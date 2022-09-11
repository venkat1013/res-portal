package io.javabrains.resumeportal.repositories;

import io.javabrains.resumeportal.models.UserProfile;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

  Optional<UserProfile> findByUserName(String userName);

}
