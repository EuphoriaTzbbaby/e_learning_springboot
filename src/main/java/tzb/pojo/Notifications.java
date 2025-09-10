package com.sample;


public class Notifications {

  private long notificationId;
  private long userId;
  private String type;
  private String content;
  private long isRead;
  private java.sql.Timestamp createdAt;


  public long getNotificationId() {
    return notificationId;
  }

  public void setNotificationId(long notificationId) {
    this.notificationId = notificationId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public long getIsRead() {
    return isRead;
  }

  public void setIsRead(long isRead) {
    this.isRead = isRead;
  }


  public java.sql.Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(java.sql.Timestamp createdAt) {
    this.createdAt = createdAt;
  }

}
