package com.mitocode.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;

@Named
@ViewScoped
public class PersonaBean implements Serializable {

	@Inject
	private IPersonaService service;
	private Persona persona;
	private List<Persona> lista;
	private String tipoDialog;
	//private UploadedFile foto;

	/*
	 * public PersonaBean() { this.persona = new Persona(); //this.service = new
	 * PersonaServiceImpl(); //this.listar(); }
	 */

	@PostConstruct
	public void init() {
		this.persona = new Persona();
		this.listar();
		
	}

	/*public void handleFileUpload(FileUploadEvent event) {
		try {
			if (event.getFile() != null) {
				this.persona.setFoto(event.getFile().getContents());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	*/
	
	public void mostrarData(Persona p) {
		this.persona = p;
		this.tipoDialog = "Modificar";
		
	}
	
	public void limpiarControles() {
		this.persona = new Persona();
		this.tipoDialog = "Nuevo";
	}
	
	public void handleFileUpload(FileUploadEvent event) {
		
		
		//if(accion.equalsIgnoreCase("R")) {
			try {
				if( event.getFile() !=null) {
					this.persona.setFoto(event.getFile().getContents());
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//} else if(accion.equalsIgnoreCase("M")) {
		//	this.service.modificar(this.persona);
		//}
    }
	
	public void operar(String accion) {
		try {
			
			if(accion.equalsIgnoreCase("R")) {
				this.service.registrar(this.persona);
			} else if(accion.equalsIgnoreCase("M")) {
				this.service.modificar(this.persona);
			}
			
			this.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listar() {
		try {
			this.lista = this.service.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	/**
	 * 
	 * getters & setters
	 */

	public Persona getPersona() {
		return persona;
	}

	public List<Persona> getLista() {
		return lista;
	}

	public void setLista(List<Persona> lista) {
		this.lista = lista;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getTipoDialog() {
		return tipoDialog;
	}

	public void setTipoDialog(String tipoDialog) {
		this.tipoDialog = tipoDialog;
	}


	

}
