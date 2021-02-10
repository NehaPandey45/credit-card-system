package com.sap.creditcard.service;

import java.util.ArrayList;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * This service loads the userName and Password as per the userName passed in the parameter.
 *
 * <p>TODO: This userName and password should be saved in database
 *
 * <p>Flow: The Spring Security Authentication Manager calls this method. Here we are getting the
 * user details from a hardcoded User List. Also the password for a user is stored in encrypted
 * format using BCrypt. Here using the Online Bcrypt Generator
 * https://www.javainuse.com/onlineBcrypt
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // TODO: this should be saved in Datatbase in secure way. For now we are saving username as a
    // constant and password is encrypted.
    final String userName = "test";
    if (userName.equals(username)) {
      return new User(
          userName,
          "$2a$10$cluoi/Lvix8ladV3RdLQIeUZZJO85Oe3iiiXpXs3Wlc4nmgwuO1cW",
          new ArrayList<>());
    } else {
      throw new UsernameNotFoundException("User not found with username: " + username);
    }
  }
}
