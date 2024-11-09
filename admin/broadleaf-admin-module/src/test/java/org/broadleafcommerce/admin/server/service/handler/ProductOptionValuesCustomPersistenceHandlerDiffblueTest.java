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
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Test;
import org.mockito.Mockito;

public class ProductOptionValuesCustomPersistenceHandlerDiffblueTest {
  /**
   * Test
   * {@link ProductOptionValuesCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link ProductOptionValuesCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValuesCustomPersistenceHandler productOptionValuesCustomPersistenceHandler = new ProductOptionValuesCustomPersistenceHandler();
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(productOptionValuesCustomPersistenceHandler.canHandleFetch(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test
   * {@link ProductOptionValuesCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Then calls
   * {@link PersistencePackage#getCeilingEntityFullyQualifiedClassname()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValuesCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_thenCallsGetCeilingEntityFullyQualifiedClassname() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValuesCustomPersistenceHandler productOptionValuesCustomPersistenceHandler = new ProductOptionValuesCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleFetchResult = productOptionValuesCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test
   * {@link ProductOptionValuesCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then return {@link DynamicResultSet#DynamicResultSet()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValuesCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch_thenReturnDynamicResultSet() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValuesCustomPersistenceHandler productOptionValuesCustomPersistenceHandler = new ProductOptionValuesCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    when(adornedTargetListPersistenceModule.fetch(Mockito.<PersistencePackage>any(),
        Mockito.<CriteriaTransferObject>any())).thenReturn(dynamicResultSet);
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any())).thenReturn(adornedTargetListPersistenceModule);

    // Act
    DynamicResultSet actualFetchResult = productOptionValuesCustomPersistenceHandler.fetch(persistencePackage, cto,
        dynamicEntityDao, helper);

    // Assert
    verify(persistencePackage).getCustomCriteria();
    verify(adornedTargetListPersistenceModule).fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(eq(OperationType.BASIC));
    assertSame(dynamicResultSet, actualFetchResult);
  }

  /**
   * Test
   * {@link ProductOptionValuesCustomPersistenceHandler#getOptionKey(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code Custom Criteria}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValuesCustomPersistenceHandler#getOptionKey(PersistencePackage)}
   */
  @Test
  public void testGetOptionKey_givenArrayOfStringWithCustomCriteria_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValuesCustomPersistenceHandler productOptionValuesCustomPersistenceHandler = new ProductOptionValuesCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});

    // Act
    Long actualOptionKey = productOptionValuesCustomPersistenceHandler.getOptionKey(persistencePackage);

    // Assert
    verify(persistencePackage).getCustomCriteria();
    assertNull(actualOptionKey);
  }
}
