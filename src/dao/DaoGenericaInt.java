package dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DaoGenericaInt 
{
	public Connection getConnection() throws DaoException, SQLException;
}
