package com.hamitmizrak.techcareer_2025_backend_1.jwt;

import com.hamitmizrak.techcareer_2025_backend_1.bean.PasswordEncoderBean;
import com.hamitmizrak.techcareer_2025_backend_1.controller.GHandleApiresult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// LOMBOK
@RequiredArgsConstructor

// API
@RestController
@RequestMapping("/api/auth")

public class _8_AuthApi {

    // Injection
    private final _5_IUserRepository iUserRepository;
    private final _7_JwtUtils jwtUtils;

    // Bean
    private final PasswordEncoderBean passwordEncoderBean;

    // AuthenticationManager
    private final AuthenticationManager authenticationManager;

   /*
    POSTMAN (REGİSTER)
    METHOD: POST
    URL   : http://localhost:4444/api/auth/register
    BODY  :
    {
      "username": "root",
      "password": "root"
    }
     */

    /*
    curl -X POST http://localhost:4444/api/auth/register \
    -H "Content-Type: application/json" \
    -d '{
      "username": "root",
      "password": "root"
    }'
     */
    // REGISTER
    @PostMapping("/register")
    public ResponseEntity<?>  userRegister(@RequestBody _2_RegisterRequest registerRequest) {
        _4_UserEntity userEntity = new _4_UserEntity();

        // username Set
        userEntity.setUsername(registerRequest.getUsername());

        // password Set
        userEntity.setPassword(passwordEncoderBean.getPasswordEncoderSingleton().encode(registerRequest.getPassword()));

        // Role Set
        userEntity.setRole(_3_Role.USER);

        //return ResponseEntity.ok("Kayıt Başarılı\n"+userEntity+"\n");
        return GHandleApiresult.genericsHandleApiResult(
                "/api/auth/register",
                200,
                500,
                ()-> iUserRepository.save(userEntity));
    }

    /////////////////////////////////////////////////////////////////////////////
    /*
    POSTMAN (LOGIN)
    METHOD: POST
    URL   : http://localhost:4444/api/auth/login
    BODY  :
    {
      "username": "root",
      "password": "root"
    }
     */

    /*
    cURL
    curl -X POST http://localhost:4444/api/auth/login \
    -H "Content-Type: application/json" \
    -d '{
      "username": "root",
      "password": "root"
    }'
    * */

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<?>  userLogin(@RequestBody _1_LoginRequest loginRequest) {
        // Kullanıcı Login Bilgileri Almak
        // import org.springframework.security.core.Authentication;
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(), loginRequest.getPassword())
                ); //end authenticate

        // Token
        String token= jwtUtils.generateJwtToken(authentication.getName());
        System.out.println(token);
        /*return ResponseEntity.ok(token);*/
        //return ResponseEntity.ok("Kayıt Başarılı\n"+userEntity+"\n");
        return GHandleApiresult.genericsHandleApiResult(
                "/api/auth/login",
                200,
                500,
                ()-> token);
    }

    /////////////////////////////////////////////////////////////////////////////
    // Postman
    // 401: Yetkisiz Giriş
     /*
    POSTMAN
    Authorization: Bearer Token <Login Aldığımız Token buraya Yapıştır>
    METHOD: GET
    URL   : http://localhost:4444/api/address/v1.0.0/find/1

     */
} //end _6_AuthApi
