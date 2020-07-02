package com.xsz.controller;


import com.xsz.dto.JobDto;
import com.xsz.entity.*;
import com.xsz.service.DTODao;
import com.xsz.service.UserService;
import com.xsz.util.ResultVOUtil;
import com.xsz.util.XSZUtil;
import com.xsz.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("user")
@Api(value = "用户控制类")
public class UserController {
    @Value("${imagesPath}")
    private String imagesPath;
    @Value("${applicationPath}")
    private String applicationPath;
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DTODao dtoDao;
    @Resource
    private XSZUtil xszUtil;


    @ApiOperation(value = "登录API")
    @PostMapping("/login")
    public ResultVO selectByNamePwd(@RequestBody  User user, HttpServletRequest request) {
        System.out.println("username***"+user.getUname());
        System.out.println("password***"+user.getPwd());

        String password=user.getPwd();
        String username=user.getUname();

        HttpHeaders httpHeaders = new HttpHeaders();
        MediaType type=MediaType.parseMediaType("application/json;charset=UTF-8");
        httpHeaders.setContentType(type);

        HashMap<String, Object> map = new HashMap<>();
        map.put("uname", username);
        map.put("pwd", password);

        HttpEntity<Map<String, Object>> objectHttpEntity = new HttpEntity<>(map,httpHeaders);
        ResponseEntity<ResultVO> resultVO = restTemplate.postForEntity("http://USERCENTER/user/login", objectHttpEntity, ResultVO.class);

//        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
//        request.add("name", username);
//        request.add("pwd", password);

//        ResultVO resultVO=this.restTemplate.postForObject("http://USERCENTER/user/login",request,ResultVO.class);
        System.out.println(resultVO);
        if("成功".equals(resultVO.getBody().getMsg())){

            LinkedHashMap<String, Object> rs=(LinkedHashMap)resultVO.getBody().getData();

            HttpSession session=request.getSession();

            User loginuser =new User();
            loginuser.setId((String) rs.get("id"));
            loginuser.setName((String) rs.get("name"));
            loginuser.setUname((String) rs.get("uname"));
            loginuser.setMobile((String) rs.get("mobile"));
            loginuser.setSex((String) rs.get("sex"));
            loginuser.setEmail((String) rs.get("email"));
            loginuser.setAge((Integer) rs.get("age"));

            LinkedHashMap<String, Object> roleMap=(LinkedHashMap) ((ArrayList)rs.get("roles")).get(0);
            System.out.println(roleMap.get("role"));

            Set<Role> roles=new HashSet<>();

            Role role=new Role();
            role.setRole((String)roleMap.get("role"));
            role.setId(Long.parseLong(roleMap.get("id").toString()));
            Set<Permission> permissions = new HashSet<>();
            ((ArrayList<LinkedHashMap<String, Object>>)roleMap.get("permissions")).forEach(p->{
                Permission permission = new Permission();
                permission.setId(Long.parseLong(p.get("id").toString()));
                permission.setPermission((String) p.get("permission"));
                permissions.add(permission);
            });
            role.setPermissions(permissions);

            roles.add(role);

            loginuser.setRoles(roles);


            session.setAttribute("loginuser", loginuser);

            return ResultVOUtil.success(loginuser);
        }else {
            return ResultVOUtil.error(500,resultVO.getBody().getMsg());
        }
    }

    /**查询当前用户信息**/
    @ApiOperation(value = "当前登录用户信息")
    @GetMapping("/current")
    public ResultVO showUserInfo(HttpServletRequest req){
        User loginuser=(User)req.getSession().getAttribute("loginuser");

        return ResultVOUtil.success(loginuser);
    }

    /**查询当前用户信息**/
    @ApiOperation(value = "用户信息")
    @GetMapping("/info")
    public ResultVO showUserById(HttpServletRequest req){
        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        String id = ((User)req.getSession().getAttribute("loginuser")).getId();

        ResultVO resultVO=this.restTemplate.getForObject("http://USERCENTER/user/info?id={0}",ResultVO.class, new String[]{id});
        return ResultVOUtil.success(resultVO);
    }

    /**修改当前用户信息**/
    @ApiOperation(value = "修改用户信息")
    @PostMapping("/infoEdit")
    public ResultVO UserInfoEdit(@RequestBody  User user, HttpServletRequest req){
        HttpHeaders httpHeaders = new HttpHeaders();
        MediaType type=MediaType.parseMediaType("application/json;charset=UTF-8");
        httpHeaders.setContentType(type);

        User loginuser=(User)req.getSession().getAttribute("loginuser");
        user.setId(loginuser.getId());


        HttpEntity<Map<String, Object>> objectHttpEntity = new HttpEntity<>(XSZUtil.objectToMap(user),httpHeaders);
        ResponseEntity<ResultVO> resultVO = restTemplate.postForEntity("http://USERCENTER/user/infoEdit", objectHttpEntity, ResultVO.class);
        return ResultVOUtil.success(resultVO.getBody().getData());
    }

    /**验证当前用户原始密码**/
    @ApiOperation(value = "验证原始密码")
    @PostMapping("/confirmOldPwd")
    public ResultVO confirmOldPwd(@RequestBody  User user, HttpServletRequest req){
        HttpHeaders httpHeaders = new HttpHeaders();
        MediaType type=MediaType.parseMediaType("application/json;charset=UTF-8");
        httpHeaders.setContentType(type);

        User loginuser=(User)req.getSession().getAttribute("loginuser");
        user.setId(loginuser.getId());


        HttpEntity<Map<String, Object>> objectHttpEntity = new HttpEntity<>(XSZUtil.objectToMap(user),httpHeaders);
        ResponseEntity<ResultVO> resultVO = restTemplate.postForEntity("http://USERCENTER/user/confirmOldPwd", objectHttpEntity, ResultVO.class);
        return ResultVOUtil.success(resultVO.getBody().getMsg());
    }


    /**修改当前用户密码**/
    @ApiOperation(value = "修改密码")
    @PostMapping("/modifyPwd")
    public ResultVO modifyPwd(@RequestBody  User user, HttpServletRequest req){
        HttpHeaders httpHeaders = new HttpHeaders();
        MediaType type=MediaType.parseMediaType("application/json;charset=UTF-8");
        httpHeaders.setContentType(type);

        User loginuser=(User)req.getSession().getAttribute("loginuser");
        user.setId(loginuser.getId());


        HttpEntity<Map<String, Object>> objectHttpEntity = new HttpEntity<>(XSZUtil.objectToMap(user),httpHeaders);
        ResponseEntity<ResultVO> resultVO = restTemplate.postForEntity("http://USERCENTER/user/modifyPwd", objectHttpEntity, ResultVO.class);
        return ResultVOUtil.success(resultVO.getBody().getMsg());
    }

    /**
     *
     * 注册
     * 注意： 数据库保存的密码是 MD5加密以后的密文
     * @param user
     * @return
     */
    @ApiOperation(value = "注册")
    @PostMapping("/register")
    public ResultVO add(@RequestBody  User user) {
        HttpHeaders httpHeaders = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json;charset=UTF-8");
        httpHeaders.setContentType(type);

        Set<Role> roleSet = new HashSet<>();
        Role role = new Role();
        role.setId(1l);
        roleSet.add(role);

        user.setRoles(roleSet);

        HttpEntity<Map<String, Object>> objectHttpEntity = new HttpEntity<>(XSZUtil.objectToMap(user), httpHeaders);
        ResponseEntity<ResultVO> resultVO = restTemplate.postForEntity("http://USERCENTER/user/register", objectHttpEntity, ResultVO.class);

        System.out.println(resultVO);
        if("成功".equals(resultVO.getBody().getMsg())){
            return ResultVOUtil.success();
        }else {
            return ResultVOUtil.error(500,resultVO.getBody().getMsg());
        }

    }

    /**根据职位id简历id投递简历**/
    @ApiOperation(value = "根据职位id简历id投递简历")
    @PostMapping("applyJob")
    public ResultVO addResume(@RequestBody JobDto jobDto){
        if(dtoDao.addPositionResume(jobDto) == 1){
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(500, "申请失败");
    }



    /**修改用户头像**/
    @ApiOperation(value = "修改用户头像")
    @PostMapping("/modifyImage")
    public void modifyImage(HttpServletRequest request, HttpServletResponse response) throws IOException {

        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;

        MultipartFile multipartFile = multipartHttpServletRequest.getFile("imageFile");

        String fileName = multipartFile.getOriginalFilename();

        String id = ((User)request.getSession().getAttribute("loginuser")).getId();

        File file = new File(imagesPath.substring(6) + id + "-" + fileName);
        multipartFile.transferTo(file);

        ResultVO resultVO = restTemplate.postForObject("http://USERCENTER/user/modifyImage/{0}/{1}", null, ResultVO.class, fileName, id);

        response.sendRedirect("/job/myProfile.html");
    }

    /**登出**/
    @ApiOperation(value = "登出api")
    @GetMapping("logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("loginuser");
        response.sendRedirect("/job/login.html");
    }

    /**企业用户申请**/
    @ApiOperation(value = "企业用户申请api")
    @PostMapping("application")
    public void application(HttpServletRequest request, MultipartHttpServletRequest req, HttpServletResponse response) throws IOException {
        MultipartFile multipartFile = req.getFile("businessLicense");

        String fileName = multipartFile.getOriginalFilename();
        String id = ((User)request.getSession().getAttribute("loginuser")).getId();

        File file = new File(applicationPath.substring(6) + id + "-" + fileName);
        multipartFile.transferTo(file);

        ResultVO resultVO = restTemplate.getForObject("http://USERCENTER/user/application/{0}/{1}",  ResultVO.class, id, fileName);

        response.sendRedirect("/job/myProfile.html");
    }

    /**修改用户角色**/
    @ApiOperation(value = "修改用户角色")
    @GetMapping("/modifyRole/{id}")
    public ResultVO modifyRole(@PathVariable("id") String id) throws IOException {
       ResultVO resultVO = restTemplate.getForObject("http://USERCENTER/user/modifyRole/{0}", ResultVO.class, id);
        return resultVO;
    }

    /**查询所有企业申请**/
    @ApiOperation(value = "查询所有企业申请")
    @GetMapping("showAllApplication")
    public ResultVO showAllApplication(){
        ResultVO resultVO=this.restTemplate.getForObject("http://USERCENTER/user/showAllApplication",ResultVO.class);

        return resultVO;
    }

}
