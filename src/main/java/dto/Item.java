package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {

    private String code;
    private String description;
    private Double unitePrice;
    private int qtyOnHand;
}
