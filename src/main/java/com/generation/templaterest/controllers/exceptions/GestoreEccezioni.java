package com.generation.templaterest.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
//qui vengono catturate e gestite tutte le eccezioni che vengono
//throwate dai controllers rest
public class GestoreEccezioni
{

	@ExceptionHandler(MostroInesistenteException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String gestisciMostroInesistente(MostroInesistenteException e)
	{
		return e.getMessage();
	}

	@ExceptionHandler(TagliaNonEsistenteException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String gestisciTagliaInesistente(TagliaNonEsistenteException e)
	{
		return e.getMessage();
	}
}
