package top.woaibocai.eduservice.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.woaibocai.eduservice.entitiy.Subject;

/**
* @author 36519
* @description 针对表【edu_subject(课程科目)】的数据库操作Mapper
* @createDate 2023-10-04 13:33:18
* @Entity top.woaibocai.entitiy.Subject
*/
@Mapper
public interface SubjectMapper extends BaseMapper<Subject> {

}




