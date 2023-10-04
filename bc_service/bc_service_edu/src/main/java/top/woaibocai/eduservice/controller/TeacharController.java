package top.woaibocai.eduservice.controller;


import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.woaibocai.commonutils.R;
import top.woaibocai.eduservice.constans.TeacherConstans;
import top.woaibocai.eduservice.entitiy.Teacher;
import top.woaibocai.eduservice.entitiy.vo.TeacherQueryVo;
import top.woaibocai.eduservice.service.TeacherService;

import java.util.List;


/**
 * @program: bc_parent
 * @description:
 * @author: woaibocai
 * @create: 2023-09-24 23:31
 **/
@Api(value = "教师管理接口",tags = "教师信息类接口")
@RestController
@RequestMapping("/eduservice/teacher")
@CrossOrigin
public class TeacharController {

    @Autowired
    private TeacherService teacherService;
    @ApiOperation("查询用户列表")
    //查询所有信息
    @GetMapping("findAll")
    public R findAll(){
        List<Teacher> list = teacherService.list(null);
        return R.ok().data("items",list);
    }
    @ApiOperation("删除用户")
    @ApiResponse(code = 200,message = "成功！")
    @DeleteMapping("{id}")
    public R deleteById(@PathVariable("id") String id ){
        boolean flag = teacherService.removeById(id);
        if (flag){
            return R.ok();
        }
        return R.error();
    }


    @ApiOperation("分页")
    @GetMapping("{current}/{size}")
    public R page(@PathVariable Long current,
                  @PathVariable Long size){
        IPage<Teacher> teacherIPage = new Page<>(current,size);
        teacherService.page(teacherIPage, null);
        List<Teacher> records = teacherIPage.getRecords();
        long total = teacherIPage.getTotal();
        return R.ok().data("total",total).data("rows",records);
    }
    @ApiOperation("条件分页")
    @PostMapping("pageTeacherCondition/{current}/{size}")
    public R pageTeacherCondition(@PathVariable Long current,
                                  @PathVariable Long size,
                                  @RequestBody(required = false) TeacherQueryVo teacherQueryVo){
        R result = teacherService.pageTeacherCondition(current,size, teacherQueryVo);
        return result;
    }

    @ApiOperation("添加讲师")
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody Teacher teacher){
        //TODO：等前端学习的熟练，一定要来这里把这个默认头像删了，包括那个b常量类！
        if (StringUtils.isEmpty(teacher.getAvatar())){
            teacher.setAvatar(TeacherConstans.DEFAULT_AVATAR);
        }
        Boolean result = teacherService.save(teacher);
        if (result){
            return R.ok();
        }
        return R.error();

    }
    //根据讲师id进行查询
    @GetMapping("getTeacher/{id}")
    public R getTeacher(@PathVariable String id) {
        Teacher teacher = teacherService.getById(id);
        return R.ok().data("teacher",teacher);
    }

    //讲师修改功能
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody Teacher teacher) {
        boolean flag = teacherService.updateById(teacher);
        if(flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }



}
