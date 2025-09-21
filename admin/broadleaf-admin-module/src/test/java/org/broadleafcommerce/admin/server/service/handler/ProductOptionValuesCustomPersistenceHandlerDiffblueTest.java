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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProductOptionValuesCustomPersistenceHandlerDiffblueTest {
  @InjectMocks
  private ProductOptionValuesCustomPersistenceHandler productOptionValuesCustomPersistenceHandler;

  /**
   * Test {@link ProductOptionValuesCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionValuesCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean ProductOptionValuesCustomPersistenceHandler.canHandleFetch(PersistencePackage)"
  })
  public void testCanHandleFetch_thenReturnFalse() {
    // Arrange
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act and Assert
    assertFalse(productOptionValuesCustomPersistenceHandler.canHandleFetch(persistencePackage));
  }

  /**
   * Test {@link ProductOptionValuesCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Then return {@link DynamicResultSet#DynamicResultSet()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionValuesCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet ProductOptionValuesCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"
  })
  public void testFetch_thenReturnDynamicResultSet() throws ServiceException {
    // Arrange
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[] {"Custom Criteria"});
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    when(adornedTargetListPersistenceModule.fetch(
            Mockito.<PersistencePackage>any(), Mockito.<CriteriaTransferObject>any()))
        .thenReturn(dynamicResultSet);

    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    DynamicResultSet actualFetchResult =
        productOptionValuesCustomPersistenceHandler.fetch(
            persistencePackage, cto, dynamicEntityDao, helper);

    // Assert
    verify(persistencePackage).getCustomCriteria();
    verify(adornedTargetListPersistenceModule)
        .fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
    assertSame(dynamicResultSet, actualFetchResult);
  }

  /**
   * Test {@link ProductOptionValuesCustomPersistenceHandler#getOptionKey(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code Custom Criteria}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionValuesCustomPersistenceHandler#getOptionKey(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ProductOptionValuesCustomPersistenceHandler.getOptionKey(PersistencePackage)"
  })
  public void testGetOptionKey_givenArrayOfStringWithCustomCriteria_thenReturnNull() {
    // Arrange
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[] {"Custom Criteria"});

    // Act
    Long actualOptionKey =
        productOptionValuesCustomPersistenceHandler.getOptionKey(persistencePackage);

    // Assert
    verify(persistencePackage).getCustomCriteria();
    assertNull(actualOptionKey);
  }
}
