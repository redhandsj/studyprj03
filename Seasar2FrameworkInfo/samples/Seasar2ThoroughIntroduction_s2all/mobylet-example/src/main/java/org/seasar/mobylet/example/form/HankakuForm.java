package org.seasar.mobylet.example.form;

import org.seasar.mobylet.example.action.HankakuAction;
import org.seasar.struts.annotation.Required;

/**
 * {@link HankakuAction}で使用するアクションフォームです。
 *
 * @author Naoki Takezoe
 */
public class HankakuForm {

	@Required
	public String message;

}
