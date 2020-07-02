package com.xsz.repository;

import com.xsz.entity.DictValue;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class DTODao {
    @Resource
    private JdbcTemplate jdbcTemplate;


    public List<Map<String, Object>> showSkillByLimit(String id, String number, String limit) {
        Integer offset = (Integer.parseInt(number) - 1) * Integer.parseInt(limit);

        String sql = "select * from tb_dict_value where dict_type_id = ? limit ?, ?";

        return jdbcTemplate.queryForList(sql, new Object[]{2, offset, Integer.parseInt(limit)});
    }

    /**修改用户角色**/
    public int modifyRole(String id){
        String sql = "update tb_user_role set role_id = 2 where uid = ?";

        Integer count = jdbcTemplate.update(sql, (PreparedStatement ps)->{
                ps.setString(1, id);
            });

        return count;
    }
}
