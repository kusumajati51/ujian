package com.test.user.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @SerializedName("id")
    @Expose
    private long id ;

    @SerializedName("name")
    @NotEmpty(message = "Please provide your name")
    @Expose 
    private String name;

    @SerializedName("email")
    @NotEmpty(message = "Please provide your email")
    @Expose
    @Email
    private String email;

    @SerializedName("password")
    @NotEmpty(message = "Please provide a password")
    @Expose  
    private String password;

    @Transient
    @SerializedName("confirmPassword")
    @NotEmpty(message = "Please Reapet your password")
    private String confirmPassword;

    @SerializedName("phoneNumber")
    @NotEmpty(message = "Please provide your Phone number")
    @Pattern(regexp = "(\\+62|0)[0-9]{9,10}", message = "Your Phone Number Wrong Format")
    private String phoneNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @SerializedName("created_at")
    @Expose  
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @SerializedName("updated_at")
    @Expose  
    private Date updatedAt;
    
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


}