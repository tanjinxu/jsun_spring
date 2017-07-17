package cn.itcast.service;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bean.Stu;
import cn.itcast.dao.StuDao;

@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
public class StuService {
    private StuDao stuDao;

    public void setStuDao(StuDao stuDao) {
        this.stuDao = stuDao;
    }

    public List<Stu> findAll(String search) {
        return this.stuDao.findAll(search);
    }

    public void delById(String id) {
        this.stuDao.delById(id);
    }

    public Stu findById(String id) {
        return this.stuDao.findById(id);
    }

    public void editById(Stu stu) {
        this.stuDao.editById(stu);
    }

    public void addStu(Stu stu) {
        this.stuDao.addStu(stu);
    }

    public void delAll(String[] id) {
        this.stuDao.delAll(id);
    }
}