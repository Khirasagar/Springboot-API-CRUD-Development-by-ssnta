package com.user.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class PropertyUserDto {

            private Long id;
            @NotEmpty
            @Size(min=2,message="Should be at least 2 characters")
            private String name;
            private Date date;

                public Date getDate() {
                    return date;
                }

                public void setDate(Date date) {
                    this.date = date;
                }

    @Email
            private String emailId;

            public String getEmailId() {
                return emailId;
            }

            public void setEmailId(String emailId) {
                this.emailId = emailId;
                }
             @Size(min=10,max=10,message="Should be  10 digits")
            private String mobile;

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }
               public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public Long getId() {
                    return id;
                }

                public void setId(Long id) {
                    this.id = id;
        }

    }
