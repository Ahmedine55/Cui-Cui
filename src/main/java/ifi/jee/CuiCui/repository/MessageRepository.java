package ifi.jee.CuiCui.repository;

import ifi.jee.CuiCui.model.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MessageRepository extends JpaRepository<Message,Integer> {
    @Query(value = "select m from Message m where m.user.id=:x order by m.date desc")
    public Page<Message> listMessages(@Param("x")int idUser, Pageable pageable);
}
