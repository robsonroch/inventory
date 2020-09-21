package com.cbmer.inventory.services.validation.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cbmer.inventory.domain.Categoria;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class GenericListSerializer extends StdSerializer<List<Categoria>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GenericListSerializer() {
		this(null);
	}

	public GenericListSerializer(Class<List<Categoria>> t) {
		super(t);
	}

	@Override
	public void serialize(List<Categoria> items, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		List<Categoria> categorias = new ArrayList<>();
		for (Categoria item : items) {
			
			categorias.add(new Categoria(item.getId(), item.getNome()));
		}
		generator.writeObject(categorias);
	}
}