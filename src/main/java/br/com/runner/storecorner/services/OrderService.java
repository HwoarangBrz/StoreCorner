package br.com.runner.storecorner.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.runner.storecorner.domain.Client;
import br.com.runner.storecorner.domain.Order;
import br.com.runner.storecorner.domain.OrderItem;
import br.com.runner.storecorner.domain.PaymentWithBankSlip;
import br.com.runner.storecorner.domain.enums.PaymentStatus;
import br.com.runner.storecorner.repository.OrderItemRepository;
import br.com.runner.storecorner.repository.OrderRepository;
import br.com.runner.storecorner.repository.PaymentRepository;
import br.com.runner.storecorner.security.UserSS;
import br.com.runner.storecorner.services.exceptions.AuthorizationException;
import br.com.runner.storecorner.services.exceptions.ObjectNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repo;
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ClientService clientService;
	
	//@Autowired
	//private EmailService emailService;
	
	public Order find(Integer id) {
		Optional<Order> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Order.class.getName()));
	}
	
	public Order insert(Order obj) {
		obj.setId(null);
		obj.setInstant(new Date());
		obj.setClient(clientService.find(obj.getClient().getId()));
		obj.getPayment().setSituation(PaymentStatus.PENDING);
		obj.getPayment().setOrder(obj);
		if (obj.getPayment() instanceof PaymentWithBankSlip) {
			PaymentWithBankSlip pagto = (PaymentWithBankSlip) obj.getPayment();
			ticketService.fillPaymentWithBankSlip(pagto, obj.getInstant());
		}
		obj = repo.save(obj);
		paymentRepository.save(obj.getPayment());
		for (OrderItem ip : obj.getItems()) {
			ip.setDiscount(0.0);
			ip.setProduct(productService.find(ip.getProduct().getId()));
			ip.setPrice(ip.getProduct().getPrice());
			ip.setOrder(obj);
		}
		orderItemRepository.saveAll(obj.getItems());
		//emailService.sendOrderConfirmationEmail(obj);
		return obj;
	}
	
	public Page<Order> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Client client =  clientService.find(user.getId());
		return repo.findByClient(client, pageRequest);
	}
}
