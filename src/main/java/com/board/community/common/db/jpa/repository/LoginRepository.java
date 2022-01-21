package com.board.community.common.db.jpa.repository;


import com.board.community.common.db.jpa.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Long> {
    Optional<LoginEntity> findByUserIdAndPassword(String userId, String password); //LINE:: ID와 패스워드가 일치한 지 확인

    Optional<LoginEntity> findByUserId(String userId); //LINE:: ID 중복체크 & ID가 등록되있는 ID 인지 확인
}
