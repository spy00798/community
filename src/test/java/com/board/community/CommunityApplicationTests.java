package com.board.community;

import com.board.community.common.db.jpa.entity.BoardEntity;
import com.board.community.common.db.jpa.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class CommunityApplicationTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void jpaTest() {
        BoardEntity boardEntity = new BoardEntity();

        boardEntity.setTitle("abc");
        boardEntity.setContent("hello world");
        boardEntity.setBdDate(new Date());
        boardRepository.save(boardEntity);
    }

}
