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

import ch.qos.logback.core.Context;
import ch.qos.logback.core.status.StatusManager;
import ch.qos.logback.core.status.StatusUtil;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Extend  StatusUtil with assertions.
 */
public class StatusChecker extends StatusUtil {

    public StatusChecker(StatusManager sm) {
        super(sm);
    }

    public StatusChecker(Context context) {
        super(context);
    }

    public void assertContainsMatch(int level, String regex) {
        assertTrue(containsMatch(level, regex));
    }

    public void assertNoMatch(String regex) {
        assertFalse(containsMatch(regex));
    }

    public void assertContainsMatch(String regex) {
        assertTrue(containsMatch(regex));
    }

    public void asssertContainsException(Class<?> scanExceptionClass) {
        assertTrue(containsException(scanExceptionClass));
    }

    public void assertIsErrorFree() {
        assertTrue(isErrorFree(0));
    }

    public void assertIsWarningOrErrorFree() {
        assertTrue(isWarningOrErrorFree(0));
    }
}
