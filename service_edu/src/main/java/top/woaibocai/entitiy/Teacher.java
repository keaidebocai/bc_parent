package top.woaibocai.entitiy;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


import java.io.Serializable;
import java.util.Date;

/**
 * @TableName edu_teacher
 */
@TableName(value ="edu_teacher")
@Data
public class Teacher implements Serializable {
    private String id;

    private String name;

    private String intro;

    private String career;

    private Integer level;

    private String avatar;

    private Integer sort;
    //逻辑删除标识
    @TableLogic
    private Integer isDeleted;

    private Date gmtCreate;

    private Date gmtModified;

    private static final long serialVersionUID = 1L;
}