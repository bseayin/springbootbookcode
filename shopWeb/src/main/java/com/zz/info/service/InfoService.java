package com.zz.info.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zz.common.dao.DictDao;
import com.zz.common.domain.DictDO;
import com.zz.info.dao.CommentDao;
import com.zz.info.dao.InfoDao;
import com.zz.info.domain.Comment;
import com.zz.info.domain.Info;
import com.zz.info.domain.api.Category;
import com.zz.info.domain.api.Index;
import com.zz.info.domain.api.IndexData;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InfoService {
	
	@Autowired
	private InfoDao infoDao;
	
    @Autowired
    private DictDao dictDao;
    
    @Autowired
    private CommentDao commentDao;
	@Value("${ImageHost}")
	String imageHost;
    
	
	public Info get(Long cid){
		return infoDao.get(cid);
	}
	
	public List<Info> list(Map<String, Object> map){
		return infoDao.listDisp(map);
	}
	
	public int count(Map<String, Object> map){
		return infoDao.count(map);
	}
	
	public int save(Info info){
		return infoDao.save(info);
	}
	
	public int update(Info info){
		return infoDao.update(info);
	}

	public int updateRead(Long cid ){
		return infoDao.updateRead(cid);
	}
	
	public int remove(Long cid){
		return infoDao.remove(cid);
	}
	
	public int batchRemove(Long[] cids){
		return infoDao.batchRemove(cids);
	}
	
	
	public List<Category> apiGetCategory() {
			// 查询列表数据
			Map<String, Object> map = new HashMap<>(16);
			map.put("type", "info_type");
			List<DictDO> dictList = dictDao.list(map);;
			List<Category> categoryList = new ArrayList<Category>();
			for (DictDO dict : dictList) {
				Category category = new Category();
				category.setId(dict.getValue());
				category.setName(dict.getName());
				categoryList.add(category);
			}
		return categoryList;
	}
	
	public HashMap apiGetIndex(String category, int pageSize, int pageIndex) {
		IndexData indexData = new IndexData();
		List<Index> indexList = new ArrayList<Index>();
		indexData.setList(indexList);
		
		Map<String, Object> map = new HashMap<>(16);
		map.put("categories", category);
		map.put("limit", pageSize);
		map.put("offset", (pageIndex-1)*pageSize);
		
		List<Info> infoList = this.infoDao.list(map);
				
		for (Info info : infoList) {
			Index index = new Index();
			index.setId(info.getCid().toString());
			index.setTitle(info.getTitle());
			index.setPhotoUrl(imageHost+info.getPhotoUrl());
			index.setRead(info.getHits()!=null?info.getHits().toString():"0");
			index.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").format(info.getGtmCreate()));
			
			// TODO: get comment count
			index.setCommentCount("0");			
			
			indexList.add(index);
		}
		
		
		
		int count = this.infoDao.count(map);
		indexData.setCount(Integer.toString(count));
		
		int pageNumber = count/pageSize + 1;
		indexData.setPage(Integer.toString(pageNumber));
		HashMap map1=new HashMap();
		HashMap map2=new HashMap();
		HashMap map3=new HashMap();
		map1.put("slider",indexData.getList());
		map1.put("hot_article",indexData.getList());
		map2.put("ad",map1);
		map2.put("slider",indexData.getList());
		map2.put("list",indexData.getList());
		map2.put("count",indexData.getCount());
		map2.put("page",indexData.getPage());
		return map2;
//		return indexData;
	}
	
	public HashMap apiGetDetail(String id) {
		
		HashMap res = new HashMap();
		
		Info info = this.infoDao.get(Long.parseLong(id));
		
		res.put("id", info.getCid().toString());
		res.put("title", info.getTitle());
		res.put("read", info.getHits());
		res.put("source", info.getSource());
		res.put("create_time", new SimpleDateFormat("yyyy-MM-dd").format(info.getGtmCreate()));
		res.put("photo_url", info.getPhotoUrl());
		res.put("category_id", info.getCategories());
		res.put("content", info.getContent());
		res.put("comment", this.getComment(id, 10));
		
		// category object
		HashMap category = new HashMap();
		
		category.put("id", info.getCategories());
		category.put("name", this.getCategoryName(info.getCategories()));
		
		res.put("category", category);
				
		return res;
		
	}
	
	private String getCategoryName(String id) {
		Map<String, Object> map = new HashMap<>(16);
		map.put("type", "info_type");
		map.put("value", id);
		List<DictDO> dictList = dictDao.list(map);;
		
		if (isEmpty(dictList)) 
			return "";
		else 
			return dictList.get(0).getName();
	}
	
	private boolean isEmpty(List list) {
		if (list == null ) return true;
		if (list.isEmpty()) return true;
		return false;
	}

	public void addComment(Comment comment) {
		this.commentDao.save(comment);		
	}
	
	public HashMap getComment(String infoId, int pageSize) {
		
		if (pageSize == 0) 
			pageSize = 10;
		
		HashMap<String, Object> res = new HashMap<String, Object>();
		
		int commentCount = this.getCommentCount(infoId);
		res.put("count", this.getCommentCount(infoId));
		res.put("page", commentCount/pageSize + 1);
		
		List<HashMap> commentList = new ArrayList<HashMap> ();
		res.put("list", commentList);
		
		if (commentCount == 0) return res;
		
		Map<String, Object> map = new HashMap<>(16);
		map.put("infoId", infoId);
		map.put("parentId", "0");
		
		List<Comment> retList = this.commentDao.list(map);
				
		for (Comment comment: retList) {
			HashMap commentObj = new HashMap();
			commentObj.put("id", comment.getCid());
			commentObj.put("content", comment.getContent());
			commentObj.put("create_time", new SimpleDateFormat("yyyy-MM-dd").format(comment.getCreateTime()));  //TODO
			HashMap replyObj = this.getReply(comment.getCid(), pageSize);
			commentObj.put("reply", replyObj);
			commentObj.put("reply_count", replyObj.get("count"));
			commentList.add(commentObj);
		}
		
		return res;
	}
	
	private int getCommentCount(String infoId) {
		Map<String, Object> map = new HashMap<>(16);
		map.put("infoId", Long.parseLong(infoId));
		map.put("parentId", "0");
		
		return this.commentDao.count(map);
	}
	
	public HashMap<String, Object> getReply(Long commentId, int pageSize) {
		if (pageSize == 0) 
			pageSize = 10;
		
		HashMap<String, Object> res = new HashMap<String, Object>();
		int replyCount = this.getReplyCount(commentId);
		res.put("count", replyCount);
		res.put("page", replyCount/pageSize + 1);
		
		ArrayList<HashMap<String, Object>> replyList = new ArrayList<HashMap<String, Object>> ();
				
		Map<String, Object> map = new HashMap<>(16);
		map.put("parentId", commentId);
		List<Comment> retList = this.commentDao.list(map);
		for (Comment comment: retList) {
			HashMap<String, Object> replyObj = new HashMap<String, Object>();
			replyObj.put("id", comment.getCid());
			replyObj.put("content", comment.getContent());
			replyObj.put("create_time", new SimpleDateFormat("yyyy-MM-dd").format(comment.getCreateTime()));  //TODO
			replyList.add(replyObj);
		}
		
		res.put("list", replyList);
		
		return res;
	}
	
	private int getReplyCount(Long commentId) {
		Map<String, Object> map = new HashMap<>(16);
		map.put("parentId", commentId.toString());
		
		return this.commentDao.count(map);
	}
}
