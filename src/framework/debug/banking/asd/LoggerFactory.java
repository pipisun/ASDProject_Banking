package framework.debug.banking.asd;

public class LoggerFactory implements Provider {

	@Override
	public Logger produce() {
		return LoggerImpl.getInstance();
	}

}
