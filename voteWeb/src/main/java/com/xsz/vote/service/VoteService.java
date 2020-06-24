package com.xsz.vote.service;

import com.xsz.common.domain.QueryRequest;
import com.xsz.common.domain.Tree;
import com.xsz.common.service.IService;

import com.xsz.system.domain.Dict;
import com.xsz.system.domain.Menu;
import com.xsz.vote.domain.Vote;
import com.xsz.vote.vo.VoteVO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@CacheConfig(cacheNames = "VoteService")
public interface VoteService extends IService<Vote> {


    @Cacheable(key = "#p0.toString() + (#p1 != null ? #p1.toString() : '')")
    List<Vote> findAllVotes(Vote vote, QueryRequest request);

    @CacheEvict(allEntries = true)
    public void addVote(Vote vote);

    @CacheEvict(key = "#p0", allEntries = true)
    void updateVote(Vote vote);

    @CacheEvict(key = "#p0", allEntries = true)
    void deleteVotes(String VoteIds);

    @Cacheable(key = "#p0")
    Vote findById(Long id);

    Tree<Vote> getVoteButtonTree();

    public List<VoteVO> findVoteVOs(Integer status);

    public List<VoteVO> findResultVoteVOs();


}
