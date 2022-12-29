package com.saraf.myapp.security.manager;

import com.saraf.myapp.entity.User;
import com.saraf.myapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

    private UserService userServiceImp;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        User user = userServiceImp.getUser(authentication.getName());
        if( !bCryptPasswordEncoder.matches(authentication.getCredentials().toString(), user.getPassword())){
            throw new BadCredentialsException("Wrong password");
        }
        return new UsernamePasswordAuthenticationToken(authentication.getName(), user.getPassword());
    }
}
