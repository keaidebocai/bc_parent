package top.woaibocai.eduservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import top.woaibocai.commonutils.R;
import top.woaibocai.eduservice.entitiy.Chapter;
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
    @ApiOperation("根据课程id进行查询课程大纲列表")
    @PostMapping("addChapter")
    public R addChapter(@RequestBody Chapter chapter){
        chapterService.save(chapter);
        return R.ok();
    }

    @ApiOperation("根据id查询")
    @GetMapping("getChapterInfo/{chapterId}")
    public R getChapterInfo(@PathVariable String chapterId){
        Chapter chapter = chapterService.getById(chapterId);
        return R.ok().data("chapter",chapter);
    }
    @ApiOperation("根据课程id更新")
    @PostMapping("updateChapter")
    public R updateChapter(@RequestBody Chapter chapter){
        chapterService.updateById(chapter);
        return R.ok();
    }
    /**
    * @Description: 删除章节，如果章节下面有小姐，就不让他删除！
    * @Param: [chapterId]
    * @return: top.woaibocai.commonutils.R
    * @Author: woaibocai
    * @Date: 2023/10/11
    */
    @DeleteMapping("{chapterId}")
    public R deleteChapter(@PathVariable String chapterId){
        Boolean aBoolean = chapterService.deleteChapter(chapterId);
        if (aBoolean){
            return R.ok();
        }
        return R.error();
    }



}
