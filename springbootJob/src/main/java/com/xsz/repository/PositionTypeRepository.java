package com.xsz.repository;

import com.xsz.entity.PositionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PositionTypeRepository extends JpaRepository<PositionType,String>, JpaSpecificationExecutor<PositionType> {

}
