//package com.pjsoft.fms.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.security.core.userdetails.User;
//
//import java.util.ArrayList;
//
//@Service
//    public class CustomUserDetailsService implements UserDetailsService {
//
//        @Override
//        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////            User user = userRepository.findByUsername(username);
//            User user = new User("anukrati","password", new ArrayList<>());
//            if (user == null) {
//                throw new UsernameNotFoundException("User not found with username: " + username);
//            }
//            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
//        }
//    }
//
