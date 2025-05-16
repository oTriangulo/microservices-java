package br.edu.atitus.product_service.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.atitus.product_service.entities.ProductEntity;
import br.edu.atitus.product_service.repositories.ProductRepository;

@RestController
@RequestMapping("product")
public class OpenProductController {
	
	private final ProductRepository repository;

	public OpenProductController(ProductRepository repository) {
		super();
		this.repository = repository;
	}
	
	@Value("$server.port}")
	private int serverPort;
	
	@GetMapping("/{idProduct}/{targetCurrency}")
	public ResponseEntity<ProductEntity> getProductByIdAndCurrency(
			@PathVariable Long idProduct,
			@PathVariable String targetCurrency) {
		
		return repository.findById(idProduct)
			.map(product -> {

				product.setConvertedPrice(product.getPrice());
				return ResponseEntity.ok(product);
			})
			.orElse(ResponseEntity.notFound().build());
	}
	
}
