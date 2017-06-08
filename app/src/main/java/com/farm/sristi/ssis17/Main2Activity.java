package com.farm.sristi.ssis17;

import android.app.ProgressDialog;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    private Button mRecordButton;
    private TextView mRecordLabel;
    private MediaRecorder mRecorder;
    private String mFileName=null;
    private StorageReference mStorage;
    private ProgressDialog mProgress;
    private EditText mPostName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        mStorage= FirebaseStorage.getInstance().getReference();
        mRecordButton=(Button)findViewById(R.id.recordbtn);
        mRecordLabel=(TextView)findViewById(R.id.recordlabel);
        mProgress=new ProgressDialog(this);
        mPostName=(EditText)findViewById(R.id.name);
        mFileName= Environment.getExternalStorageDirectory().getAbsolutePath();
        mFileName+="/recorded_audio.3gp";

    mRecordButton.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            if(motionEvent.getAction()==MotionEvent.ACTION_DOWN)
            {
                startRecording();
                mRecordLabel.setText("Recording Started...");
            }
            else if(motionEvent.getAction()==MotionEvent.ACTION_UP)
            {
                stopRecording();
                mRecordLabel.setText("Reccording Sent to National Innovation Lab...");
            }
            return  false;
        }
    });

    }
    private void startRecording() {
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setOutputFile(mFileName);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mRecorder.prepare();
        } catch (IOException e) {
           //Log.e(LOG_TAG, "prepare() failed");
        }

        mRecorder.start();
    }

    private void stopRecording() {
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
        uploadAudio();
    }

    private void uploadAudio() {
        mProgress.setMessage("Sending Recording to National Innvovation Lab");
        mProgress.show();
         String recodring=mPostName.getText().toString().trim();
        StorageReference filepath=mStorage.child("Audio").child(recodring+".3gp");
        Uri uri=Uri.fromFile(new File(mFileName));
        filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
            mProgress.dismiss();
                mRecordLabel.setText("Thank You Our Team will get back to You really soon");
            }
        });
    }
}
