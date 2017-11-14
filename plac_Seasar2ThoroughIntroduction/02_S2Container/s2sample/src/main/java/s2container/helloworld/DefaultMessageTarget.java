package s2container.helloworld;

public class DefaultMessageTarget implements IMessageTarget {

	@Override
	public String getName() {
		return "World!";
	}

}
