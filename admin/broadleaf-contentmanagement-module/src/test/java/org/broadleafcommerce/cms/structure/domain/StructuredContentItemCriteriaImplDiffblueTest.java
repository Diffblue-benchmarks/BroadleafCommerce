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
package org.broadleafcommerce.cms.structure.domain;

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

public class StructuredContentItemCriteriaImplDiffblueTest {
  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}, and
   * {@link StructuredContentItemCriteriaImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StructuredContentItemCriteriaImpl#equals(Object)}
   *   <li>{@link StructuredContentItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl = new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(1);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 = new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(1);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl2);
    int expectedHashCodeResult = structuredContentItemCriteriaImpl.hashCode();
    assertEquals(expectedHashCodeResult, structuredContentItemCriteriaImpl2.hashCode());
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}, and
   * {@link StructuredContentItemCriteriaImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StructuredContentItemCriteriaImpl#equals(Object)}
   *   <li>{@link StructuredContentItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl = new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(null);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(1);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 = new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(1);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl2);
    int notExpectedHashCodeResult = structuredContentItemCriteriaImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, structuredContentItemCriteriaImpl2.hashCode());
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}, and
   * {@link StructuredContentItemCriteriaImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StructuredContentItemCriteriaImpl#equals(Object)}
   *   <li>{@link StructuredContentItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl = new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(1);
    structuredContentItemCriteriaImpl.setStructuredContent(mock(StructuredContent.class));

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 = new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(1);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl2);
    int expectedHashCodeResult = structuredContentItemCriteriaImpl.hashCode();
    assertEquals(expectedHashCodeResult, structuredContentItemCriteriaImpl2.hashCode());
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}, and
   * {@link StructuredContentItemCriteriaImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StructuredContentItemCriteriaImpl#equals(Object)}
   *   <li>{@link StructuredContentItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl = new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(1);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 = new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(null);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(1);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl2);
    int notExpectedHashCodeResult = structuredContentItemCriteriaImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, structuredContentItemCriteriaImpl2.hashCode());
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}, and
   * {@link StructuredContentItemCriteriaImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StructuredContentItemCriteriaImpl#equals(Object)}
   *   <li>{@link StructuredContentItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl = new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(null);
    structuredContentItemCriteriaImpl.setMatchRule(null);
    structuredContentItemCriteriaImpl.setQuantity(1);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 = new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl2.setMatchRule(null);
    structuredContentItemCriteriaImpl2.setQuantity(1);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl2);
    int notExpectedHashCodeResult = structuredContentItemCriteriaImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, structuredContentItemCriteriaImpl2.hashCode());
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}, and
   * {@link StructuredContentItemCriteriaImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StructuredContentItemCriteriaImpl#equals(Object)}
   *   <li>{@link StructuredContentItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl = new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(null);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(null);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 = new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(null);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl2);
    int notExpectedHashCodeResult = structuredContentItemCriteriaImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, structuredContentItemCriteriaImpl2.hashCode());
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}, and
   * {@link StructuredContentItemCriteriaImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StructuredContentItemCriteriaImpl#equals(Object)}
   *   <li>{@link StructuredContentItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl = new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(1);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl);
    int expectedHashCodeResult = structuredContentItemCriteriaImpl.hashCode();
    assertEquals(expectedHashCodeResult, structuredContentItemCriteriaImpl.hashCode());
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentItemCriteriaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl = new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(2L);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(1);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 = new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(1);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertNotEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl2);
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentItemCriteriaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl = new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(null);
    structuredContentItemCriteriaImpl.setMatchRule(null);
    structuredContentItemCriteriaImpl.setQuantity(1);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 = new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(1);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertNotEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl2);
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentItemCriteriaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl = new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(null);
    structuredContentItemCriteriaImpl.setMatchRule("42");
    structuredContentItemCriteriaImpl.setQuantity(1);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 = new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(1);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertNotEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl2);
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentItemCriteriaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl = new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(null);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(0);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 = new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(1);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertNotEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl2);
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentItemCriteriaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl = new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(null);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(null);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 = new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(1);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertNotEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl2);
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentItemCriteriaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl = new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(1);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertNotEquals(structuredContentItemCriteriaImpl, null);
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentItemCriteriaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl = new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(1);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertNotEquals(structuredContentItemCriteriaImpl, "Different type to StructuredContentItemCriteriaImpl");
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#cloneEntity()}.
   * <p>
   * Method under test: {@link StructuredContentItemCriteriaImpl#cloneEntity()}
   */
  @Test
  public void testCloneEntity() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl = new StructuredContentItemCriteriaImpl();

    // Act
    StructuredContentItemCriteria actualCloneEntityResult = structuredContentItemCriteriaImpl.cloneEntity();

    // Assert
    assertTrue(actualCloneEntityResult instanceof StructuredContentItemCriteriaImpl);
    assertEquals(structuredContentItemCriteriaImpl, actualCloneEntityResult);
  }

  /**
   * Test
   * {@link StructuredContentItemCriteriaImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link StructuredContentItemCriteriaImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl = new StructuredContentItemCriteriaImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<StructuredContentItemCriteria> actualCreateOrRetrieveCopyInstanceResult = structuredContentItemCriteriaImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.cms.structure.domain.StructuredContentItemCriteriaImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    StructuredContentItemCriteria clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof StructuredContentItemCriteriaImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(structuredContentItemCriteriaImpl, clone);
  }

  /**
   * Test
   * {@link StructuredContentItemCriteriaImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link StructuredContentItemCriteriaImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl = new StructuredContentItemCriteriaImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StructuredContentItemCriteria> actualCreateOrRetrieveCopyInstanceResult = structuredContentItemCriteriaImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link StructuredContentItemCriteriaImpl}
   *   <li>{@link StructuredContentItemCriteriaImpl#setId(Long)}
   *   <li>{@link StructuredContentItemCriteriaImpl#setMatchRule(String)}
   *   <li>{@link StructuredContentItemCriteriaImpl#setQuantity(Integer)}
   *   <li>
   * {@link StructuredContentItemCriteriaImpl#setStructuredContent(StructuredContent)}
   *   <li>{@link StructuredContentItemCriteriaImpl#getId()}
   *   <li>{@link StructuredContentItemCriteriaImpl#getMatchRule()}
   *   <li>{@link StructuredContentItemCriteriaImpl#getQuantity()}
   *   <li>{@link StructuredContentItemCriteriaImpl#getStructuredContent()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    StructuredContentItemCriteriaImpl actualStructuredContentItemCriteriaImpl = new StructuredContentItemCriteriaImpl();
    actualStructuredContentItemCriteriaImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    actualStructuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    actualStructuredContentItemCriteriaImpl.setQuantity(1);
    StructuredContentImpl structuredContent = new StructuredContentImpl();
    actualStructuredContentItemCriteriaImpl.setStructuredContent(structuredContent);
    Long actualId = actualStructuredContentItemCriteriaImpl.getId();
    String actualMatchRule = actualStructuredContentItemCriteriaImpl.getMatchRule();
    Integer actualQuantity = actualStructuredContentItemCriteriaImpl.getQuantity();
    StructuredContent actualStructuredContent = actualStructuredContentItemCriteriaImpl.getStructuredContent();

    // Assert that nothing has changed
    assertEquals("Match Rule", actualMatchRule);
    assertEquals(1, actualQuantity.intValue());
    assertEquals(StructuredContentItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(structuredContent, actualStructuredContent);
  }
}
