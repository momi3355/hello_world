package com.yedam.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ClassExe {
	public static void main(String[] args) {
		try {
			Class<?> bookClass = Class.forName("com.yedam.bookapp.Book");
			
			/* [메소드] */
			System.out.println(bookClass.getSimpleName()+"의 메소드");
			Method[] bookMethods = bookClass.getDeclaredMethods();
			for (Method method : bookMethods) {
				System.out.print(method.getReturnType().getSimpleName()+" "+method.getName()+"( ");
				for (Parameter parameter : method.getParameters()) {
					System.out.print(parameter.getType().getSimpleName()+" ");
				}
				System.out.println(")");
			}

			/* [생성자] */
			System.out.println("\n"+bookClass.getSimpleName()+"의 생성자");
			Constructor<?>[] bookCons = bookClass.getDeclaredConstructors();
			for (Constructor<?> con : bookCons) {
				System.out.print(con.getName()+"( ");
				for (Parameter parameter : con.getParameters()) {
					System.out.print(parameter.getType().getSimpleName()+" ");
				}
				System.out.println(")");
			}

			/* [필드] */
			System.out.println("\n"+bookClass.getSimpleName()+"의 필드");
			Field[] bookField = bookClass.getDeclaredFields();
			for (Field field : bookField) {
				System.out.println(field.getType().getSimpleName()+" "+field.getName());
			}
			
			//※ Declared가 붙어진 메소드는 모든 것을 가지고 오고,
			// 그냥 get이면 'public'이 붙어진 것만 기자고 온다.
		} catch (ClassNotFoundException e) {
			System.out.println("해당 클래스를 찾을 수 없습니다.");
		}
	}
}
