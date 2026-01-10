package logic;

import java.util.ArrayList;

public class Order {
	private ArrayList<OrderItem> orderItemList;
	private static int totalOrderCount = 0;
	private int orderNumber;
	
	public Order() {
		// TODO
		this.orderNumber = totalOrderCount;
		totalOrderCount += 1;
		this.orderItemList = new ArrayList<>();
	}

	public OrderItem addItem(Item item, int amount) {
		// TODO
		// Loop the orderItemList to find if item of any orderItem equals to the given item
		// if there is orderItem with given item, increase that orderItem itemAmount with amount
		// and return that orderItem

		// else create new orderItem with given item and amount, then return the new orderItem
		//OrderItem orderItem = new OrderItem(item, amount);

		if(amount < 0) {
			amount = 0;
		}

		for(OrderItem orderItem1 : orderItemList) {
			if(orderItem1.getItem().equals(item)) {
				orderItem1.setItemAmount(orderItem1.getItemAmount() + amount);
				return orderItem1;
			}
		}
		OrderItem orderItem = new OrderItem(item, amount);
		orderItemList.add(orderItem);
		return orderItem;
	}

	public int calculateOrderTotalPrice() {
		// TODO
		// Calculate total price of the order by summing total price of each orderItem in orderItemList
		int totalPrice = 0;
		for (OrderItem orderItem : orderItemList) {
			totalPrice += orderItem.calculateTotalPrice();
		}
		return totalPrice;
	}

	public static int getTotalOrderCount() {
		return totalOrderCount;
	}
	
	public static void resetTotalOrderCount() {
		totalOrderCount = 0;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public ArrayList<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	
	
}
