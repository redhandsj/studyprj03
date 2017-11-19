package s2container.helloworld;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;

import s2container.helloworld.dto.impl.PropertyInterTypeDto;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {

		// S2Container初期化(app.dicon読込)
		SingletonS2ContainerFactory.setConfigPath("app.dicon");
		SingletonS2ContainerFactory.init();

		// S2AOPテスト
		Date date = new Date();
		date.getTime();

		// コンテナを取得する.
        S2Container container = SingletonS2ContainerFactory.getContainer();

		// インターセプタテスト
        PropertyInterTypeDto dto = (PropertyInterTypeDto)container.getComponent(PropertyInterTypeDto.class);
		try {
			Method setter = dto.getClass().getMethod("setFoo", new Class[]{ String.class});
			setter.invoke(dto,"Test");
	        Method getter = dto.getClass().getMethod("getFoo", (Class[])null );
			System.out.println("インターセプタテスト：" + (String)getter.invoke(dto));

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		// IMessageProviderインターフェイスを実装したコンポーネント取得
		IMessageProvider messageProvider = (IMessageProvider)container.getComponent(IMessageProvider.class);
		// メッセージ表示
		System.out.println(messageProvider.getMessage());

		// S2Container破棄
		SingletonS2ContainerFactory.destroy();
	}


}
