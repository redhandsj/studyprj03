★Seasar2_徹底入門.pdf
 - (CHAPTER 02) S2Container (P.038 - 127)
しおり　：　
URL　:　

★ 2017/11/13(月)に、新規作成

//==========================================================================================================
// 2.1 はじめての S2Container
//==========================================================================================================
■ プロジェクト作成
 - http://eclipse.seasar.org/updates/3.2/

 - 準備（http://itmemo.net-luck.com/seasar2-sastruts-s2jdbc/）
---------------------------------------------------------
 必要なプラグインは、以下の5つ。

「Tomcat Launcher」
「Dolteng」
「SAStrutsPlugin」
「ResourceSynchronizer」
「PropertiesEditor」
なお、「Tomcat Launcher」は、Pleiades All in Oneパッケージの場合、すでに入っているので省略。

Eclipseを起動し、メニューバーの「ヘルプ」⇒「新規ソフトウェアのインストール」を開く。

「作業対象」に「http://propedit.sourceforge.jp/eclipse/updates/」を入力し、「追加」ボタンを押下する。

一覧が表示されるので、「プロパティーエディター」にチェックし、「次へ」ボタンで進み、インストールする。

「作業対象」に「http://eclipse.seasar.org/updates/3.3/」を入力し、「追加」ボタンを押下する。

一覧が表示されるので、「Dolteng」、「SAStrutsPlugin」、「ResourceSynchronizer」、にチェックし、「次へ」ボタンで進み、インストールする。

プラグインのインストール後は、Eclipseの再起動を促されるので、再起動する。
---------------------------------------------------------

⇒ s2sample プロジェクト作成

■ 2.1.2 Hello,Seasar2 !
■ 2.1.3 S2Container の初期化
■ 2.1.4 コンポーネントの取得
 ⇒ s2sample Main.java に記載

■ 2.1.5 DIの設定
 - diconファイル
   - propertyタグで明示的に指定


//==========================================================================================================
// 2.2　 コンポーネントの定義
//==========================================================================================================
<component>
class → クラス名
name → コンポーネント名
instance → ライフサイクル ※重要！！！！
autoBinding → 自動バインディング設定
</component>

■2.2.1 コンポーネントのライフサイクル
 - singleton (標準) → 何度getしても同じインスタンス
 - prototype → getの度に新しいインスタンス
 - request → リクエストごとにインスタンス生成
 - session → sessionごとにインスタンス生成
 - application → サーブレットコンテキストごと
 - outer → インスタンスをコンテナの外で生成
⇒ /s2sample/src/main/resources/app.dicon に追加
 - 自分より短いライフサイクルのDIはできない


//==========================================================================================================
// 2.3　 インジェクションの種類
//==========================================================================================================

■2.3.1 コンストラクタインジェクション
  ⇒ public class HelloMessageProvider
     - コンストラクタを作成

■2.3.2 セッターインジェクション
  ⇒ public class HelloMessageProvider
     - setInjectStrを作成

■2.3.3 メソッドインジェクション
  ⇒ public class HelloMessageProvider
     - addListを作成
       ※ !!!!!!!!!!!!! 失敗

■2.3.4 自動バインディング
  - autoBindingタグ
    - auto → コンストラクタとプロパティに対して自動バインディング
    - semiauto → アノテーションなどで指定した場合
    - constructor → コンストラクタ
    - property → プロパティ
    - none → 自動バインディングなし


■2.3.5 外部バインディング
   <component externalBinding="true" />

//==========================================================================================================
// 2.4　 OGNL
//==========================================================================================================
■2.4.1 OGNLの使用例
■2.4.2 OGNLリファレンス
※省略



//==========================================================================================================
// 2.5　 インクルードと名前空間
//==========================================================================================================
■2.5.1 includeタグによるインクルード
 - diconファイルの親子関係
  <components>
    <include path="foo.dicon"/>
    <include path="bar.dicon"/>
  </components>
 - コンポーネント検索は、親から子の順に実行
 - インクルードdicon切り替え
   - webアプリでは、JARファイルより、WEBINF/classes が優先順位が高い
 - 名前空間
   - <components namespace="aop">
   - 他のdionファイルで参照する場合は、aop.traceInterceptor で参照する

■2.5.2 XInclude を使用したインクルード
 - <xi:include> でインクルードした部分はそのまま置換される


//==========================================================================================================
// 2.6　 AOP
//==========================================================================================================
■ 2.6.1 AOPとは？
  ⇒ LoggingInterceptor作成
 - トランザクション管理
 - 例外
 - セキュリティ
 - キャッシュ

■ 2.6.2 S2AOPの利用方法
  <component class="java.util.Date">
    <aspect pointcut="get.*">aop.traceInterceptor</aspect>
  </component>
 - finalクラスには適用できない
 - final , static , public メソッドには適用できない

■ 2.6.3 Seasar2が提供するインターセプタ
 - Seasar2はデフォルトで用意されているインターセプタ
 - <include path="aop.dicon"/>
   - ここに登録されているものは、P.72
 - SMART deploy 対象のコンポーネントの場合、@Trace
    P.73 ～
 ※ ここのアノテーションの使用する為の方法は後日

■ 2.6.4 インターセプタのグループ化
  <component name="Chain" class="org.seasar.framework.aop.interceptors.InterceptorChain">
    <initMethod name="add"><arg>loggingInterceptor</arg></initMethod>
  </component>

■ 2.6.5 独自インターセプタの作成
 ⇒ MethodCacheInterceptor作成


■ 2.6.6 インタータイプ
 - PropertyInterType
   ⇒ PropertyInterTypeDto作成
   - @Propertyでもgetter/setterの調整可能
 - InterTypeChain
   - 複数のインタータイプをグループ化する

■ 2.6.7 独自インタータイプ
 - HelloInterType
   ⇒ HelloInterType
	// InterTypeが適用されたコンポーネント
	private HelloWorld helloWorld;
   ※ 実際は省略

■ 2.6.8 AOPによるトランザクション制御
 - P.89 の表
 - P.90 の図 !!!!!!!!! 超重要 !!!!!!!!!!
 - 例外はスローしたいが、トランザクションはコミットしたい
  <!-- トランザクション -->
  <component name="requiredTx" class="org.seasar.extendsion.tx.RequiredInterceptor">
    <!-- 例外はスルーするが、コミットは行うものを登録 -->
    <initMethod>
      <arg>@org.seasar.exsample.exception.CommitException@class</arg>
    </initMethod>
  </component>


//==========================================================================================================
// 2.7　 自動登録
//==========================================================================================================
■ 2.7.1 コンポーネントの自動登録
 - 基本形
  <!-- コンポーネントの自動登録（ファイルシステムからクラスを検索） -->
  <component class="org.seasar.framework.container.autoregister.FileSystemComponentAutoRegister">
    <!-- 自動登録するコンポーネントのライフサイクルはprototype -->
	<property name="instanceDef">@org.seasar.framework.container.deployer.InstanceDefFactory@PROTOTYPE</property>
    <!-- 登録するコンポーネントへの自動バインディングは行わない -->
    <property name="autoBindingDef">@org.seasar.framework.container.assembler.AutoBinding</property>
    <!-- クラス名からコンポーネント名を決定するクラスを指定 -->
    <property name="autoNaming"></property>
    <!-- org.seasar.exsample.Mainを起点に検索 -->
    <initMethod name="addReferenceClass"><arg>@org.seasar.exsample.Main@class</arg></initMethod>
    <!-- org.seasar.exsample.component パッケージ配下でImpl で終わるクラスを自動登録 -->
    <initMethod name="addClassPattern">
      <arg>"org.seasar.exsample.component"</arg>
      <arg>".*Impl"</arg>
    </initMethod>
    <!-- org.seasar.exsample.component パッケージ配下でImpl で終わるクラスを自動登録 -->
    <initMethod name="addClassPattern">
      <arg>"org.seasar.exsample.component"</arg>
      <arg>"get*"</arg>
    </initMethod>
    <!-- org.seasar.exsample.component パッケージ配下でgetで始まるクラスを自動登録しない -->
    <initMethod name="addignoreClassPattern">
      <arg>"org.seasar.exsample.component"</arg>
      <arg>"get*"</arg>
    </initMethod>
  </component>
 - ファイルシステムからクラスを検索してコンポーネント
  <component class="org.seasar.framework.container.autoregister.FileSystemComponentAutoRegister">
 - JARファイルからクラスを検索してコンポーネント
  <component class="org.seasar.framework.container.autoregister.JarComponentAutoRegister">



■ 2.7.2 自動登録されるコンポーネントのコンポーネント名
 - クラス名のパッケージ部分除く
 - クラス名の末尾の「Impl」「Bean」は削除
 - クラス名の先頭を小文字にする
  <component class="org.seasar.framework.container.autoregister.DefaultAutoNaming">
    <!-- クラス名の先頭を小文字にする？ -->
	<property name="decapitalize">true</property>
	<!-- コンポーネント名の末尾から削除する文字列を指定 -->
    <initMethod name="addignoreClassSuffix">
      <arg>"suffix"</arg>
    </initMethod>
	<!-- 特定のクラスにネーミングルールに合致しないコンポーネント名を付与したい場合 -->
    <initMethod name="setCustomizedName">
      <arg>"fqcn"</arg>
      <arg>"name"</arg>
    </initMethod>
    <!-- コンポーネント名を置換する為のルールを追加 -->
    <initMethod name="addREplaceRule">
      <arg>"regex"</arg>
      <arg>"replacement"</arg>
    </initMethod>
  </component>

■ 2.7.3 アスペクトの自動登録
 - <component class="org.seasar.framework.container.autoregister.ComponentAutoRegister">
   よりも
   <component class="org.seasar.framework.container.autoregister.AspectAutoRegister">
   を先に書く必要がある

  <!-- クラスのパターンを指定してアスペクトを自動登録する -->
  <component class="org.seasar.framework.container.autoregister.AspectAutoRegister">
    <!-- 適用するインターセプタ -->
	<property name="interceptor"></property>
	<!-- インターセプタ適用箇所 -->
	<property name="pointcut"></property>
	<!-- 自動登録するクラスのパターン -->
    <initMethod name="addClassPattern">
      <arg>"org.seasar.exsample.component"</arg>
      <arg>".*Impl"</arg>
    </initMethod>
	<!-- 自動登録しないクラスのパターン -->
    <initMethod name="addignoreClassPattern">
      <arg>"org.seasar.exsample.component"</arg>
      <arg>".*Impl"</arg>
    </initMethod>
  </component>

  <!-- 指定したインターフェイスを実装したクラスに対してアスペクトを自動登録 -->
  <component class="org.seasar.framework.container.autoregister.InterfaceAspectAutoRegister">
    <!-- 適用するインターセプタを指定 -->
    <property name="intercenpor"></property>
    <!-- インターセプタを適用するインターフェイスを指定 -->
    <property name="targetInterface"></property>
  </component>


//==========================================================================================================
// 2.8　 アノテーション
//==========================================================================================================
 - P.99 表

//==========================================================================================================
// 2.9　 Web アプリケーションでの利用
//==========================================================================================================

############ P.103 #######################



//==========================================================================================================
// 2.10　環境ごとの切り替え
//==========================================================================================================

//==========================================================================================================
// 2.11　SMART deploy
//==========================================================================================================

//==========================================================================================================
// 2.12　dicon ファイルの構成
//==========================================================================================================

//==========================================================================================================
// 2.13　dicon ファイルリファレンス
//==========================================================================================================







//==========================================================================================================
//==========================================================================================================
// 問題
//==========================================================================================================


//==========================================================================================================
// 未整頓メモ
//==========================================================================================================


//==========================================================================================================
// <END>
//==========================================================================================================
