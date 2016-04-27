package cz.i;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jan.hadas@i.cz
 */
public class HelloWorld {

  private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorld.class);


  public void hello() {
    LOGGER.info("Hello world");
  }


}
