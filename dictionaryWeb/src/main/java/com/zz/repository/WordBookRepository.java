package com.zz.repository;

import com.zz.entity.WordBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordBookRepository extends JpaRepository<WordBook,String> {
    List<WordBook> findByUserId(String userId);
}
