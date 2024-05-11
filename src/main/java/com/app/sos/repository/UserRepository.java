package com.app.sos.repository;

import com.app.sos.model.User;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE User u SET u.id = :newId WHERE u.id = :oldId")
    void updateUserId(Long oldId, Long newId);

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE User ALTER COLUMN id RESTART WITH 1", nativeQuery = true)
    void resetIdSequence();
}

