package top.woaibocai.eduservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.woaibocai.commonutils.R;
import top.woaibocai.eduservice.entitiy.subject.OneSubject;
import top.woaibocai.eduservice.service.SubjectService;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
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


    @ApiOperation("课程分类列表(树形)")
    @GetMapping("getAllSubject")
    public R getAllSubjectTree(){

        List<OneSubject> result = subjectService.getAllSubjectTree();
        return R.ok().data("list",result);
    }

}
