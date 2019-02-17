package com.watermelonfarmers.watermelon.configuration;

import com.watermelonfarmers.watermelon.entities.UserAuthorities;
import com.watermelonfarmers.watermelon.entities.UserEntity;
import com.watermelonfarmers.watermelon.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class UserAccountSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

    private UserRepository userRepository;

    @Autowired
    public UserAccountSecurityConfiguration(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void init(AuthenticationManagerBuilder authentication) throws Exception {
        authentication.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        PasswordEncoder encoder = NoOpPasswordEncoder.getInstance();
        return encoder;
    }

    @Bean
    UserDetailsService userDetailsService() {
        return (username) -> {

            List<UserAuthorities> userAuthoritiesList = new ArrayList<>();
            UserAuthorities userAuthorities = new UserAuthorities();
            userAuthoritiesList.add(userAuthorities);
            Optional<UserEntity> userEntity = userRepository.findById(1l);

            return new User(
                    userEntity.get().getUserName(),
                    userEntity.get().getPassword(),
                    userAuthoritiesList);
        };
    }
}
