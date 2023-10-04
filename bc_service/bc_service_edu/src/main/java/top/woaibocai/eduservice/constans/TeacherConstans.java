package top.woaibocai.eduservice.constans;

import org.springframework.beans.factory.annotation.Value;

/**
 * @program: bc_parent
 * @description: 教师的常量类,不建议学我，我是不会前端
 * @author: woaibocai
 * @create: 2023-10-04 11:33
 **/
public final class TeacherConstans {
    private TeacherConstans(){

    }
    //默认头像
    @Value("${teacher.avatar}")
    public static  String DEFAULT_AVATAR ;

}
