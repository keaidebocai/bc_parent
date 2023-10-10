package top.woaibocai.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.woaibocai.eduservice.entitiy.Course;
import top.woaibocai.eduservice.entitiy.CourseDescription;
import top.woaibocai.eduservice.entitiy.vo.CourseInfoVo;
import top.woaibocai.eduservice.mapper.CourseDescriptionMapper;
import top.woaibocai.eduservice.mapper.CourseMapper;
import top.woaibocai.eduservice.service.CourseService;
import top.woaibocai.servicebase.exceptionhandler.GuliException;

/**
* @author 36519
* @description 针对表【edu_course(课程)】的数据库操作Service实现
* @createDate 2023-10-07 08:13:25
*/
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    private CourseDescriptionMapper courseDescriptionMapper;
    @Override
    public String addCourseInfo(CourseInfoVo courseInfoVo) {
        //检查主键id是否重复
        Course byId = this.baseMapper.selectById(courseInfoVo.getId());
        if (byId != null){
            throw new GuliException(20001,"此课程名称已被注册！");
        }
        //向课程表里添加信息
        Course course = new Course();
        BeanUtils.copyProperties(courseInfoVo,course);
        int insert = this.baseMapper.insert(course);
        if (insert <= 0){
            throw new GuliException(20001,"插入失败！");
        }
        String cid = course.getId();
        //向简介表里添加信息学
        CourseDescription courseDescription = new CourseDescription();
        courseDescription.setId(cid);
        courseDescription.setDescription(courseInfoVo.getDescription());
        int insert1 = courseDescriptionMapper.insert(courseDescription);
        if (insert1 <= 0){
            throw new GuliException(20001,"插入失败！");
        }
        return cid;
    }

    @Override
    public CourseInfoVo getCourseInfo(String courseId) {
        //根据课程id查询分别查两张表里的信息，然后再封装到vo里返回
        //1.查询course表中的 查鸡毛啊，直接全查，copy进去得了
        Course course = this.baseMapper.selectById(courseId);
        //2.查description表中的description字段
        LambdaQueryWrapper<CourseDescription> wrapper = new LambdaQueryWrapper<>();
        wrapper
                .select(CourseDescription::getDescription)
                .eq(CourseDescription::getId,courseId);
        CourseDescription courseDescription = courseDescriptionMapper.selectOne(wrapper);
        //封装
        CourseInfoVo courseInfoVo = new CourseInfoVo();
        BeanUtils.copyProperties(course,courseInfoVo);
        courseInfoVo.setDescription(courseDescription.getDescription());
        return courseInfoVo;
    }

    @Override
    public void updateCourseInfo(CourseInfoVo courseInfoVo) {
        Course course = new Course();
        BeanUtils.copyProperties(courseInfoVo,course);
        int i = this.baseMapper.updateById(course);
        if (i == 0){
            throw new GuliException(20001,"修改失败！");
        }
        CourseDescription courseDescription = new CourseDescription();
        courseDescription.setId(courseInfoVo.getId());
        courseDescription.setDescription(courseInfoVo.getDescription());
        courseDescriptionMapper.updateById(courseDescription);
    }
}




