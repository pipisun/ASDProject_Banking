package framework.debug.banking.asd;

import java.util.Date;

public class LogItem {
	int loggerlevel;
//	String className;
//	String eventName;
//	String methodName;
	String message;
	Date date;
	public LogItem(int loggerlevel,String message,Date date){
		this.loggerlevel=loggerlevel;
//		this.className=className;
//		this.eventName=eventName;
//		this.methodName=methodName;
		this.message=message;
		this.date=date;
	}
	
	
	public int getLoggerlevel() {
		return loggerlevel;
	}


	public void setLoggerlevel(int loggerlevel) {
		this.loggerlevel = loggerlevel;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
}
