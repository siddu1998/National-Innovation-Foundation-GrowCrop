package com.farm.sristi.ssis17;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    private String mPost_key=null;
    DatabaseReference myRef;

    private ImageView detailImage;
    private TextView deatilTitle;
    private TextView detailDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        myRef= FirebaseDatabase.getInstance().getReference().child("Blog");
        mPost_key=getIntent().getExtras().getString("idclub");

        detailImage=(ImageView)findViewById(R.id.ivdetailClub);
        deatilTitle=(TextView)findViewById(R.id.tvNameDetailClub);
        detailDesc=(TextView)findViewById(R.id.tvDesDetailClub);
        //Toast.makeText(DetailActitvity.this, mPost_key, Toast.LENGTH_SHORT).show();


        myRef.child(mPost_key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String title=(String)dataSnapshot.child("title").getValue();
                String desc=(String)dataSnapshot.child("desc").getValue();
                String image=(String)dataSnapshot.child("image").getValue();

                deatilTitle.setText(title);
                detailDesc.setText(desc);

                Picasso.with(DetailActivity.this).load(image).into(detailImage);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
