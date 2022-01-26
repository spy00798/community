package com.board.community.common.db.jpa.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_comment")
@DynamicUpdate
public class CommentEntity {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;               // 댓글번호

    @Column(nullable = false)
    private String writer;          // 댓글작성자

    @Lob
    @Column(nullable = false)
    private String comment;         // 댓글내용

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentDate;     // 댓글 작성일

    @Column(nullable = false)
    private long boardIdx;          // 게시글 번호

    @Column(name = "user_id", nullable = false)
    private String userId;           // 작성자 ID

}
