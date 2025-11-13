package org.broadleafcommerce.common.payment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CreditCardTypeCheckDiffblueTest {
  /**
   * Test {@link CreditCardTypeCheck#getCreditCardType(String)}.
   *
   * <ul>
   *   <li>When {@code (2014)?(2149)?[0-9]{11}}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CreditCardType CreditCardTypeCheck.getCreditCardType(String)"})
  public void testGetCreditCardType_when201421490911_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> CreditCardTypeCheck.getCreditCardType("(2014)?(2149)?[0-9]{11}"));
  }

  /**
   * Test {@link CreditCardTypeCheck#getCreditCardType(String)}.
   *
   * <ul>
   *   <li>When {@code 4444444444444}.
   *   <li>Then return Type is {@code VISA}.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CreditCardType CreditCardTypeCheck.getCreditCardType(String)"})
  public void testGetCreditCardType_when4444444444444_thenReturnTypeIsVisa() {
    // Arrange and Act
    CreditCardType actualCreditCardType = CreditCardTypeCheck.getCreditCardType("4444444444444");

    // Assert
    assertEquals("VISA", actualCreditCardType.getType());
    assertEquals("Visa", actualCreditCardType.getFriendlyType());
  }

  /**
   * Test {@link CreditCardTypeCheck#getCreditCardType(String)}.
   *
   * <ul>
   *   <li>When {@code 3444444444444444}.
   *   <li>Then return FriendlyType is {@code JCB}.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CreditCardType CreditCardTypeCheck.getCreditCardType(String)"})
  public void testGetCreditCardType_when3444444444444444_thenReturnFriendlyTypeIsJcb() {
    // Arrange and Act
    CreditCardType actualCreditCardType = CreditCardTypeCheck.getCreditCardType("3444444444444444");

    // Assert
    assertEquals("JCB", actualCreditCardType.getFriendlyType());
    assertEquals("JCB", actualCreditCardType.getType());
  }

  /**
   * Test {@link CreditCardTypeCheck#getCreditCardType(String)}.
   *
   * <ul>
   *   <li>When {@code 3638444444444444}.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CreditCardType CreditCardTypeCheck.getCreditCardType(String)"})
  public void testGetCreditCardType_when3638444444444444() {
    // Arrange and Act
    CreditCardType actualCreditCardType = CreditCardTypeCheck.getCreditCardType("3638444444444444");

    // Assert
    assertEquals("DINERSCLUB_CARTEBLANCHE", actualCreditCardType.getType());
    assertEquals("Diner's Club / Carte Blanche", actualCreditCardType.getFriendlyType());
  }

  /**
   * Test {@link CreditCardTypeCheck#getCreditCardType(String)}.
   *
   * <ul>
   *   <li>When {@code 4444444444444444}.
   *   <li>Then return Type is {@code VISA}.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CreditCardType CreditCardTypeCheck.getCreditCardType(String)"})
  public void testGetCreditCardType_when4444444444444444_thenReturnTypeIsVisa() {
    // Arrange and Act
    CreditCardType actualCreditCardType = CreditCardTypeCheck.getCreditCardType("4444444444444444");

    // Assert
    assertEquals("VISA", actualCreditCardType.getType());
    assertEquals("Visa", actualCreditCardType.getFriendlyType());
  }

  /**
   * Test {@link CreditCardTypeCheck#getCreditCardType(String)}.
   *
   * <ul>
   *   <li>When {@code 6011444444444444}.
   *   <li>Then return Type is {@code DISCOVER}.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CreditCardType CreditCardTypeCheck.getCreditCardType(String)"})
  public void testGetCreditCardType_when6011444444444444_thenReturnTypeIsDiscover() {
    // Arrange and Act
    CreditCardType actualCreditCardType = CreditCardTypeCheck.getCreditCardType("6011444444444444");

    // Assert
    assertEquals("DISCOVER", actualCreditCardType.getType());
    assertEquals("Discover", actualCreditCardType.getFriendlyType());
  }

  /**
   * Test {@link CreditCardTypeCheck#getCreditCardType(String)}.
   *
   * <ul>
   *   <li>When {@code 34374444444444444}.
   *   <li>Then return Type is {@code AMEX}.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CreditCardType CreditCardTypeCheck.getCreditCardType(String)"})
  public void testGetCreditCardType_when34374444444444444_thenReturnTypeIsAmex() {
    // Arrange and Act
    CreditCardType actualCreditCardType =
        CreditCardTypeCheck.getCreditCardType("34374444444444444");

    // Assert
    assertEquals("AMEX", actualCreditCardType.getType());
    assertEquals("American Express", actualCreditCardType.getFriendlyType());
  }

  /**
   * Test {@link CreditCardTypeCheck#getCreditCardType(String)}.
   *
   * <ul>
   *   <li>When {@code 2014214944444444444}.
   *   <li>Then return Type is {@code ENROUTE}.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CreditCardType CreditCardTypeCheck.getCreditCardType(String)"})
  public void testGetCreditCardType_when2014214944444444444_thenReturnTypeIsEnroute() {
    // Arrange and Act
    CreditCardType actualCreditCardType =
        CreditCardTypeCheck.getCreditCardType("2014214944444444444");

    // Assert
    assertEquals("ENROUTE", actualCreditCardType.getType());
    assertEquals("En Route", actualCreditCardType.getFriendlyType());
  }

  /**
   * Test {@link CreditCardTypeCheck#getCreditCardType(String)}.
   *
   * <ul>
   *   <li>When {@code 2131180044444444444}.
   *   <li>Then return FriendlyType is {@code JCB}.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CreditCardType CreditCardTypeCheck.getCreditCardType(String)"})
  public void testGetCreditCardType_when2131180044444444444_thenReturnFriendlyTypeIsJcb() {
    // Arrange and Act
    CreditCardType actualCreditCardType =
        CreditCardTypeCheck.getCreditCardType("2131180044444444444");

    // Assert
    assertEquals("JCB", actualCreditCardType.getFriendlyType());
    assertEquals("JCB", actualCreditCardType.getType());
  }

  /**
   * Test {@link CreditCardTypeCheck#getCreditCardType(String)}.
   *
   * <ul>
   *   <li>When {@code 515253545544444444444444}.
   *   <li>Then return Type is {@code MASTERCARD}.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CreditCardType CreditCardTypeCheck.getCreditCardType(String)"})
  public void testGetCreditCardType_when515253545544444444444444_thenReturnTypeIsMastercard() {
    // Arrange and Act
    CreditCardType actualCreditCardType =
        CreditCardTypeCheck.getCreditCardType("515253545544444444444444");

    // Assert
    assertEquals("MASTERCARD", actualCreditCardType.getType());
    assertEquals("Master Card", actualCreditCardType.getFriendlyType());
  }

  /**
   * Test {@link CreditCardTypeCheck#getCreditCardType(String)}.
   *
   * <ul>
   *   <li>When {@code 30030130230330430544444444444}.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CreditCardType CreditCardTypeCheck.getCreditCardType(String)"})
  public void testGetCreditCardType_when30030130230330430544444444444() {
    // Arrange and Act
    CreditCardType actualCreditCardType =
        CreditCardTypeCheck.getCreditCardType("30030130230330430544444444444");

    // Assert
    assertEquals("DINERSCLUB_CARTEBLANCHE", actualCreditCardType.getType());
    assertEquals("Diner's Club / Carte Blanche", actualCreditCardType.getFriendlyType());
  }
}
