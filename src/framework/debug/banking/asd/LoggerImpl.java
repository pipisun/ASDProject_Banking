package framework.debug.banking.asd;

import java.util.Date;

public class LoggerImpl implements Logger {
	   
	private int loglevel;
	private static Date dt = new Date();
	private Appender appender;
	
	// private constructor to avoid to be instanced
	private LoggerImpl(){}

	// Using an inner class to maintain the singleton
	private static class LoggerImplFactory {
		private static LoggerImpl instance = new LoggerImpl();
	}
	//get instance
	public static LoggerImpl getInstance() {
		return LoggerImplFactory.instance;
	}
		
	public Object readResolve() {  
        return getInstance();
    } 
	
	@Override
	public void debug(String msg) {
		if(this.loglevel==1){
			LogItem logitem=new LogItem(loglevel,msg,dt);
			AppenderStragety appenderStagety=new AppenderStragety(appender);
			appenderStagety.appender(logitem);
		}
	}

	@Override
	public void info(String msg) {
		if(this.loglevel==2){
			LogItem logitem=new LogItem(loglevel,msg,dt);
			AppenderStragety appenderStagety=new AppenderStragety(appender);
			appenderStagety.appender(logitem);
		}

	}

	@Override
	public void warn(String msg) {
		if(this.loglevel==3){
			LogItem logitem=new LogItem(loglevel,msg,dt);
			AppenderStragety appenderStagety=new AppenderStragety(appender);
			appenderStagety.appender(logitem);
		}

	}

	@Override
	public void fatal(String msg) {
		if(this.loglevel==5){
			LogItem logitem=new LogItem(loglevel,msg,dt);
			AppenderStragety appenderStagety=new AppenderStragety(appender);
			appenderStagety.appender(logitem);
		}

	}

	@Override
	public void error(String msg) {
		if(this.loglevel==4){
			LogItem logitem=new LogItem(loglevel,msg,dt);
			AppenderStragety appenderStagety=new AppenderStragety(appender);
			appenderStagety.appender(logitem);
		}
	}

	@Override
	public void setLoggerLevel(int i) {
		this.loglevel=i;
		
	}

	@Override
	public void setLoggerAppender(Appender appender) {
		this.appender=appender;
	}

}
