package com.example.romananchugov.homeworkapplicationlesson1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<RecyclerElement> data = new ArrayList<>();
        for(int i = 1; i <= 100; i++){
            RecyclerElement element;
            element = new RecyclerElement(i + "", R.drawable.p1, "Lorem");
            if(i % 2 == 0) {
                element = new RecyclerElement(i + "", R.drawable.p2, "Lorem");
            }
            if(i % 4 == 0){
                element = new RecyclerElement(i + "", R.drawable.p3, " Lorem");
            }
            data.add(element);
        }
        recyclerView.setAdapter(new RecyclerAdapter(data));

    }
}
