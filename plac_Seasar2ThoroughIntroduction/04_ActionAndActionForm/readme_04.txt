★Seasar2_徹底入門.pdf
 - (CHAPTER 04) アクションとアクションフォーム (P.149 - 188)
しおり　：　
URL　:　

★ 2017/11/13(月)に、新規作成



//==========================================================================================================
// 4.1 　アクション
//==========================================================================================================
03_SAStrutsGettingStarted/sastruts で解説

■4.1.1 実行メソッドとURLとのマッピング
 - １ユースケース＝１アクション
 - /sastruts/src/main/java/org/ex/action/EchoAction.java

■4.1.2 URLパターン
 - http://localhost:8080/appname/employee/list
      ↓
   public class EmployeeAction {
     @Excute(urlPattern="list")
     public String index() {
       :
     }
   }

 - http://localhost:8080/appname/employee/detail/10
      ↓
   public class EmployeeAction {
     @Excute(urlPattern="detail/{empId}")
     public String index() {
       :
     }
   }

■4.1.3 リクエストパラメータの取得
 - /sastruts/src/main/java/org/ex/form/EchoForm.java


■4.1.4 アクションからJSPへの値の受け渡し
 - アクションのpublicフィールドをsetAttribute()
 - また、publicなgetterがある場合に意図しないタイミングで呼ばれる場合があるので注意
 ⇒ /sastruts/src/main/java/org/ex/action/SampleAction.java
 ⇒ /sastruts/src/main/webapp/WEB-INF/view/sample/index.jsp


■4.1.5 アクションの粒度
 - URL設計とアクションフォーム
 - アクションフォームを共有できる処理

■4.1.6 画面遷移
 - アクションが返す値
   - 遷移先のJSP
     - 先頭「/」なら絶対パス、それ以外は相対パス
   - 別のアクション名（フォワード）
   - アクション名に「?redirect=true」を付与（リダイレクト）
     - PRG(Post-Redirect-Get)パターン
       - フォーム二重送信防止
         → P.157 の図

■4.1.7 HTTPセッションの利用
 - dto パッケージで、@Componentの session となる（セッションスコープで管理）
 - セッションに格納する場合、「java.io.Serializable」インターフェイスを実装

  // ログインユーザ情報
  @Component(instance = InstanceTyp.SESSION)
  public class UserDto implements Serializable {
    private static final long serialVersionUID = 1L;
    public long userId;
    public String userName;
  }

  // アクション例
  public class SampleAction{
    @Resouce
    protected UserDto userDto;
  }

 ⇒　/sastruts/src/main/java/org/ex/dto/UserDto.java
 ⇒　/sastruts/src/main/java/org/ex/action/TourokuAction.java

■4.1.8 Servlet API を利用する
 ⇒　/sastruts/src/main/java/org/ex/action/TourokuAction.java
    HttpSessionを追加

//==========================================================================================================
// 4.2　 アクションフォーム
//==========================================================================================================
 - Stringにしておくことを推奨

■4.2.1 アクションフォームのスコープ
 - !!!!! デフォルトではリクエストスコープ !!!!!
 - @Component(instance=InstanceType.SESSION) → セッションスコープ
 - @Execute(removeAction = true) でセッション中にフォーム削除可能

■4.2.2 複雑なアクションフォーム
 ⇒ /sastruts/src/main/java/org/ex/action/TourokuAction.java
    /sastruts/src/main/webapp/WEB-INF/view/touroku/*.jsp

■4.2.3 リセットメソッド
 - チェックボックスやセレクトボックスは選択時のみパラメータ送信
 - セッションスコープの場合状態が残るので、リセットメソッド

■4.2.4 アクションフォームを定義しない場合の注意点
 - アクション自体のpublicフィールドが使われる
 - http://localhost:8080/sastruts/touroku/?actionMessage=aaaaa
   - パラメータで値が書き換えられる事を防止する為に、アクションで明示的に初期化する


//==========================================================================================================
// 4.3　 入力チェック
//==========================================================================================================

■4.3.1 アノテーションを使用した入力チェック
 - @Execute(validator=true, input="input.jsp")
   - validator → チェックを行う
   - input → エラーで遷移するJSP

 - @Required(target="simpleSearch1,simpleSearch1")
   - 必須チェックを行うアクションクラスのメソッド

 - フォーム内でネストされたDTOでは、チェックはサポートされていない

■4.3.2 検証メソッドによる入力チェック
 - @Execute(validate="validate", input="input.jsp")
   - 検証メソッドを自作する
 ⇒ org.ex.action#TourokuAction
    org.ex.form#TourokuForm

 - 実行メソッド内での入力チェック
  ⇒ org.ex.action.TourokuAction.reg()

■4.3.3 入力チェックエラーの表示
 - application(_ja).properties
   <html:text property="userName" errorStyleClass="error" />
    ↓ 入力チェックエラーの時に class 属性が追加される
   <input type="text" name="userName" value="" class="error">

■4.3.4 入力チェック用のアノテーション
 - P.177 からの表


■4.3.5 JavaScriptによる入力チェック
 ⇒ /sastruts/src/main/webapp/WEB-INF/view/touroku/input.jsp
   - <html:javascript formName="tourokuActionForm_reg" />
   - <s:submit property="reg" value="登録" clientValidate="true" />
                                           ~~~~~~~~~~~~~~~~~~~~~

■4.3.6 エラーメッセージを変更する
 - /sastruts/src/main/resources/application_ja.properties
 - /sastruts/src/main/resources/application.properties
 - 直接指定
   ⇒ /sastruts/src/main/java/org/ex/form/TourokuForm.java
    @Required(msg=@Msg(key="ユーザ名を入力して下さい！！！",resource=false))


■4.3.7 独自の入力チェック用アノテーションを作成する
 ⇒ /sastruts/src/main/java/org/ex/validator/ArrayChecks.java
 ⇒ /sastruts/src/main/java/org/ex/validator/RequiredArray.java
 ⇒ /sastruts/src/main/webapp/WEB-INF/validator-rules.xml



############ P.190 #######################






//==========================================================================================================
//==========================================================================================================
// 問題
//==========================================================================================================


//==========================================================================================================
// 未整頓メモ
//==========================================================================================================
★ PRG(Post-Redirect-Get)パターン
 - フォームデータをPOSTした後、リダイレクトせずに画面を表示し、ブラウザを再読み込みすると、もう一度POSTしよ
   うとしてしまいます。しかし、POST後にリダイレクトして画面を表示するようにすれば、ブラウザを再読み込みして
   も送信されるのはGETリクエストなので、フォームデータの二重送信が防げるというものです。




//==========================================================================================================
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



//==========================================================================================================
// <END>
//==========================================================================================================
