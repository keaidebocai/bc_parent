package top.woaibocai.eduservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.woaibocai.commonutils.R;
import top.woaibocai.eduservice.entitiy.vo.CourseInfoVo;
import top.woaibocai.eduservice.service.CourseService;

/**
 * @program: bc_parent
 * @description: 课程管理
 * @author: woaibocai
 * @create: 2023-10-07 11:18
 **/
@RestController
@CrossOrigin
@RequestMapping("/eduservice/course")
@Api(value = "课程管理接口",tags = "课程管理类接口")
public class CourseController {

    @Autowired
    private CourseService courseService;
    /**
    * @Description: 添加课程信息
    * @Param: [courseInfoVo]
    * @return: top.woaibocai.commonutils.R
    * @Author: woaibocai
    * @Date: 2023/10/7
    */
    @ApiOperation("添加课程信息")
    @PostMapping("addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo){
        String id = courseService.addCourseInfo(courseInfoVo);
        return R.ok().data("courseId",id);
    }


}
