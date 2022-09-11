package io.javabrains.resumeportal.services;

import io.javabrains.resumeportal.models.MyUserDetails;
import io.javabrains.resumeportal.models.User;
import io.javabrains.resumeportal.repositories.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

  @Autowired
  UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> user = userRepository.findByUserName(username);
    user.orElseThrow(() -> new UsernameNotFoundException("Not found Username: " + username));
    return user.map(MyUserDetails::new).get();
  }
}
