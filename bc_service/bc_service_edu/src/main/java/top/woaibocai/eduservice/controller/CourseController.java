package top.woaibocai.eduservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import top.woaibocai.commonutils.R;
import top.woaibocai.eduservice.entitiy.vo.CourseInfoVo;
import top.woaibocai.eduservice.entitiy.vo.CoursePublishVo;
import top.woaibocai.eduservice.service.CourseService;

import javax.annotation.Resource;

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

    @Resource
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
    /**
    * @Description: 根据课程查询课程基本信息
    * @Param: [courseId]
    * @return: top.woaibocai.commonutils.R
    * @Author: woaibocai
    * @Date: 2023/10/10
    */
    @ApiOperation("根据课程查询课程基本信息")
    @GetMapping("getCourseInfo/{courseId}")
    public R getCourseInfo(@PathVariable String courseId){
        CourseInfoVo courseInfoVo = courseService.getCourseInfo(courseId);
        return R.ok().data("courseInfoVo",courseInfoVo);
    }
    /**
    * @Description: 修改课程信息
    * @Param: [courseInfoVo]
    * @return: top.woaibocai.commonutils.R
    * @Author: woaibocai
    * @Date: 2023/10/10
    */
    @ApiOperation("修改课程信息")
    @PostMapping("updateCourseInfo")
    public R updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo){
        courseService.updateCourseInfo(courseInfoVo);
        return R.ok();
    }

    /**
    * @Description: 根据课程id查询确认信息
    * @Param: [id]
    * @return: top.woaibocai.commonutils.R
    * @Author: woaibocai
    * @Date: 2023/10/13
    */
    @ApiOperation("根据课程id查询确认信息")
    @GetMapping("getPublishCourseInfo/{id}")
    public R getPublishCourseInfo(@PathVariable String id){
        CoursePublishVo coursePublish = courseService.getPublishCourseInfo(id);
        return R.ok().data("coursePublish",coursePublish);
    }


}
