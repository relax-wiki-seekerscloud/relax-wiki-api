package com.example.relaxwikiapi.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;
    private String gender;
    private String password;

    private boolean isVerified;

    @OneToMany(targetEntity = UserAddress.class, cascade = CascadeType.ALL )
    @JoinColumn(name= "ua_fk", referencedColumnName = "id")
    private List<UserAddress> address;

    @OneToMany(mappedBy = "id",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<HotelDetails> hotels;

    @OneToMany(mappedBy = "id",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<RestaurantDetails> restaurants;

    @OneToMany(mappedBy = "id",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<ActivityDetails> activities;

    public User(String userFirstName, String userLastName, String userEmail, String userPassword) {
        this.firstName = userFirstName;
        this.lastName = userLastName;
        this.email = userEmail;
        this.password = userPassword;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }
}

