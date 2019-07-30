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
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.ta.drivingschoolinfo.Adapter.adapter_home;
import com.ta.drivingschoolinfo.R;
import com.ta.drivingschoolinfo.upload;

import java.util.ArrayList;
import java.util.List;



public class fragment_home extends Fragment {
    private RecyclerView recyclerView2;
    private adapter_home mAdapter;
    private ProgressBar mProgressCircle;

    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;
    private List<upload> mUploads;

    public fragment_home() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment_home, container, false);

        mProgressCircle = (ProgressBar) view.findViewById(R.id.progress_circle);
        recyclerView2 = view.findViewById(R.id.recycler_view);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView2.setHasFixedSize(true);


        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Photo");

        return view;
    }
    public void onStart()
    {
        super.onStart();
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mUploads = new ArrayList<>();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    upload upload = postSnapshot.getValue(upload.class);
                    mUploads.add(upload);
                }
                mAdapter = new adapter_home(getActivity(), mUploads);
                recyclerView2.setAdapter(mAdapter);


                mProgressCircle.setVisibility(View.INVISIBLE);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(),Toast.LENGTH_SHORT).show();
                mProgressCircle.setVisibility(View.INVISIBLE);
            }
        });
    }

}