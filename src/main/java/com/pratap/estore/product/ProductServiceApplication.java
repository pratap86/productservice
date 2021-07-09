package com.pratap.estore.product;

import com.pratap.estore.product.command.interceptors.CreateProductCommandInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	// register CreateProductCommandInterceptor, interceptor in to command bus through application context
	@Autowired
	public void registerCreateProductCommandInterceptor(ApplicationContext applicationContext, CommandBus commandBus){
		log.info("Executing registerCreateProductCommandInterceptor() to inject interceptor with applicationContext={} and commandBus={}", applicationContext, commandBus);
		commandBus.registerDispatchInterceptor(applicationContext.getBean(CreateProductCommandInterceptor.class));
	}
}
