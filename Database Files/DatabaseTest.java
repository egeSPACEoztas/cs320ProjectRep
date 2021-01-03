import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    @Test
    void DBupdatePrice() {
        Database.DBupdatePrice(1,10);
        double alinan_deger = Database.getPrice(1);
        assertEquals(10,alinan_deger);
    }

    @Test
    void DBaddProduct() {
       int pnum = Database.getProductNum();
       Database.DBaddProduct(100,12,"newBranch",1000,"product_name");
        int newpnum = Database.getProductNum();
       assertEquals(pnum +1,newpnum);
    }

    @Test
    void DBdecrementQuantity() {
        int quantity = Database.getQuantity(3);
        Database.DBdecrementQuantity(1,5);
        int newquantity = Database.getQuantity(3);
        assertEquals(quantity-5,newquantity);
    }

    @Test
    void DBincrementQuantity() {
        int quantity = Database.getQuantity(2);
        Database.DBincrementQuantity(1,5);
        int newquantity = Database.getQuantity(2);
        assertEquals(quantity+5,newquantity);
    }

    @Test
    void removeFromDB() {
        int pnum = Database.getProductNum();
        Database.removeFromDB(1);
        int newpnum = Database.getProductNum();
        assertEquals(pnum-1,newpnum);
    }

}