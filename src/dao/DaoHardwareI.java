package dao;

import java.util.List;

import entity.Hardware;

public interface DaoHardwareI 
{
	void adicionarHardware(Hardware h) throws DaoException;
	void removerHardware(Hardware h) throws DaoException;
	Hardware pesquisarHardware(String nome) throws DaoException;
	List<Hardware> getHardwares() throws DaoException;
}