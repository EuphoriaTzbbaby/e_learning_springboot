package com.sample;


public class Likes {

  private long likeId;
  private long postId;
  private long userId;
  private java.sql.Timestamp createdAt;


  public long getLikeId() {
    return likeId;
  }

  public void setLikeId(long likeId) {
    this.likeId = likeId;
  }


  public long getPostId() {
    return postId;
  }

  public void setPostId(long postId) {
    this.postId = postId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public java.sql.Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(java.sql.Timestamp createdAt) {
    this.createdAt = createdAt;
  }

}
