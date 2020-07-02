package com.zz.repository;/**
 * @Description: 描述
 * @Author: Bsea
 * @CreateDate: 2019/12/27
 */

import com.zz.entity.Answer;
import com.zz.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description: java类作用描述
 * @Author: Bsea
 * @CreateDate: 2019/12/27$ 21:08$
 */
public interface CommentsRepository extends JpaRepository<Comments,String> {

}
