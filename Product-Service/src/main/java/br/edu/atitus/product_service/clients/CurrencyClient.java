package br.edu.atitus.product_service.clients;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(url = "http://localhost:8100", name = "currency-service"
				,fallback = CurrencyFallback.class)
public interface CurrencyClient {
	
	@GetMapping("/currency/{value}/{source}/{target}")
	CurrencyResponse getCurrency(
			@PathVariable double value,
			@PathVariable String source,
			@PathVariable String target
			);
	
}
