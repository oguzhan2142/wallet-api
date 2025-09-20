package com.oguzhan.wallet.domain.transaction;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;


@Embeddable
public record TransactionId(@Column(name = "id") UUID value) {

}
