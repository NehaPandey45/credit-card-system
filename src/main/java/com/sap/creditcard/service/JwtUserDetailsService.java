package com.sap.creditcard.service;

import java.util.ArrayList;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * The Spring Security Authentication Manager calls this method. Here we are getting the user
 * details from a hardcoded User List. Also the password for a user is stored in encrypted format
 * using BCrypt. Here using the Online Bcrypt Generator https://www.javainuse.com/onlineBcrypt
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    if ("test".equals(username)) {
      return new User(
          "test",
          "$2a$10$cluoi/Lvix8ladV3RdLQIeUZZJO85Oe3iiiXpXs3Wlc4nmgwuO1cW",
          new ArrayList<>());
    } else {
      throw new UsernameNotFoundException("User not found with username: " + username);
    }
  }
}
