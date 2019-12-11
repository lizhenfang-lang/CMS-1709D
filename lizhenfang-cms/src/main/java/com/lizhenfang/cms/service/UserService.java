package com.lizhenfang.cms.service;

import com.lizhenfang.cms.pojo.User;

/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2019年12月11日 上午9:06:48
**/
public interface UserService {
	/**
	 * 注册新增用户
	 * @param user
	 * @return
	 */
	public boolean register(User user);
	/**
	 * 根据登录名称，查询用户
	 * @param username
	 * @return
	 */
	public User getByUsername(String username);
	
	/**
	 * 加锁
	 * @param userId
	 * @return
	 */
	boolean locked(Integer userId);
	/**
	 * 解锁
	 * @param userId
	 * @return
	 */
	boolean unlocked(Integer userId);
	/**
	 * 给用户添加积分
	 * @param userId
	 * @param score
	 * @return
	 */
	int addScore(Integer userId,int score);
}
