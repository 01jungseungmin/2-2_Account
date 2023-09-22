package com.demo.bcuproj.user;

import com.demo.bcuproj.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    private SiteUser of(SiteUserDto siteUserDto) {
        return modelMapper.map(siteUserDto, SiteUser.class);
    }

    private SiteUserDto of(SiteUser siteUser) {
        return this.modelMapper.map(siteUser, SiteUserDto.class);
    }

    public SiteUserDto create(String username, String email, String password, String birth) {
        SiteUser user = new SiteUser();
        user.setUsername(username);
        user.setEmail(email);
        user.setBirth(birth);
        user.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(user);
        return of(user);
    }
    
    public SiteUserDto getUser(String username) {
        Optional<SiteUser> siteUser = this.userRepository.findByusername(username);
        if (siteUser.isPresent()) {
            return of(siteUser.get());
        } else {
            throw new DataNotFoundException("siteuser not found");
        }
    }
    public SiteUserDto getttUser(Integer id) {
        Optional<SiteUser> siteUser = this.userRepository.findById(Long.valueOf(id));
        if (siteUser.isPresent()) {
            return of(siteUser.get());
        } else {
            throw new DataNotFoundException("siteuser not found");
        }
    }

    public SiteUser gettUser(String username) {
        Optional<SiteUser> siteUser = this.userRepository.findByusername(username);
        if (siteUser.isPresent()) {
            return siteUser.get();
        } else {
            throw new DataNotFoundException("siteuser not found");
        }
    }
    public SiteUserDto modify(SiteUserDto siteUserDto, String password, String birth) {
        siteUserDto.setPassword(password);
        siteUserDto.setBirth(birth);
        SiteUser siteUser = of(siteUserDto);
        this.userRepository.save(siteUser);
        return siteUserDto;
    }

}