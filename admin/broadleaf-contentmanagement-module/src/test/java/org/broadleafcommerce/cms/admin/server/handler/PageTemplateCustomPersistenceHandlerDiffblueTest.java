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
package org.broadleafcommerce.cms.admin.server.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.broadleafcommerce.cms.field.domain.FieldGroup;
import org.broadleafcommerce.cms.page.domain.Page;
import org.broadleafcommerce.cms.page.domain.PageImpl;
import org.broadleafcommerce.cms.page.domain.PageTemplate;
import org.broadleafcommerce.cms.page.domain.PageTemplateFieldGroupXref;
import org.broadleafcommerce.cms.page.domain.PageTemplateFieldGroupXrefImpl;
import org.broadleafcommerce.cms.page.domain.PageTemplateImpl;
import org.broadleafcommerce.cms.page.service.PageService;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.sandbox.domain.SandBox;
import org.broadleafcommerce.common.sandbox.domain.SandBoxImpl;
import org.broadleafcommerce.common.sandbox.service.SandBoxService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PageTemplateCustomPersistenceHandlerDiffblueTest {
  @Mock private PageService pageService;

  @InjectMocks private PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler;

  @Mock private SandBoxService sandBoxService;

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#getSandBox()}.
   *
   * <ul>
   *   <li>Then return {@link SandBoxImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateCustomPersistenceHandler#getSandBox()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SandBox PageTemplateCustomPersistenceHandler.getSandBox()"})
  public void testGetSandBox_thenReturnSandBoxImpl() {
    // Arrange
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    when(sandBoxService.retrieveSandBoxById(Mockito.<Long>any())).thenReturn(sandBoxImpl);

    // Act
    SandBox actualSandBox = pageTemplateCustomPersistenceHandler.getSandBox();

    // Assert
    verify(sandBoxService).retrieveSandBoxById(isNull());
    assertSame(sandBoxImpl, actualSandBox);
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#getSandBox()}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateCustomPersistenceHandler#getSandBox()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SandBox PageTemplateCustomPersistenceHandler.getSandBox()"})
  public void testGetSandBox_thenThrowNumberFormatException() {
    // Arrange
    when(sandBoxService.retrieveSandBoxById(Mockito.<Long>any()))
        .thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> pageTemplateCustomPersistenceHandler.getSandBox());
    verify(sandBoxService).retrieveSandBoxById(isNull());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)} with
   * {@code page}, {@code template}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page,
   * PageTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List PageTemplateCustomPersistenceHandler.getFieldGroups(Page, PageTemplate)"
  })
  public void testGetFieldGroupsWithPageTemplate_givenNull_thenReturnEmpty() {
    // Arrange
    PageImpl page = new PageImpl();
    page.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(new HashMap<>());
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setFullUrl("https://example.org/example");
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPageFields(new HashMap<>());
    page.setPageMatchRules(new HashMap<>());
    page.setPriority(1);
    page.setQualifyingItemCriteria(new HashSet<>());
    page.setPageTemplate(null);

    // Act and Assert
    assertTrue(pageTemplateCustomPersistenceHandler.getFieldGroups(page, null).isEmpty());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)} with
   * {@code page}, {@code template}.
   *
   * <ul>
   *   <li>Given {@link PageTemplateImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page,
   * PageTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List PageTemplateCustomPersistenceHandler.getFieldGroups(Page, PageTemplate)"
  })
  public void testGetFieldGroupsWithPageTemplate_givenPageTemplateImpl() {
    // Arrange
    PageImpl page = new PageImpl();
    page.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(new HashMap<>());
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setFullUrl("https://example.org/example");
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPageFields(new HashMap<>());
    page.setPageMatchRules(new HashMap<>());
    page.setPriority(1);
    page.setQualifyingItemCriteria(new HashSet<>());
    page.setPageTemplate(new PageTemplateImpl());

    // Act and Assert
    assertTrue(pageTemplateCustomPersistenceHandler.getFieldGroups(page, null).isEmpty());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)} with
   * {@code page}, {@code template}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page,
   * PageTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List PageTemplateCustomPersistenceHandler.getFieldGroups(Page, PageTemplate)"
  })
  public void testGetFieldGroupsWithPageTemplate_thenReturnSizeIsOne() {
    // Arrange
    PageImpl page = new PageImpl();
    page.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(new HashMap<>());
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setFullUrl("https://example.org/example");
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPageFields(new HashMap<>());
    page.setPageMatchRules(new HashMap<>());
    page.setPriority(1);
    page.setQualifyingItemCriteria(new HashSet<>());
    page.setPageTemplate(null);

    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    fieldGroups.add(new PageTemplateFieldGroupXrefImpl());

    PageTemplateImpl template = new PageTemplateImpl();
    template.setId(1L);
    template.setLocale(new LocaleImpl());
    template.setTemplateDescription("Template Description");
    template.setTemplateName("Template Name");
    template.setTemplatePath("Template Path");
    template.setFieldGroupXrefs(fieldGroups);

    // Act
    List<FieldGroup> actualFieldGroups =
        pageTemplateCustomPersistenceHandler.getFieldGroups(page, template);

    // Assert
    assertEquals(1, actualFieldGroups.size());
    assertNull(actualFieldGroups.get(0));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)} with
   * {@code page}, {@code template}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page,
   * PageTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List PageTemplateCustomPersistenceHandler.getFieldGroups(Page, PageTemplate)"
  })
  public void testGetFieldGroupsWithPageTemplate_thenThrowNumberFormatException() {
    // Arrange
    PageTemplateImpl pageTemplate = mock(PageTemplateImpl.class);
    when(pageTemplate.getFieldGroupXrefs()).thenThrow(new NumberFormatException());

    PageImpl page = new PageImpl();
    page.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setAdditionalAttributes(new HashMap<>());
    page.setDescription("The characteristics of someone or something");
    page.setExcludeFromSiteMap(true);
    page.setFullUrl("https://example.org/example");
    page.setId(1L);
    page.setMetaDescription("Meta Description");
    page.setMetaTitle("Dr");
    page.setOfflineFlag(true);
    page.setPageFields(new HashMap<>());
    page.setPageMatchRules(new HashMap<>());
    page.setPriority(1);
    page.setQualifyingItemCriteria(new HashSet<>());
    page.setPageTemplate(pageTemplate);

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> pageTemplateCustomPersistenceHandler.getFieldGroups(page, null));
    verify(pageTemplate).getFieldGroupXrefs();
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)} with
   * {@code page}, {@code template}.
   *
   * <ul>
   *   <li>When {@link PageImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page,
   * PageTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List PageTemplateCustomPersistenceHandler.getFieldGroups(Page, PageTemplate)"
  })
  public void testGetFieldGroupsWithPageTemplate_whenPageImpl_thenReturnEmpty() {
    // Arrange
    PageImpl page = new PageImpl();

    // Act and Assert
    assertTrue(
        pageTemplateCustomPersistenceHandler
            .getFieldGroups(page, new PageTemplateImpl())
            .isEmpty());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#getFieldContainerClassName()}.
   *
   * <p>Method under test: {@link PageTemplateCustomPersistenceHandler#getFieldContainerClassName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PageTemplateCustomPersistenceHandler.getFieldContainerClassName()"})
  public void testGetFieldContainerClassName() {
    // Arrange, Act and Assert
    assertEquals(
        "org.broadleafcommerce.cms.page.domain.Page",
        pageTemplateCustomPersistenceHandler.getFieldContainerClassName());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#fetchEntityBasedOnId(String, List)}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateCustomPersistenceHandler#fetchEntityBasedOnId(String,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.openadmin.dto.Entity PageTemplateCustomPersistenceHandler.fetchEntityBasedOnId(String, List)"
  })
  public void testFetchEntityBasedOnId_thenThrowNumberFormatException() throws Exception {
    // Arrange
    when(pageService.findPageById(Mockito.<Long>any())).thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> pageTemplateCustomPersistenceHandler.fetchEntityBasedOnId("42", new ArrayList<>()));
    verify(pageService).findPageById(42L);
  }
}
