package top.woaibocai.eduservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import top.woaibocai.commonutils.R;
import top.woaibocai.eduservice.entitiy.chapter.ChapterVo;
import top.woaibocai.eduservice.service.ChapterService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: bc_parent
 * @description: 章节小结
 * @author: woaibocai
 * @create: 2023-10-10 14:47
 **/
@RestController
@RequestMapping("/eduservice/chapter")
@CrossOrigin
@Api(tags = "课程大纲",value = "课程大纲")
public class ChapterController {
    @Resource
    private ChapterService chapterService;
    /**
    * @Description: 课程大纲列表，根据课程id进行查询
    * @Param: [courseId]
    * @return: top.woaibocai.commonutils.R
    * @Author: woaibocai
    * @Date: 2023/10/10
    */
    @ApiOperation("根据课程id进行查询课程大纲列表")
    @GetMapping("getChapterVideo/{courseId}")
    public R getChapterVideo(@PathVariable String courseId){
        List<ChapterVo> list = chapterService.getChapterVideoByCourseId(courseId);
        return R.ok().data("allChapterVideo",list);
    }

}
