package properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 *  knife4j自定义配置
 * @author Qiurz
 * @date 2021/5/8
 */
@Data
@ConfigurationProperties(prefix = "royan.knife4j")
public class Knife4jProperties {

    /**是否开启knife4j**/
    private Boolean enabled;
    /**标题**/
    private String title = "";
    /**描述**/
    private String description = "";
    /**版本**/
    private String version = "v1.0";
    /**许可证**/
    private String license = "Open Source";
    /**许可证URL**/
    private String licenseUrl = "https://www.apache.org/licenses/LICENSE-2.0";
    /**服务条款URL**/
    private String termsOfServiceUrl = "https://www.apache.org/licenses/LICENSE-2.0";
    /**密码模式获取token令牌URL**/
    private String passwordTokenUrl = "";
    /** basePackage **/
    private String basePackage = "";
    /**联系人**/
    private Contact contact = new Contact();


    @Data
    public static class Contact {
        /**联系人**/
        private String name = "Qiurz";
        /**联系人url**/
        private String url = "https://gitee.com/aican/royan-platform";
        /**联系人email**/
        private String email = "2775623589@qq.com";
    }

}
