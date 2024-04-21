package com.ohgiraffers.springdatajpaproj.book.service;

import com.ohgiraffers.springdatajpaproj.book.dto.BookDTO;
import com.ohgiraffers.springdatajpaproj.book.dto.MemberDTO;
import com.ohgiraffers.springdatajpaproj.book.entity.Book;
import com.ohgiraffers.springdatajpaproj.book.entity.Member;
import com.ohgiraffers.springdatajpaproj.book.repository.BookRepository;
import com.ohgiraffers.springdatajpaproj.book.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    public BookDTO FindBookByCode (int bookCode) {
        Book book = bookRepository.findById(bookCode)
                .orElseThrow(IllegalArgumentException::new);

        return modelMapper.map(book, BookDTO.class);
    }

    /* Sort */

//    public List<BookDTO> findBookList() {
//
//        List<Book> bookList
//                = bookRepository.findAll(Sort.by("bookCode").descending());
//
//        return bookList.stream()
//                .map(book -> modelMapper.map(book, BookDTO.class))
//                .collect(Collectors.toList());
//    }

    /* Pageable */

    public Page<BookDTO> findBookList(Pageable pageable) {
        pageable = PageRequest.of(
                pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("bookCode").descending()
        );

        Page<Book> bookList = bookRepository.findAll(pageable);
        return bookList.map(book -> modelMapper.map(book, BookDTO.class));
    }

    public List<BookDTO> findByAmount(Integer amount) {
        /*List<Book> bookList
        = bookRepository.findByAmountLessThan(amount);*/
        /*List<Book> bookList
        = bookRepository.findByAmountLessThanOrderByAmount(amount);*/
        List<Book> bookList
                = bookRepository.findByAmountLessThan(
                amount,
                Sort.by("amount").descending()
        );
        return bookList.stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }

    /* 5. JPQL or Native Query */

    public List<MemberDTO> findAllMember() {
        List<Member> memberList = memberRepository.findAllMember();

        return memberList.stream()
                .map(member -> modelMapper.map(member, MemberDTO.class))
                .collect(Collectors.toList());
    }


    @Transactional
    public void registBook(BookDTO newBook) {
        bookRepository.save(modelMapper.map(newBook, Book.class));
    }

    @Transactional
    public void modifyBook(BookDTO modifyBook) {
        Book searchBook
                = bookRepository.findById(modifyBook.getBookCode())
                .orElseThrow(IllegalArgumentException::new);
        searchBook.modifyBookName(modifyBook.getBookName());
    }

    @Transactional
    public void deleteBook(Integer bookCode) {
        bookRepository.deleteById(bookCode);
    }


}




