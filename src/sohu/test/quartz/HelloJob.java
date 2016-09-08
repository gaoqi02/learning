package sohu.test.quartz;

import org.apache.commons.lang.time.DateFormatUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Created by qigao212074 on 2016/9/7.
 */
public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println("hello job, "+ DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
    }


}
