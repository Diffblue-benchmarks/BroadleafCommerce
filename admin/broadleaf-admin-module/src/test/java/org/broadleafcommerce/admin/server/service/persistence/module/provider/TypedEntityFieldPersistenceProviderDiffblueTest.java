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
package org.broadleafcommerce.admin.server.service.persistence.module.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceException;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.ExtractValueRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.PopulateValueRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.junit.Test;
import org.mockito.Mockito;

public class TypedEntityFieldPersistenceProviderDiffblueTest {
  /**
   * Test
   * {@link TypedEntityFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TypedEntityFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TypedEntityFieldPersistenceProvider typedEntityFieldPersistenceProvider = new TypedEntityFieldPersistenceProvider();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        typedEntityFieldPersistenceProvider.populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Test
   * {@link TypedEntityFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TypedEntityFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_thenReturnNotHandled() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TypedEntityFieldPersistenceProvider typedEntityFieldPersistenceProvider = new TypedEntityFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        typedEntityFieldPersistenceProvider.extractValue(extractValueRequest, new Property()));
  }

  /**
   * Test
   * {@link TypedEntityFieldPersistenceProvider#checkDirtyState(PopulateValueRequest, Object, Object)}.
   * <ul>
   *   <li>Given {@code Check Value}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TypedEntityFieldPersistenceProvider#checkDirtyState(PopulateValueRequest, Object, Object)}
   */
  @Test
  public void testCheckDirtyState_givenCheckValue_thenReturnFalse() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TypedEntityFieldPersistenceProvider typedEntityFieldPersistenceProvider = new TypedEntityFieldPersistenceProvider();
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn("Check Value");
    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act
    boolean actualCheckDirtyStateResult = typedEntityFieldPersistenceProvider
        .checkDirtyState(new PopulateValueRequest(true, fieldManager, property, metadata, returnType, "42",
            persistenceManager, dataFormatProvider, true, new Entity()), "Instance", "Check Value");

    // Assert
    verify(fieldManager).getFieldValue(isA(Object.class), isNull());
    assertFalse(actualCheckDirtyStateResult);
  }

  /**
   * Test
   * {@link TypedEntityFieldPersistenceProvider#checkDirtyState(PopulateValueRequest, Object, Object)}.
   * <ul>
   *   <li>Given {@code Field Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TypedEntityFieldPersistenceProvider#checkDirtyState(PopulateValueRequest, Object, Object)}
   */
  @Test
  public void testCheckDirtyState_givenFieldValue() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TypedEntityFieldPersistenceProvider typedEntityFieldPersistenceProvider = new TypedEntityFieldPersistenceProvider();
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn("Field Value");
    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act
    boolean actualCheckDirtyStateResult = typedEntityFieldPersistenceProvider
        .checkDirtyState(new PopulateValueRequest(true, fieldManager, property, metadata, returnType, "42",
            persistenceManager, dataFormatProvider, true, new Entity()), "Instance", "Check Value");

    // Assert
    verify(fieldManager).getFieldValue(isA(Object.class), isNull());
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test
   * {@link TypedEntityFieldPersistenceProvider#checkDirtyState(PopulateValueRequest, Object, Object)}.
   * <ul>
   *   <li>Given {@code /}.</li>
   *   <li>When {@link FieldManager}
   * {@link FieldManager#getFieldValue(Object, String)} return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TypedEntityFieldPersistenceProvider#checkDirtyState(PopulateValueRequest, Object, Object)}
   */
  @Test
  public void testCheckDirtyState_givenSlash_whenFieldManagerGetFieldValueReturnSlash() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TypedEntityFieldPersistenceProvider typedEntityFieldPersistenceProvider = new TypedEntityFieldPersistenceProvider();
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn(" /");
    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act
    boolean actualCheckDirtyStateResult = typedEntityFieldPersistenceProvider
        .checkDirtyState(new PopulateValueRequest(true, fieldManager, property, metadata, returnType, "42",
            persistenceManager, dataFormatProvider, true, new Entity()), "Instance", "Check Value");

    // Assert
    verify(fieldManager).getFieldValue(isA(Object.class), isNull());
    assertTrue(actualCheckDirtyStateResult);
  }

  /**
   * Test {@link TypedEntityFieldPersistenceProvider#getOrder()}.
   * <p>
   * Method under test: {@link TypedEntityFieldPersistenceProvider#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(2147482647, (new TypedEntityFieldPersistenceProvider()).getOrder());
  }

  /**
   * Test
   * {@link TypedEntityFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TypedEntityFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testCanHandlePersistence_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TypedEntityFieldPersistenceProvider typedEntityFieldPersistenceProvider = new TypedEntityFieldPersistenceProvider();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act and Assert
    assertFalse(typedEntityFieldPersistenceProvider.canHandlePersistence(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd")));
  }
}
