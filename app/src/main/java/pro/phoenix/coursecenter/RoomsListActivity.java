package pro.phoenix.coursecenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RoomsListActivity extends AppCompatActivity implements View.OnClickListener {

    ListView roomsList;
    Button addRoomBtn;

    public static FirebaseDatabase database ;
    public static DatabaseReference myRef;
    FirebaseListAdapter<Room> mListAdapter;

    Intent roomDetails;
    double coastRoom;
    boolean airCo , dataShow , available;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms_list);

        roomsList = findViewById(R.id.roomList);

        addRoomBtn = findViewById(R.id.addRoomBtn);

        addRoomBtn.setOnClickListener(this);

        database = FirebaseDatabase.getInstance();
        database.setPersistenceEnabled(true);
        myRef=database.getReference("Rooms");
        myRef.keepSynced(true);

        mListAdapter= new FirebaseListAdapter<Room>(this,Room.class,R.layout.item_room,myRef) {

            @Override
            protected void populateView(View v, Room model, int position) {
                TextView roomName=v.findViewById(R.id.roomNameTV);
                TextView roomAvailability = v.findViewById(R.id.roomAvilabilityTextView);
                TextView coastTextV = v.findViewById(R.id.coastTV);
                TextView airCoTextV = v.findViewById(R.id.airCValueTV);
                TextView datashowTextV = v.findViewById(R.id.datashowValueTV);
                TextView airTitle = v.findViewById(R.id.airConTitleView);
                TextView datashowTitle = v.findViewById(R.id.datashowTitleView);

                roomName.setText(model.getRoomName());
                airTitle.setText("AirC");
                datashowTitle.setText("Projecor");

                available = model.getAvailability();

                airCo = model.getAirc();

                dataShow = model.getDataShow();
                coastRoom = model.getCoast();
                coastTextV.setText(String.valueOf(coastRoom));

                if(available == true)
                    roomAvailability.setText("Avilable") ;
                else
                    roomAvailability.setText("Not Avilable") ;

                if(airCo == true)
                    airCoTextV.setText("Avilable");
                else
                    airCoTextV.setText("Not Avilable");

                if (dataShow == true)
                    datashowTextV.setText("Avilable");
                else
                    datashowTextV.setText("Not Avilable");
            }
        };

        roomsList.setAdapter(mListAdapter);

        roomDetails = new Intent(RoomsListActivity.this, EditRoomActivity.class);

        roomsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DatabaseReference itemRef = mListAdapter.getRef(position);
                TextView roomName=view.findViewById(R.id.roomNameTV);
                //TextView roomAvilability = view.findViewById(R.id.roomAvilabilityTextView);

                roomDetails.putExtra("ref", itemRef.getKey());
                roomDetails.putExtra("name",roomName.getText().toString());

                roomDetails.putExtra("avilability",String.valueOf(available));

                roomDetails.putExtra("coast", String.valueOf(coastRoom));
                roomDetails.putExtra("airC",String.valueOf(airCo));
                roomDetails.putExtra("datashow",String.valueOf(dataShow));

                startActivity(roomDetails);
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.addRoomBtn:
                Intent iAdd = new Intent(RoomsListActivity.this , AddRoomActivity.class);
                startActivity(iAdd);
                break;

        }
    }
}
