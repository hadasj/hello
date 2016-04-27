package cz.i.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

/**
 * @author jan.hadas@i.cz
 */
public class TestAppender extends AppenderSkeleton {

  private List<LoggingEvent> messages = new ArrayList<>();

  @Override
  protected void append(LoggingEvent event) {
    messages.add(event);
  }

  @Override
  public void close() {}

  @Override
  public boolean requiresLayout() {
    return false;
  }

  public List<LoggingEvent> getMessages() {
    return messages;
  }
}
