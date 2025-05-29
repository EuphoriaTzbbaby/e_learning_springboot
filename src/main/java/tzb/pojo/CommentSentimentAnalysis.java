package tzb.pojo;


public class CommentSentimentAnalysis {

  private long id;
  private String commentId;
  private String sentiment;
  private double score;
  private java.sql.Timestamp analyzedAt;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getCommentId() {
    return commentId;
  }

  public void setCommentId(String commentId) {
    this.commentId = commentId;
  }


  public String getSentiment() {
    return sentiment;
  }

  public void setSentiment(String sentiment) {
    this.sentiment = sentiment;
  }


  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }


  public java.sql.Timestamp getAnalyzedAt() {
    return analyzedAt;
  }

  public void setAnalyzedAt(java.sql.Timestamp analyzedAt) {
    this.analyzedAt = analyzedAt;
  }

}
