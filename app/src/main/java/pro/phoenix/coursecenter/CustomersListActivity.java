package pro.phoenix.coursecenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CustomersListActivity extends AppCompatActivity implements View.OnClickListener{

    ListView customersList;
    Button addCustomerBtn;

    public static FirebaseDatabase database ;
    public static DatabaseReference myRef;
    FirebaseListAdapter<Customer> mListAdapter;

    Intent customerInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers_list);
        customersList=findViewById(R.id.customerList);
        addCustomerBtn = findViewById(R.id.addCustomerBtn);
        addCustomerBtn.setOnClickListener(this);

        database = FirebaseDatabase.getInstance();
        database.setPersistenceEnabled(true);
        myRef=database.getReference("Customers");
        myRef.keepSynced(true);

        mListAdapter = new FirebaseListAdapter<Customer>(this,Customer.class,R.layout.item_customer,myRef) {
            @Override
            protected void populateView(View v, Customer model, int position) {
                TextView customerName = v.findViewById(R.id.customerNameTVItem);
                TextView customerPhone = v.findViewById(R.id.customerPhoneTVItem);

                customerName.setText(model.getCustomerName());
                customerPhone.setText(model.getCustomerPhone());
            }
        };
        customersList.setAdapter(mListAdapter);
        customerInfo = new Intent(CustomersListActivity.this,EditCustomerActivity.class);
        customersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DatabaseReference itemRef = mListAdapter.getRef(position);
                TextView customerName=view.findViewById(R.id.customerNameTVItem);
                TextView customerPhone = view.findViewById(R.id.customerPhoneTVItem);

                customerInfo.putExtra("customerName",customerName.getText().toString());
                customerInfo.putExtra("customerPhone",customerPhone.getText().toString());
                customerInfo.putExtra("ref",itemRef.getKey());
                startActivity(customerInfo);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.addCustomerBtn:
                Intent iAdd = new Intent(CustomersListActivity.this , AddCustomerActivity.class);
                startActivity(iAdd);
                break;
        }



    }
}
