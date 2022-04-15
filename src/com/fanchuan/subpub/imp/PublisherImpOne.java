
package com.fanchuan.subpub.imp;

import com.fanchuan.subpub.IPublisher;
import com.fanchuan.subpub.SubscribePublish;

public class PublisherImpOne<M> implements IPublisher<M>{
    private String name;

    public PublisherImpOne(String name) {
        super();
        this.name = name;
    }

    public void publish(SubscribePublish subscribePublish, M message,boolean isInstantMsg) {
        subscribePublish.publish(this.name, message, isInstantMsg);
    }

}
