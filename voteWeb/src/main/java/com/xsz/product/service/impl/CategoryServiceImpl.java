package com.xsz.product.service.impl;


import com.xsz.common.domain.QueryRequest;
import com.xsz.common.service.impl.BaseService;
import com.xsz.product.dao.CategoryDishesMapper;
import com.xsz.product.dao.CategoryMapper;
import com.xsz.product.domain.Category;
import com.xsz.product.domain.CategoryDishes;
import com.xsz.product.dto.CategoryDTO;
import com.xsz.product.service.CategoryService;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author llf
 * @description: 菜品父类服务实现类
 * @date 2020/5/25
 */
@Service("CategoryService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class CategoryServiceImpl extends BaseService<Category> implements CategoryService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private CategoryDishesMapper categoryDishesMapper;


    @Override
    public List<CategoryDTO> getCategoryListPage(QueryRequest queryRequest, CategoryDTO categoryDTO) {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        // 判断店铺id
        if (categoryDTO.getCategoryCompanyid() != 0) {
            criteria.andCondition("category_companyid=", categoryDTO.getCategoryCompanyid());
        }
        // 判断菜品分类
        if (StringUtils.isNotBlank(categoryDTO.getCategoryName())) {
            criteria.andCondition("category_name like", "%" + categoryDTO.getCategoryName() + "%");
        }
        if (StringUtils.isNotBlank(categoryDTO.getCategoryName())) {
            criteria.andCondition("category_name_en like", "%" + categoryDTO.getCategoryNameEn() + "%");
        }
        if (StringUtils.isNotBlank(categoryDTO.getCategoryCreateTime())) {
            String[] timeArr = categoryDTO.getCategoryCreateTime().split("~");
            criteria.andCondition("date_format(createtime,'%Y-%m-%d') >=", timeArr[0]);
            criteria.andCondition("date_format(createtime,'%Y-%m-%d') <=", timeArr[1]);
        }
        example.setOrderByClause("createtime desc");
        List<Category> categoryList = selectByExample(example);
        List<CategoryDTO> categoryDtoList = categoryList.stream().map(category -> {
            Mapper mapper = DozerBeanMapperBuilder.buildDefault();
            CategoryDTO convert = mapper.map(category, CategoryDTO.class);
            return convert;
        }).collect(Collectors.toList());
        return categoryDtoList;
    }

    @Override
    public List<CategoryDTO> getCategoryList(CategoryDTO categoryDTO) {
        return categoryMapper.findCategoryList(categoryDTO);
    }

    @Override
    public List<CategoryDTO> findCategoryListByDishes(Long dishesId) {
        return categoryMapper.findCategoryListByDishes(dishesId);
    }

    @Override
    public Category getCategory(Long categoryId) {
        return selectByKey(categoryId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO, category);
        category.setCreatetime(new Date());
        category.setUpdatetime(new Date());
        save(category);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO, category);
        category.setUpdatetime(new Date());
        updateNotNull(category);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteCategory(Long categoryId) {
        Example example = new Example(CategoryDishes.class);
        example.createCriteria().andCondition("category_id=", categoryId);
        int size;
        size = categoryDishesMapper.selectByExample(example).size();
        if (size == 0) {
            categoryMapper.deleteByPrimaryKey(categoryId);
            return size;
        }
        return size;
    }


}
