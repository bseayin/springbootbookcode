package com.xsz.service;

import com.xsz.dto.JobDto;
import com.xsz.dto.ResumePostionDto;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DTODao {

    @Resource
    JdbcTemplate jdbcTemplate;

    public int addPositionResume(JobDto jobDto){
        String sql = "insert into tb_position_resume(rid,pid) values (?,?)";

        PreparedStatementSetter pstats = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, jobDto.getRid());
                ps.setString(2, jobDto.getPid());
            }
        };

        return jdbcTemplate.update(sql, pstats);
    }


    //根据简历表和职位表显示查询到的申请人名字和申请的职位
    public Page<ResumePostionDto> showApplicant(String createBy, int page, int limit){
        String sql="select p.name, r.name, word_path from (tb_position p inner join tb_position_resume pr on p.id = pr.pid) inner join tb_resume r on r.id = pr.rid where p.create_by = ? limit ?, ?";
        String sql2 = "select count(*) from (tb_position p inner join tb_position_resume pr on p.id = pr.pid) inner join tb_resume r on r.id = pr.rid where p.create_by = ?";

        int finalPage = page  * limit;

        List<ResumePostionDto> resumePostionDtoList = new ArrayList<>();

        resumePostionDtoList = jdbcTemplate.query(sql, (PreparedStatement ps) -> {
                ps.setString(1, createBy);
                ps.setInt(2, finalPage);
                ps.setInt(3, limit);
        }, (ResultSet rs) -> {
                List<ResumePostionDto> list = new ArrayList<>();

                while(rs.next()){
                    ResumePostionDto resumePostionDto = new ResumePostionDto();
                    resumePostionDto.setPositionName(rs.getString(1));
                    resumePostionDto.setApplicantName(rs.getString(2));
                    resumePostionDto.setWordPath(rs.getString(3));
                    list.add(resumePostionDto);
                }
                return list;
            });

        Integer count = jdbcTemplate.queryForObject(sql2, Integer.class, createBy);

        Pageable pageable = PageRequest.of(page, limit);

        Page<ResumePostionDto> page1 = new PageImpl<>(resumePostionDtoList, pageable, count);

        return page1;
        }

    }
