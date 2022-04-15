package com.fanchuan.subpub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SubscribePublish<M> {
    //订阅器名称
    private String name;
    //订阅器队列容量
    final int QUEUE_CAPACITY = 20;
    //订阅器存储队列
    private BlockingQueue<Msg> queue = new ArrayBlockingQueue<Msg>(QUEUE_CAPACITY);
    //订阅者
    private List<ISubcriber> subcribers  = new ArrayList<ISubcriber>();

    public SubscribePublish(String name) {
        this.name = name;
    }


    public void publish(String publisher,M message,boolean isInstantMsg) {
        if(isInstantMsg){
            update(publisher,message);
            return;
        }

        Msg<M> m = new Msg<M>(publisher, message);
        while(!queue.offer(m)){

        }
    }

    public void subcribe(ISubcriber subcriber) {
        subcribers.add(subcriber);
    }
    public void unSubcribe(ISubcriber subcriber) {
        subcribers.remove(subcriber);
    }

    public void update(){
        Msg m = null;
        while((m = queue.poll())!= null){
            this.update(m.getPublisher(),(M)m.getMsg());
        }
    }
    public void update(String publisher,M Msg) {
        for(ISubcriber subcriber:subcribers){
            subcriber.update(publisher,Msg);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
