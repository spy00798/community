package com.board.community.common.db.jpa.repository;

import com.board.community.common.db.jpa.entity.BoardEntity;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    List<BoardEntity> findByTitleContainingOrWriterContainingIgnoreCase (String keyword, String keyword2); //LINE:: 제목 or 작성자 기준으로 검색
    List<BoardEntity> findByTitleContainingIgnoreCase(@Param(value = "keyword") String keyword); //LINE:: 제목 기준으로 검색
    List<BoardEntity> findByWriterContainingIgnoreCase(@Param(value = "keyword") String keyword); //LINE:: 작성자 기준으로 검색
}
