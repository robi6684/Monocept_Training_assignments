package com.monocept.streamassignment;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		@SuppressWarnings("unused")
		List<Region> regions = Arrays.asList(new Region(1, "Europe"), new Region(2, "Americas"),
				new Region(3, "Asia"),new Region(4, "Middle East and Africa"));
		
		List<Country> countries = Arrays.asList(new Country("IT", "Italy", 1), new Country("JP", "Japan", 3), 
				new Country("US", "United States of America", 2), new Country("CA", "Canada", 2),
				new Country("CN", "China", 3),new Country("IN", "India", 3),new Country("AU", "Australia", 3),
				new Country("ZW", "Zimbabwe",4),new Country("SG", "Singapore", 3),new Country("UK", "United Kingdom", 1),
				new Country("FR", "France", 1),new Country("DE", "Germany", 1),new Country("ZM", "Zambia", 4),
				new Country("EG", "Egypt", 4),new Country("BR", "Brazil", 2),new Country("CH", "Switzerland", 1),
				new Country("NL", "Netherlands", 1),new Country("MX", "Mexico", 2),new Country("KW", "Kuwait", 4),
				new Country("IL", "Israel", 4),new Country("DK", "Denmark", 1),new Country("HK", "HongKong", 3),
				new Country("NG", "Nigeria", 4),new Country("AR", "Argentina", 2),new Country("BE", "Belgium", 1));
		
		System.out.println("!--------Printing Countries Region Wise---------!");
		countries.stream().sorted((country1,country2) -> country1.getRegionId() - country2.getRegionId()).
		forEach((country) -> System.out.println(country));
		
		System.out.println("");
		System.out.println("Countries in Region 1");
		System.out.println(countries.stream().filter((country) -> country.getRegionId() == 1).count());
		
		System.out.println("Countries in Region 2");
		System.out.println(countries.stream().filter((country) -> country.getRegionId() == 2).count());
		
		System.out.println("Countries in Region 3");
		System.out.println(countries.stream().filter((country) -> country.getRegionId() == 3).count());
		
		System.out.println("Countries in Region 4");
		System.out.println(countries.stream().filter((country) -> country.getRegionId() == 4).count());
		
		System.out.println();
		System.out.println("Enter the region ID");
		int regionId = scanner.nextInt();
		
		System.out.println("Countries in this region :");
		countries.stream().filter((country) -> country.getRegionId() == regionId).
		forEach((country) -> System.out.println(country));;
		
		scanner.close();

	}

}
