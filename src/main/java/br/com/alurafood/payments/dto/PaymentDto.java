package br.com.alurafood.payments.dto;

import br.com.alurafood.payments.model.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PaymentDto {

    private Long id;
    private BigDecimal valor;
    private String nome;
    private String numero;
    private String expiracao;
    private String codigo;
    private StatusEnum status;
    private Long formaDePagamentoId;
    private Long pedidoId;

    public PaymentDto() {
    }
}
