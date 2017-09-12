package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.factory.DbFactory;
import com.model.AdminVo;
import com.model.BranchVo;
import com.model.FacultyVo;
import com.model.ParentOfVo;
import com.model.ParentVo;
import com.model.StudentBranchVo;
import com.model.StudentSubjectVo;
import com.model.StudentVo;
import com.model.SubjectVo;

public class AdminDao {

	DbFactory db;
	Connection con;
	PreparedStatement ps,ps2;
	ResultSet rs;
	public AdminDao() {
		db = new DbFactory();
		con = db.getMySqlConnection();
		
	}
	
	public AdminVo validate(String email,String password){
		AdminVo adminVo = null;
		try{
			ps = con.prepareStatement("select * from admin where admin_username = ? and admin_password = ?");
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()){
            	adminVo = new AdminVo();
            	adminVo.setAdmin_id(rs.getInt(1));
            	adminVo.setAdmin_name(rs.getString(2));
            	adminVo.setAdmin_username(email);
            	adminVo.setAdmin_password(password);
            	
               
            }
		}catch(SQLException e)
		{
			
		}
		return adminVo;
	}
	
	public void insertStudent(StudentVo studentVo){
		try {
			ps = con.prepareStatement("insert into user(user_email,email_password) values (?,?)");
			 ps.setString(1, studentVo.getUserEmail());
			 ps.setString(2, studentVo.getUserPassword());
			 ps.executeUpdate();
			 
			ps = con.prepareStatement("insert into student values (?,?,?,?,?,?,?) ");
			ps.setString(1,studentVo.getStudentAdmno());
			ps.setString(2, studentVo.getStudentName());
			ps.setString(3, studentVo.getStudentAddress());
			ps.setDate(4, (Date) studentVo.getStudentDob());
			ps.setLong(5, studentVo.getStudentMobile());
			ps.setString(6, Character.toString(studentVo.getStudentGender()));
			
			ps2 = con.prepareStatement("Select user_id from user where user_email = ?");
			 ps2.setString(1, studentVo.getUserEmail());
			 rs = ps2.executeQuery();
			 if(rs.next()){
				ps.setInt(7, rs.getInt(1));
				 
			 }
			 ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public void insertFaculty(FacultyVo facultyVo){
		try {
			ps = con.prepareStatement("insert into user(user_email,email_password) values (?,?)");
			 ps.setString(1, facultyVo.getUserEmail());
			 ps.setString(2, facultyVo.getUserPassword());
			 ps.executeUpdate();
			 
			ps = con.prepareStatement("insert into faculty values (?,?,?,?,?,?,?) ");
			ps.setString(1,facultyVo.getFacultyId());
			ps.setString(2, facultyVo.getFacultyName());
			ps.setString(3, facultyVo.getFacultyAddress());
			ps.setDate(4, (Date) facultyVo.getFacultyDob());
			ps.setLong(5, facultyVo.getFacultyMobile());
			ps.setString(6, Character.toString(facultyVo.getFacultyGender()));
			
			ps2 = con.prepareStatement("Select user_id from user where user_email = ?");
			 ps2.setString(1, facultyVo.getUserEmail());
			 rs = ps2.executeQuery();
			 if(rs.next()){
				ps.setInt(7, rs.getInt(1));
				 
			 }
			 ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public void insertParent(ParentVo parentVo){
		try {
			ps = con.prepareStatement("insert into user(user_email,email_password) values (?,?)");
			 ps.setString(1, parentVo.getUserEmail());
			 ps.setString(2, parentVo.getUserPassword());
			 ps.executeUpdate();
			 
			ps = con.prepareStatement("insert into faculty values (?,?,?,?,?,?,?) ");
			ps.setInt(1,parentVo.getParentId());
			ps.setString(2, parentVo.getParentName());
			ps.setString(3, parentVo.getParentAddress());
			ps.setDate(4, (Date) parentVo.getParentDob());
			ps.setLong(5, parentVo.getParentMobile());
			ps.setString(6, parentVo.getParentOccupation());
			ps.setLong(7, parentVo.getParentSalary());

			ps2 = con.prepareStatement("Select user_id from user where user_email = ?");
			 ps2.setString(1, parentVo.getUserEmail());
			 rs = ps2.executeQuery();
			 if(rs.next()){
				ps.setInt(8, rs.getInt(1));
				 
			 }
			 ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public void parentOf(ParentOfVo parentOfVo){
		try {
			ps = con.prepareStatement("insert into parentof values(?,?)");
			ps.setInt(1,parentOfVo.getParentId());
			ps.setString(2, parentOfVo.getStudentAdmno());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insertBranch(BranchVo branchVo){
		try {
			ps = con.prepareStatement("insert into branch(branch_name,branch_hod) values(?,?)");
			ps.setString(1,branchVo.getBranchName() );
			ps.setString(2, branchVo.getHOD());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insertSubject(SubjectVo subjectVo){
	try {
		ps = con.prepareStatement("insert into subject(subject_name) values(?)");
		ps.setString(1,subjectVo.getSubjectName() );
		ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

		
	}
	public void insertStudentBranch(StudentBranchVo studentBranchVo){
	
	try {
		ps = con.prepareStatement("insert into studentbranch values(?,?,?)");
		ps.setString(1, studentBranchVo.getStudentAdmno());
		ps.setInt(2, studentBranchVo.getBranchId() );
		ps.setInt(3, studentBranchVo.getSemester() );
		
		ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

}
	public void insertStudentSubject(StudentSubjectVo studentSubjectVo){
	
	try {
		ps = con.prepareStatement("insert into studentsubject values(?,?,?,?,?)");
		ps.setString(1, studentSubjectVo.getStudentAdmno());
		ps.setInt(2, studentSubjectVo.getSubjectId() );
		ps.setString(3, studentSubjectVo.getFacultyId() );
		ps.setInt(4, studentSubjectVo.getAttendance() );
		ps.setInt(5, studentSubjectVo.getTotalattendance() );
		
		ps.executeUpdate();} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

}

}
