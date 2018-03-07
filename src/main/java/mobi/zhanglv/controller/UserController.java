package mobi.zhanglv.controller;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.*;
import mobi.zhanglv.model.User;
import mobi.zhanglv.model.UserShort;
import mobi.zhanglv.response.BaseContainer;
import mobi.zhanglv.response.RespEntity;
import mobi.zhanglv.response.UserList;
import mobi.zhanglv.service.RedisService;
import mobi.zhanglv.service.UserService;
import mobi.zhanglv.util.CommonUtil;
import mobi.zhanglv.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Max;

/**
 * Author cuizhengwei
 * Date   2017/12/1
 * Description 用户controller
 */
@RestController
@RequestMapping(value="/user")     // 通过这里配置使下面的映射都在/users下，可去除
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "uId", value = "用户ID", required = true, dataType = "int"),
//            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
//    })
    @RequestMapping(value = "/{uId}", method = RequestMethod.GET)
    @ApiOperation(value = "", notes = "根据id获取用户", response = User.class)
    public Object getUserByUId(@PathVariable int uId) throws Exception{
        return RespEntity.generateResp(userService.selectUserByUid(uId));
    }

    @RequestMapping(value = "/short/{uId}", method = RequestMethod.GET)
    @ApiOperation(value = "", notes = "根据id获取用户", response = UserShort.class)
    public Object getUserShortByUId(@PathVariable int uId) throws Exception{
        return RespEntity.generateResp(userService.selectUserShortByUid(uId));
    }

    @RequestMapping(value = "/{uId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "", notes = "根据id删除用户")
    public Object deleteUserShortByUId(@PathVariable int uId, HttpServletRequest request) throws Exception{

        System.out.println("-----api-version----"+request.getHeader("api-version"));

        redisService.set("name", "12333");

        System.out.println("--rrr----"+redisService.get("name"));


        return RespEntity.generateResp(userService.deleteUserByUid(uId));
    }

//    @ResponseBody
//    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)   //
//    @ApiOperation(value = "", notes = "获取用户列表(后台使用)", response = UserList.class)
//    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
//        PageHelper.startPage(pageNum, pageSize);
//        return RespEntity.generateResp(BaseListContainer.generateListContainer(userMapper.countAllUsers(),1,0, "userList", userMapper.selectAllUsers()));
//    }


    @ResponseBody
    @RequestMapping(value = "/all", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    @ApiOperation(value = "", notes = "获取用户列表(后台使用)", response = UserList.class)
    public Object findAllUser(@RequestParam(name = "pageNum", required = true) @Max(value = 3) int pageNum, @RequestParam(name = "pageTime", required = true) int pageTime, @RequestParam(name = "pageSize", required = false) Integer pageSize) throws Exception {
        pageSize = CommonUtil.getPageSize(pageSize);
        PageHelper.startPage(pageNum, pageSize);
        pageTime = TimeUtil.getUnixTimeOfBeiJing();


        logger.info("----info-----");
        logger.warn("----warn-----");
        logger.debug("----debug-----");
        logger.error("----error-----");

        if(true) {
            int i = 5 / 0;
        }

        return null;
//        return RespEntity.generateResp(BaseContainer.generateListContainer(userService.countAllUsers(), pageNum, pageTime, "userList", userService.selectAllUsers()));
    }


    @ResponseBody
    @RequestMapping(value = "/", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    @ApiOperation(value = "", notes = "新增用户", response = User.class)
//    @Transactional
    public Object addUser(@RequestBody User user) throws Exception{
        userService.addNewUser(user);
        userService.addNewUser(user);

        return RespEntity.generateResp(BaseContainer.generateResultContainer(true, ""));
    }



























//    Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.



//    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

//    @ApiOperation(value = "获取用户列表", notes = "")
//    @RequestMapping(value = {""}, method = RequestMethod.GET)
//    public List<User> getUserList() {
//        List<User> r = new ArrayList<User>(users.values());
//        return r;
//    }
//
//    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
//    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
//    @RequestMapping(value = "", method = RequestMethod.POST)
//    public String postUser(@RequestBody User user) {
//        users.put(user.getId(), user);
//        return "success";
//    }
//
//    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
//    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public User getUser(@PathVariable Long id) {
//        return users.get(id);
//    }
//
//    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
//            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
//    })
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public String putUser(@PathVariable Long id, @RequestBody User user) {
//        User u = users.get(id);
//        u.setName(user.getName());
//        u.setAge(user.getAge());
//        users.put(id, u);
//        return "success";
//    }
//
//    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
//    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public String deleteUser(@PathVariable Long id) {
//        users.remove(id);
//        return "success";
//    }

}