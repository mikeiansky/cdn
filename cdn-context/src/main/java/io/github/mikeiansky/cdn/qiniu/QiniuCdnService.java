package io.github.mikeiansky.cdn.qiniu;

import com.qiniu.processing.OperationManager;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import lombok.Getter;
import lombok.Setter;

/**
 * @author mike ian
 * @date 2024/8/10
 * @desc 七牛CDN服务
 **/
public class QiniuCdnService {

    @Getter
    private Auth auth;

    @Setter
    @Getter
    private String bucket;

    @Getter
    @Setter
    private String urlPrefix;

    @Setter
    @Getter
    private String directory;

    public QiniuCdnService(String accessKey, String secretKey) {
        auth = Auth.create(accessKey, secretKey);
    }

    public String createToken() {
        return auth.uploadToken(bucket);
    }

    public String createToken(String bucket) {
        if (bucket == null) {
            return createToken();
        }
        return auth.uploadToken(bucket);
    }

    public UploadManager createUploadManager() {
        Configuration cfg = new Configuration(Region.autoRegion());
        cfg.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;// 指定分片上传版本
        return new UploadManager(cfg);
    }

    public BucketManager createBucketManager() {
        Configuration cfg = new Configuration(Region.autoRegion());
        return new BucketManager(auth, cfg);
    }

    public OperationManager createOperationManager() {
        Configuration cfg = new Configuration(Region.autoRegion());
        return new OperationManager(auth, cfg);
    }

    public String getUrl(String key) {
        if (urlPrefix == null) {
            return key;
        }
        return urlPrefix + key;
    }

    public String getDirectory() {
        return directory;
    }

    public String getBucket() {
        return bucket;
    }

}
