package com.pjsoft.fms.controller;

import com.pjsoft.fms.dto.AuthenticationRequestDto;
import com.pjsoft.fms.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/authenticate")
public class JwtAuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public String createAuthenticationToken(@RequestBody AuthenticationRequestDto authenticationRequestDto){
        List<String> userNameList = new ArrayList<>();
        userNameList.addAll(Arrays.asList("Anukrati","Verma","Anu"));
        String jwt = null;
        if(userNameList.contains(authenticationRequestDto.getUserName())){
            jwt = jwtUtil.generateAuthToken(authenticationRequestDto.getUserName());
            return jwt;
        }
        else{
            throw new RuntimeException("Credentials Invalid");
        }
    }
}
