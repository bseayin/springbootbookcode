package com.zz.service;/**
 * @Description: 描述
 * @Author: Bsea
 * @CreateDate: ${Date}
 */

import com.zz.entity.Member;
import com.zz.repository.MemberRepository;
import com.zz.util.KeyUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: java类作用描述
 * @Author: Bsea
 * @CreateDate: 2019/10/13$ 11:07$
 */
@Service
public class MemberService {
    @Resource
    MemberRepository memberRepository;

    /**
     * 添加会员
     *
     */
    public Member add(Member member){
        String key= KeyUtil.genUniqueKey();
        member.setId(key);
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        member.setCreateTime(format.format(new Date()));
        return  memberRepository.save(member);
    }

    /**
     * 修改会员
     *
     */
    @Transactional(rollbackFor = Exception.class)
    public int update(Member member){
        return  memberRepository.update(member);
    }

    /**
     * 删除会员
     *
     */
    public void remove(String id){

        memberRepository.deleteById(id);
    }



    /**
     * 查询会员
     *
     */
    public Page<Member> showall( int page, int size){
        /**
         * Sort.Direction.DESC 表示 从大到小
         * Sort.Direction.ASC  表示 从小到大
         */
        Sort sort=new Sort(Sort.Direction.DESC,"createTime");
        Pageable pageable= PageRequest.of(page,size,sort);

        return  memberRepository.findAll(pageable);
    }

    /**
     * 根据名字查询会员
     *
     */
    public Member showByName( String name){

        return  memberRepository.findByName(name);
    }
}
