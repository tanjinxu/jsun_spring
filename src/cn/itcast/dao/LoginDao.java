package cn.itcast.dao;

import cn.itcast.bean.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class LoginDao extends JdbcDaoSupport
{
  public User login(User user)
  {
    String sql = "select * from login where name = ? and pass = ?";
    try {
      User u = (User)getJdbcTemplate().queryForObject(sql, new UserRowMapper(), new Object[] { user.getName(), user.getPass() });
      return u; } catch (Exception e) {
    }
    return null;
  }

  class UserRowMapper implements RowMapper<User>
  {
    UserRowMapper()
    {
    }

    public User mapRow(ResultSet rs, int rowNum) throws SQLException
    {
      User user = new User();
      user.setPass(rs.getString("pass"));
      user.setName(rs.getString("name"));
      return user;
    }
  }
}