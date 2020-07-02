package com.xsz.repository;

import com.xsz.entity.DictType;
import com.xsz.entity.DictValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DictTypeRepository extends JpaRepository<DictType, String> {

}
