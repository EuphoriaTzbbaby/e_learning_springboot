package tzb.pojo;

import lombok.Data;

@Data
public class Users {

  private long id;
  private String username;
  private String password;
  private String role;
  private String name;
  private String email;
  private java.sql.Timestamp createdAt;
  private String avatar;
}
