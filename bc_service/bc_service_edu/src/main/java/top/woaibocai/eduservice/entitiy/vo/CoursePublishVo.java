package top.woaibocai.eduservice.entitiy.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @program: bc_parent
 * @description:
 * @author: woaibocai
 * @create: 2023-10-13 16:08
 **/
@Data
public class CoursePublishVo{

    private String title;
    private String cover;
    private Integer lessonNum;
    private String subjectLevelOne;
    private String subjectLevelTwo;
    private String teacherName;
    private String price;//只用于显示
}
