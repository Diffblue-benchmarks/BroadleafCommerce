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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.cms.field.domain.FieldGroup;
import org.broadleafcommerce.cms.field.domain.FieldGroupImpl;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
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
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class PageTemplateImplDiffblueTest {
  @Autowired
  private PageTemplateImpl pageTemplateImpl;

  /**
   * Test {@link PageTemplateImpl#getFieldGroups()}.
   * <ul>
   *   <li>Given {@link PageTemplateImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateImpl#getFieldGroups()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List PageTemplateImpl.getFieldGroups()"})
  public void testGetFieldGroups_givenPageTemplateImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PageTemplateImpl()).getFieldGroups().isEmpty());
  }

  /**
   * Test {@link PageTemplateImpl#getFieldGroups()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateImpl#getFieldGroups()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List PageTemplateImpl.getFieldGroups()"})
  public void testGetFieldGroups_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    fieldGroups.add(new PageTemplateFieldGroupXrefImpl());

    PageTemplateImpl pageTemplateImpl2 = new PageTemplateImpl();
    pageTemplateImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageTemplateImpl2.setLocale(new LocaleImpl());
    pageTemplateImpl2.setTemplateDescription("Template Description");
    pageTemplateImpl2.setTemplateName("Template Name");
    pageTemplateImpl2.setTemplatePath("Template Path");
    pageTemplateImpl2.setFieldGroupXrefs(fieldGroups);

    // Act
    List<FieldGroup> actualFieldGroups = pageTemplateImpl2.getFieldGroups();

    // Assert
    assertEquals(1, actualFieldGroups.size());
    assertNull(actualFieldGroups.get(0));
  }

  /**
   * Test {@link PageTemplateImpl#setFieldGroups(List)}.
   * <ul>
   *   <li>Then {@link PageTemplateImpl} (default constructor) FieldGroupXrefs size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateImpl#setFieldGroups(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageTemplateImpl.setFieldGroups(List)"})
  public void testSetFieldGroups_thenPageTemplateImplFieldGroupXrefsSizeIsOne() {
    // Arrange
    PageTemplateImpl pageTemplateImpl2 = new PageTemplateImpl();
    ArrayList<PageTemplateFieldGroupXref> fieldGroups = new ArrayList<>();
    pageTemplateImpl2.setFieldGroupXrefs(fieldGroups);
    pageTemplateImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageTemplateImpl2.setLocale(new LocaleImpl());
    pageTemplateImpl2.setTemplateDescription("Template Description");
    pageTemplateImpl2.setTemplateName("Template Name");
    pageTemplateImpl2.setTemplatePath("Template Path");

    ArrayList<FieldGroup> fieldGroups2 = new ArrayList<>();
    fieldGroups2.add(new FieldGroupImpl());

    // Act
    pageTemplateImpl2.setFieldGroups(fieldGroups2);

    // Assert
    List<PageTemplateFieldGroupXref> fieldGroupXrefs = pageTemplateImpl2.getFieldGroupXrefs();
    assertEquals(1, fieldGroupXrefs.size());
    assertEquals(1, pageTemplateImpl2.getFieldGroups().size());
    assertEquals(1, pageTemplateImpl2.legacyFieldGroups.size());
    assertSame(fieldGroups, fieldGroupXrefs);
  }

  /**
   * Test {@link PageTemplateImpl#setFieldGroups(List)}.
   * <ul>
   *   <li>Then {@link PageTemplateImpl} (default constructor) FieldGroupXrefs size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateImpl#setFieldGroups(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageTemplateImpl.setFieldGroups(List)"})
  public void testSetFieldGroups_thenPageTemplateImplFieldGroupXrefsSizeIsTwo() {
    // Arrange
    PageTemplateImpl pageTemplateImpl2 = new PageTemplateImpl();

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(new FieldGroupImpl());
    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();
    fieldGroups.add(fieldGroupImpl);

    // Act
    pageTemplateImpl2.setFieldGroups(fieldGroups);

    // Assert
    List<PageTemplateFieldGroupXref> fieldGroupXrefs = pageTemplateImpl2.getFieldGroupXrefs();
    assertEquals(2, fieldGroupXrefs.size());
    PageTemplateFieldGroupXref getResult = fieldGroupXrefs.get(1);
    assertTrue(getResult instanceof PageTemplateFieldGroupXrefImpl);
    assertNull(getResult.getId());
    assertNull(getResult.getGroupOrder());
    List<FieldGroup> fieldGroups2 = pageTemplateImpl2.getFieldGroups();
    assertEquals(2, fieldGroups2.size());
    List<FieldGroup> fieldGroupList = pageTemplateImpl2.legacyFieldGroups;
    assertEquals(2, fieldGroupList.size());
    assertSame(fieldGroupImpl, fieldGroups2.get(1));
    assertSame(fieldGroupImpl, fieldGroupList.get(1));
    assertSame(fieldGroupImpl, getResult.getFieldGroup());
    assertSame(pageTemplateImpl2, getResult.getPageTemplate());
  }

  /**
   * Test {@link PageTemplateImpl#setFieldGroups(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link PageTemplateImpl} (default constructor) FieldGroupXrefs Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateImpl#setFieldGroups(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageTemplateImpl.setFieldGroups(List)"})
  public void testSetFieldGroups_whenArrayList_thenPageTemplateImplFieldGroupXrefsEmpty() {
    // Arrange
    PageTemplateImpl pageTemplateImpl2 = new PageTemplateImpl();

    // Act
    pageTemplateImpl2.setFieldGroups(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(pageTemplateImpl2.getFieldGroupXrefs().isEmpty());
    assertTrue(pageTemplateImpl2.getFieldGroups().isEmpty());
    assertTrue(pageTemplateImpl2.legacyFieldGroups.isEmpty());
  }

  /**
   * Test {@link PageTemplateImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link PageTemplateImpl#getMainEntityName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PageTemplateImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull((new PageTemplateImpl()).getMainEntityName());
  }

  /**
   * Test {@link PageTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link PageTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse PageTemplateImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    PageTemplateImpl pageTemplateImpl2 = new PageTemplateImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<PageTemplate> actualCreateOrRetrieveCopyInstanceResult = pageTemplateImpl2
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link PageTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link PageTemplateImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse PageTemplateImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnPageTemplateImpl() throws CloneNotSupportedException {
    // Arrange
    PageTemplateImpl pageTemplateImpl2 = new PageTemplateImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<PageTemplate> actualCreateOrRetrieveCopyInstanceResult = pageTemplateImpl2
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.cms.page.domain.PageTemplateImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    PageTemplate clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof PageTemplateImpl);
    assertNull(clone.getId());
    assertNull(clone.getTemplateDescription());
    assertNull(clone.getTemplateName());
    assertNull(clone.getTemplatePath());
    assertNull(((PageTemplateImpl) clone).getMainEntityName());
    assertNull(clone.getLocale());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertTrue(clone.getFieldGroupXrefs().isEmpty());
    assertTrue(clone.getFieldGroups().isEmpty());
    assertTrue(((PageTemplateImpl) clone).legacyFieldGroups.isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageTemplateImpl.<init>()", "List PageTemplateImpl.getFieldGroupXrefs()",
      "Long PageTemplateImpl.getId()", "Locale PageTemplateImpl.getLocale()",
      "String PageTemplateImpl.getTemplateDescription()", "String PageTemplateImpl.getTemplateName()",
      "String PageTemplateImpl.getTemplatePath()", "void PageTemplateImpl.setFieldGroupXrefs(List)",
      "void PageTemplateImpl.setId(Long)", "void PageTemplateImpl.setLocale(Locale)",
      "void PageTemplateImpl.setTemplateDescription(String)", "void PageTemplateImpl.setTemplateName(String)",
      "void PageTemplateImpl.setTemplatePath(String)"})
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
    List<PageTemplateFieldGroupXref> actualFieldGroupXrefs = actualPageTemplateImpl.getFieldGroupXrefs();
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
