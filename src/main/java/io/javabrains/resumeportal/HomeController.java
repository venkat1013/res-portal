package io.javabrains.resumeportal;

import io.javabrains.resumeportal.models.UserProfile;
import io.javabrains.resumeportal.repositories.UserProfileRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

  @Autowired
  UserProfileRepository userProfileRepository;

  @GetMapping("/")
  public String getHomePage() {
    return "Hello world!";
  }

  @GetMapping("/edit")
  public String edit() {
    return "edit page";
  }

  @GetMapping("/view/{userId}")
  public String view(@PathVariable String userId, Model model) {
    Optional<UserProfile> userProfileOptional = userProfileRepository.findByUserName(userId);
    userProfileOptional.orElseThrow(() -> new RuntimeException("User Not Found:" + userId));

    model.addAttribute("userId", userId);
    UserProfile userProfile = userProfileOptional.get();
    model.addAttribute("userProfile", userProfile);

    return "profile-templates/" + userProfile.getTheme() + "/index";
  }
}
