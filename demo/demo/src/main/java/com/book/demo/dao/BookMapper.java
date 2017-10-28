package com.book.demo.dao;

import com.book.demo.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BookMapper {

    List<Book> findBookByName(Map m);

    Integer saveBook(Map m);
}
