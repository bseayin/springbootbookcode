package com.zz.shopAdmin.service.impl;

import com.zz.common.domain.Tree;
import com.zz.common.utils.BuildTree;
import com.zz.common.utils.ShiroUtils;
import com.zz.common.utils.StringUtils;
import com.zz.shopAdmin.dao.AdminProductinproductcategoryDao;
import com.zz.shopAdmin.dao.AdminShopProductCategoryDao;
import com.zz.shop.domain.ShopProductCategoryDO;
import com.zz.shopAdmin.domain.ProductinproductcategoryDO;
import com.zz.shopAdmin.service.AdminProductinproductcategoryService;
import com.zz.shopAdmin.service.AdminShopProductCategoryService;
import com.zz.shopAdmin.utils.FlagUtils;
import com.zz.system.domain.MenuDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class AdminShopProductCategoryServiceImpl implements AdminShopProductCategoryService {
    @Autowired
    AdminShopProductCategoryDao adminShopProductCategoryDao;
    @Autowired
    AdminProductinproductcategoryService adminProductinproductcategoryService;

    @Override
    public List<ShopProductCategoryDO> list(Map<String, Object> map) {
        return adminShopProductCategoryDao.list(map);
    }

    @Override
    public List<ShopProductCategoryDO> listActive(Map<String, Object> map) {
        map.put(FlagUtils.ISACTIVE_K, FlagUtils.ISACTIVE_V_YES);
        return list(map);
    }

    @Override
    public ShopProductCategoryDO get(String wallId) {
        return adminShopProductCategoryDao.get(wallId);
    }

    @Override
    public int count(Map<String, Object> map) {
        return adminShopProductCategoryDao.count(map);
    }

    @Override
    public int save(ShopProductCategoryDO record) {
        record.setId(UUID.randomUUID().toString().replace("-", ""));
        String userid= ShiroUtils.getUserId()+"";
        record.setCreatedBy(userid);
        record.setUpdatedBy(userid);
        return adminShopProductCategoryDao.save(record);
    }

    @Override
    public int update(ShopProductCategoryDO record) {
        record.setUpdatedBy(ShiroUtils.getUserId()+"");
        return adminShopProductCategoryDao.update(record);
    }


    /**
     * 在删除分类时
     * 将被删除分类下的所有子分类 挂至被删除分类的最近唯一父分类上
     *
     * @param id
     * @return
     */
    @Override
    public int remove(String id) {
        int i = 0;
        ShopProductCategoryDO t = get(id);
        if (t != null) {
            i = adminShopProductCategoryDao.remove(id);
            if (i > 0) {
                adminShopProductCategoryDao.updateOldPid(StringUtils.isNotBlank(t.getPid()) ? t.getPid() : FlagUtils.Category_Root_Id, t.getId());
            }
        }
        return i;
    }

    @Override
    public int batchRemove(String[] wallIds) {
        return adminShopProductCategoryDao.batchRemove(wallIds);
    }

    @Override
    public  Tree<MenuDO> getTree(String productId){
        List<ShopProductCategoryDO> categorys = list(new HashMap<String, Object>(16));
        Map temp=new HashMap();
        temp.put("productId",productId);
        List<ProductinproductcategoryDO> tempCheckedList = adminProductinproductcategoryService.list(temp);
        List<String> checkedList=tempCheckedList.stream().map(ProductinproductcategoryDO::getProductCategoryId).collect(Collectors.toList());

        List<Tree<MenuDO>> trees = new ArrayList<Tree<MenuDO>>();
        for (ShopProductCategoryDO category : categorys) {
            Tree<MenuDO> tree = new Tree<MenuDO>();
            tree.setId(category.getId());
            tree.setParentId(category.getPid());
            tree.setText(category.getName());
            Map<String, Object> state = new HashMap<>(16);
            String categoyId = category.getId();
            if (checkedList.contains(categoyId)) {
                state.put("selected", true);
            } else {
                state.put("selected", false);
            }
            tree.setState(state);
            trees.add(tree);
        }
        Tree<MenuDO> t = BuildTree.build(trees);
        t.setText(FlagUtils.Category_Root_Name);
        return t;
    }
}
