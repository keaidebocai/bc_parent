package top.woaibocai.eduservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import top.woaibocai.commonutils.R;
import top.woaibocai.eduservice.entitiy.Video;
import top.woaibocai.eduservice.entitiy.vo.VideoInfo;
import top.woaibocai.eduservice.service.VideoService;

import javax.annotation.Resource;

/**
 * @program: bc_parent
 * @description: 视频小节
 * @author: woaibocai
 * @create: 2023-10-12 16:06
 **/
@RestController
@CrossOrigin
@RequestMapping("/eduservice/video")
@Api(value = "视频小节" ,tags = "视频小节")
public class VideoController {
    @Resource
    private VideoService videoService;
    @ApiOperation("添加视频小节")
    @PostMapping("addVideo")
    public R addVideo(@RequestBody Video video){
        videoService.save(video);
        return R.ok();
    }
    /**
    * @Description: 删除小节 TODO 删除衔接的时候，把视频也删掉
    * @Param: [id]
    * @return: top.woaibocai.commonutils.R
    * @Author: woaibocai
    * @Date: 2023/10/13
    */
    @ApiOperation("删除视频小节")
    @DeleteMapping("{id}")
    public R deleteVideo(@PathVariable String id){
        boolean b = videoService.removeById(id);
        if (b){
        return R.ok();
        }else {
            return R.error();
        }
    }

    @ApiOperation("修改视频小节")
    @PostMapping("updateVideo")
    public R updateVideo(@RequestBody Video video){
        boolean b = videoService.updateById(video);
        if (b){
            return R.ok();
        }else {
            return R.error();
        }
    }

    @ApiOperation("根据小节/课程id查")
    @GetMapping("getVideo/{videoId}")
    public R getVideo(@PathVariable String videoId){
        Video video = videoService.getById(videoId);
        return R.ok().data("video",video);
    }

    @ApiOperation("补全video信息")
    @PostMapping("videoInfo")
    public R videoInfo(@RequestBody VideoInfo videoInfo){
        Boolean b = videoService.videoInfo(videoInfo);
        return R.ok();
    }

}
