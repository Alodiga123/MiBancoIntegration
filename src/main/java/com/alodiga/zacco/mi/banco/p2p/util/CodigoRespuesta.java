package com.alodiga.zacco.mi.banco.p2p.util;

public enum CodigoRespuesta {
	EXITO ("00"),	
	ERROR_INTERNO("99");
	
	private String codigo; 
	
	private CodigoRespuesta(String codigo){
		this.codigo = codigo;
	}
	
	public String getCodigo(){
		return codigo;
	}

}
