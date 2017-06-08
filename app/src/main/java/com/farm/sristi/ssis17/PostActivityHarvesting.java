package com.farm.sristi.ssis17;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.InstrumentationInfo;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class PostActivityHarvesting extends AppCompatActivity {

    private EditText plantHeight1;
    private EditText plantBranches1;
    private EditText plantSpikes1;
    private EditText SpikesPerGrain1;
    private EditText LengthOfSpikes1;

    private EditText plantHeight2;
    private EditText plantBranches2;
    private EditText plantSpikes2;
    private EditText SpikesPerGrain2;
    private EditText LengthOfSpikes2;

    private EditText plantHeight3;
    private EditText plantBranches3;
    private EditText plantSpikes3;
    private EditText SpikesPerGrain3;
    private EditText LengthOfSpikes3;

    private EditText plantHeight4;
    private EditText plantBranches4;
    private EditText plantSpikes4;
    private EditText SpikesPerGrain4;
    private EditText LengthOfSpikes4;

    private EditText plantHeight5;
    private EditText plantBranches5;
    private EditText plantSpikes5;
    private EditText SpikesPerGrain5;
    private EditText LengthOfSpikes5;

    private EditText plantHeight6;
    private EditText plantBranches6;
    private EditText plantSpikes6;
    private EditText SpikesPerGrain6;
    private EditText LengthOfSpikes6;

    private EditText plantHeight7;
    private EditText plantBranches7;
    private EditText plantSpikes7;
    private EditText SpikesPerGrain7;
    private EditText LengthOfSpikes7;

    private EditText plantHeight8;
    private EditText plantBranches8;
    private EditText plantSpikes8;
    private EditText SpikesPerGrain8;
    private EditText LengthOfSpikes8;

    private EditText plantHeight9;
    private EditText plantBranches9;
    private EditText plantSpikes9;
    private EditText SpikesPerGrain9;
    private EditText LengthOfSpikes9;

    private EditText plantHeight10;
    private EditText plantBranches10;
    private EditText plantSpikes10;
    private EditText SpikesPerGrain10;
    private EditText LengthOfSpikes10;

    private EditText plantHeight2_1;
    private EditText plantBranches2_1;
    private EditText plantSpikes2_1;
    private EditText SpikesPerGrain2_1;
    private EditText LengthOfSpikes2_1;

    private EditText plantHeight2_2;
    private EditText plantBranches2_2;
    private EditText plantSpikes2_2;
    private EditText SpikesPerGrain2_2;
    private EditText LengthOfSpikes2_2;

    private EditText plantHeight2_3;
    private EditText plantBranches2_3;
    private EditText plantSpikes2_3;
    private EditText SpikesPerGrain2_3;
    private EditText LengthOfSpikes2_3;

    private EditText plantHeight2_4;
    private EditText plantBranches2_4;
    private EditText plantSpikes2_4;
    private EditText SpikesPerGrain2_4;
    private EditText LengthOfSpikes2_4;

    private EditText plantHeight2_5;
    private EditText plantBranches2_5;
    private EditText plantSpikes2_5;
    private EditText SpikesPerGrain2_5;
    private EditText LengthOfSpikes2_5;

    private EditText plantHeight2_6;
    private EditText plantBranches2_6;
    private EditText plantSpikes2_6;
    private EditText SpikesPerGrain2_6;
    private EditText LengthOfSpikes2_6;

    private EditText plantHeight2_7;
    private EditText plantBranches2_7;
    private EditText plantSpikes2_7;
    private EditText SpikesPerGrain2_7;
    private EditText LengthOfSpikes2_7;

    private EditText plantHeight2_8;
    private EditText plantBranches2_8;
    private EditText plantSpikes2_8;
    private EditText SpikesPerGrain2_8;
    private EditText LengthOfSpikes2_8;

    private EditText plantHeight2_9;
    private EditText plantBranches2_9;
    private EditText plantSpikes2_9;
    private EditText SpikesPerGrain2_9;
    private EditText LengthOfSpikes2_9;

    private EditText plantHeight2_10;
    private EditText plantBranches2_10;
    private EditText plantSpikes2_10;
    private EditText SpikesPerGrain2_10;
    private EditText LengthOfSpikes2_10;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    private FirebaseUser mCurrentUser;
    private DatabaseReference mDatabaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_harvesting);

        mAuth = FirebaseAuth.getInstance();
        mCurrentUser = mAuth.getCurrentUser();
        mDatabaseUser = FirebaseDatabase.getInstance().getReference().child("Users").child(mCurrentUser.getUid());




        plantHeight1=(EditText)findViewById(R.id.plant1_height_v1);
        plantBranches1=(EditText)findViewById(R.id.noofbranches_plant1_v1);
        plantSpikes1=(EditText)findViewById(R.id.noofspikes_plant1_v1);
        LengthOfSpikes1=(EditText)findViewById(R.id.length_spikes_plant1_v1);
        SpikesPerGrain1=(EditText)findViewById(R.id.grainsperspike_plant1_v1);

        plantHeight2=(EditText)findViewById(R.id.plant2_height_v1);
        plantBranches2=(EditText)findViewById(R.id.noofbranches_plant2_v1);
        plantSpikes2=(EditText)findViewById(R.id.noofspikes_plant2_v1);
        LengthOfSpikes2=(EditText)findViewById(R.id.length_spikes_plant2_v1);
        SpikesPerGrain2=(EditText)findViewById(R.id.grainsperspike_plant2_v1);

        plantHeight3=(EditText)findViewById(R.id.plant3_height_v1);
        plantBranches3=(EditText)findViewById(R.id.noofbranches_plant3_v1);
        plantSpikes3=(EditText)findViewById(R.id.noofspikes_plant3_v1);
        LengthOfSpikes3=(EditText)findViewById(R.id.length_spikes_plant3_v1);
        SpikesPerGrain3=(EditText)findViewById(R.id.grainsperspike_plant3_v1);

        plantHeight4=(EditText)findViewById(R.id.plant4_height_v1);
        plantBranches4=(EditText)findViewById(R.id.noofbranches_plant4_v1);
        plantSpikes4=(EditText)findViewById(R.id.noofspikes_plant4_v2);
        LengthOfSpikes4=(EditText)findViewById(R.id.length_spikes_plant4_v1);
        SpikesPerGrain4=(EditText)findViewById(R.id.grainsperspike_plant4_v1);

        plantHeight5=(EditText)findViewById(R.id.plant5_height_v1);
        plantBranches5=(EditText)findViewById(R.id.noofbranches_plant5_v1);
        plantSpikes5=(EditText)findViewById(R.id.noofspikes_plant5_v1);
        LengthOfSpikes5=(EditText)findViewById(R.id.length_spikes_plant5_v1);
        SpikesPerGrain5=(EditText)findViewById(R.id.grainsperspike_plant5_v1);

        plantHeight6=(EditText)findViewById(R.id.plant6_height_v1);
        plantBranches6=(EditText)findViewById(R.id.noofbranches_plant6_v1);
        plantSpikes6=(EditText)findViewById(R.id.noofspikes_plant6_v1);
        LengthOfSpikes6=(EditText)findViewById(R.id.length_spikes_plant6_v1);
        SpikesPerGrain6=(EditText)findViewById(R.id.grainsperspike_plant6_v1);

        plantHeight7=(EditText)findViewById(R.id.plant7_height_v1);
        plantBranches7=(EditText)findViewById(R.id.noofbranches_plant7_v1);
        plantSpikes7=(EditText)findViewById(R.id.noofspikes_plant7_v1);
        LengthOfSpikes7=(EditText)findViewById(R.id.length_spikes_plant7_v1);
        SpikesPerGrain7=(EditText)findViewById(R.id.grainsperspike_plant7_v1);

        plantHeight8=(EditText)findViewById(R.id.plant8_height_v1);
        plantBranches8=(EditText)findViewById(R.id.noofbranches_plant8_v1);
        plantSpikes8=(EditText)findViewById(R.id.noofspikes_plant8_v1);
        LengthOfSpikes8=(EditText)findViewById(R.id.length_spikes_plant8_v1);
        SpikesPerGrain8=(EditText)findViewById(R.id.grainsperspike_plant8_v1);

        plantHeight9=(EditText)findViewById(R.id.plant9_height_v1);
        plantBranches9=(EditText)findViewById(R.id.noofbranches_plant9_v1);
        plantSpikes9=(EditText)findViewById(R.id.noofspikes_plant9_v1);
        LengthOfSpikes9=(EditText)findViewById(R.id.length_spikes_plant9_v1);
        SpikesPerGrain9=(EditText)findViewById(R.id.grainsperspike_plant9_v1);

        plantHeight10=(EditText)findViewById(R.id.plant10_height_v1);
        plantBranches10=(EditText)findViewById(R.id.noofbranches_plant10_v1);
        plantSpikes10=(EditText)findViewById(R.id.noofspikes_plant10_v1);
        LengthOfSpikes10=(EditText)findViewById(R.id.length_spikes_plant10_v1);
        SpikesPerGrain10=(EditText)findViewById(R.id.grainsperspike_plant10_v1);


        plantHeight2_1=(EditText)findViewById(R.id.plant1_height_v2);
        plantBranches2_1=(EditText)findViewById(R.id.noofbranches_plant1_v2);
        plantSpikes2_1=(EditText)findViewById(R.id.noofspikes_plant1_v2);
        LengthOfSpikes2_1=(EditText)findViewById(R.id.length_spikes_plant1_v2);
        SpikesPerGrain2_1=(EditText)findViewById(R.id.grainsperspike_plant1_v2);

        plantHeight2_2=(EditText)findViewById(R.id.plant2_height_v2);
        plantBranches2_2=(EditText)findViewById(R.id.noofbranches_plant2_v2);
        plantSpikes2_2=(EditText)findViewById(R.id.noofspikes_plant2_v2);
        LengthOfSpikes2_2=(EditText)findViewById(R.id.length_spikes_plant2_v2);
        SpikesPerGrain2_2=(EditText)findViewById(R.id.grainsperspike_plant2_v2);

        plantHeight2_3=(EditText)findViewById(R.id.plant3_height_v2);
        plantBranches2_3=(EditText)findViewById(R.id.noofbranches_plant3_v2);
        plantSpikes2_3=(EditText)findViewById(R.id.noofspikes3_plant3_v2);
        LengthOfSpikes2_3=(EditText)findViewById(R.id.length_spikes_plant3_v2);
        SpikesPerGrain2_3=(EditText)findViewById(R.id.grainsperspike_plant3_v2);

        plantHeight2_4=(EditText)findViewById(R.id.plant4_height_v2);
        plantBranches2_4=(EditText)findViewById(R.id.noofbranches_plant4_v2);
        plantSpikes2_4=(EditText)findViewById(R.id.noofspikes_plant4_v2);
        LengthOfSpikes2_4=(EditText)findViewById(R.id.length_spikes_plant4_v2);
        SpikesPerGrain2_4=(EditText)findViewById(R.id.grainsperspike_plamt4_v2);

        plantHeight2_5=(EditText)findViewById(R.id.plant5_height_v2);
        plantBranches2_5=(EditText)findViewById(R.id.noofbranches_plant5_v2);
        plantSpikes2_5=(EditText)findViewById(R.id.noofspikes_plant5_v2);
        LengthOfSpikes2_5=(EditText)findViewById(R.id.length_spikes_plant5_v2);
        SpikesPerGrain2_5=(EditText)findViewById(R.id.grainsperspike_plant5_v2);

        plantHeight2_6=(EditText)findViewById(R.id.plant6_height_v2);
        plantBranches2_6=(EditText)findViewById(R.id.noofbranches_plant6_v2);
        plantSpikes2_6=(EditText)findViewById(R.id.noofspikes_plant6_v2);
        LengthOfSpikes2_6=(EditText)findViewById(R.id.length_spikes_plant6_v2);
        SpikesPerGrain2_6=(EditText)findViewById(R.id.grainsperspike_plant6_v2);

        plantHeight2_7=(EditText)findViewById(R.id.plant7_height_v2);
        plantBranches2_7=(EditText)findViewById(R.id.noofbranches_plant7_v2);
        plantSpikes2_7=(EditText)findViewById(R.id.noofspikes_plant7_v2);
        LengthOfSpikes2_7=(EditText)findViewById(R.id.length_spikes_plant7_v2);
        SpikesPerGrain2_7=(EditText)findViewById(R.id.grainsperspike_plant7_v2);

        plantHeight2_8=(EditText)findViewById(R.id.plant8_height_v2);
        plantBranches2_8=(EditText)findViewById(R.id.noofbranches_plant8_v2);
        plantSpikes2_8=(EditText)findViewById(R.id.noofspikes_plant8_v2);
        LengthOfSpikes2_8=(EditText)findViewById(R.id.length_spikes_plant8_v2);
        SpikesPerGrain2_8=(EditText)findViewById(R.id.grainsperspike_plant8_v2);

        plantHeight2_9=(EditText)findViewById(R.id.plant9_height_v2);
        plantBranches2_9=(EditText)findViewById(R.id.noofbranches_plant9_v2);
        plantSpikes2_9=(EditText)findViewById(R.id.noofspikes_plant9_v2);
        LengthOfSpikes2_9=(EditText)findViewById(R.id.length_spikes_plant9_v2);
        SpikesPerGrain2_9=(EditText)findViewById(R.id.grainsperspike_plant9_v2);

        plantHeight2_10=(EditText)findViewById(R.id.plant10_height_v2);
        plantBranches2_10=(EditText)findViewById(R.id.noofbranches_plant10_v2);
        plantSpikes2_10=(EditText)findViewById(R.id.noofspikes_plant10_v2);
        LengthOfSpikes2_10=(EditText)findViewById(R.id.length_spikes_plant10_v2);
        SpikesPerGrain2_10=(EditText)findViewById(R.id.grainsperspike_plant10_v2);


        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReferenceFromUrl("https://ssis17-28adb.firebaseio.com/Harvest_detai");
        Button v1tov2 = (Button)findViewById(R.id.variety2_button);
        Button done_v1 = (Button)findViewById(R.id.done_v1);
        Button done_v2 = (Button)findViewById(R.id.done_v2);
        Button v2tov1 = (Button)findViewById(R.id.variety1_button_v2);
        //variety2buttons
        Button plant1_v2 = (Button)findViewById(R.id.plant1_button_v2);
        Button plant2_v2 = (Button)findViewById(R.id.plant2_button_v2);
        Button plant3_v2 = (Button)findViewById(R.id.plant3_button_v2);
        Button plant4_v2 = (Button)findViewById(R.id.plant4_button_v2);
        Button plant5_v2 = (Button)findViewById(R.id.plant5_button_v2);
        Button plant6_v2 = (Button)findViewById(R.id.plant6_button_v2);
        Button plant7_v2 = (Button)findViewById(R.id.plant7_button_v2);
        Button plant8_v2 = (Button)findViewById(R.id.plant8_button_v2);
        Button plant9_v2 = (Button)findViewById(R.id.plant9_button_v2);
        Button plant10_v2 = (Button)findViewById(R.id.plant10_button_v2);
        //variety1buttons
        Button plant1_v1 = (Button)findViewById(R.id.plant1_button);
        Button plant2_v1 = (Button)findViewById(R.id.plant2_button);
        Button plant3_v1 = (Button)findViewById(R.id.plant3_button);
        Button plant4_v1 = (Button)findViewById(R.id.plant4_button);
        Button plant5_v1 = (Button)findViewById(R.id.plant5_button);
        Button plant6_v1 = (Button)findViewById(R.id.plant6_button);
        Button plant7_v1 = (Button)findViewById(R.id.plant7_button);
        Button plant8_v1 = (Button)findViewById(R.id.plant8_button);
        Button plant9_v1 = (Button)findViewById(R.id.plant9_button);
        Button plant10_v1 = (Button)findViewById(R.id.plant10_button);
        //RelativeLayoutsVariety1
        final RelativeLayout plant1_v1_r = (RelativeLayout) findViewById(R.id.RelLay_plant1);
        final RelativeLayout plant2_v1_r = (RelativeLayout) findViewById(R.id.RelLay_plant2);
        final RelativeLayout plant3_v1_r = (RelativeLayout) findViewById(R.id.RelLay_plant3);
        final RelativeLayout plant4_v1_r = (RelativeLayout) findViewById(R.id.RelLay_plant4);
        final RelativeLayout plant5_v1_r = (RelativeLayout) findViewById(R.id.RelLay_plant5);
        final RelativeLayout plant6_v1_r = (RelativeLayout) findViewById(R.id.RelLay_plant6);
        final RelativeLayout plant7_v1_r = (RelativeLayout) findViewById(R.id.RelLay_plant7);
        final RelativeLayout plant8_v1_r = (RelativeLayout) findViewById(R.id.RelLay_plant8);
        final RelativeLayout plant9_v1_r = (RelativeLayout) findViewById(R.id.RelLay_plant9);
        final RelativeLayout plant10_v1_r = (RelativeLayout) findViewById(R.id.RelLay_plant10);
        //RelativeLayoutsVariety2
        final RelativeLayout plant1_v2_r = (RelativeLayout) findViewById(R.id.RelLay_plant1_v2);
        final RelativeLayout plant2_v2_r = (RelativeLayout) findViewById(R.id.RelLay_plant2_v2);
        final RelativeLayout plant3_v2_r = (RelativeLayout) findViewById(R.id.RelLay_plant3_v2);
        final RelativeLayout plant4_v2_r = (RelativeLayout) findViewById(R.id.RelLay_plant4_v2);
        final RelativeLayout plant5_v2_r = (RelativeLayout) findViewById(R.id.RelLay_plant5_v2);
        final RelativeLayout plant6_v2_r = (RelativeLayout) findViewById(R.id.RelLay_plant6_v2);
        final RelativeLayout plant7_v2_r = (RelativeLayout) findViewById(R.id.RelLay_plant7_v2);
        final RelativeLayout plant8_v2_r = (RelativeLayout) findViewById(R.id.RelLay_plant8_v2);
        final RelativeLayout plant9_v2_r = (RelativeLayout) findViewById(R.id.RelLay_plant9_v2);
        final RelativeLayout plant10_v2_r = (RelativeLayout) findViewById(R.id.RelLay_plant10_v2);
        final RelativeLayout RelVar2 = (RelativeLayout)findViewById(R.id.RelLay2);
        final RelativeLayout RelVar1 = (RelativeLayout)findViewById(R.id.RelLay1);
        v1tov2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelVar2.setVisibility(View.VISIBLE);
                RelVar1.setVisibility(View.GONE
                );
            }
        });
        v2tov1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                RelVar2.setVisibility(View.GONE);
                RelVar1.setVisibility(View.VISIBLE);
            }
        });
        //variety1 plant buttons
        plant1_v1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                plant1_v1_r.setVisibility(View.VISIBLE);
                plant2_v1_r.setVisibility(View.GONE);
                plant3_v1_r.setVisibility(View.GONE);
                plant4_v1_r.setVisibility(View.GONE);
                plant5_v1_r.setVisibility(View.GONE);
                plant6_v1_r.setVisibility(View.GONE);
                plant7_v1_r.setVisibility(View.GONE);
                plant8_v1_r.setVisibility(View.GONE);
                plant9_v1_r.setVisibility(View.GONE);
                plant10_v1_r.setVisibility(View.GONE);
            }
        });
        plant2_v1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                plant2_v1_r.setVisibility(View.VISIBLE);
                plant1_v1_r.setVisibility(View.GONE);
                plant3_v1_r.setVisibility(View.GONE);
                plant4_v1_r.setVisibility(View.GONE);
                plant5_v1_r.setVisibility(View.GONE);
                plant6_v1_r.setVisibility(View.GONE);
                plant7_v1_r.setVisibility(View.GONE);
                plant8_v1_r.setVisibility(View.GONE);
                plant9_v1_r.setVisibility(View.GONE);
                plant10_v1_r.setVisibility(View.GONE);
            }
        });
        plant3_v1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                plant3_v1_r.setVisibility(View.VISIBLE);
                plant2_v1_r.setVisibility(View.GONE);
                plant1_v1_r.setVisibility(View.GONE);
                plant4_v1_r.setVisibility(View.GONE);
                plant5_v1_r.setVisibility(View.GONE);
                plant6_v1_r.setVisibility(View.GONE);
                plant7_v1_r.setVisibility(View.GONE);
                plant8_v1_r.setVisibility(View.GONE);
                plant9_v1_r.setVisibility(View.GONE);
                plant10_v1_r.setVisibility(View.GONE);
            }
        });
        plant4_v1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                plant4_v1_r.setVisibility(View.VISIBLE);
                plant2_v1_r.setVisibility(View.GONE);
                plant3_v1_r.setVisibility(View.GONE);
                plant1_v1_r.setVisibility(View.GONE);
                plant5_v1_r.setVisibility(View.GONE);
                plant6_v1_r.setVisibility(View.GONE);
                plant7_v1_r.setVisibility(View.GONE);
                plant8_v1_r.setVisibility(View.GONE);
                plant9_v1_r.setVisibility(View.GONE);
                plant10_v1_r.setVisibility(View.GONE);
            }
        });
        plant5_v1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                plant5_v1_r.setVisibility(View.VISIBLE);
                plant2_v1_r.setVisibility(View.GONE);
                plant3_v1_r.setVisibility(View.GONE);
                plant4_v1_r.setVisibility(View.GONE);
                plant1_v1_r.setVisibility(View.GONE);
                plant6_v1_r.setVisibility(View.GONE);
                plant7_v1_r.setVisibility(View.GONE);
                plant8_v1_r.setVisibility(View.GONE);
                plant9_v1_r.setVisibility(View.GONE);
                plant10_v1_r.setVisibility(View.GONE);
            }
        });
        plant6_v1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                plant6_v1_r.setVisibility(View.VISIBLE);
                plant2_v1_r.setVisibility(View.GONE);
                plant3_v1_r.setVisibility(View.GONE);
                plant4_v1_r.setVisibility(View.GONE);
                plant5_v1_r.setVisibility(View.GONE);
                plant1_v1_r.setVisibility(View.GONE);
                plant7_v1_r.setVisibility(View.GONE);
                plant8_v1_r.setVisibility(View.GONE);
                plant9_v1_r.setVisibility(View.GONE);
                plant10_v1_r.setVisibility(View.GONE);
            }
        });
        plant7_v1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                plant7_v1_r.setVisibility(View.VISIBLE);
                plant2_v1_r.setVisibility(View.GONE);
                plant3_v1_r.setVisibility(View.GONE);
                plant4_v1_r.setVisibility(View.GONE);
                plant5_v1_r.setVisibility(View.GONE);
                plant6_v1_r.setVisibility(View.GONE);
                plant1_v1_r.setVisibility(View.GONE);
                plant8_v1_r.setVisibility(View.GONE);
                plant9_v1_r.setVisibility(View.GONE);
                plant10_v1_r.setVisibility(View.GONE);
            }
        });
        plant8_v1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                plant8_v1_r.setVisibility(View.VISIBLE);
                plant2_v1_r.setVisibility(View.GONE);
                plant3_v1_r.setVisibility(View.GONE);
                plant4_v1_r.setVisibility(View.GONE);
                plant5_v1_r.setVisibility(View.GONE);
                plant6_v1_r.setVisibility(View.GONE);
                plant7_v1_r.setVisibility(View.GONE);
                plant1_v1_r.setVisibility(View.GONE);
                plant9_v1_r.setVisibility(View.GONE);
                plant10_v1_r.setVisibility(View.GONE);
            }
        });
        plant9_v1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                plant9_v1_r.setVisibility(View.VISIBLE);
                plant2_v1_r.setVisibility(View.GONE);
                plant3_v1_r.setVisibility(View.GONE);
                plant4_v1_r.setVisibility(View.GONE);
                plant5_v1_r.setVisibility(View.GONE);
                plant6_v1_r.setVisibility(View.GONE);
                plant7_v1_r.setVisibility(View.GONE);
                plant8_v1_r.setVisibility(View.GONE);
                plant1_v1_r.setVisibility(View.GONE);
                plant10_v1_r.setVisibility(View.GONE);
            }
        });
        plant10_v1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                plant10_v1_r.setVisibility(View.VISIBLE);
                plant2_v1_r.setVisibility(View.GONE);
                plant3_v1_r.setVisibility(View.GONE);
                plant4_v1_r.setVisibility(View.GONE);
                plant5_v1_r.setVisibility(View.GONE);
                plant6_v1_r.setVisibility(View.GONE);
                plant7_v1_r.setVisibility(View.GONE);
                plant8_v1_r.setVisibility(View.GONE);
                plant9_v1_r.setVisibility(View.GONE);
                plant1_v1_r.setVisibility(View.GONE);
            }
        });
        //Variety2plants
        plant1_v2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                plant1_v2_r.setVisibility(View.VISIBLE);
                plant2_v2_r.setVisibility(View.GONE);
                plant3_v2_r.setVisibility(View.GONE);
                plant4_v2_r.setVisibility(View.GONE);
                plant5_v2_r.setVisibility(View.GONE);
                plant6_v2_r.setVisibility(View.GONE);
                plant7_v2_r.setVisibility(View.GONE);
                plant8_v2_r.setVisibility(View.GONE);
                plant9_v2_r.setVisibility(View.GONE);
                plant10_v2_r.setVisibility(View.GONE);
            }
        });

        plant2_v2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                plant2_v2_r.setVisibility(View.VISIBLE);
                plant1_v2_r.setVisibility(View.GONE);
                plant3_v2_r.setVisibility(View.GONE);
                plant4_v2_r.setVisibility(View.GONE);
                plant5_v2_r.setVisibility(View.GONE);
                plant6_v2_r.setVisibility(View.GONE);
                plant7_v2_r.setVisibility(View.GONE);
                plant8_v2_r.setVisibility(View.GONE);
                plant9_v2_r.setVisibility(View.GONE);
                plant10_v2_r.setVisibility(View.GONE);

            }
        });
        plant3_v2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                plant3_v2_r.setVisibility(View.VISIBLE);
                plant2_v2_r.setVisibility(View.GONE);
                plant1_v2_r.setVisibility(View.GONE);
                plant4_v2_r.setVisibility(View.GONE);
                plant5_v2_r.setVisibility(View.GONE);
                plant6_v2_r.setVisibility(View.GONE);
                plant7_v2_r.setVisibility(View.GONE);
                plant8_v2_r.setVisibility(View.GONE);
                plant9_v2_r.setVisibility(View.GONE);
                plant10_v2_r.setVisibility(View.GONE);
            }
        });
        plant4_v2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                plant4_v2_r.setVisibility(View.VISIBLE);
                plant2_v2_r.setVisibility(View.GONE);
                plant3_v2_r.setVisibility(View.GONE);
                plant1_v2_r.setVisibility(View.GONE);
                plant5_v2_r.setVisibility(View.GONE);
                plant6_v2_r.setVisibility(View.GONE);
                plant7_v2_r.setVisibility(View.GONE);
                plant8_v2_r.setVisibility(View.GONE);
                plant9_v2_r.setVisibility(View.GONE);
                plant10_v2_r.setVisibility(View.GONE);
            }
        });
        plant5_v2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                plant5_v2_r.setVisibility(View.VISIBLE);
                plant2_v2_r.setVisibility(View.GONE);
                plant3_v2_r.setVisibility(View.GONE);
                plant4_v2_r.setVisibility(View.GONE);
                plant1_v2_r.setVisibility(View.GONE);
                plant6_v2_r.setVisibility(View.GONE);
                plant7_v2_r.setVisibility(View.GONE);
                plant8_v2_r.setVisibility(View.GONE);
                plant9_v2_r.setVisibility(View.GONE);
                plant10_v2_r.setVisibility(View.GONE);



            }
        });


        plant6_v2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                plant6_v2_r.setVisibility(View.VISIBLE);
                plant2_v2_r.setVisibility(View.GONE);
                plant3_v2_r.setVisibility(View.GONE);
                plant4_v2_r.setVisibility(View.GONE);
                plant5_v2_r.setVisibility(View.GONE);
                plant1_v2_r.setVisibility(View.GONE);
                plant7_v2_r.setVisibility(View.GONE);
                plant8_v2_r.setVisibility(View.GONE);
                plant9_v2_r.setVisibility(View.GONE);
                plant10_v2_r.setVisibility(View.GONE);



            }
        });

        plant7_v2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                plant7_v2_r.setVisibility(View.VISIBLE);
                plant2_v2_r.setVisibility(View.GONE);
                plant3_v2_r.setVisibility(View.GONE);
                plant4_v2_r.setVisibility(View.GONE);
                plant5_v2_r.setVisibility(View.GONE);
                plant6_v2_r.setVisibility(View.GONE);
                plant1_v2_r.setVisibility(View.GONE);
                plant8_v2_r.setVisibility(View.GONE);
                plant9_v2_r.setVisibility(View.GONE);
                plant10_v2_r.setVisibility(View.GONE);

            }
        });

        plant8_v2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                plant8_v2_r.setVisibility(View.VISIBLE);
                plant2_v2_r.setVisibility(View.GONE);
                plant3_v2_r.setVisibility(View.GONE);
                plant4_v2_r.setVisibility(View.GONE);
                plant5_v2_r.setVisibility(View.GONE);
                plant6_v2_r.setVisibility(View.GONE);
                plant7_v2_r.setVisibility(View.GONE);
                plant1_v2_r.setVisibility(View.GONE);
                plant9_v2_r.setVisibility(View.GONE);
                plant10_v2_r.setVisibility(View.GONE);
            }
        });
        plant9_v2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                plant9_v2_r.setVisibility(View.VISIBLE);
                plant2_v2_r.setVisibility(View.GONE);
                plant3_v2_r.setVisibility(View.GONE);
                plant4_v2_r.setVisibility(View.GONE);
                plant5_v2_r.setVisibility(View.GONE);
                plant6_v2_r.setVisibility(View.GONE);
                plant7_v2_r.setVisibility(View.GONE);
                plant8_v2_r.setVisibility(View.GONE);
                plant1_v2_r.setVisibility(View.GONE);
                plant10_v2_r.setVisibility(View.GONE);
            }
        });
        plant10_v2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                plant10_v2_r.setVisibility(View.VISIBLE);
                plant2_v2_r.setVisibility(View.GONE);
                plant3_v2_r.setVisibility(View.GONE);
                plant4_v2_r.setVisibility(View.GONE);
                plant5_v2_r.setVisibility(View.GONE);
                plant6_v2_r.setVisibility(View.GONE);
                plant7_v2_r.setVisibility(View.GONE);
                plant8_v2_r.setVisibility(View.GONE);
                plant9_v2_r.setVisibility(View.GONE);
                plant1_v2_r.setVisibility(View.GONE);
            }
        });

    done_v1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final DatabaseReference newPost = databaseReference.push();

           mDatabaseUser.addValueEventListener(new ValueEventListener() {
               @Override
               public void onDataChange(DataSnapshot dataSnapshot) {
                   newPost.child("PlantHeight 1").setValue(plantHeight1.getText().toString().trim());
                   newPost.child("Plant Branches 1").setValue(plantBranches1.getText().toString().trim());
                   newPost.child("Plant 1 number of Spike").setValue(plantSpikes1.getText().toString().trim());
                   newPost.child("Plant 1 Length of Spike").setValue(LengthOfSpikes1.getText().toString().trim());
                   newPost.child("Plant 1 Grains per Spike").setValue(SpikesPerGrain1.getText().toString().trim());
                   newPost.child("PlantHeight 2").setValue(plantHeight2.getText().toString().trim());
                   newPost.child("Plant Branches 2").setValue(plantBranches2.getText().toString().trim());
                   newPost.child("Plant 2 number of Spike").setValue(plantSpikes2.getText().toString().trim());
                   newPost.child("Plant 2 Length of Spike").setValue(LengthOfSpikes2.getText().toString().trim());
                   newPost.child("Plant 2 Grains per Spike").setValue(SpikesPerGrain2.getText().toString().trim());
                   newPost.child("PlantHeight 3").setValue(plantHeight3.getText().toString().trim());
                   newPost.child("Plant Branches 3").setValue(plantBranches3.getText().toString().trim());
                   newPost.child("Plant 3 number of Spike").setValue(plantSpikes3.getText().toString().trim());
                   newPost.child("Plant 3 Length of Spike").setValue(LengthOfSpikes3.getText().toString().trim());
                   newPost.child("Plant 3 Grains per Spike").setValue(SpikesPerGrain3.getText().toString().trim());
                   newPost.child("PlantHeight 4").setValue(plantHeight4.getText().toString().trim());
                   newPost.child("Plant Branches 4").setValue(plantBranches4.getText().toString().trim());
                   newPost.child("Plant 4 number of Spike").setValue(plantSpikes4.getText().toString().trim());
                   newPost.child("Plant 4 Length of Spike").setValue(LengthOfSpikes4.getText().toString().trim());
                   newPost.child("Plant 4 Grains per Spike").setValue(SpikesPerGrain4.getText().toString().trim());
                   newPost.child("PlantHeight 5").setValue(plantHeight5.getText().toString().trim());
                   newPost.child("Plant Branches 5").setValue(plantBranches5.getText().toString().trim());
                   newPost.child("Plant 5 number of Spike").setValue(plantSpikes5.getText().toString().trim());
                   newPost.child("Plant 5 Length of Spike").setValue(LengthOfSpikes5.getText().toString().trim());
                   newPost.child("Plant 5 Grains per Spike").setValue(SpikesPerGrain5.getText().toString().trim());
                   newPost.child("PlantHeight 6").setValue(plantHeight6.getText().toString().trim());
                   newPost.child("Plant Branches 6").setValue(plantBranches6.getText().toString().trim());
                   newPost.child("Plant 6 number of Spike").setValue(plantSpikes6.getText().toString().trim());
                   newPost.child("Plant 6 Length of Spike").setValue(LengthOfSpikes6.getText().toString().trim());
                   newPost.child("Plant 6 Grains per Spike").setValue(SpikesPerGrain6.getText().toString().trim());
                   newPost.child("PlantHeight 7").setValue(plantHeight7.getText().toString().trim());
                   newPost.child("Plant Branches 7").setValue(plantBranches7.getText().toString().trim());
                   newPost.child("Plant 7 number of Spike").setValue(plantSpikes7.getText().toString().trim());
                   newPost.child("Plant 7 Length of Spike").setValue(LengthOfSpikes7.getText().toString().trim());
                   newPost.child("Plant 7 Grains per Spike").setValue(SpikesPerGrain7.getText().toString().trim());
                   newPost.child("PlantHeight 8").setValue(plantHeight8.getText().toString().trim());
                   newPost.child("Plant Branches 8").setValue(plantBranches8.getText().toString().trim());
                   newPost.child("Plant 8 number of Spike").setValue(plantSpikes8.getText().toString().trim());
                   newPost.child("Plant 8 Length of Spike").setValue(LengthOfSpikes8.getText().toString().trim());
                   newPost.child("Plant 8 Grains per Spike").setValue(SpikesPerGrain8.getText().toString().trim());
                   newPost.child("PlantHeight 9").setValue(plantHeight9.getText().toString().trim());
                   newPost.child("Plant Branches 9").setValue(plantBranches9.getText().toString().trim());
                   newPost.child("Plant 9 number of Spike").setValue(plantSpikes9.getText().toString().trim());
                   newPost.child("Plant 9 Length of Spike").setValue(LengthOfSpikes9.getText().toString().trim());
                   newPost.child("Plant 9 Grains per Spike").setValue(SpikesPerGrain9.getText().toString().trim());
                   newPost.child("PlantHeight 10").setValue(plantHeight10.getText().toString().trim());
                   newPost.child("Plant Branches 10").setValue(plantBranches10.getText().toString().trim());
                   newPost.child("Plant 10 number of Spike").setValue(plantSpikes10.getText().toString().trim());
                   newPost.child("Plant 10 Length of Spike").setValue(LengthOfSpikes10.getText().toString().trim());
                   newPost.child("Plant 10 Grains per Spike").setValue(SpikesPerGrain10.getText().toString().trim());
                   newPost.child("uid").setValue(mCurrentUser.getUid());
                   newPost.child("username").setValue(dataSnapshot.child("name").getValue()).addOnCompleteListener(new OnCompleteListener<Void>() {
                       @Override
                       public void onComplete(@NonNull Task<Void> task) {

                           if(task.isSuccessful()) {
                               startActivity(new Intent(PostActivityHarvesting.this, VarietyMainPage.class));
                           }
                       }
                   });
               }

               @Override
               public void onCancelled(DatabaseError databaseError) {

               }
           });

        }
    });

        done_v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatabaseReference newPost1=databaseReference.push();
                mDatabaseUser.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {


                        newPost1.child("Plant 2 Height 1").setValue(plantHeight2_1.getText().toString().trim());
                        newPost1.child("Plant 2 Branches 1").setValue(plantBranches2_1.getText().toString().trim());
                        newPost1.child("Plant 2 number of Spike 1").setValue(plantSpikes2_1.getText().toString().trim());
                        newPost1.child("Plant 2 Length of Spike 1").setValue(LengthOfSpikes2_1.getText().toString().trim());
                        newPost1.child("Plant 2 Grains per Spike 1").setValue(SpikesPerGrain2_1.getText().toString().trim());
                        newPost1.child("PlantHeight 2 ").setValue(plantHeight2_2.getText().toString().trim());
                        newPost1.child("Plant Branches 2").setValue(plantBranches2_2.getText().toString().trim());
                        newPost1.child("Plant 2 number of Spike").setValue(plantSpikes2_2.getText().toString().trim());
                        newPost1.child("Plant 2 Length of Spike").setValue(LengthOfSpikes2_2.getText().toString().trim());
                        newPost1.child("Plant 2 Grains per Spike").setValue(SpikesPerGrain2_2.getText().toString().trim());
                        newPost1.child("PlantHeight 3").setValue(plantHeight2_3.getText().toString().trim());
                        newPost1.child("Plant Branches 3").setValue(plantBranches2_3.getText().toString().trim());
                        newPost1.child("Plant 3 number of Spike").setValue(plantSpikes2_3.getText().toString().trim());
                        newPost1.child("Plant 3 Length of Spike").setValue(LengthOfSpikes2_3.getText().toString().trim());
                        newPost1.child("Plant 3 Grains per Spike").setValue(SpikesPerGrain2_3.getText().toString().trim());
                        newPost1.child("PlantHeight 4").setValue(plantHeight2_4.getText().toString().trim());
                        newPost1.child("Plant Branches 4").setValue(plantBranches2_4.getText().toString().trim());
                        newPost1.child("Plant 4 number of Spike").setValue(plantSpikes2_4.getText().toString().trim());
                        newPost1.child("Plant 4 Length of Spike").setValue(LengthOfSpikes2_4.getText().toString().trim());
                        newPost1.child("Plant 4 Grains per Spike").setValue(SpikesPerGrain2_4.getText().toString().trim());
                        newPost1.child("PlantHeight 5").setValue(plantHeight2_5.getText().toString().trim());
                        newPost1.child("Plant Branches 5").setValue(plantBranches2_5.getText().toString().trim());
                        newPost1.child("Plant 5 number of Spike").setValue(plantSpikes2_5.getText().toString().trim());
                        newPost1.child("Plant 5 Length of Spike").setValue(LengthOfSpikes2_5.getText().toString().trim());
                        newPost1.child("Plant 5 Grains per Spike").setValue(SpikesPerGrain2_5.getText().toString().trim());
                        newPost1.child("PlantHeight 6").setValue(plantHeight2_6.getText().toString().trim());
                        newPost1.child("Plant Branches 6").setValue(plantBranches2_6.getText().toString().trim());
                        newPost1.child("Plant 6 number of Spike").setValue(plantSpikes2_6.getText().toString().trim());
                        newPost1.child("Plant 6 Length of Spike").setValue(LengthOfSpikes2_6.getText().toString().trim());
                        newPost1.child("Plant 6 Grains per Spike").setValue(SpikesPerGrain2_6.getText().toString().trim());
                        newPost1.child("PlantHeight 7").setValue(plantHeight2_7.getText().toString().trim());
                        newPost1.child("Plant Branches 7").setValue(plantBranches2_7.getText().toString().trim());
                        newPost1.child("Plant 7 number of Spike").setValue(plantSpikes2_7.getText().toString().trim());
                        newPost1.child("Plant 7 Length of Spike").setValue(LengthOfSpikes2_7.getText().toString().trim());
                        newPost1.child("Plant 7 Grains per Spike").setValue(SpikesPerGrain2_7.getText().toString().trim());
                        newPost1.child("PlantHeight 8").setValue(plantHeight2_8.getText().toString().trim());
                        newPost1.child("Plant Branches 8").setValue(plantBranches2_8.getText().toString().trim());
                        newPost1.child("Plant 8 number of Spike").setValue(plantSpikes2_8.getText().toString().trim());
                        newPost1.child("Plant 8 Length of Spike").setValue(LengthOfSpikes2_8.getText().toString().trim());
                        newPost1.child("Plant 8 Grains per Spike").setValue(SpikesPerGrain2_8.getText().toString().trim());
                        newPost1.child("PlantHeight 9").setValue(plantHeight2_9.getText().toString().trim());
                        newPost1.child("Plant Branches 9").setValue(plantBranches2_9.getText().toString().trim());
                        newPost1.child("Plant 9 number of Spike").setValue(plantSpikes2_9.getText().toString().trim());
                        newPost1.child("Plant 9 Length of Spike").setValue(LengthOfSpikes2_9.getText().toString().trim());
                        newPost1.child("Plant 9 Grains per Spike").setValue(SpikesPerGrain2_9.getText().toString().trim());
                        newPost1.child("PlantHeight 10").setValue(plantHeight2_10.getText().toString().trim());
                        newPost1.child("Plant Branches 10").setValue(plantBranches2_10.getText().toString().trim());
                        newPost1.child("Plant 10 number of Spike").setValue(plantSpikes2_10.getText().toString().trim());
                        newPost1.child("Plant 10 Length of Spike").setValue(LengthOfSpikes2_10.getText().toString().trim());
                        newPost1.child("Plant 10 Grains per Spike").setValue(SpikesPerGrain2_10.getText().toString().trim());
                        newPost1.child("uid").setValue(mCurrentUser.getUid());
                        newPost1.child("username").setValue(dataSnapshot.child("name").getValue()).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                if(task.isSuccessful()) {
                                    startActivity(new Intent(PostActivityHarvesting.this, VarietyMainPage.class));
                                }
                            }
                        });
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

    }
}
