package com.farm.sristi.ssis17;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class DetailActivityHotel extends AppCompatActivity {




    private String mPost_key=null;

    DatabaseReference myRef;

   // private ImageView detailImage;
    private TextView deatilTitle;
    private TextView detailprice;
    private TextView detailphone;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hotel);



        myRef= FirebaseDatabase.getInstance().getReference().child("Hotel");
        mPost_key=getIntent().getExtras().getString("idH");



     //   detailImage=(ImageView)findViewById(R.id.ivdetailH);
        deatilTitle=(TextView)findViewById(R.id.tvNameDetailH);
        detailprice=(TextView)findViewById(R.id.tvDesDetailH);
        detailphone=(TextView)findViewById(R.id.tvphoneDetailH);
        //Toast.makeText(DetailActitvity.this, mPost_key, Toast.LENGTH_SHORT).show();


        myRef.child(mPost_key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String title=(String)dataSnapshot.child("title").getValue();
                String price=(String)dataSnapshot.child("price").getValue();
       //         String image=(String)dataSnapshot.child("image").getValue();
                String phone=(String)dataSnapshot.child("phone").getValue();

                deatilTitle.setText(title);
                detailprice.setText(price);
                detailphone.setText(phone);
         //       Picasso.with(DetailActivityHotel.this).load(image).into(detailImage);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
