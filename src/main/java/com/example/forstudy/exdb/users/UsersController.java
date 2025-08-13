package com.example.forstudy.exdb.users;

import com.example.forstudy.config.jwt.JwtTokenProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "로그인", description = "아이디와 비밀번호로 JWT 토큰을 발급받습니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "로그인 성공",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UsersResDTO.class))),
            @ApiResponse(responseCode = "401", description = "인증 실패")
    })
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsersReqDTO usersReqDTO){
        String token = usersService
                .authenticate(usersReqDTO.getUsername(), usersReqDTO.getPassword());
        return new ResponseEntity<>(new UsersResDTO(token), HttpStatus.OK);
    }
}
