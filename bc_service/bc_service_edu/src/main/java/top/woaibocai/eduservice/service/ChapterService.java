package top.woaibocai.eduservice.service;


import top.woaibocai.eduservice.entitiy.Chapter;
import com.baomidou.mybatisplus.extension.service.IService;
import top.woaibocai.eduservice.entitiy.chapter.ChapterVo;

import java.util.List;

/**
* @author 36519
* @description 针对表【edu_chapter(课程)】的数据库操作Service
* @createDate 2023-10-07 08:13:25
*/
public interface ChapterService extends IService<Chapter> {

    List<ChapterVo> getChapterVideoByCourseId(String courseId);

    Boolean deleteChapter(String chapterId);

    int removeChapterByCourseId(String courseId);
}
