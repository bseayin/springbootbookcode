package com.xsz.repository;

import com.xsz.entity.Resume;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ResumeRepository extends JpaRepository<Resume,String>, JpaSpecificationExecutor<Resume> {

    Page<Resume> findByCreateByOrderByIdDesc(Pageable pageable, String id);
}
