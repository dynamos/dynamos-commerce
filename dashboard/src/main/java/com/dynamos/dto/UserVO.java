package com.dynamos.dto;

import com.dynamos.domain.entity.Authority;
import com.dynamos.domain.entity.User;

import java.time.LocalDateTime;
import java.util.Set;


/**
 * A VO representing a user, with his authorities.
 */
public class UserVO {

    public static final int PASSWORD_MIN_LENGTH = 5;
    public static final int PASSWORD_MAX_LENGTH = 100;

    private String login;

    private String firstName;

    private String lastName;

    private String email;

    private boolean activated = false;

    private String langKey;

    private Set<Authority> authorities;

    private LocalDateTime createdDate;

    public UserVO() {
    }

    public UserVO(User user) {
        this(user.getLogin(), user.getFirstName(), user.getLastName(),
                user.getEmail(), user.getActivated(), user.getLangKey(),
                user.getAuthorities(), user.getCreatedDate());
    }

    public UserVO(String login, String firstName, String lastName,
                  String email, boolean activated, String langKey, Set<Authority> authorities, LocalDateTime createdDate) {

        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.activated = activated;
        this.langKey = langKey;
        this.authorities = authorities;
        this.createdDate = createdDate;
    }


    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActivated() {
        return activated;
    }

    public String getLangKey() {
        return langKey;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", activated=" + activated +
                ", langKey='" + langKey + '\'' +
                ", authorities=" + authorities.stream().map(Authority::getName) +
                "}";
    }
}
