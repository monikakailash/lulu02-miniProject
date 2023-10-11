
package com.lulu.DatabaseConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

//import com.mysql.cj.xdevapi.Statement;

public class DatabaseConnect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

				//Connect with MySQL

				//Connection, statement, ResultSet

				//Fetch records

				try {

					 Class.forName("com.mysql.cj.jdbc.Driver");

			         Connection connection = DriverManager.getConnection("",

			             "root", "");

			         java.sql.Statement statement;

			         statement = connection.createStatement();

			         ResultSet resultSet;

			         resultSet = statement.executeQuery(

			             "select * from product");

			         int proid;

			         String prodname;

			         String prodesc;
			         int prodcost;

			         while (resultSet.next()) {

			             proid = resultSet.getInt("prodid");

			             prodname = resultSet.getString("prodname");

			             prodesc=resultSet.getString("prodesc");
			             prodcost = resultSet.getInt("prodcost");
			             System.out.println("id : " + proid

			                                + " name : " + prodname + " description :"+ prodesc + "prodcost : " + prodcost);

			         }

		
					}catch(Exception E) {

		 

					}

	}

}

