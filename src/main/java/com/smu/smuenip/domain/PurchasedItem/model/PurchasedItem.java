package com.smu.smuenip.domain.PurchasedItem.model;

import com.smu.smuenip.domain.Category.model.Category;
import com.smu.smuenip.domain.receipt.model.Receipt;
import com.smu.smuenip.domain.user.model.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class PurchasedItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchasedItemId;

    @JoinColumn(name = "user_id")
    @OneToOne
    private User user;

    @JoinColumn(name = "receipt_id")
    @ManyToOne
    private Receipt receipt;

    @Column
    private String itemName;

    @Column
    private int itemCount;

    @Column
    private int itemPrice;

    @JoinColumn(name = "category_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @Builder
    public PurchasedItem(User user, Receipt receipt, String itemName, int itemCount, int itemPrice,
        Category category) {
        this.user = user;
        this.receipt = receipt;
        this.itemName = itemName;
        this.itemCount = itemCount;
        this.itemPrice = itemPrice;
        this.category = category;
    }
}