package com.example.forstudy.exdb.users;

import com.example.forstudy.config.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsersReqDTO usersReqDTO){
        String token = usersService
                .authenticate(usersReqDTO.getUsername(), usersReqDTO.getPassword());
        return new ResponseEntity<>(new UsersResDTO(token), HttpStatus.OK);
    }
}
