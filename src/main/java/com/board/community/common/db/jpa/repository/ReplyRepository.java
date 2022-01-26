package com.board.community.common.db.jpa.repository;


import com.board.community.common.db.jpa.entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {

       List<ReplyEntity> findAllByBoardIdx(long id);
}
