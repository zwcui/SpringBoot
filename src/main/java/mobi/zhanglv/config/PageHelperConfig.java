package mobi.zhanglv.config;

import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

/**
 * Author cuizhengwei
 * Date   2018/3/5
 * Description 分页插件
 */
public class PageHelperConfig {

	private static final Logger logger = LoggerFactory.getLogger(PageHelperConfig.class);

	@Bean
	public PageHelper pageHelper() {
		logger.info("注册MyBatis分页插件PageHelper");
		PageHelper pageHelper = new PageHelper();
		Properties p = new Properties();
		p.setProperty("offsetAsPageNum", "true");
		p.setProperty("rowBoundsWithCount", "true");
		p.setProperty("reasonable", "true");
		pageHelper.setProperties(p);
		return pageHelper;
	}
}
