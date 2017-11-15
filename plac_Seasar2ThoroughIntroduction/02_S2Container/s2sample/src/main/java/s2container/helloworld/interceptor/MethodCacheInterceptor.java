package s2container.helloworld.interceptor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.aopalliance.intercept.MethodInvocation;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;

public class MethodCacheInterceptor  extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	// キャッシュ格納マップ
	private Map<String, Object> chacheMap = new ConcurrentHashMap<String, Object>();

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String key = this.createKey(invocation);
		Object value = this.chacheMap.get(key);

		// キャッシュされてない場合はメソッド呼び出し
		if(value == null) {
			value = invocation.proceed();
			this.chacheMap.put(key, value);
		}

		return value;
	}

	private String createKey(MethodInvocation invocation) {
		StringBuilder key = new StringBuilder();

		Class<?> targetClass = getTargetClass(invocation);
		key.append(targetClass.getName());
		key.append("#");
		key.append(invocation.getMethod().getName());
		key.append("(");

		Object[] args = invocation.getArguments();
		for(int i=0; i < args.length; i++) {
			if(i != 0) {
				key.append(",");
			}
			key.append(args[i]);
		}
		key.append(")");
		return key.toString();
	}


}
