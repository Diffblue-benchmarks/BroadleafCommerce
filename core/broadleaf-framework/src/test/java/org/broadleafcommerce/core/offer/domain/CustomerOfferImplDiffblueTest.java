/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class CustomerOfferImplDiffblueTest {
  /**
   * Test {@link CustomerOfferImpl#equals(Object)}, and
   * {@link CustomerOfferImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerOfferImpl#equals(Object)}
   *   <li>{@link CustomerOfferImpl#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = customerOfferImpl.hashCode();
    assertEquals(expectedHashCodeResult, customerOfferImpl2.hashCode());
  }

  /**
   * Test {@link CustomerOfferImpl#equals(Object)}, and
   * {@link CustomerOfferImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerOfferImpl#equals(Object)}
   *   <li>{@link CustomerOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CustomerOfferImpl customerOfferImpl = new CustomerOfferImpl();
    customerOfferImpl.setCustomer(mock(Customer.class));
    customerOfferImpl.setId(CustomerOfferImpl.serialVersionUID);
    customerOfferImpl.setOffer(new OfferImpl());

    CustomerOfferImpl customerOfferImpl2 = new CustomerOfferImpl();
    customerOfferImpl2.setCustomer(new CustomerImpl());
    customerOfferImpl2.setId(CustomerOfferImpl.serialVersionUID);
    customerOfferImpl2.setOffer(new OfferImpl());

    // Act and Assert
    assertEquals(customerOfferImpl, customerOfferImpl2);
    int notExpectedHashCodeResult = customerOfferImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, customerOfferImpl2.hashCode());
  }

  /**
   * Test {@link CustomerOfferImpl#equals(Object)}, and
   * {@link CustomerOfferImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerOfferImpl#equals(Object)}
   *   <li>{@link CustomerOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
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
    int expectedHashCodeResult = customerOfferImpl.hashCode();
    assertEquals(expectedHashCodeResult, customerOfferImpl2.hashCode());
  }

  /**
   * Test {@link CustomerOfferImpl#equals(Object)}, and
   * {@link CustomerOfferImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerOfferImpl#equals(Object)}
   *   <li>{@link CustomerOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
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
    int expectedHashCodeResult = customerOfferImpl.hashCode();
    assertEquals(expectedHashCodeResult, customerOfferImpl2.hashCode());
  }

  /**
   * Test {@link CustomerOfferImpl#equals(Object)}, and
   * {@link CustomerOfferImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerOfferImpl#equals(Object)}
   *   <li>{@link CustomerOfferImpl#hashCode()}
   * </ul>
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerOfferImpl#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerOfferImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CustomerOfferImpl customerOfferImpl = new CustomerOfferImpl();
    customerOfferImpl.setCustomer(mock(Customer.class));
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerOfferImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerOfferImpl#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerOfferImpl#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerOfferImpl#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerOfferImpl#equals(Object)}
   */
  @Test
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
   * <p>
   * Methods under test:
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

    // Assert that nothing has changed
    assertEquals(CustomerOfferImpl.serialVersionUID, actualId.longValue());
    assertSame(offer, actualOffer);
    assertSame(customer, actualCustomer);
  }
}
