package com.xsz.service;

import com.xsz.dto.ResumePostionDto;
import com.xsz.entity.Position;
import com.xsz.entity.User;
import com.xsz.repository.PositionRepository;
import com.xsz.util.KeyUtil;
import io.swagger.models.auth.In;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class PositionService {
    @Resource
    PositionRepository positionRepository;
    @Resource
    DTODao dtoDao;

    /**根据行业类别查询所有职位**/
    public Page<Position> showByTid(String tid, String page, String limit){
        Pageable pageable = PageRequest.of(Integer.parseInt(page), Integer.parseInt(limit));

        return positionRepository.findByPid(tid, pageable);
    }

    /**添加职位**/
    public Position addPosition(Position position, User user) {

        position.setCreateDate(new Date());
        position.setId(KeyUtil.getId());
        position.setCreateBy(user.getId());

        return positionRepository.save(position);
    }

    /**修改职位**/
    public Position editPosition(Position position) {
        position.setCreateDate(new Date());
        return positionRepository.save(position);
    }

    /**删除职位**/
    public void deletePosition(String id) {
        positionRepository.deleteById(id);
    }

    /**查询所有职位**/
    public List<Position> showAll() {
        return positionRepository.findAll();
    }

    /**分页查询所有职位**/
    public Page<Position> showAllByPage(String page, String limit) {
        Pageable pageable = PageRequest.of(Integer.parseInt(page), Integer.parseInt(limit));
        return positionRepository.findAll(pageable);
    }

    /**根据id查询职位**/
    public Position showById(String id) {
        return positionRepository.findById(id).get();
    }

    /**根据职位创建者ID查询职位**/
    public Page<Position> showAllByCreateById(String page, String limit, String createById) {
        Pageable pageable = PageRequest.of(Integer.parseInt(page), Integer.parseInt(limit));

        return positionRepository.findByCreateBy(pageable, createById);

    }

    /**根据职位创建者ID查询求职者**/
    public Page<ResumePostionDto> showApplicant(String page, String limit, String createById) {
        return dtoDao.showApplicant(createById, Integer.parseInt(page), Integer.parseInt(limit));

    }
}
