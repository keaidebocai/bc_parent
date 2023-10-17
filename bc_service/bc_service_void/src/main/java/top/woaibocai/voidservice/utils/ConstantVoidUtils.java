package top.woaibocai.voidservice.utils;

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
public class ConstantVoidUtils implements InitializingBean {

    //读取配置文件内容
    //密钥id
    @Value("${qcloud.void.file.secretId}")
    private String secretId;
    //密钥密码
    @Value("${qcloud.void.file.secretKey}")
    private String secretKey;

    //定义公开的静态量
    //密钥id
    public static String SECRET_ID;
    //密钥密码
    public static String SECRET_KEY;

    @Override
    public void afterPropertiesSet() throws Exception{
        //密钥id
        SECRET_ID = secretId;
        //密钥密码
        SECRET_KEY = secretKey;
    }

}
