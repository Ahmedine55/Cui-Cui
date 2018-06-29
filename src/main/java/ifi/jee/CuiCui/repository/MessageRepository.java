package ifi.jee.CuiCui.repository;

import ifi.jee.CuiCui.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Integer> {
}
