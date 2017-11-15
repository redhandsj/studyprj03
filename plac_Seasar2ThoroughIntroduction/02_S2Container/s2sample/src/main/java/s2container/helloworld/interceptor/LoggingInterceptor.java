package s2container.helloworld.interceptor;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;
import org.seasar.framework.log.Logger;

public class LoggingInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(LoggingInterceptor.class);

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Class<?> clazz = getTargetClass(invocation);
		Method method = invocation.getMethod();

		// メソッド開始ログ
		if(logger.isInfoEnabled()) {
			logger.info(clazz.getSimpleName() + "#" + method.getName() + "() start.");
		}

		// メソッド本来の処理を実行
		Object result = invocation.proceed();

		// メソッド終了ログ
		if(logger.isInfoEnabled()) {
			logger.info(clazz.getSimpleName() + "#" + method.getName() + "() end.");
		}

		return result;
	}
}
