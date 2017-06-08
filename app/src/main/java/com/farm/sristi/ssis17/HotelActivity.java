package com.farm.sristi.ssis17;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class HotelActivity extends AppCompatActivity {



    private RecyclerView mBlogList;
    FirebaseDatabase database;
    DatabaseReference mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        mBlogList=(RecyclerView)findViewById(R.id.blog_list_hotel);
        mBlogList.setHasFixedSize(true);
        mBlogList.setLayoutManager(new LinearLayoutManager(this));

        database=FirebaseDatabase.getInstance();
        mRef=database.getReference("Hotel");
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<ModelClassHotel,BlogViewHolder> firebaseRecyclerAdapter=
                new FirebaseRecyclerAdapter<ModelClassHotel, HotelActivity.BlogViewHolder>(ModelClassHotel.class,
                        R.layout.design_row,
                        HotelActivity.BlogViewHolder.class,
                        mRef) {

                    @Override
                    protected void populateViewHolder(HotelActivity.BlogViewHolder viewHolder, final ModelClassHotel model, int position) {

                        final String post_key=getRef(position).getKey();
                        viewHolder.setTitle(model.getTitle());
                     //   viewHolder.setImage(getApplicationContext(),model.getImage());


                        viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                //Toast.makeText(MainActivity.this, post_key, Toast.LENGTH_SHORT).show();
                                Intent detailAct=new Intent(HotelActivity.this,DetailActivityHotel.class);
                                detailAct.putExtra("idH",post_key);
                                startActivity(detailAct);


                            }
                        });
                    }
                };
        mBlogList.setAdapter(firebaseRecyclerAdapter);
    }
    public static class BlogViewHolder extends RecyclerView.ViewHolder
    {
        View mView;

        public BlogViewHolder(View itemView)
        {
            super(itemView);
            mView=itemView;

        }
        public void setTitle(String title)
        {
            TextView post_title=(TextView)mView.findViewById(R.id.titleText);
            post_title.setText(title);
        }
//        public void setImage(Context ctx, String image)
  //      {
    //        ImageView post_image=(ImageView)mView.findViewById(R.id.imageView);
        //    Picasso.with(ctx).load(image).into(post_image);
      //  }

    }

}
