/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.page.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class PageItemCriteriaImplDiffblueTest {
  /**
   * Test {@link PageItemCriteriaImpl#equals(Object)}, and
   * {@link PageItemCriteriaImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PageItemCriteriaImpl#equals(Object)}
   *   <li>{@link PageItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();
    pageItemCriteriaImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl.setMatchRule("Match Rule");
    pageItemCriteriaImpl.setPage(new PageImpl());
    pageItemCriteriaImpl.setQuantity(1);

    PageItemCriteriaImpl pageItemCriteriaImpl2 = new PageItemCriteriaImpl();
    pageItemCriteriaImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl2.setMatchRule("Match Rule");
    pageItemCriteriaImpl2.setPage(new PageImpl());
    pageItemCriteriaImpl2.setQuantity(1);

    // Act and Assert
    assertEquals(pageItemCriteriaImpl, pageItemCriteriaImpl2);
    int expectedHashCodeResult = pageItemCriteriaImpl.hashCode();
    assertEquals(expectedHashCodeResult, pageItemCriteriaImpl2.hashCode());
  }

  /**
   * Test {@link PageItemCriteriaImpl#equals(Object)}, and
   * {@link PageItemCriteriaImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PageItemCriteriaImpl#equals(Object)}
   *   <li>{@link PageItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();
    pageItemCriteriaImpl.setId(null);
    pageItemCriteriaImpl.setMatchRule("Match Rule");
    pageItemCriteriaImpl.setPage(new PageImpl());
    pageItemCriteriaImpl.setQuantity(1);

    PageItemCriteriaImpl pageItemCriteriaImpl2 = new PageItemCriteriaImpl();
    pageItemCriteriaImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl2.setMatchRule("Match Rule");
    pageItemCriteriaImpl2.setPage(new PageImpl());
    pageItemCriteriaImpl2.setQuantity(1);

    // Act and Assert
    assertEquals(pageItemCriteriaImpl, pageItemCriteriaImpl2);
    int notExpectedHashCodeResult = pageItemCriteriaImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, pageItemCriteriaImpl2.hashCode());
  }

  /**
   * Test {@link PageItemCriteriaImpl#equals(Object)}, and
   * {@link PageItemCriteriaImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PageItemCriteriaImpl#equals(Object)}
   *   <li>{@link PageItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();
    pageItemCriteriaImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl.setMatchRule("Match Rule");
    pageItemCriteriaImpl.setPage(mock(Page.class));
    pageItemCriteriaImpl.setQuantity(1);

    PageItemCriteriaImpl pageItemCriteriaImpl2 = new PageItemCriteriaImpl();
    pageItemCriteriaImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl2.setMatchRule("Match Rule");
    pageItemCriteriaImpl2.setPage(new PageImpl());
    pageItemCriteriaImpl2.setQuantity(1);

    // Act and Assert
    assertEquals(pageItemCriteriaImpl, pageItemCriteriaImpl2);
    int expectedHashCodeResult = pageItemCriteriaImpl.hashCode();
    assertEquals(expectedHashCodeResult, pageItemCriteriaImpl2.hashCode());
  }

  /**
   * Test {@link PageItemCriteriaImpl#equals(Object)}, and
   * {@link PageItemCriteriaImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PageItemCriteriaImpl#equals(Object)}
   *   <li>{@link PageItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();
    pageItemCriteriaImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl.setMatchRule("Match Rule");
    pageItemCriteriaImpl.setPage(new PageImpl());
    pageItemCriteriaImpl.setQuantity(1);

    PageItemCriteriaImpl pageItemCriteriaImpl2 = new PageItemCriteriaImpl();
    pageItemCriteriaImpl2.setId(null);
    pageItemCriteriaImpl2.setMatchRule("Match Rule");
    pageItemCriteriaImpl2.setPage(new PageImpl());
    pageItemCriteriaImpl2.setQuantity(1);

    // Act and Assert
    assertEquals(pageItemCriteriaImpl, pageItemCriteriaImpl2);
    int notExpectedHashCodeResult = pageItemCriteriaImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, pageItemCriteriaImpl2.hashCode());
  }

  /**
   * Test {@link PageItemCriteriaImpl#equals(Object)}, and
   * {@link PageItemCriteriaImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PageItemCriteriaImpl#equals(Object)}
   *   <li>{@link PageItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();
    pageItemCriteriaImpl.setId(null);
    pageItemCriteriaImpl.setMatchRule(null);
    pageItemCriteriaImpl.setPage(new PageImpl());
    pageItemCriteriaImpl.setQuantity(1);

    PageItemCriteriaImpl pageItemCriteriaImpl2 = new PageItemCriteriaImpl();
    pageItemCriteriaImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl2.setMatchRule(null);
    pageItemCriteriaImpl2.setPage(new PageImpl());
    pageItemCriteriaImpl2.setQuantity(1);

    // Act and Assert
    assertEquals(pageItemCriteriaImpl, pageItemCriteriaImpl2);
    int notExpectedHashCodeResult = pageItemCriteriaImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, pageItemCriteriaImpl2.hashCode());
  }

  /**
   * Test {@link PageItemCriteriaImpl#equals(Object)}, and
   * {@link PageItemCriteriaImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PageItemCriteriaImpl#equals(Object)}
   *   <li>{@link PageItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();
    pageItemCriteriaImpl.setId(null);
    pageItemCriteriaImpl.setMatchRule("Match Rule");
    pageItemCriteriaImpl.setPage(new PageImpl());
    pageItemCriteriaImpl.setQuantity(null);

    PageItemCriteriaImpl pageItemCriteriaImpl2 = new PageItemCriteriaImpl();
    pageItemCriteriaImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl2.setMatchRule("Match Rule");
    pageItemCriteriaImpl2.setPage(new PageImpl());
    pageItemCriteriaImpl2.setQuantity(null);

    // Act and Assert
    assertEquals(pageItemCriteriaImpl, pageItemCriteriaImpl2);
    int notExpectedHashCodeResult = pageItemCriteriaImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, pageItemCriteriaImpl2.hashCode());
  }

  /**
   * Test {@link PageItemCriteriaImpl#equals(Object)}, and
   * {@link PageItemCriteriaImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PageItemCriteriaImpl#equals(Object)}
   *   <li>{@link PageItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();
    pageItemCriteriaImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl.setMatchRule("Match Rule");
    pageItemCriteriaImpl.setPage(new PageImpl());
    pageItemCriteriaImpl.setQuantity(1);

    // Act and Assert
    assertEquals(pageItemCriteriaImpl, pageItemCriteriaImpl);
    int expectedHashCodeResult = pageItemCriteriaImpl.hashCode();
    assertEquals(expectedHashCodeResult, pageItemCriteriaImpl.hashCode());
  }

  /**
   * Test {@link PageItemCriteriaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageItemCriteriaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();
    pageItemCriteriaImpl.setId(2L);
    pageItemCriteriaImpl.setMatchRule("Match Rule");
    pageItemCriteriaImpl.setPage(new PageImpl());
    pageItemCriteriaImpl.setQuantity(1);

    PageItemCriteriaImpl pageItemCriteriaImpl2 = new PageItemCriteriaImpl();
    pageItemCriteriaImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl2.setMatchRule("Match Rule");
    pageItemCriteriaImpl2.setPage(new PageImpl());
    pageItemCriteriaImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(pageItemCriteriaImpl, pageItemCriteriaImpl2);
  }

  /**
   * Test {@link PageItemCriteriaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageItemCriteriaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();
    pageItemCriteriaImpl.setId(null);
    pageItemCriteriaImpl.setMatchRule(null);
    pageItemCriteriaImpl.setPage(new PageImpl());
    pageItemCriteriaImpl.setQuantity(1);

    PageItemCriteriaImpl pageItemCriteriaImpl2 = new PageItemCriteriaImpl();
    pageItemCriteriaImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl2.setMatchRule("Match Rule");
    pageItemCriteriaImpl2.setPage(new PageImpl());
    pageItemCriteriaImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(pageItemCriteriaImpl, pageItemCriteriaImpl2);
  }

  /**
   * Test {@link PageItemCriteriaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageItemCriteriaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();
    pageItemCriteriaImpl.setId(null);
    pageItemCriteriaImpl.setMatchRule("42");
    pageItemCriteriaImpl.setPage(new PageImpl());
    pageItemCriteriaImpl.setQuantity(1);

    PageItemCriteriaImpl pageItemCriteriaImpl2 = new PageItemCriteriaImpl();
    pageItemCriteriaImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl2.setMatchRule("Match Rule");
    pageItemCriteriaImpl2.setPage(new PageImpl());
    pageItemCriteriaImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(pageItemCriteriaImpl, pageItemCriteriaImpl2);
  }

  /**
   * Test {@link PageItemCriteriaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageItemCriteriaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();
    pageItemCriteriaImpl.setId(null);
    pageItemCriteriaImpl.setMatchRule("Match Rule");
    pageItemCriteriaImpl.setPage(new PageImpl());
    pageItemCriteriaImpl.setQuantity(0);

    PageItemCriteriaImpl pageItemCriteriaImpl2 = new PageItemCriteriaImpl();
    pageItemCriteriaImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl2.setMatchRule("Match Rule");
    pageItemCriteriaImpl2.setPage(new PageImpl());
    pageItemCriteriaImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(pageItemCriteriaImpl, pageItemCriteriaImpl2);
  }

  /**
   * Test {@link PageItemCriteriaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageItemCriteriaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();
    pageItemCriteriaImpl.setId(null);
    pageItemCriteriaImpl.setMatchRule("Match Rule");
    pageItemCriteriaImpl.setPage(new PageImpl());
    pageItemCriteriaImpl.setQuantity(null);

    PageItemCriteriaImpl pageItemCriteriaImpl2 = new PageItemCriteriaImpl();
    pageItemCriteriaImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl2.setMatchRule("Match Rule");
    pageItemCriteriaImpl2.setPage(new PageImpl());
    pageItemCriteriaImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(pageItemCriteriaImpl, pageItemCriteriaImpl2);
  }

  /**
   * Test {@link PageItemCriteriaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageItemCriteriaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();
    pageItemCriteriaImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl.setMatchRule("Match Rule");
    pageItemCriteriaImpl.setPage(new PageImpl());
    pageItemCriteriaImpl.setQuantity(1);

    // Act and Assert
    assertNotEquals(pageItemCriteriaImpl, null);
  }

  /**
   * Test {@link PageItemCriteriaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageItemCriteriaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();
    pageItemCriteriaImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl.setMatchRule("Match Rule");
    pageItemCriteriaImpl.setPage(new PageImpl());
    pageItemCriteriaImpl.setQuantity(1);

    // Act and Assert
    assertNotEquals(pageItemCriteriaImpl, "Different type to PageItemCriteriaImpl");
  }

  /**
   * Test {@link PageItemCriteriaImpl#cloneEntity()}.
   * <p>
   * Method under test: {@link PageItemCriteriaImpl#cloneEntity()}
   */
  @Test
  public void testCloneEntity() {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();

    // Act
    PageItemCriteria actualCloneEntityResult = pageItemCriteriaImpl.cloneEntity();

    // Assert
    assertTrue(actualCloneEntityResult instanceof PageItemCriteriaImpl);
    assertEquals(pageItemCriteriaImpl, actualCloneEntityResult);
  }

  /**
   * Test
   * {@link PageItemCriteriaImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link PageItemCriteriaImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<PageItemCriteria> actualCreateOrRetrieveCopyInstanceResult = pageItemCriteriaImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link PageItemCriteriaImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link PageItemCriteriaImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageItemCriteriaImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnPageItemCriteriaImpl() throws CloneNotSupportedException {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<PageItemCriteria> actualCreateOrRetrieveCopyInstanceResult = pageItemCriteriaImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.cms.page.domain.PageItemCriteriaImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    PageItemCriteria clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof PageItemCriteriaImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(pageItemCriteriaImpl, clone);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PageItemCriteriaImpl}
   *   <li>{@link PageItemCriteriaImpl#setId(Long)}
   *   <li>{@link PageItemCriteriaImpl#setMatchRule(String)}
   *   <li>{@link PageItemCriteriaImpl#setPage(Page)}
   *   <li>{@link PageItemCriteriaImpl#setQuantity(Integer)}
   *   <li>{@link PageItemCriteriaImpl#getId()}
   *   <li>{@link PageItemCriteriaImpl#getMatchRule()}
   *   <li>{@link PageItemCriteriaImpl#getPage()}
   *   <li>{@link PageItemCriteriaImpl#getQuantity()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PageItemCriteriaImpl actualPageItemCriteriaImpl = new PageItemCriteriaImpl();
    actualPageItemCriteriaImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    actualPageItemCriteriaImpl.setMatchRule("Match Rule");
    PageImpl page = new PageImpl();
    actualPageItemCriteriaImpl.setPage(page);
    actualPageItemCriteriaImpl.setQuantity(1);
    Long actualId = actualPageItemCriteriaImpl.getId();
    String actualMatchRule = actualPageItemCriteriaImpl.getMatchRule();
    Page actualPage = actualPageItemCriteriaImpl.getPage();

    // Assert that nothing has changed
    assertEquals("Match Rule", actualMatchRule);
    assertEquals(1, actualPageItemCriteriaImpl.getQuantity().intValue());
    assertEquals(PageItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(page, actualPage);
  }
}
