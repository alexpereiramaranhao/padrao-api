package com.algaworks.algafood.api.exceptionhandler;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;

@JsonInclude(Include.NON_NULL)
@Getter
@Builder
public class Problema {

	private Integer status;
	private LocalDateTime timestamp;
	private String tipo;
	private String titulo;
	private String detalhe;
	private String userMessage;
	
}