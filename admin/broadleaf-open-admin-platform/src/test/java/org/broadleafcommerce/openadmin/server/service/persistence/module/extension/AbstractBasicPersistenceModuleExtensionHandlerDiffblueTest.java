/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.persistence.module.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractBasicPersistenceModuleExtensionHandlerDiffblueTest {
  /**
   * Test {@link AbstractBasicPersistenceModuleExtensionHandler#rebalanceForUpdate(BasicPersistenceModule, PersistencePackage, Serializable, Map, Object, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link AbstractBasicPersistenceModuleExtensionHandler#rebalanceForUpdate(BasicPersistenceModule, PersistencePackage, Serializable, Map, Object, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractBasicPersistenceModuleExtensionHandler.rebalanceForUpdate(BasicPersistenceModule, PersistencePackage, Serializable, Map, Object, ExtensionResultHolder)"})
  public void testRebalanceForUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AbstractBasicPersistenceModuleExtensionHandler abstractBasicPersistenceModuleExtensionHandler = new AbstractBasicPersistenceModuleExtensionHandler();
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    PersistencePackage persistencePackage = new PersistencePackage();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();

    ExtensionResultHolder<Serializable> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new SimpleDateFormat("yyyy/mm/dd"));
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractBasicPersistenceModuleExtensionHandler.rebalanceForUpdate(basicPersistenceModule, persistencePackage,
            instance, mergedProperties, "Primary Key", resultHolder));
  }

  /**
   * Test {@link AbstractBasicPersistenceModuleExtensionHandler#rebalanceForAdd(BasicPersistenceModule, PersistencePackage, Serializable, Map, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link AbstractBasicPersistenceModuleExtensionHandler#rebalanceForAdd(BasicPersistenceModule, PersistencePackage, Serializable, Map, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractBasicPersistenceModuleExtensionHandler.rebalanceForAdd(BasicPersistenceModule, PersistencePackage, Serializable, Map, ExtensionResultHolder)"})
  public void testRebalanceForAdd() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AbstractBasicPersistenceModuleExtensionHandler abstractBasicPersistenceModuleExtensionHandler = new AbstractBasicPersistenceModuleExtensionHandler();
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    PersistencePackage persistencePackage = new PersistencePackage();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();

    ExtensionResultHolder<Serializable> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new SimpleDateFormat("yyyy/mm/dd"));
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractBasicPersistenceModuleExtensionHandler
        .rebalanceForAdd(basicPersistenceModule, persistencePackage, instance, mergedProperties, resultHolder));
  }

  /**
   * Test new {@link AbstractBasicPersistenceModuleExtensionHandler} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link AbstractBasicPersistenceModuleExtensionHandler}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractBasicPersistenceModuleExtensionHandler.<init>()"})
  public void testNewAbstractBasicPersistenceModuleExtensionHandler() {
    // Arrange and Act
    AbstractBasicPersistenceModuleExtensionHandler actualAbstractBasicPersistenceModuleExtensionHandler = new AbstractBasicPersistenceModuleExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractBasicPersistenceModuleExtensionHandler.getPriority());
    assertTrue(actualAbstractBasicPersistenceModuleExtensionHandler.isEnabled());
  }
}
