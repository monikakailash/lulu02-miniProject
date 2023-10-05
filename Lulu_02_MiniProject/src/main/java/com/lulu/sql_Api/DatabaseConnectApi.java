package com.lulu.sql_Api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

//import com.mysql.cj.xdevapi.Statement;

public class DatabaseConnectApi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			 Class.forName("com.mysql.cj.jdbc.Driver");

	         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/prodlulu",

	             "root", "Mkailash2002");

	         java.sql.Statement statement;

	         statement = connection.createStatement();

	         ResultSet resultSet;

	         resultSet = statement.executeQuery(

	             "select * from product where prodname=\"phone\"");

	         int prodid;

	         String prodname;

	         String prodesc;
	         int prodcost;

	         while (resultSet.next()) {

	             prodid = resultSet.getInt("prodid");

	             prodname = resultSet.getString("prodname");

	             prodesc=resultSet.getString("prodesc");
	             prodcost = resultSet.getInt("prodcost");

	             System.out.println("prodid : " + prodid

	                                + " name : " + prodname + " description :"+ prodesc + "prodcost : " + prodcost);

	         }

			}catch(Exception E) {



			}

	}

	}