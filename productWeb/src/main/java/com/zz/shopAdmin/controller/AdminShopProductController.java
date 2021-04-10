package com.zz.shopAdmin.controller;

import java.util.List;
import java.util.Map;

import com.zz.common.utils.ShiroUtils;
import com.zz.shop.domain.ShopProductDO;
import com.zz.shopAdmin.domain.ShopProductDTO;
import com.zz.shopAdmin.service.AdminShopProductService;
import com.zz.util.ResultVOUtil;
import com.zz.vo.ResultVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zz.common.utils.PageUtils;
import com.zz.common.utils.Query;
import com.zz.common.utils.R;

/**
 * 产品
 * 
 * @author jwh
 * @email 1304058324@qq.com
 * @date 2020-11-26 16:18:25
 */
 
@Controller
@RequestMapping("/shop/product")
public class AdminShopProductController {
	@Autowired
	private AdminShopProductService productService;
	
	@GetMapping()
	@RequiresPermissions("shop:product:product")
	String Product(){
	    return "shop/product/product";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("shop:product:product")
	public PageUtils list(@RequestParam Map<String, Object> params){
		params.put("shopId", ShiroUtils.getUser().getDeptId());
		//查询列表数据
        Query query = new Query(params);
		List<ShopProductDO> productList = productService.list(query);
		int total = productService.count(query);
		PageUtils pageUtils = new PageUtils(productList, total);
		return pageUtils;
	}
	@ResponseBody
	@GetMapping("/listSimple")
	@RequiresPermissions("shop:product:product")
	public PageUtils listSimple(@RequestParam Map<String, Object> params){
		params.put("shopId", ShiroUtils.getUser().getDeptId());
		//查询列表数据
        Query query = new Query(params);
		List<ShopProductDTO> productList = productService.listSimple(query);
		int total = productService.count(query);
		PageUtils pageUtils = new PageUtils(productList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("shop:product:add")
	String add(){
	    return "shop/product/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("shop:product:edit")
	String edit(@PathVariable("id") String id,Model model){
		ShopProductDO product = productService.get(id);
		model.addAttribute("product", product);
	    return "shop/product/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("shop:product:add")
	public ResultVO save(ShopProductDTO product){
		if(productService.save(product)>0){
			return ResultVOUtil.success(product.getId());
		}
		return ResultVOUtil.error(-1,"操作失败");
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("shop:product:edit")
	public ResultVO update( ShopProductDTO product){
		if(productService.update(product)>0){
			return ResultVOUtil.success();
		}
		return  ResultVOUtil.success();
	}
	@ResponseBody
	@RequestMapping("/updateActive")
	@RequiresPermissions("shop:product:edit")
	public ResultVO update( String  id,Boolean active){
		productService.updateActive(id,active);
		return  ResultVOUtil.success();
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("shop:product:remove")
	public ResultVO remove( String id){
		if(productService.remove(id)>0){
		return  ResultVOUtil.success();
		}
		return ResultVOUtil.error(-1,"操作失败");
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("shop:product:batchRemove")
	public ResultVO remove(@RequestParam("ids[]") String[] ids){
		productService.batchRemove(ids);
		return  ResultVOUtil.success();
	}
	
}
