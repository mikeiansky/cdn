package io.github.mikeiansky.cdn.sample;

import io.github.mikeiansky.cdn.qiniu.QiniuCdnService;
import org.springframework.stereotype.Service;

/**
 * @author mike ian
 * @date 2024/12/3
 * @desc
 **/
@Service
public class CdnQiniuSampleService {

    private final QiniuCdnService qiniuCdnService;

    public CdnQiniuSampleService(QiniuCdnService qiniuCdnService) {
        this.qiniuCdnService = qiniuCdnService;
    }

    public String createToken(){
        return qiniuCdnService.createToken();
    }

}
