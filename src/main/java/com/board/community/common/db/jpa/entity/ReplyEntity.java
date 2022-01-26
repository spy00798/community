package com.board.community.common.db.jpa.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_reply")
@DynamicUpdate
public class ReplyEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;           // 답글번호

    @Lob
    @Column
    private String content;     // 답글 내용

    @Column
    @Temporal(TemporalType.DATE)
    private Date reDate;        // 답글 작성일

    @Column
    private String writer;      // 답글 작성자

    @Column
    private String refType;     // 참조 타입 (댓글 or 답글)

//    @Column
//    private long boardIdx;

//    @Column
//    private long refIdx;        // 원 답글 번호

    @Column
    private long commentIdx;        // 원 댓글 번호

    @Column(name = "user_id", nullable = false)
    private String userId;      // 작성자 ID

}
