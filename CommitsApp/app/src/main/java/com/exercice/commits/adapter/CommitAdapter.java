package com.exercice.commits.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.exercice.commits.R;
import com.exercice.commits.models.DataToShow;
import com.exercice.commits.views.CommitsViewHolder;

import java.util.List;


public class CommitAdapter extends RecyclerView.Adapter<CommitsViewHolder> {

    private List<DataToShow> dataToShows;

    public CommitAdapter(List<DataToShow> dataToShows) {
        this.dataToShows = dataToShows;
    }

    @Override
    public CommitsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.commit_item, parent, false);

        return new CommitsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommitsViewHolder viewHolder, int position) {
        viewHolder.updateWithCommitData(this.dataToShows.get(position));
    }

    @Override
    public int getItemCount() {
        return this.dataToShows.size();
    }
}