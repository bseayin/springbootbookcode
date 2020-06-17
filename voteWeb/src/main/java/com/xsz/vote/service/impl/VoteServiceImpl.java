package com.xsz.vote.service.impl;

import com.xsz.common.domain.QueryRequest;
import com.xsz.common.service.impl.BaseService;
import com.xsz.common.util.MD5Utils;

import com.xsz.system.domain.Dict;
import com.xsz.vote.dao.VoteMapper;
import com.xsz.vote.domain.Vote;
import com.xsz.vote.service.VoteService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service("voteService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class VoteServiceImpl extends BaseService<Vote> implements VoteService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private VoteMapper voteMapper;


    @Override
    public Vote findByName(String VoteName) {
        return null;
    }

    @Override
    public List<Vote> findAllVotes(Vote vote, QueryRequest request) {
        try {
            Example example = new Example(Vote.class);
            Example.Criteria criteria = example.createCriteria();
            if (StringUtils.isNotBlank(vote.getTitle())) {
                criteria.andCondition("title=",vote.getTitle());
            }

            example.setOrderByClause("CREATETIME");
            return this.selectByExample(example);
        } catch (Exception e) {
            log.error("获取字典信息失败", e);
            return new ArrayList<>();
        }
    }



    @Override
    public void addVote(Vote vote) {
        save(vote);
    }

    @Override
    public void updateVote(Vote Vote, Long[] roles) {

    }

    @Override
    public void deleteVotes(String VoteIds) {

    }
}
