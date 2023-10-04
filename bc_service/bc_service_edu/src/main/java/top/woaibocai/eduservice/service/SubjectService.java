package top.woaibocai.eduservice.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;
import top.woaibocai.eduservice.entitiy.Subject;

/**
* @author 36519
* @description 针对表【edu_subject(课程科目)】的数据库操作Service
* @createDate 2023-10-04 13:33:18
*/
public interface SubjectService extends IService<Subject> {

    void saveSubject(MultipartFile file,SubjectService subjectService);
}
