package org.seasar.mobylet.example.action;

import org.seasar.struts.annotation.Execute;

/**
 * 絵文字を表示するサンプルです。
 *
 * @author Naoki Takezoe
 */
public class EmojiAction {

	@Execute(validator=false)
	public String index(){
		return "index.jsp";
	}

}
