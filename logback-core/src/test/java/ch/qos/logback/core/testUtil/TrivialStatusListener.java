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
package ch.qos.logback.core.testUtil;

import ch.qos.logback.core.spi.LifeCycle;
import ch.qos.logback.core.status.Status;
import ch.qos.logback.core.status.StatusListener;

import java.util.ArrayList;
import java.util.List;

public class TrivialStatusListener implements StatusListener, LifeCycle {

    public List<Status> list = new ArrayList<Status>();
    boolean start = false;

    public void addStatusEvent(Status status) {
        if (!isStarted())
            return;
        list.add(status);
    }

    public void start() {
        start = true;
    }

    public void stop() {
        start = false;
    }

    @Override
    public boolean isStarted() {
        return start;
    }
}
