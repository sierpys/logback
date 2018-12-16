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
package ch.qos.logback.core.appender;

import ch.qos.logback.core.testUtil.TeeOutputStream;

import java.io.IOException;
import java.io.PrintStream;

public class XTeeOutputStream extends TeeOutputStream {

    boolean closed = false;

    public XTeeOutputStream(PrintStream targetPS) {
        super(targetPS);
    }

    @Override
    public void close() throws IOException {
        closed = true;
        super.close();
    }

    public boolean isClosed() {
        return closed;
    }
}
