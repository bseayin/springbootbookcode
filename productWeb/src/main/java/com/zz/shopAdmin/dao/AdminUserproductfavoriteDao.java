package com.zz.shopAdmin.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户收藏
 * @author jwh
 * @email 1304058324@qq.com
 * @date 2020-11-30 20:41:15
 */
@Mapper
public interface AdminUserproductfavoriteDao {

	int count(Map<String,Object> map);
	
}
