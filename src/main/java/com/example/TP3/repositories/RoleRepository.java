package com.example.TP3.repositories;

import com.example.TP3.entities.Role;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByNomRole(String nomRole);
}
