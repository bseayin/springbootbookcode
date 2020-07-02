package com.xsz.repository;

import com.xsz.entity.DictType;
import com.xsz.entity.DictValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;


public interface DictValueRepository extends JpaRepository<DictValue, String> {

    Page<DictValue> findByDictTypeId(String id, Pageable pageable);

    List<DictValue> findByDictTypeId(String id, Sort sort);
}
