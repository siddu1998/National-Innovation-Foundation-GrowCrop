package com.farm.sristi.ssis17;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

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

import static android.R.attr.data;

public class PostActivitySowing extends AppCompatActivity {


    private ImageButton mSelectImage;
    private Button mSubmitBtn;
    public Uri mImageUri = null;
    private static final int GALLERY_REQUEST = 1;
    private StorageReference mStorage;
    private DatabaseReference mDatabase;
    private ProgressDialog mProgress;
    private FirebaseAuth mAuth;
    private FirebaseUser mCurrentUser;
    private DatabaseReference mDatabaseUser;

    private EditText mPostVarietyName1;
    private EditText mPostVarietyQuantity1;
    private EditText mPostVarietyDate1;

    private EditText mPostVarietyName2;
    private EditText mPostVarietyQuantity2;
    private EditText mPostVarietyDate2;
    private RelativeLayout r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_sowing);
        mAuth = FirebaseAuth.getInstance();
        mCurrentUser = mAuth.getCurrentUser();
        mStorage = FirebaseStorage.getInstance().getReference();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Sowing_Dates");
        mDatabaseUser = FirebaseDatabase.getInstance().getReference().child("Users").child(mCurrentUser.getUid());
        mSelectImage = (ImageButton) findViewById(R.id.imageSelect);
        mSubmitBtn = (Button) findViewById(R.id.submitBtn);

        mPostVarietyName1=(EditText)findViewById(R.id.name_of_variety1);
        mPostVarietyName2=(EditText)findViewById(R.id.name_variety_2);
        mPostVarietyDate1=(EditText)findViewById(R.id.date_of_sowing_seed1);
        mPostVarietyDate2=(EditText)findViewById(R.id.date_of_sowing_seed2);
        mPostVarietyQuantity1=(EditText)findViewById(R.id.quantity_of_seed1);
        mPostVarietyQuantity2=(EditText)findViewById(R.id.quantity_of_seed2);

        r=(RelativeLayout)findViewById(R.id.secondVariety);
        Button b=(Button)findViewById(R.id.many);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r.setVisibility(View.VISIBLE);
            }
        });

        mProgress = new ProgressDialog(this);
        mSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, GALLERY_REQUEST);
            }
        });
        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPosting();
            }
        });
    }

    private void startPosting() {
        mProgress.setMessage("Posting to National Innovation Lab");
        final String name1=mPostVarietyName1.getText().toString().trim();
        final String name2=mPostVarietyName2.getText().toString().trim();

        final String quan1=mPostVarietyQuantity1.getText().toString().trim();
        final String quan2=mPostVarietyQuantity2.getText().toString().trim();

        final String date1=mPostVarietyDate1.getText().toString().trim();
        final String date2=mPostVarietyDate2.getText().toString().trim();
        if(mImageUri != null) {
            mProgress.show();
            StorageReference filepath = mStorage.child("Sowing_Images").child(mImageUri.getLastPathSegment());
            filepath.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    final Uri downloadUrl = taskSnapshot.getDownloadUrl();
                    final DatabaseReference newPost = mDatabase.push();
                    mDatabaseUser.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            newPost.child("Name of Variety 1").setValue(name1);
                            newPost.child("Date 1").setValue(date1);
                            newPost.child("Quantity of seed 1").setValue(quan1);

                            newPost.child("Name of Variety  2").setValue(name2);
                            newPost.child("Date 2").setValue(date2);
                            newPost.child("Quantity of seed 2").setValue(quan2);

                            newPost.child("image").setValue(downloadUrl.toString());
                            newPost.child("uid").setValue(mCurrentUser.getUid());
                            newPost.child("mobile").setValue(dataSnapshot.child("Mobile").getValue());
                            newPost.child("username").setValue(dataSnapshot.child("name").getValue()).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(PostActivitySowing.this, VarietyMainPage.class));
                                    }
                                }
                            });
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Toast.makeText(PostActivitySowing.this, "Looks Like You are offLine", Toast.LENGTH_SHORT).show();
                        }
                    });
                    mProgress.dismiss();
                }
            });
        }
        else
            {
                Toast.makeText(this, "Image Field is Missing", Toast.LENGTH_SHORT).show();
            }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == GALLERY_REQUEST && resultCode == RESULT_OK){
            mImageUri = data.getData();
            mSelectImage.setImageURI(mImageUri);
        }
    }
}
