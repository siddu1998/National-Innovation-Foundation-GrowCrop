package com.farm.sristi.ssis17;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VarietyMainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variety_main_page);
        Button trans=(Button)findViewById(R.id.transplantation);
        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VarietyMainPage.this,PostActivity.class));
            }
        });
    Button flowering=(Button)findViewById(R.id.flowering);
        flowering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VarietyMainPage.this,PostActivityFlowering.class));
            }
        });


        Button harverst=(Button)findViewById(R.id.harvest);
        harverst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VarietyMainPage.this,PostActivityHarvesting.class));

            }
        });

 Button sow=(Button)findViewById(R.id.sowing);
        sow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VarietyMainPage.this,PostActivitySowing.class));
            }
        });
    }
}
