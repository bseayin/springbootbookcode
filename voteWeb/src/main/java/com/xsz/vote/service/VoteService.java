package com.xsz.vote.service;

import com.xsz.common.domain.QueryRequest;
import com.xsz.common.service.IService;

import com.xsz.system.domain.Dict;
import com.xsz.vote.domain.Vote;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@CacheConfig(cacheNames = "VoteService")
public interface VoteService extends IService<Vote> {
    Vote findByName(String VoteName);

    @Cacheable(key = "#p0.toString() + (#p1 != null ? #p1.toString() : '')")
    List<Vote> findAllVotes(Vote vote, QueryRequest request);

    @CacheEvict(allEntries = true)
    void addVote(Vote Vote, Long[] roles);

    @CacheEvict(key = "#p0", allEntries = true)
    void updateVote(Vote Vote, Long[] roles);

    @CacheEvict(key = "#p0", allEntries = true)
    void deleteVotes(String VoteIds);


}