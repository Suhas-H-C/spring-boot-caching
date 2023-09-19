package com.prac.order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "PRAC_ORDER")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

    @Id
    private int orderId;
    private String orderNumber;
    private boolean orderStatus;
}
