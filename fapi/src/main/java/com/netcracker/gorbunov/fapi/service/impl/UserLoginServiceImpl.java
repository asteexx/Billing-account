package com.netcracker.gorbunov.fapi.service.impl;

import com.netcracker.gorbunov.fapi.beClasses.UserModel;
import com.netcracker.gorbunov.fapi.service.UserLoginService;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service("userDetailsService")
public class UserLoginServiceImpl implements UserDetailsService, UserLoginService {

    private final static Logger LOGGER = LogManager.getLogger(UserLoginServiceImpl.class);


    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserModel findByLogin(String login) {
        RestTemplate restTemplate = new RestTemplate();
        LOGGER.info("111");
        UserModel user = restTemplate.getForObject(backendServerUrl + "/api/users/login/" + login, UserModel.class);
        LOGGER.info("2222");
        LOGGER.info(user + ": user");
        return user;
    }

    @Override
    public List<UserModel> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        UserModel[] usersResponse = restTemplate.getForObject(backendServerUrl + "/api/users", UserModel[].class);
        return usersResponse == null ? Collections.emptyList() : Arrays.asList(usersResponse);
    }

    @Override
    public UserModel save(UserModel user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/users/signup", user, UserModel.class).getBody();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), getAuthority(user));
    }

    @Override
    public void deleteUser(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/users/" + id);
    }

    @Override
    public UserModel getUserById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/users/" + id, UserModel.class);

    }
@Override
    public Set<SimpleGrantedAuthority> getAuthority(UserModel user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getValue()));
        return authorities;
    }


}
