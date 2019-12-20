package com.lizhenfang.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lizhenfang.cms.pojo.User;

/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2019年12月10日 下午7:25:41
**/
public interface UserDao {
	/**
	 * 回显
	 * @param id
	 * @return
	 */
	User selectById(Integer id);
	/**
	 * 列表展示
	 * @param user
	 * @return
	 */
	List<User> select(@Param("user") User user);
	/**
	 * 查询条数
	 * @param user
	 * @return
	 */
	int count(@Param("user") User user);
	/**
	 * 添加
	 * @param user
	 * @return
	 */
	int insert(@Param("user") User user);
	/**
	 * 修改
	 * @param user
	 * @return
	 */
	int update(@Param("user") User user);
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	int deleteById(@Param("id") Integer id);
	/**
	 * 批量删除
	 * @param user
	 * @return
	 */
	int deleteByIds(@Param("ids") String ids);
	
	/**
	 * 修改locked字段值 
	 * @param userId
	 * @param locked
	 * @return
	 */
	int updateLocked(@Param("userId") Integer userId, @Param("locked")  int locked);
	/**
	 * @Title: selectByUsername   
	 * @Description: 根据登录名，查询用户  
	 * @param: @param username
	 * @param: @return      
	 * @return: User      
	 * @throws
	 */
	User selectByUsername(@Param("username")String username);
}
