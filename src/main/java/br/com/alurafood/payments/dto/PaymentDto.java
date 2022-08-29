package br.com.alurafood.payments.dto;

import br.com.alurafood.payments.model.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PaymentDto {

    private Long id;
    private BigDecimal value;
    private String name;
    private String number;
    private String expires;
    private String code;
    private StatusEnum status;
    private Long formOfPaymentId;
    private Long requestId;

    public PaymentDto() {
    }
}
