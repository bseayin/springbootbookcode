package com.zz.service;/**
 * @Description: 描述
 * @Author: Bsea
 * @CreateDate: 2019/12/27
 */

import com.zz.entity.Comments;
import com.zz.repository.CommentsRepository;
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
public class CommentsService {
    @Resource
    CommentsRepository commentsRepository;

    public Page<Comments> getCommentsAll(Pageable pageable){
       return commentsRepository.findAll(pageable);
    }

    public Comments getCommentsById(String id){
        return commentsRepository.getOne(id);
    }


    public Comments add(Comments Comments){
        return commentsRepository.save(Comments);
    }


    public void delete(Comments Comments){
         commentsRepository.delete(Comments);
    }
}
