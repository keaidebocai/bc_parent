package top.woaibocai.servicebase.headler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: springboot-headline-part
 * @description: mybatis填充器
 * @author: woaibocai
 * @create: 2023-09-21 12:44
 **/
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("------------------------------------------------------------开始填充------------------------------------------------------------");
        this.setFieldValByName("gmtCreate", new Date(), metaObject);
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("------------------------------------------------------------开始填充------------------------------------------------------------");
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }
}
