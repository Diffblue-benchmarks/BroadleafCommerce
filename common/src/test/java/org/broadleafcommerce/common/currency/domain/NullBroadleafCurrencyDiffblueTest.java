/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.common.currency.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class NullBroadleafCurrencyDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NullBroadleafCurrency}
   *   <li>{@link NullBroadleafCurrency#setCurrencyCode(String)}
   *   <li>{@link NullBroadleafCurrency#setDefaultFlag(boolean)}
   *   <li>{@link NullBroadleafCurrency#setFriendlyName(String)}
   *   <li>{@link NullBroadleafCurrency#getCurrencyCode()}
   *   <li>{@link NullBroadleafCurrency#getDefaultFlag()}
   *   <li>{@link NullBroadleafCurrency#getFriendlyName()}
   *   <li>{@link NullBroadleafCurrency#getJavaCurrency()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NullBroadleafCurrency.<init>()", "String NullBroadleafCurrency.getCurrencyCode()",
      "boolean NullBroadleafCurrency.getDefaultFlag()", "String NullBroadleafCurrency.getFriendlyName()",
      "java.util.Currency NullBroadleafCurrency.getJavaCurrency()",
      "void NullBroadleafCurrency.setCurrencyCode(String)", "void NullBroadleafCurrency.setDefaultFlag(boolean)",
      "void NullBroadleafCurrency.setFriendlyName(String)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    NullBroadleafCurrency actualNullBroadleafCurrency = new NullBroadleafCurrency();
    actualNullBroadleafCurrency.setCurrencyCode("Code");
    actualNullBroadleafCurrency.setDefaultFlag(true);
    actualNullBroadleafCurrency.setFriendlyName("Friendly Name");
    String actualCurrencyCode = actualNullBroadleafCurrency.getCurrencyCode();
    boolean actualDefaultFlag = actualNullBroadleafCurrency.getDefaultFlag();
    String actualFriendlyName = actualNullBroadleafCurrency.getFriendlyName();

    // Assert
    assertNull(actualCurrencyCode);
    assertNull(actualFriendlyName);
    assertNull(actualNullBroadleafCurrency.getJavaCurrency());
    assertFalse(actualDefaultFlag);
  }
}
