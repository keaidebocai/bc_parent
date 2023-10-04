package top.woaibocai.eduservice.listener;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import top.woaibocai.eduservice.entitiy.Subject;
import top.woaibocai.eduservice.entitiy.excel.SubjectData;
import top.woaibocai.eduservice.service.SubjectService;
import top.woaibocai.servicebase.exceptionhandler.GuliException;

/**
 * @program: bc_parent
 * @description: 监听器
 * @author: woaibocai
 * @create: 2023-10-04 13:55
 **/
public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {
    //因为SubjectExcelListener不能交给spring进行管理，需要自己new，不能注入其他对象
    //不能实现数据库操作，除非手写jdbc
    //手动把有参构造和无参构造写出来，使它能够进行添加操作
    public SubjectService subjectService;
    public SubjectExcelListener(){}
    public SubjectExcelListener(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    //读取excel的内容，一行一行的读取
    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        if (subjectData == null){
            throw new GuliException(20001,"文件数据为空");
        }

        //一行一行的读取，每次读取有两个值，第一个值一级分类，第二个值二级分类
        //判断一级分类是否重复
        Subject existOneSubject = this.existOneSubject(subjectData.getOneSubjectName(), subjectService);
        //没有相同的一级分类，则添加
        if (existOneSubject == null){
            existOneSubject = new Subject();
            existOneSubject.setParentId("0");
            existOneSubject.setTitle(subjectData.getOneSubjectName());
            subjectService.save(existOneSubject);
        }
        //获取积极分类的id值
        String pid = existOneSubject.getId();
        //添加二级分类
        //判断二级分类是否重复
        Subject existTwoSubject = this.existTwoSubject(subjectData.getTwoSubjectName(), pid, subjectService);
        if (existTwoSubject == null){
            existTwoSubject.setParentId(pid);
            existTwoSubject.setTitle(subjectData.getTwoSubjectName());
            subjectService.save(existTwoSubject);
        }

    }

    //判断一级分类不能重复处添加
    private Subject existOneSubject(String name,SubjectService subjectService){
        LambdaQueryWrapper<Subject> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Subject::getTitle,name);
        wrapper.eq(Subject::getParentId,"0");
        Subject oneSubject = subjectService.getOne(wrapper);
        return oneSubject;
    }
    //判断二级分类不能重复添加
    private Subject existTwoSubject(String name,String pid,SubjectService subjectService){
        LambdaQueryWrapper<Subject> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Subject::getTitle,name);
        wrapper.eq(Subject::getParentId,pid);
        Subject twoSubject = subjectService.getOne(wrapper);
        return twoSubject;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
