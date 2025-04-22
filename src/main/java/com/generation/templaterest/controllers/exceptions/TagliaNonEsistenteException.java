package com.generation.templaterest.controllers.exceptions;

public class TagliaNonEsistenteException extends RuntimeException
{
	public TagliaNonEsistenteException(String message)
	{
		super(message);
	}
}
