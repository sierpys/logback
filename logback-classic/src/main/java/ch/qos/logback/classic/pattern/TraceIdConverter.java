package ch.qos.logback.classic.pattern;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.taobao.eagleeye.EagleEye;

/**
 * @author sier.pys 12/13/18
 */
public class TraceIdConverter extends ClassicConverter {
    private static final String TRACE_ID_NOT_FOUND = "NONE";

    @Override
    public String convert(ILoggingEvent iLoggingEvent) {
        String traceId = EagleEye.getTraceId();
        if(traceId == null) {
            traceId = TRACE_ID_NOT_FOUND;
        }
        return traceId;
    }
}
