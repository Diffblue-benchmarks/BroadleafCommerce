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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.cms.field.domain.FieldDefinition;
import org.broadleafcommerce.cms.field.domain.FieldDefinitionImpl;
import org.broadleafcommerce.cms.field.domain.FieldGroup;
import org.broadleafcommerce.cms.field.domain.FieldGroupImpl;
import org.broadleafcommerce.cms.page.domain.Page;
import org.broadleafcommerce.cms.page.domain.PageField;
import org.broadleafcommerce.cms.page.domain.PageImpl;
import org.broadleafcommerce.cms.page.domain.PageTemplate;
import org.broadleafcommerce.cms.page.domain.PageTemplateFieldGroupXref;
import org.broadleafcommerce.cms.page.domain.PageTemplateFieldGroupXrefImpl;
import org.broadleafcommerce.cms.page.domain.PageTemplateImpl;
import org.broadleafcommerce.cms.page.service.PageService;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.sandbox.domain.SandBox;
import org.broadleafcommerce.common.sandbox.domain.SandBoxImpl;
import org.broadleafcommerce.common.sandbox.service.SandBoxService;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.InspectHelper;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PageTemplateCustomPersistenceHandlerDiffblueTest {
  @InjectMocks
  private PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler;

  @Mock
  private DynamicFieldPersistenceHandlerHelper dynamicFieldPersistenceHandlerHelper;

  @Mock
  private PageService pageService;

  @Mock
  private SandBoxService sandBoxService;

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean PageTemplateCustomPersistenceHandler.canHandleFetch(PersistencePackage)"})
  public void testCanHandleFetch_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(pageTemplateCustomPersistenceHandler.canHandleFetch(new PersistencePackage()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean PageTemplateCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(pageTemplateCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean PageTemplateCustomPersistenceHandler.canHandleInspect(PersistencePackage)"})
  public void testCanHandleInspect_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(pageTemplateCustomPersistenceHandler.canHandleInspect(new PersistencePackage()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean PageTemplateCustomPersistenceHandler.canHandleRemove(PersistencePackage)"})
  public void testCanHandleRemove() {
    // Arrange, Act and Assert
    assertFalse(pageTemplateCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean PageTemplateCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(pageTemplateCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#getSandBox()}.
   * <ul>
   *   <li>Then return {@link SandBoxImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#getSandBox()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#getSandBox()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SandBox PageTemplateCustomPersistenceHandler.getSandBox()"})
  public void testGetSandBox_thenThrowNumberFormatException() {
    // Arrange
    when(sandBoxService.retrieveSandBoxById(Mockito.<Long>any()))
        .thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> pageTemplateCustomPersistenceHandler.getSandBox());
    verify(sandBoxService).retrieveSandBoxById(isNull());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)} with {@code page}, {@code template}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link PageImpl} (default constructor) PageTemplate is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List PageTemplateCustomPersistenceHandler.getFieldGroups(Page, PageTemplate)"})
  public void testGetFieldGroupsWithPageTemplate_givenNull_whenPageImplPageTemplateIsNull() {
    // Arrange
    PageImpl page = new PageImpl();
    page.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * Test {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)} with {@code page}, {@code template}.
   * <ul>
   *   <li>Given {@link PageTemplateImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List PageTemplateCustomPersistenceHandler.getFieldGroups(Page, PageTemplate)"})
  public void testGetFieldGroupsWithPageTemplate_givenPageTemplateImpl() {
    // Arrange
    PageImpl page = new PageImpl();
    page.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * Test {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)} with {@code page}, {@code template}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List PageTemplateCustomPersistenceHandler.getFieldGroups(Page, PageTemplate)"})
  public void testGetFieldGroupsWithPageTemplate_thenReturnSizeIsOne() {
    // Arrange
    PageImpl page = new PageImpl();
    page.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    List<FieldGroup> actualFieldGroups = pageTemplateCustomPersistenceHandler.getFieldGroups(page, template);

    // Assert
    assertEquals(1, actualFieldGroups.size());
    assertNull(actualFieldGroups.get(0));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)} with {@code page}, {@code template}.
   * <ul>
   *   <li>When {@link PageImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#getFieldGroups(Page, PageTemplate)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List PageTemplateCustomPersistenceHandler.getFieldGroups(Page, PageTemplate)"})
  public void testGetFieldGroupsWithPageTemplate_whenPageImpl_thenReturnEmpty() {
    // Arrange
    PageImpl page = new PageImpl();

    // Act and Assert
    assertTrue(pageTemplateCustomPersistenceHandler.getFieldGroups(page, new PageTemplateImpl()).isEmpty());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#getFieldGroups(PersistencePackage, DynamicEntityDao)} with {@code pp}, {@code dynamicEntityDao}.
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#getFieldGroups(PersistencePackage, DynamicEntityDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List PageTemplateCustomPersistenceHandler.getFieldGroups(PersistencePackage, DynamicEntityDao)"})
  public void testGetFieldGroupsWithPpDynamicEntityDao() {
    // Arrange
    Entity entity = new Entity();

    PersistencePackage pp = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria", null}, "ABC123");
    pp.addCustomCriteria("Criteria");

    // Act and Assert
    assertTrue(pageTemplateCustomPersistenceHandler.getFieldGroups(pp, new DynamicEntityDaoImpl()).isEmpty());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#getFieldGroups(PersistencePackage, DynamicEntityDao)} with {@code pp}, {@code dynamicEntityDao}.
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#getFieldGroups(PersistencePackage, DynamicEntityDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List PageTemplateCustomPersistenceHandler.getFieldGroups(PersistencePackage, DynamicEntityDao)"})
  public void testGetFieldGroupsWithPpDynamicEntityDao2() {
    // Arrange
    Entity entity = new Entity();

    PersistencePackage pp = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria", null, "Custom Criteria"}, "ABC123");
    pp.addCustomCriteria("Criteria");

    // Act and Assert
    assertTrue(pageTemplateCustomPersistenceHandler.getFieldGroups(pp, new DynamicEntityDaoImpl()).isEmpty());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#getFieldGroups(PersistencePackage, DynamicEntityDao)} with {@code pp}, {@code dynamicEntityDao}.
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#getFieldGroups(PersistencePackage, DynamicEntityDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List PageTemplateCustomPersistenceHandler.getFieldGroups(PersistencePackage, DynamicEntityDao)"})
  public void testGetFieldGroupsWithPpDynamicEntityDao3() {
    // Arrange
    when(pageService.findPageById(Mockito.<Long>any())).thenReturn(new PageImpl());
    Entity entity = new Entity();

    PersistencePackage pp = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");
    pp.addCustomCriteria("42");
    pp.addCustomCriteria("Criteria");

    // Act
    List<FieldGroup> actualFieldGroups = pageTemplateCustomPersistenceHandler.getFieldGroups(pp,
        new DynamicEntityDaoImpl());

    // Assert
    verify(pageService).findPageById(eq(42L));
    assertTrue(actualFieldGroups.isEmpty());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#getFieldGroups(PersistencePackage, DynamicEntityDao)} with {@code pp}, {@code dynamicEntityDao}.
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#getFieldGroups(PersistencePackage, DynamicEntityDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List PageTemplateCustomPersistenceHandler.getFieldGroups(PersistencePackage, DynamicEntityDao)"})
  public void testGetFieldGroupsWithPpDynamicEntityDao4() {
    // Arrange
    PageImpl pageImpl = mock(PageImpl.class);
    when(pageImpl.getPageTemplate()).thenReturn(new PageTemplateImpl());
    when(pageService.findPageById(Mockito.<Long>any())).thenReturn(pageImpl);
    Entity entity = new Entity();

    PersistencePackage pp = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");
    pp.addCustomCriteria("42");
    pp.addCustomCriteria("Criteria");

    // Act
    List<FieldGroup> actualFieldGroups = pageTemplateCustomPersistenceHandler.getFieldGroups(pp,
        new DynamicEntityDaoImpl());

    // Assert
    verify(pageImpl, atLeast(1)).getPageTemplate();
    verify(pageService).findPageById(eq(42L));
    assertTrue(actualFieldGroups.isEmpty());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#getFieldGroups(PersistencePackage, DynamicEntityDao)} with {@code pp}, {@code dynamicEntityDao}.
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#getFieldGroups(PersistencePackage, DynamicEntityDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List PageTemplateCustomPersistenceHandler.getFieldGroups(PersistencePackage, DynamicEntityDao)"})
  public void testGetFieldGroupsWithPpDynamicEntityDao5() {
    // Arrange
    PageTemplateImpl pageTemplateImpl = mock(PageTemplateImpl.class);
    when(pageTemplateImpl.getFieldGroupXrefs()).thenThrow(new NumberFormatException("foo"));
    PageImpl pageImpl = mock(PageImpl.class);
    when(pageImpl.getPageTemplate()).thenReturn(pageTemplateImpl);
    when(pageService.findPageById(Mockito.<Long>any())).thenReturn(pageImpl);
    Entity entity = new Entity();

    PersistencePackage pp = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");
    pp.addCustomCriteria("42");
    pp.addCustomCriteria("Criteria");

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> pageTemplateCustomPersistenceHandler.getFieldGroups(pp, new DynamicEntityDaoImpl()));
    verify(pageImpl, atLeast(1)).getPageTemplate();
    verify(pageTemplateImpl).getFieldGroupXrefs();
    verify(pageService).findPageById(eq(42L));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#getFieldGroups(PersistencePackage, DynamicEntityDao)} with {@code pp}, {@code dynamicEntityDao}.
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#getFieldGroups(PersistencePackage, DynamicEntityDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List PageTemplateCustomPersistenceHandler.getFieldGroups(PersistencePackage, DynamicEntityDao)"})
  public void testGetFieldGroupsWithPpDynamicEntityDao6() {
    // Arrange
    PageTemplateImpl pageTemplateImpl = mock(PageTemplateImpl.class);
    when(pageTemplateImpl.getFieldGroupXrefs()).thenThrow(new NumberFormatException("foo"));
    PageImpl pageImpl = mock(PageImpl.class);
    when(pageImpl.getPageTemplate()).thenReturn(pageTemplateImpl);
    when(pageService.findPageTemplateById(Mockito.<Long>any())).thenReturn(new PageTemplateImpl());
    when(pageService.findPageById(Mockito.<Long>any())).thenReturn(pageImpl);
    Entity entity = new Entity();

    PersistencePackage pp = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");
    pp.addCustomCriteria("42");
    pp.addCustomCriteria("Criteria");
    pp.addCustomCriteria("42");
    pp.addCustomCriteria("Criteria");

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> pageTemplateCustomPersistenceHandler.getFieldGroups(pp, new DynamicEntityDaoImpl()));
    verify(pageImpl, atLeast(1)).getPageTemplate();
    verify(pageTemplateImpl).getFieldGroupXrefs();
    verify(pageService).findPageById(eq(42L));
    verify(pageService).findPageTemplateById(eq(42L));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#getFieldGroups(PersistencePackage, DynamicEntityDao)} with {@code pp}, {@code dynamicEntityDao}.
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#getFieldGroups(PersistencePackage, DynamicEntityDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List PageTemplateCustomPersistenceHandler.getFieldGroups(PersistencePackage, DynamicEntityDao)"})
  public void testGetFieldGroupsWithPpDynamicEntityDao7() {
    // Arrange
    PageTemplateImpl pageTemplateImpl = mock(PageTemplateImpl.class);
    when(pageTemplateImpl.getFieldGroupXrefs()).thenThrow(new NumberFormatException("foo"));
    when(pageService.findPageTemplateById(Mockito.<Long>any())).thenReturn(pageTemplateImpl);
    when(pageService.findPageById(Mockito.<Long>any())).thenReturn(mock(PageImpl.class));
    new NumberFormatException("foo");
    Entity entity = new Entity();

    PersistencePackage pp = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");
    pp.addCustomCriteria("42");
    pp.addCustomCriteria("Criteria");
    pp.addCustomCriteria("42");
    pp.addCustomCriteria("Criteria");

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> pageTemplateCustomPersistenceHandler.getFieldGroups(pp, new DynamicEntityDaoImpl()));
    verify(pageTemplateImpl).getFieldGroupXrefs();
    verify(pageService).findPageById(eq(42L));
    verify(pageService).findPageTemplateById(eq(42L));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet PageTemplateCustomPersistenceHandler.inspect(PersistencePackage, DynamicEntityDao, InspectHelper)"})
  public void testInspect() throws ServiceException {
    // Arrange
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to perform inspect for entity: ", "Custom Criteria",
            "Unable to perform inspect for entity: "},
        "ABC123");
    persistencePackage.addCustomCriteria("Unable to perform inspect for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> pageTemplateCustomPersistenceHandler.inspect(persistencePackage,
        dynamicEntityDao, new PersistenceManagerImpl()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet PageTemplateCustomPersistenceHandler.inspect(PersistencePackage, DynamicEntityDao, InspectHelper)"})
  public void testInspect2() throws ServiceException {
    // Arrange
    when(dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(Mockito.<List<FieldGroup>>any(),
        Mockito.<Class<Object>>any())).thenThrow(new NumberFormatException("USD"));
    when(pageService.findPageById(Mockito.<Long>any())).thenReturn(new PageImpl());
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to perform inspect for entity: "}, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform inspect for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> pageTemplateCustomPersistenceHandler.inspect(persistencePackage,
        dynamicEntityDao, new PersistenceManagerImpl()));
    verify(dynamicFieldPersistenceHandlerHelper).buildDynamicPropertyList(isA(List.class), isA(Class.class));
    verify(pageService).findPageById(eq(42L));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet PageTemplateCustomPersistenceHandler.inspect(PersistencePackage, DynamicEntityDao, InspectHelper)"})
  public void testInspect_givenNull() throws ServiceException {
    // Arrange
    when(dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(Mockito.<List<FieldGroup>>any(),
        Mockito.<Class<Object>>any())).thenReturn(new Property[]{new Property()});
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to perform inspect for entity: "}, "ABC123");
    persistencePackage.addCustomCriteria(null);
    persistencePackage.addCustomCriteria("Unable to perform inspect for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    DynamicResultSet actualInspectResult = pageTemplateCustomPersistenceHandler.inspect(persistencePackage,
        dynamicEntityDao, new PersistenceManagerImpl());

    // Assert
    verify(dynamicFieldPersistenceHandlerHelper).buildDynamicPropertyList(isA(List.class), isA(Class.class));
    assertNull(actualInspectResult.getPromptSearch());
    assertNull(actualInspectResult.getTotalCountLessThanPageSize());
    assertNull(actualInspectResult.getBatchId());
    assertNull(actualInspectResult.getLowerCount());
    assertNull(actualInspectResult.getUpperCount());
    assertNull(actualInspectResult.getFirstId());
    assertNull(actualInspectResult.getLastId());
    assertNull(actualInspectResult.getFetchType());
    assertEquals(0, actualInspectResult.getPageSize().intValue());
    assertEquals(0, actualInspectResult.getStartIndex().intValue());
    assertEquals(0, actualInspectResult.getTotalRecords().intValue());
    assertEquals(0, actualInspectResult.getRecords().length);
    assertTrue(actualInspectResult.getUnselectedTabMetadata().isEmpty());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <ul>
   *   <li>Given {@link Page} {@link Page#getPageTemplate()} return {@link PageTemplateImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet PageTemplateCustomPersistenceHandler.inspect(PersistencePackage, DynamicEntityDao, InspectHelper)"})
  public void testInspect_givenPageGetPageTemplateReturnPageTemplateImpl() throws ServiceException {
    // Arrange
    when(dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(Mockito.<List<FieldGroup>>any(),
        Mockito.<Class<Object>>any())).thenReturn(new Property[]{new Property()});
    Page page = mock(Page.class);
    when(page.getPageTemplate()).thenReturn(new PageTemplateImpl());
    when(pageService.findPageById(Mockito.<Long>any())).thenReturn(page);
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to perform inspect for entity: "}, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform inspect for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    DynamicResultSet actualInspectResult = pageTemplateCustomPersistenceHandler.inspect(persistencePackage,
        dynamicEntityDao, new PersistenceManagerImpl());

    // Assert
    verify(dynamicFieldPersistenceHandlerHelper).buildDynamicPropertyList(isA(List.class), isA(Class.class));
    verify(page, atLeast(1)).getPageTemplate();
    verify(pageService).findPageById(eq(42L));
    assertNull(actualInspectResult.getPromptSearch());
    assertNull(actualInspectResult.getTotalCountLessThanPageSize());
    assertNull(actualInspectResult.getBatchId());
    assertNull(actualInspectResult.getLowerCount());
    assertNull(actualInspectResult.getUpperCount());
    assertNull(actualInspectResult.getFirstId());
    assertNull(actualInspectResult.getLastId());
    assertNull(actualInspectResult.getFetchType());
    assertEquals(0, actualInspectResult.getPageSize().intValue());
    assertEquals(0, actualInspectResult.getStartIndex().intValue());
    assertEquals(0, actualInspectResult.getTotalRecords().intValue());
    assertEquals(0, actualInspectResult.getRecords().length);
    assertTrue(actualInspectResult.getUnselectedTabMetadata().isEmpty());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <ul>
   *   <li>Given {@link PageService} {@link PageService#findPageById(Long)} return {@link PageImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet PageTemplateCustomPersistenceHandler.inspect(PersistencePackage, DynamicEntityDao, InspectHelper)"})
  public void testInspect_givenPageServiceFindPageByIdReturnPageImpl() throws ServiceException {
    // Arrange
    when(dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(Mockito.<List<FieldGroup>>any(),
        Mockito.<Class<Object>>any())).thenReturn(new Property[]{new Property()});
    when(pageService.findPageById(Mockito.<Long>any())).thenReturn(new PageImpl());
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to perform inspect for entity: "}, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform inspect for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    DynamicResultSet actualInspectResult = pageTemplateCustomPersistenceHandler.inspect(persistencePackage,
        dynamicEntityDao, new PersistenceManagerImpl());

    // Assert
    verify(dynamicFieldPersistenceHandlerHelper).buildDynamicPropertyList(isA(List.class), isA(Class.class));
    verify(pageService).findPageById(eq(42L));
    assertNull(actualInspectResult.getPromptSearch());
    assertNull(actualInspectResult.getTotalCountLessThanPageSize());
    assertNull(actualInspectResult.getBatchId());
    assertNull(actualInspectResult.getLowerCount());
    assertNull(actualInspectResult.getUpperCount());
    assertNull(actualInspectResult.getFirstId());
    assertNull(actualInspectResult.getLastId());
    assertNull(actualInspectResult.getFetchType());
    assertEquals(0, actualInspectResult.getPageSize().intValue());
    assertEquals(0, actualInspectResult.getStartIndex().intValue());
    assertEquals(0, actualInspectResult.getTotalRecords().intValue());
    assertEquals(0, actualInspectResult.getRecords().length);
    assertTrue(actualInspectResult.getUnselectedTabMetadata().isEmpty());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <ul>
   *   <li>Then calls {@link PageTemplateImpl#getFieldGroupXrefs()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet PageTemplateCustomPersistenceHandler.inspect(PersistencePackage, DynamicEntityDao, InspectHelper)"})
  public void testInspect_thenCallsGetFieldGroupXrefs() throws ServiceException {
    // Arrange
    PageTemplateImpl pageTemplateImpl = mock(PageTemplateImpl.class);
    when(pageTemplateImpl.getFieldGroupXrefs()).thenThrow(new NumberFormatException("foo"));
    Page page = mock(Page.class);
    when(page.getPageTemplate()).thenReturn(pageTemplateImpl);
    when(pageService.findPageById(Mockito.<Long>any())).thenReturn(page);
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to perform inspect for entity: "}, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform inspect for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> pageTemplateCustomPersistenceHandler.inspect(persistencePackage,
        dynamicEntityDao, new PersistenceManagerImpl()));
    verify(page, atLeast(1)).getPageTemplate();
    verify(pageTemplateImpl).getFieldGroupXrefs();
    verify(pageService).findPageById(eq(42L));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet PageTemplateCustomPersistenceHandler.inspect(PersistencePackage, DynamicEntityDao, InspectHelper)"})
  public void testInspect_thenThrowServiceException() throws ServiceException {
    // Arrange
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to perform inspect for entity: "}, "ABC123");
    persistencePackage.addCustomCriteria("Unable to perform inspect for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> pageTemplateCustomPersistenceHandler.inspect(persistencePackage,
        dynamicEntityDao, new PersistenceManagerImpl()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@code Unable to perform fetch for entity:}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet PageTemplateCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch_givenUnableToPerformFetchForEntity_thenThrowServiceException() throws ServiceException {
    // Arrange
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to perform fetch for entity: "}, "ABC123");
    persistencePackage.addCustomCriteria("Unable to perform fetch for entity: ");
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> pageTemplateCustomPersistenceHandler.fetch(persistencePackage, cto,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#populateFKLookupValues(DynamicEntityDao, Entity)}.
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#populateFKLookupValues(DynamicEntityDao, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageTemplateCustomPersistenceHandler.populateFKLookupValues(DynamicEntityDao, Entity)"})
  public void testPopulateFKLookupValues() throws ClassNotFoundException {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{property});

    // Act
    pageTemplateCustomPersistenceHandler.populateFKLookupValues(dynamicEntityDao, entity);

    // Assert
    verify(entity).getProperties();
    verify(property).getMetadata();
    verify(property).getValue();
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#populateFKLookupValues(DynamicEntityDao, Entity)}.
   * <ul>
   *   <li>Given array of {@link Property} with {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#populateFKLookupValues(DynamicEntityDao, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageTemplateCustomPersistenceHandler.populateFKLookupValues(DynamicEntityDao, Entity)"})
  public void testPopulateFKLookupValues_givenArrayOfPropertyWithProperty() throws ClassNotFoundException {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{new Property()});

    // Act
    pageTemplateCustomPersistenceHandler.populateFKLookupValues(dynamicEntityDao, entity);

    // Assert
    verify(entity).getProperties();
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#populateFKLookupValues(DynamicEntityDao, Entity)}.
   * <ul>
   *   <li>Given array of {@link Property} with {@link Property#Property(String, String)} with {@code Name} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#populateFKLookupValues(DynamicEntityDao, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageTemplateCustomPersistenceHandler.populateFKLookupValues(DynamicEntityDao, Entity)"})
  public void testPopulateFKLookupValues_givenArrayOfPropertyWithPropertyWithNameAndValueIs42()
      throws ClassNotFoundException {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{new Property("Name", "42")});

    // Act
    pageTemplateCustomPersistenceHandler.populateFKLookupValues(dynamicEntityDao, entity);

    // Assert
    verify(entity).getProperties();
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#populateFKLookupValues(DynamicEntityDao, Entity)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#populateFKLookupValues(DynamicEntityDao, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageTemplateCustomPersistenceHandler.populateFKLookupValues(DynamicEntityDao, Entity)"})
  public void testPopulateFKLookupValues_thenThrowNumberFormatException() throws ClassNotFoundException {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    Property property = mock(Property.class);
    when(property.getMetadata()).thenThrow(new NumberFormatException("foo"));
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{property});

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> pageTemplateCustomPersistenceHandler.populateFKLookupValues(dynamicEntityDao, entity));
    verify(entity).getProperties();
    verify(property).getMetadata();
    verify(property).getValue();
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#getFieldContainerClassName()}.
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#getFieldContainerClassName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PageTemplateCustomPersistenceHandler.getFieldContainerClassName()"})
  public void testGetFieldContainerClassName() {
    // Arrange, Act and Assert
    assertEquals("org.broadleafcommerce.cms.page.domain.Page",
        pageTemplateCustomPersistenceHandler.getFieldContainerClassName());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#fetchEntityBasedOnId(String, List)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#fetchEntityBasedOnId(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity PageTemplateCustomPersistenceHandler.fetchEntityBasedOnId(String, List)"})
  public void testFetchEntityBasedOnId_thenThrowNumberFormatException() throws Exception {
    // Arrange
    when(pageService.findPageById(Mockito.<Long>any())).thenThrow(new NumberFormatException("foo"));

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> pageTemplateCustomPersistenceHandler.fetchEntityBasedOnId("42", new ArrayList<>()));
    verify(pageService).findPageById(eq(42L));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#fetchDynamicEntity(Serializable, List, boolean)}.
   * <ul>
   *   <li>Given {@link PageTemplateImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#fetchDynamicEntity(Serializable, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity PageTemplateCustomPersistenceHandler.fetchDynamicEntity(Serializable, List, boolean)"})
  public void testFetchDynamicEntity_givenPageTemplateImpl() throws Exception {
    // Arrange
    PageImpl root = new PageImpl();
    root.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    root.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    root.setAdditionalAttributes(new HashMap<>());
    root.setDescription("The characteristics of someone or something");
    root.setExcludeFromSiteMap(true);
    root.setFullUrl("https://example.org/example");
    root.setId(1L);
    root.setMetaDescription("Meta Description");
    root.setMetaTitle("Dr");
    root.setOfflineFlag(true);
    root.setPageMatchRules(new HashMap<>());
    root.setPriority(1);
    root.setQualifyingItemCriteria(new HashSet<>());
    root.setPageFields(null);
    root.setPageTemplate(new PageTemplateImpl());

    // Act
    Entity actualFetchDynamicEntityResult = pageTemplateCustomPersistenceHandler.fetchDynamicEntity(root, null, false);

    // Assert
    assertNull(actualFetchDynamicEntityResult.getDeployDate());
    assertEquals(0, actualFetchDynamicEntityResult.getProperties().length);
    assertEquals(1, actualFetchDynamicEntityResult.getType().length);
    assertFalse(actualFetchDynamicEntityResult.getActive());
    assertFalse(actualFetchDynamicEntityResult.getDeleted());
    assertFalse(actualFetchDynamicEntityResult.getInactive());
    assertFalse(actualFetchDynamicEntityResult.isDirty());
    assertFalse(actualFetchDynamicEntityResult.isMultiPartAvailableOnThread());
    assertFalse(actualFetchDynamicEntityResult.isPreAdd());
    assertTrue(actualFetchDynamicEntityResult.getGlobalValidationErrors().isEmpty());
    assertTrue(actualFetchDynamicEntityResult.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = actualFetchDynamicEntityResult.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, actualFetchDynamicEntityResult.getValidationErrors());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#fetchDynamicEntity(Serializable, List, boolean)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return DeployDate is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#fetchDynamicEntity(Serializable, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity PageTemplateCustomPersistenceHandler.fetchDynamicEntity(Serializable, List, boolean)"})
  public void testFetchDynamicEntity_whenArrayList_thenReturnDeployDateIsNull() throws Exception {
    // Arrange
    PageImpl root = new PageImpl();
    root.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    root.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    root.setAdditionalAttributes(new HashMap<>());
    root.setDescription("The characteristics of someone or something");
    root.setExcludeFromSiteMap(true);
    root.setFullUrl("https://example.org/example");
    root.setId(1L);
    root.setMetaDescription("Meta Description");
    root.setMetaTitle("Dr");
    root.setOfflineFlag(true);
    root.setPageMatchRules(new HashMap<>());
    root.setPriority(1);
    root.setQualifyingItemCriteria(new HashSet<>());
    root.setPageFields(null);
    root.setPageTemplate(null);

    // Act
    Entity actualFetchDynamicEntityResult = pageTemplateCustomPersistenceHandler.fetchDynamicEntity(root,
        new ArrayList<>(), false);

    // Assert
    assertNull(actualFetchDynamicEntityResult.getDeployDate());
    assertEquals(0, actualFetchDynamicEntityResult.getProperties().length);
    assertEquals(1, actualFetchDynamicEntityResult.getType().length);
    assertFalse(actualFetchDynamicEntityResult.getActive());
    assertFalse(actualFetchDynamicEntityResult.getDeleted());
    assertFalse(actualFetchDynamicEntityResult.getInactive());
    assertFalse(actualFetchDynamicEntityResult.isDirty());
    assertFalse(actualFetchDynamicEntityResult.isMultiPartAvailableOnThread());
    assertFalse(actualFetchDynamicEntityResult.isPreAdd());
    assertTrue(actualFetchDynamicEntityResult.getGlobalValidationErrors().isEmpty());
    assertTrue(actualFetchDynamicEntityResult.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = actualFetchDynamicEntityResult.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, actualFetchDynamicEntityResult.getValidationErrors());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#fetchDynamicEntity(Serializable, List, boolean)}.
   * <ul>
   *   <li>When {@link PageImpl} (default constructor) PageTemplate is {@code null}.</li>
   *   <li>Then return DeployDate is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#fetchDynamicEntity(Serializable, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Entity PageTemplateCustomPersistenceHandler.fetchDynamicEntity(Serializable, List, boolean)"})
  public void testFetchDynamicEntity_whenPageImplPageTemplateIsNull_thenReturnDeployDateIsNull() throws Exception {
    // Arrange
    PageImpl root = new PageImpl();
    root.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    root.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    root.setAdditionalAttributes(new HashMap<>());
    root.setDescription("The characteristics of someone or something");
    root.setExcludeFromSiteMap(true);
    root.setFullUrl("https://example.org/example");
    root.setId(1L);
    root.setMetaDescription("Meta Description");
    root.setMetaTitle("Dr");
    root.setOfflineFlag(true);
    root.setPageMatchRules(new HashMap<>());
    root.setPriority(1);
    root.setQualifyingItemCriteria(new HashSet<>());
    root.setPageFields(null);
    root.setPageTemplate(null);

    // Act
    Entity actualFetchDynamicEntityResult = pageTemplateCustomPersistenceHandler.fetchDynamicEntity(root, null, false);

    // Assert
    assertNull(actualFetchDynamicEntityResult.getDeployDate());
    assertEquals(0, actualFetchDynamicEntityResult.getProperties().length);
    assertEquals(1, actualFetchDynamicEntityResult.getType().length);
    assertFalse(actualFetchDynamicEntityResult.getActive());
    assertFalse(actualFetchDynamicEntityResult.getDeleted());
    assertFalse(actualFetchDynamicEntityResult.getInactive());
    assertFalse(actualFetchDynamicEntityResult.isDirty());
    assertFalse(actualFetchDynamicEntityResult.isMultiPartAvailableOnThread());
    assertFalse(actualFetchDynamicEntityResult.isPreAdd());
    assertTrue(actualFetchDynamicEntityResult.getGlobalValidationErrors().isEmpty());
    assertTrue(actualFetchDynamicEntityResult.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = actualFetchDynamicEntityResult.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, actualFetchDynamicEntityResult.getValidationErrors());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageTemplateCustomPersistenceHandler.processFieldGroups(List, Map, List, List)"})
  public void testProcessFieldGroups_given42_whenArrayListAdd42_thenArrayListEmpty() {
    // Arrange
    ArrayList<String> dirtyFields = new ArrayList<>();
    dirtyFields.add("42");
    dirtyFields.add("foo");
    HashMap<String, PageField> pageFieldMap = new HashMap<>();
    ArrayList<Property> propertiesList = new ArrayList<>();

    // Act
    pageTemplateCustomPersistenceHandler.processFieldGroups(dirtyFields, pageFieldMap, propertiesList,
        new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(propertiesList.isEmpty());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageTemplateCustomPersistenceHandler.processFieldGroups(List, Map, List, List)"})
  public void testProcessFieldGroups_givenFoo_whenArrayListAddFoo_thenArrayListEmpty() {
    // Arrange
    ArrayList<String> dirtyFields = new ArrayList<>();
    dirtyFields.add("foo");
    HashMap<String, PageField> pageFieldMap = new HashMap<>();
    ArrayList<Property> propertiesList = new ArrayList<>();

    // Act
    pageTemplateCustomPersistenceHandler.processFieldGroups(dirtyFields, pageFieldMap, propertiesList,
        new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(propertiesList.isEmpty());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageTemplateCustomPersistenceHandler.processFieldGroups(List, Map, List, List)"})
  public void testProcessFieldGroups_thenArrayListFirstNameIsEmptyString() {
    // Arrange
    HashMap<String, PageField> pageFieldMap = new HashMap<>();
    ArrayList<Property> propertiesList = new ArrayList<>();

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(new FieldDefinitionImpl());

    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();
    fieldGroupImpl.setFieldGroupXrefs(new ArrayList<>());
    fieldGroupImpl.setId(1L);
    fieldGroupImpl.setInitCollapsedFlag(true);
    fieldGroupImpl.setIsMasterFieldGroup(true);
    fieldGroupImpl.setName("Name");
    fieldGroupImpl.setFieldDefinitions(fieldDefinitions);

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(fieldGroupImpl);

    // Act
    pageTemplateCustomPersistenceHandler.processFieldGroups(null, pageFieldMap, propertiesList, fieldGroups);

    // Assert
    assertEquals(1, propertiesList.size());
    Property getResult = propertiesList.get(0);
    FieldMetadata metadata = getResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("", getResult.getName());
    assertNull(metadata.getOwningClass());
    assertFalse(getResult.getIsDirty());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageTemplateCustomPersistenceHandler.processFieldGroups(List, Map, List, List)"})
  public void testProcessFieldGroups_thenArrayListFirstNameIsEmptyString2() {
    // Arrange
    ArrayList<Property> propertiesList = new ArrayList<>();

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(new FieldDefinitionImpl());

    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();
    fieldGroupImpl.setFieldGroupXrefs(new ArrayList<>());
    fieldGroupImpl.setId(1L);
    fieldGroupImpl.setInitCollapsedFlag(true);
    fieldGroupImpl.setIsMasterFieldGroup(true);
    fieldGroupImpl.setName("Name");
    fieldGroupImpl.setFieldDefinitions(fieldDefinitions);

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(fieldGroupImpl);

    // Act
    pageTemplateCustomPersistenceHandler.processFieldGroups(null, null, propertiesList, fieldGroups);

    // Assert
    assertEquals(1, propertiesList.size());
    Property getResult = propertiesList.get(0);
    FieldMetadata metadata = getResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("", getResult.getName());
    assertNull(metadata.getOwningClass());
    assertFalse(getResult.getIsDirty());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageTemplateCustomPersistenceHandler.processFieldGroups(List, Map, List, List)"})
  public void testProcessFieldGroups_thenArrayListFirstNameIsEmptyString3() {
    // Arrange
    ArrayList<String> dirtyFields = new ArrayList<>();
    HashMap<String, PageField> pageFieldMap = new HashMap<>();
    ArrayList<Property> propertiesList = new ArrayList<>();

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(new FieldDefinitionImpl());

    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();
    fieldGroupImpl.setFieldGroupXrefs(new ArrayList<>());
    fieldGroupImpl.setId(1L);
    fieldGroupImpl.setInitCollapsedFlag(true);
    fieldGroupImpl.setIsMasterFieldGroup(true);
    fieldGroupImpl.setName("Name");
    fieldGroupImpl.setFieldDefinitions(fieldDefinitions);

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(fieldGroupImpl);

    // Act
    pageTemplateCustomPersistenceHandler.processFieldGroups(dirtyFields, pageFieldMap, propertiesList, fieldGroups);

    // Assert
    assertEquals(1, propertiesList.size());
    Property getResult = propertiesList.get(0);
    FieldMetadata metadata = getResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("", getResult.getName());
    assertNull(metadata.getOwningClass());
    assertFalse(getResult.getIsDirty());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Name is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageTemplateCustomPersistenceHandler.processFieldGroups(List, Map, List, List)"})
  public void testProcessFieldGroups_thenArrayListFirstNameIsFoo() {
    // Arrange
    ArrayList<String> dirtyFields = new ArrayList<>();
    dirtyFields.add("foo");
    HashMap<String, PageField> pageFieldMap = new HashMap<>();
    ArrayList<Property> propertiesList = new ArrayList<>();
    FieldDefinitionImpl fieldDefinitionImpl = mock(FieldDefinitionImpl.class);
    when(fieldDefinitionImpl.getAdditionalForeignKeyClass()).thenReturn("Additional Foreign Key Class");
    when(fieldDefinitionImpl.getName()).thenReturn("foo");

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(fieldDefinitionImpl);

    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();
    fieldGroupImpl.setFieldGroupXrefs(new ArrayList<>());
    fieldGroupImpl.setId(1L);
    fieldGroupImpl.setInitCollapsedFlag(true);
    fieldGroupImpl.setIsMasterFieldGroup(true);
    fieldGroupImpl.setName("Name");
    fieldGroupImpl.setFieldDefinitions(fieldDefinitions);

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(fieldGroupImpl);

    // Act
    pageTemplateCustomPersistenceHandler.processFieldGroups(dirtyFields, pageFieldMap, propertiesList, fieldGroups);

    // Assert
    verify(fieldDefinitionImpl, atLeast(1)).getAdditionalForeignKeyClass();
    verify(fieldDefinitionImpl).getName();
    assertEquals(1, propertiesList.size());
    Property getResult = propertiesList.get(0);
    FieldMetadata metadata = getResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("Additional Foreign Key Class", metadata.getOwningClass());
    assertEquals("foo", getResult.getName());
    assertTrue(getResult.getIsDirty());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Name is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageTemplateCustomPersistenceHandler.processFieldGroups(List, Map, List, List)"})
  public void testProcessFieldGroups_thenArrayListFirstNameIsName() {
    // Arrange
    HashMap<String, PageField> pageFieldMap = new HashMap<>();
    ArrayList<Property> propertiesList = new ArrayList<>();
    FieldDefinitionImpl fieldDefinitionImpl = mock(FieldDefinitionImpl.class);
    when(fieldDefinitionImpl.getAdditionalForeignKeyClass()).thenReturn("Additional Foreign Key Class");
    when(fieldDefinitionImpl.getName()).thenReturn("Name");

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(fieldDefinitionImpl);

    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();
    fieldGroupImpl.setFieldGroupXrefs(new ArrayList<>());
    fieldGroupImpl.setId(1L);
    fieldGroupImpl.setInitCollapsedFlag(true);
    fieldGroupImpl.setIsMasterFieldGroup(true);
    fieldGroupImpl.setName("Name");
    fieldGroupImpl.setFieldDefinitions(fieldDefinitions);

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(fieldGroupImpl);

    // Act
    pageTemplateCustomPersistenceHandler.processFieldGroups(null, pageFieldMap, propertiesList, fieldGroups);

    // Assert
    verify(fieldDefinitionImpl, atLeast(1)).getAdditionalForeignKeyClass();
    verify(fieldDefinitionImpl).getName();
    assertEquals(1, propertiesList.size());
    Property getResult = propertiesList.get(0);
    FieldMetadata metadata = getResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("Additional Foreign Key Class", metadata.getOwningClass());
    assertEquals("Name", getResult.getName());
    assertFalse(getResult.getIsDirty());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Name is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageTemplateCustomPersistenceHandler.processFieldGroups(List, Map, List, List)"})
  public void testProcessFieldGroups_thenArrayListFirstNameIsName2() {
    // Arrange
    ArrayList<String> dirtyFields = new ArrayList<>();
    dirtyFields.add("foo");
    HashMap<String, PageField> pageFieldMap = new HashMap<>();
    ArrayList<Property> propertiesList = new ArrayList<>();
    FieldDefinitionImpl fieldDefinitionImpl = mock(FieldDefinitionImpl.class);
    when(fieldDefinitionImpl.getAdditionalForeignKeyClass()).thenReturn("Additional Foreign Key Class");
    when(fieldDefinitionImpl.getName()).thenReturn("Name");

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(fieldDefinitionImpl);

    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();
    fieldGroupImpl.setFieldGroupXrefs(new ArrayList<>());
    fieldGroupImpl.setId(1L);
    fieldGroupImpl.setInitCollapsedFlag(true);
    fieldGroupImpl.setIsMasterFieldGroup(true);
    fieldGroupImpl.setName("Name");
    fieldGroupImpl.setFieldDefinitions(fieldDefinitions);

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(fieldGroupImpl);

    // Act
    pageTemplateCustomPersistenceHandler.processFieldGroups(dirtyFields, pageFieldMap, propertiesList, fieldGroups);

    // Assert
    verify(fieldDefinitionImpl, atLeast(1)).getAdditionalForeignKeyClass();
    verify(fieldDefinitionImpl).getName();
    assertEquals(1, propertiesList.size());
    Property getResult = propertiesList.get(0);
    FieldMetadata metadata = getResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("Additional Foreign Key Class", metadata.getOwningClass());
    assertEquals("Name", getResult.getName());
    assertFalse(getResult.getIsDirty());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageTemplateCustomPersistenceHandler.processFieldGroups(List, Map, List, List)"})
  public void testProcessFieldGroups_thenArrayListSizeIsTwo() {
    // Arrange
    HashMap<String, PageField> pageFieldMap = new HashMap<>();
    ArrayList<Property> propertiesList = new ArrayList<>();

    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    fieldDefinitions.add(new FieldDefinitionImpl());
    fieldDefinitions.add(new FieldDefinitionImpl());

    FieldGroupImpl fieldGroupImpl = new FieldGroupImpl();
    fieldGroupImpl.setFieldGroupXrefs(new ArrayList<>());
    fieldGroupImpl.setId(1L);
    fieldGroupImpl.setInitCollapsedFlag(true);
    fieldGroupImpl.setIsMasterFieldGroup(true);
    fieldGroupImpl.setName("Name");
    fieldGroupImpl.setFieldDefinitions(fieldDefinitions);

    ArrayList<FieldGroup> fieldGroups = new ArrayList<>();
    fieldGroups.add(fieldGroupImpl);

    // Act
    pageTemplateCustomPersistenceHandler.processFieldGroups(null, pageFieldMap, propertiesList, fieldGroups);

    // Assert
    assertEquals(2, propertiesList.size());
    Property expectedGetResult = propertiesList.get(0);
    assertEquals(expectedGetResult, propertiesList.get(1));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#processFieldGroups(List, Map, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageTemplateCustomPersistenceHandler.processFieldGroups(List, Map, List, List)"})
  public void testProcessFieldGroups_whenHashMap_thenArrayListEmpty() {
    // Arrange
    ArrayList<String> dirtyFields = new ArrayList<>();
    HashMap<String, PageField> pageFieldMap = new HashMap<>();
    ArrayList<Property> propertiesList = new ArrayList<>();

    // Act
    pageTemplateCustomPersistenceHandler.processFieldGroups(dirtyFields, pageFieldMap, propertiesList,
        new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(propertiesList.isEmpty());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#processIncludeId(boolean, Page, List)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#processIncludeId(boolean, Page, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageTemplateCustomPersistenceHandler.processIncludeId(boolean, Page, List)"})
  public void testProcessIncludeId_givenProperty_thenArrayListSizeIsTwo() {
    // Arrange
    PageImpl page = new PageImpl();

    ArrayList<Property> propertiesList = new ArrayList<>();
    propertiesList.add(new Property());

    // Act
    pageTemplateCustomPersistenceHandler.processIncludeId(true, page, propertiesList);

    // Assert
    assertEquals(2, propertiesList.size());
    Property getResult = propertiesList.get(1);
    assertTrue(getResult.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("id", getResult.getName());
    assertEquals("null", getResult.getRawValue());
    assertEquals("null", getResult.getUnHtmlEncodedValue());
    assertEquals("null", getResult.getValue());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getDeployDate());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#processIncludeId(boolean, Page, List)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#processIncludeId(boolean, Page, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageTemplateCustomPersistenceHandler.processIncludeId(boolean, Page, List)"})
  public void testProcessIncludeId_whenFalse_thenArrayListEmpty() {
    // Arrange
    PageImpl page = new PageImpl();
    ArrayList<Property> propertiesList = new ArrayList<>();

    // Act
    pageTemplateCustomPersistenceHandler.processIncludeId(false, page, propertiesList);

    // Assert that nothing has changed
    assertTrue(propertiesList.isEmpty());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#processIncludeId(boolean, Page, List)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#processIncludeId(boolean, Page, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageTemplateCustomPersistenceHandler.processIncludeId(boolean, Page, List)"})
  public void testProcessIncludeId_whenTrue_thenArrayListSizeIsOne() {
    // Arrange
    PageImpl page = new PageImpl();
    ArrayList<Property> propertiesList = new ArrayList<>();

    // Act
    pageTemplateCustomPersistenceHandler.processIncludeId(true, page, propertiesList);

    // Assert
    assertEquals(1, propertiesList.size());
    Property getResult = propertiesList.get(0);
    assertTrue(getResult.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("id", getResult.getName());
    assertEquals("null", getResult.getRawValue());
    assertEquals("null", getResult.getUnHtmlEncodedValue());
    assertEquals("null", getResult.getValue());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getDeployDate());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity PageTemplateCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testUpdate_givenNull_thenReturnEntity() throws ServiceException {
    // Arrange
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to perform update for entity: "}, "ABC123");
    persistencePackage.addCustomCriteria(null);
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertSame(entity, pageTemplateCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao,
        new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@code Unable to perform update for entity:}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity PageTemplateCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testUpdate_givenUnableToPerformUpdateForEntity_thenThrowServiceException() throws ServiceException {
    // Arrange
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to perform update for entity: "}, "ABC123");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> pageTemplateCustomPersistenceHandler.update(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then calls {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity PageTemplateCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testUpdate_thenCallsBuildDynamicPropertyList() throws ServiceException {
    // Arrange
    when(dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(Mockito.<List<FieldGroup>>any(),
        Mockito.<Class<Object>>any())).thenThrow(new NumberFormatException("Unable to perform update for entity: "));
    when(pageService.findPageById(Mockito.<Long>any())).thenReturn(new PageImpl());
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to perform update for entity: "}, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> pageTemplateCustomPersistenceHandler.update(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(dynamicFieldPersistenceHandlerHelper).buildDynamicPropertyList(isA(List.class), isA(Class.class));
    verify(pageService).findPageById(eq(42L));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then calls {@link Page#getPageTemplate()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity PageTemplateCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testUpdate_thenCallsGetPageTemplate() throws ServiceException {
    // Arrange
    PageTemplateImpl pageTemplateImpl = mock(PageTemplateImpl.class);
    when(pageTemplateImpl.getFieldGroupXrefs()).thenThrow(new NumberFormatException("foo"));
    Page page = mock(Page.class);
    when(page.getPageTemplate()).thenReturn(pageTemplateImpl);
    when(pageService.findPageById(Mockito.<Long>any())).thenReturn(page);
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to perform update for entity: "}, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> pageTemplateCustomPersistenceHandler.update(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(page, atLeast(1)).getPageTemplate();
    verify(pageTemplateImpl).getFieldGroupXrefs();
    verify(pageService).findPageById(eq(42L));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity PageTemplateCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testAdd_givenNull_thenReturnEntity() throws ServiceException {
    // Arrange
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to perform update for entity: "}, "ABC123");
    persistencePackage.addCustomCriteria(null);
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertSame(entity, pageTemplateCustomPersistenceHandler.add(persistencePackage, dynamicEntityDao,
        new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@code Unable to perform update for entity:}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity PageTemplateCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testAdd_givenUnableToPerformUpdateForEntity_thenThrowServiceException() throws ServiceException {
    // Arrange
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to perform update for entity: "}, "ABC123");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> pageTemplateCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then calls {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity PageTemplateCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testAdd_thenCallsBuildDynamicPropertyList() throws ServiceException {
    // Arrange
    when(dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(Mockito.<List<FieldGroup>>any(),
        Mockito.<Class<Object>>any())).thenThrow(new NumberFormatException("Unable to perform update for entity: "));
    when(pageService.findPageById(Mockito.<Long>any())).thenReturn(new PageImpl());
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to perform update for entity: "}, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> pageTemplateCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(dynamicFieldPersistenceHandlerHelper).buildDynamicPropertyList(isA(List.class), isA(Class.class));
    verify(pageService).findPageById(eq(42L));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then calls {@link Page#getPageTemplate()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity PageTemplateCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testAdd_thenCallsGetPageTemplate() throws ServiceException {
    // Arrange
    PageTemplateImpl pageTemplateImpl = mock(PageTemplateImpl.class);
    when(pageTemplateImpl.getFieldGroupXrefs()).thenThrow(new NumberFormatException("foo"));
    Page page = mock(Page.class);
    when(page.getPageTemplate()).thenReturn(pageTemplateImpl);
    when(pageService.findPageById(Mockito.<Long>any())).thenReturn(page);
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to perform update for entity: "}, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> pageTemplateCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(page, atLeast(1)).getPageTemplate();
    verify(pageTemplateImpl).getFieldGroupXrefs();
    verify(pageService).findPageById(eq(42L));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity PageTemplateCustomPersistenceHandler.addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testAddOrUpdate_givenNull_thenReturnEntity() throws ServiceException {
    // Arrange
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to perform update for entity: "}, "ABC123");
    persistencePackage.addCustomCriteria(null);
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertSame(entity, pageTemplateCustomPersistenceHandler.addOrUpdate(persistencePackage, dynamicEntityDao,
        new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@code Unable to perform update for entity:}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity PageTemplateCustomPersistenceHandler.addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testAddOrUpdate_givenUnableToPerformUpdateForEntity_thenThrowServiceException() throws ServiceException {
    // Arrange
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to perform update for entity: "}, "ABC123");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> pageTemplateCustomPersistenceHandler.addOrUpdate(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then calls {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List, Class)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity PageTemplateCustomPersistenceHandler.addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testAddOrUpdate_thenCallsBuildDynamicPropertyList() throws ServiceException {
    // Arrange
    when(dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(Mockito.<List<FieldGroup>>any(),
        Mockito.<Class<Object>>any())).thenThrow(new NumberFormatException("Unable to perform update for entity: "));
    when(pageService.findPageById(Mockito.<Long>any())).thenReturn(new PageImpl());
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to perform update for entity: "}, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> pageTemplateCustomPersistenceHandler.addOrUpdate(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(dynamicFieldPersistenceHandlerHelper).buildDynamicPropertyList(isA(List.class), isA(Class.class));
    verify(pageService).findPageById(eq(42L));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then calls {@link Page#getPageTemplate()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity PageTemplateCustomPersistenceHandler.addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testAddOrUpdate_thenCallsGetPageTemplate() throws ServiceException {
    // Arrange
    PageTemplateImpl pageTemplateImpl = mock(PageTemplateImpl.class);
    when(pageTemplateImpl.getFieldGroupXrefs()).thenThrow(new NumberFormatException("foo"));
    Page page = mock(Page.class);
    when(page.getPageTemplate()).thenReturn(pageTemplateImpl);
    when(pageService.findPageById(Mockito.<Long>any())).thenReturn(page);
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Unable to perform update for entity: "}, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> pageTemplateCustomPersistenceHandler.addOrUpdate(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(page, atLeast(1)).getPageTemplate();
    verify(pageTemplateImpl).getFieldGroupXrefs();
    verify(pageService).findPageById(eq(42L));
  }
}
