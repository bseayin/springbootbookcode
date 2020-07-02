package com.zz.service;/**
 * @Description: 描述
 * @Author: Bsea
 * @CreateDate: 2019/12/27
 */

import com.zz.entity.Question;
import com.zz.repository.QuestionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description: java类作用描述
 * @Author: Bsea
 * @CreateDate: 2019/12/27$ 21:09$
 */
@Service
public class QuestionService {
    @Resource
    QuestionRepository questionRepository;

    public Page<Question> getQuestionAll(Pageable pageable){
       return questionRepository.findAll(pageable);
    }

    public Question getQuestionById(String id){
        return questionRepository.getOne(id);
    }


    public Question add(Question question){
        return questionRepository.save(question);
    }


    public void delete(Question question){
         questionRepository.delete(question);
    }
}
