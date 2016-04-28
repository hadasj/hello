package cz.i;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.i.test.TestAppender;

/**
 * @author jan.hadas@i.cz
 */
public class HelloWorldTest {

  private HelloWorld serviceUnderTest = new HelloWorld();
  private static TestAppender appender = new TestAppender();

  @BeforeClass
  public static void setUp() {
    Logger.getRootLogger().addAppender(appender);
  }

  @Test
  public void shouldPrintHello() {
    serviceUnderTest.hello();
    /*
    assertFalse(appender.getMessages().isEmpty());
    LoggingEvent firstLoggedMessage = appender.getMessages().get(0);
    assertEquals("Hello world", firstLoggedMessage.getMessage());
    assertEquals(Level.INFO, firstLoggedMessage.getLevel());
    */
  }

}
