package org.ex;

import java.util.List;

import org.ex.entity.Emp;
import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.framework.container.SingletonS2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;

public class Main {

//	private static String installPath = "/h2_1_1_107_beta/bin";
//	private static Server h2server = null;
//	private static Connection con = null;

//	@Resource
//	protected JdbcManager jdbcManager;


	public static void main(String[] args) {
//		try {
//			/* 起動方法をコマンドプロンプト方式より変更した */
//			h2server = Server.createTcpServer( new String[] { "-tcpPort", "9092", "-baseDir ", installPath});
//			// データベース起動
//			h2server.start();
//
//			// DB接続
//			Class.forName("org.h2.Driver");
//			con = DriverManager.getConnection("jdbc:h2:./data/database/H2Test;TRACE_LEVEL_FILE=0", "sa", null);
//
//			// オートコミットオフ
//			con.setAutoCommit(false);
//		} catch (SQLException | ClassNotFoundException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//
//		PreparedStatement preState = null;

		SingletonS2ContainerFactory.init();

		// S2ContainerからJdbcManagerを取得
		JdbcManager jdbcManager = SingletonS2Container.getComponent(JdbcManager.class);

		// Jdbcを使用して検索
//		List<Emp> results = jdbcManager.from(Emp.class)
//				.where("deptId = 1").orderBy("empNo asc").getResultList();

		// 検索用メソッド
//		List<Emp> results = jdbcManager.from(Emp.class)
//				.id(1).version(1).getResultList();
		// 検索用メソッド
		List<Emp> results = jdbcManager.from(Emp.class)
				.where("DEPT_ID = 1")
				.forUpdate()
				.orderBy("ID DESC")
				.getResultList();

		// 検索結果を表示
		for(Emp emp : results) {
			System.out.println(emp.empNo + " : " + emp.empName);
		}

		// ====== 挿入======
//		Emp emp = new Emp();
//		emp.empNo = 9999;
//		emp.empName = "DODO";
//		emp.mgrId = 33;
////		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
////		try {
////			emp.hiredate = (Date) sdf.parse("20171010");
////		} catch (ParseException e) {
////			// TODO 自動生成された catch ブロック
////			e.printStackTrace();
////		}
//		emp.sal = new BigDecimal(20000.0);
//		emp.deptId = 1;
//
//		int count = jdbcManager.insert(emp).execute();
//		System.out.println(" count : " + count);



		SingletonS2ContainerFactory.destroy();
	}

}
