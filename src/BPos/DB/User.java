package BPos.DB;
// Generated Aug 23, 2016 10:19:13 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User  implements java.io.Serializable {


     private Integer idUser;
     private String fname;
     private String lname;
     private String email;
     private String mobile;
     private String lanNo;
     private String gender;
     private Set userLogins = new HashSet(0);

    public User() {
    }

    public User(String fname, String lname, String email, String mobile, String lanNo, String gender, Set userLogins) {
       this.fname = fname;
       this.lname = lname;
       this.email = email;
       this.mobile = mobile;
       this.lanNo = lanNo;
       this.gender = gender;
       this.userLogins = userLogins;
    }
   
    public Integer getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
    public String getFname() {
        return this.fname;
    }
    
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return this.lname;
    }
    
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getLanNo() {
        return this.lanNo;
    }
    
    public void setLanNo(String lanNo) {
        this.lanNo = lanNo;
    }
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Set getUserLogins() {
        return this.userLogins;
    }
    
    public void setUserLogins(Set userLogins) {
        this.userLogins = userLogins;
    }




}


