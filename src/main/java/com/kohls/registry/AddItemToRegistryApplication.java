package com.kohls.registry;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kohls.registry.dao.CreateRegistryDao;
import com.kohls.registry.dao.CreateRegistryItemDao;
import com.kohls.registry.dao.Registry;
import com.kohls.registry.dao.RegistryItem;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories("com.kohls.registry.dao")
public class AddItemToRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddItemToRegistryApplication.class, args);
	}
}

@RestController
class AddToRegistryController {

	@Autowired
	private CreateRegistryItemDao dao;

	@Autowired
	private CreateRegistryDao rDao;

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void findRegistry(@RequestBody RegistryUI ui) {
		Registry r = rDao.findOne(ui.getRegistryId());
		RegistryItem ri = new RegistryItem();
		ri.setRegistry(r);
		ri.setDescription(ui.getDescription());
		ri.setPrice(ui.getPrice());
		ri.setId(ui.getId().toString());

		dao.save(ri);
	}
}