package com.sample;


public class PostMedia {

  private long mediaId;
  private long postId;
  private String mediaType;
  private String url;
  private java.sql.Timestamp uploadedAt;


  public long getMediaId() {
    return mediaId;
  }

  public void setMediaId(long mediaId) {
    this.mediaId = mediaId;
  }


  public long getPostId() {
    return postId;
  }

  public void setPostId(long postId) {
    this.postId = postId;
  }


  public String getMediaType() {
    return mediaType;
  }

  public void setMediaType(String mediaType) {
    this.mediaType = mediaType;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  public java.sql.Timestamp getUploadedAt() {
    return uploadedAt;
  }

  public void setUploadedAt(java.sql.Timestamp uploadedAt) {
    this.uploadedAt = uploadedAt;
  }

}
