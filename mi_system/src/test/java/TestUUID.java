import cn.hutool.core.lang.ObjectId;
import cn.hutool.http.HttpUtil;

public class TestUUID {
    public static void main(String[] args) {
        // System.out.println(ObjectId.next());
//        "5fdc3f475e8f4c0a2641be47"

        for (int i = 6000; i < 12000; i++) {

            String str = "{\n" +
                    "  \"xm\": \"张三\",\n" +
                    "  \"idcard\": \"342221199811232016\",\n" +
                    "  \"dwmc\": \"盱眙周村蔬菜种植专业户\",\n" +
                    "  \"dwlb\": \"3\",\n" +
                    "  \"lxdh\": \"18901581539\",\n" +
                    "  \"dwdz\": \"江苏省 盱眙县 盱眙街道\",\n" +
                    "  \"ncppzdl\": \",1\",\n" +
                    "  \"yzmj\": \"\",\n" +
                    "  \"zzmj\": \"1\",\n" +
                    "  \"ncpList\": [\n" +
                    "    {\n" +
                    "      \"ncpmc\": \"白菜\",\n" +
                    "      \"ncpsl\": \"1\",\n" +
                    "      \"ncpdw\": \"1\",\n" +
                    "      \"ncpdj\": \"1\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"sfytcppp\": \"0\",\n" +
                    "  \"ppname\": \"白菜货源充足\",\n" +
                    "  \"qsrq\": \"2020-12-18\",\n" +
                    "  \"jzrq\": \"2021-12-18\",\n" +
                    "  \"jxswlnl\": \"0\",\n" +
                    "  \"xfzkdnl\": \"0\",\n" +
                    "  \"sfcjgnl\": \"0\",\n" +
                    "  \"bz\": \"\",\n" +
                    "  \"gmurl\": \"\",\n" +
                    "  \"ncpmc\": \",白菜" +i+
                    "号\",\n" +
                    "  \"usertel\": \"18901581539\",\n" +
                    "  \"szdq\": \"江苏省,淮安市,盱眙县,仇集镇,象山村\",\n" +
                    "  \"szdqcode\": \"320000,320800,320830,320830112,320830112203\",\n" +
                    "  \"ncppzdlList\": [\n" +
                    "    {\n" +
                    "      \"ncppzdl\": \"1\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"cppt\": \"\"\n" +
                    "}";
            String result= HttpUtil.post("https://znxdsczt.znxdcloud.com/api/ncpxqxx/addNcpxqxx", str);
            System.out.println(result);
        }

        System.out.println("好了+++++");
    }
}
