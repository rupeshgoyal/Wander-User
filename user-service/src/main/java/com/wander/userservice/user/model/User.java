package com.wander.userservice.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@Table(name = "users")
public class User {

    public User() {
        authorities= new HashSet<>();
        authorities.add("USER");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Size(min=4, max=15, message = "username size should be between 4 to 15")
    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String uuid;

    @Size(min=4, max=50, message = "Size should be between 4 to 50")
    @Column(nullable = false)
    private String name;

    @Email(message = "Please enter valid email address")
    @Size(min=5, max=50, message = "Size should be between 4 to 50")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Column(nullable = false)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name="AUTHORITY")
    @CollectionTable(name = "AUTHORITIES",joinColumns = {@JoinColumn(name="id")})
    private Set<String> authorities;

    @Column(nullable = false)
    private boolean enabled;
}
