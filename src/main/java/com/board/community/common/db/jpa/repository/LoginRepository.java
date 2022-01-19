package com.board.community.common.db.jpa.repository;


import com.board.community.common.db.jpa.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<LoginEntity, Long> {
    Optional<LoginEntity> findByUserIdAndPassword(String userId, String password);
}
