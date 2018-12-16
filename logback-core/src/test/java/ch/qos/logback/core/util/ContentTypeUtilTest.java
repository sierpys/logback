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
package ch.qos.logback.core.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContentTypeUtilTest {

    @Test
    public void smoke() {
        String contextType = "text/html";
        assertTrue(ContentTypeUtil.isTextual(contextType));
        assertEquals("html", ContentTypeUtil.getSubType(contextType));
    }

    @Test
    public void nullContext() {
        String contextType = null;
        assertFalse(ContentTypeUtil.isTextual(contextType));
        assertNull(ContentTypeUtil.getSubType(contextType));
    }

    @Test
    public void emptySubtype() {
        String contextType = "text/";
        assertTrue(ContentTypeUtil.isTextual(contextType));
        assertNull(ContentTypeUtil.getSubType(contextType));
    }
}
