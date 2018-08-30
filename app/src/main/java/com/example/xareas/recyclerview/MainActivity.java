package com.example.xareas.recyclerview;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.Iterator;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> wordList = new LinkedList<>();
    private int mCount = 0;
    private RecyclerView mRecycler;
    private WordListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0 ; i < 100; i++){
            wordList.add("Mi Palabra " + mCount++);
        }
        mRecycler = findViewById(R.id.recyclerview);
        adapter = new WordListAdapter(this,wordList);
        mRecycler.setAdapter(adapter);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
            int size = wordList.size();
            wordList.addLast("Mi ultima palabra " + size);
            mRecycler.getAdapter().notifyItemInserted(size);
            mRecycler.smoothScrollToPosition(size);
        });


    }
}
