package com.ohgiraffers.springdatajpaproj.book.repository;

import com.ohgiraffers.springdatajpaproj.book.entity.Book;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByAmountLessThan(Integer amount);

    List<Book> findByAmountLessThanOrderByAmount(Integer amount);

    List<Book> findByAmountLessThan(Integer amount, Sort sort);

}
