package top.woaibocai.eduservice.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import top.woaibocai.commonutils.R;
import top.woaibocai.eduservice.entitiy.Teacher;
import top.woaibocai.eduservice.entitiy.vo.TeacherQueryVo;
import top.woaibocai.eduservice.mapper.TeacherMapper;
import top.woaibocai.eduservice.service.TeacherService;

/**
* @author 36519
* @description 针对表【edu_teacher(讲师)】的数据库操作Service实现
* @createDate 2023-09-24 23:33:07
*/
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher>
    implements TeacherService {
    @Autowired
//    @Resource
    private TeacherMapper teacherMapper;
    @Override
    public R pageTeacherCondition(Long current, Long size,@RequestBody(required = false) TeacherQueryVo teacherQueryVo) {
        //创建分页
        IPage<Teacher> teacherIPage = new Page<>(current,size);
        //根据条件查询
        LambdaQueryWrapper<Teacher> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .like(!StringUtils.isEmpty(teacherQueryVo.getName()),Teacher::getName,teacherQueryVo.getName())
                .eq(teacherQueryVo.getLevel() == 1 || teacherQueryVo.getLevel() == 2,Teacher::getLevel,teacherQueryVo.getLevel())
                .ge(!StringUtils.isEmpty(teacherQueryVo.getBegin()),Teacher::getGmtCreate,teacherQueryVo.getBegin())
                .le(!StringUtils.isEmpty(teacherQueryVo.getEnd()),Teacher::getGmtModified,teacherQueryVo.getEnd())
                .orderByDesc(Teacher::getGmtCreate);

        //把查好的数据放进分页
        teacherMapper.selectPage(teacherIPage,queryWrapper);
        //统一返回格式
        return R.ok()
                .data("current",teacherIPage.getCurrent())
                .data("size",teacherIPage.getSize())
                .data("total",teacherIPage.getTotal())
                .data("rows",teacherIPage.getRecords());
    }
}




