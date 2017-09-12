
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.factory.DbFactory;
import com.model.*;

public class FacultyDao {
	DbFactory db;
	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	Date date = new Date();

	public FacultyDao() {
		db = new DbFactory();
		con = db.getMySqlConnection();

	}

	public List<StudentVo> getStudentList(int branchId, int semesterId, int subjectId, String facultyId) {
		List<StudentVo> list = new ArrayList<StudentVo>();

		try {
			ps = con.prepareStatement(
					"select student.student_admno,student.student_name from studentsubject inner join studentbranch inner join student " +
							"on studentsubject.student_admno = studentbranch.student_admno and student.student_admno = studentsubject.student_admno " +
							"where subject_id = ? and faculty_id=? and branch_id = ? and semester=?;");
			ps.setInt(1, subjectId);
			ps.setString(2, facultyId);
			ps.setInt(3, branchId);
			ps.setInt(4, semesterId);

			rs = ps.executeQuery();
			while (rs.next()) {
				StudentVo studentVo = new StudentVo();
				studentVo.setStudentAdmno(rs.getString(1));
				studentVo.setStudentName(rs.getString(2));
				list.add(studentVo);


			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return list;
	}

	public void setAttendance(String facultyId, String studentAdmno, int subjectId, char attendance) {
		Calendar calendar = Calendar.getInstance();
		Date date2 = calendar.getTime();
		try {
			ps = con.prepareStatement("insert into datewiseattendance(student_admno,subject_id,faculty_id,adate,attendance,day) values (?,?,?,?,?,?)");
			ps.setString(1, studentAdmno);
			ps.setInt(2, subjectId);
			ps.setString(3, facultyId);
			ps.setDate(4, new java.sql.Date(calendar.getTime().getTime()));
			ps.setString(5, Character.toString(attendance));
			ps.setString(6, new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date2.getTime()));
			int i = ps.executeUpdate();
			System.out.println(i);

			ps = con.prepareStatement("update studentsubject  set attendance = attendance + ?  where student_admNo=? and subject_id=? and faculty_id=?");
			PreparedStatement ps2 = con.prepareStatement("update studentsubject  set totalattendance= totalattendance + ? where student_admNo=? and subject_id=? and faculty_id=?");

			ps.setString(2, studentAdmno);
			ps.setInt(3, subjectId);
			ps.setString(4, facultyId);
			ps2.setString(2, studentAdmno);
			ps2.setInt(3, subjectId);
			ps2.setString(4, facultyId);


			if (attendance == 'P') {
				ps.setInt(1, 1);
				ps2.setInt(1, 1);
			} else if (attendance == 'A') {
				ps.setInt(1, 0);
				ps2.setInt(1, 1);
			} else {
				ps.setInt(1, 0);
				ps2.setInt(1, 0);
			}
			int j = ps.executeUpdate();
			int k = ps2.executeUpdate();

			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<DateWiseAttendanceVo> updateAttendanceView(String studentAdmno, int subjectId, java.sql.Date date) {
		List<DateWiseAttendanceVo> list = new ArrayList<DateWiseAttendanceVo>();
		try {
			ps = con.prepareStatement("Select * from datewiseattendance where student_admno =?, subject_Id=? and adate = ?");
			ps.setString(1, studentAdmno);
			ps.setInt(2, subjectId);
			ps.setDate(3, date);
			rs = ps.executeQuery();
			if (rs.next()) {
				DateWiseAttendanceVo datewise = new DateWiseAttendanceVo();
				datewise.setAttendanceId(rs.getInt(1));
				datewise.setAttendance(rs.getString(5).charAt(0));

				list.add(datewise);
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public void updateAttendance(int attendanceId, char attendance, char newAttendance, String studentAdmno, int subjectId) {
		try {
			ps = con.prepareStatement("update table datewiseattendance where attendance_id=? set attendance = ?");
			ps.setInt(1, attendanceId);
			ps.setString(2, Character.toString(newAttendance));
			ps.executeUpdate();
			ps = con.prepareStatement("update table studentsubject where student_admNo=? and subject_id=?  set attendance = attendance + ? and totalattendance= totalattendance + ?");
			ps.setString(1, studentAdmno);
			ps.setInt(2, subjectId);
			if (newAttendance == 'P' && attendance == 'A') {
				ps.setInt(3, 1);
				ps.setInt(4, 0);
			} else if (newAttendance == 'A' && attendance == 'P') {
				ps.setInt(3, -1);
				ps.setInt(4, 0);
			} else if ((attendance == 'P') && newAttendance == 'E') {
				ps.setInt(3, -1);
				ps.setInt(4, -1);

			} else if ((attendance == 'A') && newAttendance == 'E') {
				ps.setInt(3, 0);
				ps.setInt(4, -1);

			} else {
				ps.setInt(3, 0);
				ps.setInt(4, 0);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void uploadAssignment(AssignmentVo assignmentVo) {
		try {
			ps = con.prepareStatement("Insert into assigment(assigment_name,assigment_date,faculty_id,subject_id,assigment_ques1,assigment_ques2,assigment_ques3,assigment_ques4,assigment_ques5) values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, assignmentVo.getAssigmentName());
			ps.setDate(2, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
			ps.setString(3, assignmentVo.getFacultyId());
			ps.setInt(4, assignmentVo.getSubjectId());
			for (int i = 0; i < 5; i++) {
				ps.setString(5 + i, assignmentVo.getQuestions()[i]);

			}
			ps.executeUpdate();

			con.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<AssignmentVo> viewAssigments(int subjectId) {
		List<AssignmentVo> list = new ArrayList<AssignmentVo>();
		try {
			ps = con.prepareStatement("select * from assigment where subject_id = ?");

			ps.setInt(1, subjectId);
			rs = ps.executeQuery();
			while (rs.next()) {
				AssignmentVo av = new AssignmentVo();
				av.setAssignmentId(rs.getInt(1));
				av.setAssigmentName(rs.getString(2));
				av.setAssigmentDate(rs.getDate(3));
				av.setFacultyId(rs.getString(4));
				av.setSubjectId(rs.getInt(5));
				list.add(av);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return list;
	}

	public List<AssignmentVo> viewAssigmentsByFacId(String FacultyId) {
		List<AssignmentVo> list = new ArrayList<AssignmentVo>();
		try {
			ps = con.prepareStatement("select * from assigment where faculty_id = ?");

			ps.setString(1, FacultyId);
			rs = ps.executeQuery();
			while (rs.next()) {
				AssignmentVo av = new AssignmentVo();
				av.setAssignmentId(rs.getInt(1));
				av.setAssigmentName(rs.getString(2));
				av.setAssigmentDate(rs.getDate(3));
				av.setFacultyId(rs.getString(4));
				av.setSubjectId(rs.getInt(5));
				list.add(av);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return list;
	}

	public List<SumbitAssignmentVo> viewSubmittedAnsweres(int assignmentId) {
		List<SumbitAssignmentVo> list = new ArrayList<SumbitAssignmentVo>();

		try {
			ps = con.prepareStatement("select * from submitassigment where assigment_id = ?");
			ps.setInt(1, assignmentId);
			rs = ps.executeQuery();
			while (rs.next()) {
				SumbitAssignmentVo av = new SumbitAssignmentVo();
				av.setStudentAdmno(rs.getString(2));
				av.setAssigmentid(rs.getInt(2));
				String[] answeres = new String[5];
				for (int i = 0; i < 5; i++) {

					answeres[i] = rs.getString(3 + i);
				}
				av.setAnsweres(answeres);
				list.add(av);
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return list;
	}

	public String getFacultyName(String id) {
		String s = new String();

		try {
			ps = con.prepareStatement("Select Faculty_name from faculty where faculty_id = ?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				s = rs.getString(1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
}