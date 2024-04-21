package com.ohgiraffers.springdatajpaproj.book.controller;

import com.ohgiraffers.springdatajpaproj.book.dto.BookDTO;
import com.ohgiraffers.springdatajpaproj.book.dto.MemberDTO;
import com.ohgiraffers.springdatajpaproj.book.repository.BookRepository;
import com.ohgiraffers.springdatajpaproj.book.service.BookService;
import com.ohgiraffers.springdatajpaproj.common.Pagenation;
import com.ohgiraffers.springdatajpaproj.common.PagingButton;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/{bookCode}")
    public String findBookByCode(@PathVariable int bookCode, Model model) {

        BookDTO book = bookService.FindBookByCode(bookCode);

        model.addAttribute("book", book);

        return "book/detail";
    }

    /* Sort */

//    @GetMapping("/list")
//    public String findBookList(Model model) {
//        List<BookDTO> bookList = bookService.findBookList();
//        model.addAttribute("bookList", bookList);
//        return "book/list";
//    }

    /* Pageable */

    @GetMapping("/list")
    public String findBookList(@PageableDefault Pageable pageable, Model model) {
        log.info("pageable : {}", pageable);

        Page<BookDTO> bookList = bookService.findBookList(pageable);

        log.info("조회된 내용 : {}", bookList.getContent());
        log.info("총 페이지 수 : {}", bookList.getTotalPages());
        log.info("총 메뉴 수 : {}", bookList.getTotalElements());
        log.info("해당 페이지에 표시 될 요소 수 : {}", bookList.getSize());
        log.info("해당 페이지에 실제 요소 수:{}",bookList.getNumberOfElements());
        log.info("첫 페이지 여부 : {}", bookList.isFirst());
        log.info("마지막 페이지 여부 : {}", bookList.isLast());
        log.info("정렬 방식 : {}", bookList.getSort());
        log.info("여러 페이지 중 현재 인덱스 : {}", bookList.getNumber());
        PagingButton paging = Pagenation.getPagingButtonInfo(bookList);
        model.addAttribute("paging", paging);
        model.addAttribute("bookList", bookList);
        return "book/list";
    }

    @GetMapping("/querymethod")
    public void querymethodPage(){}


    @GetMapping("/search")
    public String findByAmount(
            @RequestParam Integer amount, Model model
    ) {
        List<BookDTO> bookList = bookService.findByAmount(amount);
        model.addAttribute("bookList", bookList);
        model.addAttribute("amount", amount);
        return "book/searchResult";
    }

    @GetMapping("/regist")
    public void registPage() {}

    @GetMapping("/member")
    @ResponseBody
    public List<MemberDTO> findMemberList() {
        return bookService.findAllMember();
    }

    @PostMapping("/regist")
    public String registBook(BookDTO newBook) {
        bookService.registBook(newBook);
        return "redirect:/book/list";
    }

    @GetMapping("/modify")
    public void modifyPage() {}

    @PostMapping("/modify")
    public String modifyPage(BookDTO modifyBook) {
        bookService.modifyBook(modifyBook);
        return "redirect:/book/" + modifyBook.getBookCode();
    }

    @GetMapping("/delete")
    public void deletePage() {}

    @PostMapping("/delete")
    public String deleteBook(@RequestParam Integer bookCode) {
        bookService.deleteBook(bookCode);
        return "redirect:/book/list";
    }



}

