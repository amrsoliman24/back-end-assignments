package services;

import entities.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import reposotories.userRepo;

import java.util.Optional;

@Service
public class SysUsersDetailsService implements UserDetailsService {
    @Autowired
    reposotories.userRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       user user = userRepo.findByusername(s);
        return new  SysUserDetails(user);
    }
}
