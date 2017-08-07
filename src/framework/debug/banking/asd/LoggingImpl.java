package framework.debug.banking.asd;

import java.util.Date;

public class LoggingImpl implements Logging {
	   
	private int logLevel;
	private static Date date = new Date();
	private Appender appender;
	
	// private constructor to avoid to be instanced
	private LoggingImpl(){}

	// Using an inner class to maintain the singleton
	private static class LoggingFactoryImpl {
		private static LoggingImpl instance = new LoggingImpl();
	}
	
	// Get instance
	public static LoggingImpl getInstance() {
		return LoggingFactoryImpl.instance;
	}
		
	public Object retrieveResolve() {  
        return getInstance();
    } 
	
//	@Override
//	public void debug(String msg) {
//		if(this.logLevel==1){
//			LogItem logitem=new LogItem(logLevel,msg,date);
//			AppenderStragety appenderStagety=new AppenderStragety(appender);
//			appenderStagety.appender(logitem);
//		}
//	}

	@Override
	public void info(String msg) {
		if(this.logLevel==1){
			LogItem logitem=new LogItem(logLevel,msg,date);
			AppenderStragety appenderStagety=new AppenderStragety(appender);
			appenderStagety.appender(logitem);
		}

	}

	@Override
	public void warn(String msg) {
		if(this.logLevel==2){
			LogItem logitem=new LogItem(logLevel,msg,date);
			AppenderStragety appenderStagety=new AppenderStragety(appender);
			appenderStagety.appender(logitem);
		}

	}

//	@Override
//	public void fatal(String msg) {
//		if(this.logLevel==5){
//			LogItem logitem=new LogItem(logLevel,msg,date);
//			AppenderStragety appenderStagety=new AppenderStragety(appender);
//			appenderStagety.appender(logitem);
//		}
//
//	}

	@Override
	public void error(String msg) {
		if(this.logLevel==3){
			LogItem logitem=new LogItem(logLevel,msg,date);
			AppenderStragety appenderStagety=new AppenderStragety(appender);
			appenderStagety.appender(logitem);
		}
	}

	@Override
	public void setLoggerLevel(int i) {
		this.logLevel=i;
		
	}

	@Override
	public void setLoggerAppender(Appender appender) {
		this.appender=appender;
	}

}
