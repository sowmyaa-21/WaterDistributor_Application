package com.example.waterdistributorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class dealer_registeration extends AppCompatActivity {
    EditText dname,dcompanyname,dlocation,dmobno;
    Button register_button;
    DatabaseReference databasedregisteration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer_registeration);

        Intent i=getIntent();
        databasedregisteration= FirebaseDatabase.getInstance().getReference("dealerregistration");
        dname=(EditText)findViewById(R.id.edit_text_name);
        dcompanyname=(EditText)findViewById(R.id.edit_text_cname);
        dlocation=(EditText)findViewById(R.id.edit_text_location);
        dmobno=(EditText)findViewById(R.id.edit_text_mobno);
        register_button=(Button)findViewById(R.id.submitbutton);
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    addealers();
            }
        });

    }
    public void addealers(){
        String MobilePattern = "[0-9]{10}";
        String name=dname.getText().toString().trim();
        String cname=dcompanyname.getText().toString().trim();
        String location=dlocation.getText().toString().trim();
        String mobno=dmobno.getText().toString().trim();
        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(cname) && !TextUtils.isEmpty(location)&& (!TextUtils.isEmpty(mobno) && mobno.matches(MobilePattern)) )  {
            String did = databasedregisteration.push().getKey();
            DealerDetails dealerDetails = new DealerDetails(name, cname, location, mobno);
            databasedregisteration.child(did).setValue(dealerDetails);
            Toast.makeText(this,"Registered",Toast.LENGTH_LONG).show();
            Intent suc=new Intent(dealer_registeration.this,register_success.class);
            startActivity(suc);
        }
        else{
            Toast.makeText(this,"Please fill all the details",Toast.LENGTH_LONG).show();
        }
    }
}
