package cn.itcast.service;

import cn.itcast.bean.User;
import cn.itcast.dao.LoginDao;

public class LoginService
{
  private LoginDao loginDao;

  public void setLoginDao(LoginDao loginDao)
  {
    this.loginDao = loginDao;
  }

  public User doLogin(User user) {
    return this.loginDao.login(user);
  }
}