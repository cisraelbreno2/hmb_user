package br.com.hmb_user.repository;

import br.com.hmb_user.model.RoleModel;
import br.com.hmb_user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
}
