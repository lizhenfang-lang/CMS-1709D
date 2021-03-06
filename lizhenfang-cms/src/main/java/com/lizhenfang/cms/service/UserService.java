package com.lizhenfang.cms.service;

import com.github.pagehelper.PageInfo;
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
	 * 加锁用户
	 * @param userId
	 * @return
	 */
	boolean locked(Integer userId);
	/**
	 * 解锁用户
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
	/**
	 *查询用户列表
	 * @param user
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<User> getPageInfo(User user, int pageNum, int pageSize);
	/**
	 * 更新用户信息
	 * @param user
	 */
	boolean update(User user);
	/**
	 * @Title: isExist   
	 * @Description: 根据用户名判断用户是否存在   
	 * @param: @param username
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	boolean isExist(String username);
	/**
	 * @Title: getById   
	 * @Description: 根据用户Id查询User   
	 * @param: @param id
	 * @param: @return      
	 * @return: User      
	 * @throws
	 */
	User getById(Integer id);
	
	
	
}
