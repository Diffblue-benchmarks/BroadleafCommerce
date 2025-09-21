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
package org.broadleafcommerce.cms.page.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
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
import org.broadleafcommerce.cms.field.domain.FieldGroup;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
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
public class PageTemplateImplDiffblueTest {
  @Autowired private PageTemplateImpl pageTemplateImpl;

  /**
   * Test {@link PageTemplateImpl#getFieldGroups()}.
   *
   * <ul>
   *   <li>Given {@link PageTemplateImpl}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateImpl#getFieldGroups()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PageTemplateImpl.getFieldGroups()"})
  public void testGetFieldGroups_givenPageTemplateImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(pageTemplateImpl.getFieldGroups().isEmpty());
  }

  /**
   * Test {@link PageTemplateImpl#getFieldGroups()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateImpl#getFieldGroups()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PageTemplateImpl.getFieldGroups()"})
  public void testGetFieldGroups_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    fieldGroups.add(new PageTemplateFieldGroupXrefImpl());
    pageTemplateImpl.setFieldGroupXrefs(fieldGroups);

    // Act
    List<FieldGroup> actualFieldGroups = pageTemplateImpl.getFieldGroups();

    // Assert
    assertEquals(1, actualFieldGroups.size());
    assertNull(actualFieldGroups.get(0));
  }

  /**
   * Test {@link PageTemplateImpl#setFieldGroups(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateImpl#setFieldGroups(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageTemplateImpl.setFieldGroups(List)"})
  public void testSetFieldGroups_whenArrayList_thenArrayListEmpty() {
    // Arrange
    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();

    // Act
    pageTemplateImpl.setFieldGroups(fieldGroups);

    // Assert that nothing has changed
    assertTrue(fieldGroups.isEmpty());
    assertTrue(pageTemplateImpl.getFieldGroupXrefs().isEmpty());
    assertTrue(pageTemplateImpl.getFieldGroups().isEmpty());
    assertTrue(pageTemplateImpl.legacyFieldGroups.isEmpty());
  }

  /**
   * Test {@link PageTemplateImpl#getMainEntityName()}.
   *
   * <p>Method under test: {@link PageTemplateImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PageTemplateImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull(pageTemplateImpl.getMainEntityName());
  }

  /**
   * Test {@link PageTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * PageTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse PageTemplateImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new PageTemplateImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<PageTemplate> actualCreateOrRetrieveCopyInstanceResult =
        pageTemplateImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link PageTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * PageTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse PageTemplateImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(pageTemplateImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<PageTemplate> actualCreateOrRetrieveCopyInstanceResult =
        pageTemplateImpl.createOrRetrieveCopyInstance(context);

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
   *   <li>default or parameterless constructor of {@link PageTemplateImpl}
   *   <li>{@link PageTemplateImpl#setFieldGroupXrefs(List)}
   *   <li>{@link PageTemplateImpl#setId(Long)}
   *   <li>{@link PageTemplateImpl#setLocale(Locale)}
   *   <li>{@link PageTemplateImpl#setTemplateDescription(String)}
   *   <li>{@link PageTemplateImpl#setTemplateName(String)}
   *   <li>{@link PageTemplateImpl#setTemplatePath(String)}
   *   <li>{@link PageTemplateImpl#getFieldGroupXrefs()}
   *   <li>{@link PageTemplateImpl#getId()}
   *   <li>{@link PageTemplateImpl#getLocale()}
   *   <li>{@link PageTemplateImpl#getTemplateDescription()}
   *   <li>{@link PageTemplateImpl#getTemplateName()}
   *   <li>{@link PageTemplateImpl#getTemplatePath()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageTemplateImpl.<init>()",
    "List PageTemplateImpl.getFieldGroupXrefs()",
    "Long PageTemplateImpl.getId()",
    "Locale PageTemplateImpl.getLocale()",
    "String PageTemplateImpl.getTemplateDescription()",
    "String PageTemplateImpl.getTemplateName()",
    "String PageTemplateImpl.getTemplatePath()",
    "void PageTemplateImpl.setFieldGroupXrefs(List)",
    "void PageTemplateImpl.setId(Long)",
    "void PageTemplateImpl.setLocale(Locale)",
    "void PageTemplateImpl.setTemplateDescription(String)",
    "void PageTemplateImpl.setTemplateName(String)",
    "void PageTemplateImpl.setTemplatePath(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    PageTemplateImpl actualPageTemplateImpl = new PageTemplateImpl();
    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    actualPageTemplateImpl.setFieldGroupXrefs(fieldGroups);
    actualPageTemplateImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    LocaleImpl locale = new LocaleImpl();
    actualPageTemplateImpl.setLocale(locale);
    actualPageTemplateImpl.setTemplateDescription("Template Description");
    actualPageTemplateImpl.setTemplateName("Template Name");
    actualPageTemplateImpl.setTemplatePath("Template Path");
    List<PageTemplateFieldGroupXref> actualFieldGroupXrefs =
        actualPageTemplateImpl.getFieldGroupXrefs();
    Long actualId = actualPageTemplateImpl.getId();
    Locale actualLocale = actualPageTemplateImpl.getLocale();
    String actualTemplateDescription = actualPageTemplateImpl.getTemplateDescription();
    String actualTemplateName = actualPageTemplateImpl.getTemplateName();

    // Assert
    assertEquals("Template Description", actualTemplateDescription);
    assertEquals("Template Name", actualTemplateName);
    assertEquals("Template Path", actualPageTemplateImpl.getTemplatePath());
    assertTrue(actualFieldGroupXrefs.isEmpty());
    assertTrue(actualPageTemplateImpl.legacyFieldGroups.isEmpty());
    assertEquals(PageItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(fieldGroups, actualFieldGroupXrefs);
    assertSame(locale, actualLocale);
  }
}
