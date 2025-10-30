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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.broadleafcommerce.profile.core.dao.RoleDao;
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
public class CustomerCustomPersistenceHandlerDiffblueTest {
  @InjectMocks
  private CustomerCustomPersistenceHandler customerCustomPersistenceHandler;

  @Mock
  private CustomerService customerService;

  @Mock
  private RoleDao roleDao;

  /**
   * Test {@link CustomerCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean CustomerCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(customerCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test {@link CustomerCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean CustomerCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(customerCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test {@link CustomerCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean CustomerCustomPersistenceHandler.canHandleRemove(PersistencePackage)"})
  public void testCanHandleRemove_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(customerCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test {@link CustomerCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#getType()} return array of {@link String} with {@code Type}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity CustomerCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testAdd_givenEntityGetTypeReturnArrayOfStringWithType_thenThrowServiceException()
      throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> customerCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).getType();
  }

  /**
   * Test {@link CustomerCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity CustomerCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testUpdate_thenThrowServiceException() throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getPrimaryKey(Mockito.<Entity>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn("Primary Key");
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> customerCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao, helper));
    verify(entity, atLeast(1)).getType();
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.profile.core.domain.Customer"), isNull());
  }

  /**
   * Test {@link CustomerCustomPersistenceHandler#validateUniqueUsername(Entity, Customer, boolean)}.
   * <ul>
   *   <li>Given {@code 42 Main St}.</li>
   *   <li>Then calls {@link Customer#getEmailAddress()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerCustomPersistenceHandler#validateUniqueUsername(Entity, Customer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity CustomerCustomPersistenceHandler.validateUniqueUsername(Entity, Customer, boolean)"})
  public void testValidateUniqueUsername_given42MainSt_thenCallsGetEmailAddress() {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    Customer adminInstance = mock(Customer.class);
    when(adminInstance.getEmailAddress()).thenReturn("42 Main St");

    // Act
    Entity actualValidateUniqueUsernameResult = customerCustomPersistenceHandler.validateUniqueUsername(entity,
        adminInstance, false);

    // Assert
    verify(entity).addValidationError(eq("emailAddress"), eq("nonUniqueUsernameError"));
    verify(entity).findProperty(eq("emailAddress"));
    verify(property).getValue();
    verify(adminInstance).getEmailAddress();
    verify(customerService).readCustomerByUsername(eq("42"));
    assertSame(entity, actualValidateUniqueUsernameResult);
  }

  /**
   * Test {@link CustomerCustomPersistenceHandler#validateUniqueUsername(Entity, Customer, boolean)}.
   * <ul>
   *   <li>Given {@link CustomerService} {@link CustomerService#readCustomerByUsername(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerCustomPersistenceHandler#validateUniqueUsername(Entity, Customer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity CustomerCustomPersistenceHandler.validateUniqueUsername(Entity, Customer, boolean)"})
  public void testValidateUniqueUsername_givenCustomerServiceReadCustomerByUsernameReturnNull() {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any())).thenReturn(null);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    Entity actualValidateUniqueUsernameResult = customerCustomPersistenceHandler.validateUniqueUsername(entity,
        new CustomerImpl(), true);

    // Assert
    verify(entity).findProperty(eq("emailAddress"));
    verify(customerService).readCustomerByUsername(isNull());
    assertNull(actualValidateUniqueUsernameResult);
  }

  /**
   * Test {@link CustomerCustomPersistenceHandler#validateUniqueUsername(Entity, Customer, boolean)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.</li>
   *   <li>Then return {@link Entity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerCustomPersistenceHandler#validateUniqueUsername(Entity, Customer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity CustomerCustomPersistenceHandler.validateUniqueUsername(Entity, Customer, boolean)"})
  public void testValidateUniqueUsername_givenPropertyGetValueReturn42_thenReturnEntity() {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    Entity actualValidateUniqueUsernameResult = customerCustomPersistenceHandler.validateUniqueUsername(entity,
        new CustomerImpl(), true);

    // Assert
    verify(entity).addValidationError(eq("emailAddress"), eq("nonUniqueUsernameError"));
    verify(entity).findProperty(eq("emailAddress"));
    verify(property).getValue();
    verify(customerService).readCustomerByUsername(eq("42"));
    assertSame(entity, actualValidateUniqueUsernameResult);
  }

  /**
   * Test {@link CustomerCustomPersistenceHandler#validateUniqueUsername(Entity, Customer, boolean)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.</li>
   *   <li>Then return {@link Entity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerCustomPersistenceHandler#validateUniqueUsername(Entity, Customer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity CustomerCustomPersistenceHandler.validateUniqueUsername(Entity, Customer, boolean)"})
  public void testValidateUniqueUsername_givenPropertyGetValueReturn42_thenReturnEntity2() {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    Entity actualValidateUniqueUsernameResult = customerCustomPersistenceHandler.validateUniqueUsername(entity,
        new CustomerImpl(), false);

    // Assert
    verify(entity).addValidationError(eq("emailAddress"), eq("nonUniqueUsernameError"));
    verify(entity).findProperty(eq("emailAddress"));
    verify(property).getValue();
    verify(customerService).readCustomerByUsername(eq("42"));
    assertSame(entity, actualValidateUniqueUsernameResult);
  }

  /**
   * Test {@link CustomerCustomPersistenceHandler#validateUniqueUsername(Entity, Customer, boolean)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerCustomPersistenceHandler#validateUniqueUsername(Entity, Customer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity CustomerCustomPersistenceHandler.validateUniqueUsername(Entity, Customer, boolean)"})
  public void testValidateUniqueUsername_givenPropertyGetValueReturnNull_thenReturnNull() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    Entity actualValidateUniqueUsernameResult = customerCustomPersistenceHandler.validateUniqueUsername(entity,
        new CustomerImpl(), false);

    // Assert
    verify(entity).findProperty(eq("emailAddress"));
    verify(property).getValue();
    assertNull(actualValidateUniqueUsernameResult);
  }

  /**
   * Test {@link CustomerCustomPersistenceHandler#validateUniqueUsername(Entity, Customer, boolean)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerCustomPersistenceHandler#validateUniqueUsername(Entity, Customer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity CustomerCustomPersistenceHandler.validateUniqueUsername(Entity, Customer, boolean)"})
  public void testValidateUniqueUsername_givenProperty_whenEntityFindPropertyReturnProperty() {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    Entity actualValidateUniqueUsernameResult = customerCustomPersistenceHandler.validateUniqueUsername(entity,
        new CustomerImpl(), true);

    // Assert
    verify(entity).addValidationError(eq("emailAddress"), eq("nonUniqueUsernameError"));
    verify(entity).findProperty(eq("emailAddress"));
    verify(customerService).readCustomerByUsername(isNull());
    assertSame(entity, actualValidateUniqueUsernameResult);
  }

  /**
   * Test {@link CustomerCustomPersistenceHandler#validateUniqueUsername(Entity, Customer, boolean)}.
   * <ul>
   *   <li>Then calls {@link Customer#getEmailAddress()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerCustomPersistenceHandler#validateUniqueUsername(Entity, Customer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity CustomerCustomPersistenceHandler.validateUniqueUsername(Entity, Customer, boolean)"})
  public void testValidateUniqueUsername_thenCallsGetEmailAddress() {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    Customer adminInstance = mock(Customer.class);
    when(adminInstance.getEmailAddress()).thenReturn("42 Main St");

    // Act
    Entity actualValidateUniqueUsernameResult = customerCustomPersistenceHandler.validateUniqueUsername(entity,
        adminInstance, false);

    // Assert
    verify(entity).addValidationError(eq("emailAddress"), eq("nonUniqueUsernameError"));
    verify(entity).findProperty(eq("emailAddress"));
    verify(property).getValue();
    verify(adminInstance).getEmailAddress();
    verify(customerService).readCustomerByUsername(isNull());
    assertSame(entity, actualValidateUniqueUsernameResult);
  }

  /**
   * Test {@link CustomerCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CustomerCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testRemove_givenProperty_thenThrowServiceException() throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"id"}, "ABC123");

    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> customerCustomPersistenceHandler.remove(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).findProperty(eq("id"));
    verify(entity).getType();
  }

  /**
   * Test {@link CustomerCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CustomerCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testRemove_thenCallsGetValue() throws ServiceException {
    // Arrange
    when(customerService.readCustomerById(Mockito.<Long>any())).thenReturn(new CustomerImpl());
    doNothing().when(roleDao).removeCustomerRolesByCustomerId(Mockito.<Long>any());
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"id"}, "ABC123");

    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    doNothing().when(adornedTargetListPersistenceModule).remove(Mockito.<PersistencePackage>any());
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any())).thenReturn(adornedTargetListPersistenceModule);

    // Act
    customerCustomPersistenceHandler.remove(persistencePackage, dynamicEntityDao, helper);

    // Assert
    verify(entity).findProperty(eq("id"));
    verify(property).getValue();
    verify(adornedTargetListPersistenceModule).remove(isA(PersistencePackage.class));
    verify(helper).getCompatibleModule(eq(OperationType.BASIC));
    verify(roleDao).removeCustomerRolesByCustomerId(eq(42L));
    verify(customerService).readCustomerById(eq(42L));
  }
}
