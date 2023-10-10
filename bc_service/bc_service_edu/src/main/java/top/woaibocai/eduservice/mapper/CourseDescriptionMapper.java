package top.woaibocai.eduservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.woaibocai.eduservice.entitiy.CourseDescription;


/**
* @author 36519
* @description 针对表【edu_course_description(课程简介)】的数据库操作Mapper
* @createDate 2023-10-07 08:13:25
* @Entity top.woaibocai.entitiy.CourseDescription
*/
@Mapper
public interface CourseDescriptionMapper extends BaseMapper<CourseDescription> {

}




