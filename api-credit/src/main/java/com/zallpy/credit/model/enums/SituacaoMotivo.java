/**
 * 
 */
package com.zallpy.credit.model.enums;

import java.util.Arrays;

/**
 * Author : Damianos Sotirakis Enum: Situação - Motivo
 *
 */

public enum SituacaoMotivo {

	APROVADO1("Limite pré-aprovado entre:"), 
	APROVADO2("Limite pré-aprovado superior:"),
	RECUSADO1("Reprovado pela politica de crédito"),
	RECUSADO2("Renda baixa"),
	RECUSADO3("Cpf em situação irregular");

	private String value;

	private SituacaoMotivo(String value) {
			this.value = value;
		}

	public static SituacaoMotivo fromValue(String value) {
		for (SituacaoMotivo motivo : values()) {
			if (motivo.value.equalsIgnoreCase(value)) {
				return motivo;
			}
		}
		throw new IllegalArgumentException(
				"Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
	}

}
