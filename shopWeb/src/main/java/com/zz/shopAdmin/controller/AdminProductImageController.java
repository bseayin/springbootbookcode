package com.zz.shopAdmin.controller;

import java.util.List;
import java.util.Map;

import com.zz.common.config.BootdoConfig;
import com.zz.common.utils.FileUtil;
import com.zz.shop.domain.ShopProductImageDO;
import com.zz.shopAdmin.service.AdminProductImageService;
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
 * 产品图片
 * 
 * @author jwh
 * @email 1304058324@qq.com
 * @date 2020-11-27 17:08:34
 */
 
@Controller
@RequestMapping("/shop/productImage")
public class AdminProductImageController {
	@Autowired
	private AdminProductImageService productimageService;
	@Autowired
	private BootdoConfig bootdoConfig;
	@GetMapping()
	@RequiresPermissions("shop:productimage:productimage")
	String Productimage(@RequestParam String id,@RequestParam(required = false) Boolean doAdd,Model model){
		model.addAttribute("id",id);
		model.addAttribute("doAdd",doAdd==null?false:doAdd);
	    return "shop/productimage/productimage";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("shop:productimage:productimage")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ShopProductImageDO> productimageList = productimageService.list(query);
		int total = productimageService.count(query);
		PageUtils pageUtils = new PageUtils(productimageList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("shop:productimage:add")
	String add(){
	    return "shop/productimage/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("shop:productimage:edit")
	String edit(@PathVariable("id") String id,Model model){
		ShopProductImageDO productimage = productimageService.get(id);
		model.addAttribute("productimage", productimage);
	    return "shop/productimage/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("shop:productimage:add")
	public ResultVO save(ShopProductImageDO productimage){
		if(productimageService.save(productimage)>0){
			return ResultVOUtil.success();
		}
		return ResultVOUtil.error(-1,"操作失败");
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("shop:productimage:edit")
	public R update( ShopProductImageDO productimage){
		productimageService.update(productimage);
		return R.ok();
	}
	@ResponseBody
	@RequestMapping("/updateActive")
	@RequiresPermissions("shop:product:edit")
	public R update( String  id,Boolean active){
		productimageService.updateActive(id,active);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("shop:productimage:remove")
	public R remove( String id){
		ShopProductImageDO productImageDO=productimageService.get(id);
		if(productimageService.remove(id)>0){
			String fileName = bootdoConfig.getUploadPath() + productImageDO.getImageSrc().replace("/files/", "");
			FileUtil.deleteFile(fileName);
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("shop:productimage:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		productimageService.batchRemove(ids);
		for(String idstr:ids){
			ShopProductImageDO productImageDO=productimageService.get(idstr);
			String fileName = bootdoConfig.getUploadPath() + productImageDO.getImageSrc().replace("/files/", "");
			FileUtil.deleteFile(fileName);
		}
		return R.ok();
	}
	
}
