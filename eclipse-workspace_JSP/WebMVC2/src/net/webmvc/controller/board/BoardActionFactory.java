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
		}
		return action;
	}
}
