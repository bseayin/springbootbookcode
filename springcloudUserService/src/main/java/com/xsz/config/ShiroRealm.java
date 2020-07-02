package com.xsz.config;

import com.xsz.entity.Permission;
import com.xsz.entity.Role;
import com.xsz.entity.User;
import com.xsz.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

//import com.zz.entity.User;
//import com.zz.repository.UserRepository;

//import com.springboot.dao.UserMapper;
//import com.springboot.pojo.User;

public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    /**
     * 获取用户角色和权限
     * /**
     * * 此方法调用 hasRole,hasPermission的时候才会进行回调. ** 权限信息.(授权):
     * * 1、如果用户正常退出，缓存自动清空；
     * * 2、如果用户非正常退出，缓存自动清空；
     * * 3、如果我们修改了用户的权限，而用户不退出系统，修改的权限无法立即生效。
     * * （需要手动编程进行实现；放在service进行调用）
     * * 在权限修改后调用realm中的方法，realm已经由spring管理，所以从spring中获取realm实例，
     * * 调用clearCached方法；
     * * :Authorization 是授权访问控制，用于对用户进行的操作授权，证明该用户是否允许进行当前操作，如访问某个链
     * 接，某个资源文件等。
     * * @param principals
     * * @return
     * */

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        /*
         * 当没有使用缓存的时候，不断刷新页面的话，这个代码会不断执行，
         * 当其实没有必要每次都重新设置权限信息，所以我们需要放到缓存中进行管理；
         * 当放到缓存中时，这样的话，doGetAuthorizationInfo就只会执行一次了，
         * 缓存过期之后会再次执行。
         */
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User userInfo = (User)principal.getPrimaryPrincipal();

        ///在认证成功之后返回.
        //设置角色信息.
        //支持 Set集合,
        //用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要
        // List<Role> roleList=user.getRoleList();
        // for (Role role : roleList) {
        // info.addStringPermissions(role.getPermissionsName());
        // }

        for(Role role:userInfo.getRoles()){
            authorizationInfo.addRole(role.getRole());
            for(Permission p:role.getPermissions()){
                authorizationInfo.addStringPermission(p.getPermission());
            } }
        //设置权限信息.
        // authorizationInfo.setStringPermissions(getStringPermissions(userInfo.getRoleList()))
        return authorizationInfo;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        System.out.println("用户" + userName + "认证-----ShiroRealm.doGetAuthenticationInfo");
        User user = userService.getByUname(userName);

        if (user == null) {
            throw new UnknownAccountException("用户名不存在！");
        }
//        //1. MD5加密不可以破解
//        //2. 登录比较的是，两个密文
//        if (!password.equals(user.getPwd())) {
//            throw new IncorrectCredentialsException("密码错误！");
//        }
//        if (user.getStatus().equals("0")) {
//            throw new LockedAccountException("账号已被锁定,请联系管理员！");
//        }
//        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());

        //加密方式;
//交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, //用户名
                user.getPwd(), //密码
                getName() //realm name
        );
        return authenticationInfo;
    }

}
