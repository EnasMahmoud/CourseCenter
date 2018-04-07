package pro.phoenix.coursecenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class AddRoomActivity extends AppCompatActivity implements View.OnClickListener{

    Switch avilableSw , airCSw , datashowSw;
    Button addRoomBtn ;
    EditText nameRoom , coastRoom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room);

        avilableSw = findViewById(R.id.availabilitySwitchE);
        airCSw = findViewById(R.id.airCSwitchE);
        datashowSw = findViewById(R.id.dataShowSwitchE);

        addRoomBtn=findViewById(R.id.addBtn);
        addRoomBtn.setOnClickListener(this);

        nameRoom=findViewById(R.id.roomNameEdit);
        coastRoom = findViewById(R.id.coastEdit);

        avilableSw = findViewById(R.id.availabilitySwitch);
        airCSw = findViewById(R.id.airSwitch);
        datashowSw = findViewById(R.id.dataShowSwitch);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.addBtn:
                Room newRoom = new Room(avilableSw.isChecked() ,  Double.parseDouble(coastRoom.getText().toString())  ,
                        airCSw.isChecked(), datashowSw.isChecked() , nameRoom.getText().toString() );
                String ID = RoomsListActivity.myRef.push().getKey();
                RoomsListActivity.myRef.child(ID).setValue(newRoom);
                nameRoom.setText("");
                coastRoom.setText("");
                avilableSw.setChecked(false);
                airCSw.setChecked(false);
                datashowSw.setChecked(false);
                break;
        }

    }
}
