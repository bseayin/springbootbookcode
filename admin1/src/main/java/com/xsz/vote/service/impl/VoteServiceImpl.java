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
import com.xsz.vote.vo.VoteVO;
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

/**
 * Bsea
 * @date 2020.06.25
 */
@Service("voteService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class VoteServiceImpl extends BaseService<Vote> implements VoteService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private VoteMapper voteMapper;


    /**
     *  查询所有需要投票的选项
     * @param vote
     * @param request
     * @return
     */
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

    /**
     * 获取投票项目列表
     * @return
     */
    @Override
    public Tree<Vote> getVoteButtonTree() {
        List<Tree<Vote>> trees = new ArrayList<>();
        List<Vote> voteList = this.findAllVotes(new Vote(),null);
        log.debug("voteList--size---"+voteList.size());
        buildTrees(trees, voteList);
        return TreeUtils.build(trees);
    }
    /**
     * 获取投票结果列表
     * @return
     */
    @Override
    public List<VoteVO> findVoteVOs(Integer status) {
        return voteMapper.findVoteVOs(status);
    }

    @Override
    public List<VoteVO> findResultVoteVOs() {
        return voteMapper.findResultVoteVOs();
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
