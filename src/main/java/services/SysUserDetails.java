package services;

import entities.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import reposotories.userRepo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.PrimitiveIterator;

public class SysUserDetails implements UserDetails {

    @Autowired
    reposotories.userRepo userRepo;

    private String username ;
    private String Password ;
    private boolean enabled ;
    private String role;


    public SysUserDetails(user user){
        this.username = user.getUsername();
        this.Password = user.getPassword();
        this.enabled = user.isEnabled();
        this.role = user.getRole().getName();

    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_"+role));
    }

    @Override
    public String getPassword() {
        return Password;
    }

    @Override
    public String getUsername() {
        return username;
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
        return enabled;

    }
}
