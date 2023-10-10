package top.woaibocai.eduservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.woaibocai.eduservice.entitiy.Course;


/**
* @author 36519
* @description 针对表【edu_course(课程)】的数据库操作Mapper
* @createDate 2023-10-07 08:13:25
* @Entity top.woaibocai.entitiy.Course
*/
@Mapper
public interface CourseMapper extends BaseMapper<Course> {

}




