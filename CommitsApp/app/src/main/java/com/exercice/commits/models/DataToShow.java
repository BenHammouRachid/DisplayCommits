package com.exercice.commits.models;

public class DataToShow {
    private String authorName;
    private String authorAvatar;
    private String commitMessage;
    private String sha1;


    public DataToShow(String authorName, String authorAvatar, String commitMessage, String sha1) {
        this.authorName = authorName;
        this.authorAvatar = authorAvatar;
        this.commitMessage = commitMessage;
        this.sha1 = sha1;

    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorAvatar() {
        return authorAvatar;
    }

    public String getCommitMessage() {
        return commitMessage;
    }

    public String getSha1() {
        return sha1;
    }
}
