package s2container.helloworld;

import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;

public class Main {

	public static void main(String[] args) {
		// S2Container初期化(app.dicon読込)
		SingletonS2ContainerFactory.setConfigPath("app.dicon");
		SingletonS2ContainerFactory.init();

		// コンテナを取得する.
        S2Container container = SingletonS2ContainerFactory.getContainer();

		// IMessageProviderインターフェイスを実装したコンポーネント取得
		IMessageProvider messageProvider = (IMessageProvider)container.getComponent(IMessageProvider.class);

		// メッセージ表示
		System.out.println(messageProvider.getMessage());

		// S2Container破棄
		SingletonS2ContainerFactory.destroy();
	}

}
