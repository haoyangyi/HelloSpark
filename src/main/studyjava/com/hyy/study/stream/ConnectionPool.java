package com.hyy.study.stream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class ConnectionPool {

	// 队列
	private static LinkedList<Connection> connectionQueue;

	static {
		// 加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public synchronized static Connection getConnection() {
		try {
			if (connectionQueue == null) {
				connectionQueue = new LinkedList<Connection>();
				for (int i = 0; i < 5; i++) {
					Connection conn = DriverManager.getConnection(
							"jdbc:mysql://node24:3306/test", "root",
							"123123");
					connectionQueue.push(conn);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connectionQueue.poll();
	}
	
	public static void returnConnection(Connection conn){
		connectionQueue.push(conn);
	}
}
