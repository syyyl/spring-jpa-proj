package com.ohgiraffers.springdatajpaproj.book.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookDTO {

    private int bookCode;
    private String bookName;
    private String publisher;
    private int releaseDate;
    private int amount;
    private int categoryCode;
    private boolean loanableYn;

    public BookDTO() {}


}
