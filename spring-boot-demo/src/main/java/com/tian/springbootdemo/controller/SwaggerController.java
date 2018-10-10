package com.tian.springbootdemo.controller;

import com.tian.springbootdemo.dao.domain.User;
import com.tian.springbootdemo.vo.ResObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @auther: lawt
 * @date: 2018/10/9 21
 * @Description:
 */
@Api(description = "用户接口",value = "my swagger")
@RestController
@RequestMapping("/demoController")
public class SwaggerController {

    @ApiOperation(value = "新增用户" ,  notes="新增注册")
    @RequestMapping(value="/createUser",method= RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResObject createUser(@RequestBody User user){
        System.out.println("createUser:::"+user.toString());
        return new ResObject(HttpStatus.OK.value(), "新增成功.");
    }

    @ApiOperation(value = "修改用户" ,  notes="修改用户")
    @RequestMapping(value="/updateUser",method=RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResObject updateUser(@RequestBody User user){
        System.out.println("updateUser:::"+user.toString());
        return new ResObject(HttpStatus.OK.value(), "修改成功.");
    }

    @ApiOperation(value = "删除用户" ,  notes="删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户标识", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value="/deleteUser",method=RequestMethod.DELETE)
    public ResObject deleteUser(@RequestParam("userId") String userId){
        System.out.println("deleteUser:::"+userId);
        return new ResObject(HttpStatus.OK.value(), "删除成功.");
    }

    @ApiOperation(value = "查询用户" ,  notes="查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户标识", required = true, paramType = "query", dataType = "Integer")
    })
    @RequestMapping(value="/queryUser",method=RequestMethod.GET)
    public ResObject queryUser(@RequestParam("userId") Integer userId){
        System.out.println("queryUser:::"+userId);
        User user = new User(userId, "张三", "man", 22);
        return new ResObject(HttpStatus.OK.value(), user);
    }

}