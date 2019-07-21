package com.learn.multithread.aqs;

import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/25 21:21
 */
public class MyAqs extends AbstractQueuedLongSynchronizer {
    @Override
    protected boolean tryAcquire(long arg) {
        return super.tryAcquire(arg);
    }

    @Override
    protected boolean tryRelease(long arg) {
        return super.tryRelease(arg);
    }

    @Override
    protected long tryAcquireShared(long arg) {
        return super.tryAcquireShared(arg);
    }

    @Override
    protected boolean tryReleaseShared(long arg) {
        return super.tryReleaseShared(arg);
    }

    @Override
    protected boolean isHeldExclusively() {
        return super.isHeldExclusively();
    }

}
