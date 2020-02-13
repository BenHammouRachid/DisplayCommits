package com.exercice.commits.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.exercice.commits.R;
import com.exercice.commits.models.DataToShow;
import com.exercice.commits.util.Utils;

public class CommitsViewHolder extends RecyclerView.ViewHolder {
    private TextView authorName;
    private TextView commitMessage;
    private TextView sha1;
    private ImageView authorAvatar;

    //String authorName, String authorAvatar, String commitMessage, String sha1)


    public CommitsViewHolder(View itemView) {
        super(itemView);
        authorName = itemView.findViewById(R.id.authorname);
        commitMessage = itemView.findViewById(R.id.commitmessage);
        sha1 = itemView.findViewById(R.id.sha1);
        authorAvatar = itemView.findViewById(R.id.authoravatar);
    }

    public void updateWithCommitData(DataToShow dataToShow) {
        this.authorName.setText(dataToShow.getAuthorName());
        this.commitMessage.setText(dataToShow.getCommitMessage());
        this.sha1.setText(dataToShow.getSha1());
        //TODO : load image using picasso
        //this.authorAvatar.setImageResource();
    }
}