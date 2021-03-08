package com.fullstack_basics.book_rest_api.repository;

import com.fullstack_basics.book_rest_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    
    @Query("FROM User WHERE email=:email")
    User findByEmail(@Param("email") String email);
}
