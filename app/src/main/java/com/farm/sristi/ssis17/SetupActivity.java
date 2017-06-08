package com.farm.sristi.ssis17;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import static android.R.attr.data;
public class SetupActivity extends AppCompatActivity {


    private EditText mNameField;
   private EditText mMobileField;
    private Button mSubmitBtn;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseUsers;
    private StorageReference mStorageImage;

    private ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);


        mAuth = FirebaseAuth.getInstance();


        mDatabaseUsers = FirebaseDatabase.getInstance().getReference().child("Users");

        mProgress = new ProgressDialog(this);
        mMobileField=(EditText)findViewById(R.id.setupMobileField);
        mNameField = (EditText) findViewById(R.id.setupNameField);
        mSubmitBtn = (Button) findViewById(R.id.setupSubmitBtn);

        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startSetupAccount();

            }
        });



    }

    private void startSetupAccount() {
        final String name = mNameField.getText().toString().trim();
        final String mobile=mMobileField.getText().toString().trim();

        final String user_id = mAuth.getCurrentUser().getUid();
        if(!TextUtils.isEmpty(name) ){
            mProgress.setMessage("Thank You");
            mProgress.show();


                    mDatabaseUsers.child(user_id).child("name").setValue(name);
                   mDatabaseUsers.child(user_id).child("Mobile").setValue(mobile);
                    mProgress.dismiss();
                    startActivity(new Intent(SetupActivity.this,MainActivity.class));
                }
            }

        }




