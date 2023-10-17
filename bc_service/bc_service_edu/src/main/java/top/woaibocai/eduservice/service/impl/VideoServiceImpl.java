package top.woaibocai.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;
import top.woaibocai.eduservice.entitiy.Video;
import top.woaibocai.eduservice.entitiy.vo.VideoInfo;
import top.woaibocai.eduservice.mapper.VideoMapper;
import top.woaibocai.eduservice.service.VideoService;

import javax.annotation.Resource;

/**
* @author 36519
* @description 针对表【edu_video(课程视频)】的数据库操作Service实现
* @createDate 2023-10-07 08:13:25
*/
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {
    //根据课程id删除小节
    //TODO 删除小姐，删除对应的视频文件
    @Override
    public int removeByCourseId(String courseId) {
        LambdaQueryWrapper<Video> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Video::getCourseId,courseId);
        int delete = this.baseMapper.delete(wrapper);
        return delete;
    }

    @Override
    public Boolean videoInfo(VideoInfo videoInfo) {
        Video video = this.baseMapper.selectById(videoInfo.getVoidId());
        video.setVideoSourceId(videoInfo.getFileId());
        video.setVideoOriginalName(videoInfo.getFileName().replaceAll(".mp4",""));
        int i = this.baseMapper.updateById(video);
        return i >= 0;
    }
}




