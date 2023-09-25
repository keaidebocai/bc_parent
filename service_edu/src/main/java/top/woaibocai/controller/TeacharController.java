package top.woaibocai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.woaibocai.entitiy.Teacher;
import top.woaibocai.service.TeacherService;
import top.woaibocai.service.impl.TeacherServiceImpl;

import java.util.List;

/**
 * @program: bc_parent
 * @description:
 * @author: woaibocai
 * @create: 2023-09-24 23:31
 **/
@RestController
@RequestMapping("teacher")
public class TeacharController {

    @Autowired
    private TeacherService teacherService;
    //查询所有信息
    @GetMapping("findAll")
    public List<Teacher> findAll(){
        List<Teacher> list = teacherService.list(null);
        return list;
    }

    @DeleteMapping("{id}")
    public String deleteById(@PathVariable("id") String id ){
        teacherService.removeById(id);
        return "yes";
    }




}
