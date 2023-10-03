package top.woaibocai.cos.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.woaibocai.commonutils.R;
import top.woaibocai.cos.service.CosService;

import java.io.IOException;

/**
 * @program: bc_parent
 * @description:
 * @author: woaibocai
 * @create: 2023-10-03 19:33
 **/
@RestController
@RequestMapping("/educos/filecos")
@CrossOrigin
@Api(tags = "cos",value = "cos")
public class CosController {
    @Autowired
    private CosService cosService;
    //上传头像的方法
    @ApiOperation("avatar")
    @PostMapping
    public R uploadCosFile(MultipartFile file) throws Exception {
        //获取上传文件 MultipartFile
        //返回上传到cos的url路径
        String url = cosService.uploadFileAvatar(file);
        return R.ok().data("url",url);
    }
}
