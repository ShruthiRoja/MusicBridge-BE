package com.musicbridge.marketplace.removal;

import java.util.Set;
import java.util.UUID;

public interface ProductRemover {
    void deleteProduct(UUID productId);

    void deleteProducts(Set<UUID> productIds);
}
