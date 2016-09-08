package sohu.test.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by qigao212074 on 2016/9/7.
 */
public class Test {

    public static void run() throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("helloJob", "group1")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger","group1")
                .startNow()
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                //每5s运行一次
                                .withIntervalInSeconds(5)
                                        //重复运行3次
                                .withRepeatCount(3)
                ).build();

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
//添加job，以及其关联的trigger
        scheduler.scheduleJob(jobDetail, trigger);
//启动job
        ;
    }

    public static void main(String[] args) throws SchedulerException {
        run();
    }
}
