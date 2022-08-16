package br.com.alurafood.payments.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "payments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive
    private BigDecimal value;

    @NotBlank
    @Size(max=100)
    private String name;

    @NotBlank
    @Size(max=19)
    private String number;

    @NotBlank
    @Size(max=7)
    private String expires;

    @NotBlank
    @Size(min=3, max=3)
    private String code;

    @Enumerated
    private StatusEnum statusEnum;

    @NotNull
    private Long requestId;

    @NotNull
    private Long formOfPaymentId;
}
