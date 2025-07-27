import java.time.LocalDateTime;
import java.util.*;

public class Purchase {
    String billId;
    LocalDateTime dateTime;
    Map<String, Integer> items; // productId -> quantity
    double totalAmount;

    public Purchase(String billId, Map<String, Integer> items, double totalAmount) {
        this.billId = billId;
        this.items = items;
        this.totalAmount = totalAmount;
        this.dateTime = LocalDateTime.now();
    }
}
