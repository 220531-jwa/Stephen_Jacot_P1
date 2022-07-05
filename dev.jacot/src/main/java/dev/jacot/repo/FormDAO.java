package dev.jacot.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.jacot.models.Form;
import dev.jacot.util.ConnectionUtil;

public class FormDAO 
{
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	
	public Form createForm(Form f)
	{
		String sql = "insert into reimburstmentrequests values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) returning *;";
		
		try(Connection conn = cu.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, f.getFormDate());
			ps.setString(2, f.getFormTime());
			ps.setString(3, f.getEventDescription());
			ps.setString(4, f.geteFirstName());
			ps.setString(5, f.geteLastName());
			ps.setString(6, f.getEventLocation());
			ps.setInt(7, f.getEventCost());
			ps.setInt(8, f.getTotal());
			ps.setInt(9, f.getFormStatus());
			ps.setString(10, f.getFormJustification());
			ps.setInt(11, f.getEventType());
			ps.setInt(12, f.getEmployeeId());
			ps.setInt(13, f.getGradeType());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				return new Form(
				rs.getInt("id"),
				rs.getString("event_date"),
				rs.getString("event_time"),
				rs.getString("event_description"),
				rs.getString("e_first_name"),
				rs.getString("e_last_name"),
				rs.getString("event_location"),
				rs.getInt("event_cost"),
				rs.getInt("total_amount_reimbursements"),
				rs.getInt("form_status"),
				rs.getString("form_justification"),
				rs.getInt("event_type"),
				rs.getInt("e_id"),
				rs.getInt("grades_format")
				);	
			}
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Form> getFormById(int employeeId)
	{
		String sql = "select * from reimburstmentrequests where e_id = ?";
		
		try (Connection conn = cu.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, employeeId);
			
			ResultSet rs = ps.executeQuery();
			
			List<Form> forms = new ArrayList<>();
			
			if(rs.next())
			{
				int formid = rs.getInt("id");
				int eid = rs.getInt("e_id");
				
				int grades = rs.getInt("grades_format");
				
				String formDate = rs.getString("event_date");
				
				String formTime = rs.getString("event_time");
				
				int eventType = rs.getInt("event_type");
				
				int total = rs.getInt("total_amount_reimbursements");
				
				int eventCost = rs.getInt("event_cost");
				
				int formStatus = rs.getInt("form_status");
				
				String eFirstName = rs.getString("e_first_name");
				
				String eLastName = rs.getString("e_last_name");
				
				String formJustification = rs.getString("form_justification");
				
				String eventLocation = rs.getString("event_location");
				
				String eventDescription = rs.getString("event_description");
				
				Form f = new Form(formid,formDate, formTime, eventDescription, eFirstName, eLastName, eventLocation, eventCost, total, formStatus, formJustification, eventType, grades, eid);
				
				forms.add(f);
			} 
			
			return forms;
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}





	public List<Form> getAllForms() 
	{
		String sql = "select * from reimburstmentrequests";
		
		try(Connection conn = cu.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			List<Form> allForms = new ArrayList<>();
			
			while(rs.next())
			{

				Form f = new Form(
						rs.getInt("id"),
						rs.getString("event_date"),
						rs.getString("event_time"),
						rs.getString("event_description"),
						rs.getString("e_first_name"),
						rs.getString("e_last_name"),
						rs.getString("event_location"),
						rs.getInt("event_cost"),
						rs.getInt("total_amount_reimbursements"),
						rs.getInt("form_status"),
						rs.getString("form_justification"),
						rs.getInt("event_type"),
						rs.getInt("e_id"),
						rs.getInt("grades_format")
						);
				
				allForms.add(f);
				
			
			}
			
			return allForms;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean denyForm(Form f)
	{
		String sql = "update reimburstmentrequests" + " set form_status = ?" + " where id = ?";
		
		try(Connection conn = cu.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, f.getFormStatus());
			ps.setInt(2, f.getFormId());
			
			ps.executeUpdate();
			
			if(ps.executeUpdate() != 0)
			{
				return true;
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}





	public int getSumOfRequests() 
	{
		String sql = "select SUM(total_amount_reimbursements) as sum_total\r\n"
				+ "from reimburstmentrequests;";
		
		try(Connection conn = cu.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
		
		
		
	}

	public boolean approveForm(Form f) 
	{
		
		String sql = "update reimburstmentrequests" + " set form_status = ?" + " where id = ?";
		
		try(Connection conn = cu.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, f.getFormStatus());
			ps.setInt(2, f.getFormId());
			
			ps.executeUpdate();
			
			if(ps.executeUpdate() != 0)
			{
				return true;
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean editForm(Form f)
	{
		String sql = "update reimburstmentrequests" + " set event_date = ?, event_time = ?, event_description = ?, e_first_name = ?, e_last_name = ?, event_location = ?, event_cost = ?, event_type = ?, grades_format = ?, form_justification = ?" + " where id = ?";
		
		try(Connection conn = cu.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, f.getFormDate()); 
			ps.setString(2, f.getFormTime()); 
			ps.setString(3, f.getEventDescription()); 
			ps.setString(4, f.geteFirstName()); 
			ps.setString(5, f.geteLastName()); 
			ps.setString(6, f.getEventLocation()); 
			ps.setInt(7, f.getEventCost()); 
			ps.setInt(8, f.getEventType()); 
			ps.setInt(9, f.getGradeType()); 
			ps.setString(10, f.getFormJustification());
			ps.setInt(11, f.getFormId()); 
			
			
			ps.executeUpdate();
			
			if(ps.executeUpdate() != 0)
			{
				return true;
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

}
