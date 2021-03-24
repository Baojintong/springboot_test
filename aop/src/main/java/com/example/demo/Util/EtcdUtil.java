package com.example.demo.Util;

import com.example.demo.DemoApplication;
import com.example.demo.MainStartupRunner;
import mousio.etcd4j.EtcdClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class EtcdUtil {

    static Logger logger = LoggerFactory.getLogger(MainStartupRunner.class);

    @Value("${server.address}")
    public String serverAddress = "";

    @Value("${server.port}")
    public String serverPost="";

    @Value( "${etcd.host}")
    public String etcdHost="";

    @Value("${etcd.port}")
    public String etcdPort= "";

    @Value("${etcd.instance.prekey}")
    public String etcdServiceInstancePreKey = "";

    public EtcdClient getEtcdClient(){
        EtcdClient etcd = new EtcdClient(URI.create("http://" + etcdHost + ":/" + etcdPort));
        return etcd;
    }

    public void initNode()throws Exception{
        String nodeKey=etcdServiceInstancePreKey+"/"+ DemoApplication.name;
        EtcdClient client=getEtcdClient();
        client.put(nodeKey, serverAddress+":"+serverPost).ttl(30).send();
    }

    public void destroyNode()throws Exception{
        String nodeKey=etcdServiceInstancePreKey+"/"+ DemoApplication.name;
        EtcdClient client=getEtcdClient();
        client.delete(nodeKey).send();
    }

    public void refreshTtl()throws Exception{
        String nodeKey=etcdServiceInstancePreKey+"/"+ DemoApplication.name;
        EtcdClient client=getEtcdClient();
        client.refresh(nodeKey, 30).send();
    }
}
