package com.xsz.vote.service;

import com.xsz.common.domain.QueryRequest;
import com.xsz.common.service.IService;
import com.xsz.vote.domain.VoteTopicOption;
import com.xsz.vote.domain.VoteTopicOption;
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
@CacheConfig(cacheNames = "TbDVoteTopicOptionsService")
public interface TbDVoteTopicOptionsService extends IService<VoteTopicOption> {

    @Cacheable(key = "#p0.toString() + (#p1 != null ? #p1.toString() : '')")
    List<VoteTopicOption> findAllVoteTopicOptions(VoteTopicOption VoteTopicOption, QueryRequest request);

    @CacheEvict(allEntries = true)
    public void addVoteTopicOption(VoteTopicOption VoteTopicOption);

    @CacheEvict(key = "#p0", allEntries = true)
    void updateVoteTopicOption(VoteTopicOption VoteTopicOption);

    @CacheEvict(key = "#p0", allEntries = true)
    void deleteVoteTopicOptions(String VoteTopicOptionIds);

    @Cacheable(key = "#p0")
    VoteTopicOption findById(Long id);

}
