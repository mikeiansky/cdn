package io.github.mikeiansky.cdn.autoconfigure;

import com.qiniu.util.Auth;
import io.github.mikeiansky.cdn.qiniu.QiniuCdnService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mike ian
 * @date 2024/12/3
 * @desc
 **/
@EnableConfigurationProperties(CdnProperties.class)
@Configuration
public class CdnAutoConfiguration {

    @ConditionalOnClass(value = {QiniuCdnService.class, Auth.class})
    @Bean
    public QiniuCdnService qiniuCdnService(CdnProperties cdnProperties) {
        CdnServiceProperties qiniuCdnProperties = cdnProperties.getQiniu();
        QiniuCdnService qiniuService = new QiniuCdnService(qiniuCdnProperties.getAccessKey(), qiniuCdnProperties.getSecretKey());
        qiniuService.setUrlPrefix(qiniuCdnProperties.getUrlPrefix());
        qiniuService.setBucket(qiniuCdnProperties.getBucket());
        qiniuService.setDirectory(qiniuCdnProperties.getDirectory());
        return qiniuService;
    }

}
