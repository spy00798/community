package com.board.community;

import com.board.community.common.db.jpa.entity.BoardEntity;
import com.board.community.common.db.jpa.entity.LoginEntity;
import com.board.community.common.db.jpa.repository.BoardRepository;
import com.board.community.common.db.jpa.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class CommunityApplicationTests {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private LoginRepository loginRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void boardTest() {
        BoardEntity boardEntity = new BoardEntity();

        boardEntity.setTitle("abc");
        boardEntity.setContent("hello world");
        boardEntity.setBdDate(new Date());
        boardRepository.save(boardEntity);
    }

    @Test
    void createTestUser() {
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setUserId("test");
        loginEntity.setPassword("123");
        loginEntity.setUserName("test");

        loginRepository.save(loginEntity);

    }


}
