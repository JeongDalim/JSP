package net.webmvc.controller.admin;

import net.webmvc.action.Action;

public class AdminActionFactory {
	private static AdminActionFactory instance = new AdminActionFactory();

	private AdminActionFactory() {
		super();
	}

	public static AdminActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String cmd) {
		Action action = null;
		if (cmd.equals("admin_login")) {
			action = new Admin_loginAction();
		} else if (cmd.equals("admin_main")) {
			action = new Admin_mainAction();
		}
		return action;
	}
}
