package top.woaibocai.eduservice.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.woaibocai.eduservice.entitiy.Comment;
import top.woaibocai.eduservice.mapper.CommentMapper;
import top.woaibocai.eduservice.service.CommentService;

/**
* @author 36519
* @description 针对表【edu_comment(评论)】的数据库操作Service实现
* @createDate 2023-10-07 08:13:25
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}




