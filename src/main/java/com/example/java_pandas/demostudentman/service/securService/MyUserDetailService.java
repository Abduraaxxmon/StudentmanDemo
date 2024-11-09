package com.example.java_pandas.demostudentman.service.securService;

import com.example.java_pandas.demostudentman.dto.UserPrincipal;
import com.example.java_pandas.demostudentman.entity.User;
import com.example.java_pandas.demostudentman.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService  implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User not found"+username);
        }
        return new UserPrincipal(user.get());

    }
}
