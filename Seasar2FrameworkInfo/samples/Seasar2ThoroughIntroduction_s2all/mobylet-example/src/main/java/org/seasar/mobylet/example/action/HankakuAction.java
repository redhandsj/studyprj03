package org.seasar.mobylet.example.action;

import javax.annotation.Resource;

import org.seasar.mobylet.example.form.HankakuForm;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * ユーザの入力した文字列のカナを半角に変換して表示するサンプルです。
 *
 * @author Naoki Takezoe
 */
public class HankakuAction {

	@Resource
	@ActionForm
	protected HankakuForm hankakuForm;

	public String message;

	@Execute(validator=false)
	public String index(){
		return "index.jsp";
	}

	@Execute(validator=true, input="index.jsp")
	public String send(){
		this.message = this.hankakuForm.message;
		return "result.jsp";
	}

}
