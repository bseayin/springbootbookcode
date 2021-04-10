package com.zz.schoolwall.controller;

import com.zz.common.utils.Query;
import com.zz.schoolwall.domain.SchoolWallCommentDO;
import com.zz.schoolwall.service.SchoolWallCommentService;
import com.zz.schoolwall.service.SchoolWallService;
import com.zz.util.ResultVOUtil;
import com.zz.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/schoolwall/comment")
@Controller
public class ApiSchoolWallCommentController {
	@Autowired
	SchoolWallCommentService schoolWallCommentService;
	@Autowired
	SchoolWallService schoolWallService;

	/**
	 * 墙话的评论查询
	 * @param wallId 墙话id
	 * @param limit 分页-条数
	 * @return
	 */
	@ResponseBody
	@GetMapping("/listMain/{wallId}")
	public ResultVO listMain(@PathVariable("wallId") Long wallId, @RequestParam Integer offset,@RequestParam Integer limit ) {
		Map<String, Object> params = new HashMap();
		params.put("offset",offset);
		params.put("limit",limit);
		params.put("wallId",wallId);
		params.put("commentStatus",1);
		params.put("parentCommentId",-1);
		Query query = new Query(params);
		List<SchoolWallCommentDO> reList = schoolWallCommentService.list(query);
		return ResultVOUtil.success(reList);
	}

	/**
	 * 评论的回复 查询
	 * @param parentCommentId 父评论id
	 * @param limit 分页-条数
	 * @return
	 */
	@ResponseBody
	@GetMapping("/listSecond/{parentCommentId}")
	public ResultVO listSecond(@PathVariable("parentCommentId") Long parentCommentId, @RequestParam Integer offset,@RequestParam Integer limit ) {
		SchoolWallCommentDO comment=schoolWallCommentService.get(parentCommentId);
		if(comment.getCommentStatus()==-1){
			return ResultVOUtil.error(-1,"该条评论已关闭");
		}

		Map<String, Object> params = new HashMap();
		params.put("offset",offset);
		params.put("limit",limit);
		params.put("commentStatus",1);
		params.put("parentCommentId",parentCommentId);
		Query query = new Query(params);
		List<SchoolWallCommentDO> reList = schoolWallCommentService.list(query);
		return ResultVOUtil.success(reList);
	}
	/**
	 * 添加
	 */
	@PostMapping("/save")
	@ResponseBody
	public ResultVO save(@RequestParam String content,@RequestParam Long wallId,@RequestParam(required = false) Long parentId ) {
		SchoolWallCommentDO schoolWallCommentDO=new SchoolWallCommentDO();
		schoolWallCommentDO.setWallId(wallId);
		schoolWallCommentDO.setCommentCentent(content);
		schoolWallCommentDO.setParentCommentId(parentId==null?"-1":(parentId+""));
		int count=schoolWallCommentService.save(schoolWallCommentDO);
		if(parentId==null){
			schoolWallService.increaseCommentNum(wallId);
		}else{
			schoolWallCommentService.increaseCommentNum(parentId);
		}

		if (count>0) {
			return ResultVOUtil.success( schoolWallCommentDO.getCommentId());
		}
		return ResultVOUtil.error(-1,"失败");
	}

}
