package net.webmvc.dao;

public class PdsDAO {
	private PdsDAO() {
	}

	private static PdsDAO instance = new PdsDAO();

	public static PdsDAO getInstance() {
		return instance;
	}
}
