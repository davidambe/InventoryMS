package ims.Controller;

import org.apache.log4j.Logger;

import ims.Utilities.Utils;

public enum CrudActions {
	CREATE("Create a new item in the database"), READ("Select an item to read from the database"),
	UPDATE("Update an item in the database"), DELETE("Delete an item from the database"), RETURN("Back to Menu");

	public static final Logger LOGGER = Logger.getLogger(CrudActions.class);

	private String description;

	private CrudActions() {
	}

	CrudActions(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.name() + ":" + this.description;
	}

	public static void printCrudActions() {
		for (CrudActions action : CrudActions.values()) {
			LOGGER.info(action.getDescription());
		}
	}

	public static CrudActions getAction() {
		CrudActions action;
		while (true) {
			try {
				action = CrudActions.valueOf(Utils.getUserInput().toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		}
		return action;
	}
}
