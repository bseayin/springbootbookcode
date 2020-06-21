package com.xsz.vote.service;


import com.xsz.common.domain.QueryRequest;
import com.xsz.common.service.IService;
import com.xsz.vote.domain.VoteResult;
import com.xsz.vote.domain.VoteResult;
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
@CacheConfig(cacheNames = "TbDVoteResultService")
public interface TbDVoteResultService extends IService<VoteResult> {
    @Cacheable(key = "#p0.toString() + (#p1 != null ? #p1.toString() : '')")
    List<VoteResult> findAllVoteResults(VoteResult VoteResult, QueryRequest request);

    @CacheEvict(allEntries = true)
    public void addVoteResult(VoteResult VoteResult);

    @CacheEvict(key = "#p0", allEntries = true)
    void updateVoteResult(VoteResult VoteResult);

    @CacheEvict(key = "#p0", allEntries = true)
    void deleteVoteResults(String VoteResultIds);

    @Cacheable(key = "#p0")
    VoteResult findById(Long id);

}
