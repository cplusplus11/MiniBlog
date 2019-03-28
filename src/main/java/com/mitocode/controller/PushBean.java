package com.mitocode.controller;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class PushBean implements Serializable{

	/* error injection aqui */
	
	@Inject @Push(channel = "notify")
	private static PushContext push; 
	
	public static void sendMessage() {
		push.send("//////////////////////////////// THIS IS A MESSAGE //////////////////////");
	}
	
	/* error injection hasta aqui */
}
	

	
	
