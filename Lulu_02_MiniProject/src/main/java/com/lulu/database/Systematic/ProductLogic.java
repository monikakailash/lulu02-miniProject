package com.lulu.database.Systematic;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import com.lulu.database.Systematic.*;
	import com.mysql.cj.jdbc.CallableStatement;
	public class ProductLogic {
	void createData() throws SQLException {
		Connection connection = ConnectDB.setupConnection();
		String query ="INSERT INTO product( proid, prodname, prodesc, prodcost ) VALUES( ?, ?,?,?)";
//		String query = "insert values into employee(? ,? ,?)  ";
		PreparedStatement myStmt = connection.prepareStatement(query);
		myStmt.setInt(1, 444);
		myStmt.setString(2, "earphones");
		myStmt.setString(3, "boat");
		myStmt.setInt(4, 600);
		int success = myStmt.executeUpdate();
		System.out.println("Added Successfully " + success);

		}
	
		void readData() throws SQLException {
			Connection connection=ConnectDB.setupConnection();

	 

			 Statement statement;
			 statement = connection.createStatement();
	        ResultSet resultSet;
	        resultSet = statement.executeQuery(
	            "select * from product where proid>=111");
	        int proid;
	        String prodname;
	        String prodesc;
	        int prodcost;
	        
	        while (resultSet.next()) {
	        	proid = resultSet.getInt("proid");
	        	prodname = resultSet.getString("prodname");
	        	prodesc=resultSet.getString("prodesc");
	        	prodcost=resultSet.getInt("prodcost");
	            
	            System.out.println("proid : " + proid
	                               + " prodname : " + prodname +"  description:"+ prodesc + "prodcost : " + prodcost);
	        }
	}
	
		  void updateData() throws SQLException {
			Connection connection = ConnectDB.setupConnection();
			String query = "update product set prodname= ? where proid = ? ";
			PreparedStatement myStmt = connection.prepareStatement(query);
			myStmt.setString(1, "Bulb");
			myStmt.setInt(2, 333);
			boolean success = myStmt.execute();
			System.out.println("Updated Successfully " + success);

		}
		  /*
	
		  void deleteData() throws SQLException {
			Connection connection = ConnectDB.setupConnection();
			String query = "delete from product where proid = ? ";
			PreparedStatement myStmt = connection.prepareStatement(query);
			myStmt.setInt(1, 222);
			boolean success = myStmt.execute();
			System.out.println("Deleted Successfully " + success);

		}
		  void batchProcess() throws SQLException {
			Connection connection = ConnectDB.setupConnection();

	 

	 

			Statement stmt = connection.createStatement();

	 

				stmt.addBatch("insert into product values(888 ,'Charger','ctype', 700)");
				stmt.addBatch("insert into product values(999 ,'bag','hand-bag', 2000)");
				stmt.addBatch("insert into product values(1001 ,'shoes','puma', 5000)");

	 

				stmt.executeBatch();//executing the batch
				System.out.println("Batch executed successfully!");

	 

//				Submits a batch of commands to the database for execution and if all 
//				commands execute successfully, returns an array of update counts.

	 

		}
		  
		  void tryBatchMore() throws SQLException {
				Connection connection = ConnectDB.setupConnection();
				String SQL = "INSERT INTO product (proid, prodname, prodesc, prodcost) " +
			             "VALUES(?, ?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(SQL);
			//Set auto-commit to false
			connection.setAutoCommit(false);
			// Set the variables
			pstmt.setInt( 1, 400 );
			pstmt.setString( 2, "book" );
			pstmt.setString( 3, "classmate" );
			pstmt.setInt( 4, 40);
			//pstmt.setInt( 4, 33 );
			// Add it to the batch
			pstmt.addBatch();
			// Set the variables
			pstmt.setInt( 1, 401 );
			pstmt.setString( 2, "perfume" );
			pstmt.setString( 3, "Zudio perfume" );
			pstmt.setInt( 4, 90 );
			// Add it to the batch
			pstmt.addBatch();
			//add more batches

			//Create an int[] to hold returned values
			int[] count = pstmt.executeBatch();

		 

			//Explicitly commit statements to apply changes
			connection.commit();
			}
		  
		  void StoredProceduresMore() throws SQLException {

				Connection connection = ConnectDB.setupConnection();
				String query="call pull_product ()";
				java.sql.CallableStatement stmt = connection.prepareCall(query);
				//The interface used to execute SQL stored procedures
				ResultSet resultSet = stmt.executeQuery(query);
				//to display result sets//

				int proid;
				String prodname;
				String prodesc;
				int prodcost;

				while (resultSet.next()) {
					proid = resultSet.getInt("proid");
					prodname = resultSet.getString("prodname");
					prodesc = resultSet.getString("prodesc");
					prodcost=resultSet.getInt("prodcost");
					
					
					System.out.println("prodid : " + proid + " prodname : " + prodname + "  prodesc:" + prodesc + "prodcost :" + prodcost);
				}

	 
		  }
		 
		  void TransactionsConcepts() throws SQLException {
				Connection connection = ConnectDB.setupConnection();
				String query = "INSERT INTO product ( proid, prodname, prodesc, prodcost ) VALUES( ?, ?,?, ?)";
//				String query = "insert values into employee(? ,? ,?)  ";
				PreparedStatement myStmt = connection.prepareStatement(query);
				connection.setAutoCommit(false);  //By default its always true 
				myStmt.setInt(1, 504);
				myStmt.setString(2, "toothpaste");
				myStmt.setString(3, "colgate");
				myStmt.setInt(4, 50);

		 

				int success = myStmt.executeUpdate();
				connection.commit();
				//Makes all changes made since the previouscommit/rollback permanent and releases any database lockscurrently held by this Connection object.
				//This method should beused only when auto-commit mode has been disabled.
				connection.rollback();
				//Undoes all changes made in the current transactionand releases any database locks currently heldby this Connection object.
				//This method should beused only when auto-commit mode has been disabled.
				System.out.println("Added Successfully " + success);
			}
		  */
	}
	

