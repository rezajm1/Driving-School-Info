package com.ta.drivingschoolinfo.Adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ta.drivingschoolinfo.Model.model_home;
import com.ta.drivingschoolinfo.R;
import java.util.ArrayList;

public class adapter_home extends RecyclerView.Adapter<adapter_home.HomeViewHolder>{
private ArrayList<model_home> dataList;

public adapter_home(ArrayList<model_home> dataList) {
        this.dataList = dataList;
        }

@Override
public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_nama, parent, false);
        return new HomeViewHolder(view);
        }

@Override
public void onBindViewHolder(HomeViewHolder holder, int position) {
        holder.txtnama.setText(dataList.get(position).getNama());
        holder.txtalamat.setText(dataList.get(position).getAlamat());
        holder.txtnotel.setText(dataList.get(position).getNotel());
        }

@Override
public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
        }

public class HomeViewHolder extends RecyclerView.ViewHolder{
    private TextView txtnama, txtalamat, txtnotel;

    public HomeViewHolder(View itemView) {
        super(itemView);
        txtnama = (TextView) itemView.findViewById(R.id.txt_nama);
        txtalamat = (TextView) itemView.findViewById(R.id.txt_alamat);
        txtnotel = (TextView) itemView.findViewById(R.id.txt_notel);
    }
}


}

