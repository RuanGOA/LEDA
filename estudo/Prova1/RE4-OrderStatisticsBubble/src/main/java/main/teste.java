package main;

import orderStatistic.OrderStatistics;
import orderStatistic.OrderStatisticsSelectionImpl;

public class teste {

	public static void main(String[] args) {
		Integer[] array = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8};
		
		OrderStatistics order = new OrderStatisticsSelectionImpl();
		
		System.out.println(order.getOrderStatistics(array, 2));
	}
	
}
