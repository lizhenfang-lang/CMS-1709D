package com.lizhenfang.cms.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lizhenfang.cms.dao.ArticleDao;
import com.lizhenfang.cms.dao.ArticleVoteDao;
import com.lizhenfang.cms.dao.CategoryDao;
import com.lizhenfang.cms.dao.ChannelDao;
import com.lizhenfang.cms.dao.CommentDao;
import com.lizhenfang.cms.dao.SettingsDao;
import com.lizhenfang.cms.dao.SlideDao;
import com.lizhenfang.cms.dao.TagDao;
import com.lizhenfang.cms.dao.UserDao;
import com.lizhenfang.cms.dao.VoteContentDao;
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
	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private ArticleVoteDao articleVoteDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ChannelDao channelDao;
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private SettingsDao settingsDao;
	@Autowired
	private SlideDao slideDao;
	@Autowired
	private TagDao tagDao;
	@Autowired
	private VoteContentDao voteContentDao;
	@Test
	public void select() {
		List<User> userlist=userDao.select(null);
		System.out.println(userlist);
		
		User user=new User();
		user.setUsername("李振芳");
		user.setPassword("2323423");
		userDao.deleteByIds("169");
	}
}
