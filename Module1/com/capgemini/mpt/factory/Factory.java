package com.capgemini.mpt.factory;

import com.capgemini.mpt.dao.DaoImpl;

public class Factory {

public static DaoImpl getDaoImpl()
{
	return new DaoImpl();
}


}
