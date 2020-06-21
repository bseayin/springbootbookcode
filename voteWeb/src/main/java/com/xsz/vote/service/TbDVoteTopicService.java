package com.xsz.vote.service;

import com.xsz.common.domain.QueryRequest;
import com.xsz.common.domain.Tree;
import com.xsz.common.service.IService;

import com.xsz.vote.domain.Vote;
import com.xsz.vote.domain.VoteTopic;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Bsea
 * @since 2020-06-17
 */
@CacheConfig(cacheNames = "VoteTopicService")
public interface TbDVoteTopicService extends IService<VoteTopic> {
    @Cacheable(key = "#p0.toString() + (#p1 != null ? #p1.toString() : '')")
    List<VoteTopic> findAllVoteTopics(VoteTopic VoteTopic, QueryRequest request);

    @CacheEvict(allEntries = true)
    public void addVoteTopic(VoteTopic voteTopic);

    @CacheEvict(key = "#p0", allEntries = true)
    public void updateVoteTopic(VoteTopic voteTopic);



    @CacheEvict(key = "#p0", allEntries = true)
    void deleteVoteTopics(String voteTopicIds);

    @Cacheable(key = "#p0")
    public VoteTopic findById(Long id);


    Tree<VoteTopic> getVoteTopicButtonTree();

}
