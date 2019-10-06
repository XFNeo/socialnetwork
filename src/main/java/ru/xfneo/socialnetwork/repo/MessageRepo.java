package ru.xfneo.socialnetwork.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.xfneo.socialnetwork.domain.Message;

public interface MessageRepo extends JpaRepository<Message, Long> {

}
