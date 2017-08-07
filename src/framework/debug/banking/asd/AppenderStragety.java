package framework.debug.banking.asd;

public class AppenderStragety {

	private Appender appender;

	public AppenderStragety(Appender appender) {
		this.appender = appender;
	}

	public void appender(LogItem logitem) {
		if (logitem != null) {
			appender.append(logitem);
		} else {
			System.out.println("Logitem is null");
		}
	}

	public Appender getAppender() {
		return appender;
	}

	public void setAppender(Appender appender) {
		this.appender = appender;
	}

}
