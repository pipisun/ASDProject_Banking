package framework.debug.banking.asd;

public class Main {
	public static void main(String[] args) {
		//non adaptor pattern
		Provider provider = new LoggerFactory();
		Logging logger=provider.produce();
		//DEBUG = 1,INFO = 2,WARN = 3,ERROR = 4,FATAL = 5
		logger.setLoggerLevel(4);
		//ConsoleAppender:write to console,FileAppender write to file
		Appender appender=new ConsoleAppender();
//		Appender appender = new FileAppender();
		logger.setLoggerAppender(appender);
		logger.error("it is error log in log file");
		
		//Adaptor
		//DEBUG = 1,INFO = 2,WARN = 3,ERROR = 4,FATAL = 5
		//appenderTo: 1-text file, 2- console
		Target adaptor=new Adaptor();
		adaptor.configLog(5, 1);
		adaptor.setLog("test it by adaptor");
	}
}
