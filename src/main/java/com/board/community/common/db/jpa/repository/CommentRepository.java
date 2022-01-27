package com.board.community.common.db.jpa.repository;

import com.board.community.common.db.jpa.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findAllByBoardIdx(Long id);

    Integer countByBoardIdxAndDepth(long boardIdx, Integer depth);
    @Transactional
    @Modifying
    @Query(value = "update tbl_comment set commentGroup = idx where depth = 0", nativeQuery = true)
    void updateCommentGroup();

    Integer countByBoardIdxAndDepthAndCommentGroup(long boardIdx, Integer depth, Integer commentGroup);
}
