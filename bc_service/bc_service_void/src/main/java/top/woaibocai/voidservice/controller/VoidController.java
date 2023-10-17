package top.woaibocai.voidservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import top.woaibocai.commonutils.R;
import top.woaibocai.servicebase.exceptionhandler.GuliException;
import top.woaibocai.voidservice.service.VoidService;
import top.woaibocai.voidservice.utils.ConstantVoidUtils;
import top.woaibocai.voidservice.utils.Signature;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @program: bc_parent
 * @description:
 * @author: woaibocai
 * @create: 2023-10-17 11:00
 **/
@RestController
@RequestMapping("/eduvoid/video")
@CrossOrigin
@Api(tags = "VOD上传",value = "VOD上传")
public class VoidController {
    @Resource
    private VoidService voidService;
    //上传视频到VOD的方法
    @ApiOperation("上传")
    @GetMapping("sign")
    public R sign(){
        Signature sign = new Signature();
        // 设置 App 的云 API 密钥
        sign.setSecretId(ConstantVoidUtils.SECRET_ID);
        sign.setSecretKey(ConstantVoidUtils.SECRET_KEY);
        sign.setCurrentTime(System.currentTimeMillis() / 1000);
        sign.setRandom(new Random().nextInt(java.lang.Integer.MAX_VALUE));
        sign.setSignValidDuration(3600 * 24 * 2); // 签名有效期：2天
        try {
            String signature = sign.getUploadSignature();
            return R.ok().data("data",signature);
        } catch (Exception e) {
            throw new GuliException(20001,"获取签名失败");
        }
    }
}
