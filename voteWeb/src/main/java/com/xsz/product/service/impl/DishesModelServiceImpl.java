package com.xsz.product.service.impl;

import com.xsz.common.domain.QueryRequest;
import com.xsz.common.service.impl.BaseService;
import com.xsz.product.dao.DishesModelMapper;
import com.xsz.product.domain.DishesModel;
import com.xsz.product.service.DishesModelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author llf
 * @description: 菜品规格服务实现类
 * @date 2020/5/25
 */
@Service("DishesModelService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DishesModelServiceImpl extends BaseService<DishesModel> implements DishesModelService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private DishesModelMapper dishesModelMapper;

    @Override
    public List<DishesModel> getDishesModelPage(QueryRequest request, Long dishesId) {
        if (dishesId == 0) {
            return null;
        } else {
            Example example = new Example(DishesModel.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andCondition("dishes_id=", dishesId);
            List<DishesModel> dishesModelList = selectByExample(example);
            return dishesModelList;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteDishesModel(Long modelId) {
        delete(modelId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addOrUpdateDishesModel(List<DishesModel> dishesModel, Long dishesId, Boolean isAdd) {
        if (isAdd) {
            // 存新信息进去
            addModel(dishesModel, dishesId);
        } else {
            updateDishesModel(dishesModel, dishesId);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateDishesModel(List<DishesModel> dishesModel, Long dishesId) {
        List<DishesModel> dishesModelList = getDishesModelPage(null,dishesId);
        if (dishesModelList.size() == 0) {
            // 存入新记录
            addModel(dishesModel, dishesId);
        } else {
            // 删除原始记录
            dishesModelList.forEach(model -> deleteDishesModel(model.getModelId()));
            // 存入新记录
            addModel(dishesModel, dishesId);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void addModel(List<DishesModel> dishesModel, Long dishesId) {
        dishesModel.forEach(model -> {
            model.setDishesId(dishesId);
            save(model);
        });
    }

}
