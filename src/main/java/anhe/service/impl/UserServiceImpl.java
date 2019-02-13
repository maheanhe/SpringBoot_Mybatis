package anhe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import anhe.mapper.TUserMapper;
import anhe.entity.TUser;
import anhe.entity.TUserExample;
import anhe.entity.TUserExample.Criteria;
import anhe.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private TUserMapper tUserMapper;

	@Override
	public List<TUser> findAllUser() {
		return tUserMapper.selectByExample(null);
	}

	@Override
	public void addUser(TUser user) {
		tUserMapper.insert(user);
	}

	@Override
	public void deleteUser(Integer id) {
		tUserMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void updateUser(TUser user) {
		tUserMapper.updateByPrimaryKey(user);
	}

	@Override
	public List<TUser> searchUser(TUser user) {
		String name = user.getName();
		TUserExample tUserExample = null;
		if (name != null && !"".equals(name) && !"null".equals(name)) {
			tUserExample = new TUserExample();
			Criteria criteria = tUserExample.createCriteria();
			criteria.andNameLike('%' + name + '%');
		}
		return tUserMapper.selectByExample(tUserExample);
	}

}
