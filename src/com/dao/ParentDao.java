package com.dao;

import com.factory.DbFactory;
import com.model.StudentVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Animesh on 13-07-2017.
 */
public class ParentDao {

    DbFactory db;
    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    public ParentDao(){
        db = new DbFactory();
        con = db.getMySqlConnection();

    }

    public StudentVo getStudent(int parentId){
        StudentVo studentVo = new StudentVo();
        try {
            ps = con.prepareStatement("Select * from student inner join parentof on student.student_admno  = parentof.student_admno where parentof.parent_id= ?");
           ps.setInt(1,parentId);
            rs = ps.executeQuery();
            if(rs.next()){
                studentVo.setStudentAdmno(rs.getString(1));
                studentVo.setStudentName(rs.getString(2));
                studentVo.setStudentAddress(rs.getString(3));
                studentVo.setStudentDob(rs.getDate(4));
                studentVo.setStudentMobile(rs.getLong(5));
                studentVo.setStudentGender(rs.getString(6).charAt(0));
            }

        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        return studentVo;
    }

}
