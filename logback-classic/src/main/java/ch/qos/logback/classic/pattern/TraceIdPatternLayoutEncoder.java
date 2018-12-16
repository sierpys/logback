package ch.qos.logback.classic.pattern;

import ch.qos.logback.classic.encoder.PatternLayoutEncoder;

/**
 * @author sier.pys 12/13/18
 */
public class TraceIdPatternLayoutEncoder extends PatternLayoutEncoder {
    @Override
    public void start() {
        TraceIdPatternLayout patternLayout = new TraceIdPatternLayout();
        patternLayout.setContext(this.context);
        patternLayout.setPattern(this.getPattern());
        patternLayout.setOutputPatternAsHeader(this.outputPatternAsHeader);
        patternLayout.start();
        this.layout = patternLayout;
        this.started = true;
    }
}
