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
package ch.qos.logback.core.joran.event;

import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.spi.ActionException;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import org.xml.sax.Attributes;

import java.util.ArrayList;
import java.util.List;

public class ListenAction extends Action implements InPlayListener {

    List<SaxEvent> seList = new ArrayList<SaxEvent>();

    @Override
    public void begin(InterpretationContext ec, String name, Attributes attributes) throws ActionException {
        ec.addInPlayListener(this);
    }

    @Override
    public void end(InterpretationContext ec, String name) throws ActionException {
        ec.removeInPlayListener(this);

    }

    @Override
    public void inPlay(SaxEvent event) {
        seList.add(event);
    }

    public List<SaxEvent> getSeList() {
        return seList;
    }

}
