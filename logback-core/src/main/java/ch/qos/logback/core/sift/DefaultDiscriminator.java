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
package ch.qos.logback.core.sift;

/**
 * @author Ceki G&uuml;lc&uuml;
 */
public class DefaultDiscriminator<E> extends AbstractDiscriminator<E> {

    static public final String DEFAULT = "default";

    @Override
    public String getDiscriminatingValue(E e) {
        return DEFAULT;
    }

    @Override
    public String getKey() {
        return DEFAULT;
    }

}
