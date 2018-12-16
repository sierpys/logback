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
package ch.qos.logback.core.joran.spi;

import ch.qos.logback.core.status.StatusManager;

import java.net.URL;

public class XMLUtil {

    static public final int ILL_FORMED = 1;
    static public final int UNRECOVERABLE_ERROR = 2;

    static public int checkIfWellFormed(URL url, StatusManager sm) {
        return 0;
    }

}
