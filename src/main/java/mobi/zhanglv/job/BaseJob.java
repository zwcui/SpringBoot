package mobi.zhanglv.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Author cuizhengwei
 * Date   2018/3/6
 * Description
 */
public interface BaseJob extends Job {
	public void execute(JobExecutionContext context) throws JobExecutionException;
}
