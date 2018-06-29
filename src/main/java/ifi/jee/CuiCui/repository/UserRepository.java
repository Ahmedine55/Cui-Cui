package ifi.jee.CuiCui.repository;

import ifi.jee.CuiCui.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "select user from User user order by user.nom desc")
    public Page<User> listUser(Pageable pageable);
}
