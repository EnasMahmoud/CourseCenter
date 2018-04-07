package pro.phoenix.coursecenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditCustomerActivity extends AppCompatActivity implements View.OnClickListener {

    Button updateCustomerBtn , delCustomerBtn;
    EditText customerNameET , customerPhoneET;
    String mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_customer);
        Intent i = getIntent();
        updateCustomerBtn = findViewById(R.id.updteCustomerBtn);
        delCustomerBtn = findViewById(R.id.delCustomerBtn);
        updateCustomerBtn.setOnClickListener(this);
        delCustomerBtn.setOnClickListener(this);
        customerNameET = findViewById(R.id.customerNameEditT);
        customerPhoneET = findViewById(R.id.customerPhoneEditT);
        customerPhoneET.setText(i.getStringExtra("customerName"));
        customerNameET.setText(i.getStringExtra("customerPhone"));
        mRef = i.getStringExtra("ref");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.updteCustomerBtn:
                Customer newCustomer = new Customer(customerNameET.getText().toString(),customerPhoneET.getText().toString());
                CustomersListActivity.myRef.child(mRef).setValue(newCustomer);
                finish();
                break;
            case R.id.delCustomerBtn:
                CustomersListActivity.myRef.child(mRef).removeValue();
                finish();
                break;
        }

    }
}
