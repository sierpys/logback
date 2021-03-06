/**
 * Logback: the reliable, generic, fast and flexible logging framework.
 * Copyright (C) 1999-2015, QOS.ch. All rights reserved.
 * <p>
 * This program and the accompanying materials are dual-licensed under
 * either the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation
 * <p>
 * or (per the licensee's choosing)
 * <p>
 * under the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation.
 */
package ch.qos.logback.core.net.mock;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.ContextBase;
import ch.qos.logback.core.status.Status;
import ch.qos.logback.core.status.StatusListener;
import ch.qos.logback.core.status.StatusManager;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/**
 * A mock {@link Context} with instrumentation for unit testing.
 *
 * @author Carl Harris
 */
public class MockContext extends ContextBase {

    private final ScheduledExecutorService scheduledExecutorService;

    private Status lastStatus;

    public MockContext() {
        this(new MockScheduledExecutorService());
    }

    public MockContext(ScheduledExecutorService executorService) {
        this.setStatusManager(new MockStatusManager());
        this.scheduledExecutorService = executorService;
    }

    @Override
    public ScheduledExecutorService getScheduledExecutorService() {
        return scheduledExecutorService;
    }

    public Status getLastStatus() {
        return lastStatus;
    }

    public void setLastStatus(Status lastStatus) {
        this.lastStatus = lastStatus;
    }

    private class MockStatusManager implements StatusManager {

        @Override
        public void add(Status status) {
            lastStatus = status;
        }

        @Override
        public List<Status> getCopyOfStatusList() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int getCount() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean add(StatusListener listener) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove(StatusListener listener) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<StatusListener> getCopyOfStatusListenerList() {
            throw new UnsupportedOperationException();
        }

    }

}
