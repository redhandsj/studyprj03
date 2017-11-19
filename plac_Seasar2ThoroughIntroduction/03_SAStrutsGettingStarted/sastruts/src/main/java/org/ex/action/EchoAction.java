package org.ex.action;

import javax.annotation.Resource;

import org.ex.form.EchoForm;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * Echoアプリ
 * @author redhandsj
 *
 * <p>
 * マッピングの命名規約
 * <ul>
 * <li> アクションクラス名から末尾の「Action」を削除
 * <li> 先頭を小文字に変換
 * <li> 「アクション名/メソッド名」がURL。メソッド名「index」は省略可能
 * <li> アクションにメソッドが１つの場合は、省略可能
 * </ul>
 * </p>
 *
 * <p>
 * マッピングの優先順位<br>
 *  http://localhost:8080/appname/hogeの場合は以下の優先順位
 * <ul>
 * <li> ルート.action.HogeAction#index()
 * <li> ルート.action.IndexAction#hoge()
 * <li> ルート.action.hoge.IndexAction#index()
 * </ul>
 * </p>
 */
public class EchoAction {

	/**
	 * アクションフォーム<br>
	 * <p>
	 * Seasar2では、publicはアノテーションなしでも自動バインディングされる<br>
	 * 明示的にアノテーションする事が推奨。
	 * </p>
	 */
	@Resource
	@ActionForm
	protected EchoForm echoForm;

	/**
	 * 入力画面の実行
	 */
	@Execute(validator=false)
	public String index() {
		return "input.jsp";
	}

	/**
	 * エコー画面の実行
	 * <p>
	 * 入力画面でエラーがあった場合、input.jspに表示を戻す
	 * </p>
	 */
	@Execute(validator=true, input="input.jsp")
	public String echo() {
		return "echo.jsp";
	}

}
