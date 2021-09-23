package com.lotus.jewel.sample.annotation.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

import com.lotus.jewel.sample.annotation.MethodAnnotation;
import com.lotus.jewel.sample.annotation.StringInjector;
import com.lotus.jewel.sample.annotation.TypeAnnotation;

public class TestMain {
	public static void main(String[] args) {
		System.out.println("----- Class Test -----");
		TypeTest typeTest = new TypeTest();
		typeTest.setMessage(new Date().toString());
		printTypeTest(typeTest);
		
		System.out.println("----- Method Test -----");
		MethodTest methodTest = new MethodTest();
		methodTest.setMessage(new Date().toString());
		try {
			printMethodTest(methodTest);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		
		System.out.println("----- Field Test -----");
		FieldTest fieldTest = new FieldTest();
		try {
			printFieldTest(fieldTest);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		System.out.println("- cobra : " + fieldTest.getCobra());
		System.out.println("- defaultValue : " + fieldTest.getDefaultValue());
		
	}

	public static void printTypeTest(TypeTest typeTest) {
		System.out.println("message : " + typeTest.getMessage());

		Annotation[] annotations = TypeTest.class.getDeclaredAnnotations();
		for (Annotation annotation : annotations) {
			if(annotation instanceof TypeAnnotation) {
				TypeAnnotation myTypeAnnotation = (TypeAnnotation)annotation;
				System.out.println("name : " + myTypeAnnotation.name());
				System.out.println("value : " + myTypeAnnotation.value());
			}
		}
	}
	
	public static void printMethodTest(MethodTest methodTest) throws NoSuchMethodException {
		System.out.println("message : " + methodTest.getMessage());
		
		Method method = MethodTest.class.getMethod("doThis");
		Annotation[] annotations = method.getDeclaredAnnotations();
		
		for (Annotation annotation : annotations) {
			if(annotation instanceof MethodAnnotation) {
				MethodAnnotation myMethodAnnotation = (MethodAnnotation)annotation;
				System.out.println("name : " + myMethodAnnotation.name());
				System.out.println("value : " + myMethodAnnotation.value());
				
			}
		}
		
		Annotation annotation = MethodTest.class.getMethod("doThat").getAnnotation(MethodAnnotation.class);
		if(annotation instanceof MethodAnnotation) {
			MethodAnnotation myMethodAnnotation = (MethodAnnotation)annotation;
			System.out.println("name : " + myMethodAnnotation.name());
			System.out.println("value : " + myMethodAnnotation.value());
		}
		
	}
	
	public static <T> void printFieldTest(T fieldTest) throws IllegalAccessException {
		Field [] fields = fieldTest.getClass().getDeclaredFields();
		for (Field field : fields) {
			StringInjector stringInjector = field.getAnnotation(StringInjector.class);
			if(stringInjector != null && field.getType() == String.class) {
				System.out.println("value : " + stringInjector.value());
				field.setAccessible(true);
				field.set(fieldTest, stringInjector.value());
			}
		}
	}
	
}
