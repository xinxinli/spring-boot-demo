package com.eshore.project.springbootdemo.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eshore.project.springbootdemo.dao.UserMapper;
import com.eshore.project.springbootdemo.entity.User;
import com.eshore.project.springbootdemo.util.BaseRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lixinxin
 * @since 2020-01-03
 */
@RestController
@RequestMapping("/user")
@Api(value="/user",tags={"用户信息控制层"})
public class UserController {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    UserMapper userMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${com.neo.title}")
    private String title;
    @Value("${com.neo.description}")
    private String description;

    /**
     * 测试mongo
     * @return
     */
    @RequestMapping("/saveMogoUser")
    public User saveMogoUser() {
        User user=new User("小红", "aa", "aa123456");
        return mongoTemplate.save(user);
    }

    @GetMapping("/getMogoUser")
    public User getMogoUser(String username) {
        Query query=new Query(Criteria.where("userName").is(username));
        User user =  mongoTemplate.findOne(query , User.class);
        return user;
    }
    /**
     * 测试session的共享
     * @param session
     * @return
     */
    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

    /**
     * 测试springboot
     * @return
     */
    @GetMapping("/hello")
    public String index() {
        return "Hello World";
    }

    /**
     * 测试redis
     * @return
     */
    @GetMapping("/getRedis")
    public String getRedis() throws InterruptedException {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        String value = stringRedisTemplate.opsForValue().get("aaa");
        User user=new User("刘金山", "aa", "aa123456");
        ValueOperations<String, User> operations=redisTemplate.opsForValue();
        operations.set("com.neox", user);
        Thread.sleep(1000);
        boolean exists=redisTemplate.hasKey("com.neox");
        if(exists){
            System.out.println("exists is true");
        }else{
            System.out.println("exists is false");
        }
        return value;
    }

    @RequestMapping("/getUser")
    @Cacheable(value="user-key")
    public User getUser() {
        User user=new User("aa@126.com", "aa", "aa123456");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }

    @ApiOperation(notes = "获取-用户信息列表", httpMethod = "GET", value = "获取-用户信息列表")
    @RequestMapping(value = "/getUsers",method = RequestMethod.GET)
    public BaseRes<List<User>> getUsers(){
        BaseRes<List<User>> res = null;
        List<User> users = userMapper.getUsers();
        res =  new BaseRes<List<User>>(BaseRes.CODE_SUCCESS, BaseRes.MSG_SUCCESS, users);
        res.setTotalCount(users.size());
        return res;
    }

    @ApiOperation(notes = "通过ID获取-用户信表", httpMethod = "GET", value = "通过ID获取-用户信息")
    @GetMapping("/getUserById")
    public BaseRes<User> getUserById(String id){
        BaseRes<User> res = null;
        EntityWrapper<User> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("id",id);
        List<User> users = userMapper.selectList(entityWrapper);
        res =  new BaseRes<User>(BaseRes.CODE_SUCCESS, BaseRes.MSG_SUCCESS, users.get(0));
        return res;
    }

    //分页
    @ApiOperation(notes = "分页查询-用户信表", httpMethod = "POST", value = "分页查询-用户信息")
    @PostMapping("/findBusinessOppPage")
    public BaseRes<List<User>> findBusinessOppPage(@RequestBody User user) {
        System.out.println(title);
        System.out.println(description);
        return null;
    }
}

