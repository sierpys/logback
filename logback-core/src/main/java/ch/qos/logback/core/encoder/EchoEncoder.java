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
package ch.qos.logback.core.encoder;

import ch.qos.logback.core.CoreConstants;

public class EchoEncoder<E> extends EncoderBase<E> {

    String fileHeader;
    String fileFooter;

    @Override
    public byte[] encode(E event) {
        String val = event + CoreConstants.LINE_SEPARATOR;
        return val.getBytes();
    }

    @Override
    public byte[] footerBytes() {
        if (fileFooter == null) {
            return null;
        }
        return fileFooter.getBytes();
    }

    @Override
    public byte[] headerBytes() {
        if (fileHeader == null) {
            return null;
        }
        return fileHeader.getBytes();
    }
}
