package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CandidateItemOfferImplDiffblueTest {
  @Autowired private CandidateItemOfferImpl candidateItemOfferImpl;

  /**
   * Test {@link CandidateItemOfferImpl#clone()}.
   *
   * <p>Method under test: {@link CandidateItemOfferImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CandidateItemOffer CandidateItemOfferImpl.clone()"})
  public void testClone() {
    // Arrange and Act
    CandidateItemOffer actualCloneResult = candidateItemOfferImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof CandidateItemOfferImpl);
    assertEquals(candidateItemOfferImpl, actualCloneResult);
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}, and {@link
   * CandidateItemOfferImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CandidateItemOfferImpl#equals(Object)}
   *   <li>{@link CandidateItemOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CandidateItemOfferImpl.equals(Object)",
    "int CandidateItemOfferImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(new Money());
    candidateItemOfferImpl.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl.setOrderItem(new BundleOrderItemImpl());

    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();
    candidateItemOfferImpl2.setDiscountedPrice(new Money());
    candidateItemOfferImpl2.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl2.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertEquals(candidateItemOfferImpl, candidateItemOfferImpl2);
    assertEquals(candidateItemOfferImpl.hashCode(), candidateItemOfferImpl2.hashCode());
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}, and {@link
   * CandidateItemOfferImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CandidateItemOfferImpl#equals(Object)}
   *   <li>{@link CandidateItemOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CandidateItemOfferImpl.equals(Object)",
    "int CandidateItemOfferImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(new Money());
    candidateItemOfferImpl.setId(null);
    candidateItemOfferImpl.setOrderItem(new BundleOrderItemImpl());

    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();
    candidateItemOfferImpl2.setDiscountedPrice(new Money());
    candidateItemOfferImpl2.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl2.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertEquals(candidateItemOfferImpl, candidateItemOfferImpl2);
    assertEquals(candidateItemOfferImpl.hashCode(), candidateItemOfferImpl2.hashCode());
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}, and {@link
   * CandidateItemOfferImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CandidateItemOfferImpl#equals(Object)}
   *   <li>{@link CandidateItemOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CandidateItemOfferImpl.equals(Object)",
    "int CandidateItemOfferImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(new Money());
    candidateItemOfferImpl.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl.setOrderItem(new BundleOrderItemImpl());

    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();
    candidateItemOfferImpl2.setDiscountedPrice(new Money());
    candidateItemOfferImpl2.setId(null);
    candidateItemOfferImpl2.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertEquals(candidateItemOfferImpl, candidateItemOfferImpl2);
    assertEquals(candidateItemOfferImpl.hashCode(), candidateItemOfferImpl2.hashCode());
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}, and {@link
   * CandidateItemOfferImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CandidateItemOfferImpl#equals(Object)}
   *   <li>{@link CandidateItemOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CandidateItemOfferImpl.equals(Object)",
    "int CandidateItemOfferImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(new Money());
    candidateItemOfferImpl.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertEquals(candidateItemOfferImpl, candidateItemOfferImpl);
    int expectedHashCodeResult = candidateItemOfferImpl.hashCode();
    assertEquals(expectedHashCodeResult, candidateItemOfferImpl.hashCode());
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CandidateItemOfferImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CandidateItemOfferImpl.equals(Object)",
    "int CandidateItemOfferImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(new Money());
    candidateItemOfferImpl.setId(2L);
    candidateItemOfferImpl.setOrderItem(new BundleOrderItemImpl());

    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();
    candidateItemOfferImpl2.setDiscountedPrice(new Money());
    candidateItemOfferImpl2.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl2.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertNotEquals(candidateItemOfferImpl, candidateItemOfferImpl2);
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CandidateItemOfferImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CandidateItemOfferImpl.equals(Object)",
    "int CandidateItemOfferImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(new Money(10.0d));
    candidateItemOfferImpl.setId(null);
    candidateItemOfferImpl.setOrderItem(new BundleOrderItemImpl());

    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();
    candidateItemOfferImpl2.setDiscountedPrice(new Money());
    candidateItemOfferImpl2.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl2.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertNotEquals(candidateItemOfferImpl, candidateItemOfferImpl2);
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CandidateItemOfferImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CandidateItemOfferImpl.equals(Object)",
    "int CandidateItemOfferImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(new Money());
    candidateItemOfferImpl.setId(null);
    candidateItemOfferImpl.setOrderItem(new DiscreteOrderItemImpl());

    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();
    candidateItemOfferImpl2.setDiscountedPrice(new Money());
    candidateItemOfferImpl2.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl2.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertNotEquals(candidateItemOfferImpl, candidateItemOfferImpl2);
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CandidateItemOfferImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CandidateItemOfferImpl.equals(Object)",
    "int CandidateItemOfferImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(new Money());
    candidateItemOfferImpl.setId(null);
    candidateItemOfferImpl.setOrderItem(null);

    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();
    candidateItemOfferImpl2.setDiscountedPrice(new Money());
    candidateItemOfferImpl2.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl2.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertNotEquals(candidateItemOfferImpl, candidateItemOfferImpl2);
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CandidateItemOfferImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CandidateItemOfferImpl.equals(Object)",
    "int CandidateItemOfferImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Money discountedPrice = mock(Money.class);
    when(discountedPrice.getAmount()).thenReturn(null);

    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(discountedPrice);
    candidateItemOfferImpl.setId(null);
    candidateItemOfferImpl.setOrderItem(new BundleOrderItemImpl());

    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();
    candidateItemOfferImpl2.setDiscountedPrice(new Money());
    candidateItemOfferImpl2.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl2.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertNotEquals(candidateItemOfferImpl, candidateItemOfferImpl2);
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CandidateItemOfferImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CandidateItemOfferImpl.equals(Object)",
    "int CandidateItemOfferImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(new Money());
    candidateItemOfferImpl.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertNotEquals(candidateItemOfferImpl, null);
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CandidateItemOfferImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CandidateItemOfferImpl.equals(Object)",
    "int CandidateItemOfferImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(new Money());
    candidateItemOfferImpl.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertNotEquals(candidateItemOfferImpl, "Different type to CandidateItemOfferImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CandidateItemOfferImpl}
   *   <li>{@link CandidateItemOfferImpl#setId(Long)}
   *   <li>{@link CandidateItemOfferImpl#setOrderItem(OrderItem)}
   *   <li>{@link CandidateItemOfferImpl#getId()}
   *   <li>{@link CandidateItemOfferImpl#getOrderItem()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CandidateItemOfferImpl.<init>()",
    "Long CandidateItemOfferImpl.getId()",
    "OrderItem CandidateItemOfferImpl.getOrderItem()",
    "void CandidateItemOfferImpl.setId(Long)",
    "void CandidateItemOfferImpl.setOrderItem(OrderItem)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CandidateItemOfferImpl actualCandidateItemOfferImpl = new CandidateItemOfferImpl();
    actualCandidateItemOfferImpl.setId(CandidateItemOfferImpl.serialVersionUID);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    actualCandidateItemOfferImpl.setOrderItem(orderItem);
    Long actualId = actualCandidateItemOfferImpl.getId();
    OrderItem actualOrderItem = actualCandidateItemOfferImpl.getOrderItem();

    // Assert
    assertEquals(CandidateItemOfferImpl.serialVersionUID, actualId.longValue());
    assertSame(orderItem, actualOrderItem);
  }
}
