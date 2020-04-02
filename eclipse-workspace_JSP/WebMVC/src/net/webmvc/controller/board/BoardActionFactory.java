package net.webmvc.controller.board;

import net.webmvc.action.Action;

public class BoardActionFactory {
	private static BoardActionFactory instance = new BoardActionFactory();

	private BoardActionFactory() {
		super();
	}

	public static BoardActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String cmd) {
		Action action = null;
		if (cmd.equals("board_list")) {
			action = new Board_listAction();
		} else if (cmd.equals("board_view")) {
			action = new Board_ViewAction();
		} else if (cmd.equals("board_delete")) {
			action = new Board_DeleteAction();
		} else if (cmd.equals("board_write")) {
			action = new Board_WriteAction();
		} else if (cmd.equals("board_write_pro")) {
			action = new Board_Write_ProAction();
		} else if (cmd.equals("board_modify")) {
			action = new Board_ModifyAction();
		} else if (cmd.equals("board_modify_pro")) {
			action = new Board_Modify_ProAction();
		} else if (cmd.equals("board_search")) {
			action = new BoardSearchAction();
		}
		return action;
	}
}
