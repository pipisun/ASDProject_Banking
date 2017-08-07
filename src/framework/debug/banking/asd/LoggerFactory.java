package framework.debug.banking.asd;

public class LoggerFactory implements Provider {

	@Override
	public Logging produce() {
		return LoggingImpl.getInstance();
	}

}
