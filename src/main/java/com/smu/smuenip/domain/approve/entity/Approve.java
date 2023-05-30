package com.smu.smuenip.domain.approve.entity;

import com.smu.smuenip.domain.recycledImage.RecycledImage;
import com.smu.smuenip.domain.user.model.User;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Entity
@NoArgsConstructor
public class Approve {

    @Id
    @Column(name = "approve_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "recycled_image_id")
    private RecycledImage recycledImage;

    @OneToOne
    @JoinColumn(name = "admin_id")
    private User admin;

    @Column(name = "is_approved")
    private boolean isApproved;

    @CreationTimestamp
    @Column(name = "approved_date")
    private LocalDateTime approvedDate;

    public Approve(RecycledImage recycledImage, User admin, boolean isApproved) {
        this.recycledImage = recycledImage;
        this.admin = admin;
        this.isApproved = isApproved;

        User user = recycledImage.getPurchasedItem().getUser();
        user.incrementScore();
    }

    public void setApproved(boolean approved) {

        User user = recycledImage.getPurchasedItem().getUser();

        if (approved) {
            user.incrementScore();
            isApproved = true;
            return;
        }
        
        user.decrementScore();
        isApproved = false;
    }
}
