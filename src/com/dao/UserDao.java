package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.factory.DbFactory;
import com.model.FacultyVo;
import com.model.ParentVo;
import com.model.StudentVo;
import com.model.UserType;
import com.model.UserVo;

public class UserDao {

	DbFactory db;
	Connection con;
	StudentVo studentVo = new StudentVo();
	UserVo userVo = null;
	FacultyVo facultyVo = new FacultyVo();
	ParentVo parentVo = new ParentVo();
   PreparedStatement ps;
   ResultSet rs;
	public UserDao() {
		db = new DbFactory();
		con = db.getMySqlConnection();

	}

	public UserVo validate(String email, String password) {

		try {
			PreparedStatement ps = con.prepareStatement("select user_id from user where user_email = ? and user_passsword=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ps = con.prepareStatement("select * from student where user_id = ?");
				ps.setInt(1, rs.getInt(1));

				ResultSet rs2 = ps.executeQuery();
				if (rs2.next()) {
					studentVo.setStudentAdmno(rs2.getString(1));
					studentVo.setStudentName(rs2.getString(2));
					studentVo.setStudentAddress(rs2.getString(3));
					studentVo.setStudentDob(rs2.getDate(4));
					studentVo.setStudentMobile(rs2.getLong(5));
					studentVo.setStudentGender(rs2.getString(6).charAt(0));
					studentVo.setUserId(rs2.getInt(7));
					studentVo.setUserType(UserType.STUDENT);
							userVo = studentVo;
                      userVo.setName(rs2.getString(2));
				}

				ps = con.prepareStatement("select * from faculty where user_id = ?");
				ps.setInt(1, rs.getInt(1));
				ResultSet rs3 = ps.executeQuery();
				if (rs3.next()) {
					facultyVo.setFacultyId(rs3.getString(1));
					facultyVo.setFacultyName(rs3.getString(2));
					facultyVo.setFacultyAddress(rs3.getString(3));
					facultyVo.setFacultyDob(rs3.getDate(4));
					facultyVo.setFacultyMobile(rs3.getLong(5));
					facultyVo.setFacultyGender(rs3.getString(6).charAt(0));
					facultyVo.setUserId(rs3.getInt(7));
					facultyVo.setUserType(UserType.FACULTY);
					userVo = facultyVo;
                    userVo.setName(rs3.getString(2));

                }

				ps = con.prepareStatement("select * from parent where user_id = ?");
				ps.setInt(1, rs.getInt(1));
				ResultSet rs4 = ps.executeQuery();
				if (rs4.next()) {
					parentVo.setParentId(rs4.getInt(1));
					parentVo.setParentName(rs4.getString(2));
					parentVo.setParentAddress(rs4.getString(3));
					parentVo.setParentDob(rs4.getDate(4));
					parentVo.setParentMobile(rs4.getLong(5));
					parentVo.setParentOccupation(rs4.getString(6));
					parentVo.setParentSalary(rs4.getLong(7));
					parentVo.setUserId(rs4.getInt(8));
					parentVo.setUserType(UserType.PARENT);
					userVo = parentVo;
                    userVo.setName(rs4.getString(2));

                }

			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userVo.setUserEmail(email);
		return userVo;
	}

	public List<StudentVo> returnStudentList() {
     List<StudentVo> list=new ArrayList<StudentVo>();
		try {
			ps=con.prepareStatement("Select * from Student ");
			rs =ps.executeQuery();
			while(rs.next()){
				StudentVo studentVo = new StudentVo();
				studentVo.setUserId(rs.getInt(7));
				studentVo.setStudentAddress(rs.getString(3));
				studentVo.setStudentAdmno(rs.getString(1));
				studentVo.setStudentName(rs.getString(2));
				studentVo.setStudentDob(rs.getDate(4));
				studentVo.setStudentGender(rs.getString(6).charAt(0));
				studentVo.setStudentMobile(rs.getLong(5));

                System.out.print(studentVo.getStudentAdmno());

				list.add(studentVo);
			}
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return list;
	}

    public List<FacultyVo> returnFacultyList() {
        List<FacultyVo> list=new ArrayList<FacultyVo>();
        try {
            ps=con.prepareStatement("Select * from Faculty ");
            rs =ps.executeQuery();
            while(rs.next()){
                FacultyVo facultyVo = new FacultyVo();
                facultyVo.setFacultyId(rs.getString(1));
                facultyVo.setFacultyName(rs.getString(2));
                facultyVo.setFacultyAddress(rs.getString(3));
                facultyVo.setFacultyDob(rs.getDate(4));
                facultyVo.setFacultyMobile(rs.getLong(5));
                facultyVo.setFacultyGender(rs.getString(6).charAt(0));
                facultyVo.setUserId(rs.getInt(7));



                list.add(facultyVo);
            }
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }
    public List<ParentVo> returnParentList() {
        List<ParentVo> list=new ArrayList<ParentVo>();
        try {
            ps=con.prepareStatement("Select * from Parent ");
            rs =ps.executeQuery();
            while(rs.next()){
                ParentVo parentVo = new ParentVo();
                parentVo.setParentId(rs.getInt(1));
                parentVo.setParentName(rs.getString(2));
                parentVo.setParentAddress(rs.getString(3));
                parentVo.setParentDob(rs.getDate(4));
                parentVo.setParentMobile(rs.getLong(5));
                parentVo.setParentOccupation(rs.getString(6));
                parentVo.setParentSalary(rs.getLong(7));
                parentVo.setUserId(rs.getInt(8));




                list.add(parentVo);
            }
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }

  public List<UserVo> returnUsers(String userType){
	    List<UserVo> list = new ArrayList<UserVo>();
      try {
          ps = con.prepareStatement("Select * from  user inner join " + userType +" on user.user_id = " + userType + ".user_id");
     rs = ps.executeQuery();
     while (rs.next()){
         UserVo userVo = new UserVo();
         userVo.setUserId(rs.getInt(1));
         userVo.setUserEmail(rs.getString(2));
         userVo.setName(rs.getString(5));
         list.add(userVo);
     }
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return list;
  }

  public void sendMessage(int senderId,int recieverId,String message){
      try {
          ps =  con.prepareStatement("insert into chattable(sender_userid ,reciever_userid ,message ) values (?,?,?)");
          ps.setInt(1,senderId);
          ps.setInt(2,recieverId);
          ps.setString(3,message);
       int i = ps.executeUpdate();
       if(i>0)
       con.commit();
      } catch (SQLException e) {
          e.printStackTrace();
      }

  }


    public List<String> showMessages(int sid, int rid){
        List<String> list = new ArrayList<String>();
        try {
            ps = con.prepareStatement("select message from chattable where (sender_userid=? and reciever_userid=?) OR (sender_userid=? and reciever_userid=?)");
            ps.setInt(1,sid);
            ps.setInt(2,rid);
            ps.setInt(3,rid);
            ps.setInt(4,sid);
            rs=ps.executeQuery();
            while(rs.next())
            {
                list.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
