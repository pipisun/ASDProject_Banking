package framework.debug.banking.asd;

public class Adaptor implements Target {

	private Provider provider = new LoggerFactory();
	private Logger logger = provider.produce();
	private Appender appender = new FileAppender();// default text file

	private int loglevel = 1;// default is debug

	@Override
	public void configLog(int loglevel, int appenderTo) {
		logger.setLoggerLevel(loglevel);
		if (appenderTo == 1) {
			logger.setLoggerAppender(appender);
		} else if (appenderTo == 2) {
			appender = new ConsoleAppender();
			logger.setLoggerAppender(appender);
		}
		this.loglevel = loglevel;
	}

	@Override
	public void setLog(String message) {
		// DEBUG = 1,INFO = 2,WARN = 3,ERROR = 4,FATAL = 5
		if (loglevel == 1) {
			logger.debug(message);
		} else if (loglevel == 2) {
			logger.info(message);
		}
		if (loglevel == 3) {
			logger.warn(message);
		}
		if (loglevel == 4) {
			logger.error(message);
		}
		if (loglevel == 5) {
			logger.fatal(message);
		}
	}

}
