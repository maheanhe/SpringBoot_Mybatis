package anhe.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;

import anhe.entity.TPermission;
import anhe.entity.TRole;
import anhe.entity.TUser;
import anhe.entity.TUserExample;
import anhe.entity.TUserExample.Criteria;
import anhe.mapper.TPermissionMapper;
import anhe.mapper.TRoleMapper;
import anhe.mapper.TUserMapper;

/**
 * 通过用户名获得用户信息
 * 
 * @author 张文浩
 *
 */
@Component
public class TUserDetailsService implements UserDetailsService {

	@Autowired
	private TUserMapper tUserMapper;

	@Autowired
	private TRoleMapper tRoleMapper;

	@Autowired
	private TPermissionMapper tPermissionMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TUser user = null;

		if (username != null) {
			TUserExample tUserExample = new TUserExample();
			Criteria criteria = tUserExample.createCriteria();
			criteria.andNameEqualTo(username);
			List<TUser> userList = tUserMapper.selectByExample(tUserExample);
			if (userList.size() == 1) {
				user = userList.get(0);
			}
		} else {
			//若用户名为空则返回null
			return null;
		}

		//若用户不存在抛出异常
		if (null == user) {
			throw new UsernameNotFoundException(username);
		}

		Set<SimpleGrantedAuthority> authorities = new HashSet<>();

		List<Integer> roleList = JSONArray.parseArray(user.getRolelist(), Integer.class);
		for (Integer roleId : roleList) {
			TRole role = tRoleMapper.selectByPrimaryKey(roleId);
			List<Integer> permissionList = JSONArray.parseArray(role.getPermissionlist(), Integer.class);
			for (Integer permissionId : permissionList) {
				TPermission permission = tPermissionMapper.selectByPrimaryKey(permissionId);
				authorities.add(new SimpleGrantedAuthority(permission.getCode()));
			}
		}

		return new User(user.getName(), user.getPassword(), authorities);
	}
}