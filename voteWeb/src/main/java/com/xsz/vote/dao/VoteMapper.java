package com.xsz.vote.dao;

import com.xsz.common.config.MyMapper;
import com.xsz.system.domain.User;
import com.xsz.vote.domain.Vote;
import com.xsz.vote.vo.VoteVO;

import java.util.List;

public interface VoteMapper extends MyMapper<Vote> {

    public List<VoteVO> findVoteVOs(Integer status);
    public List<VoteVO> findResultVoteVOs();

}