package com.sshmeger.test;



/**
 * Test entity. @author MyEclipse Persistence Tools
 */

public class Test  implements java.io.Serializable {


    // Fields    

     private String id;
     private String name;
     private String password;


    // Constructors

    /** default constructor */
    public Test() {
    }

    
    /** full constructor */
    public Test(String name, String password) {
        this.name = name;
        this.password = password;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
   








}