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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.service.ParentCategoryLegacyModeService;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryProductXref;
import org.broadleafcommerce.core.catalog.domain.CategoryProductXrefImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.ProductImpl;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FieldPath;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FieldPathBuilder;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FilterMapping;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.Restriction;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.predicate.PredicateProvider;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProductCustomPersistenceHandlerDiffblueTest {
  @InjectMocks
  private ProductCustomPersistenceHandler productCustomPersistenceHandler;

  @Mock
  private ParentCategoryLegacyModeService parentCategoryLegacyModeService;

  @Mock
  private CatalogService catalogService;

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleAdd(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd2() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleAdd(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"productDirectEdit"}, "ABC123")));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd3() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleAdd(
        new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(), new String[]{}, "ABC123")));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd_thenReturnTrue() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertTrue(productCustomPersistenceHandler
        .canHandleAdd(new PersistencePackage("org.broadleafcommerce.core.catalog.domain.Product", entity,
            new PersistencePerspective(), new String[]{"productDirectEdit"}, "ABC123")));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleUpdate(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate2() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleUpdate(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"productDirectEdit"}, "ABC123")));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate3() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleUpdate(
        new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(), new String[]{}, "ABC123")));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate_thenReturnTrue() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertTrue(productCustomPersistenceHandler
        .canHandleUpdate(new PersistencePackage("org.broadleafcommerce.core.catalog.domain.Product", entity,
            new PersistencePerspective(), new String[]{"productDirectEdit"}, "ABC123")));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductCustomPersistenceHandler.canHandleRemove(PersistencePackage)"})
  public void testCanHandleRemove() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleRemove(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductCustomPersistenceHandler.canHandleRemove(PersistencePackage)"})
  public void testCanHandleRemove2() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleRemove(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"productDirectEdit"}, "ABC123")));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductCustomPersistenceHandler.canHandleRemove(PersistencePackage)"})
  public void testCanHandleRemove3() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleRemove(
        new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(), new String[]{}, "ABC123")));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductCustomPersistenceHandler.canHandleRemove(PersistencePackage)"})
  public void testCanHandleRemove_thenReturnTrue() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertTrue(productCustomPersistenceHandler
        .canHandleRemove(new PersistencePackage("org.broadleafcommerce.core.catalog.domain.Product", entity,
            new PersistencePerspective(), new String[]{"productDirectEdit"}, "ABC123")));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductCustomPersistenceHandler.canHandleRemove(PersistencePackage)"})
  public void testCanHandleRemove_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductCustomPersistenceHandler.canHandleFetch(PersistencePackage)"})
  public void testCanHandleFetch() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleFetch(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductCustomPersistenceHandler.canHandleFetch(PersistencePackage)"})
  public void testCanHandleFetch2() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertTrue(productCustomPersistenceHandler.canHandleFetch(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"upsaleProduct"}, "ABC123")));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductCustomPersistenceHandler.canHandleFetch(PersistencePackage)"})
  public void testCanHandleFetch3() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleFetch(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"productDirectEdit"}, "ABC123")));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductCustomPersistenceHandler.canHandleFetch(PersistencePackage)"})
  public void testCanHandleFetch4() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleFetch(
        new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(), new String[]{}, "ABC123")));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductCustomPersistenceHandler.canHandleFetch(PersistencePackage)"})
  public void testCanHandleFetch5() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertTrue(productCustomPersistenceHandler
        .canHandleFetch(new PersistencePackage("org.broadleafcommerce.core.catalog.domain.Product", entity,
            new PersistencePerspective(), new String[]{"productDirectEdit"}, "ABC123")));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductCustomPersistenceHandler.canHandleInspect(PersistencePackage)"})
  public void testCanHandleInspect() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleInspect(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductCustomPersistenceHandler.canHandleInspect(PersistencePackage)"})
  public void testCanHandleInspect2() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleInspect(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"productDirectEdit"}, "ABC123")));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductCustomPersistenceHandler.canHandleInspect(PersistencePackage)"})
  public void testCanHandleInspect3() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleInspect(
        new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(), new String[]{}, "ABC123")));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductCustomPersistenceHandler.canHandleInspect(PersistencePackage)"})
  public void testCanHandleInspect_thenReturnTrue() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertTrue(productCustomPersistenceHandler
        .canHandleInspect(new PersistencePackage("org.broadleafcommerce.core.catalog.domain.Product", entity,
            new PersistencePerspective(), new String[]{"productDirectEdit"}, "ABC123")));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductCustomPersistenceHandler.canHandleInspect(PersistencePackage)"})
  public void testCanHandleInspect_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleInspect(new PersistencePackage()));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link ParentCategoryLegacyModeService} {@link ParentCategoryLegacyModeService#isLegacyMode()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet ProductCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch_givenParentCategoryLegacyModeServiceIsLegacyModeReturnFalse() throws ServiceException {
    // Arrange
    when(parentCategoryLegacyModeService.isLegacyMode()).thenReturn(false);
    Entity entity = new Entity();
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");

    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.fetch(Mockito.<PersistencePackage>any(),
        Mockito.<CriteriaTransferObject>any())).thenReturn(new DynamicResultSet());
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any())).thenReturn(adornedTargetListPersistenceModule);

    // Act
    productCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao, helper);

    // Assert
    verify(parentCategoryLegacyModeService).isLegacyMode();
    verify(adornedTargetListPersistenceModule).fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(eq(OperationType.BASIC));
    List<FilterMapping> nonCountAdditionalFilterMappings = cto.getNonCountAdditionalFilterMappings();
    assertEquals(1, nonCountAdditionalFilterMappings.size());
    FilterMapping getResult = nonCountAdditionalFilterMappings.get(0);
    assertNull(getResult.getInheritedFromClass());
    assertNull(getResult.getOrder());
    assertNull(getResult.getFullPropertyName());
    Restriction restriction = getResult.getRestriction();
    FieldPathBuilder fieldPathBuilder = restriction.getFieldPathBuilder();
    assertNull(fieldPathBuilder.getRestrictions());
    assertNull(fieldPathBuilder.getCriteria());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getFieldPath());
    assertNull(restriction.getFilterValueConverter());
    assertTrue(getResult.getDirectFilterValues().isEmpty());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getNullsLast());
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then {@link CriteriaTransferObject} (default constructor) NonCountAdditionalFilterMappings Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet ProductCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch_thenCriteriaTransferObjectNonCountAdditionalFilterMappingsEmpty() throws ServiceException {
    // Arrange
    Entity entity = new Entity();
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"upsaleProduct"}, "ABC123");

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
    DynamicResultSet actualFetchResult = productCustomPersistenceHandler.fetch(persistencePackage, cto,
        dynamicEntityDao, helper);

    // Assert
    verify(adornedTargetListPersistenceModule).fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(eq(OperationType.BASIC));
    assertTrue(cto.getNonCountAdditionalFilterMappings().isEmpty());
    assertSame(dynamicResultSet, actualFetchResult);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then {@link CriteriaTransferObject} (default constructor) NonCountAdditionalFilterMappings size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet ProductCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch_thenCriteriaTransferObjectNonCountAdditionalFilterMappingsSizeIsOne() throws ServiceException {
    // Arrange
    when(parentCategoryLegacyModeService.isLegacyMode()).thenReturn(true);
    Entity entity = new Entity();
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");

    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.fetch(Mockito.<PersistencePackage>any(),
        Mockito.<CriteriaTransferObject>any())).thenReturn(new DynamicResultSet());
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any())).thenReturn(adornedTargetListPersistenceModule);

    // Act
    productCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao, helper);

    // Assert
    verify(parentCategoryLegacyModeService).isLegacyMode();
    verify(adornedTargetListPersistenceModule).fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(eq(OperationType.BASIC));
    List<FilterMapping> nonCountAdditionalFilterMappings = cto.getNonCountAdditionalFilterMappings();
    assertEquals(1, nonCountAdditionalFilterMappings.size());
    FilterMapping getResult = nonCountAdditionalFilterMappings.get(0);
    assertNull(getResult.getInheritedFromClass());
    assertNull(getResult.getOrder());
    assertNull(getResult.getFullPropertyName());
    Restriction restriction = getResult.getRestriction();
    FieldPathBuilder fieldPathBuilder = restriction.getFieldPathBuilder();
    assertNull(fieldPathBuilder.getRestrictions());
    assertNull(fieldPathBuilder.getCriteria());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getFieldPath());
    assertNull(restriction.getFilterValueConverter());
    assertTrue(getResult.getDirectFilterValues().isEmpty());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getNullsLast());
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#getType()} return array of {@link String} with {@code Type}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity ProductCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testAdd_givenEntityGetTypeReturnArrayOfStringWithType_thenThrowServiceException()
      throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> productCustomPersistenceHandler.add(persistencePackage, dynamicEntityDao,
        new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).getType();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity ProductCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testUpdate_givenPropertyGetValueReturn42_thenCallsGetValue() throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to update entity for "}, "ABC123");

    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("defaultCategory", new BasicFieldMetadata());
    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getPrimaryKey(Mockito.<Entity>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn("Primary Key");
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(stringFieldMetadataMap);

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> productCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao, helper));
    verify(entity, atLeast(1)).findProperty(eq("defaultCategory"));
    verify(entity, atLeast(1)).getType();
    verify(property).getValue();
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Product"),
        isA(PersistencePerspective.class));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return empty string.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity ProductCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testUpdate_givenPropertyGetValueReturnEmptyString_thenCallsGetValue() throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to update entity for "}, "ABC123");

    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("defaultCategory", new BasicFieldMetadata());
    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getPrimaryKey(Mockito.<Entity>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn("Primary Key");
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(stringFieldMetadataMap);

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> productCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao, helper));
    verify(entity, atLeast(1)).findProperty(eq("defaultCategory"));
    verify(entity, atLeast(1)).getType();
    verify(property).getValue();
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Product"),
        isA(PersistencePerspective.class));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with name is {@code defaultCategory} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity ProductCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testUpdate_givenPropertyWithNameIsDefaultCategoryAndValueIs42() throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("defaultCategory", "42"));
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to update entity for "}, "ABC123");

    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("defaultCategory", new BasicFieldMetadata());
    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getPrimaryKey(Mockito.<Entity>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn("Primary Key");
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(stringFieldMetadataMap);

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> productCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao, helper));
    verify(entity, atLeast(1)).findProperty(eq("defaultCategory"));
    verify(entity, atLeast(1)).getType();
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Product"),
        isA(PersistencePerspective.class));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity ProductCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testUpdate_givenProperty_whenEntityFindPropertyReturnProperty() throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to update entity for "}, "ABC123");

    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("defaultCategory", new BasicFieldMetadata());
    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getPrimaryKey(Mockito.<Entity>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn("Primary Key");
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(stringFieldMetadataMap);

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> productCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao, helper));
    verify(entity, atLeast(1)).findProperty(eq("defaultCategory"));
    verify(entity, atLeast(1)).getType();
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Product"),
        isA(PersistencePerspective.class));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testRemove_thenThrowServiceException() throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getPrimaryKey(Mockito.<Entity>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn("Primary Key");
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> productCustomPersistenceHandler.remove(persistencePackage, dynamicEntityDao, helper));
    verify(entity, atLeast(1)).getType();
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Product"), isNull());
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeProduct(PersistencePackage, Product, RecordHelper)}.
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#removeProduct(PersistencePackage, Product, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductCustomPersistenceHandler.removeProduct(PersistencePackage, Product, RecordHelper)"})
  public void testRemoveProduct() throws ServiceException {
    // Arrange
    doNothing().when(catalogService).removeProduct(Mockito.<Product>any());
    PersistencePackage persistencePackage = new PersistencePackage();
    ProductBundleImpl adminInstance = new ProductBundleImpl();

    // Act
    productCustomPersistenceHandler.removeProduct(persistencePackage, adminInstance,
        new AdornedTargetListPersistenceModule());

    // Assert
    verify(catalogService).removeProduct(isA(Product.class));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#isDefaultCategoryLegacyMode()}.
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#isDefaultCategoryLegacyMode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductCustomPersistenceHandler.isDefaultCategoryLegacyMode()"})
  public void testIsDefaultCategoryLegacyMode() {
    // Arrange, Act and Assert
    assertFalse(productCustomPersistenceHandler.isDefaultCategoryLegacyMode());
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#modifyParentCategoryMetadata(Map)}.
   * <ul>
   *   <li>Given {@code defaultCategory}.</li>
   *   <li>Then {@link HashMap#HashMap()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#modifyParentCategoryMetadata(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductCustomPersistenceHandler.modifyParentCategoryMetadata(Map)"})
  public void testModifyParentCategoryMetadata_givenDefaultCategory_thenHashMapSizeIsOne() {
    // Arrange
    HashMap<String, FieldMetadata> md = new HashMap<>();
    md.put("defaultCategory", new BasicFieldMetadata());
    md.put("allParentCategoryXrefs", new AdornedTargetCollectionMetadata());

    // Act
    productCustomPersistenceHandler.modifyParentCategoryMetadata(md);

    // Assert
    assertEquals(1, md.size());
    FieldMetadata getResult = md.get("defaultCategory");
    assertTrue(getResult instanceof BasicFieldMetadata);
    assertEquals("ProductImpl_Parent_Category", getResult.getFriendlyName());
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#getExistingDefaultCategory(Product)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#getExistingDefaultCategory(Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.catalog.domain.Category ProductCustomPersistenceHandler.getExistingDefaultCategory(Product)"})
  public void testGetExistingDefaultCategory_whenProductBundleImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(productCustomPersistenceHandler.getExistingDefaultCategory(new ProductBundleImpl()));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryProductXrefImpl} (default constructor).</li>
   *   <li>When {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"})
  public void testRemoveOldDefault_givenArrayListAddCategoryProductXrefImpl_whenEntity() {
    // Arrange
    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(new CategoryProductXrefImpl());
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, new Entity());

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link CategoryProductXref}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"})
  public void testRemoveOldDefault_givenArrayList_whenCategoryProductXref() {
    // Arrange
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryProductXref oldDefault = mock(CategoryProductXref.class);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, new Entity());

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"})
  public void testRemoveOldDefault_givenArrayList_whenEntity() {
    // Arrange
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, new Entity());

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link ProductImpl#getAllParentCategoryXrefs()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"})
  public void testRemoveOldDefault_givenArrayList_whenNull_thenCallsGetAllParentCategoryXrefs() {
    // Arrange
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, null, new Entity());

    // Assert
    verify(adminInstance).getAllParentCategoryXrefs();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@link CategoryProductXrefImpl} {@link CategoryProductXrefImpl#getCategory()} return {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"})
  public void testRemoveOldDefault_givenCategoryProductXrefImplGetCategoryReturnCategoryImpl() {
    // Arrange
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getCategory()).thenReturn(new CategoryImpl());

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(categoryProductXrefImpl).getCategory();
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(entity, atLeast(1)).findProperty(eq("defaultCategory"));
    verify(property).getValue();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@link CategoryProductXrefImpl} {@link CategoryProductXrefImpl#getDefaultReference()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"})
  public void testRemoveOldDefault_givenCategoryProductXrefImplGetDefaultReferenceReturnFalse() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(false);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl, atLeast(1)).getDefaultReference();
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(entity, atLeast(1)).findProperty(eq("defaultCategory"));
    verify(property).getValue();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@link CategoryProductXrefImpl} {@link CategoryProductXrefImpl#getDefaultReference()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"})
  public void testRemoveOldDefault_givenCategoryProductXrefImplGetDefaultReferenceReturnNull() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(null);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl).getDefaultReference();
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(entity, atLeast(1)).findProperty(eq("defaultCategory"));
    verify(property).getValue();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@link CategoryProductXrefImpl} {@link CategoryProductXrefImpl#getDefaultReference()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"})
  public void testRemoveOldDefault_givenCategoryProductXrefImplGetDefaultReferenceReturnTrue() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl, atLeast(1)).getDefaultReference();
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(entity, atLeast(1)).findProperty(eq("defaultCategory"));
    verify(property).getValue();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"})
  public void testRemoveOldDefault_givenPropertyGetValueReturn42_thenCallsGetValue() {
    // Arrange
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(entity, atLeast(1)).findProperty(eq("defaultCategory"));
    verify(property).getValue();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return empty string.</li>
   *   <li>Then calls {@link ProductImpl#setCategory(Category)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"})
  public void testRemoveOldDefault_givenPropertyGetValueReturnEmptyString_thenCallsSetCategory() {
    // Arrange
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    doNothing().when(adminInstance).setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(adminInstance).setCategory(isNull());
    verify(entity, atLeast(1)).findProperty(eq("defaultCategory"));
    verify(property).getValue();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with name is {@code defaultCategory} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"})
  public void testRemoveOldDefault_givenPropertyWithNameIsDefaultCategoryAndValueIs42() {
    // Arrange
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("defaultCategory", "42"));

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(entity, atLeast(1)).findProperty(eq("defaultCategory"));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"})
  public void testRemoveOldDefault_givenProperty_whenEntityFindPropertyReturnProperty() {
    // Arrange
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    doNothing().when(adminInstance).setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(adminInstance).setCategory(isNull());
    verify(entity, atLeast(1)).findProperty(eq("defaultCategory"));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}.
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CategoryProductXref ProductCustomPersistenceHandler.getCurrentDefaultXref(Product)"})
  public void testGetCurrentDefaultXref() {
    // Arrange
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getCategory()).thenReturn(new CategoryImpl());

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    CategoryProductXref actualCurrentDefaultXref = productCustomPersistenceHandler.getCurrentDefaultXref(product);

    // Assert
    verify(categoryProductXrefImpl).getCategory();
    verify(product).getAllParentCategoryXrefs();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}.
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CategoryProductXref ProductCustomPersistenceHandler.getCurrentDefaultXref(Product)"})
  public void testGetCurrentDefaultXref2() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    productCustomPersistenceHandler.getCurrentDefaultXref(product);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl, atLeast(1)).getDefaultReference();
    verify(product).getAllParentCategoryXrefs();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}.
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CategoryProductXref ProductCustomPersistenceHandler.getCurrentDefaultXref(Product)"})
  public void testGetCurrentDefaultXref3() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(false);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    CategoryProductXref actualCurrentDefaultXref = productCustomPersistenceHandler.getCurrentDefaultXref(product);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl, atLeast(1)).getDefaultReference();
    verify(product).getAllParentCategoryXrefs();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}.
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CategoryProductXref ProductCustomPersistenceHandler.getCurrentDefaultXref(Product)"})
  public void testGetCurrentDefaultXref4() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(null);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    CategoryProductXref actualCurrentDefaultXref = productCustomPersistenceHandler.getCurrentDefaultXref(product);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl).getDefaultReference();
    verify(product).getAllParentCategoryXrefs();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryProductXrefImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CategoryProductXref ProductCustomPersistenceHandler.getCurrentDefaultXref(Product)"})
  public void testGetCurrentDefaultXref_givenArrayListAddCategoryProductXrefImpl() {
    // Arrange
    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(new CategoryProductXrefImpl());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    CategoryProductXref actualCurrentDefaultXref = productCustomPersistenceHandler.getCurrentDefaultXref(product);

    // Assert
    verify(product).getAllParentCategoryXrefs();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CategoryProductXref ProductCustomPersistenceHandler.getCurrentDefaultXref(Product)"})
  public void testGetCurrentDefaultXref_givenArrayList_thenReturnNull() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());

    // Act
    CategoryProductXref actualCurrentDefaultXref = productCustomPersistenceHandler.getCurrentDefaultXref(product);

    // Assert
    verify(product).getAllParentCategoryXrefs();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CategoryProductXref ProductCustomPersistenceHandler.getCurrentDefaultXref(Product)"})
  public void testGetCurrentDefaultXref_whenProductBundleImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(productCustomPersistenceHandler.getCurrentDefaultXref(new ProductBundleImpl()));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#isRecursiveProductSelection(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#isRecursiveProductSelection(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductCustomPersistenceHandler.isRecursiveProductSelection(PersistencePackage)"})
  public void testIsRecursiveProductSelection_thenReturnFalse() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.isRecursiveProductSelection(new PersistencePackage("Dr Jane Doe",
        entity, new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#isRecursiveProductSelection(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#isRecursiveProductSelection(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductCustomPersistenceHandler.isRecursiveProductSelection(PersistencePackage)"})
  public void testIsRecursiveProductSelection_thenReturnTrue() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertTrue(productCustomPersistenceHandler.isRecursiveProductSelection(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"upsaleProduct"}, "ABC123")));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#createFilterMappingForProperty(String, PredicateProvider)}.
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#createFilterMappingForProperty(String, PredicateProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FilterMapping ProductCustomPersistenceHandler.createFilterMappingForProperty(String, PredicateProvider)"})
  public void testCreateFilterMappingForProperty() {
    // Arrange
    PredicateProvider predicateProvider = mock(PredicateProvider.class);

    // Act
    FilterMapping actualCreateFilterMappingForPropertyResult = productCustomPersistenceHandler
        .createFilterMappingForProperty("Target Property Name", predicateProvider);

    // Assert
    FieldPath fieldPath = actualCreateFilterMappingForPropertyResult.getFieldPath();
    assertEquals("Target Property Name", fieldPath.getTargetProperty());
    assertNull(actualCreateFilterMappingForPropertyResult.getInheritedFromClass());
    assertNull(actualCreateFilterMappingForPropertyResult.getOrder());
    assertNull(actualCreateFilterMappingForPropertyResult.getFullPropertyName());
    assertNull(actualCreateFilterMappingForPropertyResult.getSortDirection());
    Restriction restriction = actualCreateFilterMappingForPropertyResult.getRestriction();
    assertNull(restriction.getFilterValueConverter());
    assertTrue(fieldPath.getAssociationPath().isEmpty());
    assertTrue(fieldPath.getTargetPropertyPieces().isEmpty());
    assertTrue(actualCreateFilterMappingForPropertyResult.getDirectFilterValues().isEmpty());
    assertTrue(actualCreateFilterMappingForPropertyResult.getFilterValues().isEmpty());
    assertTrue(actualCreateFilterMappingForPropertyResult.getNullsLast());
    assertSame(predicateProvider, restriction.getPredicateProvider());
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#getFilteredDynamicResultSet(PersistencePackage, CriteriaTransferObject, RecordHelper)}.
   * <ul>
   *   <li>Then return {@link DynamicResultSet#DynamicResultSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#getFilteredDynamicResultSet(PersistencePackage, CriteriaTransferObject, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet ProductCustomPersistenceHandler.getFilteredDynamicResultSet(PersistencePackage, CriteriaTransferObject, RecordHelper)"})
  public void testGetFilteredDynamicResultSet_thenReturnDynamicResultSet() throws ServiceException {
    // Arrange
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);
    CriteriaTransferObject cto = new CriteriaTransferObject();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    when(adornedTargetListPersistenceModule.fetch(Mockito.<PersistencePackage>any(),
        Mockito.<CriteriaTransferObject>any())).thenReturn(dynamicResultSet);
    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any())).thenReturn(adornedTargetListPersistenceModule);

    // Act
    DynamicResultSet actualFilteredDynamicResultSet = productCustomPersistenceHandler
        .getFilteredDynamicResultSet(persistencePackage, cto, helper);

    // Assert
    verify(persistencePerspective).getOperationTypes();
    verify(adornedTargetListPersistenceModule).fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(eq(OperationType.BASIC));
    assertSame(dynamicResultSet, actualFilteredDynamicResultSet);
  }
}
