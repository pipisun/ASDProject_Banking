package framework.debug.banking.asd;

public interface Target {
	// INFO = 1,WARN = 2,ERROR = 3
	//appenderTo: 1-text file, 2- console
	public void configLog(int loglevel,int appenderTo);
	public void setLog(String message);
}
