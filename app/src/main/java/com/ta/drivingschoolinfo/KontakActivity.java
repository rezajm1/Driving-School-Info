package com.ta.drivingschoolinfo;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class KontakActivity extends AppCompatActivity {
    TextView TextView8,TextView9,TextView10,TextView12,TextView14,TextView16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontak);
        TextView8=(TextView)findViewById(R.id.textView8);
        TextView9=(TextView)findViewById(R.id.textView9);
        TextView10=(TextView)findViewById(R.id.textView10);
        TextView12=(TextView)findViewById(R.id.textView12);
        TextView14=(TextView)findViewById(R.id.textView14);
        TextView16=(TextView)findViewById(R.id.textView16);
        Typeface customfont=Typeface.createFromAsset(getAssets(),"fonts/volatire.ttf");
        TextView8.setTypeface(customfont);
        TextView9.setTypeface(customfont);
        TextView10.setTypeface(customfont);
        TextView12.setTypeface(customfont);
        TextView14.setTypeface(customfont);
        TextView16.setTypeface(customfont);
    }
}
