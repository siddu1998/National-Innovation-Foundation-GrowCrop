package com.farm.sristi.ssis17;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import static android.icu.lang.UCharacter.JoiningGroup.E;

public class MasterMainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_main_page);
        Button field=(Button)findViewById(R.id.fieldVariety);
        field.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MasterMainPage.this,VarietyMainPage.class));
            }
        });


    Button pest=(Button)findViewById(R.id.pest);
        pest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MasterMainPage.this,PostActivityPest.class));
            }
        });

        Button speak=(Button)findViewById(R.id.record);
        speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MasterMainPage.this,Main2Activity.class));
            }
        });

    ImageButton callKissanHelpLine=(ImageButton)findViewById(R.id.kissanHelpLine);
        callKissanHelpLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = "+1800-1801-551";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        });

    Button solutions=(Button)findViewById(R.id.solutions);
        solutions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MasterMainPage.this,HotelActivity.class));
            }
        });


    }

}
