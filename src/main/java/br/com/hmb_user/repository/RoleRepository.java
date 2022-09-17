package br.com.hmb_user.repository;

import br.com.hmb_user.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long > {
}
