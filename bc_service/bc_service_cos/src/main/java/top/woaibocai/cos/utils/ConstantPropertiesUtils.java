package top.woaibocai.cos.utils;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.region.Region;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program: bc_parent
 * @description: 读取配置文件里的数据
 * @author: woaibocai
 * @create: 2023-10-03 19:17
 **/
//当项目启动，spring加载后，执行接口的一个方法
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ConstantPropertiesUtils implements InitializingBean {

    //读取配置文件内容
    //密钥id
    @Value("${qcloud.cos.file.secretId}")
    private String secretId;
    //密钥密码
    @Value("${qcloud.cos.file.secretKey}")
    private String secretKey;
    //cos存储桶的地域
    @Value("${qcloud.cos.file.COS_REGION}")
    private String cosRegion;
    //存储桶的名称
    @Value("${qcloud.cos.file.bucket}")
    private String bucket;

    //定义公开的静态量
    //密钥id
    public static String SECRET_ID;
    //密钥密码
    public static String SECRET_KEY;
    //cos存储桶的地域
    public static String COS_REGION;
    //存储桶的名称
    public static String BUCKET;

    @Override
    public void afterPropertiesSet() throws Exception{
        //密钥id
        SECRET_ID = secretId;
        //密钥密码
        SECRET_KEY = secretKey;
        //cos存储桶的地域
        COS_REGION = cosRegion;
        //存储桶的名称
        BUCKET = bucket;
    }

}
