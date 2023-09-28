package top.woaibocai.eduservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.web.bind.annotation.*;
import top.woaibocai.commonutils.R;

/**
 * @program: bc_parent
 * @description: 登录接口
 * @author: woaibocai
 * @create: 2023-09-28 09:58
 **/
@RestController
@RequestMapping("/eduservice/user")
@Api(value = "登录管理接口",tags = "登录类接口")
@CrossOrigin
public class EduLoginController {
    @ApiOperation("登录接口")
    //login
    @PostMapping("login")
    public R login(){

        return R.ok().data("token","admin");
    }
    @ApiOperation("info")
    //info
    @GetMapping("info")
    public R info(){

        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://qiniu.woaibocai.top/static/img/tou.png");
    }



}
