package util;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DBUtil {
	private static DataSource ds=null;
	static{
		try{
			Properties pro=new Properties();
			pro.load(DBUtil.class.getClassLoader()
					.getResourceAsStream("resources/dbcpconfig.properties"));
			ds=BasicDataSourceFactory.createDataSource(pro);
		}catch(Exception e){
			throw new ExceptionInInitializerError("初始化连接错误,请检查配置文件");
		}
	}


	public static DataSource getDataSource(){
		return ds;
	}

	public static Connection getConnection() throws SQLException{
		Connection con=ds.getConnection();
		con.setAutoCommit(false);
		return con;
	}
}
