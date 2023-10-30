package oit.is.z2215.kaizi.janken.model;

public class User {
  int id;
  String username;

  public User() {

  }

  public void setUsername(String username) {
    this.username = username;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return username;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.username = name;
  }

  public String getUsername() {
    return username;
  }
}
