import java.util.ArrayList;

public class Search {
    public boolean searchProduct(String tenAo) {
        ArrayList<PRODUCT> productArrayList = new ArrayList<>();
        productArrayList.add(new PRODUCT("Áo thun", 200));
        productArrayList.add(new PRODUCT("Áo polo", 300));
        productArrayList.add(new PRODUCT("Áo sơ mi tay ngắn", 250));
        productArrayList.add(new PRODUCT("Áo sơ mi tay dài", 350));
        productArrayList.add(new PRODUCT("Quần ngắn", 400));
        productArrayList.add(new PRODUCT("Quần tây", 500));

        if (tenAo.isEmpty()) {
            return false;
        }
        for (int i = 0; i < productArrayList.size(); i++) {
            if (productArrayList.equals("Áo"))
                return true;
        }
        return false;
    }
}

