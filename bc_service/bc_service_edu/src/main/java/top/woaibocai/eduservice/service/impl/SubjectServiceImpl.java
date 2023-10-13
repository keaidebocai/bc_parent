package top.woaibocai.eduservice.service.impl;


import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.woaibocai.eduservice.entitiy.Subject;
import top.woaibocai.eduservice.entitiy.excel.SubjectData;
import top.woaibocai.eduservice.entitiy.subject.OneSubject;
import top.woaibocai.eduservice.entitiy.subject.TwoSubject;
import top.woaibocai.eduservice.listener.SubjectExcelListener;
import top.woaibocai.eduservice.mapper.SubjectMapper;
import top.woaibocai.eduservice.service.SubjectService;

import javax.annotation.Resource;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
* @author 36519
* @description 针对表【edu_subject(课程科目)】的数据库操作Service实现
* @createDate 2023-10-04 13:33:18
*/
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {
    @Resource
    private SubjectMapper subjectMapper;
    @Override
    public void saveSubject(MultipartFile file,SubjectService subjectService) {
        try{
            //文件的输入流
//            InputStream in = file.getInputStream();
            InputStream in = new BufferedInputStream(file.getInputStream());
            //调用方法进行读取
            EasyExcel.read(in, SubjectData.class,new SubjectExcelListener(subjectService)).sheet().doRead();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<OneSubject> getAllSubjectTree() {
        //所有的一级分类
        LambdaQueryWrapper<Subject> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(Subject::getId,Subject::getParentId,Subject::getTitle)
                .eq(Subject::getParentId,"0");
        List<Subject> oneSubjectList = baseMapper.selectList(wrapper);
        //所有的二级分类
        LambdaQueryWrapper<Subject> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(Subject::getId,Subject::getParentId,Subject::getTitle)
                .ne(Subject::getParentId,"0");
        List<Subject> twoSubjects = this.baseMapper.selectList(queryWrapper);
        //创建一个list集合用于存储最终的数据
        List<OneSubject> subjectsVo = new ArrayList<>();
        //封装一级分类

        //1.stream 没写完，效率没for好，所以不写了。
//        subjectsVo = oneSubjectList.stream().map(one -> {
//            OneSubject oneSubject = new OneSubject();
//            BeanUtils.copyProperties(one,oneSubject);
//            return oneSubject;
//        }).collect(Collectors.toList());

        //2.for循环
        for (int i = 0; i < oneSubjectList.size(); i++) {
            Subject subject = oneSubjectList.get(i);
            OneSubject oneSubject = new OneSubject();
            BeanUtils.copyProperties(subject,oneSubject);
            //封装二级分类
            //在一级分类循环里遍历查询所有二级分类
            //创建list集合封装每一个一级分类的二级分类
            List<TwoSubject> twoSubjectsVo = new ArrayList<>();
            for (int m = 0; m < twoSubjects.size(); m++) {
                //获取每个二级分类
                Subject tSubject = twoSubjects.get(m);
                //判断二级分类的parentId和一级分类的id是否一样
                if (tSubject.getParentId().equals(oneSubject.getId())){
                    //如果相同那就把他放进twoSubjectsVo里
                    TwoSubject twoSubject = new TwoSubject();
                    BeanUtils.copyProperties(tSubject,twoSubject);
                    twoSubjectsVo.add(twoSubject);
                }
            }
            oneSubject.setChildren(twoSubjectsVo);
            subjectsVo.add(oneSubject);
        }




        //封装二级分类





        return subjectsVo;
    }


}




