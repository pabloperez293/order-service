package dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class OrderResponse {
    private String orderId;
    private String status;
    private String accountId;
    private Double totalAmount;
    private Double TotalFax;
    private Date transactionDate;

}
