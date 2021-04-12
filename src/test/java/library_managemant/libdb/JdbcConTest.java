package library_managemant.libdb;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

public class JdbcConTest {

	@Test
	public void testGetConnection() {
		System.out.printf("%s()%n", "testGetconnection()");
		Connection con = JdbcCon.getConnection();
		System.out.println("con > " + con);
		Assert.assertNotNull(con);
		
		System.out.println(con);
	}

}
