package com.cs.common.persistence.domain;
// Generated 14-May-2017 7:46:21 PM by Hibernate Tools 5.2.0.Final


import javax.persistence.*;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user"
        , schema = "auth"
)
public class User implements java.io.Serializable {


    private long id;
    private String name;
    private String email;
    private String userId;
    private String password;

    public User() {
    }


    public User(long id) {
        this.id = id;
    }

    public User(long id, String name, String email, String userId, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userId = userId;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Column(name = "name", length = 100)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "email", length = 100)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Column(name = "user_id", length = 100)
    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    @Column(name = "password", length = 200)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}


