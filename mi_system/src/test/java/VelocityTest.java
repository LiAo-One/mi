import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.io.StringWriter;
import java.util.Properties;

public class VelocityTest {

    @Test
    public void test() {
        Properties p = new Properties();
        try {
            // 加载classpath目录下的vm文件
            p.setProperty("file.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
            // 定义字符集
            p.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
            p.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
            // 初始化Velocity引擎，指定配置Properties
            Velocity.init(p);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 变量
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("test", "123456");

        // 模板列表
        StringWriter sw = new StringWriter();
        Template tpl = Velocity.getTemplate("templates/test.vm", "UTF-8");
        tpl.merge(velocityContext, sw);


        System.out.println(sw.toString());
    }
}
