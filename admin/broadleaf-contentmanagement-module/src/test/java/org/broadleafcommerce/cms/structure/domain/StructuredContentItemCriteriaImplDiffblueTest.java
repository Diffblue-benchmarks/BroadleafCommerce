/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.structure.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class StructuredContentItemCriteriaImplDiffblueTest {
  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}, and {@link
   * StructuredContentItemCriteriaImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StructuredContentItemCriteriaImpl#equals(Object)}
   *   <li>{@link StructuredContentItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentItemCriteriaImpl.equals(Object)",
    "int StructuredContentItemCriteriaImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(1);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(1);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl2);
    assertEquals(
        structuredContentItemCriteriaImpl.hashCode(),
        structuredContentItemCriteriaImpl2.hashCode());
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}, and {@link
   * StructuredContentItemCriteriaImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StructuredContentItemCriteriaImpl#equals(Object)}
   *   <li>{@link StructuredContentItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentItemCriteriaImpl.equals(Object)",
    "int StructuredContentItemCriteriaImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(null);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(1);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(1);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl2);
    assertNotEquals(
        structuredContentItemCriteriaImpl.hashCode(),
        structuredContentItemCriteriaImpl2.hashCode());
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}, and {@link
   * StructuredContentItemCriteriaImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StructuredContentItemCriteriaImpl#equals(Object)}
   *   <li>{@link StructuredContentItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentItemCriteriaImpl.equals(Object)",
    "int StructuredContentItemCriteriaImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(1);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(null);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(1);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl2);
    assertNotEquals(
        structuredContentItemCriteriaImpl.hashCode(),
        structuredContentItemCriteriaImpl2.hashCode());
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}, and {@link
   * StructuredContentItemCriteriaImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StructuredContentItemCriteriaImpl#equals(Object)}
   *   <li>{@link StructuredContentItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentItemCriteriaImpl.equals(Object)",
    "int StructuredContentItemCriteriaImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(null);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(null);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(null);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl2);
    assertNotEquals(
        structuredContentItemCriteriaImpl.hashCode(),
        structuredContentItemCriteriaImpl2.hashCode());
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}, and {@link
   * StructuredContentItemCriteriaImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StructuredContentItemCriteriaImpl#equals(Object)}
   *   <li>{@link StructuredContentItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentItemCriteriaImpl.equals(Object)",
    "int StructuredContentItemCriteriaImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentItemCriteriaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentItemCriteriaImpl.equals(Object)",
    "int StructuredContentItemCriteriaImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(2L);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(1);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(1);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertNotEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl2);
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentItemCriteriaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentItemCriteriaImpl.equals(Object)",
    "int StructuredContentItemCriteriaImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(null);
    structuredContentItemCriteriaImpl.setMatchRule("42");
    structuredContentItemCriteriaImpl.setQuantity(1);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(1);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertNotEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl2);
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentItemCriteriaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentItemCriteriaImpl.equals(Object)",
    "int StructuredContentItemCriteriaImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(null);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(0);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(1);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertNotEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl2);
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentItemCriteriaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentItemCriteriaImpl.equals(Object)",
    "int StructuredContentItemCriteriaImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(null);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(null);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(1);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertNotEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl2);
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentItemCriteriaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentItemCriteriaImpl.equals(Object)",
    "int StructuredContentItemCriteriaImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(1);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertNotEquals(structuredContentItemCriteriaImpl, null);
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentItemCriteriaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentItemCriteriaImpl.equals(Object)",
    "int StructuredContentItemCriteriaImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(1);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertNotEquals(
        structuredContentItemCriteriaImpl, "Different type to StructuredContentItemCriteriaImpl");
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#cloneEntity()}.
   *
   * <p>Method under test: {@link StructuredContentItemCriteriaImpl#cloneEntity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StructuredContentItemCriteria StructuredContentItemCriteriaImpl.cloneEntity()"
  })
  public void testCloneEntity() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();

    // Act
    StructuredContentItemCriteria actualCloneEntityResult =
        structuredContentItemCriteriaImpl.cloneEntity();

    // Assert
    assertTrue(actualCloneEntityResult instanceof StructuredContentItemCriteriaImpl);
    assertEquals(structuredContentItemCriteriaImpl, actualCloneEntityResult);
  }

  /**
   * Test {@link
   * StructuredContentItemCriteriaImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * StructuredContentItemCriteriaImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse StructuredContentItemCriteriaImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(new StructuredContentItemCriteriaImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StructuredContentItemCriteria> actualCreateOrRetrieveCopyInstanceResult =
        structuredContentItemCriteriaImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link
   * StructuredContentItemCriteriaImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * StructuredContentItemCriteriaImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse StructuredContentItemCriteriaImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(1);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());
    CreateResponse<Object> createResponse =
        new CreateResponse<>(structuredContentItemCriteriaImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StructuredContentItemCriteria> actualCreateOrRetrieveCopyInstanceResult =
        structuredContentItemCriteriaImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link
   * StructuredContentItemCriteriaImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       StructuredContentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentItemCriteriaImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse StructuredContentItemCriteriaImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenCallsCreateOrRetrieveCopyInstance()
      throws CloneNotSupportedException {
    // Arrange
    StructuredContentImpl structuredContent = mock(StructuredContentImpl.class);
    when(structuredContent.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new StructuredContentImpl(), true));

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setStructuredContent(structuredContent);

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(1);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());
    CreateResponse<Object> createResponse =
        new CreateResponse<>(structuredContentItemCriteriaImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StructuredContentItemCriteria> actualCreateOrRetrieveCopyInstanceResult =
        structuredContentItemCriteriaImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(structuredContent).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StructuredContentItemCriteriaImpl}
   *   <li>{@link StructuredContentItemCriteriaImpl#setId(Long)}
   *   <li>{@link StructuredContentItemCriteriaImpl#setMatchRule(String)}
   *   <li>{@link StructuredContentItemCriteriaImpl#setQuantity(Integer)}
   *   <li>{@link StructuredContentItemCriteriaImpl#setStructuredContent(StructuredContent)}
   *   <li>{@link StructuredContentItemCriteriaImpl#getId()}
   *   <li>{@link StructuredContentItemCriteriaImpl#getMatchRule()}
   *   <li>{@link StructuredContentItemCriteriaImpl#getQuantity()}
   *   <li>{@link StructuredContentItemCriteriaImpl#getStructuredContent()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StructuredContentItemCriteriaImpl.<init>()",
    "Long StructuredContentItemCriteriaImpl.getId()",
    "String StructuredContentItemCriteriaImpl.getMatchRule()",
    "Integer StructuredContentItemCriteriaImpl.getQuantity()",
    "StructuredContent StructuredContentItemCriteriaImpl.getStructuredContent()",
    "void StructuredContentItemCriteriaImpl.setId(Long)",
    "void StructuredContentItemCriteriaImpl.setMatchRule(String)",
    "void StructuredContentItemCriteriaImpl.setQuantity(Integer)",
    "void StructuredContentItemCriteriaImpl.setStructuredContent(StructuredContent)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    StructuredContentItemCriteriaImpl actualStructuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();
    actualStructuredContentItemCriteriaImpl.setId(
        StructuredContentItemCriteriaImpl.serialVersionUID);
    actualStructuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    actualStructuredContentItemCriteriaImpl.setQuantity(1);
    StructuredContentImpl structuredContent = new StructuredContentImpl();
    actualStructuredContentItemCriteriaImpl.setStructuredContent(structuredContent);
    Long actualId = actualStructuredContentItemCriteriaImpl.getId();
    String actualMatchRule = actualStructuredContentItemCriteriaImpl.getMatchRule();
    Integer actualQuantity = actualStructuredContentItemCriteriaImpl.getQuantity();
    StructuredContent actualStructuredContent =
        actualStructuredContentItemCriteriaImpl.getStructuredContent();

    // Assert
    assertEquals("Match Rule", actualMatchRule);
    assertEquals(1, actualQuantity.intValue());
    assertEquals(StructuredContentItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(structuredContent, actualStructuredContent);
  }
}
