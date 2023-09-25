package top.woaibocai.eduservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.woaibocai.eduservice.entitiy.Teacher;

import java.util.Map;

/**
* @author 36519
* @description 针对表【edu_teacher(讲师)】的数据库操作Mapper
* @createDate 2023-09-24 23:33:07
* @Entity top.woaibocai.entitiy.Teacher
*/
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {



}




