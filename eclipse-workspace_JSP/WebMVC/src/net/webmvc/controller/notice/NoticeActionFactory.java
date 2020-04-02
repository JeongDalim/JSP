package net.webmvc.controller.notice;

import net.webmvc.action.Action;



public class NoticeActionFactory {
	private static NoticeActionFactory instance = new NoticeActionFactory();

	private NoticeActionFactory() {
		super();
	}

	public static NoticeActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String cmd) {
		Action action = null;
		if (cmd.equals("notice_list")) {
			action = new Notice_listAction();
		} else if (cmd.equals("notice_view")) {
			action = new Notice_ViewAction();
		} else if (cmd.equals("notice_delete")) {
			action = new Notice_DeleteAction();
		} else if (cmd.equals("notice_write")) {
			action = new Notice_WriteAction();
		} else if (cmd.equals("notice_write_pro")) {
			action = new Notice_Write_ProAction();
		} else if (cmd.equals("notice_modify")) {
			action = new Notice_ModifyAction();
		} else if (cmd.equals("notice_modify_pro")) {
			action = new Notice_Modify_ProAction();
		}else if (cmd.equals("notice_search")) {
			action = new Notice_SearchAction();
		}
		return action;
	}
}
