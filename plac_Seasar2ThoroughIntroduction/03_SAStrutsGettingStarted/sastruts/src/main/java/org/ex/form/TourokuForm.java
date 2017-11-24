package org.ex.form;

import java.io.Serializable;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.ex.dto.UserDto;
import org.ex.validator.RequiredArray;
import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;
import org.seasar.struts.annotation.Msg;
import org.seasar.struts.annotation.Required;

/**
 * フォーム
 * @author redhandsj
 * <p>
 * セッションスコープにしてみる
 * </p>
 */
@Component(instance=InstanceType.SESSION)
public class TourokuForm implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 入力
	 * <p>
	 * 必須チェックを追加
	 * </p>
	 */
	@Required
	public String name;

	/**
	 * 入力
	 * <p>
	 * 必須チェックを追加
	 * </p>
	 */
	@Required(msg=@Msg(key="ユーザ名を入力して下さい！！！",resource=false))
	public String userNm;

	/**
	 * 入力
	 * <p>
	 * 必須チェックを追加
	 * </p>
	 */
	@Required
	public String passwd;


	/**
	 * 複数選択
	 */
	@RequiredArray
	public String[] products;

	/**
	 * ネスト
	 */
	public UserDto user = new UserDto();

	/**
	 * 繰り返し
	 */
	public UserDto[] users = new UserDto[]{ new UserDto(),new UserDto(),new UserDto() };

	/**
	 * リセット
	 */
	public void reset() {
		products = null;
		name = "";
	}

	/**
	 * 検証メソッド
	 */
	public ActionMessages validate() {
		ActionMessages errors = new ActionMessages();
		// 名前が「aaaa」の場合
		if(!name.equals("aaaa")) {
			errors.add("name",new ActionMessage("aaaaではない！",false));
		}
		return errors;
	}
}
