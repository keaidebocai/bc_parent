package top.woaibocai.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.woaibocai.eduservice.entitiy.Chapter;
import top.woaibocai.eduservice.entitiy.Video;
import top.woaibocai.eduservice.entitiy.chapter.ChapterVo;
import top.woaibocai.eduservice.entitiy.chapter.VideoVo;
import top.woaibocai.eduservice.mapper.ChapterMapper;
import top.woaibocai.eduservice.mapper.VideoMapper;
import top.woaibocai.eduservice.service.ChapterService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
* @author 36519
* @description 针对表【edu_chapter(课程)】的数据库操作Service实现
* @createDate 2023-10-07 08:13:25
*/
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;
    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<ChapterVo> getChapterVideoByCourseId(String courseId) {
        //先查询所有章节
        LambdaQueryWrapper<Chapter> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .select(Chapter::getId,Chapter::getTitle)
                .eq(Chapter::getCourseId,courseId);
        List<Chapter> chapters = chapterMapper.selectList(queryWrapper);
        //再查所有的小结
        LambdaQueryWrapper<Video> wrapper = new LambdaQueryWrapper<>();
        wrapper
                .select(Video::getId,Video::getTitle,Video::getChapterId)
                .eq(Video::getCourseId,courseId);
        List<Video> videos = videoMapper.selectList(wrapper);
        //再用课程列表的那种方法给他封装进ChapterVo
        List<ChapterVo> finalChapterVo = new ArrayList<>();
        for (int i = 0; i <chapters.size(); i++) {
            //先把每一个查出来的Chapter放进ChapterVo中
            ChapterVo chapterVo = new ChapterVo();
            Chapter chapter = chapters.get(i);
            //BeanUtils.copyProperties,捏麻麻地，每次都把里面的值弄反，无一例外！左值右空！！！！！
            BeanUtils.copyProperties(chapter,chapterVo);
            List<VideoVo> videoVos = new ArrayList<>();
            //再把video所对应的chapters.get(i)放进去
            for (int j = 0; j < videos.size(); j++) {
                VideoVo videoVo = new VideoVo();
                Video video = videos.get(j);
                //把小结video所对应的章节chapter筛出来
                if (chapter.getId().equals(video.getChapterId())){
                    BeanUtils.copyProperties(video,videoVo);
                    videoVos.add(videoVo);
                }
            }
            //把每一个chapterVo下的children装进去，这样一个完整的chapterVo就封装好了
            chapterVo.setChildren(videoVos);
            //再把每一个封装好的chapterVo放进finalChapterVo集合里，返回给前端
            finalChapterVo.add(chapterVo);
        }
        return finalChapterVo;
    }
}




