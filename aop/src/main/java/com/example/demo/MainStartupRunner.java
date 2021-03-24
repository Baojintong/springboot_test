package com.example.demo;

import com.example.demo.Util.EtcdUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;


@Component
public class MainStartupRunner implements CommandLineRunner, DisposableBean, ExitCodeGenerator {
    Logger logger = LoggerFactory.getLogger(MainStartupRunner.class);

    @Autowired
    EtcdUtil etcdUtil;

    @Override
    public void destroy() throws Exception {
        logger.info(" >>>> MainStartupRunner destroy");
        etcdUtil.destroyNode();
        logger.info("<<<<<<<<<<< SpringBoot 进程被销毁了 >>>>>>>>>>>>>>>");
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info(">>>>>>>>>>>>>>>服务启动执行<<<<<<<<<<<<<");
        etcdUtil.initNode();
    }

    @Override
    public int getExitCode() {
        return 0;
    }
}
