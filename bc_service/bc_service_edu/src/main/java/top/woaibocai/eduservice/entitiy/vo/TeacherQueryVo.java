package top.woaibocai.eduservice.entitiy.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



/**
 * @program: bc_parent
 * @description:
 * @author: woaibocai
 * @create: 2023-09-25 14:53
 **/
@Data
public class TeacherQueryVo {
    @ApiModelProperty(value = "教师模糊查询",example = "")
    private String name;
    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师",example = "0")
    private Integer level;
    @ApiModelProperty(value = "查询时间开始",example = "2019-01-01 10:10:10")
    private String begin;
    @ApiModelProperty(value = "查询时间结束")
    private String end;
}
