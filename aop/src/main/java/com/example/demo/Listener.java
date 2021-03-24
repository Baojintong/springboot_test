package com.example.demo;

import com.google.common.base.Charsets;
import io.etcd.jetcd.ByteSequence;
import io.etcd.jetcd.*;
import io.etcd.jetcd.options.WatchOption;
import io.etcd.jetcd.watch.WatchEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.concurrent.CountDownLatch;

public class Listener implements Runnable {
    static Logger logger = LoggerFactory.getLogger(MainStartupRunner.class);
    static Integer maxEvents = 5;
    static CountDownLatch latch = new CountDownLatch(maxEvents);

    public static void main(String[] args) throws Exception {
        String serviceInstanceKey = "/node/node1";
        WatchOption watchOpts = WatchOption.newBuilder().withPrefix(
                ByteSequence.from("/node", Charsets.UTF_8)
        ).build();
        Client client = Client.builder().endpoints("http://192.168.50.233:2379").build();
        logger.info("观察者开始");
        Watch watch = client.getWatchClient();
        Watch.Watcher watcher = watch.watch(
                ByteSequence.from(serviceInstanceKey, Charsets.UTF_8),
                watchOpts,
                response -> {
                    for (WatchEvent event : response.getEvents()) {
                        logger.info("type={}, key={}, value={}",
                                event.getEventType().toString(),
                                Optional.ofNullable(event.getKeyValue().getKey())
                                        .map(bs -> bs.toString(Charsets.UTF_8))
                                        .orElse(""),
                                Optional.ofNullable(event.getKeyValue().getValue())
                                        .map(bs -> bs.toString(Charsets.UTF_8))
                                        .orElse(""));
                    }
                    latch.countDown();
                }
        );
        latch.await();
        watcher.close();
    }

    @Override
    public void run() {

    }
}
