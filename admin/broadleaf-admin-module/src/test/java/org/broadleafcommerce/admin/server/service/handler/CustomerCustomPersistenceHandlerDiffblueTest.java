/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.server.service.handler;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.junit.Test;
import org.mockito.Mockito;

public class CustomerCustomPersistenceHandlerDiffblueTest {
  /**
   * Test
   * {@link CustomerCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   *   <li>Then calls
   * {@link PersistencePackage#getCeilingEntityFullyQualifiedClassname()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_givenDrJaneDoe_thenCallsGetCeilingEntityFullyQualifiedClassname() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerCustomPersistenceHandler customerCustomPersistenceHandler = new CustomerCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleAddResult = customerCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Test
   * {@link CustomerCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerCustomPersistenceHandler customerCustomPersistenceHandler = new CustomerCustomPersistenceHandler();

    // Act and Assert
    assertFalse(customerCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test
   * {@link CustomerCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Then calls
   * {@link PersistencePackage#getCeilingEntityFullyQualifiedClassname()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_thenCallsGetCeilingEntityFullyQualifiedClassname() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerCustomPersistenceHandler customerCustomPersistenceHandler = new CustomerCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleUpdateResult = customerCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test
   * {@link CustomerCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerCustomPersistenceHandler customerCustomPersistenceHandler = new CustomerCustomPersistenceHandler();

    // Act and Assert
    assertFalse(customerCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test
   * {@link CustomerCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>Then calls
   * {@link PersistencePackage#getCeilingEntityFullyQualifiedClassname()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove_thenCallsGetCeilingEntityFullyQualifiedClassname() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerCustomPersistenceHandler customerCustomPersistenceHandler = new CustomerCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleRemoveResult = customerCustomPersistenceHandler.canHandleRemove(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleRemoveResult);
  }

  /**
   * Test
   * {@link CustomerCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerCustomPersistenceHandler customerCustomPersistenceHandler = new CustomerCustomPersistenceHandler();

    // Act and Assert
    assertFalse(customerCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test
   * {@link CustomerCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#getType()} return array of
   * {@link String} with {@code Type}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd_givenEntityGetTypeReturnArrayOfStringWithType_thenThrowServiceException()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerCustomPersistenceHandler customerCustomPersistenceHandler = new CustomerCustomPersistenceHandler();
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
   * Test
   * {@link CustomerCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testUpdate_thenThrowServiceException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerCustomPersistenceHandler customerCustomPersistenceHandler = new CustomerCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getEntity()).thenReturn(entity);
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getPrimaryKey(Mockito.<Entity>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn("Primary Key");
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> customerCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao, helper));
    verify(entity, atLeast(1)).getType();
    verify(persistencePackage).getEntity();
    verify(persistencePackage).getPersistencePerspective();
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.profile.core.domain.Customer"),
        isA(PersistencePerspective.class));
  }

  /**
   * Test
   * {@link CustomerCustomPersistenceHandler#validateUniqueUsername(Entity, Customer, boolean)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerCustomPersistenceHandler#validateUniqueUsername(Entity, Customer, boolean)}
   */
  @Test
  public void testValidateUniqueUsername_given42_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerCustomPersistenceHandler customerCustomPersistenceHandler = new CustomerCustomPersistenceHandler();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    Customer adminInstance = mock(Customer.class);
    when(adminInstance.getEmailAddress()).thenReturn("42");

    // Act
    Entity actualValidateUniqueUsernameResult = customerCustomPersistenceHandler.validateUniqueUsername(entity,
        adminInstance, false);

    // Assert
    verify(entity).findProperty(eq("emailAddress"));
    verify(property).getValue();
    verify(adminInstance).getEmailAddress();
    assertNull(actualValidateUniqueUsernameResult);
  }

  /**
   * Test
   * {@link CustomerCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#findProperty(String)} return
   * {@link Property#Property()}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testRemove_givenEntityFindPropertyReturnProperty_thenThrowServiceException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerCustomPersistenceHandler customerCustomPersistenceHandler = new CustomerCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getEntity()).thenReturn(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> customerCustomPersistenceHandler.remove(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).findProperty(eq("id"));
    verify(entity).getType();
    verify(persistencePackage).getEntity();
  }
}
