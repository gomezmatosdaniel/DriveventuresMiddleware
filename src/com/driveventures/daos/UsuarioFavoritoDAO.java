package com.driveventures.daos;

import com.driveventures.model.UsuarioFavorito;

import DBCUtils.DataException;

public interface UsuarioFavoritoDAO {
	
	public UsuarioFavorito FindById(int idusuario, int idconductor) throws DataException;

	
	
	
}
