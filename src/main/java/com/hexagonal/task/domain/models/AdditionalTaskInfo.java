package com.hexagonal.task.domain.models;

public class AdditionalTaskInfo {
    private final long userId;
    private final String userName;
    private final String userEmail;

    public AdditionalTaskInfo(long userId, String userName, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
