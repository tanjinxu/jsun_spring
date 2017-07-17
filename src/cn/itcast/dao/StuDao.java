package cn.itcast.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import cn.itcast.bean.Stu;

public class StuDao extends JdbcDaoSupport {
    public List<Stu> findAll(String search) {
        String sql = (search != null) ? "select * from stu where name like '%" + search + "%'" : "select * from stu";
        return getJdbcTemplate().query(sql, new StuRowMapper());
    }

    public void delById(String id) {
        String sql = "delete from stu where id = ?";
        getJdbcTemplate().update(sql, new Object[] { id });
    }

    public Stu findById(String id) {
        String sql = "select * from stu where id = ?";
        Stu stu = (Stu) getJdbcTemplate().queryForObject(sql, new StuRowMapper(), new Object[] { id });
        return stu;
    }

    public void editById(Stu stu) {
        String sql = "update stu set name = ? ,age = ? , sex = ? where id = ?";
        getJdbcTemplate().update(sql,
                new Object[] { stu.getName(), stu.getAge(), stu.getSex(), Integer.valueOf(stu.getId()) });
    }

    public void addStu(Stu stu) {
        String sql = "insert into stu values (null,?,?,?)";
        getJdbcTemplate().update(sql, new Object[] { stu.getName(), stu.getAge(), stu.getSex() });
    }

    public void delAll(String[] id) {
        for (String sid : id) {
            String sql = "delete from stu where id = ?";
            getJdbcTemplate().update(sql, new Object[] { sid });
        }
        int a = 1 / 0;
    }

    class StuRowMapper implements RowMapper<Stu> {
        StuRowMapper() {
        }

        public Stu mapRow(ResultSet rs, int rowNum) throws SQLException {
            Stu stu = new Stu();
            stu.setId(rs.getInt("id"));
            stu.setName(rs.getString("name"));
            stu.setAge(rs.getString("age"));
            stu.setSex(rs.getString("sex"));
            return stu;
        }
    }
}