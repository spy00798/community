package com.board.community.common.db.jpa.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_board")
public class BoardEntity {

    @Id
    @Column(name = "idx", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;                 // 게시글 번호(순서)

    @Column(name = "title", nullable = false)
    private String title;            // 게시글 제목

    @Lob
    @Column(name = "content", nullable = false)
    private String content;          // 게시글 내용

    @Column(name = "bd_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date bdDate;             // 게시글 등록일

    @Column(name = "writer", nullable = false)
    private String writer;

    @Column(name = "user_id", nullable = false)
    private String userId;
}
