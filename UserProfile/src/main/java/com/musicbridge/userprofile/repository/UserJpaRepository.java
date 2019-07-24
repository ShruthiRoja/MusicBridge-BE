package com.musicbridge.userprofile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; 

import com.musicbridge.userprofile.dto.UserDTO;

@Repository
public interface UserJpaRepository extends JpaRepository<UserDTO,Long> {
	
	UserDTO findById(Long id);
	
	UserDTO findByName(String name);
}
