package SQLConn;

import java.sql.Connection;

public class SQLRunner {

	public static void main(String[] args) {
		// CREATE SWITCH CASE STATEMENT
		// VALIDATE INPUT //TRY CATCH FOR ERRORS
		SQLConnection customer = new SQLConnection();
		SQLConnection orders = new SQLConnection();
		SQLConnection inventory = new SQLConnection();
		Connection conn = orders.getConnection();
		
		customer cm1 = new customer();
		orders or1 = new orders();
		inventory iv1 = new inventory();
		
		//Switch case
		

		// Customer CRUD
		// CREATE
		cm1.createCustomer(conn, "James", "Bond", "jamesbond@aol.com", "41 Princton Road", "PR41 PD14",
				"United Kingdom", "customers");
		// READ
		// UPDATE

		// Orders CRUD

		// Inventory CRUD

	}
}
