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
		}
		return action;
	}
}
