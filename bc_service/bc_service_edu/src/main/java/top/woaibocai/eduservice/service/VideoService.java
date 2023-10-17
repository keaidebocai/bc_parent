package top.woaibocai.eduservice.service;

import top.woaibocai.eduservice.entitiy.Video;
import com.baomidou.mybatisplus.extension.service.IService;
import top.woaibocai.eduservice.entitiy.vo.VideoInfo;

/**
* @author 36519
* @description 针对表【edu_video(课程视频)】的数据库操作Service
* @createDate 2023-10-07 08:13:25
*/
public interface VideoService extends IService<Video> {
    //根据课程id删除小节
    int removeByCourseId(String courseId);

    Boolean videoInfo(VideoInfo videoInfo);
}
