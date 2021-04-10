package com.zz.shop.controller;

import com.zz.shop.domain.ShopCarouselDO;
import com.zz.system.dao.UserDao;
import com.zz.system.domain.UserDO;
import com.zz.util.ResultVOUtil;
import com.zz.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/v1/shop/util")
@RestController
public class ShopCommonUtilController {
  @Autowired
  UserDao userDao;
  @ResponseBody
  @GetMapping("/getUserFromOpenId")
  public ResultVO<UserDO> getUserFromOpenId(String openId) {
    Map<String,Object> queryMap = new HashMap<>();
    queryMap.put("openId", openId);
    List<UserDO> userList = userDao.list(queryMap);
    UserDO user = null;
    if (userList.size() > 0) {
      user = userList.get(0);
    }
    return ResultVOUtil.success(user);
  }
}
