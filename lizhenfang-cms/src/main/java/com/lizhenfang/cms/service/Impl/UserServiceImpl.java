package com.lizhenfang.cms.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
		return false;
	}

	@Override
	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
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

}
