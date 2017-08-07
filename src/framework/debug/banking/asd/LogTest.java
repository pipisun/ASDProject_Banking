package framework.debug.banking.asd;

public class LogTest {
	public static void main(String[] args) {
		//non adaptor pattern
		Provider provider = new LoggerFactory();
		Logging logger=provider.produce();
		// INFO = 1,WARN = 2,ERROR = 3
		logger.setLoggerLevel(3);
		//ConsoleAppender:write to console,FileAppender write to file
		Appender appender=new ConsoleAppender();
//		Appender appender = new FileAppender();
		logger.setLoggerAppender(appender);
		logger.error("it is error log in log file");
		
		//Adaptor
		// INFO = 1,WARN = 2,ERROR = 3
		//appenderTo: 1-text file, 2- console
		Target adaptor=new Adaptor();
		adaptor.configLog(1, 2);
		adaptor.setLog("test it by adaptor");
	}
}
