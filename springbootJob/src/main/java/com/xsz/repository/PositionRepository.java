package com.xsz.repository;

import com.xsz.entity.Position;
import javafx.geometry.Pos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position,String>, JpaSpecificationExecutor<Position> {

    public Page<Position> findByPid(String tid, Pageable pageable);

    Page<Position> findByCreateBy(Pageable pageable, String createById);
}
