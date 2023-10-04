package top.woaibocai.eduservice.entitiy.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @program: bc_parent
 * @description: 读表格的实体类
 * @author: woaibocai
 * @create: 2023-10-04 13:48
 **/
@Data
public class SubjectData {
    @ExcelProperty(index = 0)
    private String oneSubjectName;
    @ExcelProperty(index = 1)
    private String twoSubjectName;
}
