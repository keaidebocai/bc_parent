package top.woaibocai.eduservice.entitiy;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName edu_comment
 */
@TableName(value ="edu_comment")
@Data
public class Comment implements Serializable {
    private String id;

    private String courseId;

    private String teacherId;

    private String memberId;

    private String nickname;

    private String avatar;

    private String content;

    //逻辑删除标识
    @TableLogic
    private Integer isDeleted;
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
    private static final long serialVersionUID = 1L;
}