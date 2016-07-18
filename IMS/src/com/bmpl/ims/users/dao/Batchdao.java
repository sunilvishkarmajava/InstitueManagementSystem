package com.bmpl.ims.users.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.bmpl.ims.common.dao.CommonDAO;
import com.bmpl.ims.common.dao.CommonSQLConstants;
import com.bmpl.ims.users.dto.BatchDTO;

public class Batchdao {

	public boolean addbatch(BatchDTO batchdto) throws SQLException, ClassNotFoundException
	{
		boolean isaddbatch=false;
		
		String sql  = CommonSQLConstants.ADDBATCH_SQL;
		Connection con = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;
		BatchDTO batchobject = null;
	
		 con= CommonDAO.getConnection();

		try{
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, batchdto.getBatchname());
		pstmt.setString(2, batchdto.getCoursename());
		pstmt.setString(3, batchdto.getTrainername());
		pstmt.setLong(4, batchdto.getTotalsets());
		pstmt.setString(5, batchdto.getDescription());
		pstmt.setString(6, batchdto.getBatchstartdate());
		int row = pstmt.executeUpdate();
		if(row>0)
		{
			isaddbatch=true;
		}
		}
		finally
		{
			con.close();
		}
		return isaddbatch;
	}
}
