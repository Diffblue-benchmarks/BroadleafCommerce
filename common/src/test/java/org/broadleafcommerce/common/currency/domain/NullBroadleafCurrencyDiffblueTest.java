package org.broadleafcommerce.common.currency.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class NullBroadleafCurrencyDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NullBroadleafCurrency.<init>()",
    "String NullBroadleafCurrency.getCurrencyCode()",
    "boolean NullBroadleafCurrency.getDefaultFlag()",
    "String NullBroadleafCurrency.getFriendlyName()",
    "java.util.Currency NullBroadleafCurrency.getJavaCurrency()",
    "void NullBroadleafCurrency.setCurrencyCode(String)",
    "void NullBroadleafCurrency.setDefaultFlag(boolean)",
    "void NullBroadleafCurrency.setFriendlyName(String)"
  })
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
