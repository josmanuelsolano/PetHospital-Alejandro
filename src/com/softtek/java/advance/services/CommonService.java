package com.softtek.java.advance.services;

import java.util.List;

public final class CommonService {
	
	static void printList(List<?> list){
		for (Object object : list) {
			System.out.println(object);
		}
	}
}
