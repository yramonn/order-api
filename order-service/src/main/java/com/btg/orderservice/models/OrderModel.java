package com.btg.orderservice.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "TB_ORDER")
public class OrderModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserModel user;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalValue = BigDecimal.ZERO;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemModel> itens = new ArrayList<>();

    public void calculateTotalValue() {
        this.totalValue = itens.stream()
                .map(item -> item.getValue()
                        .multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public List<ItemModel> getItens() {
        return itens;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public void setItens(List<ItemModel> itens) {
        this.itens = itens;
    }
}
