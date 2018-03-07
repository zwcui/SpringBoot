package mobi.zhanglv.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Author cuizhengwei
 * Date   2018/3/5
 * Description 测试Spring自带定时任务
 */
@Component
public class TestSchedule {

	@Scheduled(cron = "0 * * * * *")
	public void test(){
		System.out.println("--定时任务--"+new Date(System.currentTimeMillis()));
	}

}
