package ch.qos.logback.classic.pattern;

import ch.qos.logback.classic.PatternLayout;

/**
 * @author sier.pys 12/13/18
 */
public class TraceIdPatternLayout extends PatternLayout {

    public TraceIdPatternLayout() {
        super();
        this.getDefaultConverterMap().put("traceId", TraceIdConverter.class.getName());
    }
}
