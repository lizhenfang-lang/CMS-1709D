package com.lizhenfang.cms.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lizhenfang.cms.common.CmsMd5Util;
import com.lizhenfang.cms.dao.UserDao;
import com.lizhenfang.cms.pojo.User;
import com.lizhenfang.cms.service.UserService;

/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2019年12月11日 上午9:07:05
**/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		user.setPassword(CmsMd5Util.string2MD5(user.getPassword()));
		user.setLocked(0);
		user.setScore(0);
		user.setRole("0");
		return userDao.insert(user)>0;
	}

	@Override
	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		System.out.println(userDao.selectByUsername(username));
		return userDao.selectByUsername(username);
	}

	@Override
	public boolean locked(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.updateLocked(userId,1)>0;
	}

	@Override
	public boolean unlocked(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.updateLocked(userId,0)>0;
	}

	@Override
	public int addScore(Integer userId, int score) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageInfo<User> getPageInfo(User user, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		List<User> userList = userDao.select(user);
		return new PageInfo<>(userList);
	}

	@Override
	public boolean update(User user) {
		user.setUpdateTime(new Date());
		return userDao.update(user)>0;
		
	}
	@Override
	public boolean isExist(String username) {
		return getByUsername(username)!=null;
	}

	@Override
	public User getById(Integer id) {
		return userDao.selectById(id);
	}
}
