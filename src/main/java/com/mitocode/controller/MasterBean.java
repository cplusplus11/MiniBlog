package com.mitocode.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.mitocode.model.Usuario;

@Named
@ViewScoped
public class MasterBean implements Serializable{
	
	FacesContext context = FacesContext.getCurrentInstance();
	
	public void verificarSesion() throws IOException {
		try {
			Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
			
			if(us == null) {
				context.getExternalContext().redirect("./../index.xhtml");
			
			}
			
		} catch (Exception e) {
			context.getExternalContext().redirect("./../index.xhtml");
		}
	}
	
	public void cerrarSesion() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
}
