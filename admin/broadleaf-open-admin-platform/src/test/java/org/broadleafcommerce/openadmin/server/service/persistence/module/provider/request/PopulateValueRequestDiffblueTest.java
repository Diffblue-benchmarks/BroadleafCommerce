/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.junit.Test;

public class PopulateValueRequestDiffblueTest {
  /**
   * Test {@link PopulateValueRequest#getSetId()}.
   * <p>
   * Method under test: {@link PopulateValueRequest#getSetId()}
   */
  @Test
  public void testGetSetId() {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act and Assert
    assertFalse((new PopulateValueRequest(false, fieldManager, property, metadata, returnType, "42", persistenceManager,
        dataFormatProvider, true, new Entity())).getSetId());
  }

  /**
   * Test {@link PopulateValueRequest#getSetId()}.
   * <p>
   * Method under test: {@link PopulateValueRequest#getSetId()}
   */
  @Test
  public void testGetSetId2() {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act and Assert
    assertFalse((new PopulateValueRequest(null, fieldManager, property, metadata, returnType, "42", persistenceManager,
        dataFormatProvider, true, new Entity())).getSetId());
  }

  /**
   * Test {@link PopulateValueRequest#getSetId()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PopulateValueRequest#getSetId()}
   */
  @Test
  public void testGetSetId_thenReturnTrue() {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act and Assert
    assertTrue((new PopulateValueRequest(true, fieldManager, property, metadata, returnType, "42", persistenceManager,
        dataFormatProvider, true, new Entity())).getSetId());
  }

  /**
   * Test {@link PopulateValueRequest#getPreAdd()}.
   * <p>
   * Method under test: {@link PopulateValueRequest#getPreAdd()}
   */
  @Test
  public void testGetPreAdd() {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act and Assert
    assertFalse((new PopulateValueRequest(true, fieldManager, property, metadata, returnType, "42", persistenceManager,
        dataFormatProvider, false, new Entity())).getPreAdd());
  }

  /**
   * Test {@link PopulateValueRequest#getPreAdd()}.
   * <p>
   * Method under test: {@link PopulateValueRequest#getPreAdd()}
   */
  @Test
  public void testGetPreAdd2() {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act and Assert
    assertFalse((new PopulateValueRequest(true, fieldManager, property, metadata, returnType, "42", persistenceManager,
        dataFormatProvider, null, new Entity())).getPreAdd());
  }

  /**
   * Test {@link PopulateValueRequest#getPreAdd()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PopulateValueRequest#getPreAdd()}
   */
  @Test
  public void testGetPreAdd_thenReturnTrue() {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act and Assert
    assertTrue((new PopulateValueRequest(true, fieldManager, property, metadata, returnType, "42", persistenceManager,
        dataFormatProvider, true, new Entity())).getPreAdd());
  }
}
