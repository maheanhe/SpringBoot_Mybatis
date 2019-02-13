package anhe.service;

import java.util.List;

import anhe.entity.TUser;
/**
 * 用户服务
 * @author 文浩
 *
 */
public interface UserService {
	/**
	 * 获得所有用户
	 * @return
	 */
	List<TUser> findAllUser();
	/**
	 * 增加用户
	 * @param user
	 */
	void addUser(TUser user);
	/**
	 * 删除用户
	 * @param id
	 */
	void deleteUser(Integer id);
	/**
	 * 更改用户
	 * @param user
	 */
	void updateUser(TUser user);
	/**
	 * 搜索用户
	 * @param user
	 */
	List<TUser> searchUser(TUser user);
}
