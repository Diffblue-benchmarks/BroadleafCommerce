/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CustomerOfferImplDiffblueTest {
  /**
   * Test {@link CustomerOfferImpl#equals(Object)}, and {@link CustomerOfferImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerOfferImpl#equals(Object)}
   *   <li>{@link CustomerOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerOfferImpl.equals(Object)",
    "int CustomerOfferImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CustomerOfferImpl customerOfferImpl = new CustomerOfferImpl();
    customerOfferImpl.setCustomer(new CustomerImpl());
    customerOfferImpl.setId(CustomerOfferImpl.serialVersionUID);
    customerOfferImpl.setOffer(new OfferImpl());

    CustomerOfferImpl customerOfferImpl2 = new CustomerOfferImpl();
    customerOfferImpl2.setCustomer(new CustomerImpl());
    customerOfferImpl2.setId(CustomerOfferImpl.serialVersionUID);
    customerOfferImpl2.setOffer(new OfferImpl());

    // Act and Assert
    assertEquals(customerOfferImpl, customerOfferImpl2);
    assertEquals(customerOfferImpl.hashCode(), customerOfferImpl2.hashCode());
  }

  /**
   * Test {@link CustomerOfferImpl#equals(Object)}, and {@link CustomerOfferImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerOfferImpl#equals(Object)}
   *   <li>{@link CustomerOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerOfferImpl.equals(Object)",
    "int CustomerOfferImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CustomerOfferImpl customerOfferImpl = new CustomerOfferImpl();
    customerOfferImpl.setCustomer(new CustomerImpl());
    customerOfferImpl.setId(null);
    customerOfferImpl.setOffer(new OfferImpl());

    CustomerOfferImpl customerOfferImpl2 = new CustomerOfferImpl();
    customerOfferImpl2.setCustomer(new CustomerImpl());
    customerOfferImpl2.setId(CustomerOfferImpl.serialVersionUID);
    customerOfferImpl2.setOffer(new OfferImpl());

    // Act and Assert
    assertEquals(customerOfferImpl, customerOfferImpl2);
    assertEquals(customerOfferImpl.hashCode(), customerOfferImpl2.hashCode());
  }

  /**
   * Test {@link CustomerOfferImpl#equals(Object)}, and {@link CustomerOfferImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerOfferImpl#equals(Object)}
   *   <li>{@link CustomerOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerOfferImpl.equals(Object)",
    "int CustomerOfferImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CustomerOfferImpl customerOfferImpl = new CustomerOfferImpl();
    customerOfferImpl.setCustomer(new CustomerImpl());
    customerOfferImpl.setId(CustomerOfferImpl.serialVersionUID);
    customerOfferImpl.setOffer(new OfferImpl());

    CustomerOfferImpl customerOfferImpl2 = new CustomerOfferImpl();
    customerOfferImpl2.setCustomer(new CustomerImpl());
    customerOfferImpl2.setId(null);
    customerOfferImpl2.setOffer(new OfferImpl());

    // Act and Assert
    assertEquals(customerOfferImpl, customerOfferImpl2);
    assertEquals(customerOfferImpl.hashCode(), customerOfferImpl2.hashCode());
  }

  /**
   * Test {@link CustomerOfferImpl#equals(Object)}, and {@link CustomerOfferImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerOfferImpl#equals(Object)}
   *   <li>{@link CustomerOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerOfferImpl.equals(Object)",
    "int CustomerOfferImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    CustomerOfferImpl customerOfferImpl = new CustomerOfferImpl();
    customerOfferImpl.setCustomer(null);
    customerOfferImpl.setId(null);
    customerOfferImpl.setOffer(new OfferImpl());

    CustomerOfferImpl customerOfferImpl2 = new CustomerOfferImpl();
    customerOfferImpl2.setCustomer(null);
    customerOfferImpl2.setId(CustomerOfferImpl.serialVersionUID);
    customerOfferImpl2.setOffer(new OfferImpl());

    // Act and Assert
    assertEquals(customerOfferImpl, customerOfferImpl2);
    assertEquals(customerOfferImpl.hashCode(), customerOfferImpl2.hashCode());
  }

  /**
   * Test {@link CustomerOfferImpl#equals(Object)}, and {@link CustomerOfferImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerOfferImpl#equals(Object)}
   *   <li>{@link CustomerOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerOfferImpl.equals(Object)",
    "int CustomerOfferImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    CustomerOfferImpl customerOfferImpl = new CustomerOfferImpl();
    customerOfferImpl.setCustomer(new CustomerImpl());
    customerOfferImpl.setId(null);
    customerOfferImpl.setOffer(null);

    CustomerOfferImpl customerOfferImpl2 = new CustomerOfferImpl();
    customerOfferImpl2.setCustomer(new CustomerImpl());
    customerOfferImpl2.setId(CustomerOfferImpl.serialVersionUID);
    customerOfferImpl2.setOffer(null);

    // Act and Assert
    assertEquals(customerOfferImpl, customerOfferImpl2);
    assertEquals(customerOfferImpl.hashCode(), customerOfferImpl2.hashCode());
  }

  /**
   * Test {@link CustomerOfferImpl#equals(Object)}, and {@link CustomerOfferImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerOfferImpl#equals(Object)}
   *   <li>{@link CustomerOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerOfferImpl.equals(Object)",
    "int CustomerOfferImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CustomerOfferImpl customerOfferImpl = new CustomerOfferImpl();
    customerOfferImpl.setCustomer(new CustomerImpl());
    customerOfferImpl.setId(CustomerOfferImpl.serialVersionUID);
    customerOfferImpl.setOffer(new OfferImpl());

    // Act and Assert
    assertEquals(customerOfferImpl, customerOfferImpl);
    int expectedHashCodeResult = customerOfferImpl.hashCode();
    assertEquals(expectedHashCodeResult, customerOfferImpl.hashCode());
  }

  /**
   * Test {@link CustomerOfferImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerOfferImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerOfferImpl.equals(Object)",
    "int CustomerOfferImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CustomerOfferImpl customerOfferImpl = new CustomerOfferImpl();
    customerOfferImpl.setCustomer(new CustomerImpl());
    customerOfferImpl.setId(2L);
    customerOfferImpl.setOffer(new OfferImpl());

    CustomerOfferImpl customerOfferImpl2 = new CustomerOfferImpl();
    customerOfferImpl2.setCustomer(new CustomerImpl());
    customerOfferImpl2.setId(CustomerOfferImpl.serialVersionUID);
    customerOfferImpl2.setOffer(new OfferImpl());

    // Act and Assert
    assertNotEquals(customerOfferImpl, customerOfferImpl2);
  }

  /**
   * Test {@link CustomerOfferImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerOfferImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerOfferImpl.equals(Object)",
    "int CustomerOfferImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CustomerOfferImpl customerOfferImpl = new CustomerOfferImpl();
    customerOfferImpl.setCustomer(null);
    customerOfferImpl.setId(null);
    customerOfferImpl.setOffer(new OfferImpl());

    CustomerOfferImpl customerOfferImpl2 = new CustomerOfferImpl();
    customerOfferImpl2.setCustomer(new CustomerImpl());
    customerOfferImpl2.setId(CustomerOfferImpl.serialVersionUID);
    customerOfferImpl2.setOffer(new OfferImpl());

    // Act and Assert
    assertNotEquals(customerOfferImpl, customerOfferImpl2);
  }

  /**
   * Test {@link CustomerOfferImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerOfferImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerOfferImpl.equals(Object)",
    "int CustomerOfferImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CustomerOfferImpl customerOfferImpl = new CustomerOfferImpl();
    customerOfferImpl.setCustomer(mock(CustomerImpl.class));
    customerOfferImpl.setId(null);
    customerOfferImpl.setOffer(new OfferImpl());

    CustomerOfferImpl customerOfferImpl2 = new CustomerOfferImpl();
    customerOfferImpl2.setCustomer(new CustomerImpl());
    customerOfferImpl2.setId(CustomerOfferImpl.serialVersionUID);
    customerOfferImpl2.setOffer(new OfferImpl());

    // Act and Assert
    assertNotEquals(customerOfferImpl, customerOfferImpl2);
  }

  /**
   * Test {@link CustomerOfferImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerOfferImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerOfferImpl.equals(Object)",
    "int CustomerOfferImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OfferImpl offer = new OfferImpl();
    offer.setId(OfferImpl.serialVersionUID);

    CustomerOfferImpl customerOfferImpl = new CustomerOfferImpl();
    customerOfferImpl.setCustomer(new CustomerImpl());
    customerOfferImpl.setId(null);
    customerOfferImpl.setOffer(offer);

    CustomerOfferImpl customerOfferImpl2 = new CustomerOfferImpl();
    customerOfferImpl2.setCustomer(new CustomerImpl());
    customerOfferImpl2.setId(CustomerOfferImpl.serialVersionUID);
    customerOfferImpl2.setOffer(new OfferImpl());

    // Act and Assert
    assertNotEquals(customerOfferImpl, customerOfferImpl2);
  }

  /**
   * Test {@link CustomerOfferImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerOfferImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerOfferImpl.equals(Object)",
    "int CustomerOfferImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CustomerOfferImpl customerOfferImpl = new CustomerOfferImpl();
    customerOfferImpl.setCustomer(new CustomerImpl());
    customerOfferImpl.setId(null);
    customerOfferImpl.setOffer(null);

    CustomerOfferImpl customerOfferImpl2 = new CustomerOfferImpl();
    customerOfferImpl2.setCustomer(new CustomerImpl());
    customerOfferImpl2.setId(CustomerOfferImpl.serialVersionUID);
    customerOfferImpl2.setOffer(new OfferImpl());

    // Act and Assert
    assertNotEquals(customerOfferImpl, customerOfferImpl2);
  }

  /**
   * Test {@link CustomerOfferImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerOfferImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerOfferImpl.equals(Object)",
    "int CustomerOfferImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CustomerOfferImpl customerOfferImpl = new CustomerOfferImpl();
    customerOfferImpl.setCustomer(new CustomerImpl());
    customerOfferImpl.setId(CustomerOfferImpl.serialVersionUID);
    customerOfferImpl.setOffer(new OfferImpl());

    // Act and Assert
    assertNotEquals(customerOfferImpl, null);
  }

  /**
   * Test {@link CustomerOfferImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerOfferImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerOfferImpl.equals(Object)",
    "int CustomerOfferImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CustomerOfferImpl customerOfferImpl = new CustomerOfferImpl();
    customerOfferImpl.setCustomer(new CustomerImpl());
    customerOfferImpl.setId(CustomerOfferImpl.serialVersionUID);
    customerOfferImpl.setOffer(new OfferImpl());

    // Act and Assert
    assertNotEquals(customerOfferImpl, "Different type to CustomerOfferImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CustomerOfferImpl}
   *   <li>{@link CustomerOfferImpl#setCustomer(Customer)}
   *   <li>{@link CustomerOfferImpl#setId(Long)}
   *   <li>{@link CustomerOfferImpl#setOffer(Offer)}
   *   <li>{@link CustomerOfferImpl#getCustomer()}
   *   <li>{@link CustomerOfferImpl#getId()}
   *   <li>{@link CustomerOfferImpl#getOffer()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomerOfferImpl.<init>()",
    "Customer CustomerOfferImpl.getCustomer()",
    "Long CustomerOfferImpl.getId()",
    "Offer CustomerOfferImpl.getOffer()",
    "void CustomerOfferImpl.setCustomer(Customer)",
    "void CustomerOfferImpl.setId(Long)",
    "void CustomerOfferImpl.setOffer(Offer)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CustomerOfferImpl actualCustomerOfferImpl = new CustomerOfferImpl();
    CustomerImpl customer = new CustomerImpl();
    actualCustomerOfferImpl.setCustomer(customer);
    actualCustomerOfferImpl.setId(CustomerOfferImpl.serialVersionUID);
    OfferImpl offer = new OfferImpl();
    actualCustomerOfferImpl.setOffer(offer);
    Customer actualCustomer = actualCustomerOfferImpl.getCustomer();
    Long actualId = actualCustomerOfferImpl.getId();
    Offer actualOffer = actualCustomerOfferImpl.getOffer();

    // Assert
    assertEquals(CustomerOfferImpl.serialVersionUID, actualId.longValue());
    assertSame(offer, actualOffer);
    assertSame(customer, actualCustomer);
  }
}
