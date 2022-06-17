package com.javr.earthquake_monitor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.javr.earthquake_monitor.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.eqRecycler.setLayoutManager(new LinearLayoutManager(this));

        ArrayList <Earthquake> eqList = new ArrayList<>();
        /*eqList.add(new Earthquake("ec1", "Ecuador", 7.5, 12313123123123L,1.132131231, 2.234234234));
        eqList.add(new Earthquake("ch1", "Chile", 7.5, 12313123123123L,1.132131231, 2.234234234));
        eqList.add(new Earthquake("pe1", "Peru", 7.5, 12313123123123L,1.132131231, 2.234234234));
        eqList.add(new Earthquake("co1", "Colombia", 7.5, 12313123123123L,1.132131231, 2.234234234));
        eqList.add(new Earthquake("ve1", "Venezuela", 7.5, 12313123123123L,1.132131231, 2.234234234));*/

        EqAdapter adapter = new EqAdapter();
        adapter.setOnItemClickListener(new EqAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Earthquake earthquake) {
                Toast.makeText(MainActivity.this, earthquake.getPlace(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.eqRecycler.setAdapter(adapter);
        adapter.submitList(eqList);

        if(eqList.isEmpty()){
            binding.txtEmptyView.setVisibility(View.VISIBLE);
        }else{
            binding.txtEmptyView.setVisibility(View.GONE);
        }
    }
}