-- CREATE DATABASE proj1;

CREATE TABLE `BOOK_INFO`
(
    `BOOK_CODE` MEDIUMINT NOT NULL AUTO_INCREMENT COMMENT '도서코드',
    `BOOK_NAME` VARCHAR(50) NOT NULL COMMENT '도서명',
    `PUBLISHER` VARCHAR(10) NOT NULL COMMENT '출판사',
    `RELEASE_DATE` VARCHAR(8) NOT NULL COMMENT '출간일',
    `AMOUNT` VARCHAR(15) NOT NULL COMMENT '보유권수',
    `CATEGORY_CODE` VARCHAR(5) NOT NULL COMMENT '분야코드',
    `LOANABLE_YN` VARCHAR(5) NOT NULL COMMENT '대출가능여부',
    PRIMARY KEY ( `BOOK_CODE` )
)
    COMMENT = '도서정보';

INSERT INTO BOOK_INFO (BOOK_NAME, PUBLISHER, RELEASE_DATE, AMOUNT, CATEGORY_CODE, LOANABLE_YN) VALUES
                                                                                                   ('도서1', '출판사1', '20230204', 3, 1, 'Y'),
                                                                                                   ('도서2', '출판사2', '20120524', 2, 2, 'Y'),
                                                                                                   ('도서3', '출판사2', '20130906', 1, 2, 'N'),
                                                                                                   ('도서4', '출판사3', '20221012', 1, 3, 'N'),
                                                                                                   ('도서5', '출판사1', '20211113', 1, 1, 'Y'),
                                                                                                   ('도서6', '출판사4', '20060708', 3, 4, 'Y'),
                                                                                                   ('도서7', '출판사5', '20081230', 3, 4, 'Y'),
                                                                                                   ('도서8', '출판사1', '20161116', 2, 5, 'Y'),
                                                                                                   ('도서9', '출판사2', '20190413', 2, 5, 'Y'),
                                                                                                   ('도서10', '출판사5', '20170829', 2, 1, 'N'),
                                                                                                   ('도서11', '출판사5', '20210228', 2, 5, 'Y'),
                                                                                                   ('도서12', '출판사4', '20010912', 1, 2, 'Y'),
                                                                                                   ('도서13', '출판사3', '20200212', 2, 3, 'Y'),
                                                                                                   ('도서14', '출판사6', '20240207', 1, 2, 'Y'),
                                                                                                   ('도서15', '출판사6', '20181019', 2, 4, 'N'),
                                                                                                   ('도서16', '출판사1', '20110516', 2, 5, 'Y'),
                                                                                                   ('도서17', '출판사2', '20150829', 2, 1, 'Y'),
                                                                                                   ('도서18', '출판사5', '20120809', 1, 3, 'Y'),
                                                                                                   ('도서19', '출판사6', '20210612', 3, 2, 'Y'),
                                                                                                   ('도서20', '출판사4', '20160514', 3, 2, 'Y'),
                                                                                                   ('도서21', '출판사3', '20220713', 4, 4, 'Y'),
                                                                                                   ('도서22', '출판사3', '20071012', 3, 1, 'Y'),
                                                                                                   ('도서23', '출판사1', '20091224', 2, 5, 'N'),
                                                                                                   ('도서24', '출판사4', '20180112', 1, 5, 'Y'),
                                                                                                   ('도서25', '출판사6', '20200125', 1, 1, 'Y');
commit;

CREATE TABLE `MEMBER_INFO`
(
    `MEMBER_CODE` MEDIUMINT NOT NULL AUTO_INCREMENT COMMENT '회원코드',
    `MEMBER_NAME` VARCHAR(50) NOT NULL COMMENT '회원이름',
    `JOIN_DATE` VARCHAR(8) NOT NULL COMMENT '회원가입일',
    `LOAN_YN` VARCHAR(5) NOT NULL COMMENT '대출중여부',
    `LOANED_BOOK` VARCHAR(20) COMMENT '대출도서',
    PRIMARY KEY ( `MEMBER_CODE` )
)
    COMMENT = '회원정보';

INSERT INTO MEMBER_INFO (MEMBER_NAME, JOIN_DATE, LOAN_YN, LOANED_BOOK) VALUES
                                                                           ('회원1', '20201203', 'Y', 3),
                                                                           ('회원2', '20210123', 'Y', 1),
                                                                           ('회원3', '20221114', 'N', null),
                                                                           ('회원4', '20190913', 'Y', 15),
                                                                           ('회원5', '20230420', 'Y', 21),
                                                                           ('회원6', '20190211', 'N', null),
                                                                           ('회원7', '20220617', 'Y', 13),
                                                                           ('회원8', '20210826', 'Y', 24);
commit;

-- DROP TABLE IF EXISTS `MEMBER_INFO`;

GRANT ALL PRIVILEGES ON proj1.* TO 'ohgiraffers'@'%';