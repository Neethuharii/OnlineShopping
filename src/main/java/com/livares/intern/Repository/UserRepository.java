package com.livares.intern.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livares.intern.Model.user;

@Repository
public interface UserRepository extends JpaRepository<user, Long> {

}
