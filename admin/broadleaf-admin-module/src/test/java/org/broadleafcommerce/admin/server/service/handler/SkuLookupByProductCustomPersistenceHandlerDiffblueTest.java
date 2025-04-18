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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SkuLookupByProductCustomPersistenceHandlerDiffblueTest {
  @Mock
  private CatalogService catalogService;

  @Mock
  private SkuCustomPersistenceHandler skuCustomPersistenceHandler;

  @InjectMocks
  private SkuLookupByProductCustomPersistenceHandler skuLookupByProductCustomPersistenceHandler;

  /**
   * Test {@link SkuLookupByProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <p>
   * Method under test: {@link SkuLookupByProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuLookupByProductCustomPersistenceHandler.canHandleFetch(PersistencePackage)"})
  public void testCanHandleFetch() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(skuLookupByProductCustomPersistenceHandler.canHandleFetch(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test {@link SkuLookupByProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Then calls {@link PersistencePackage#getCeilingEntityFullyQualifiedClassname()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuLookupByProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuLookupByProductCustomPersistenceHandler.canHandleFetch(PersistencePackage)"})
  public void testCanHandleFetch_thenCallsGetCeilingEntityFullyQualifiedClassname() {
    // Arrange
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});

    // Act
    Boolean actualCanHandleFetchResult = skuLookupByProductCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test {@link SkuLookupByProductCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given array of {@link Entity} with {@link Entity} (default constructor).</li>
   *   <li>Then return PromptSearch is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuLookupByProductCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet SkuLookupByProductCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch_givenArrayOfEntityWithEntity_thenReturnPromptSearchIsNull() throws ServiceException {
    // Arrange
    doNothing().when(skuCustomPersistenceHandler)
        .updateProductOptionFieldsForFetch(Mockito.<List<Serializable>>any(), Mockito.<Entity[]>any());
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    when(helper.getRecords(Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[]{new Entity()});

    // Act
    DynamicResultSet actualFetchResult = skuLookupByProductCustomPersistenceHandler.fetch(persistencePackage, cto,
        dynamicEntityDao, helper);

    // Assert
    verify(skuCustomPersistenceHandler).updateProductOptionFieldsForFetch(isA(List.class), isA(Entity[].class));
    verify(cto).getCriteriaMap();
    verify(persistencePackage).getPersistencePerspective();
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    assertNull(actualFetchResult.getPromptSearch());
    assertNull(actualFetchResult.getTotalCountLessThanPageSize());
    assertNull(actualFetchResult.getBatchId());
    assertNull(actualFetchResult.getLowerCount());
    assertNull(actualFetchResult.getUpperCount());
    assertNull(actualFetchResult.getFirstId());
    assertNull(actualFetchResult.getLastId());
    assertNull(actualFetchResult.getClassMetaData());
    assertNull(actualFetchResult.getFetchType());
    assertEquals(0, actualFetchResult.getPageSize().intValue());
    assertEquals(0, actualFetchResult.getStartIndex().intValue());
    assertEquals(1, actualFetchResult.getTotalRecords().intValue());
    assertEquals(1, actualFetchResult.getRecords().length);
    assertTrue(actualFetchResult.getUnselectedTabMetadata().isEmpty());
  }

  /**
   * Test {@link SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code java.text}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean SkuLookupByProductCustomPersistenceHandler.isRequestForSkusFilteredByProduct(PersistencePackage)"})
  public void testIsRequestForSkusFilteredByProduct_givenArrayOfStringWithJavaText() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setCustomCriteria(new String[]{"java.text"});

    // Act and Assert
    assertFalse(skuLookupByProductCustomPersistenceHandler.isRequestForSkusFilteredByProduct(persistencePackage));
  }

  /**
   * Test {@link SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}.
   * <ul>
   *   <li>Then calls {@link PersistencePackage#getCustomCriteria()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean SkuLookupByProductCustomPersistenceHandler.isRequestForSkusFilteredByProduct(PersistencePackage)"})
  public void testIsRequestForSkusFilteredByProduct_thenCallsGetCustomCriteria() {
    // Arrange
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});

    // Act
    boolean actualIsRequestForSkusFilteredByProductResult = skuLookupByProductCustomPersistenceHandler
        .isRequestForSkusFilteredByProduct(persistencePackage);

    // Assert
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualIsRequestForSkusFilteredByProductResult);
  }

  /**
   * Test {@link SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean SkuLookupByProductCustomPersistenceHandler.isRequestForSkusFilteredByProduct(PersistencePackage)"})
  public void testIsRequestForSkusFilteredByProduct_thenReturnTrue() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertTrue(skuLookupByProductCustomPersistenceHandler.isRequestForSkusFilteredByProduct(new PersistencePackage(
        "Dr Jane Doe", entity, new PersistencePerspective(), new String[]{"productFilterForSkus"}, "ABC123")));
  }

  /**
   * Test {@link SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean SkuLookupByProductCustomPersistenceHandler.isRequestForSkusFilteredByProduct(PersistencePackage)"})
  public void testIsRequestForSkusFilteredByProduct_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(skuLookupByProductCustomPersistenceHandler.isRequestForSkusFilteredByProduct(new PersistencePackage()));
  }

  /**
   * Test {@link SkuLookupByProductCustomPersistenceHandler#getOrder()}.
   * <p>
   * Method under test: {@link SkuLookupByProductCustomPersistenceHandler#getOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SkuLookupByProductCustomPersistenceHandler.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(2147483645, (new SkuLookupByProductCustomPersistenceHandler()).getOrder());
  }
}
