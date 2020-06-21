package com.xsz.vote.service.impl;

import com.xsz.common.domain.QueryRequest;
import com.xsz.common.domain.Tree;
import com.xsz.common.service.impl.BaseService;
import com.xsz.common.util.MD5Utils;

import com.xsz.common.util.TreeUtils;
import com.xsz.system.domain.Dict;
import com.xsz.system.domain.Menu;
import com.xsz.system.domain.User;
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
            log.error("获取投票项目信息失败", e);
            return new ArrayList<>();
        }
    }



    @Override
    public void addVote(Vote vote) {
        vote.setCreatetime(new Date());
        save(vote);
    }

    @Override
    public void updateVote(Vote vote) {
        vote.setCreatetime(new Date());
        this.updateNotNull(vote);
    }

    @Override
    public void deleteVotes(String VoteIds) {
        List<String> list = Arrays.asList(VoteIds.split(","));
        this.batchDelete(list, "id", Vote.class);
    }

    @Override
    public Vote findById(Long id) {
        return this.selectByKey(id);
    }

    @Override
    public Tree<Vote> getVoteButtonTree() {
        List<Tree<Vote>> trees = new ArrayList<>();
        List<Vote> voteList = this.findAllVotes(new Vote(),null);
        log.debug("voteList--size---"+voteList.size());
        buildTrees(trees, voteList);
        return TreeUtils.build(trees);
    }

    private void buildTrees(List<Tree<Vote>> trees, List<Vote> voteList) {
        voteList.forEach(vote -> {
            Tree<Vote> tree = new Tree<>();
            tree.setId(vote.getId().toString());
//            tree.setParentId("");
            tree.setText(vote.getTitle());
            trees.add(tree);
        });
    }
}
