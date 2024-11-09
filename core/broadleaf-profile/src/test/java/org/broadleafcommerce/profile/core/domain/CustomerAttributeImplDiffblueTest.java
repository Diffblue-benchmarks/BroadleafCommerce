/*-
 * #%L
 * BroadleafCommerce Profile
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
package org.broadleafcommerce.profile.core.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class CustomerAttributeImplDiffblueTest {
  /**
   * Test {@link CustomerAttributeImpl#getValue()}.
   * <ul>
   *   <li>Given {@link CustomerAttributeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAttributeImpl#getValue()}
   */
  @Test
  public void testGetValue_givenCustomerAttributeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CustomerAttributeImpl()).getValue());
  }

  /**
   * Test {@link CustomerAttributeImpl#getValue()}.
   * <ul>
   *   <li>Given {@link CustomerAttributeImpl} (default constructor) Customer is
   * {@link CustomerImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAttributeImpl#getValue()}
   */
  @Test
  public void testGetValue_givenCustomerAttributeImplCustomerIsCustomerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(mock(CustomerImpl.class));

    // Act and Assert
    assertNull(customerAttributeImpl.getValue());
  }

  /**
   * Test {@link CustomerAttributeImpl#getName()}.
   * <ul>
   *   <li>Given {@link CustomerAttributeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAttributeImpl#getName()}
   */
  @Test
  public void testGetName_givenCustomerAttributeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CustomerAttributeImpl()).getName());
  }

  /**
   * Test {@link CustomerAttributeImpl#getName()}.
   * <ul>
   *   <li>Given {@link CustomerAttributeImpl} (default constructor) Customer is
   * {@link CustomerImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAttributeImpl#getName()}
   */
  @Test
  public void testGetName_givenCustomerAttributeImplCustomerIsCustomerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(mock(CustomerImpl.class));

    // Act and Assert
    assertNull(customerAttributeImpl.getName());
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}, and
   * {@link CustomerAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerAttributeImpl#equals(Object)}
   *   <li>{@link CustomerAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(new CustomerImpl());
    customerAttributeImpl.setId(1L);
    customerAttributeImpl.setName("Name");
    customerAttributeImpl.setValue("42");

    CustomerAttributeImpl customerAttributeImpl2 = new CustomerAttributeImpl();
    customerAttributeImpl2.setCustomer(new CustomerImpl());
    customerAttributeImpl2.setId(1L);
    customerAttributeImpl2.setName("Name");
    customerAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(customerAttributeImpl, customerAttributeImpl2);
    int expectedHashCodeResult = customerAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, customerAttributeImpl2.hashCode());
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}, and
   * {@link CustomerAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerAttributeImpl#equals(Object)}
   *   <li>{@link CustomerAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(mock(Customer.class));
    customerAttributeImpl.setId(1L);
    customerAttributeImpl.setName("Name");
    customerAttributeImpl.setValue("42");

    CustomerAttributeImpl customerAttributeImpl2 = new CustomerAttributeImpl();
    customerAttributeImpl2.setCustomer(new CustomerImpl());
    customerAttributeImpl2.setId(1L);
    customerAttributeImpl2.setName("Name");
    customerAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(customerAttributeImpl, customerAttributeImpl2);
    int notExpectedHashCodeResult = customerAttributeImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, customerAttributeImpl2.hashCode());
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}, and
   * {@link CustomerAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerAttributeImpl#equals(Object)}
   *   <li>{@link CustomerAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(new CustomerImpl());
    customerAttributeImpl.setId(null);
    customerAttributeImpl.setName("Name");
    customerAttributeImpl.setValue("42");

    CustomerAttributeImpl customerAttributeImpl2 = new CustomerAttributeImpl();
    customerAttributeImpl2.setCustomer(new CustomerImpl());
    customerAttributeImpl2.setId(1L);
    customerAttributeImpl2.setName("Name");
    customerAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(customerAttributeImpl, customerAttributeImpl2);
    int expectedHashCodeResult = customerAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, customerAttributeImpl2.hashCode());
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}, and
   * {@link CustomerAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerAttributeImpl#equals(Object)}
   *   <li>{@link CustomerAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(new CustomerImpl());
    customerAttributeImpl.setId(1L);
    customerAttributeImpl.setName("Name");
    customerAttributeImpl.setValue("42");

    CustomerAttributeImpl customerAttributeImpl2 = new CustomerAttributeImpl();
    customerAttributeImpl2.setCustomer(new CustomerImpl());
    customerAttributeImpl2.setId(null);
    customerAttributeImpl2.setName("Name");
    customerAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(customerAttributeImpl, customerAttributeImpl2);
    int expectedHashCodeResult = customerAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, customerAttributeImpl2.hashCode());
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}, and
   * {@link CustomerAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerAttributeImpl#equals(Object)}
   *   <li>{@link CustomerAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(null);
    customerAttributeImpl.setId(null);
    customerAttributeImpl.setName("Name");
    customerAttributeImpl.setValue("42");

    CustomerAttributeImpl customerAttributeImpl2 = new CustomerAttributeImpl();
    customerAttributeImpl2.setCustomer(null);
    customerAttributeImpl2.setId(1L);
    customerAttributeImpl2.setName("Name");
    customerAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(customerAttributeImpl, customerAttributeImpl2);
    int expectedHashCodeResult = customerAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, customerAttributeImpl2.hashCode());
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}, and
   * {@link CustomerAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerAttributeImpl#equals(Object)}
   *   <li>{@link CustomerAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(new CustomerImpl());
    customerAttributeImpl.setId(null);
    customerAttributeImpl.setName(null);
    customerAttributeImpl.setValue("42");

    CustomerAttributeImpl customerAttributeImpl2 = new CustomerAttributeImpl();
    customerAttributeImpl2.setCustomer(new CustomerImpl());
    customerAttributeImpl2.setId(1L);
    customerAttributeImpl2.setName(null);
    customerAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(customerAttributeImpl, customerAttributeImpl2);
    int expectedHashCodeResult = customerAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, customerAttributeImpl2.hashCode());
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}, and
   * {@link CustomerAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerAttributeImpl#equals(Object)}
   *   <li>{@link CustomerAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(new CustomerImpl());
    customerAttributeImpl.setId(1L);
    customerAttributeImpl.setName("Name");
    customerAttributeImpl.setValue("42");

    // Act and Assert
    assertEquals(customerAttributeImpl, customerAttributeImpl);
    int expectedHashCodeResult = customerAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, customerAttributeImpl.hashCode());
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(new CustomerImpl());
    customerAttributeImpl.setId(2L);
    customerAttributeImpl.setName("Name");
    customerAttributeImpl.setValue("42");

    CustomerAttributeImpl customerAttributeImpl2 = new CustomerAttributeImpl();
    customerAttributeImpl2.setCustomer(new CustomerImpl());
    customerAttributeImpl2.setId(1L);
    customerAttributeImpl2.setName("Name");
    customerAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(customerAttributeImpl, customerAttributeImpl2);
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(mock(Customer.class));
    customerAttributeImpl.setId(null);
    customerAttributeImpl.setName("Name");
    customerAttributeImpl.setValue("42");

    CustomerAttributeImpl customerAttributeImpl2 = new CustomerAttributeImpl();
    customerAttributeImpl2.setCustomer(new CustomerImpl());
    customerAttributeImpl2.setId(1L);
    customerAttributeImpl2.setName("Name");
    customerAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(customerAttributeImpl, customerAttributeImpl2);
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(null);
    customerAttributeImpl.setId(null);
    customerAttributeImpl.setName("Name");
    customerAttributeImpl.setValue("42");

    CustomerAttributeImpl customerAttributeImpl2 = new CustomerAttributeImpl();
    customerAttributeImpl2.setCustomer(new CustomerImpl());
    customerAttributeImpl2.setId(1L);
    customerAttributeImpl2.setName("Name");
    customerAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(customerAttributeImpl, customerAttributeImpl2);
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(new CustomerImpl());
    customerAttributeImpl.setId(null);
    customerAttributeImpl.setName("42");
    customerAttributeImpl.setValue("42");

    CustomerAttributeImpl customerAttributeImpl2 = new CustomerAttributeImpl();
    customerAttributeImpl2.setCustomer(new CustomerImpl());
    customerAttributeImpl2.setId(1L);
    customerAttributeImpl2.setName("Name");
    customerAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(customerAttributeImpl, customerAttributeImpl2);
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(new CustomerImpl());
    customerAttributeImpl.setId(null);
    customerAttributeImpl.setName(null);
    customerAttributeImpl.setValue("42");

    CustomerAttributeImpl customerAttributeImpl2 = new CustomerAttributeImpl();
    customerAttributeImpl2.setCustomer(new CustomerImpl());
    customerAttributeImpl2.setId(1L);
    customerAttributeImpl2.setName("Name");
    customerAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(customerAttributeImpl, customerAttributeImpl2);
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(new CustomerImpl());
    customerAttributeImpl.setId(null);
    customerAttributeImpl.setName("Name");
    customerAttributeImpl.setValue("Name");

    CustomerAttributeImpl customerAttributeImpl2 = new CustomerAttributeImpl();
    customerAttributeImpl2.setCustomer(new CustomerImpl());
    customerAttributeImpl2.setId(1L);
    customerAttributeImpl2.setName("Name");
    customerAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(customerAttributeImpl, customerAttributeImpl2);
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(new CustomerImpl());
    customerAttributeImpl.setId(null);
    customerAttributeImpl.setName("Name");
    customerAttributeImpl.setValue(null);

    CustomerAttributeImpl customerAttributeImpl2 = new CustomerAttributeImpl();
    customerAttributeImpl2.setCustomer(new CustomerImpl());
    customerAttributeImpl2.setId(1L);
    customerAttributeImpl2.setName("Name");
    customerAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(customerAttributeImpl, customerAttributeImpl2);
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(new CustomerImpl());
    customerAttributeImpl.setId(1L);
    customerAttributeImpl.setName("Name");
    customerAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(customerAttributeImpl, null);
  }

  /**
   * Test {@link CustomerAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    customerAttributeImpl.setCustomer(new CustomerImpl());
    customerAttributeImpl.setId(1L);
    customerAttributeImpl.setName("Name");
    customerAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(customerAttributeImpl, "Different type to CustomerAttributeImpl");
  }

  /**
   * Test
   * {@link CustomerAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link CustomerAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<CustomerAttribute> actualCreateOrRetrieveCopyInstanceResult = customerAttributeImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link CustomerAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link CustomerAttributeImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnCustomerAttributeImpl()
      throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerAttributeImpl customerAttributeImpl = new CustomerAttributeImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<CustomerAttribute> actualCreateOrRetrieveCopyInstanceResult = customerAttributeImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.profile.core.domain.CustomerAttributeImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    CustomerAttribute clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof CustomerAttributeImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(customerAttributeImpl, clone);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CustomerAttributeImpl}
   *   <li>{@link CustomerAttributeImpl#setCustomer(Customer)}
   *   <li>{@link CustomerAttributeImpl#setId(Long)}
   *   <li>{@link CustomerAttributeImpl#setName(String)}
   *   <li>{@link CustomerAttributeImpl#setValue(String)}
   *   <li>{@link CustomerAttributeImpl#getCustomer()}
   *   <li>{@link CustomerAttributeImpl#getId()}
   *   <li>{@link CustomerAttributeImpl#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CustomerAttributeImpl actualCustomerAttributeImpl = new CustomerAttributeImpl();
    CustomerImpl customer = new CustomerImpl();
    actualCustomerAttributeImpl.setCustomer(customer);
    actualCustomerAttributeImpl.setId(1L);
    actualCustomerAttributeImpl.setName("Name");
    actualCustomerAttributeImpl.setValue("42");
    Customer actualCustomer = actualCustomerAttributeImpl.getCustomer();
    Long actualId = actualCustomerAttributeImpl.getId();

    // Assert that nothing has changed
    assertEquals("42", actualCustomerAttributeImpl.toString());
    assertEquals(1L, actualId.longValue());
    assertSame(customer, actualCustomer);
  }
}
