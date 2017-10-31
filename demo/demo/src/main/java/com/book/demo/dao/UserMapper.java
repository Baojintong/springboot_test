package com.book.demo.dao;

import com.book.demo.domain.Book;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<Book> findBookByName(Map m);

    Integer saveBook(Map m);

    Integer login(Map m);
}
