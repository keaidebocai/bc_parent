package top.woaibocai.eduservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestBody;
import top.woaibocai.commonutils.R;
import top.woaibocai.eduservice.entitiy.Teacher;
import top.woaibocai.eduservice.entitiy.vo.TeacherQueryVo;

/**
* @author 36519
* @description 针对表【edu_teacher(讲师)】的数据库操作Service
* @createDate 2023-09-24 23:33:07
*/
public interface TeacherService extends IService<Teacher> {


    R pageTeacherCondition(Long current, Long size,@RequestBody(required = false) TeacherQueryVo teacherQueryVo);
}
