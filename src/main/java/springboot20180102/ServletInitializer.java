package springboot20180102;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
/**
 * 修改启动类，继承 SpringBootServletInitializer 并重写 configure 方法
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		// 注意这里要指向原先用main方法执行的Application启动类
		return application.sources(DemoApplication.class);
	}

}
