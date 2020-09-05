package com.xsz.vote.dao;

import com.xsz.common.config.MyMapper;
import com.xsz.system.domain.User;
import com.xsz.vote.domain.Vote;
import com.xsz.vote.vo.VoteVO;

import java.util.List;

/**
 * Bsea
 * 2020/06/27
 */
public interface VoteMapper extends MyMapper<Vote> {
    /**投票管理主页查询**/
    public List<VoteVO> findVoteVOs(Integer status);
    /**投票结果主页查询**/
    public List<VoteVO> findResultVoteVOs();

}