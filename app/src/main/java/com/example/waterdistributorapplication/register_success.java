package com.example.waterdistributorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageButton;

public class register_success extends AppCompatActivity {
    ImageButton home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_success);
    home=(ImageButton)findViewById(R.id.imageButton);
    Intent suc=getIntent();
    home.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent k=new Intent(register_success.this,MainActivity.class);
            startActivity(k);
        }
    });
    }

}
