
package com.fanchuan.subpub;

public interface IPublisher<M> {
    public void publish(SubscribePublish subscribePublish, M message, boolean isInstantMsg);
}
