package io.github.mikeiansky.cdn.autoconfigure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author mike ian
 * @date 2024/12/3
 * @desc
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CdnServiceProperties {

    private String accessKey;
    private String secretKey;
    private String urlPrefix;

    /**
     * 默认使用的bucket
     */
    private String bucket;

    /**
     * 使用的文件夹
     */
    private String directory;

}
