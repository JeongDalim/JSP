package net.webmvc.controller.pds;

import net.webmvc.action.Action;

public class PdsActionFactory {
	private static PdsActionFactory instance = new PdsActionFactory();

	private PdsActionFactory() {
		super();
	}

	public static PdsActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String cmd) {
		Action action = null;
		if (cmd.equals("pds_list")) {
			action = new Pds_listAction();
		} else if (cmd.equals("pds_view")) {
			action = new Pds_ViewAction();
		} else if (cmd.equals("pds_delete")) {
			action = new Pds_DeleteAction();
		} else if (cmd.equals("pds_write")) {
			action = new Pds_WriteAction();
		} else if (cmd.equals("pds_write_pro")) {
			action = new Pds_Write_ProAction();
		} else if (cmd.equals("pds_modify")) {
			action = new Pds_ModifyAction();
		} else if (cmd.equals("pds_modify_pro")) {
			action = new Pds_Modify_ProAction();
		} else if (cmd.equals("pds_search")) {
			action = new Pds_SearchAction();
		} else if (cmd.equals("pds_download")) {
			action = new Pds_DownloadAction();
		}

		return action;
	}
}
