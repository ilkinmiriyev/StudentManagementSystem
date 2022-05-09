package edu.deegrework.StudentManagementSystem.security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "user_details")
@Entity
public class CustomUserDetails implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

//    @OneToOne(mappedBy = "userDetails")
//    private Student student;

    @CreationTimestamp
    @Column(name = "creation_date", updatable = false, nullable = false)
    private Date creationDate;

    @Column(name = "logged_in")
    private Boolean loggedIn = Boolean.FALSE;

    @Column(name = "locked")
    private Boolean locked;

    @Column(name = "enabled")
    private Boolean enabled;

//    public CustomUserDetails(User user) {
//        this.email = user.getEmail();
//        this.password = user.getPassword();
//        this.role = user.getRole();
//        this.locked = user.getLocked();
//        this.enabled = user.getEnabled();
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
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
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
