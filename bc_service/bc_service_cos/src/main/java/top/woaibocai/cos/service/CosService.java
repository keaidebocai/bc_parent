package top.woaibocai.cos.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CosService {
    //上传头像到cos
    String uploadFileAvatar(MultipartFile file) throws IOException;
}
