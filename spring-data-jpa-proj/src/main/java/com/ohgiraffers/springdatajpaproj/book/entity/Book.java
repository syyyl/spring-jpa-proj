package com.ohgiraffers.springdatajpaproj.book.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book_info")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookCode;
    private String bookName;
    private String publisher;
    private int releaseDate;
    private int amount;
    private int categoryCode;
    private boolean loanableYn;

    public void modifyBookName(String bookName) {
        this.bookName = bookName;
    }

}
