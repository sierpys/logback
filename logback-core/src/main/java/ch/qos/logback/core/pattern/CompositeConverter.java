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
package ch.qos.logback.core.pattern;

abstract public class CompositeConverter<E> extends DynamicConverter<E> {

    Converter<E> childConverter;

    @Override
    public String convert(E event) {
        StringBuilder buf = new StringBuilder();

        for (Converter<E> c = childConverter; c != null; c = c.next) {
            c.write(buf, event);
        }
        String intermediary = buf.toString();
        return transform(event, intermediary);
    }

    abstract protected String transform(E event, String in);

    public Converter<E> getChildConverter() {
        return childConverter;
    }

    public void setChildConverter(Converter<E> child) {
        childConverter = child;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("CompositeConverter<");

        if (formattingInfo != null) {
            buf.append(formattingInfo);
        }

        if (childConverter != null) {
            buf.append(", children: ").append(childConverter);
        }
        buf.append(">");
        return buf.toString();
    }
}
