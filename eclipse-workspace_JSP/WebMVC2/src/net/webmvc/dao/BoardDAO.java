package net.webmvc.dao;

public class BoardDAO {
	private BoardDAO() {
	}

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}
}
