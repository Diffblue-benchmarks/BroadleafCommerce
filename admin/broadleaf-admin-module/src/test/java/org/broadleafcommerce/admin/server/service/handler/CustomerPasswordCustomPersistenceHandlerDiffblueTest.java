/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.server.service.handler;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.security.util.PasswordReset;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CustomerPasswordCustomPersistenceHandlerDiffblueTest {
  @InjectMocks
  private CustomerPasswordCustomPersistenceHandler customerPasswordCustomPersistenceHandler;

  @Mock
  private CustomerService customerService;

  /**
   * Test {@link CustomerPasswordCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code java.text}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPasswordCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean CustomerPasswordCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate_givenArrayOfStringWithJavaText() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setCustomCriteria(new String[]{"java.text"});

    // Act and Assert
    assertFalse(customerPasswordCustomPersistenceHandler.canHandleUpdate(persistencePackage));
  }

  /**
   * Test {@link CustomerPasswordCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code passwordUpdate}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPasswordCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean CustomerPasswordCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate_givenArrayOfStringWithPasswordUpdate_thenReturnTrue() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setCustomCriteria(new String[]{"passwordUpdate"});

    // Act and Assert
    assertTrue(customerPasswordCustomPersistenceHandler.canHandleUpdate(persistencePackage));
  }

  /**
   * Test {@link CustomerPasswordCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given empty array of {@link String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPasswordCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean CustomerPasswordCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate_givenEmptyArrayOfString() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setCustomCriteria(new String[]{});

    // Act and Assert
    assertFalse(customerPasswordCustomPersistenceHandler.canHandleUpdate(persistencePackage));
  }

  /**
   * Test {@link CustomerPasswordCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPasswordCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean CustomerPasswordCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(customerPasswordCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test {@link CustomerPasswordCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Customer} {@link Customer#getEmailAddress()} return {@code 42 Main St}.</li>
   *   <li>Then calls {@link CustomerService#resetPassword(PasswordReset)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPasswordCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity CustomerPasswordCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testUpdate_givenCustomerGetEmailAddressReturn42MainSt_thenCallsResetPassword() throws ServiceException {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customerService.resetPassword(Mockito.<PasswordReset>any())).thenReturn(new CustomerImpl());
    when(customerService.readCustomerByUsername(Mockito.<String>any())).thenReturn(customer);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"username"}, "ABC123");

    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    customerPasswordCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao,
        new AdornedTargetListPersistenceModule());

    // Assert
    verify(entity, atLeast(1)).findProperty(eq("username"));
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customerService).readCustomerByUsername(isNull());
    verify(customerService).resetPassword(isA(PasswordReset.class));
  }

  /**
   * Test {@link CustomerPasswordCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Customer} {@link Customer#getEmailAddress()} return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPasswordCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity CustomerPasswordCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testUpdate_givenCustomerGetEmailAddressReturnEmptyString() throws ServiceException {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.getEmailAddress()).thenReturn("");
    when(customerService.readCustomerByUsername(Mockito.<String>any())).thenReturn(customer);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"username"}, "ABC123");

    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> customerPasswordCustomPersistenceHandler.update(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).findProperty(eq("username"));
    verify(customer).getEmailAddress();
    verify(customerService).readCustomerByUsername(isNull());
  }

  /**
   * Test {@link CustomerPasswordCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link CustomerService} {@link CustomerService#readCustomerByUsername(String)} return {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPasswordCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity CustomerPasswordCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testUpdate_givenCustomerServiceReadCustomerByUsernameReturnCustomerImpl() throws ServiceException {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"username"}, "ABC123");

    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> customerPasswordCustomPersistenceHandler.update(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).findProperty(eq("username"));
    verify(customerService).readCustomerByUsername(isNull());
  }

  /**
   * Test {@link CustomerPasswordCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPasswordCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity CustomerPasswordCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testUpdate_givenPropertyGetValueReturn42_thenCallsGetValue() throws ServiceException {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customerService.resetPassword(Mockito.<PasswordReset>any())).thenReturn(new CustomerImpl());
    when(customerService.readCustomerByUsername(Mockito.<String>any())).thenReturn(customer);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"username"}, "ABC123");

    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    customerPasswordCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao,
        new AdornedTargetListPersistenceModule());

    // Assert
    verify(entity, atLeast(1)).findProperty(eq("username"));
    verify(property, atLeast(1)).getValue();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customerService).readCustomerByUsername(eq("42"));
    verify(customerService).resetPassword(isA(PasswordReset.class));
  }
}
