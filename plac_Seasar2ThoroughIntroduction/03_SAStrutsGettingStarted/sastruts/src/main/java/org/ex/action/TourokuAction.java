package org.ex.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.ex.dto.UserDto;
import org.ex.form.TourokuForm;
import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.framework.container.SingletonS2Container;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class TourokuAction {

	@Resource
	@ActionForm
	protected TourokuForm tourokuForm;

    /**
     * セッション情報
     */
    @Resource
    protected HttpSession session;

    /**
     * アクションのフォーム
     */
    public String actionMessage = "アクション自動フォーム";

    		/**
	 * 入力
	 * @return
	 */
	@Execute(validator=false, reset="reset")
	public String index() {
		// S2ContainerからJdbcManagerを取得
		JdbcManager jdbcManager = SingletonS2Container.getComponent(JdbcManager.class);

		// セッションに値を入力
		UserDto userDto = new UserDto();
		userDto.userId = 1000;
		userDto.userName = "TEST";
		session.setAttribute("userDto", userDto);
		return "input.jsp";
	}

	/**
     * 登録
     * @return
     */
//	@Execute(validator=true, input="input.jsp")
	@Execute(validate="validate", input="input.jsp")
    public String reg() {
//		if(true) {
//			// テスト
//			throw new ActionMessagesException("テストの為のエラー",false);
//		}
        return "complete?redirect=true";
    }

	/**
     * 完了
     * @return
     */
    @Execute(validator=false)
    public String complete() {
//        UserDto userDto = (UserDto)session.getAttribute("userDto");
//        tourokuForm.name = userDto.userName;
        return "cmp.jsp";
    }

}
