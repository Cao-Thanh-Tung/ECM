package mta.otherAnnotations.propertyResource;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMainClass {
	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();//(DBConnection.class);
		context.scan("mta.otherAnnotations.propertyResource");
		context.refresh();
		DBConnection dbConnection = context.getBean(DBConnection.class);
		System.out.println(dbConnection.getAppName());
		System.out.println(dbConnection.getAppName1());
		Connection con = dbConnection.getConnection();
		System.out.println(con.getMetaData().getDatabaseProductName());
		System.out.println(con.getMetaData().getDatabaseProductVersion());

		// close the spring context
		context.close();
	}
}
