package com.oguzhan.wallet.domain.wallet;


import com.oguzhan.wallet.domain.user.UserId;
import jakarta.persistence.*;

@Entity
@Table(name = "wallets")
public class Wallet {

    @EmbeddedId
    private WalletId id;


    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "user_id", nullable = false))
    private UserId userId;

    @Embedded
    private Money amount;


    protected Wallet() {

    }

    private Wallet(WalletId id, UserId userId, Money amount) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
    }

    public static Wallet create(Currency currency, UserId userId) {
        return new Wallet(WalletId.newId(), userId, Money.zero(currency));
    }

    public WalletId getId() {
        return id;
    }

    public UserId getUserId() {
        return userId;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money updatedBalance) {

        this.amount = updatedBalance;
    }
}
