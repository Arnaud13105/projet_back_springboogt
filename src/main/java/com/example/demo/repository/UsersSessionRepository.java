package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.UsersSession;

public interface UsersSessionRepository extends JpaRepository<UsersSession, Long>{

}
