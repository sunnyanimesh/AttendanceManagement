package com.dao;

import com.factory.DbFactory;
import com.model.SubjectVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Animesh on 10-07-2017.
 */
public class SubjectDao {
    DbFactory db;
    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    public SubjectDao(){
        db = new DbFactory();
        con = db.getMySqlConnection();

    }

    public List<SubjectVo> getSubjects(){
        List<SubjectVo> list = new ArrayList<SubjectVo>();
        try {
            ps = con.prepareStatement("Select  * from  subject ");
            rs = ps.executeQuery();
            while(rs.next()){
                SubjectVo subjectVo = new SubjectVo();
                subjectVo.setSubjectId(rs.getInt(1));
                subjectVo.setSubjectName(rs.getString(2));
            list.add(subjectVo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

   public String getSubjectName(int id){
       String s = new String();

       try {
           ps = con.prepareStatement("Select Subject_name from subject where subject_id = ?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next()){
                s = rs.getString(1);

            }
       } catch (SQLException e) {
           e.printStackTrace();
       }

return s;
   }
}
