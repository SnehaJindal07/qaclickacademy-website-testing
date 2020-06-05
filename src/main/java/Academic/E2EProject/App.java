package Academic.E2EProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import resources.base;

/**
 * Hello world!
 *
 */
public class App 
{
    public static Logger log = LogManager.getLogger(base.class.getName());
    public static void main( String[] args )
    {
        log.info( "Hello World!" );
    }
}
