/*-
 * #%L
 * BroadleafCommerce Profile
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
package org.broadleafcommerce.profile.core.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerAddressImplDiffblueTest {
  @Autowired private CustomerAddressImpl customerAddressImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerAddressImpl#setAddress(Address)}
   *   <li>{@link CustomerAddressImpl#setAddressName(String)}
   *   <li>{@link CustomerAddressImpl#setCustomer(Customer)}
   *   <li>{@link CustomerAddressImpl#setId(Long)}
   *   <li>{@link CustomerAddressImpl#getAddress()}
   *   <li>{@link CustomerAddressImpl#getAddressName()}
   *   <li>{@link CustomerAddressImpl#getCustomer()}
   *   <li>{@link CustomerAddressImpl#getId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Address CustomerAddressImpl.getAddress()",
    "String CustomerAddressImpl.getAddressName()",
    "Customer CustomerAddressImpl.getCustomer()",
    "Long CustomerAddressImpl.getId()",
    "void CustomerAddressImpl.setAddress(Address)",
    "void CustomerAddressImpl.setAddressName(String)",
    "void CustomerAddressImpl.setCustomer(Customer)",
    "void CustomerAddressImpl.setId(Long)"
  })
  public void testGettersAndSetters() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    AddressImpl address = new AddressImpl();

    // Act
    customerAddressImpl.setAddress(address);
    customerAddressImpl.setAddressName("42 Main St");
    CustomerImpl customer = new CustomerImpl();
    customerAddressImpl.setCustomer(customer);
    customerAddressImpl.setId(1L);
    Address actualAddress = customerAddressImpl.getAddress();
    String actualAddressName = customerAddressImpl.getAddressName();
    Customer actualCustomer = customerAddressImpl.getCustomer();

    // Assert
    assertEquals("42 Main St", actualAddressName);
    assertEquals(1L, customerAddressImpl.getId().longValue());
    assertSame(address, actualAddress);
    assertSame(customer, actualCustomer);
  }

  /**
   * Test {@link CustomerAddressImpl#toString()}.
   *
   * <ul>
   *   <li>Given {@link CustomerAddressImpl} AddressName is {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAddressImpl#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CustomerAddressImpl.toString()"})
  public void testToString_givenCustomerAddressImplAddressNameIsFoo_thenReturnFoo() {
    // Arrange
    customerAddressImpl.setAddressName("foo");

    // Act and Assert
    assertEquals("foo", customerAddressImpl.toString());
  }

  /**
   * Test {@link CustomerAddressImpl#toString()}.
   *
   * <ul>
   *   <li>Given {@link CustomerAddressImpl}.
   *   <li>Then return {@code null - null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAddressImpl#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CustomerAddressImpl.toString()"})
  public void testToString_givenCustomerAddressImpl_thenReturnNullNull() {
    // Arrange, Act and Assert
    assertEquals("null - null", customerAddressImpl.toString());
  }

  /**
   * Test {@link CustomerAddressImpl#getArchived()}.
   *
   * <p>Method under test: {@link CustomerAddressImpl#getArchived()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Character CustomerAddressImpl.getArchived()"})
  public void testGetArchived() {
    // Arrange, Act and Assert
    assertEquals('N', customerAddressImpl.getArchived().charValue());
  }

  /**
   * Test {@link CustomerAddressImpl#setArchived(Character)}.
   *
   * <p>Method under test: {@link CustomerAddressImpl#setArchived(Character)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerAddressImpl.setArchived(Character)"})
  public void testSetArchived() {
    // Arrange and Act
    customerAddressImpl.setArchived('A');

    // Assert
    assertEquals('A', customerAddressImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', customerAddressImpl.getArchived().charValue());
  }

  /**
   * Test {@link CustomerAddressImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link CustomerAddressImpl} Archived is {@code Y}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAddressImpl#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerAddressImpl.isActive()"})
  public void testIsActive_givenCustomerAddressImplArchivedIsY_thenReturnFalse() {
    // Arrange
    customerAddressImpl.setArchived('Y');

    // Act and Assert
    assertFalse(customerAddressImpl.isActive());
  }

  /**
   * Test {@link CustomerAddressImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link CustomerAddressImpl}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAddressImpl#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerAddressImpl.isActive()"})
  public void testIsActive_givenCustomerAddressImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(customerAddressImpl.isActive());
  }

  /**
   * Test {@link CustomerAddressImpl#equals(Object)}, and {@link CustomerAddressImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerAddressImpl#equals(Object)}
   *   <li>{@link CustomerAddressImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAddressImpl.equals(Object)",
    "int CustomerAddressImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(new AddressImpl());
    customerAddressImpl.setAddressName("42 Main St");
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(1L);

    CustomerAddressImpl customerAddressImpl2 = new CustomerAddressImpl();
    customerAddressImpl2.setAddress(new AddressImpl());
    customerAddressImpl2.setAddressName("42 Main St");
    customerAddressImpl2.setCustomer(new CustomerImpl());
    customerAddressImpl2.setId(1L);

    // Act and Assert
    assertEquals(customerAddressImpl, customerAddressImpl2);
    assertEquals(customerAddressImpl.hashCode(), customerAddressImpl2.hashCode());
  }

  /**
   * Test {@link CustomerAddressImpl#equals(Object)}, and {@link CustomerAddressImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerAddressImpl#equals(Object)}
   *   <li>{@link CustomerAddressImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAddressImpl.equals(Object)",
    "int CustomerAddressImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(new AddressImpl());
    customerAddressImpl.setAddressName("42 Main St");
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(null);

    CustomerAddressImpl customerAddressImpl2 = new CustomerAddressImpl();
    customerAddressImpl2.setAddress(new AddressImpl());
    customerAddressImpl2.setAddressName("42 Main St");
    customerAddressImpl2.setCustomer(new CustomerImpl());
    customerAddressImpl2.setId(1L);

    // Act and Assert
    assertEquals(customerAddressImpl, customerAddressImpl2);
    assertEquals(customerAddressImpl.hashCode(), customerAddressImpl2.hashCode());
  }

  /**
   * Test {@link CustomerAddressImpl#equals(Object)}, and {@link CustomerAddressImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerAddressImpl#equals(Object)}
   *   <li>{@link CustomerAddressImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAddressImpl.equals(Object)",
    "int CustomerAddressImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(new AddressImpl());
    customerAddressImpl.setAddressName("42 Main St");
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(1L);

    CustomerAddressImpl customerAddressImpl2 = new CustomerAddressImpl();
    customerAddressImpl2.setAddress(new AddressImpl());
    customerAddressImpl2.setAddressName("42 Main St");
    customerAddressImpl2.setCustomer(new CustomerImpl());
    customerAddressImpl2.setId(null);

    // Act and Assert
    assertEquals(customerAddressImpl, customerAddressImpl2);
    assertEquals(customerAddressImpl.hashCode(), customerAddressImpl2.hashCode());
  }

  /**
   * Test {@link CustomerAddressImpl#equals(Object)}, and {@link CustomerAddressImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerAddressImpl#equals(Object)}
   *   <li>{@link CustomerAddressImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAddressImpl.equals(Object)",
    "int CustomerAddressImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(null);
    customerAddressImpl.setAddressName("42 Main St");
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(null);

    CustomerAddressImpl customerAddressImpl2 = new CustomerAddressImpl();
    customerAddressImpl2.setAddress(null);
    customerAddressImpl2.setAddressName("42 Main St");
    customerAddressImpl2.setCustomer(new CustomerImpl());
    customerAddressImpl2.setId(1L);

    // Act and Assert
    assertEquals(customerAddressImpl, customerAddressImpl2);
    assertEquals(customerAddressImpl.hashCode(), customerAddressImpl2.hashCode());
  }

  /**
   * Test {@link CustomerAddressImpl#equals(Object)}, and {@link CustomerAddressImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerAddressImpl#equals(Object)}
   *   <li>{@link CustomerAddressImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAddressImpl.equals(Object)",
    "int CustomerAddressImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(new AddressImpl());
    customerAddressImpl.setAddressName(null);
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(null);

    CustomerAddressImpl customerAddressImpl2 = new CustomerAddressImpl();
    customerAddressImpl2.setAddress(new AddressImpl());
    customerAddressImpl2.setAddressName(null);
    customerAddressImpl2.setCustomer(new CustomerImpl());
    customerAddressImpl2.setId(1L);

    // Act and Assert
    assertEquals(customerAddressImpl, customerAddressImpl2);
    assertEquals(customerAddressImpl.hashCode(), customerAddressImpl2.hashCode());
  }

  /**
   * Test {@link CustomerAddressImpl#equals(Object)}, and {@link CustomerAddressImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerAddressImpl#equals(Object)}
   *   <li>{@link CustomerAddressImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAddressImpl.equals(Object)",
    "int CustomerAddressImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(new AddressImpl());
    customerAddressImpl.setAddressName("42 Main St");
    customerAddressImpl.setCustomer(null);
    customerAddressImpl.setId(null);

    CustomerAddressImpl customerAddressImpl2 = new CustomerAddressImpl();
    customerAddressImpl2.setAddress(new AddressImpl());
    customerAddressImpl2.setAddressName("42 Main St");
    customerAddressImpl2.setCustomer(null);
    customerAddressImpl2.setId(1L);

    // Act and Assert
    assertEquals(customerAddressImpl, customerAddressImpl2);
    assertEquals(customerAddressImpl.hashCode(), customerAddressImpl2.hashCode());
  }

  /**
   * Test {@link CustomerAddressImpl#equals(Object)}, and {@link CustomerAddressImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerAddressImpl#equals(Object)}
   *   <li>{@link CustomerAddressImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAddressImpl.equals(Object)",
    "int CustomerAddressImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(new AddressImpl());
    customerAddressImpl.setAddressName("42 Main St");
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(1L);

    // Act and Assert
    assertEquals(customerAddressImpl, customerAddressImpl);
    int expectedHashCodeResult = customerAddressImpl.hashCode();
    assertEquals(expectedHashCodeResult, customerAddressImpl.hashCode());
  }

  /**
   * Test {@link CustomerAddressImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAddressImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAddressImpl.equals(Object)",
    "int CustomerAddressImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(new AddressImpl());
    customerAddressImpl.setAddressName("42 Main St");
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(2L);

    CustomerAddressImpl customerAddressImpl2 = new CustomerAddressImpl();
    customerAddressImpl2.setAddress(new AddressImpl());
    customerAddressImpl2.setAddressName("42 Main St");
    customerAddressImpl2.setCustomer(new CustomerImpl());
    customerAddressImpl2.setId(1L);

    // Act and Assert
    assertNotEquals(customerAddressImpl, customerAddressImpl2);
  }

  /**
   * Test {@link CustomerAddressImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAddressImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAddressImpl.equals(Object)",
    "int CustomerAddressImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(null);
    customerAddressImpl.setAddressName("42 Main St");
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(null);

    CustomerAddressImpl customerAddressImpl2 = new CustomerAddressImpl();
    customerAddressImpl2.setAddress(new AddressImpl());
    customerAddressImpl2.setAddressName("42 Main St");
    customerAddressImpl2.setCustomer(new CustomerImpl());
    customerAddressImpl2.setId(1L);

    // Act and Assert
    assertNotEquals(customerAddressImpl, customerAddressImpl2);
  }

  /**
   * Test {@link CustomerAddressImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAddressImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAddressImpl.equals(Object)",
    "int CustomerAddressImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(mock(AddressImpl.class));
    customerAddressImpl.setAddressName("42 Main St");
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(null);

    CustomerAddressImpl customerAddressImpl2 = new CustomerAddressImpl();
    customerAddressImpl2.setAddress(new AddressImpl());
    customerAddressImpl2.setAddressName("42 Main St");
    customerAddressImpl2.setCustomer(new CustomerImpl());
    customerAddressImpl2.setId(1L);

    // Act and Assert
    assertNotEquals(customerAddressImpl, customerAddressImpl2);
  }

  /**
   * Test {@link CustomerAddressImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAddressImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAddressImpl.equals(Object)",
    "int CustomerAddressImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(new AddressImpl());
    customerAddressImpl.setAddressName("17 High St");
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(null);

    CustomerAddressImpl customerAddressImpl2 = new CustomerAddressImpl();
    customerAddressImpl2.setAddress(new AddressImpl());
    customerAddressImpl2.setAddressName("42 Main St");
    customerAddressImpl2.setCustomer(new CustomerImpl());
    customerAddressImpl2.setId(1L);

    // Act and Assert
    assertNotEquals(customerAddressImpl, customerAddressImpl2);
  }

  /**
   * Test {@link CustomerAddressImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAddressImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAddressImpl.equals(Object)",
    "int CustomerAddressImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(new AddressImpl());
    customerAddressImpl.setAddressName(null);
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(null);

    CustomerAddressImpl customerAddressImpl2 = new CustomerAddressImpl();
    customerAddressImpl2.setAddress(new AddressImpl());
    customerAddressImpl2.setAddressName("42 Main St");
    customerAddressImpl2.setCustomer(new CustomerImpl());
    customerAddressImpl2.setId(1L);

    // Act and Assert
    assertNotEquals(customerAddressImpl, customerAddressImpl2);
  }

  /**
   * Test {@link CustomerAddressImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAddressImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAddressImpl.equals(Object)",
    "int CustomerAddressImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(new AddressImpl());
    customerAddressImpl.setAddressName("42 Main St");
    customerAddressImpl.setCustomer(null);
    customerAddressImpl.setId(null);

    CustomerAddressImpl customerAddressImpl2 = new CustomerAddressImpl();
    customerAddressImpl2.setAddress(new AddressImpl());
    customerAddressImpl2.setAddressName("42 Main St");
    customerAddressImpl2.setCustomer(new CustomerImpl());
    customerAddressImpl2.setId(1L);

    // Act and Assert
    assertNotEquals(customerAddressImpl, customerAddressImpl2);
  }

  /**
   * Test {@link CustomerAddressImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAddressImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAddressImpl.equals(Object)",
    "int CustomerAddressImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(new AddressImpl());
    customerAddressImpl.setAddressName("42 Main St");
    customerAddressImpl.setCustomer(mock(CustomerImpl.class));
    customerAddressImpl.setId(null);

    CustomerAddressImpl customerAddressImpl2 = new CustomerAddressImpl();
    customerAddressImpl2.setAddress(new AddressImpl());
    customerAddressImpl2.setAddressName("42 Main St");
    customerAddressImpl2.setCustomer(new CustomerImpl());
    customerAddressImpl2.setId(1L);

    // Act and Assert
    assertNotEquals(customerAddressImpl, customerAddressImpl2);
  }

  /**
   * Test {@link CustomerAddressImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAddressImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAddressImpl.equals(Object)",
    "int CustomerAddressImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(new AddressImpl());
    customerAddressImpl.setAddressName("42 Main St");
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(1L);

    // Act and Assert
    assertNotEquals(customerAddressImpl, null);
  }

  /**
   * Test {@link CustomerAddressImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAddressImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerAddressImpl.equals(Object)",
    "int CustomerAddressImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(new AddressImpl());
    customerAddressImpl.setAddressName("42 Main St");
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(1L);

    // Act and Assert
    assertNotEquals(customerAddressImpl, "Different type to CustomerAddressImpl");
  }

  /**
   * Test new {@link CustomerAddressImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link CustomerAddressImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerAddressImpl.<init>()"})
  public void testNewCustomerAddressImpl() {
    // Arrange and Act
    CustomerAddressImpl actualCustomerAddressImpl = new CustomerAddressImpl();

    // Assert
    assertEquals('N', actualCustomerAddressImpl.archiveStatus.getArchived().charValue());
    assertEquals('N', actualCustomerAddressImpl.getArchived().charValue());
    assertNull(actualCustomerAddressImpl.getId());
    assertNull(actualCustomerAddressImpl.getAddressName());
    assertNull(actualCustomerAddressImpl.getAddress());
    assertNull(actualCustomerAddressImpl.getCustomer());
  }
}
