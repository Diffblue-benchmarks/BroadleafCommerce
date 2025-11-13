package org.broadleafcommerce.core.order.service.call;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class GiftWrapOrderItemRequestDiffblueTest {
  /**
   * Test {@link GiftWrapOrderItemRequest#equals(Object)}, and {@link
   * GiftWrapOrderItemRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GiftWrapOrderItemRequest#equals(Object)}
   *   <li>{@link GiftWrapOrderItemRequest#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GiftWrapOrderItemRequest.equals(Object)",
    "int GiftWrapOrderItemRequest.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GiftWrapOrderItemRequest giftWrapOrderItemRequest = new GiftWrapOrderItemRequest();
    GiftWrapOrderItemRequest giftWrapOrderItemRequest2 = new GiftWrapOrderItemRequest();

    // Act and Assert
    assertEquals(giftWrapOrderItemRequest, giftWrapOrderItemRequest2);
    assertEquals(giftWrapOrderItemRequest.hashCode(), giftWrapOrderItemRequest2.hashCode());
  }

  /**
   * Test {@link GiftWrapOrderItemRequest#equals(Object)}, and {@link
   * GiftWrapOrderItemRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GiftWrapOrderItemRequest#equals(Object)}
   *   <li>{@link GiftWrapOrderItemRequest#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GiftWrapOrderItemRequest.equals(Object)",
    "int GiftWrapOrderItemRequest.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GiftWrapOrderItemRequest giftWrapOrderItemRequest = new GiftWrapOrderItemRequest();

    // Act and Assert
    assertEquals(giftWrapOrderItemRequest, giftWrapOrderItemRequest);
    int expectedHashCodeResult = giftWrapOrderItemRequest.hashCode();
    assertEquals(expectedHashCodeResult, giftWrapOrderItemRequest.hashCode());
  }

  /**
   * Test {@link GiftWrapOrderItemRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GiftWrapOrderItemRequest#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GiftWrapOrderItemRequest.equals(Object)",
    "int GiftWrapOrderItemRequest.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GiftWrapOrderItemRequest(), 1);
  }

  /**
   * Test {@link GiftWrapOrderItemRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GiftWrapOrderItemRequest#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GiftWrapOrderItemRequest.equals(Object)",
    "int GiftWrapOrderItemRequest.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<OrderItem> wrappedItems = new ArrayList<>();
    wrappedItems.add(new BundleOrderItemImpl());

    GiftWrapOrderItemRequest giftWrapOrderItemRequest = new GiftWrapOrderItemRequest();
    giftWrapOrderItemRequest.setWrappedItems(wrappedItems);

    // Act and Assert
    assertNotEquals(giftWrapOrderItemRequest, new GiftWrapOrderItemRequest());
  }

  /**
   * Test {@link GiftWrapOrderItemRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GiftWrapOrderItemRequest#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GiftWrapOrderItemRequest.equals(Object)",
    "int GiftWrapOrderItemRequest.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GiftWrapOrderItemRequest(), null);
  }

  /**
   * Test {@link GiftWrapOrderItemRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GiftWrapOrderItemRequest#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GiftWrapOrderItemRequest.equals(Object)",
    "int GiftWrapOrderItemRequest.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GiftWrapOrderItemRequest(), "Different type to GiftWrapOrderItemRequest");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GiftWrapOrderItemRequest}
   *   <li>{@link GiftWrapOrderItemRequest#setWrappedItems(List)}
   *   <li>{@link GiftWrapOrderItemRequest#getWrappedItems()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GiftWrapOrderItemRequest.<init>()",
    "List GiftWrapOrderItemRequest.getWrappedItems()",
    "void GiftWrapOrderItemRequest.setWrappedItems(List)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    GiftWrapOrderItemRequest actualGiftWrapOrderItemRequest = new GiftWrapOrderItemRequest();
    ArrayList<OrderItem> wrappedItems = new ArrayList<>();
    actualGiftWrapOrderItemRequest.setWrappedItems(wrappedItems);
    List<OrderItem> actualWrappedItems = actualGiftWrapOrderItemRequest.getWrappedItems();

    // Assert
    assertNull(actualGiftWrapOrderItemRequest.getRetailPriceOverride());
    assertNull(actualGiftWrapOrderItemRequest.getSalePriceOverride());
    assertNull(actualGiftWrapOrderItemRequest.getCategory());
    assertNull(actualGiftWrapOrderItemRequest.getProduct());
    assertNull(actualGiftWrapOrderItemRequest.getSku());
    assertNull(actualGiftWrapOrderItemRequest.getBundleOrderItem());
    assertNull(actualGiftWrapOrderItemRequest.getOrder());
    assertNull(actualGiftWrapOrderItemRequest.getPersonalMessage());
    assertEquals(0, actualGiftWrapOrderItemRequest.getQuantity());
    assertTrue(actualGiftWrapOrderItemRequest.getDiscreteOrderItemFeePrices().isEmpty());
    assertTrue(actualWrappedItems.isEmpty());
    assertTrue(actualGiftWrapOrderItemRequest.getAdditionalAttributes().isEmpty());
    assertTrue(actualGiftWrapOrderItemRequest.getItemAttributes().isEmpty());
    assertSame(wrappedItems, actualWrappedItems);
  }
}
