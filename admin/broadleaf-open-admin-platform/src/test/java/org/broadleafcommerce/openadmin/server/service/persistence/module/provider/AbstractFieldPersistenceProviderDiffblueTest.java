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
package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.HashMap;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.PersistencePerspectiveItem;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.RestrictionFactory;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.AddSearchMappingRequest;
import org.junit.Test;
import org.mockito.Mockito;

public class AbstractFieldPersistenceProviderDiffblueTest {
  /**
   * Test {@link AbstractFieldPersistenceProvider#alwaysRun()}.
   * <ul>
   *   <li>Given {@link BasicFieldPersistenceProvider} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractFieldPersistenceProvider#alwaysRun()}
   */
  @Test
  public void testAlwaysRun_givenBasicFieldPersistenceProvider() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BasicFieldPersistenceProvider()).alwaysRun());
  }

  /**
   * Test {@link AbstractFieldPersistenceProvider#alwaysRun()}.
   * <ul>
   *   <li>Then calls
   * {@link PersistencePerspective#addPersistencePerspectiveItem(PersistencePerspectiveItemType, PersistencePerspectiveItem)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractFieldPersistenceProvider#alwaysRun()}
   */
  @Test
  public void testAlwaysRun_thenCallsAddPersistencePerspectiveItem() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    doNothing().when(persistencePerspective)
        .addPersistencePerspectiveItem(Mockito.<PersistencePerspectiveItemType>any(),
            Mockito.<PersistencePerspectiveItem>any());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());
    CriteriaTransferObject requestedCto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    AddSearchMappingRequest addSearchMappingRequest = new AddSearchMappingRequest(persistencePerspective, requestedCto,
        "Dr Jane Doe", mergedProperties, "Property Name", fieldManager, dataFormatProvider,
        new AdornedTargetListPersistenceModule(), mock(RestrictionFactory.class));

    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();
    basicFieldPersistenceProvider.addSearchMapping(addSearchMappingRequest, new ArrayList<>());

    // Act
    boolean actualAlwaysRunResult = basicFieldPersistenceProvider.alwaysRun();

    // Assert
    verify(persistencePerspective).addPersistencePerspectiveItem(eq(PersistencePerspectiveItemType.FOREIGNKEY),
        isA(PersistencePerspectiveItem.class));
    assertFalse(actualAlwaysRunResult);
  }

  /**
   * Test {@link AbstractFieldPersistenceProvider#canHandlePopulateNull()}.
   * <ul>
   *   <li>Given {@link BasicFieldPersistenceProvider} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFieldPersistenceProvider#canHandlePopulateNull()}
   */
  @Test
  public void testCanHandlePopulateNull_givenBasicFieldPersistenceProvider_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BasicFieldPersistenceProvider()).canHandlePopulateNull());
  }

  /**
   * Test {@link AbstractFieldPersistenceProvider#canHandlePopulateNull()}.
   * <ul>
   *   <li>Given {@link MapFieldPersistenceProvider} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFieldPersistenceProvider#canHandlePopulateNull()}
   */
  @Test
  public void testCanHandlePopulateNull_givenMapFieldPersistenceProvider_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new MapFieldPersistenceProvider()).canHandlePopulateNull());
  }

  /**
   * Test {@link AbstractFieldPersistenceProvider#canHandlePopulateNull()}.
   * <ul>
   *   <li>Then calls
   * {@link PersistencePerspective#addPersistencePerspectiveItem(PersistencePerspectiveItemType, PersistencePerspectiveItem)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFieldPersistenceProvider#canHandlePopulateNull()}
   */
  @Test
  public void testCanHandlePopulateNull_thenCallsAddPersistencePerspectiveItem() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    doNothing().when(persistencePerspective)
        .addPersistencePerspectiveItem(Mockito.<PersistencePerspectiveItemType>any(),
            Mockito.<PersistencePerspectiveItem>any());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());
    CriteriaTransferObject requestedCto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    AddSearchMappingRequest addSearchMappingRequest = new AddSearchMappingRequest(persistencePerspective, requestedCto,
        "Dr Jane Doe", mergedProperties, "Property Name", fieldManager, dataFormatProvider,
        new AdornedTargetListPersistenceModule(), mock(RestrictionFactory.class));

    BasicFieldPersistenceProvider basicFieldPersistenceProvider = new BasicFieldPersistenceProvider();
    basicFieldPersistenceProvider.addSearchMapping(addSearchMappingRequest, new ArrayList<>());

    // Act
    boolean actualCanHandlePopulateNullResult = basicFieldPersistenceProvider.canHandlePopulateNull();

    // Assert
    verify(persistencePerspective).addPersistencePerspectiveItem(eq(PersistencePerspectiveItemType.FOREIGNKEY),
        isA(PersistencePerspectiveItem.class));
    assertFalse(actualCanHandlePopulateNullResult);
  }
}
