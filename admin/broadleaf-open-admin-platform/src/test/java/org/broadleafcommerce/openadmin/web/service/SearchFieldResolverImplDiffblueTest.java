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
package org.broadleafcommerce.openadmin.web.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
import org.broadleafcommerce.openadmin.server.service.AdminEntityService;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SearchFieldResolverImplDiffblueTest {
  @Mock
  private AdminEntityService adminEntityService;

  @InjectMocks
  private SearchFieldResolverImpl searchFieldResolverImpl;

  /**
   * Test {@link SearchFieldResolverImpl#resolveField(String)}.
   * <ul>
   *   <li>Then return {@code id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchFieldResolverImpl#resolveField(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SearchFieldResolverImpl.resolveField(String)"})
  public void testResolveField_thenReturnId() throws ServiceException {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);

    // Act
    String actualResolveFieldResult = searchFieldResolverImpl.resolveField("Class Name");

    // Assert
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    assertEquals("id", actualResolveFieldResult);
  }

  /**
   * Test {@link SearchFieldResolverImpl#resolveField(String)}.
   * <ul>
   *   <li>Then return {@code name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchFieldResolverImpl#resolveField(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SearchFieldResolverImpl.resolveField(String)"})
  public void testResolveField_thenReturnName() throws ServiceException {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{new Property("name", "42")});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);

    // Act
    String actualResolveFieldResult = searchFieldResolverImpl.resolveField("Class Name");

    // Assert
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    assertEquals("name", actualResolveFieldResult);
  }
}
