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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FieldPath;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FieldPathBuilder;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FilterMapping;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.Restriction;
import org.junit.Test;
import org.mockito.Mockito;

public class ISOCountryPersistenceHandlerDiffblueTest {
  /**
   * Test {@link ISOCountryPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link ISOCountryPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ISOCountryPersistenceHandler isoCountryPersistenceHandler = new ISOCountryPersistenceHandler();
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(isoCountryPersistenceHandler.canHandleFetch(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test {@link ISOCountryPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Then calls
   * {@link PersistencePackage#getCeilingEntityFullyQualifiedClassname()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ISOCountryPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_thenCallsGetCeilingEntityFullyQualifiedClassname() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ISOCountryPersistenceHandler isoCountryPersistenceHandler = new ISOCountryPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleFetchResult = isoCountryPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test
   * {@link ISOCountryPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then {@link CriteriaTransferObject} (default constructor)
   * AdditionalFilterMappings size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ISOCountryPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch_thenCriteriaTransferObjectAdditionalFilterMappingsSizeIsTwo() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ISOCountryPersistenceHandler isoCountryPersistenceHandler = new ISOCountryPersistenceHandler();
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);
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
    DynamicResultSet actualFetchResult = isoCountryPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(persistencePerspective).getOperationTypes();
    verify(adornedTargetListPersistenceModule).fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(eq(OperationType.BASIC));
    List<FilterMapping> additionalFilterMappings = cto.getAdditionalFilterMappings();
    assertEquals(2, additionalFilterMappings.size());
    FilterMapping getResult = additionalFilterMappings.get(0);
    FieldPath fieldPath = getResult.getFieldPath();
    assertEquals("name", fieldPath.getTargetProperty());
    assertNull(getResult.getInheritedFromClass());
    FilterMapping getResult2 = additionalFilterMappings.get(1);
    assertNull(getResult2.getInheritedFromClass());
    assertNull(getResult.getOrder());
    assertNull(getResult2.getOrder());
    assertNull(getResult.getFullPropertyName());
    assertNull(getResult2.getFullPropertyName());
    Restriction restriction = getResult.getRestriction();
    FieldPathBuilder fieldPathBuilder = restriction.getFieldPathBuilder();
    assertNull(fieldPathBuilder.getRestrictions());
    Restriction restriction2 = getResult2.getRestriction();
    FieldPathBuilder fieldPathBuilder2 = restriction2.getFieldPathBuilder();
    assertNull(fieldPathBuilder2.getRestrictions());
    assertNull(fieldPathBuilder.getCriteria());
    assertNull(fieldPathBuilder2.getCriteria());
    assertNull(getResult.getSortDirection());
    assertNull(getResult2.getSortDirection());
    assertNull(getResult2.getFieldPath());
    assertNull(restriction.getFilterValueConverter());
    assertNull(restriction2.getFilterValueConverter());
    assertTrue(fieldPath.getAssociationPath().isEmpty());
    assertTrue(fieldPath.getTargetPropertyPieces().isEmpty());
    assertTrue(getResult.getDirectFilterValues().isEmpty());
    assertTrue(getResult2.getDirectFilterValues().isEmpty());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult2.getFilterValues().isEmpty());
    assertTrue(getResult.getNullsLast());
    assertTrue(getResult2.getNullsLast());
    assertSame(dynamicResultSet, actualFetchResult);
  }
}
