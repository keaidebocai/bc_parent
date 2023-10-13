package top.woaibocai.eduservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.woaibocai.eduservice.entitiy.Course;
import top.woaibocai.eduservice.entitiy.vo.CoursePublishVo;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    CoursePublishVo getCoursePublishVoById(String id);
}