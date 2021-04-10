package com.zz.info.service.impl;

import com.zz.info.domain.Info;
import com.zz.info.domain.api.Index;
import com.zz.info.domain.api.IndexData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zz.info.dao.UsercollectionDao;
import com.zz.info.domain.UsercollectionDO;
import com.zz.info.service.UsercollectionService;



@Service
public class UsercollectionServiceImpl implements UsercollectionService {
	@Autowired
	private UsercollectionDao usercollectionDao;
	@Value("${ImageHost}")
	String imageHost;
	@Override
	public UsercollectionDO get(String userId){
		return usercollectionDao.get(userId);
	}
	
	@Override
	public List<UsercollectionDO> list(Map<String, Object> map){
		return usercollectionDao.list(map);
	}

	public List<Info> listToInfo(Map<String, Object> map){
		return usercollectionDao.listToInfo(map);
	}

	@Override
	public int count(Map<String, Object> map){
		return usercollectionDao.count(map);
	}


	@Override
	public int save(UsercollectionDO usercollection){
		return usercollectionDao.save(usercollection);
	}
	
	@Override
	public int update(UsercollectionDO usercollection){
		return usercollectionDao.update(usercollection);
	}
	
	@Override
	public int remove(String userId){
		return usercollectionDao.remove(userId);
	}
	
	@Override
	public int batchRemove(String[] userIds){
		return usercollectionDao.batchRemove(userIds);
	}
	@Override
	public int toggleCollection(Long contentId, String userId){
		Map p=new HashMap();
		p.put("infoId",contentId);
		p.put("userId",userId);
		List<UsercollectionDO>  re=list(p);
		if(re.size()>0){
			for(UsercollectionDO t:re){
				UsercollectionDO tempDO=new UsercollectionDO();
				tempDO.setCid(t.getCid());
				tempDO.setStatus(0);
				update(tempDO);
			}
			return re.size();
		}
		UsercollectionDO tempDO=new UsercollectionDO();
		tempDO.setInfoId(contentId);
		tempDO.setUserId(userId);
		return save(tempDO);
	}

	@Override
	public HashMap apiGetIndex(String userId, int pageSize, int pageIndex) {
		IndexData indexData = new IndexData();
		List<Index> indexList = new ArrayList<Index>();
		indexData.setList(indexList);

		Map<String, Object> map = new HashMap<>(16);
		map.put("user_id", userId);
		map.put("limit", pageSize);
		map.put("offset", (pageIndex-1)*pageSize);

		List<Info> infoList = listToInfo(map);

		for (Info info : infoList) {
			Index index = new Index();
			index.setId(info.getCid().toString());
			index.setTitle(info.getTitle());
			index.setPhotoUrl(imageHost+info.getPhotoUrl());
			index.setRead(info.getHits()!=null?info.getHits().toString():"0");
			index.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").format(info.getGtmCreate()));
			index.setSource(info.getAuthor());
			index.setCommentCount(info.getCommentsNum()+"");

			indexList.add(index);
		}



		int count = usercollectionDao.countListToInfo(map);
		indexData.setCount(Integer.toString(count));

		int pageNumber = count/pageSize + 1;
		indexData.setPage(Integer.toString(pageNumber));
		HashMap map2=new HashMap();
		map2.put("list",indexData.getList());
		map2.put("count",indexData.getCount());
		map2.put("page",indexData.getPage());
		return map2;
	}
}
