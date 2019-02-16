package com.watermelonfarmers.watermelon.entities;

import org.springframework.security.core.GrantedAuthority;

public class UserAuthorities implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return "ROLE_USER";
    }
}
