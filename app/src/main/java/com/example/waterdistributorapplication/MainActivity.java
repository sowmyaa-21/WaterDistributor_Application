package com.example.waterdistributorapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button user,dealer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent k=getIntent();

        getSupportActionBar().hide();
        user=(Button)findViewById(R.id.user_button);
        dealer=(Button)findViewById(R.id.dealerreg_button);
        dealer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent idealer=new Intent(MainActivity.this,dealer_registeration.class);
                startActivity(idealer);

            }
        });
        user.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Information To the User");
                builder.setMessage("You can search your water dealers by your location");
                builder.setCancelable(true);

                final AlertDialog dlg = builder.create();

                dlg.show();

                final Timer t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        dlg.dismiss(); // when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                },500000); // after 2 second (or 2000 miliseconds), the task will be active.
                Intent newuser= new Intent(MainActivity.this,SearchActivity.class);
                startActivity(newuser);
            }
        });

    }

}
