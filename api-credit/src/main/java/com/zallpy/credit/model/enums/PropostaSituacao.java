package com.zallpy.credit.model.enums;

import java.util.Arrays;

/**
 * Author : Damianos Sotirakis Enum: Proposta - Situacao
 *
 */

public enum PropostaSituacao {
	RECUSADO("Recusado"), 
	APROVADO("Aprovado");
	

	private String value;

	private PropostaSituacao(String value) {
			this.value = value;
		}
	public String getValue() {
		return this.value;
	}
	public static PropostaSituacao fromValue(String value) {
		for (PropostaSituacao situacao : values()) {
			if (situacao.value.equalsIgnoreCase(value)) {
				return situacao;
			}
		}
		throw new IllegalArgumentException(
				"Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
	}
}
