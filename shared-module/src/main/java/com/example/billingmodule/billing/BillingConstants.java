/*
 * Copyright 2017 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.billingmodule.billing;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClient.SkuType;
import java.util.Arrays;
import java.util.List;

/**
 * Static fields and methods useful for billing
 */
public final class BillingConstants {

    public static final String SKU_FAKE_PURCHASED = "android.test.purchased";
    public static final String SKU_FAKE_CANCELLED = "android.test.canceled";
    public static final String SKU_FAKE_REFUNDED = "android.test.refunded";
    public static final String SKU_FAKE_UNAVAILABLE = "android.test.item_unavailable";

    // SKUs for our products: the premium upgrade (non-consumable) and gas (consumable)
    public static final String SKU_PREMIUM = "premium";
    public static final String SKU_GAS = "gas";
    public static final String SKU_GAS = "gas";

    // SKU for our subscription (infinite gas)
    public static final String SKU_GOLD_MONTHLY = "gold_monthly";
    public static final String SKU_GOLD_YEARLY = "gold_yearly";

    private static final String[] STATIC_IN_APP_SKUS = {
            SKU_FAKE_PURCHASED,
            SKU_FAKE_CANCELLED,
            SKU_FAKE_REFUNDED,
            SKU_FAKE_UNAVAILABLE
    };
    private static final String[] IN_APP_SKUS = {SKU_GAS, SKU_PREMIUM};
    private static final String[] SUBSCRIPTIONS_SKUS = {SKU_GOLD_MONTHLY, SKU_GOLD_YEARLY};

    private BillingConstants(){}

    /**
     * Returns the list of all SKUs for the billing type specified
     */
    public static final List<String> getSkuList(@BillingClient.SkuType String billingType) {
        List<String> inAppSKUs = Arrays.asList(STATIC_IN_APP_SKUS);
        inAppSKUs.addAll(Arrays.asList(IN_APP_SKUS));
        return (billingType == SkuType.INAPP) ? inAppSKUs
                : Arrays.asList(SUBSCRIPTIONS_SKUS);
    }
}

