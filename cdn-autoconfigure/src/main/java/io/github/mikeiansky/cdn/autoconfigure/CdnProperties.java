package io.github.mikeiansky.cdn.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author mike ian
 * @date 2024/12/3
 * @desc
 **/
@Data
@ConfigurationProperties(prefix = "io.github.mikeiansky.cdn")
public class CdnProperties {

    private CdnServiceProperties qiniu;

}
