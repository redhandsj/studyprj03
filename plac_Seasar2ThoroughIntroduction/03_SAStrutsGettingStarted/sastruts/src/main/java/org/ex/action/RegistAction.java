package org.ex.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.ex.dto.UserDto;
import org.seasar.struts.annotation.Execute;

/**
 * 登録機能
 * @author redhandsj
 *
 */
public class RegistAction {

	/**
	 * セッション情報
	 */
	@Resource
	protected HttpSession session;

	/**
	 * 入力
	 * @return
	 */
	@Execute(validator=false)
	public String input() {
		return "input.jsp";
	}
	/**
	 * 登録
	 * @return
	 */
	@Execute(validator=false)
	public String register() {
		UserDto userDto = (UserDto)session.getAttribute("userDto");
		return "complete?redirect=true";
	}
	/**
	 * 完了
	 * @return
	 */
	@Execute(validator=false)
	public String complete() {
		return "complete.jsp";
	}
}
