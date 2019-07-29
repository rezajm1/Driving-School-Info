package com.ta.drivingschoolinfo.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ta.drivingschoolinfo.Adapter.adapter_home;
import com.ta.drivingschoolinfo.Model.model_home;
import com.ta.drivingschoolinfo.R;
import java.util.ArrayList;



public class fragment_home extends Fragment {
    private RecyclerView recyclerView;
    private adapter_home adapter;
    private ArrayList<model_home> homeArrayList;

    public fragment_home(){

    }

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragment_home, container, false);



    }


   public void addData(){
        homeArrayList = new ArrayList<>();
        homeArrayList.add(new model_home("Dimas Maulana", "1414370309", "asdas"));
        homeArrayList.add(new model_home("Fadly Yonk", "1214234560", "987654321"));
        homeArrayList.add(new model_home("Ariyandi Nugraha", "1214230345", "987648765"));
        homeArrayList.add(new model_home("Aham Siswana", "1214378098", "098758124"));
    }

}
