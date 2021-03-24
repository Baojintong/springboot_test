package com.example.demo;

import com.example.demo.Util.EtcdUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class HeartbeatSchedule {

    Logger logger = LoggerFactory.getLogger(HeartbeatSchedule.class);

    @Autowired
    EtcdUtil etcdUtil;

    @Scheduled(fixedRate = 1000*10) //每十秒执行一次
    public void schedule() throws Exception {
        logger.info("HeartbeatSchedule start");
        etcdUtil.refreshTtl();
        logger.info("HeartbeatSchedule end");
    }
}
