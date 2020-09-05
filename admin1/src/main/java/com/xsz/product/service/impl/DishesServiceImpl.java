package com.xsz.product.service.impl;

import com.xsz.common.domain.QueryRequest;
import com.xsz.common.service.impl.BaseService;
import com.xsz.product.dao.CategoryDishesMapper;
import com.xsz.product.dao.DishesMapper;
import com.xsz.product.domain.CategoryDishes;
import com.xsz.product.domain.Dishes;
import com.xsz.product.dto.DishesDTO;
import com.xsz.product.enums.DishesEnum;
import com.xsz.product.service.CategoryDishesService;
import com.xsz.product.service.DishesService;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author llf
 * @description: 菜品服务实现类
 * @date 2020/5/25
 */
@Service("DishesService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DishesServiceImpl extends BaseService<Dishes> implements DishesService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private CategoryDishesMapper categoryDishesMapper;

    @Resource
    private DishesMapper dishesMapper;

    @Resource
    private CategoryDishesService categoryDishesService;

    @Override
    public Dishes getDishesById(Long id) {
        return selectByKey(id);
    }

    @Override
    public List<DishesDTO> getDishesPage(QueryRequest request, DishesDTO dishesDTO) {
        if (StringUtils.isNotBlank(dishesDTO.getDishesCreateTime())) {
            String[] timeArr = dishesDTO.getDishesCreateTime().split("~");
            dishesDTO.setBeginDate(timeArr[0]);
            dishesDTO.setEndDate(timeArr[1]);
        }
        return dishesMapper.findDishesPage(dishesDTO);
    }

    @Override
    public List<DishesDTO> getDishesByCategoryId(Long categoryId) {
        List<DishesDTO> dtoList=new ArrayList<>();
        // 获取一级菜单所对应的菜品id
        List<String> strings=categoryDishesMapper.getDishesIdByCategory(categoryId);
        strings.forEach(e-> {
            DishesDTO dishesDTO = new DishesDTO();
            BeanUtils.copyProperties(getDishesById(Long.parseLong(e)), dishesDTO);
            dtoList.add(dishesDTO);
        });
        return dtoList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteDishes(String ids,Long userId) {
        List<String> list = Arrays.asList(ids.split(","));
        // 将菜品状态改为已下架
        Example example = new Example(Dishes.class);
        example.createCriteria().andIn("spareId", list);
        Dishes dishes=new Dishes();
        dishes.setSpareStatus(DishesEnum.UNSHELVES);
        dishes.setSpareUpdateman(userId);
        dishesMapper.updateByExampleSelective(dishes,example);
        // 删除中间表信息
        categoryDishesService.deleteCategoryDishesByDishesId(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long addDishes(DishesDTO dishesDTO, Long[] categoryIds) {
        Dishes dishes=new Dishes();
        BeanUtils.copyProperties(dishesDTO,dishes);
        dishes.setSpareCreatetime(new Date());
        dishes.setSpareUpdatetime(new Date());
        // 菜品信息添加
        Long disesId=dishesMapper.addDishesReturnKey(dishes);
        // 菜品父类和菜品中间表添加
        setCategoryDishes(dishes,categoryIds);
        return disesId;
    }

    /**
     * 菜品父类和菜品中间表添加
     * @param dishes
     * @param categoryIds
     */
    private void setCategoryDishes(Dishes dishes,Long[] categoryIds){
        Arrays.stream(categoryIds).forEach(categoryId -> {
            CategoryDishes categoryDishes = new CategoryDishes();
            categoryDishes.setCategoryId(categoryId);
            categoryDishes.setSpareId(dishes.getSpareId());
           categoryDishesMapper.insert(categoryDishes);
        });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateDishes(DishesDTO dishesDTO, Long[] categoryIds) {
        Dishes dishes=new Dishes();
        BeanUtils.copyProperties(dishesDTO,dishes);
        dishes.setSpareUpdatetime(new Date());
        // 更新菜品信息
        updateNotNull(dishes);
        // 删除中间表
        Example example = new Example(CategoryDishes.class);
        example.createCriteria().andCondition("spare_id=", dishes.getSpareId());
        categoryDishesMapper.deleteByExample(example);
        // 添加中间表信息
        setCategoryDishes(dishes,categoryIds);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateDishesFile(DishesDTO dishesDTO) {
        Dishes dishes=new Dishes();
        BeanUtils.copyProperties(dishesDTO,dishes);
        dishes.setSpareUpdatetime(new Date());
        // 更新菜品信息
        updateNotNull(dishes);
    }




}
