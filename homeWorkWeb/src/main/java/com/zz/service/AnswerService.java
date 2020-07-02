package com.zz.service;/**
 * @Description: 描述
 * @Author: Bsea
 * @CreateDate: 2019/12/27
 */

import com.zz.entity.Answer;
import com.zz.repository.AnswerRepository;
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
public class AnswerService {
    @Resource
    AnswerRepository answerRepository;

    public Page<Answer> getAnswerAll(Pageable pageable){
       return answerRepository.findAll(pageable);
    }

    public Answer getAnswerById(String id){
        return answerRepository.getOne(id);
    }


    public Answer add(Answer Answer){
        return answerRepository.save(Answer);
    }


    public void delete(Answer Answer){
         answerRepository.delete(Answer);
    }
}
