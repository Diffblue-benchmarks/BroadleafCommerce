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
package org.broadleafcommerce.cms.field.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.cms.structure.domain.StructuredContentFieldGroupXref;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class FieldGroupImplDiffblueTest {
  /**
   * Test {@link FieldGroupImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * FieldGroupImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse FieldGroupImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new FieldGroupImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<FieldGroup> actualCreateOrRetrieveCopyInstanceResult =
        fieldGroupImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link FieldGroupImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * FieldGroupImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse FieldGroupImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();

    FieldGroupImpl fieldGroupImpl2 = new FieldGroupImpl();
    fieldGroupImpl2.setFieldDefinitions(new ArrayList<>());
    fieldGroupImpl2.setFieldGroupXrefs(new ArrayList<>());
    fieldGroupImpl2.setId(1L);
    fieldGroupImpl2.setInitCollapsedFlag(true);
    fieldGroupImpl2.setIsMasterFieldGroup(true);
    fieldGroupImpl2.setName("Name");
    CreateResponse<Object> createResponse = new CreateResponse<>(fieldGroupImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<FieldGroup> actualCreateOrRetrieveCopyInstanceResult =
        fieldGroupImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link FieldGroupImpl#isMasterFieldGroup()}.
   *
   * <ul>
   *   <li>Given {@link FieldGroupImpl} (default constructor) IsMasterFieldGroup is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroupImpl#isMasterFieldGroup()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FieldGroupImpl.isMasterFieldGroup()"})
  public void testIsMasterFieldGroup_givenFieldGroupImplIsMasterFieldGroupIsNull() {
    // Arrange
    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();
    fieldGroupImpl.setFieldDefinitions(new ArrayList<>());
    fieldGroupImpl.setFieldGroupXrefs(new ArrayList<>());
    fieldGroupImpl.setId(1L);
    fieldGroupImpl.setInitCollapsedFlag(true);
    fieldGroupImpl.setName("Name");
    fieldGroupImpl.setIsMasterFieldGroup(null);

    // Act and Assert
    assertFalse(fieldGroupImpl.isMasterFieldGroup());
  }

  /**
   * Test {@link FieldGroupImpl#isMasterFieldGroup()}.
   *
   * <ul>
   *   <li>Given {@link FieldGroupImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroupImpl#isMasterFieldGroup()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FieldGroupImpl.isMasterFieldGroup()"})
  public void testIsMasterFieldGroup_givenFieldGroupImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new FieldGroupImpl().isMasterFieldGroup());
  }

  /**
   * Test {@link FieldGroupImpl#isMasterFieldGroup()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroupImpl#isMasterFieldGroup()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FieldGroupImpl.isMasterFieldGroup()"})
  public void testIsMasterFieldGroup_thenReturnTrue() {
    // Arrange
    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();
    fieldGroupImpl.setFieldDefinitions(new ArrayList<>());
    fieldGroupImpl.setFieldGroupXrefs(new ArrayList<>());
    fieldGroupImpl.setId(1L);
    fieldGroupImpl.setInitCollapsedFlag(true);
    fieldGroupImpl.setName("Name");
    fieldGroupImpl.setIsMasterFieldGroup(true);

    // Act and Assert
    assertTrue(fieldGroupImpl.isMasterFieldGroup());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link FieldGroupImpl}
   *   <li>{@link FieldGroupImpl#setFieldDefinitions(List)}
   *   <li>{@link FieldGroupImpl#setFieldGroupXrefs(List)}
   *   <li>{@link FieldGroupImpl#setId(Long)}
   *   <li>{@link FieldGroupImpl#setInitCollapsedFlag(Boolean)}
   *   <li>{@link FieldGroupImpl#setIsMasterFieldGroup(Boolean)}
   *   <li>{@link FieldGroupImpl#setName(String)}
   *   <li>{@link FieldGroupImpl#getFieldDefinitions()}
   *   <li>{@link FieldGroupImpl#getFieldGroupXrefs()}
   *   <li>{@link FieldGroupImpl#getId()}
   *   <li>{@link FieldGroupImpl#getInitCollapsedFlag()}
   *   <li>{@link FieldGroupImpl#getName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FieldGroupImpl.<init>()",
    "List FieldGroupImpl.getFieldDefinitions()",
    "List FieldGroupImpl.getFieldGroupXrefs()",
    "Long FieldGroupImpl.getId()",
    "Boolean FieldGroupImpl.getInitCollapsedFlag()",
    "String FieldGroupImpl.getName()",
    "void FieldGroupImpl.setFieldDefinitions(List)",
    "void FieldGroupImpl.setFieldGroupXrefs(List)",
    "void FieldGroupImpl.setId(Long)",
    "void FieldGroupImpl.setInitCollapsedFlag(Boolean)",
    "void FieldGroupImpl.setIsMasterFieldGroup(Boolean)",
    "void FieldGroupImpl.setName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    FieldGroupImpl actualFieldGroupImpl = new FieldGroupImpl();
    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    actualFieldGroupImpl.setFieldDefinitions(fieldDefinitions);
    ArrayList<StructuredContentFieldGroupXref> fieldGroupXrefs = new ArrayList<>();
    actualFieldGroupImpl.setFieldGroupXrefs(fieldGroupXrefs);
    actualFieldGroupImpl.setId(1L);
    actualFieldGroupImpl.setInitCollapsedFlag(true);
    actualFieldGroupImpl.setIsMasterFieldGroup(true);
    actualFieldGroupImpl.setName("Name");
    List<FieldDefinition> actualFieldDefinitions = actualFieldGroupImpl.getFieldDefinitions();
    List<StructuredContentFieldGroupXref> actualFieldGroupXrefs =
        actualFieldGroupImpl.getFieldGroupXrefs();
    Long actualId = actualFieldGroupImpl.getId();
    Boolean actualInitCollapsedFlag = actualFieldGroupImpl.getInitCollapsedFlag();

    // Assert
    assertEquals("Name", actualFieldGroupImpl.getName());
    assertEquals(1L, actualId.longValue());
    assertTrue(actualFieldDefinitions.isEmpty());
    assertTrue(actualFieldGroupXrefs.isEmpty());
    assertTrue(actualInitCollapsedFlag);
    assertSame(fieldDefinitions, actualFieldDefinitions);
    assertSame(fieldGroupXrefs, actualFieldGroupXrefs);
  }
}
