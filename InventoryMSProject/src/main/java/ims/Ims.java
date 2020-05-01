package ims;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import ims.Controller.CrudActions;
import ims.Controller.CrudController;
import ims.Controller.CustomerController;
import ims.Entities.EntitySelection;
import ims.Services.CustomerServices;
import ims.Utilities.Utils;

public class Ims {

	public static final Logger LOGGER = Logger.getLogger(Ims.class);

	public void ImsSystem() {
		// OrdersMenu ordersMenu = new OrdersMenu();
		// InventoryMenu inventory = new InventoryMenu();

		LOGGER.info("What is your username");
		String username = Utils.getUserInput();
		LOGGER.info("What is your password");
		String password = Utils.getUserInput();

		init(username, password);

		LOGGER.info("Which entity would you like to use?");
		EntitySelection.printEntities();

		EntitySelection domain = EntitySelection.getEntitySelection();
		LOGGER.info("What would you like to do with " + domain.name().toLowerCase() + ":");

		CrudActions.printCrudActions();
		// CrudActions action = CrudActions.getAction();

		switch (domain) {
		case CUSTOMER:
			break;
		case ORDER:
			break;
		case INVENTORY:
			break;
		case STOP:
			break;
		default:
			break;
		}
	}

	public void doAction(CrudController<?> crudController, CrudActions action) {
		switch (action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;
		case RETURN:
			break;
		default:
			break;
		}

	}

	public void init(String username, String password) {
		init("jdbc:mysql://" + Utils.MYSQL, username, password, "src/main/resources/InventoryMS.Test.sql");
	}

	public String readFile(String fileLocation) {
		StringBuilder stringBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(fileLocation));) {
			String string;
			while ((string = br.readLine()) != null) {
				stringBuilder.append(string);
				stringBuilder.append("\r\n");
			}
		} catch (IOException e) {
			for (StackTraceElement ele : e.getStackTrace()) {
				LOGGER.debug(ele);
			}
			LOGGER.error(e.getMessage());
		}
		return stringBuilder.toString();
	}

//establish connectin to the database
	public void init(String jdbcConnectionUrl, String username, String password, String fileLocation) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				BufferedReader br = new BufferedReader(new FileReader(fileLocation));) {
			String string;
			while ((string = br.readLine()) != null) {
				try (Statement statement = connection.createStatement();) {
					statement.executeUpdate(string);
				}
			}
		} catch (SQLException | IOException e) {
			for (StackTraceElement ele : e.getStackTrace()) {
				LOGGER.debug(ele);
			}
			LOGGER.error(e.getMessage());
		}
	}
}
