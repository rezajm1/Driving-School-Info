package com.ta.drivingschoolinfo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ta.drivingschoolinfo.R;
import com.ta.drivingschoolinfo.upload;
import java.util.ArrayList;
import java.util.List;
import com.squareup.picasso.Picasso;


public class adapter_home extends RecyclerView.Adapter<adapter_home.ImageViewHolder>{
    private Context mContext;
    private List<upload> mUploads;


    public adapter_home(Context context, List<upload> uploads) {
        mContext = context;
        mUploads = uploads;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        upload uploadCurrent = mUploads.get(position);
        holder.textViewName.setText(uploadCurrent.getmName());
        holder.textViewUsia.setText(uploadCurrent.getmUsia());
        holder.textViewAlamat.setText(uploadCurrent.getmAlamat());
        Picasso.get()
                .load(uploadCurrent.getGambarUrl())
                .placeholder(R.mipmap.ic_launcher)
                .fit()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }



    public class ImageViewHolder extends RecyclerView.ViewHolder  {
        public ImageView imageView;
        public TextView textViewName;
        public TextView textViewUsia;
        public TextView textViewAlamat;

        public ImageViewHolder(View itemView){
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewUsia = itemView.findViewById(R.id.text_view_name1);
            textViewAlamat = itemView.findViewById(R.id.text_view_name2);
            imageView = itemView.findViewById(R.id.image_view_upload);

        }

    }

}

