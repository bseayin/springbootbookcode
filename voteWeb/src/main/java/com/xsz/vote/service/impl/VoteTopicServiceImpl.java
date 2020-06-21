package com.xsz.vote.service.impl;

import com.xsz.common.domain.QueryRequest;
import com.xsz.common.domain.Tree;
import com.xsz.common.service.impl.BaseService;
import com.xsz.common.util.TreeUtils;
import com.xsz.vote.dao.VoteTopicMapper;
import com.xsz.vote.domain.Vote;
import com.xsz.vote.domain.VoteTopic;
import com.xsz.vote.service.TbDVoteTopicService;
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

@Service("voteTopicService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class VoteTopicServiceImpl extends BaseService<VoteTopic> implements TbDVoteTopicService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private VoteTopicMapper voteTopicMapper;


    @Override
    public List<VoteTopic> findAllVoteTopics(VoteTopic voteTopic, QueryRequest request) {
        try {
            Example example = new Example(Vote.class);
            Example.Criteria criteria = example.createCriteria();
            if (StringUtils.isNotBlank(voteTopic.getTitle())) {
                criteria.andCondition("title=",voteTopic.getTitle());
            }

            example.setOrderByClause("CREATETIME");
            return this.selectByExample(example);
        } catch (Exception e) {
            log.error("获取投票项目信息失败", e);
            return new ArrayList<>();
        }
    }

    @Override
    public void addVoteTopic(VoteTopic voteTopic) {
        voteTopic.setCreatetime(new Date());
        save(voteTopic);
    }

    @Override
    public void updateVoteTopic(VoteTopic voteTopic) {
        voteTopic.setCreatetime(new Date());
        this.updateNotNull(voteTopic);
    }

    @Override
    public void deleteVoteTopics(String voteTopicIds) {
        List<String> list = Arrays.asList(voteTopicIds.split(","));
        this.batchDelete(list, "id", VoteTopic.class);
    }

    @Override
    public VoteTopic findById(Long id) {
        return this.selectByKey(id);
    }

    @Override
    public Tree<VoteTopic> getVoteTopicButtonTree() {
        List<Tree<VoteTopic>> trees = new ArrayList<>();
        List<VoteTopic> voteList = this.findAllVoteTopics(new VoteTopic(),null);

        buildTrees(trees, voteList);
        return TreeUtils.build(trees);
    }

    private void buildTrees(List<Tree<VoteTopic>> trees, List<VoteTopic> voteList) {
        voteList.forEach(vote -> {
            Tree<VoteTopic> tree = new Tree<>();
            tree.setId(vote.getId().toString());
//            tree.setParentId("");
            tree.setText(vote.getTitle());
            trees.add(tree);
        });
    }
}
