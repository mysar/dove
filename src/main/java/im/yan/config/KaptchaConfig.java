package im.yan.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;
/**
 * Tip: Kaptcha 验证码生成工具配置
 * Created by Im.Yan on 2018/3/26.
 */
@Configuration
public class KaptchaConfig {

    @Bean
    public DefaultKaptcha producer() {
        Properties properties = new Properties();
        properties.put("kaptcha.border", "no");
        properties.put("kaptcha.textproducer.font.color", "black");
        properties.put("kaptcha.textproducer.char.space", "1");  // 文字间隔
        properties.put("kaptcha.textproducer.char.length","2");  // 验证码长度
        properties.put("kaptcha.textproducer.char.string","1234567890");//文本集合，验证码值从此集合中获取
        Config config = new Config(properties);
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
