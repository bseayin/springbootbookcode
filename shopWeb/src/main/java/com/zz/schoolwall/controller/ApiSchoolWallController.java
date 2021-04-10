package com.zz.schoolwall.controller;

import com.zz.common.utils.Query;
import com.zz.common.utils.ShiroUtils;
import com.zz.schoolwall.domain.SchoolWallDO;
import com.zz.schoolwall.domain.SchoolWallDTO;
import com.zz.schoolwall.service.SchoolWallService;
import com.zz.util.ResultVOUtil;
import com.zz.vo.ResultVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/schoolwall")
@Controller
public class ApiSchoolWallController {
	@Autowired
	SchoolWallService schoolWallService;

	/**
	 *查询列表
	 * @param offset
	 * @param limit 分页-条数
	 * @param type 类型 0-表白 1-树洞 2-心愿 3-知乎
	 * @return
	 */
	@ResponseBody
	@GetMapping("/list")
	public ResultVO<Map> list(@RequestParam Integer offset ,@RequestParam Integer limit ,@RequestParam Integer type ) {
		Map<String, Object> params = new HashMap();
		params.put("offset",offset);
		params.put("limit",limit);
		params.put("wallStatus",1);
		Query query = new Query(params);
		List<SchoolWallDO> reList = schoolWallService.list(query);
		return ResultVOUtil.success(reList);
	}
	/**
	 * 查询列表-我的
	 * @param offset
	 * @param limit 分页-条数
	 * @param type 类型 0-表白 1-树洞 2-心愿 3-知乎
	 * @return
	 */
	@ResponseBody
	@GetMapping("/mylist")
	public ResultVO mylist(@RequestParam Integer offset ,@RequestParam Integer limit ,@RequestParam Integer type ) {
		Map<String, Object> params = new HashMap();
		params.put("offset",offset);
		params.put("limit",limit);
		params.put("wallStatus",1);
		params.put("wallCreateman",ShiroUtils.getUserId());
		Query query = new Query(params);
		List<SchoolWallDO> reList = schoolWallService.list(query);
		return ResultVOUtil.success(reList);
	}



	@GetMapping("/info/{id}")
	ResultVO get(@PathVariable("id") Long id) {
		SchoolWallDO schoolWallDO = schoolWallService.get(id);
		return ResultVOUtil.success(schoolWallDO);
	}

	@RequiresPermissions({"schoolwall:wall:add","schoolwall:wall:edit"})
	@ResponseBody
	@PostMapping("/save")
	ResultVO save( @RequestBody SchoolWallDTO schoolWallDTO) {
		int count=-1;
		if (schoolWallDTO.getWallId() ==null) {
			count = schoolWallService.save(schoolWallDTO);
		} else {
			count = schoolWallService.update(schoolWallDTO);
		}
		if (count>0) {
			return ResultVOUtil.success( schoolWallDTO.getWallId());
		}
		return ResultVOUtil.error(-1,"失败");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("schoolwall:wall:remove")
	@PostMapping("/remove")
	@ResponseBody
	public ResultVO remove(Long id) {
		if (schoolWallService.logicRemove(id) > 0) {
			return ResultVOUtil.success();
		}
		return ResultVOUtil.error(-1,"失败");
	}

	@PostMapping("/myremove")
	@ResponseBody
	public ResultVO myremove(Long id) {
		SchoolWallDO schoolWallDO=schoolWallService.get(id);
		if(!(ShiroUtils.getUserId()+"").equals(schoolWallDO.getWallCreateman())){
			return ResultVOUtil.error(-1,"失败:无法删除他人墙话");
		}
		if (schoolWallService.logicRemove(id) > 0) {
			return ResultVOUtil.success();
		}
		return ResultVOUtil.error(-1,"失败");
	}


}
