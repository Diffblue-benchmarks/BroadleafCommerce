/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.admin.server.persistence.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
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

public class HTMLFieldPersistenceProviderDiffblueTest {
  /**
   * Test
   * {@link HTMLFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HTMLFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testCanHandlePersistence_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HTMLFieldPersistenceProvider htmlFieldPersistenceProvider = new HTMLFieldPersistenceProvider();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act and Assert
    assertFalse(
        htmlFieldPersistenceProvider.canHandlePersistence(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Test
   * {@link HTMLFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HTMLFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HTMLFieldPersistenceProvider htmlFieldPersistenceProvider = new HTMLFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act and Assert
    assertFalse(htmlFieldPersistenceProvider.canHandleExtraction(extractValueRequest, new Property()));
  }

  /**
   * Test
   * {@link HTMLFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HTMLFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue_thenReturnNotHandled() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HTMLFieldPersistenceProvider htmlFieldPersistenceProvider = new HTMLFieldPersistenceProvider();
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
        htmlFieldPersistenceProvider.populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Test
   * {@link HTMLFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HTMLFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_thenReturnNotHandled() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HTMLFieldPersistenceProvider htmlFieldPersistenceProvider = new HTMLFieldPersistenceProvider();
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
        htmlFieldPersistenceProvider.extractValue(extractValueRequest, new Property()));
  }

  /**
   * Test {@link HTMLFieldPersistenceProvider#fixAssetPathsForStorage(String)}.
   * <p>
   * Method under test:
   * {@link HTMLFieldPersistenceProvider#fixAssetPathsForStorage(String)}
   */
  @Test
  public void testFixAssetPathsForStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Val", (new HTMLFieldPersistenceProvider()).fixAssetPathsForStorage("Val"));
  }

  /**
   * Test {@link HTMLFieldPersistenceProvider#fixAssetPathsForDisplay(String)}.
   * <p>
   * Method under test:
   * {@link HTMLFieldPersistenceProvider#fixAssetPathsForDisplay(String)}
   */
  @Test
  public void testFixAssetPathsForDisplay() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Val", (new HTMLFieldPersistenceProvider()).fixAssetPathsForDisplay("Val"));
  }

  /**
   * Test {@link HTMLFieldPersistenceProvider#getOrder()}.
   * <p>
   * Method under test: {@link HTMLFieldPersistenceProvider#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(60000, (new HTMLFieldPersistenceProvider()).getOrder());
  }
}
