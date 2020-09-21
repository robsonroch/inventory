package com.cbmer.inventory.services.validation.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface EscolheMethodTemplate<T> {

	default String returnFieldValue(T obj) {		
		List<Field> privateFields = Arrays.asList(obj.getClass().getDeclaredFields());
		
		String fieldValue = "sem valor";
		
		for (Field field : privateFields) {

			field.setAccessible(true);

			Object object;
			try {
				object = field.get(obj);
				if (object != null && field.isAnnotationPresent(FieldToSave.class)) {
					FieldToSave annotation = field.getAnnotation(FieldToSave.class);
					if (annotation != null && !annotation.value().isEmpty()) {
						fieldValue = annotation.value();
					} 
					
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				
			}

		}
		
		return fieldValue;
	}

}
