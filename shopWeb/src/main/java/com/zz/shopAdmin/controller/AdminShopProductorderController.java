package com.zz.shopAdmin.controller;

import java.util.List;
import java.util.Map;

import com.zz.shopAdmin.domain.AdminShopProductorderDO;
import com.zz.shopAdmin.domain.AdminShopProductorderVO;
import com.zz.shopAdmin.service.AdminShopProductorderService;
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
 * 订单
 * 
 * @author jwh
 * @email jinwenhao
 * @date 2020-12-15 17:09:46
 */
 
@Controller
@RequestMapping("/shop/shopProductorder")
public class AdminShopProductorderController {
	@Autowired
	private AdminShopProductorderService shopProductorderService;
	
	@GetMapping()
	@RequiresPermissions("shop:shopProductorder:shopProductorder")
	String ShopProductorder(){
	    return "shop/shopProductorder/shopProductorder";
	}

	@GetMapping(value="productlist")
	@RequiresPermissions("shop:shopProductorder:shopProductorder")
	String productlist(){
	    return "shop/shopProductorder/shopProductorder_productlist";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("shop:shopProductorder:shopProductorder")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<AdminShopProductorderDO> shopProductorderList = shopProductorderService.list(query);
		int total = shopProductorderService.count(query);
		PageUtils pageUtils = new PageUtils(shopProductorderList, total);
		return pageUtils;
	}
	@ResponseBody
	@GetMapping("/listProduct")
	@RequiresPermissions("shop:shopProductorder:shopProductorder")
	public PageUtils listProduct(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<AdminShopProductorderVO> shopProductorderList = shopProductorderService.listProduct(query);
		int total = shopProductorderService.count(query);
		PageUtils pageUtils = new PageUtils(shopProductorderList, total);
		return pageUtils;
	}

	@ResponseBody
	@GetMapping("/listOrder")
	@RequiresPermissions("shop:shopProductorder:shopProductorder")
	public PageUtils listOrder(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<AdminShopProductorderDO> shopProductorderList = shopProductorderService.listOrder(query);
		int total = shopProductorderService.countOrder(query);
		PageUtils pageUtils = new PageUtils(shopProductorderList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("shop:shopProductorder:add")
	String add(){
	    return "shop/shopProductorder/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("shop:shopProductorder:edit")
	String edit(@PathVariable("id") String id,Model model){
		AdminShopProductorderDO shopProductorder = shopProductorderService.get(id);
		model.addAttribute("shopProductorder", shopProductorder);
	    return "shop/shopProductorder/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("shop:shopProductorder:add")
	public R save( AdminShopProductorderDO shopProductorder){
		if(shopProductorderService.save(shopProductorder)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("shop:shopProductorder:edit")
	public R update( AdminShopProductorderDO shopProductorder){
		shopProductorderService.update(shopProductorder);
		return R.ok();
	}
	@ResponseBody
	@RequestMapping("/updateOrder")
//	@RequiresPermissions("shop:shopProductorder:edit")
	public R updateOrder( AdminShopProductorderDO shopProductorder){
		shopProductorderService.updateByOrderSetId(shopProductorder);
		return R.ok();
	}
	@ResponseBody
	@RequestMapping("/updateOrderBatch")
//	@RequiresPermissions("shop:shopProductorder:edit")
	public R updateOrderBatch( String  ids,AdminShopProductorderDO shopProductorder){
		for(String id:ids.trim().split(",")){
			shopProductorder.setOrdersetid(id);
			shopProductorderService.updateByOrderSetId(shopProductorder);
		}
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("shop:shopProductorder:remove")
	public R remove( String id){
		if(shopProductorderService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("shop:shopProductorder:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		shopProductorderService.batchRemove(ids);
		return R.ok();
	}
	
}
