package top.woaibocai.eduservice.service;

import top.woaibocai.eduservice.entitiy.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import top.woaibocai.eduservice.entitiy.vo.CourseInfoVo;
import top.woaibocai.eduservice.entitiy.vo.CoursePublishVo;

/**
* @author 36519
* @description 针对表【edu_course(课程)】的数据库操作Service
* @createDate 2023-10-07 08:13:25
*/
public interface CourseService extends IService<Course> {

    String addCourseInfo(CourseInfoVo courseInfoVo);

    CourseInfoVo getCourseInfo(String courseId);

    void updateCourseInfo(CourseInfoVo courseInfoVo);

    CoursePublishVo getPublishCourseInfo(String id);

    Boolean removeCourse(String courseId);
}
