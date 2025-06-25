package com.example.forstudy.exdb.users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Users {
    @Id
    @Column(name="username", nullable = false)
    private String username;

    private String password;
}
