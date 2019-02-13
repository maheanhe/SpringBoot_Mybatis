package anhe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import anhe.entity.TUser;
import anhe.entity.common.Result;
import anhe.service.UserService;

/**
 * 用户数据接口
 * 
 * @author 文浩
 *
 */
@RestController
@RequestMapping("/tuser")
@PreAuthorize("hasAuthority('userList')")
public class UserController {

	@Autowired
	private UserService userServiceImpl;

	/**
	 * 获得所有用户
	 * 
	 * @return
	 */
	@RequestMapping("/findAllUser")
	public List<TUser> findAllUser() {
		return userServiceImpl.findAllUser();
	}

	/**
	 * 添加用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/addUser", method = {RequestMethod.POST })
	public Result addUser(@RequestBody TUser user) {
		if (user.getName() == null || user.getName().equals("") || user.getName().equals("null")
				|| user.getPassword() == null || user.getPassword().equals("") || user.getPassword().equals("null")) {
			return new Result("用户名或密码不能为空", false);
		}
		try {
			userServiceImpl.addUser(user);
			return new Result("添加成功", true);
		} catch (Exception e) {
			return new Result("添加失败", false);
		}
	}

	/**
	 * 删除用户
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteUser")
	public Result deleteUser(Integer id) {
		try {
			userServiceImpl.deleteUser(id);
			return new Result("删除成功", true);
		} catch (Exception e) {
			return new Result("删除失败", false);
		}
	}

	/**
	 * 更新用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/updateUser", method = {RequestMethod.POST })
	public Result updateUser(@RequestBody TUser user) {
		if (user.getName() == null || user.getName().equals("") || user.getName().equals("null")
				|| user.getPassword() == null || user.getPassword().equals("") || user.getPassword().equals("null")) {
			return new Result("用户名或密码不能为空", false);
		}
		try {
			userServiceImpl.updateUser(user);
			return new Result("更新成功", true);
		} catch (Exception e) {
			return new Result("更新失败", false);
		}
	}

}
