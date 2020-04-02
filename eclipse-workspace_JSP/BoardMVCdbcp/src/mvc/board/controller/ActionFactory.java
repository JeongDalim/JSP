package mvc.board.controller;

import mvc.board.service.Action;
import mvc.board.service.BoardDeleteAction;
import mvc.board.service.BoardDelete_proAction;
import mvc.board.service.BoardEditAction;
import mvc.board.service.BoardEdit_proAction;
import mvc.board.service.BoardListAction;
import mvc.board.service.BoardSearchAction;
import mvc.board.service.BoardViewAction;
import mvc.board.service.BoardWriteAction;
import mvc.board.service.BoardWrite_proAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String cmd) {
		Action action = null;
		System.out.println("ActionFactory: " + cmd);
		// 조건처리
		if (cmd.equals("board_list")) {
			action = new BoardListAction();
		} else if (cmd.equals("board_view")) {
			action = new BoardViewAction();
		} else if (cmd.equals("board_write")) {
			action = new BoardWriteAction();
		} else if (cmd.equals("board_write_pro")) {
			action = new BoardWrite_proAction();
		} else if (cmd.equals("board_edit")) {
			action = new BoardEditAction();
		} else if (cmd.equals("board_edit_pro")) {
			action = new BoardEdit_proAction();
		} else if (cmd.equals("board_delete")) {
			action = new BoardDeleteAction();
		} else if (cmd.equals("board_delete_pro")) {
			action = new BoardDelete_proAction();
		}else if (cmd.equals("board_search")) {
			action = new BoardSearchAction();
		}
		return action;
	}
}
