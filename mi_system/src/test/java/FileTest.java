import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) {
        try {
            FileUtils.writeStringToFile(new File("E:\\Java/1.test"), "测试", "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
