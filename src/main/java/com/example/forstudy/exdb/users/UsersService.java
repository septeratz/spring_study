package com.example.forstudy.exdb.users;

import com.example.forstudy.config.jwt.JwtTokenProvider;
import com.example.forstudy.exception.users.NotFoundUsernameException;
import com.example.forstudy.exception.users.WrongPasswordException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository userRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider tokenProvider;

    public String authenticate(String username, String password) {
        Users user = userRepository.findByUsername(username).orElseThrow(()->
                new NotFoundUsernameException("존재하지 않는 유저입니다."));
        if (!Objects.equals(password, user.getPassword())) {
            throw new WrongPasswordException();
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), password);

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        String access = tokenProvider.createToken(username);


        return access;
    }


}
