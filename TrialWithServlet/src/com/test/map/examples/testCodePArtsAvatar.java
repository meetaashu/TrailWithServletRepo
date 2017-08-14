package com.test.map.examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.test.map.examples.myCode.Address;
import com.test.map.examples.myCode.Warehouse;

public class testCodePArtsAvatar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public enum Warehouse {
	    EDMONTON, MONTREAL, TORONTO, VANCOUVER
	}
	
	
	public static List<Warehouse> getNearestWarehouses(Address address) {
        switch (address.getCity()) {
            case "Toronto":
                return Arrays.asList(Warehouse.TORONTO, Warehouse.MONTREAL, Warehouse.EDMONTON, Warehouse.VANCOUVER);
            case "Vancouver":
                return Arrays.asList(Warehouse.VANCOUVER, Warehouse.EDMONTON, Warehouse.TORONTO, Warehouse.MONTREAL);
            case "Montreal":
                return Arrays.asList(Warehouse.MONTREAL, Warehouse.TORONTO, Warehouse.EDMONTON, Warehouse.VANCOUVER);
            case "Edmonton":
                return Arrays.asList(Warehouse.EDMONTON, Warehouse.VANCOUVER, Warehouse.TORONTO, Warehouse.MONTREAL);
            default:
                return Arrays.asList();
        }
    }
	public static Map<Warehouse, Integer> getInventory(String product) {
        Map<Warehouse, Integer> inventoryMap = new HashMap<>();
        switch (product) {
            case "Product1": {
                inventoryMap.put(Warehouse.TORONTO, 10);
                inventoryMap.put(Warehouse.VANCOUVER, 32);
                inventoryMap.put(Warehouse.MONTREAL, 32);
                inventoryMap.put(Warehouse.EDMONTON,52);
                break;
            }
            case "Product2": {
                inventoryMap.put(Warehouse.TORONTO, 0);
                inventoryMap.put(Warehouse.VANCOUVER, 10);
                inventoryMap.put(Warehouse.MONTREAL, 0);
                inventoryMap.put(Warehouse.EDMONTON, 10);
                break;
            }
            case "Product3": {
                inventoryMap.put(Warehouse.TORONTO, 25);
                inventoryMap.put(Warehouse.VANCOUVER,15);
                inventoryMap.put(Warehouse.MONTREAL, 16);
                inventoryMap.put(Warehouse.EDMONTON, 72);
                break;
            }
            case "Product4": {
                inventoryMap.put(Warehouse.TORONTO, 31);
                inventoryMap.put(Warehouse.VANCOUVER,11);
                inventoryMap.put(Warehouse.MONTREAL, 4);
                inventoryMap.put(Warehouse.EDMONTON, 6);
                break;
            }
            case "Product5": {
                inventoryMap.put(Warehouse.TORONTO, 55);
                inventoryMap.put(Warehouse.VANCOUVER, 36);
                inventoryMap.put(Warehouse.MONTREAL, 74);
                inventoryMap.put(Warehouse.EDMONTON, 11);
                break;
            }
        }
        return inventoryMap;
    }

public Map<String, Map<Warehouse,Integer>> getInventoryAllocation(Map<String, Integer> shoppingCart, Address addressOfCustomer) {
	//creating map of final result
	Map<String, Map<Warehouse, Integer>> resultMap = new HashMap<String, Map<Warehouse, Integer>>();
	
	//Find the list of warehouse nearest to customer
			List<Warehouse> warehouseList=getNearestWarehouses(addressOfCustomer);
			//Warehouse warehouse=warehouseList.get(0);
			
	//Find the product id added in cart
	Set<String> pId=shoppingCart.keySet();
	for(String productId:pId){
		//Find the qty required against this product id
		int noOfProductsRequired=shoppingCart.get(productId);
		
		
		Map<Warehouse,Integer> resultOfWarehouseAndNoOfProduct =new HashMap<Warehouse,Integer>();
		
		Map<Warehouse,Integer>	warehouseQuantityDetailOfProduct=getInventory(productId);
		
		for(Warehouse warehouse:warehouseList){
		int noOfProducts=warehouseQuantityDetailOfProduct.get(warehouse);		
		if(noOfProducts>=noOfProductsRequired && noOfProductsRequired>0){
			noOfProductsRequired=(noOfProductsRequired)-(noOfProducts);
			resultOfWarehouseAndNoOfProduct.put(warehouse, noOfProducts);
			//resultMap.put(productId, resultOfWarehouseAndNoOfProduct);
			break;
		}else if(noOfProducts<noOfProductsRequired && noOfProductsRequired>0){
			 noOfProductsRequired=(noOfProductsRequired)-(noOfProducts);
			resultOfWarehouseAndNoOfProduct.put(warehouse, noOfProducts);
		}
		}
		resultMap.put(productId, resultOfWarehouseAndNoOfProduct);
	}
	return resultMap;
}
	


	public class Address {
        private final String city;

        public Address(String city) {
            this.city = city;
        }

        public String getCity() {
            return city;
        }
    }

}
