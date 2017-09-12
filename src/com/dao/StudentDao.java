package com.dao;

import java.sql.*;
import java.util.*;

import com.factory.DbFactory;
import com.model.*;

public class StudentDao {

	DbFactory db;
	Connection con;
	  ResultSet rs;
	  PreparedStatement ps;
	public StudentDao(){
		db = new DbFactory();
		con = db.getMySqlConnection();

	}


	public List<SubjectVo> getSubjects(String studentAdmno){
		List<SubjectVo> list = new ArrayList<SubjectVo>() ;

		try {
			ps = con.prepareStatement(" select studentsubject.subject_id,subject_name from subject inner join studentSubject on subject.subject_id = studentsubject.subject_id and studentSubject.student_admno = ?");
            ps.setString(1,studentAdmno);
            rs = ps.executeQuery();
            while(rs.next()){
				SubjectVo subject = new SubjectVo();
            	subject.setSubjectId(rs.getInt(1));
				subject.setSubjectName(rs.getString(2));
            	list.add(subject);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		}


	public String  getAttendancestream(String studentAdmNo, int subId, java.sql.Date datea)
	{
		String list = new String("");
		
	  try {
		   ps = con.prepareStatement("Select attendance from datewiseattendance where student_admno  =? and subject_id =? and adate = ?");
		  ps.setString(1,studentAdmNo);
		  ps.setInt(2, subId);
		  ps.setDate(3, datea);
		  
		  rs = ps.executeQuery();

		  while(rs.next())
		  {   list = list + " "+rs.getString(1);

			}
		  
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
	}
	public StudentSubjectVo getSubjectAttendance(String studentAdmno,int subId)
	{   StudentSubjectVo studentSubjectVo = new StudentSubjectVo();
		try {
			 ps=con.prepareStatement("Select attendance,totalattendance from studentsubject where student_admno=?and subject_id=? ");
			ps.setString(1, studentAdmno);
			ps.setInt(2, subId);
			
			rs = ps.executeQuery();
			while(rs.next())
			{
				studentSubjectVo.setAttendance(rs.getInt(1));
				studentSubjectVo.setTotalattendance(rs.getInt(2));
			}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		return studentSubjectVo;
	}
	public List<AssignmentVo> viewAssigments(int subjectId){
		List<AssignmentVo> list= new ArrayList<AssignmentVo>();
       try {
		ps = con.prepareStatement("select * from assigment where subject_id = ?");

	       ps.setInt(1, subjectId);
	       rs = ps.executeQuery();
	       while(rs.next()){
	    	   AssignmentVo av =new AssignmentVo();
	    	   av.setAssignmentId(rs.getInt(1));
	    	   av.setAssigmentName(rs.getString(2));
	    	   av.setAssigmentDate(rs.getDate(3));
	    	   av.setFacultyId(rs.getString(4));
	    	   av.setSubjectId(rs.getInt(5));

	    	   av.setQuestions(new String[]{rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)});
	    	   list.add(av);
	       }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 
 
 return list;
		}
	public void submitAssigment(SumbitAssignmentVo submitAssignmentVo)
	{
		try {
			ps = con.prepareStatement("Insert into submitassigment values (?,?,?,?,?,?,?)");
			ps.setString(1,submitAssignmentVo.getStudentAdmno());
			ps.setInt(2,submitAssignmentVo.getAssigmentid());
			for(int i=0;i<5;i++)
			{
				ps.setString(i+3, submitAssignmentVo.getAnsweres()[i]);
			}
           ps.executeUpdate();
        con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
	
	

