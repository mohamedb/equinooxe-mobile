
package com.equinooxe.domain;

/**
 *
 * @author Mohamed
 */
public class BasicAuthDto {

    String username;
    String password;
    boolean rememberMe = true;
    
    /**
     * Jackson need a default constructor to perform serialization!
     */
    public BasicAuthDto(){
         
    }
    
    public BasicAuthDto(String username, String password, boolean rememberMe) {
        this.username = username;
        this.password = password;
        this.rememberMe = rememberMe;
    }

    @Override
    public String toString() {
        return username + " | " + password+ " | "+Boolean.toString(rememberMe);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

}
