package top.woaibocai.eduservice.entitiy.subject;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: bc_parent
 * @description: 一级分类
 * @author: woaibocai
 * @create: 2023-10-05 11:26
 **/
@Data
public class OneSubject {

    private String id;
    private String title;
    //一个一级分类里有多个二级分类
    private List<TwoSubject> children = new ArrayList<>();
}
