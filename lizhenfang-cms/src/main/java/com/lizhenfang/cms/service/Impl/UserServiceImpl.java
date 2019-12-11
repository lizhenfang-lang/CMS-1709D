package com.lizhenfang.cms.service.Impl;

import org.springframework.stereotype.Service;

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
		return false;
	}

	@Override
	public boolean unlocked(Integer userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addScore(Integer userId, int score) {
		// TODO Auto-generated method stub
		return 0;
	}

}
