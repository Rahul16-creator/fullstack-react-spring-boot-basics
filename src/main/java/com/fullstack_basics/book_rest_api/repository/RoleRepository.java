package com.fullstack_basics.book_rest_api.repository;

import com.fullstack_basics.book_rest_api.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    
}
