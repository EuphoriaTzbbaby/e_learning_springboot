package com.sample;


public class Follows {

  private long followId;
  private long followerId;
  private long followingId;
  private java.sql.Timestamp createdAt;


  public long getFollowId() {
    return followId;
  }

  public void setFollowId(long followId) {
    this.followId = followId;
  }


  public long getFollowerId() {
    return followerId;
  }

  public void setFollowerId(long followerId) {
    this.followerId = followerId;
  }


  public long getFollowingId() {
    return followingId;
  }

  public void setFollowingId(long followingId) {
    this.followingId = followingId;
  }


  public java.sql.Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(java.sql.Timestamp createdAt) {
    this.createdAt = createdAt;
  }

}
