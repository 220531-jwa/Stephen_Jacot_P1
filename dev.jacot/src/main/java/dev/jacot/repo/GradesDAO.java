package dev.jacot.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.jacot.models.Form;
import dev.jacot.models.Grades;
import dev.jacot.util.ConnectionUtil;

public class GradesDAO {
	
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	public Grades createGrades(Grades g) 
	{
		String sql = "insert into grades values (default, ?, ?, ?) returning *;";
		
		try(Connection conn = cu.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, String.valueOf(g.getLetterGrade()));
			ps.setBoolean(2, g.isPresentation());
			ps.setBoolean(3, g.isPassOrFail());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				return new Grades(
				rs.getInt("id"),
				rs.getString("letter_grade").charAt(0),
				rs.getBoolean("presentatation"),
				rs.getBoolean("pass_or_fail")
				);	
			}
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	
	
	public List<Grades> getAllGrades()
	{
		String sql = "select * from grades";
		
		try(Connection conn = cu.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			List<Grades> allGrades = new ArrayList<>();
			
			
			while(rs.next())
			{
				Grades g = new Grades(rs.getInt("id"),
						rs.getString("letter_grade").charAt(0),
						rs.getBoolean("presentatation"),
						rs.getBoolean("pass_or_fail"));
				
				allGrades.add(g);
			}
			
			return allGrades;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
