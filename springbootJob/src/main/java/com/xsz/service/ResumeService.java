package com.xsz.service;

import com.xsz.entity.Resume;
import com.xsz.entity.User;
import com.xsz.repository.ResumeRepository;
import com.xsz.util.KeyUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResumeService {
    @Resource
    ResumeRepository resumeRepository;

    /**查询当前用户简历**/
    public Page<Resume> showBycreateBy(String page, String limit, String id) {
        Pageable pageable = PageRequest.of(Integer.parseInt(page), Integer.parseInt(limit));

        return resumeRepository.findByCreateByOrderByIdDesc(pageable, id);
    }

    /**根据简历Id查询简历
     * @return**/
    public Resume showById(String id) {
//        Sort sort = new Sort(Sort.Direction.DESC, "id");
//        Pageable pageable = PageRequest.of(Integer.parseInt(pageNum), Integer.parseInt(limitNum));

        return resumeRepository.findById(id).get();
    }

    /**添加简历**/
    public Resume addResume(Resume resume) {

//        resume.setId(KeyUtil.getId());

        return resumeRepository.save(resume);
    }

    /**修改简历**/
    public Resume editResume(Resume resume) {
        return resumeRepository.save(resume);
    }

    /**删除简历**/
    public void deleteResume(String id) {
        resumeRepository.deleteById(id);
    }
}
