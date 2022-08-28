package br.com.alurafood.payments.service;

import br.com.alurafood.payments.dto.PaymentDto;
import br.com.alurafood.payments.model.Payment;
import br.com.alurafood.payments.model.StatusEnum;
import br.com.alurafood.payments.repository.PaymentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;

public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ModelMapper modelMapper;


    public Page<PaymentDto> getAll(Pageable paginacao) {
        return paymentRepository
                .findAll(paginacao)
                .map(p -> modelMapper.map(p, PaymentDto.class));
    }

    public PaymentDto getId(Long id) {
        Payment pagamento = paymentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(pagamento, PaymentDto.class);
    }

    public PaymentDto createPayment(PaymentDto paymentDto) {
        Payment pagamento = modelMapper.map(paymentDto, Payment.class);
        pagamento.setStatusEnum(StatusEnum.CREATED);
        paymentRepository.save(pagamento);

        return modelMapper.map(pagamento, PaymentDto.class);
    }

    public PaymentDto updatePayment(Long id, PaymentDto dto) {
        Payment pagamento = modelMapper.map(dto, Payment.class);
        pagamento.setId(id);
        pagamento = paymentRepository.save(pagamento);
        return modelMapper.map(pagamento, PaymentDto.class);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
    

}
