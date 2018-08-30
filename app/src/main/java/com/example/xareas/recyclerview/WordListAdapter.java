package com.example.xareas.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;

    public WordListAdapter(Context context, LinkedList<String> mWordList) {
        this.mInflater = LayoutInflater.from(context);
        this.mWordList = mWordList;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.wordlist_item,parent,false);
        return new WordViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
       String mCurrent = mWordList.get(position);
       holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

         final TextView wordItemView;
         final WordListAdapter mAdapter;

         public WordViewHolder(View itemView,WordListAdapter adapter) {
             super(itemView);
             wordItemView = itemView.findViewById(R.id.word);
             this.mAdapter = adapter;
             itemView.setOnClickListener(this::onClick);
         }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            String element = mWordList.get(position);
            mWordList.set(position,"TouchInside " + position);
            mAdapter.notifyDataSetChanged();
        }
    }
}
