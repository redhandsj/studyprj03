package org.seasar.mobylet.example.action;

import org.seasar.struts.annotation.Execute;

/**
 * 画像リサイズのサンプルです。
 *
 * @author Naoki Takezie
 */
public class ImageAction {

	@Execute(validator=false)
	public String index(){
		return "index.jsp";
	}

}
