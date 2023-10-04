package top.woaibocai.eduservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.woaibocai.commonutils.R;
import top.woaibocai.eduservice.service.SubjectService;

/**
 * @program: bc_parent
 * @description: 课程管理
 * @author: woaibocai
 * @create: 2023-10-04 13:40
 **/
@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
@Api(value = "课程接口",tags = "课程类接口")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    //添加课程分类
    //获取上传的文件，把文件读取出来
    /**
    * @Description: 添加课程分类，获取上传的文件，把文件读取出来
    * @Param: [file]
    * @return: top.woaibocai.commonutils.R
    * @Author: woaibocai
    * @Date: 2023/10/4
    */
    @ApiOperation("上传文件")
    @PostMapping("addSubject")
    public R addSubject(MultipartFile file){
        //上传过来的文件
        subjectService.saveSubject(file,subjectService);
        return R.ok();
    }

}
