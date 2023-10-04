package top.woaibocai.eduservice.entitiy;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName edu_subject
 */
@TableName(value ="edu_subject")
@Data
public class Subject implements Serializable {
    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    private String title;

    private String parentId;

    private Integer sort;
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    private static final long serialVersionUID = 1L;
}