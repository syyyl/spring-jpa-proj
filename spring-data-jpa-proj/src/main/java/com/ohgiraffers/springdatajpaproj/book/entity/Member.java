package com.ohgiraffers.springdatajpaproj.book.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "member_info")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    private String memberName;
    private int joinDate;
    private boolean loanYn;
    private int loanedBook;
}
