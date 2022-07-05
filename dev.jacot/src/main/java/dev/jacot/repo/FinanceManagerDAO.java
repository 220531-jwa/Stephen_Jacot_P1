package dev.jacot.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.jacot.models.Employee;
import dev.jacot.models.FinanceManager;
import dev.jacot.util.ConnectionUtil;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class FinanceManagerDAO 
{
	
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	
	public FinanceManager getFinanceManagerByUserName(String username) 
	{
		String sql = "select * from financemanager where manageruser = ?";
		
		try(Connection conn = cu.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				return new FinanceManager(
						rs.getString("manageruser"),
						rs.getString("managerpass"),
						rs.getString("last_name"),
						rs.getString("first_name"),
						rs.getInt("id"));
			}
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
			
		}
		
		return null;
	}

}
