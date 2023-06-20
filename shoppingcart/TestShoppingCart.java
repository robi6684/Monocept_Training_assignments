package com.monocept.shoppingcart;

import java.util.Arrays;
import java.util.List;

public class TestShoppingCart {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Product product1 = new Product(101,"Water Bottle",1000,10);
		Product product2 = new Product(102,"Bag",500,20);
		Product product3 = new Product(103,"Specs",3000,5);
		
		LineItem item1 = new LineItem(1,1,product1);
		LineItem item2 = new LineItem(2,3,product2);
		LineItem item3 = new LineItem(3,2,product3);
		
		List<LineItem> itemsList1 = Arrays.asList(item1,item2);
		List<LineItem> itemsList2 = Arrays.asList(item3);
		
		Order order1 = new Order(10001,"13/06/2023",itemsList1);
		Order order2 = new Order(10002,"19/06/2023",itemsList2);
		
		List<Order> orders = Arrays.asList(order1,order2);
		
		Customer customer = new Customer(11,"Ravi",orders);
		
		System.out.println("ID" + " " + "  Quantity" + " " + " Unit Price" + " " + "    Total Price");
		itemsList1.stream().forEach((item) -> System.out.println(item));
		double totalCost = 0;
		
		for(LineItem item : itemsList1) {
			totalCost += item.calculateLineItemCost();
		}
		System.out.println();
		System.out.println("Total Cost :" + totalCost);
	}

}
