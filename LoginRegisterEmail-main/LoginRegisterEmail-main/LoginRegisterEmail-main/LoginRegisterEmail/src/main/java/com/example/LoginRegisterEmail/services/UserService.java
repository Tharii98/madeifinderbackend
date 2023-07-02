package com.example.LoginRegisterEmail.services;

import com.example.LoginRegisterEmail.repoistory.UserRepository;
import com.example.LoginRegisterEmail.entities.User;
import com.example.LoginRegisterEmail.jwt.JwtTokenUtil;
import com.example.LoginRegisterEmail.registration.token.Confirmation;
import com.example.LoginRegisterEmail.registration.token.ConfirmationTokenService;
import com.example.LoginRegisterEmail.utils.Util;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
@AllArgsConstructor
public class UserService implements UserDetailsService, Serializable {

    private static final long serialVersionUID = -2550185165626007488L;
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    private JwtTokenUtil jwtTokenUtil;

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info(Util.FIND_BY_EMAIL);
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format(Util.USER_NOT_FOUND_MSG, email)));

    }

    public String signUp (User user){
        boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();
        if (userExists){
            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        final String token = jwtTokenUtil.generateToken(user);
        Confirmation confirmationToken = new Confirmation(token, LocalDateTime.now(),LocalDateTime.now().plusMinutes(15),user);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }

    @Transactional
    public void enableAppUser(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        optionalUser.ifPresent(user -> {
            user.setEnabled(true);
            userRepository.save(user);
        });
    }


}
