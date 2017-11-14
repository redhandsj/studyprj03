package s2container.helloworld;

public interface IMessageProvider {
	public void setMessageTarget(IMessageTarget messageTarget);
	public String getMessage();
}
