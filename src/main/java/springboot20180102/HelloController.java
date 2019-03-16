package springboot20180102;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by kangwl_pc on 2018/1/18.
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(Map<String, Object> map){
        System.out.println("============进入初始方法===========");
        return "testPage";
    }

    @RequestMapping("/testPage")
    public String testPage(Map<String, Object> map){
        System.out.println("============进入初始方法===========");
        return "testPage";
    }

}
