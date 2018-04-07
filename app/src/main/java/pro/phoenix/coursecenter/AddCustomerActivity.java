package pro.phoenix.coursecenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddCustomerActivity extends AppCompatActivity {

    EditText customerName , customerPhone;
    Button addNewCustomer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        customerName = findViewById(R.id.customerNameAddET);
        customerPhone = findViewById(R.id.customerPhoneAddET);
        addNewCustomer = findViewById(R.id.addNewCustomerBtn);
        addNewCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Customer newCustomer = new Customer(customerName.getText().toString(), customerPhone.getText().toString());
                String ID = CustomersListActivity.myRef.push().getKey();
                CustomersListActivity.myRef.child(ID).setValue(newCustomer);
                customerName.setText("");
                customerPhone.setText("");
            }
        });
    }
}
