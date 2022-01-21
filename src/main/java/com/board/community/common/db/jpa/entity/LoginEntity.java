package com.board.community.common.db.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_user")
public class LoginEntity {

    @Id
    @Column(name = "idx", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;            // 회원 번호

    @Column(name = "user_id", nullable = false, unique = true)
    private String userId;      // 아이디

    @Column(name = "user_pw", nullable = false)
    private String password;    // 패스워드

    @Column(name = "user_nm", nullable = false)
    private String userName;    // 사용자 이름
}
