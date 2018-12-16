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
package ch.qos.logback.core.joran.action;

import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.util.OptionHelper;
import org.xml.sax.Attributes;

import java.util.HashMap;
import java.util.Map;

public class ConversionRuleAction extends Action {
    boolean inError = false;

    /**
     * Instantiates an layout of the given class and sets its name.
     *
     */
    @Override
    @SuppressWarnings("unchecked")
    public void begin(InterpretationContext ec, String localName, Attributes attributes) {
        // Let us forget about previous errors (in this object)
        inError = false;

        String errorMsg;
        String conversionWord = attributes.getValue(ActionConst.CONVERSION_WORD_ATTRIBUTE);
        String converterClass = attributes.getValue(ActionConst.CONVERTER_CLASS_ATTRIBUTE);

        if (OptionHelper.isEmpty(conversionWord)) {
            inError = true;
            errorMsg = "No 'conversionWord' attribute in <conversionRule>";
            addError(errorMsg);

            return;
        }

        if (OptionHelper.isEmpty(converterClass)) {
            inError = true;
            errorMsg = "No 'converterClass' attribute in <conversionRule>";
            ec.addError(errorMsg);

            return;
        }

        try {
            Map<String, String> ruleRegistry = (Map<String, String>) context.getObject(CoreConstants.PATTERN_RULE_REGISTRY);
            if (ruleRegistry == null) {
                ruleRegistry = new HashMap<String, String>();
                context.putObject(CoreConstants.PATTERN_RULE_REGISTRY, ruleRegistry);
            }
            // put the new rule into the rule registry
            addInfo("registering conversion word " + conversionWord + " with class [" + converterClass + "]");
            ruleRegistry.put(conversionWord, converterClass);
        } catch (Exception oops) {
            inError = true;
            errorMsg = "Could not add conversion rule to PatternLayout.";
            addError(errorMsg);
        }
    }

    /**
     * Once the children elements are also parsed, now is the time to activate
     * the appender options.
     */
    @Override
    public void end(InterpretationContext ec, String n) {
    }

    public void finish(InterpretationContext ec) {
    }
}
