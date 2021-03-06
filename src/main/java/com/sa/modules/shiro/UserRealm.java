package com.sa.modules.shiro;

import com.sa.modules.dao.MenuDao;
import com.sa.modules.dao.UserDao;
import com.sa.modules.entity.MenuEntity;
import com.sa.modules.entity.UserEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @Author: moe
 * @Date: 2018/04/16
 * @Description: 认证
 */
@Component
public class UserRealm extends AuthorizingRealm {
	@Autowired
	private UserDao UserDao;
	@Autowired
	private MenuDao menuDao;

	/**
	 * 认证(登录时调用)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken)authcToken;

		//查询用户信息
		UserEntity user = UserDao.queryByUserName(token.getUsername());
		//账号不存在
		if(user == null) {
			throw new UnknownAccountException("账号或密码不正确");
		}
		if (user.getStatus() == 0){
			throw new UnknownAccountException("账号被锁定");
		}

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
		return info;
	}


	/**
	 * 授权(验证权限时调用)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		UserEntity user = (UserEntity)principals.getPrimaryPrincipal();
		Long userId = user.getUserId();

		List<String> permsList = null;

		//系统管理员，拥有最高权限
		if(userId == 1){
			List<MenuEntity> powerList = menuDao.queryAllPowers();
			permsList = new ArrayList<>(powerList.size());
			for(MenuEntity power : powerList){
				permsList.add(power.getUrl());
			}
		}else{
			permsList = UserDao.queryUserPowers(userId);
		}

		//用户权限列表
		Set<String> permsSet = new HashSet<String>();
		for(String perms : permsList){
			if(StringUtils.isBlank(perms)){
				continue;
			}
			permsSet.addAll(Arrays.asList(perms.trim().split(",")));
		}

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(permsSet);
		return info;
	}

	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
		shaCredentialsMatcher.setHashAlgorithmName(ShiroUtils.hashAlgorithmName);
		shaCredentialsMatcher.setHashIterations(ShiroUtils.hashIterations);
		super.setCredentialsMatcher(shaCredentialsMatcher);
	}
}
