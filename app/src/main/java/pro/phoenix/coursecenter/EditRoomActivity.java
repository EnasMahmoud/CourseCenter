package pro.phoenix.coursecenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class EditRoomActivity extends AppCompatActivity implements View.OnClickListener{

    String mRef;
    Button updateBtn , deleteBtn;
    EditText nameRoom , coastRoom;
    Switch availability , airCRoom , datashowRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_room);

        deleteBtn = findViewById(R.id.delBtn);
        updateBtn = findViewById(R.id.editBtn);
        deleteBtn.setOnClickListener(this);
        updateBtn.setOnClickListener(this);

        nameRoom = findViewById(R.id.roomNameET);
        coastRoom=findViewById(R.id.coastET);
        availability = findViewById(R.id.availabilitySwitchE);
        airCRoom = findViewById(R.id.airCSwitchE);
        datashowRoom= findViewById(R.id.dataShowSwitchE);

        Intent i = getIntent();
        nameRoom.setText(i.getStringExtra("name"));
        coastRoom.setText(i.getStringExtra("coast"));
        airCRoom.setChecked(Boolean.parseBoolean(i.getStringExtra("airC")));
        datashowRoom.setChecked(Boolean.parseBoolean(i.getStringExtra("datashow")));
        //Toast.makeText(this,i.getStringExtra("avilability"),Toast.LENGTH_LONG ).show();
        availability.setChecked(Boolean.parseBoolean(i.getStringExtra("avilability")));
        mRef=i.getStringExtra("ref");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.delBtn:
                RoomsListActivity.myRef.child(mRef).removeValue();
                finish();
                break;
            case R.id.editBtn:
                Room room=new Room(availability.isChecked() ,  Double.parseDouble(coastRoom.getText().toString())  ,
                    airCRoom.isChecked(), datashowRoom.isChecked() , nameRoom.getText().toString() );
                RoomsListActivity.myRef.child(mRef).setValue(room);
                finish();
                break;
        }

    }
}
