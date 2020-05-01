package ims.Entities;

import org.apache.log4j.Logger;

import ims.Utilities.Utils;

public enum EntitySelection {

	CUSTOMER("Access Customers Table"),
	ORDER("Access Orders Table"),
	INVENTORY("Access Inventory Table"),
	STOP("To close the application");
	
	public static final Logger LOGGER = Logger.getLogger(EntitySelection.class);

	private String description;
	
	private EntitySelection(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.name() + ": " +this.description;
	}
	
	public static void printEntities() {
		for (EntitySelection domain : EntitySelection.values()) {
			LOGGER.info(domain.getDescription());
		}
	}
	
	public static EntitySelection getEntitySelection() {
		EntitySelection domain;
		while (true) {
			try {
				domain = EntitySelection.valueOf(Utils.getUserInput().toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		}
		return domain;
	}

}
