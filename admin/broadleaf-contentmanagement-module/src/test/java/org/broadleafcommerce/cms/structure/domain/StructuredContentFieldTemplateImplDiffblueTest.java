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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.broadleafcommerce.cms.field.domain.FieldGroup;
import org.broadleafcommerce.cms.field.domain.FieldGroupImpl;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class StructuredContentFieldTemplateImplDiffblueTest {
  @Autowired private StructuredContentFieldTemplateImpl structuredContentFieldTemplateImpl;

  /**
   * Test {@link StructuredContentFieldTemplateImpl#getFieldGroups()}.
   *
   * <ul>
   *   <li>Given {@link StructuredContentFieldTemplateImpl} FieldGroupXrefs is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentFieldTemplateImpl#getFieldGroups()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List StructuredContentFieldTemplateImpl.getFieldGroups()"})
  public void testGetFieldGroups_givenStructuredContentFieldTemplateImplFieldGroupXrefsIsNull() {
    // Arrange
    structuredContentFieldTemplateImpl.setFieldGroupXrefs(null);

    // Act and Assert
    assertTrue(structuredContentFieldTemplateImpl.getFieldGroups().isEmpty());
  }

  /**
   * Test {@link StructuredContentFieldTemplateImpl#getFieldGroups()}.
   *
   * <ul>
   *   <li>Given {@link StructuredContentFieldTemplateImpl}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentFieldTemplateImpl#getFieldGroups()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List StructuredContentFieldTemplateImpl.getFieldGroups()"})
  public void testGetFieldGroups_givenStructuredContentFieldTemplateImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(structuredContentFieldTemplateImpl.getFieldGroups().isEmpty());
  }

  /**
   * Test {@link StructuredContentFieldTemplateImpl#getFieldGroups()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentFieldTemplateImpl#getFieldGroups()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List StructuredContentFieldTemplateImpl.getFieldGroups()"})
  public void testGetFieldGroups_thenReturnSizeIsOne() {
    // Arrange
    LinkedList<StructuredContentFieldGroupXref> fieldGroupXrefs = new LinkedList<>();
    fieldGroupXrefs.add(new StructuredContentFieldGroupXrefImpl());
    structuredContentFieldTemplateImpl.setFieldGroupXrefs(fieldGroupXrefs);

    // Act
    List<FieldGroup> actualFieldGroups = structuredContentFieldTemplateImpl.getFieldGroups();

    // Assert
    assertEquals(1, actualFieldGroups.size());
    assertNull(actualFieldGroups.get(0));
  }

  /**
   * Test {@link StructuredContentFieldTemplateImpl#setFieldGroups(List)}.
   *
   * <ul>
   *   <li>Given {@link FieldGroupImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link FieldGroupImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentFieldTemplateImpl#setFieldGroups(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredContentFieldTemplateImpl.setFieldGroups(List)"})
  public void testSetFieldGroups_givenFieldGroupImpl_whenArrayListAddFieldGroupImpl() {
    // Arrange
    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(new FieldGroupImpl());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> structuredContentFieldTemplateImpl.setFieldGroups(fieldGroups));
  }

  /**
   * Test {@link StructuredContentFieldTemplateImpl#setFieldGroups(List)}.
   *
   * <ul>
   *   <li>Given {@link FieldGroupImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link FieldGroupImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentFieldTemplateImpl#setFieldGroups(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredContentFieldTemplateImpl.setFieldGroups(List)"})
  public void testSetFieldGroups_givenFieldGroupImpl_whenArrayListAddFieldGroupImpl2() {
    // Arrange
    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(new FieldGroupImpl());
    fieldGroups.add(new FieldGroupImpl());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> structuredContentFieldTemplateImpl.setFieldGroups(fieldGroups));
  }

  /**
   * Test {@link StructuredContentFieldTemplateImpl#setFieldGroups(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentFieldTemplateImpl#setFieldGroups(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredContentFieldTemplateImpl.setFieldGroups(List)"})
  public void testSetFieldGroups_whenArrayList() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> structuredContentFieldTemplateImpl.setFieldGroups(new ArrayList<>()));
  }

  /**
   * Test {@link
   * StructuredContentFieldTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * StructuredContentFieldTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse StructuredContentFieldTemplateImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(new StructuredContentFieldTemplateImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StructuredContentFieldTemplate> actualCreateOrRetrieveCopyInstanceResult =
        structuredContentFieldTemplateImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link
   * StructuredContentFieldTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * StructuredContentFieldTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse StructuredContentFieldTemplateImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(structuredContentFieldTemplateImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StructuredContentFieldTemplate> actualCreateOrRetrieveCopyInstanceResult =
        structuredContentFieldTemplateImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StructuredContentFieldTemplateImpl}
   *   <li>{@link StructuredContentFieldTemplateImpl#setFieldGroupXrefs(List)}
   *   <li>{@link StructuredContentFieldTemplateImpl#setId(Long)}
   *   <li>{@link StructuredContentFieldTemplateImpl#setName(String)}
   *   <li>{@link StructuredContentFieldTemplateImpl#getFieldGroupXrefs()}
   *   <li>{@link StructuredContentFieldTemplateImpl#getId()}
   *   <li>{@link StructuredContentFieldTemplateImpl#getName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StructuredContentFieldTemplateImpl.<init>()",
    "List StructuredContentFieldTemplateImpl.getFieldGroupXrefs()",
    "Long StructuredContentFieldTemplateImpl.getId()",
    "String StructuredContentFieldTemplateImpl.getName()",
    "void StructuredContentFieldTemplateImpl.setFieldGroupXrefs(List)",
    "void StructuredContentFieldTemplateImpl.setId(Long)",
    "void StructuredContentFieldTemplateImpl.setName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    StructuredContentFieldTemplateImpl actualStructuredContentFieldTemplateImpl =
        new StructuredContentFieldTemplateImpl();
    ArrayList<StructuredContentFieldGroupXref> fieldGroupXrefs = new ArrayList<>();
    actualStructuredContentFieldTemplateImpl.setFieldGroupXrefs(fieldGroupXrefs);
    actualStructuredContentFieldTemplateImpl.setId(
        StructuredContentItemCriteriaImpl.serialVersionUID);
    actualStructuredContentFieldTemplateImpl.setName("Name");
    List<StructuredContentFieldGroupXref> actualFieldGroupXrefs =
        actualStructuredContentFieldTemplateImpl.getFieldGroupXrefs();
    Long actualId = actualStructuredContentFieldTemplateImpl.getId();

    // Assert
    assertEquals("Name", actualStructuredContentFieldTemplateImpl.getName());
    assertTrue(actualFieldGroupXrefs.isEmpty());
    assertEquals(StructuredContentItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(fieldGroupXrefs, actualFieldGroupXrefs);
  }
}
