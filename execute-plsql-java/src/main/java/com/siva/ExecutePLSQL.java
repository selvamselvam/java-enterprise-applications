package com.siva;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import oracle.jdbc.pool.OracleDataSource;

public class ExecutePLSQL {

	public static void main(String[] args) throws SQLException {
		      OracleDataSource ods = new OracleDataSource();
		      ods.setURL("jdbc:oracle:thin:sys as sysdba/a@localhost:1521/xe");
		      
		      Connection conn = ods.getConnection();
		      CallableStatement cstmt = conn.prepareCall("{? =call f(?)}");
		      cstmt.registerOutParameter(1, Types.FLOAT);
		      cstmt.setInt(2, 20);
		      cstmt.executeUpdate();
		      float acctBal = cstmt.getFloat(1);
		      System.out.println ("Out argument is: " + acctBal);

		  

	}

}
