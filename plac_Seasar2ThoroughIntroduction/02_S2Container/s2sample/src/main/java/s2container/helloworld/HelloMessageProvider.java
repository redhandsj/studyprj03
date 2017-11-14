package s2container.helloworld;

public class HelloMessageProvider implements IMessageProvider {

	private IMessageTarget messageTarget;

	@Override
	public void setMessageTarget(IMessageTarget messageTarget) {
		this.messageTarget = messageTarget;
	}

	@Override
	public String getMessage() {
		return "Hello " + messageTarget.getName() + "!";
	}

}
