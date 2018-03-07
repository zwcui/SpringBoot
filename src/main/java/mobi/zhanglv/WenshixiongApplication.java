package mobi.zhanglv;

import org.apache.log4j.PropertyConfigurator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Author cuizhengwei
 * Date   2017/12/1
 * Description main
 * 启动类添加MapperScan注解
 *
 *
 * 已实现：
 * 1.model类、mapper.xml先通过m要把mybatis generate自动生成，创建空构造函数，(默认字段驼峰结构)
 * 2.mapper.xml文件定义resultMap，映射bean的字段
 * 3.修改mapper类，编写Service，Servicempl  mapper.xml配置sql可以使用unix_timestamp()获取时间戳
 * 4.如果接口方法要保证事物一致性，在方法上加@Transactional
 * 5.response包中放置返回类型，RespEntity.generateResp
 * 6.分页插件，查询之前：PageHelper.startPage(pageNum, pageSize);
 * 7.定时任务，参考schedule包
 * 8.自动注入RedisService，通过其get/set方法进行取值与赋值
 * 9.热部署，重新编译类与修改配置文件均会触发重新部署
 * 10.要获取request head中参数（如api-version），在controller方法中加入参数HttpServletRequest
 * 11.rsa验签，将签名放在request的head中，控制接口访问权限
 *
 * 待优化：
 * 1.Quatz实现任务调度的集群管理，通过数据库表进行不同节点执行控制
 * 2.已有代码优化
 * 3.读写分离
 *
 * errorcode与errormsg放入数据库配置

 * 放在git上
 * 部署脚本
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@MapperScan("mobi.zhanglv.dao")
public class WenshixiongApplication {

	public static void main(String[] args) {
//		String log4jPath = WenshixiongApplication.class.getClassLoader().getResource("").getPath()+"log4j.properties";
//		System.out.println("--------------------"+log4jPath);
//		PropertyConfigurator.configure(log4jPath);
		SpringApplication.run(WenshixiongApplication.class, args);
	}
}
