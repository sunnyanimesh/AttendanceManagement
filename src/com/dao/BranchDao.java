package com.dao;

import com.factory.DbFactory;
import com.model.BranchVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Animesh on 10-07-2017.
 */
public class BranchDao {
    DbFactory db;
    Connection con;
    ResultSet rs;
    PreparedStatement ps;

    public BranchDao() {
        db = new DbFactory();
        con = db.getMySqlConnection();

    }

    public List<BranchVo> getBranch(){
        List<BranchVo> list = new ArrayList<BranchVo>();
        try {
            ps = con.prepareStatement("Select  * from  branch ");
            rs = ps.executeQuery();
            while(rs.next()){
                BranchVo branchVo = new BranchVo();
                branchVo.setBranchId(rs.getInt(1));
                branchVo.setBranchName(rs.getString(2));
                branchVo.setHOD(rs.getString(3));

                list.add(branchVo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public BranchVo getBranch(String studentadmno)  {
        BranchVo branchVo=new BranchVo();
        try{
            ps=con.prepareStatement("select branch.branch_Id,branch_Name from branch inner join studentbranch on  studentbranch.branch_Id = branch.branch_Id where student_admno=?");
            ps.setString(1,studentadmno);
            rs=ps.executeQuery();
            if(rs.next()){
                branchVo.setBranchId(rs.getInt(1));
                branchVo.setBranchName(rs.getString(2));

            }


        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return branchVo;


    }

}
