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
package org.broadleafcommerce.admin.web.controller.inventory;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.openadmin.dto.FilterAndSortCriteria;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdminInventoryBasicOperationsControllerDiffblueTest {
  @InjectMocks
  private AdminInventoryBasicOperationsController adminInventoryBasicOperationsController;

  @Mock private CatalogService catalogService;

  /**
   * Test {@link
   * AdminInventoryBasicOperationsController#modifyFetchPersistencePackageRequest(PersistencePackageRequest,
   * Map)}.
   *
   * <p>Method under test: {@link
   * AdminInventoryBasicOperationsController#modifyFetchPersistencePackageRequest(PersistencePackageRequest,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminInventoryBasicOperationsController.modifyFetchPersistencePackageRequest(PersistencePackageRequest, Map)"
  })
  public void testModifyFetchPersistencePackageRequest() {
    // Arrange
    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getFilterAndSortCriteria())
        .thenReturn(new FilterAndSortCriteria[] {new FilterAndSortCriteria("42")});
    when(ppr.addFilterAndSortCriteria(Mockito.<FilterAndSortCriteria>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    ppr.addFilterAndSortCriteria(new FilterAndSortCriteria("42"));

    // Act
    adminInventoryBasicOperationsController.modifyFetchPersistencePackageRequest(
        ppr, new HashMap<>());

    // Assert
    verify(ppr).addFilterAndSortCriteria(isA(FilterAndSortCriteria.class));
    verify(ppr, atLeast(1)).getFilterAndSortCriteria();
  }

  /**
   * Test {@link
   * AdminInventoryBasicOperationsController#modifyFetchPersistencePackageRequest(PersistencePackageRequest,
   * Map)}.
   *
   * <p>Method under test: {@link
   * AdminInventoryBasicOperationsController#modifyFetchPersistencePackageRequest(PersistencePackageRequest,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminInventoryBasicOperationsController.modifyFetchPersistencePackageRequest(PersistencePackageRequest, Map)"
  })
  public void testModifyFetchPersistencePackageRequest2() {
    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(new ProductBundleImpl());
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(skuImpl);

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("inventory");

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});
    when(ppr.getFilterAndSortCriteria())
        .thenReturn(new FilterAndSortCriteria[] {new FilterAndSortCriteria("inventoryParameter")});
    when(ppr.addFilterAndSortCriteria(Mockito.<FilterAndSortCriteria>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    ppr.addFilterAndSortCriteria(new FilterAndSortCriteria("42"));

    // Act
    adminInventoryBasicOperationsController.modifyFetchPersistencePackageRequest(
        ppr, new HashMap<>());

    // Assert
    verify(catalogService).findSkuById(42L);
    verify(ppr).addFilterAndSortCriteria(isA(FilterAndSortCriteria.class));
    verify(ppr, atLeast(1)).getFilterAndSortCriteria();
    verify(ppr).getSectionCrumbs();
  }

  /**
   * Test {@link
   * AdminInventoryBasicOperationsController#modifyFetchPersistencePackageRequest(PersistencePackageRequest,
   * Map)}.
   *
   * <p>Method under test: {@link
   * AdminInventoryBasicOperationsController#modifyFetchPersistencePackageRequest(PersistencePackageRequest,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminInventoryBasicOperationsController.modifyFetchPersistencePackageRequest(PersistencePackageRequest, Map)"
  })
  public void testModifyFetchPersistencePackageRequest3() {
    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setFulfillmentType(new FulfillmentType("fulfillmentType", "fulfillmentType"));
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(skuImpl);

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("inventory");

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});
    when(ppr.getFilterAndSortCriteria())
        .thenReturn(new FilterAndSortCriteria[] {new FilterAndSortCriteria("inventoryParameter")});
    when(ppr.addFilterAndSortCriteria(Mockito.<FilterAndSortCriteria>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    ppr.addFilterAndSortCriteria(new FilterAndSortCriteria("42"));

    // Act
    adminInventoryBasicOperationsController.modifyFetchPersistencePackageRequest(
        ppr, new HashMap<>());

    // Assert
    verify(catalogService).findSkuById(42L);
    verify(ppr, atLeast(1)).addFilterAndSortCriteria(Mockito.<FilterAndSortCriteria>any());
    verify(ppr, atLeast(1)).getFilterAndSortCriteria();
    verify(ppr).getSectionCrumbs();
  }

  /**
   * Test {@link
   * AdminInventoryBasicOperationsController#modifyFetchPersistencePackageRequest(PersistencePackageRequest,
   * Map)}.
   *
   * <ul>
   *   <li>Given empty array of {@link SectionCrumb}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminInventoryBasicOperationsController#modifyFetchPersistencePackageRequest(PersistencePackageRequest,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminInventoryBasicOperationsController.modifyFetchPersistencePackageRequest(PersistencePackageRequest, Map)"
  })
  public void testModifyFetchPersistencePackageRequest_givenEmptyArrayOfSectionCrumb() {
    // Arrange
    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getSectionCrumbs()).thenReturn(new SectionCrumb[] {});
    when(ppr.getFilterAndSortCriteria())
        .thenReturn(new FilterAndSortCriteria[] {new FilterAndSortCriteria("inventoryParameter")});
    when(ppr.addFilterAndSortCriteria(Mockito.<FilterAndSortCriteria>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    ppr.addFilterAndSortCriteria(new FilterAndSortCriteria("42"));

    // Act
    adminInventoryBasicOperationsController.modifyFetchPersistencePackageRequest(
        ppr, new HashMap<>());

    // Assert
    verify(ppr).addFilterAndSortCriteria(isA(FilterAndSortCriteria.class));
    verify(ppr, atLeast(1)).getFilterAndSortCriteria();
    verify(ppr).getSectionCrumbs();
  }

  /**
   * Test {@link
   * AdminInventoryBasicOperationsController#modifyFetchPersistencePackageRequest(PersistencePackageRequest,
   * Map)}.
   *
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor) SectionIdentifier is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminInventoryBasicOperationsController#modifyFetchPersistencePackageRequest(PersistencePackageRequest,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminInventoryBasicOperationsController.modifyFetchPersistencePackageRequest(PersistencePackageRequest, Map)"
  })
  public void testModifyFetchPersistencePackageRequest_givenSectionCrumbSectionIdentifierIs42() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});
    when(ppr.getFilterAndSortCriteria())
        .thenReturn(new FilterAndSortCriteria[] {new FilterAndSortCriteria("inventoryParameter")});
    when(ppr.addFilterAndSortCriteria(Mockito.<FilterAndSortCriteria>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    ppr.addFilterAndSortCriteria(new FilterAndSortCriteria("42"));

    // Act
    adminInventoryBasicOperationsController.modifyFetchPersistencePackageRequest(
        ppr, new HashMap<>());

    // Assert
    verify(ppr).addFilterAndSortCriteria(isA(FilterAndSortCriteria.class));
    verify(ppr, atLeast(1)).getFilterAndSortCriteria();
    verify(ppr).getSectionCrumbs();
  }

  /**
   * Test {@link
   * AdminInventoryBasicOperationsController#modifyFetchPersistencePackageRequest(PersistencePackageRequest,
   * Map)}.
   *
   * <ul>
   *   <li>Then calls {@link CatalogService#findSkuById(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminInventoryBasicOperationsController#modifyFetchPersistencePackageRequest(PersistencePackageRequest,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminInventoryBasicOperationsController.modifyFetchPersistencePackageRequest(PersistencePackageRequest, Map)"
  })
  public void testModifyFetchPersistencePackageRequest_thenCallsFindSkuById() {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("inventory");

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getSectionCrumbs()).thenReturn(new SectionCrumb[] {sectionCrumb});
    when(ppr.getFilterAndSortCriteria())
        .thenReturn(new FilterAndSortCriteria[] {new FilterAndSortCriteria("inventoryParameter")});
    when(ppr.addFilterAndSortCriteria(Mockito.<FilterAndSortCriteria>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    ppr.addFilterAndSortCriteria(new FilterAndSortCriteria("42"));

    // Act
    adminInventoryBasicOperationsController.modifyFetchPersistencePackageRequest(
        ppr, new HashMap<>());

    // Assert
    verify(catalogService).findSkuById(42L);
    verify(ppr).addFilterAndSortCriteria(isA(FilterAndSortCriteria.class));
    verify(ppr, atLeast(1)).getFilterAndSortCriteria();
    verify(ppr).getSectionCrumbs();
  }

  /**
   * Test {@link
   * AdminInventoryBasicOperationsController#modifyFetchPersistencePackageRequest(PersistencePackageRequest,
   * Map)}.
   *
   * <ul>
   *   <li>Then calls {@link FilterAndSortCriteria#getPropertyId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminInventoryBasicOperationsController#modifyFetchPersistencePackageRequest(PersistencePackageRequest,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminInventoryBasicOperationsController.modifyFetchPersistencePackageRequest(PersistencePackageRequest, Map)"
  })
  public void testModifyFetchPersistencePackageRequest_thenCallsGetPropertyId() {
    // Arrange
    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getPropertyId()).thenReturn("42");

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getFilterAndSortCriteria())
        .thenReturn(new FilterAndSortCriteria[] {filterAndSortCriteria});
    when(ppr.addFilterAndSortCriteria(Mockito.<FilterAndSortCriteria>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    ppr.addFilterAndSortCriteria(new FilterAndSortCriteria("42"));

    // Act
    adminInventoryBasicOperationsController.modifyFetchPersistencePackageRequest(
        ppr, new HashMap<>());

    // Assert
    verify(filterAndSortCriteria, atLeast(1)).getPropertyId();
    verify(ppr).addFilterAndSortCriteria(isA(FilterAndSortCriteria.class));
    verify(ppr, atLeast(1)).getFilterAndSortCriteria();
  }
}
