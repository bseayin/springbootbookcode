package com.zz.info.service;

import com.zz.info.domain.LikeDO;

import java.util.List;
import java.util.Map;

/**
 * 信息发布内容/信息评论 点赞
 * 
 * @author jwh
 * @email 1304058324@qq.com
 * @date 2020-12-06 18:20:48
 */
public interface LikeService {
	
	List<LikeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int toggleLike(String likeType,Long contentId,String userId);
	
	int remove(String likeType,Long contentId,String userId);
	
}
