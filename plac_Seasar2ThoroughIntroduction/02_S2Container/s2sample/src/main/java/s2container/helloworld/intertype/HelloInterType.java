package s2container.helloworld.intertype;

import org.seasar.framework.aop.intertype.AbstractInterType;

import javassist.CannotCompileException;
import javassist.NotFoundException;

public class HelloInterType extends AbstractInterType {
	@Override
	protected void introduce() throws CannotCompileException, NotFoundException {
		addMethod("public void hello(){ System.out.println(\"Hello World!\") }");
	}

}
