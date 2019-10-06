package ru.xfneo.socialnetwork.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.xfneo.socialnetwork.domain.User;

public interface UserDetailsRepo extends JpaRepository<User, String> {
}
