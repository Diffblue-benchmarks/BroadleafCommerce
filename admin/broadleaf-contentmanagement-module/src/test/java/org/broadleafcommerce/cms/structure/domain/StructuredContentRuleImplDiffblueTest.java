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

public class StructuredContentRuleImplDiffblueTest {
  /**
   * Test {@link StructuredContentRuleImpl#equals(Object)}, and
   * {@link StructuredContentRuleImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StructuredContentRuleImpl#equals(Object)}
   *   <li>{@link StructuredContentRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StructuredContentRuleImpl structuredContentRuleImpl = new StructuredContentRuleImpl();
    structuredContentRuleImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentRuleImpl.setMatchRule("Match Rule");

    StructuredContentRuleImpl structuredContentRuleImpl2 = new StructuredContentRuleImpl();
    structuredContentRuleImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(structuredContentRuleImpl, structuredContentRuleImpl2);
    int expectedHashCodeResult = structuredContentRuleImpl.hashCode();
    assertEquals(expectedHashCodeResult, structuredContentRuleImpl2.hashCode());
  }

  /**
   * Test {@link StructuredContentRuleImpl#equals(Object)}, and
   * {@link StructuredContentRuleImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StructuredContentRuleImpl#equals(Object)}
   *   <li>{@link StructuredContentRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    StructuredContentRuleImpl structuredContentRuleImpl = new StructuredContentRuleImpl();
    structuredContentRuleImpl.setId(null);
    structuredContentRuleImpl.setMatchRule("Match Rule");

    StructuredContentRuleImpl structuredContentRuleImpl2 = new StructuredContentRuleImpl();
    structuredContentRuleImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(structuredContentRuleImpl, structuredContentRuleImpl2);
    int notExpectedHashCodeResult = structuredContentRuleImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, structuredContentRuleImpl2.hashCode());
  }

  /**
   * Test {@link StructuredContentRuleImpl#equals(Object)}, and
   * {@link StructuredContentRuleImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StructuredContentRuleImpl#equals(Object)}
   *   <li>{@link StructuredContentRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    StructuredContentRuleImpl structuredContentRuleImpl = new StructuredContentRuleImpl();
    structuredContentRuleImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentRuleImpl.setMatchRule("Match Rule");

    StructuredContentRuleImpl structuredContentRuleImpl2 = new StructuredContentRuleImpl();
    structuredContentRuleImpl2.setId(null);
    structuredContentRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(structuredContentRuleImpl, structuredContentRuleImpl2);
    int notExpectedHashCodeResult = structuredContentRuleImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, structuredContentRuleImpl2.hashCode());
  }

  /**
   * Test {@link StructuredContentRuleImpl#equals(Object)}, and
   * {@link StructuredContentRuleImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StructuredContentRuleImpl#equals(Object)}
   *   <li>{@link StructuredContentRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    StructuredContentRuleImpl structuredContentRuleImpl = new StructuredContentRuleImpl();
    structuredContentRuleImpl.setId(null);
    structuredContentRuleImpl.setMatchRule(null);

    StructuredContentRuleImpl structuredContentRuleImpl2 = new StructuredContentRuleImpl();
    structuredContentRuleImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentRuleImpl2.setMatchRule(null);

    // Act and Assert
    assertEquals(structuredContentRuleImpl, structuredContentRuleImpl2);
    int notExpectedHashCodeResult = structuredContentRuleImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, structuredContentRuleImpl2.hashCode());
  }

  /**
   * Test {@link StructuredContentRuleImpl#equals(Object)}, and
   * {@link StructuredContentRuleImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StructuredContentRuleImpl#equals(Object)}
   *   <li>{@link StructuredContentRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StructuredContentRuleImpl structuredContentRuleImpl = new StructuredContentRuleImpl();
    structuredContentRuleImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentRuleImpl.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(structuredContentRuleImpl, structuredContentRuleImpl);
    int expectedHashCodeResult = structuredContentRuleImpl.hashCode();
    assertEquals(expectedHashCodeResult, structuredContentRuleImpl.hashCode());
  }

  /**
   * Test {@link StructuredContentRuleImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentRuleImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StructuredContentRuleImpl structuredContentRuleImpl = new StructuredContentRuleImpl();
    structuredContentRuleImpl.setId(2L);
    structuredContentRuleImpl.setMatchRule("Match Rule");

    StructuredContentRuleImpl structuredContentRuleImpl2 = new StructuredContentRuleImpl();
    structuredContentRuleImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(structuredContentRuleImpl, structuredContentRuleImpl2);
  }

  /**
   * Test {@link StructuredContentRuleImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentRuleImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    StructuredContentRuleImpl structuredContentRuleImpl = new StructuredContentRuleImpl();
    structuredContentRuleImpl.setId(null);
    structuredContentRuleImpl.setMatchRule(null);

    StructuredContentRuleImpl structuredContentRuleImpl2 = new StructuredContentRuleImpl();
    structuredContentRuleImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(structuredContentRuleImpl, structuredContentRuleImpl2);
  }

  /**
   * Test {@link StructuredContentRuleImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentRuleImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    StructuredContentRuleImpl structuredContentRuleImpl = new StructuredContentRuleImpl();
    structuredContentRuleImpl.setId(null);
    structuredContentRuleImpl.setMatchRule("42");

    StructuredContentRuleImpl structuredContentRuleImpl2 = new StructuredContentRuleImpl();
    structuredContentRuleImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(structuredContentRuleImpl, structuredContentRuleImpl2);
  }

  /**
   * Test {@link StructuredContentRuleImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentRuleImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    StructuredContentRuleImpl structuredContentRuleImpl = new StructuredContentRuleImpl();
    structuredContentRuleImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentRuleImpl.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(structuredContentRuleImpl, null);
  }

  /**
   * Test {@link StructuredContentRuleImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentRuleImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    StructuredContentRuleImpl structuredContentRuleImpl = new StructuredContentRuleImpl();
    structuredContentRuleImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentRuleImpl.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(structuredContentRuleImpl, "Different type to StructuredContentRuleImpl");
  }

  /**
   * Test {@link StructuredContentRuleImpl#cloneEntity()}.
   * <p>
   * Method under test: {@link StructuredContentRuleImpl#cloneEntity()}
   */
  @Test
  public void testCloneEntity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentRuleImpl structuredContentRuleImpl = new StructuredContentRuleImpl();

    // Act
    StructuredContentRule actualCloneEntityResult = structuredContentRuleImpl.cloneEntity();

    // Assert
    assertTrue(actualCloneEntityResult instanceof StructuredContentRuleImpl);
    assertEquals(structuredContentRuleImpl, actualCloneEntityResult);
  }

  /**
   * Test
   * {@link StructuredContentRuleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link StructuredContentRuleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentRuleImpl structuredContentRuleImpl = new StructuredContentRuleImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StructuredContentRule> actualCreateOrRetrieveCopyInstanceResult = structuredContentRuleImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link StructuredContentRuleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link StructuredContentRuleImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentRuleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnStructuredContentRuleImpl()
      throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentRuleImpl structuredContentRuleImpl = new StructuredContentRuleImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<StructuredContentRule> actualCreateOrRetrieveCopyInstanceResult = structuredContentRuleImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.cms.structure.domain.StructuredContentRuleImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    StructuredContentRule clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof StructuredContentRuleImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(structuredContentRuleImpl, clone);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link StructuredContentRuleImpl}
   *   <li>{@link StructuredContentRuleImpl#setId(Long)}
   *   <li>{@link StructuredContentRuleImpl#setMatchRule(String)}
   *   <li>{@link StructuredContentRuleImpl#getId()}
   *   <li>{@link StructuredContentRuleImpl#getMatchRule()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    StructuredContentRuleImpl actualStructuredContentRuleImpl = new StructuredContentRuleImpl();
    actualStructuredContentRuleImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    actualStructuredContentRuleImpl.setMatchRule("Match Rule");
    Long actualId = actualStructuredContentRuleImpl.getId();

    // Assert that nothing has changed
    assertEquals("Match Rule", actualStructuredContentRuleImpl.getMatchRule());
    assertEquals(StructuredContentItemCriteriaImpl.serialVersionUID, actualId.longValue());
  }
}
