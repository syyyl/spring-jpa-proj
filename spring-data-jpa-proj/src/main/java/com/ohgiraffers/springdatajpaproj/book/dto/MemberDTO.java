package com.ohgiraffers.springdatajpaproj.book.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {

    private String memberName;
    private int joinDate;
    private boolean loanYn;
    private int loanedBook;

}
