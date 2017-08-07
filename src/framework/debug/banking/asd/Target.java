package framework.debug.banking.asd;

public interface Target {
	//DEBUG = 1,INFO = 2,WARN = 3,ERROR = 4,FATAL = 5
	//appenderTo: 1-text file, 2- console
	public void configLog(int loglevel,int appenderTo);
	public void setLog(String message);
}
