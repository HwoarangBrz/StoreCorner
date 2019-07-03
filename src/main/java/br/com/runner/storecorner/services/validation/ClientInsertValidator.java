package br.com.runner.storecorner.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.runner.storecorner.domain.Client;
import br.com.runner.storecorner.domain.enums.ClientType;
import br.com.runner.storecorner.dto.NewClientDTO;
import br.com.runner.storecorner.repository.ClientRepository;
import br.com.runner.storecorner.resources.exception.FieldMessage;
import br.com.runner.storecorner.services.validation.utils.BR;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, NewClientDTO> {

	@Autowired
	private ClientRepository repo;
	
	@Override
	public void initialize(ClientInsert ann) {
	}

	@Override
	public boolean isValid(NewClientDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		if (objDto.getType().equals(ClientType.PHYSICALPERSON.getCod()) && !BR.isValidCPF(objDto.getDocument())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
		}

		if (objDto.getType().equals(ClientType.LEGALPERSON.getCod()) && !BR.isValidCNPJ(objDto.getDocument())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
		}

		Client aux = repo.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}

