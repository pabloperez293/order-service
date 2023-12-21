package controllers;

import dto.OrderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class OrderController {

    @GetMapping(value = "order")
    public ResponseEntity<List<OrderResponse>> findAll() {
        List<OrderResponse> orderList = new ArrayList();

        OrderResponse response = new OrderResponse();
        response.setAccountId("999123");
        response.setOrderId("11123");
        response.setStatus("PENDING");
        response.setTotalAmount(100.00);
        response.setTotalFax(5.00);
        response.setTransactionDate(new Date());

        OrderResponse response01 = new OrderResponse();
        response.setAccountId("999123");
        response.setOrderId("11312");
        response.setStatus("PENDING");
        response.setTotalAmount(10.00);
        response.setTotalFax(15.00);
        response.setTransactionDate(new Date());

        orderList.add(response);
        orderList.add(response01);

        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }
    @GetMapping(value = "order/{orderId}")
    public ResponseEntity<OrderResponse> findById(@PathVariable String orderId) {
        OrderResponse response = new OrderResponse();
        response.setAccountId("999123");
        response.setOrderId(orderId);
        response.setStatus("PENDING");
        response.setTotalAmount(100.00);
        response.setTotalFax(5.00);
        response.setTransactionDate(new Date());
// Para valores no encontrados
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "order/crate")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest payload) {
        //Esto envia al servidor de app, convertimos de la manera en esta ocacion como json
        OrderResponse response = new OrderResponse();
        response.setAccountId(payload.getAccountId());
        response.setOrderId("123456");
        response.setStatus("PENDING");
        response.setTotalAmount(100.00);
        response.setTotalFax(5.00);
        response.setTransactionDate(new Date());
// Para valores no encontrados
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
