package top.woaibocai.eduservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.woaibocai.eduservice.entitiy.Teacher;


/**
* @author 36519
* @description 针对表【edu_teacher(讲师)】的数据库操作Mapper
* @createDate 2023-09-24 23:33:07
* @Entity top.woaibocai.entitiy.Teacher
*/
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {



}




