package com.ta.drivingschoolinfo;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PostDetailActivity extends AppCompatActivity {
    TextView textView11,post_detail_nama,textView13,post_notel,textView15,post_detail_alamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        ImageView img ;
        TextView txt_post_detail_nama, txt_post_notel, txt_post_detail_alamat;
        Button btn_form1;
        final Context context = this;


            //Ini Views

            img = findViewById(R.id.post_detail_img);
            txt_post_detail_nama = findViewById(R.id.post_detail_nama);
            txt_post_notel = findViewById(R.id.post_notel);
            txt_post_detail_alamat = findViewById(R.id.post_detail_alamat);


            // Pengisian Data
            String postimg = getIntent().getExtras().getString("imageView");
            Picasso.get().load(postimg).into(img);

            String postnama = getIntent().getExtras().getString("textViewNamakursus");
            txt_post_detail_nama.setText(postnama);
            String postnotel = getIntent().getExtras().getString("textViewNotel");
            txt_post_notel.setText(postnotel);
            String postalamat = getIntent().getExtras().getString("textViewAlamat");
            txt_post_detail_alamat.setText(postalamat);


        textView11=(TextView)findViewById(R.id.textView11);
        post_detail_nama=(TextView)findViewById(R.id.post_detail_nama);
        textView13=(TextView)findViewById(R.id.textView13);
        post_notel=(TextView)findViewById(R.id.post_notel);
        textView15=(TextView)findViewById(R.id.textView15);
        post_detail_alamat=(TextView)findViewById(R.id.post_detail_alamat);
        Typeface customfont=Typeface.createFromAsset(getAssets(),"fonts/volatire.ttf");
        textView11.setTypeface(customfont);
        post_detail_nama.setTypeface(customfont);
        textView13.setTypeface(customfont);
        post_notel.setTypeface(customfont);
        textView15.setTypeface(customfont);
        post_detail_alamat.setTypeface(customfont);
        post_detail_alamat.setTypeface(customfont);


        }
    }


