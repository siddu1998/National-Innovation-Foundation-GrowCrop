package com.farm.sristi.ssis17;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.os.Build.VERSION_CODES.N;


public class PostActivityPest extends AppCompatActivity {
    private RelativeLayout r1;
    private RelativeLayout r2;
    public ImageButton  mSelectImage1;
    private ImageButton mSelectImage2;

    private Button mSubmitBtn1;
    private Button mSubmitBtn2;

    public Uri mImageUri1 = null;
    public Uri mImageUri2=null;

    private EditText mPostCropName1;//done
    private EditText mPostVarietyName1;//done

    private EditText mPostCropName2;
    private EditText mPostVarietyName2;


    private RadioGroup ProblemTypeRadioGroup1;//Done
    private RadioButton ProblemTypeRadioButton1;//Done

    private RadioGroup ProblemTypeRadioGroup2;
    private RadioButton ProblemTypeRadioButton2;

    private EditText mPostNameofPestLocal1;//Done
    private  EditText mPostNameofPestEnglish1;//done

    private EditText mPostNameofPestLocal2;
    private  EditText mPostNameofPestEnglish2;


    private RadioGroup extentOfDamageRadioGroup1;//Done
    private RadioButton extendOfDamageRadioButton1;//Done

    private RadioGroup extentOfDamageRadioGroup2;
    private RadioButton extendOfDamageRadioButton2;


    private EditText mPostNameOfMaterial1;//done
    private EditText mPostSourceOfMaterial1;//done
    private EditText mStageOfMaterial1;//done
    private EditText mPostMethodOfPreparation1;//done
    private EditText mPostMethodOfApplication1;//done
    private EditText mPostDosage1;//done
    private EditText mPostPrecautions1;//done

    private EditText mPostNameOfMaterial2;
    private EditText mPostSourceOfMaterial2;
    private EditText mStageOfMaterial2;
    private EditText mPostMethodOfPreparation2;
    private EditText mPostMethodOfApplication2;
    private EditText mPostDosage2;
    private EditText mPostPrecautions2;


    private static final int GALLERY_REQUEST = 1;
    private StorageReference mStorage;
    private DatabaseReference mDatabase;
    private ProgressDialog mProgress;
    private FirebaseAuth mAuth;
    private FirebaseUser mCurrentUser;
    private DatabaseReference mDatabaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_pest);

        r1=(RelativeLayout)findViewById(R.id.RelativeLay1);
        r2=(RelativeLayout)findViewById(R.id.RelativeLay2);

        Button b=(Button)findViewById(R.id.Addproblem_r1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r1.setVisibility(View.GONE);
                r2.setVisibility(View.VISIBLE);
            }
        });

        mAuth = FirebaseAuth.getInstance();
        mCurrentUser = mAuth.getCurrentUser();
        mStorage = FirebaseStorage.getInstance().getReference();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Pest_Problem_By_Farmer");
        mDatabaseUser = FirebaseDatabase.getInstance().getReference().child("Users").child(mCurrentUser.getUid());
        mSelectImage1 = (ImageButton) findViewById(R.id.imageSelect1);
        mSelectImage2=(ImageButton)findViewById(R.id.imageSelect2);


        mPostCropName1=(EditText)findViewById(R.id.Cropnameedit_r1);
        mPostVarietyName1=(EditText)findViewById(R.id.Varietynameedit_r1);
        mPostNameofPestLocal1=(EditText)findViewById(R.id.Local_r1);
        mPostNameofPestEnglish1=(EditText)findViewById(R.id.English_r1);
        mPostNameOfMaterial1=(EditText)findViewById(R.id.nameofmaterial_edit_r1);
        mPostSourceOfMaterial1=(EditText)findViewById(R.id.sourceofmaterial_edit_r1);
        mStageOfMaterial1=(EditText)findViewById(R.id.stageofplant_edit_r1);
        mPostMethodOfPreparation1=(EditText)findViewById(R.id.methodofprep_edit_r1);
        mPostMethodOfApplication1=(EditText)findViewById(R.id.methodofapp_edit_r1);
        mPostDosage1=(EditText)findViewById(R.id.dosage_edit_r1);
        mPostPrecautions1=(EditText)findViewById(R.id.precautions_edit_r1);


        mPostCropName2=(EditText)findViewById(R.id.Cropnameedit_r1);
        mPostVarietyName2=(EditText)findViewById(R.id.Varietynameedit_r1);
        mPostNameofPestLocal2=(EditText)findViewById(R.id.Local_r2);
        mPostNameofPestEnglish2=(EditText)findViewById(R.id.English_r2);
        mPostNameOfMaterial2=(EditText)findViewById(R.id.nameofmaterial_r2);
        mPostSourceOfMaterial2=(EditText)findViewById(R.id.sourceofmaterial_r2);
        mStageOfMaterial2=(EditText)findViewById(R.id.stageoftheplant_r2);
        mPostMethodOfPreparation2=(EditText)findViewById(R.id.methodofprep_r2);
        mPostMethodOfApplication2=(EditText)findViewById(R.id.methodofapp_r2);
        mPostDosage2=(EditText)findViewById(R.id.dosage_r2);
        mPostPrecautions2=(EditText)findViewById(R.id.precautions_r2);




        mSubmitBtn1 = (Button) findViewById(R.id.submitBtn1);
        mSubmitBtn2=(Button)findViewById(R.id.submitBtn2);

        mProgress = new ProgressDialog(this);

        mSelectImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, GALLERY_REQUEST);
            }
        });
        mSelectImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent2 = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent2.setType("image/*");
                startActivityForResult(galleryIntent2, GALLERY_REQUEST);
            }      });

        mSubmitBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPosting1();
            }
        });

        mSubmitBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPosting2();
            }
        });
    }
    private void startPosting1() {
        mProgress.setMessage("Posting to National Innovation Lab");

        final String cropName_val1 = mPostCropName1.getText().toString().trim();
        final String VarietyName_val1 = mPostVarietyName1.getText().toString().trim();
        final String localName_val1 = mPostNameofPestLocal1.getText().toString().trim();
        final String englishName_val1 = mPostNameofPestEnglish1.getText().toString().trim();
        final String nameOfmaterial_val1 = mPostNameOfMaterial1.getText().toString().trim();
        final String source_val1 = mPostSourceOfMaterial1.getText().toString().trim();
        final String stage_val1 = mStageOfMaterial1.getText().toString().trim();
        final String method_val1 = mPostMethodOfPreparation1.getText().toString().trim();
        final String application_val1 = mPostMethodOfApplication1.getText().toString().trim();
        final String dosage_val1 = mPostDosage1.getText().toString().trim();
        final String precaution_val2 = mPostPrecautions1.getText().toString().trim();

        ProblemTypeRadioGroup1 = (RadioGroup) findViewById(R.id.radioGroupID_r1);
        int selectedId = ProblemTypeRadioGroup1.getCheckedRadioButtonId();
        ProblemTypeRadioButton1 = (RadioButton) findViewById(selectedId);
        final String problemPresence_val1 = ProblemTypeRadioButton1.getText().toString().trim();

        extentOfDamageRadioGroup1 = (RadioGroup) findViewById(R.id.radioGroup_extent_r1);
        int selectedIdExtent = extentOfDamageRadioGroup1.getCheckedRadioButtonId();
        extendOfDamageRadioButton1 = (RadioButton) findViewById(selectedIdExtent);
        final String problemExtent_val1 = extendOfDamageRadioButton1.getText().toString().trim();

        if (mImageUri1 != null) {
            mProgress.show();
            StorageReference filepath = mStorage.child("Pest_control_images").child(mImageUri1.getLastPathSegment());
            filepath.putFile(mImageUri1).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    final Uri downloadUrl1 = taskSnapshot.getDownloadUrl();
                    final DatabaseReference newPost = mDatabase.push();
                    mDatabaseUser.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            newPost.child("Crop Name 1").setValue(cropName_val1);
                            newPost.child("Variety Name 1").setValue(VarietyName_val1);
                            newPost.child("Local Name 1").setValue(localName_val1);
                            newPost.child("English Name 1").setValue(englishName_val1);
                            newPost.child("name of material").setValue(nameOfmaterial_val1);
                            newPost.child("Source Name 1").setValue(source_val1);
                            newPost.child("Stage of application 1").setValue(stage_val1);
                            newPost.child("Method 1").setValue(method_val1);
                            newPost.child("application 1").setValue(application_val1);
                            newPost.child("dosage of 1").setValue(dosage_val1);
                            newPost.child("Precautions 1").setValue(precaution_val2);
                            newPost.child("Problem Present 1").setValue(problemPresence_val1);
                            newPost.child("Extent of problem Present 1").setValue(problemExtent_val1);
                            newPost.child("image").setValue(downloadUrl1.toString());
                            newPost.child("uid").setValue(mCurrentUser.getUid());
                            newPost.child("mobile").setValue(dataSnapshot.child("Mobile").getValue());
                            newPost.child("username").setValue(dataSnapshot.child("name").getValue()).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()) {
                                        Toast.makeText(PostActivityPest.this, "Thank You Your Problem has been Registred", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                        }
                    });
                    mProgress.dismiss();
                }
            });
        }
        else
            {
                Toast.makeText(this, "Image Field Is missing", Toast.LENGTH_SHORT).show();
            }
    }

    private void startPosting2() {
        mProgress.setMessage("Posting to National Innovation Lab");
        if(mImageUri2!= null) {
            mProgress.show();
            final String cropName_val2 = mPostCropName2.getText().toString().trim();
            final String VarietyName_val2 = mPostVarietyName2.getText().toString().trim();
            final String localName_val2 = mPostNameofPestLocal2.getText().toString().trim();
            final String englishName_val2 = mPostNameofPestEnglish2.getText().toString().trim();
            final String nameOfmaterial_val2 = mPostNameOfMaterial2.getText().toString().trim();
            final String source_val2 = mPostSourceOfMaterial2.getText().toString().trim();
            final String stage_val2 = mStageOfMaterial2.getText().toString().trim();
            final String method_val2 = mPostMethodOfPreparation2.getText().toString().trim();
            final String application_val2 = mPostMethodOfApplication2.getText().toString().trim();
            final String dosage_val2 = mPostDosage2.getText().toString().trim();
            final String precaution_val1 = mPostPrecautions2.getText().toString().trim();


            ProblemTypeRadioGroup2 = (RadioGroup) findViewById(R.id.radioGroupID_r2);
            int selectedId2 = ProblemTypeRadioGroup2.getCheckedRadioButtonId();
            ProblemTypeRadioButton2 = (RadioButton) findViewById(selectedId2);
            final String problemPresence_val2 = ProblemTypeRadioButton2.getText().toString().trim();

            extentOfDamageRadioGroup2 = (RadioGroup) findViewById(R.id.extentradioG_r2);
            int selectedIdExtent2 = extentOfDamageRadioGroup2.getCheckedRadioButtonId();
            extendOfDamageRadioButton2 = (RadioButton) findViewById(selectedIdExtent2);
            final String problemExtent_val2 = extendOfDamageRadioButton2.getText().toString().trim();

            StorageReference filepath = mStorage.child("Pest_control_images").child(mImageUri2.getLastPathSegment());
            filepath.putFile(mImageUri2).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    final Uri downloadUrl2 = taskSnapshot.getDownloadUrl();
                    final DatabaseReference newPost = mDatabase.push();
                    mDatabaseUser.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            newPost.child("Crop Name 2").setValue(cropName_val2);
                            newPost.child("Variety Name 2").setValue(VarietyName_val2);
                            newPost.child("Local Name 2").setValue(localName_val2);
                            newPost.child("English Name 2").setValue(englishName_val2);
                            newPost.child("name of material 2").setValue(nameOfmaterial_val2);
                            newPost.child("Source Name 2").setValue(source_val2);
                            newPost.child("Stage of application 2").setValue(stage_val2);
                            newPost.child("Method 2").setValue(method_val2);
                            newPost.child("application 2").setValue(application_val2);
                            newPost.child("dosage of 2").setValue(dosage_val2);
                            newPost.child("Precautions 2").setValue(precaution_val1);
                            newPost.child("Problem Present 2").setValue(problemPresence_val2);
                            newPost.child("Extent of problem Present 2").setValue(problemExtent_val2);

                            newPost.child("image").setValue(downloadUrl2.toString());
                            newPost.child("uid").setValue(mCurrentUser.getUid());
                            newPost.child("mobile").setValue(dataSnapshot.child("Mobile").getValue());
                            newPost.child("username").setValue(dataSnapshot.child("name").getValue()).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(PostActivityPest.this, MasterMainPage.class));
                                    }
                                }
                            });
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                        }
                    });
                    mProgress.dismiss();
                }
            });
        }
        else
        {
            Toast.makeText(this, "Image Field is empty", Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == GALLERY_REQUEST && resultCode == RESULT_OK){
            mImageUri1 = data.getData();
            mImageUri2=data.getData();
            mSelectImage1.setImageURI(mImageUri1);
            mSelectImage2.setImageURI(mImageUri2);
        }
    }

}
