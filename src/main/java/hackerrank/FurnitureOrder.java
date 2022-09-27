package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class FurnitureOrder implements FurnitureOrderInterface {

      Map<Furniture, Integer> furnitureTypeQuantities;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        furnitureTypeQuantities = new HashMap<>();
    }

    public void addToOrder(final Furniture type, int furnitureCount) {
        furnitureTypeQuantities.put(type, furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        return (HashMap<Furniture, Integer>) furnitureTypeQuantities;
    }

    public float getTotalOrderCost() {
        float cost;
        float totalCost = 0.0F;
        for (Map.Entry<Furniture,Integer>  furnitureIntegerEntry: furnitureTypeQuantities.entrySet()) {
            cost = Furniture.valueOf(furnitureIntegerEntry.getKey().name()).cost() * furnitureIntegerEntry.getValue();
            totalCost = cost + totalCost;
        }
        return totalCost;
    }

    public int getTypeCount(Furniture type) {
        return furnitureTypeQuantities.get(Furniture.valueOf(type.name())) != null ? furnitureTypeQuantities.get(Furniture.valueOf(type.name())): 0;
      }

    public float getTypeCost(Furniture type) {
        return furnitureTypeQuantities.get(type)!=null ? furnitureTypeQuantities.get(type)*Furniture.valueOf(type.name()).cost():0 * Furniture.valueOf(type.name()).cost();
    }

    public int getTotalOrderQuantity() {
        return furnitureTypeQuantities.values().stream().mapToInt(Integer::intValue).sum();
    }
}