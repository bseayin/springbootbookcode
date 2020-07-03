package com.zz.repository;

import com.zz.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: 会员
 * @Author: Bsea
 * @CreateDate: 2019/9/25$ 20:16$
 */
public interface MemberRepository extends JpaRepository<Member, String> {
    /**
     * 根据名字查找会员
     * @param name 名字
     * @return Member
     */
    public Member findByName(String name);

    /**
     *复杂JPA操作  使用@Query()自定义sql语句  根据业务id UId去更新整个实体
     * 删除和更新操作，需要@Modifying和@Transactional注解的支持
     *
     * 更新操作中 如果某个字段为null则不更新，否则更新【注意符号和空格位置】
     * @param member 对象
     * @return int 被修改数据 条数
     */
    @Modifying

    @Query("update tb_member tm set " +
            "tm.name = CASE WHEN :#{#m.name} IS NULL THEN tm.name ELSE :#{#m.name} END ," +
            "tm.phone =  CASE WHEN :#{#m.phone} IS NULL THEN tm.phone ELSE :#{#m.phone} END, " +
            "tm.sex =  CASE WHEN :#{#m.sex} IS NULL THEN tm.sex ELSE :#{#m.sex} END, " +
            "tm.age =  CASE WHEN :#{#m.age} <=0 THEN tm.age ELSE :#{#m.age} END " +
            "where tm.id = :#{#m.id}")
    int update(@Param("m") Member member);


}
