package com.SecurityApp.services;

import com.SecurityApp.dto.SignUpDto;
import com.SecurityApp.dto.UserDto;
import com.SecurityApp.entities.User;
import com.SecurityApp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with email "+username+"not found"));
    }

    public UserDto signUp(SignUpDto signUpDto) {
        Optional<User> user=userRepository.findByEmail(signUpDto.getEmail());

        if(user.isPresent()){
            throw new BadCredentialsException("User with email already exits "+signUpDto.getEmail());
        }

        User toBeCreateUser=modelMapper.map(signUpDto,User.class);
        toBeCreateUser.setPassword(passwordEncoder.encode(toBeCreateUser.getPassword()));

        User savedUser=userRepository.save(toBeCreateUser);

        return modelMapper.map(savedUser,UserDto.class);
    }
}
