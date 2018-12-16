package ch.qos.logback.core.spi;

/**
 * Generate sequence numbers
 *
 * @author Ceki G&uuml;lc&uuml;
 * @since 1.3.0
 */
public interface SequenceNumberGenerator extends ContextAware {


    long nextSequenceNumber();

}
