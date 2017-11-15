package s2container.helloworld;

import java.util.ArrayList;
import java.util.List;

public class HelloMessageProvider implements IMessageProvider {

	private IMessageTarget messageTarget;

	private String injectStr;
	private List<String> list = new ArrayList<String>();

	public void addList(String str) {
		this.list.add(str);
	}

	/**
	 * セッターインジェクション
	 * @param injectStr
	 */
	public void setInjectStr(String injectStr) {
		this.injectStr = injectStr;
	}
	/**
	 * コンストラクタ
	 * @param str
	 */
	public HelloMessageProvider(String str){
		System.out.println(this.getClass().getName() + " : str");

		// インターセプトテスト
		this.test();

	}
	@Override
	public void setMessageTarget(IMessageTarget messageTarget) {
		this.messageTarget = messageTarget;
	}

	@Override
	public String getMessage() {
		return "Hello " + messageTarget.getName() + "!";
	}

	public void init() {
		System.out.println(this.getClass().getName() + "#init()");
	}
	public void dispose() {
		System.out.println(this.getClass().getName() + "dispose()");
	}

//	@SimpleTrace
	private void test() {
		System.out.println(this.getClass().getName() + "testing.!!!!");
	}

}
