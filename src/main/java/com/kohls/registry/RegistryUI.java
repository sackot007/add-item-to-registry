package com.kohls.registry;

import java.util.UUID;

public class RegistryUI {

	private String registryId;
	private UUID id = UUID.randomUUID();

	private String description;
	private float price;

	public String getRegistryId() {
		return registryId;
	}

	public void setRegistryId(String registryId) {
		this.registryId = registryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public UUID getId() {
		return id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegistryUI [registryId=").append(registryId)
				.append(", id=").append(id).append(", description=")
				.append(description).append(", price=").append(price)
				.append("]");
		return builder.toString();
	}

}
