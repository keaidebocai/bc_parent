package top.woaibocai.eduservice.service.impl;


import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.woaibocai.eduservice.entitiy.Subject;
import top.woaibocai.eduservice.entitiy.excel.SubjectData;
import top.woaibocai.eduservice.listener.SubjectExcelListener;
import top.woaibocai.eduservice.mapper.SubjectMapper;
import top.woaibocai.eduservice.service.SubjectService;

import java.io.InputStream;

/**
* @author 36519
* @description 针对表【edu_subject(课程科目)】的数据库操作Service实现
* @createDate 2023-10-04 13:33:18
*/
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Override
    public void saveSubject(MultipartFile file,SubjectService subjectService) {
        try{
            //文件的输入流
            InputStream in = file.getInputStream();
            //调用方法进行读取
            EasyExcel.read(in, SubjectData.class,new SubjectExcelListener(subjectService)).sheet().doRead();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}




