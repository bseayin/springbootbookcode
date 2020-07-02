package com.zz.service;

import com.zz.entity.WordBook;
import com.zz.repository.WordBookRepository;
import com.zz.util.KeyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WordBookService {

    @Resource
    WordBookRepository wordBookRepository;

    public List<WordBook> getByUser(String uid){
        return  wordBookRepository.findByUserId(uid);
    };


    public WordBook save(WordBook wordBook){
        wordBook.setId(KeyUtil.genUniqueKey());
        return  wordBookRepository.save(wordBook);
    };
}
