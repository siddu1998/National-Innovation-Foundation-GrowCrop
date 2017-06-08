package com.farm.sristi.ssis17;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import static android.R.attr.inset;
import static android.os.Build.VERSION_CODES.M;


public class PostActivityFlowering extends AppCompatActivity {
    public ImageButton  mSelectImage;
    private EditText mPostTitle;
    private EditText mPostDesc;
   private EditText mPostOther;
    private EditText mPostPerentage;
    private EditText mPostPercentage2;

    private TextView offset2TextView;

    private Button mSubmitBtn;

    private RadioGroup InsectPresenceRadioGroup;
    private RadioButton insectPresenceRadioButton;

    private RadioGroup InsectIntenstityRadioGroup;//intensity radio group
    private RadioButton instectIntenstiyRadioButton;//intenstiy scale radio button

    private  RadioGroup InsectPresenceRadioGroup2;
    private RadioButton InsectPresenceRadioButton2;

    private RadioGroup InsectIntensityRadioGroup2;
    private RadioButton InsectIntenstiyRadioButton2;

    private RadioGroup DiseasePresenceRadioGroup;
    private RadioButton DiseasePresenceRadioButton;


    private RadioGroup DiseasePresenceRadioGroup2;
    private RadioButton DiseasePresenceRadioButton2;

    private RadioGroup DiseaseIntensityRadioGroup;
    private RadioButton DiseaseIntensityRadioButton;

    private RadioGroup DiseaseIntensityRadioGroup2;
    private RadioButton DiseaseIntensityRadioButton2;

    private RadioGroup ofSet2RadioGroup;
    private  RadioButton ofSet2Button;

    private RadioGroup ofSet1RadioGroup;
    private RadioButton ofSet1Button;

    private RadioGroup DroughtRadioGroup;
    private RadioButton DroughtRadioButton;

    private RadioGroup WeedRadioGroup;
    private RadioButton WeedRadioButton;

    private RadioGroup NutrientRadioGroup;
    private RadioButton NutrientRadioButton;


    private RadioGroup LodgingRadioGroup;
    private RadioButton LodgingRadioButton;



    private TextView percentageFlowering2;
    private TextView insectPresence2;
    private TextView insectIntensity2;
    private TextView DiseasePresence2;
    private TextView DiseaseIntensity2;

    private Uri mImageUri = null;
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
        setContentView(R.layout.activity_post_flowering);

        insectPresence2=(TextView)findViewById(R.id.insectText2);
        insectIntensity2=(TextView)findViewById(R.id.textView18);

        offset2TextView=(TextView)findViewById(R.id.textView20);
        percentageFlowering2=(TextView)findViewById(R.id.percentageFloweringText);
        DiseasePresence2=(TextView)findViewById(R.id.textView19);
        DiseaseIntensity2=(TextView)findViewById(R.id.textView23);

        mAuth = FirebaseAuth.getInstance();
        mCurrentUser = mAuth.getCurrentUser();
        mStorage = FirebaseStorage.getInstance().getReference();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Flowering_stage");
        mDatabaseUser = FirebaseDatabase.getInstance().getReference().child("Users").child(mCurrentUser.getUid());
        mSelectImage = (ImageButton) findViewById(R.id.imageSelect);

        mPostTitle = (EditText) findViewById(R.id.titleField);
        mPostDesc = (EditText) findViewById(R.id.descField);
        mPostOther=(EditText)findViewById(R.id.otherField);
        mPostPerentage=(EditText)findViewById(R.id.percentgeField);
        mPostPercentage2=(EditText)findViewById(R.id.percentageFloweringEdit2);

        ofSet2RadioGroup=(RadioGroup)findViewById(R.id.ofSet2); //offset2 declaration and id assigning
        ofSet1RadioGroup=(RadioGroup)findViewById(R.id.ofSet1);

        InsectPresenceRadioGroup2=(RadioGroup)findViewById(R.id.insectOccurence2radioGroup);
        DiseasePresenceRadioGroup2=(RadioGroup)findViewById(R.id.diesaseOccurenceRadioGroup2);


        InsectIntensityRadioGroup2=(RadioGroup)findViewById(R.id.intensityOfInsect2Radio);
        DiseaseIntensityRadioGroup2=(RadioGroup)findViewById(R.id.intensityOfDisease2RadioGroup);


        Button b=(Button)findViewById(R.id.more);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                percentageFlowering2.setVisibility(View.VISIBLE);
                offset2TextView.setVisibility(View.VISIBLE);
                insectPresence2.setVisibility(View.VISIBLE);
                insectIntensity2.setVisibility(View.VISIBLE);
                DiseaseIntensity2.setVisibility(View.VISIBLE);
                ofSet2RadioGroup.setVisibility(View.VISIBLE);
                InsectPresenceRadioGroup2.setVisibility(View.VISIBLE);
                DiseasePresence2.setVisibility(View.VISIBLE);
                mPostPercentage2.setVisibility(View.VISIBLE);
                DiseasePresenceRadioGroup2.setVisibility(View.VISIBLE);
                InsectIntensityRadioGroup2.setVisibility(View.VISIBLE);
                DiseaseIntensityRadioGroup2.setVisibility(View.VISIBLE);
            }
        });

        mSubmitBtn = (Button) findViewById(R.id.submitBtn);

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
        mProgress.setMessage("Sending Details to National Innvoation Foundation");
        final String title_val = mPostTitle.getText().toString().trim();
        final String desc_val = mPostDesc.getText().toString().trim();
        final String other_val=mPostOther.getText().toString().trim();
        final String percentage_val=mPostPerentage.getText().toString().trim();
        final String percentage_val2=mPostPercentage2.getText().toString().trim();

        InsectPresenceRadioGroup=(RadioGroup)findViewById(R.id.insectPresenceRadioGroup);
        int selectedId = InsectPresenceRadioGroup.getCheckedRadioButtonId();
        insectPresenceRadioButton=(RadioButton)findViewById(selectedId);
        final String insectPresnece_val=insectPresenceRadioButton.getText().toString().trim();

        InsectIntenstityRadioGroup=(RadioGroup)findViewById(R.id.insectIntensityRadioGroup);
        int selectedIdInsectIntensity=InsectIntenstityRadioGroup.getCheckedRadioButtonId();
        instectIntenstiyRadioButton=(RadioButton)findViewById(selectedIdInsectIntensity);
        final String insectIntensity_val=instectIntenstiyRadioButton.getText().toString().trim();


        int selectedIdOfset1=ofSet1RadioGroup.getCheckedRadioButtonId();
        ofSet1Button=(RadioButton)findViewById(selectedIdOfset1);
        final String ofSet1_val=ofSet1Button.getText().toString().trim();

        int selectedIdOfSet2=ofSet2RadioGroup.getCheckedRadioButtonId();
        ofSet2Button=(RadioButton)findViewById(selectedIdOfSet2);
        final String ofSet2_val=ofSet2Button.getText().toString().trim();

        int selectedIdOfInsectIntensity2=InsectIntensityRadioGroup2.getCheckedRadioButtonId();
        InsectIntenstiyRadioButton2=(RadioButton)findViewById(selectedIdOfInsectIntensity2);
        final String insectIntensity2_val=InsectIntenstiyRadioButton2.getText().toString().trim();




        DiseasePresenceRadioGroup=(RadioGroup)findViewById(R.id.DiseasePreseneceRadioGroup);
        int selectedIdDiseasePresence=DiseasePresenceRadioGroup.getCheckedRadioButtonId();
        DiseasePresenceRadioButton=(RadioButton)findViewById(selectedIdDiseasePresence);
        final String diseasePresence_val=DiseasePresenceRadioButton.getText().toString().trim();

        DiseaseIntensityRadioGroup=(RadioGroup)findViewById(R.id.IntensityOfDiseaseRadioGroup);
        int selectedIdDiseaseIntensity=DiseaseIntensityRadioGroup.getCheckedRadioButtonId();
        DiseaseIntensityRadioButton=(RadioButton)findViewById(selectedIdDiseaseIntensity);
        final String diseaseIntensity_val=DiseaseIntensityRadioButton.getText().toString().trim();


        DroughtRadioGroup=(RadioGroup)findViewById(R.id.DroughtRadioGroup);
        int selectedIdDrought=DroughtRadioGroup.getCheckedRadioButtonId();
        DroughtRadioButton=(RadioButton)findViewById(selectedIdDrought);
        final String drought_val=DroughtRadioButton.getText().toString().trim();

        WeedRadioGroup=(RadioGroup)findViewById(R.id.WeedRadioGroup);
        int selecetedIdWeed=WeedRadioGroup.getCheckedRadioButtonId();
        WeedRadioButton=(RadioButton)findViewById(selecetedIdWeed);
        final String weed_val=WeedRadioButton.getText().toString().trim();


        NutrientRadioGroup=(RadioGroup)findViewById(R.id.NutrientsRadioGroup);
        int selectedIdNutrinent=NutrientRadioGroup.getCheckedRadioButtonId();
        NutrientRadioButton=(RadioButton)findViewById(selectedIdNutrinent);
        final String nutrient_val=NutrientRadioButton.getText().toString().trim();


        LodgingRadioGroup=(RadioGroup)findViewById(R.id.LodgingRadioGroup);
        int selectedIdLodging=LodgingRadioGroup.getCheckedRadioButtonId();
        LodgingRadioButton=(RadioButton)findViewById(selectedIdLodging);
        final String lodging_val=LodgingRadioButton.getText().toString().trim();

        if(mImageUri != null) {
            mProgress.show();
            StorageReference filepath = mStorage.child("Flowering_Images").child(mImageUri.getLastPathSegment());
            filepath.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    final Uri downloadUrl = taskSnapshot.getDownloadUrl();
                    final DatabaseReference newPost = mDatabase.push();
                    mDatabaseUser.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            newPost.child("title").setValue(title_val);
                            newPost.child("desc").setValue(desc_val);
                            newPost.child("other_comments").setValue(other_val);

                            newPost.child("Percentage Flowering").setValue(percentage_val);
                            newPost.child("Percentage Flowering 2").setValue(percentage_val2);

                            newPost.child("Insect_Presnece").setValue(insectPresnece_val);
                            newPost.child("Insect_Intensity").setValue(insectIntensity_val);

                            newPost.child("Disease_Presenece").setValue(diseasePresence_val);
                            newPost.child("Disease_intensty").setValue(diseaseIntensity_val);

                            newPost.child("Drought_condition").setValue(drought_val);
                            newPost.child("Weed_condition").setValue(weed_val);
                            newPost.child("Nutrinent_condition").setValue(nutrient_val);
                            newPost.child("Lodging_condition").setValue(lodging_val);

                            newPost.child("Of Set 1").setValue(ofSet1_val);
                            newPost.child("Of Set 2").setValue(ofSet2_val);

                            newPost.child("Insect Intensity 2").setValue(insectIntensity2_val);

                            newPost.child("image").setValue(downloadUrl.toString());
                            newPost.child("uid").setValue(mCurrentUser.getUid());
                            newPost.child("mobile").setValue(dataSnapshot.child("Mobile").getValue());
                            newPost.child("username").setValue(dataSnapshot.child("name").getValue()).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(PostActivityFlowering.this, VarietyMainPage.class));
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
                Toast.makeText(this, "Image Field Is empty", Toast.LENGTH_SHORT).show();
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
