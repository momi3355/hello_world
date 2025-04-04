package com.yedam.bookapp;

public class User {
	private String userId;
	private String userName;
	private String password;

	public User(String userId, String userName, String password) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
	   return userName;
	}
	public String getUserId() {
	   return userId;
	}
	public String getPassword() {
	   return password;
	}

@Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((password == null) ? 0 : password.hashCode());
      result = prime * result + ((userId == null) ? 0 : userId.hashCode());
      result = prime * result + ((userName == null) ? 0 : userName.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      User other = (User)obj;
      if (password == null) {
         if (other.password != null)
            return false;
      } else if (!password.equals(other.password))
         return false;
      if (userId == null) {
         if (other.userId != null)
            return false;
      } else if (!userId.equals(other.userId))
         return false;
      if (userName == null) {
         if (other.userName != null)
            return false;
      } else if (!userName.equals(other.userName))
         return false;
      return true;
   }
}
