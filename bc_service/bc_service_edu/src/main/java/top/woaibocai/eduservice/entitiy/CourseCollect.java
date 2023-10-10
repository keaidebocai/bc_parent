package top.woaibocai.eduservice.entitiy;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName edu_course_collect
 */
@TableName(value ="edu_course_collect")
@Data
public class CourseCollect implements Serializable {
    private String id;

    private String courseId;

    private String memberId;

    //逻辑删除标识
    @TableLogic
    private Integer isDeleted;
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    private static final long serialVersionUID = 1L;
}