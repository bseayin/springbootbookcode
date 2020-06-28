package com.xsz.repository;

import com.xsz.entity.Meeting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface MeetingRepository extends JpaRepository<Meeting,String> {
    @Transactional
    @Modifying
    @Query("update Meeting m set m.templateId = ?1 where m.id = ?2")
    public int updateTemplateById(String templateId, String id);
}
