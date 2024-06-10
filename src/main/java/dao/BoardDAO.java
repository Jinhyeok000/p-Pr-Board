package dao;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	private static BoardDAO instance;

	public synchronized static BoardDAO getInstance() {
		if (instance == null) {
			return new BoardDAO();
		} else {
			return instance;
		}
	}

	private BoardDAO() {}

	private Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}

	//이곳부터 메서드를 넣으면 됩니다.
	
}
