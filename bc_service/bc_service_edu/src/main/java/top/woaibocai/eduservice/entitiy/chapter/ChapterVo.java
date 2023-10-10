package top.woaibocai.eduservice.entitiy.chapter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: bc_parent
 * @description: 章节
 * @author: woaibocai
 * @create: 2023-10-10 14:40
 **/
@Data
public class ChapterVo {

    private String id;
    private String title;

    //表示小结
    private List<VideoVo> children = new ArrayList<>();
}
