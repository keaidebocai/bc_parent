package top.woaibocai.eduservice.entitiy;


import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName edu_course_description
 */
@TableName(value ="edu_course_description")
@Data
public class CourseDescription implements Serializable {
    @TableId(value = "id",type = IdType.INPUT)
    private String id;

    private String description;
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    private static final long serialVersionUID = 1L;
}