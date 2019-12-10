package com.lizhenfang.cms.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lizhenfang.cms.dao.UserDao;
import com.lizhenfang.cms.pojo.User;

/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2019年12月10日 下午7:36:44
**/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/spring-beans.xml")
public class UserTest {
	@Autowired
	private UserDao userDao;
	@Test
	public void select() {
		List<User> userlist=userDao.select();
		System.out.println(userlist);
	}
}
