package pro.phoenix.coursecenter;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;


/**
 * Created by ANNAS on 4/2/2018.
 */

public class AvilabilityFragment extends Fragment implements
        View.OnClickListener , DatePickerDialog.OnDateSetListener , TimePickerDialog.OnTimeSetListener{
    Button pickDateBtn , pickTimeBtn , checkAvilabilityBtn;
    TextView dateTv , timeTv,errorHint;
    int day , month,year,hour,min;
    Boolean pickDateFlage =false;
    Boolean pickTimeFlage = false;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_avilability, container, false);
        pickDateBtn = v.findViewById(R.id.pickDateBtn);
        pickTimeBtn = v.findViewById(R.id.pickTimeBtn);
        checkAvilabilityBtn = v.findViewById(R.id.checkReserveBtn);
        checkAvilabilityBtn.setOnClickListener(this);
        pickDateBtn.setOnClickListener(this);
        pickTimeBtn.setOnClickListener(this);
        dateTv = v.findViewById(R.id.dateTV);
        timeTv = v.findViewById(R.id.timeView);
        errorHint = v.findViewById(R.id.errorText);
        return v;
    }

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.pickDateBtn:
                Calendar cD = Calendar.getInstance();
                year = cD.get(Calendar.YEAR);
                month = cD.get(Calendar.MONTH);
                day = cD.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),AvilabilityFragment.this,year,month,day);
                datePickerDialog.show();
                break;
            case R.id.pickTimeBtn:
                Calendar cT = Calendar.getInstance();
                hour = cT.get(Calendar.HOUR);
                min = cT.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),AvilabilityFragment.this,hour,min, android.text.format.DateFormat.is24HourFormat(getContext()));
                timePickerDialog.show();
                break;
            case R.id.checkReserveBtn:
                if(pickTimeFlage==true && pickDateFlage==true)
                    errorHint.setText("");
                else
                    errorHint.setText("Choose event date and time !");
                break;
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        dateTv.setText(dayOfMonth+" / "+month+" / "+ year);
        pickDateFlage =true;
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        timeTv.setText(hourOfDay+" : "+minute);
        pickTimeFlage = true;
    }
}
