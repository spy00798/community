package com.board.community.common.db.jpa.repository;

import com.board.community.common.db.jpa.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
}
