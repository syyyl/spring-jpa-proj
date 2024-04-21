package com.ohgiraffers.springdatajpaproj.book.repository;

import com.ohgiraffers.springdatajpaproj.book.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    @Query(
            value = "SELECT member_name, join_date, loan_yn, loaned_book FROM member_info ORDER BY member_code",
            nativeQuery = true
    )
    List<Member> findAllMember();
}
