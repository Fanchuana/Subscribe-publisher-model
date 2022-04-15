
package com.fanchuan.subpub;
public interface ISubcriber<M> {
    public void subcribe(SubscribePublish subscribePublish);
    public void unSubcribe(SubscribePublish subscribePublish);
    public void update(String publisher,M message);
}