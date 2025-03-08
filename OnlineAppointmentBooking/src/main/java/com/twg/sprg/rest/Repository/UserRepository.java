package com.twg.sprg.rest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twg.sprg.rest.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
