package org.seasar.sastruts.example.mayaa.action;

import org.seasar.struts.annotation.Execute;

public class ComponentAction {

	@Execute(validator = false)
	public String index() {
        return "index.html";
	}

}
