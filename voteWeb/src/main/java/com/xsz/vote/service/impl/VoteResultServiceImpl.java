package com.xsz.vote.service.impl;

import com.xsz.common.domain.QueryRequest;
import com.xsz.common.domain.Tree;
import com.xsz.common.service.impl.BaseService;
import com.xsz.common.util.TreeUtils;
import com.xsz.vote.dao.VoteMapper;
import com.xsz.vote.domain.Vote;
import com.xsz.vote.domain.VoteResult;
import com.xsz.vote.service.TbDVoteResultService;
import com.xsz.vote.service.VoteService;
import org.apache.commons.lang3.StringUtils;
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

@Service("voteResultService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class VoteResultServiceImpl extends BaseService<VoteResult> implements TbDVoteResultService {

    private Logger log = LoggerFactory.getLogger(this.getClass());


    @Override
    public List<VoteResult> findAllVoteResults(VoteResult voteResult, QueryRequest request) {
        try {
            Example example = new Example(Vote.class);
            Example.Criteria criteria = example.createCriteria();
            if (voteResult.getVoteid()!=null) {
                criteria.andCondition("VOTEID=",voteResult.getVoteid());
            }

            example.setOrderByClause("CREATETIME");
            return this.selectByExample(example);
        } catch (Exception e) {
            log.error("获取投票项目信息失败", e);
            return new ArrayList<>();
        }
    }

    @Override
    public void addVoteResult(VoteResult voteResult) {
        voteResult.setCreatetime(new Date());
        save(voteResult);
    }

    @Override
    public void updateVoteResult(VoteResult voteResult) {
        voteResult.setCreatetime(new Date());
        this.updateNotNull(voteResult);
    }

    @Override
    public void deleteVoteResults(String voteResultIds) {
        List<String> list = Arrays.asList(voteResultIds.split(","));
        this.batchDelete(list, "id", VoteResult.class);
    }

    @Override
    public VoteResult findById(Long id) {
        return this.selectByKey(id);
    }
}
