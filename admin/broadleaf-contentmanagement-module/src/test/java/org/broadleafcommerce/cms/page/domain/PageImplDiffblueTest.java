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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class PageImplDiffblueTest {
  /**
   * Test {@link PageImpl#getOfflineFlag()}.
   * <p>
   * Method under test: {@link PageImpl#getOfflineFlag()}
   */
  @Test
  public void testGetOfflineFlag() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageImpl pageImpl = new PageImpl();
    pageImpl.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    pageImpl.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    pageImpl.setAdditionalAttributes(new HashMap<>());
    pageImpl.setDescription("The characteristics of someone or something");
    pageImpl.setExcludeFromSiteMap(true);
    pageImpl.setFullUrl("https://example.org/example");
    pageImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageImpl.setMetaDescription("Meta Description");
    pageImpl.setMetaTitle("Dr");
    pageImpl.setPageFields(new HashMap<>());
    pageImpl.setPageMatchRules(new HashMap<>());
    pageImpl.setPageTemplate(new PageTemplateImpl());
    pageImpl.setPriority(1);
    pageImpl.setQualifyingItemCriteria(new HashSet<>());
    pageImpl.setOfflineFlag(true);

    // Act and Assert
    assertTrue(pageImpl.getOfflineFlag());
  }

  /**
   * Test {@link PageImpl#getOfflineFlag()}.
   * <ul>
   *   <li>Given {@link PageImpl} (default constructor) ActiveEndDate is
   * {@link java.sql.Date}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageImpl#getOfflineFlag()}
   */
  @Test
  public void testGetOfflineFlag_givenPageImplActiveEndDateIsDate_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageImpl pageImpl = new PageImpl();
    pageImpl.setActiveEndDate(mock(java.sql.Date.class));
    pageImpl.setActiveStartDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    pageImpl.setAdditionalAttributes(new HashMap<>());
    pageImpl.setDescription("The characteristics of someone or something");
    pageImpl.setExcludeFromSiteMap(true);
    pageImpl.setFullUrl("https://example.org/example");
    pageImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageImpl.setMetaDescription("Meta Description");
    pageImpl.setMetaTitle("Dr");
    pageImpl.setPageFields(new HashMap<>());
    pageImpl.setPageMatchRules(new HashMap<>());
    pageImpl.setPageTemplate(new PageTemplateImpl());
    pageImpl.setPriority(1);
    pageImpl.setQualifyingItemCriteria(new HashSet<>());
    pageImpl.setOfflineFlag(true);

    // Act and Assert
    assertTrue(pageImpl.getOfflineFlag());
  }

  /**
   * Test {@link PageImpl#getOfflineFlag()}.
   * <ul>
   *   <li>Given {@link PageImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageImpl#getOfflineFlag()}
   */
  @Test
  public void testGetOfflineFlag_givenPageImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PageImpl()).getOfflineFlag());
  }

  /**
   * Test {@link PageImpl#setOfflineFlag(Boolean)}.
   * <p>
   * Method under test: {@link PageImpl#setOfflineFlag(Boolean)}
   */
  @Test
  public void testSetOfflineFlag() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageImpl pageImpl = new PageImpl();
    pageImpl.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    pageImpl.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    pageImpl.setAdditionalAttributes(new HashMap<>());
    pageImpl.setDescription("The characteristics of someone or something");
    pageImpl.setExcludeFromSiteMap(true);
    pageImpl.setFullUrl("https://example.org/example");
    pageImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageImpl.setMetaDescription("Meta Description");
    pageImpl.setMetaTitle("Dr");
    pageImpl.setOfflineFlag(true);
    pageImpl.setPageFields(new HashMap<>());
    pageImpl.setPageMatchRules(new HashMap<>());
    pageImpl.setPageTemplate(new PageTemplateImpl());
    pageImpl.setPriority(1);
    pageImpl.setQualifyingItemCriteria(new HashSet<>());

    // Act
    pageImpl.setOfflineFlag(null);

    // Assert
    assertFalse(pageImpl.getOfflineFlag());
    assertFalse(pageImpl.offlineFlag);
  }

  /**
   * Test {@link PageImpl#setOfflineFlag(Boolean)}.
   * <ul>
   *   <li>Given {@link PageImpl} (default constructor) ActiveEndDate is
   * {@link java.sql.Date}.</li>
   *   <li>Then not {@link PageImpl} (default constructor) OfflineFlag.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageImpl#setOfflineFlag(Boolean)}
   */
  @Test
  public void testSetOfflineFlag_givenPageImplActiveEndDateIsDate_thenNotPageImplOfflineFlag() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageImpl pageImpl = new PageImpl();
    pageImpl.setActiveEndDate(mock(java.sql.Date.class));
    pageImpl.setActiveStartDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    pageImpl.setAdditionalAttributes(new HashMap<>());
    pageImpl.setDescription("The characteristics of someone or something");
    pageImpl.setExcludeFromSiteMap(true);
    pageImpl.setFullUrl("https://example.org/example");
    pageImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageImpl.setMetaDescription("Meta Description");
    pageImpl.setMetaTitle("Dr");
    pageImpl.setOfflineFlag(true);
    pageImpl.setPageFields(new HashMap<>());
    pageImpl.setPageMatchRules(new HashMap<>());
    pageImpl.setPageTemplate(new PageTemplateImpl());
    pageImpl.setPriority(1);
    pageImpl.setQualifyingItemCriteria(new HashSet<>());

    // Act
    pageImpl.setOfflineFlag(null);

    // Assert
    assertFalse(pageImpl.getOfflineFlag());
    assertFalse(pageImpl.offlineFlag);
  }

  /**
   * Test {@link PageImpl#setOfflineFlag(Boolean)}.
   * <ul>
   *   <li>Given {@link PageImpl} (default constructor).</li>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link PageImpl} (default constructor) OfflineFlag.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageImpl#setOfflineFlag(Boolean)}
   */
  @Test
  public void testSetOfflineFlag_givenPageImpl_whenTrue_thenPageImplOfflineFlag() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageImpl pageImpl = new PageImpl();

    // Act
    pageImpl.setOfflineFlag(true);

    // Assert
    assertTrue(pageImpl.getOfflineFlag());
    assertTrue(pageImpl.offlineFlag);
  }

  /**
   * Test {@link PageImpl#getPriority()}.
   * <p>
   * Method under test: {@link PageImpl#getPriority()}
   */
  @Test
  public void testGetPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageImpl pageImpl = new PageImpl();
    pageImpl.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    pageImpl.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    pageImpl.setAdditionalAttributes(new HashMap<>());
    pageImpl.setDescription("The characteristics of someone or something");
    pageImpl.setExcludeFromSiteMap(true);
    pageImpl.setFullUrl("https://example.org/example");
    pageImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageImpl.setMetaDescription("Meta Description");
    pageImpl.setMetaTitle("Dr");
    pageImpl.setOfflineFlag(true);
    pageImpl.setPageFields(new HashMap<>());
    pageImpl.setPageMatchRules(new HashMap<>());
    pageImpl.setPageTemplate(new PageTemplateImpl());
    pageImpl.setQualifyingItemCriteria(new HashSet<>());
    pageImpl.setPriority(1);

    // Act and Assert
    assertEquals(1, pageImpl.getPriority().intValue());
  }

  /**
   * Test {@link PageImpl#getPriority()}.
   * <ul>
   *   <li>Given {@link PageImpl} (default constructor) ActiveEndDate is
   * {@link java.sql.Date}.</li>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageImpl#getPriority()}
   */
  @Test
  public void testGetPriority_givenPageImplActiveEndDateIsDate_thenReturnIntValueIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageImpl pageImpl = new PageImpl();
    pageImpl.setActiveEndDate(mock(java.sql.Date.class));
    pageImpl.setActiveStartDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    pageImpl.setAdditionalAttributes(new HashMap<>());
    pageImpl.setDescription("The characteristics of someone or something");
    pageImpl.setExcludeFromSiteMap(true);
    pageImpl.setFullUrl("https://example.org/example");
    pageImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageImpl.setMetaDescription("Meta Description");
    pageImpl.setMetaTitle("Dr");
    pageImpl.setOfflineFlag(true);
    pageImpl.setPageFields(new HashMap<>());
    pageImpl.setPageMatchRules(new HashMap<>());
    pageImpl.setPageTemplate(new PageTemplateImpl());
    pageImpl.setQualifyingItemCriteria(new HashSet<>());
    pageImpl.setPriority(1);

    // Act and Assert
    assertEquals(1, pageImpl.getPriority().intValue());
  }

  /**
   * Test {@link PageImpl#getPriority()}.
   * <ul>
   *   <li>Given {@link PageImpl} (default constructor).</li>
   *   <li>Then return intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageImpl#getPriority()}
   */
  @Test
  public void testGetPriority_givenPageImpl_thenReturnIntValueIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0, (new PageImpl()).getPriority().intValue());
  }

  /**
   * Test {@link PageImpl#getExcludeFromSiteMap()}.
   * <p>
   * Method under test: {@link PageImpl#getExcludeFromSiteMap()}
   */
  @Test
  public void testGetExcludeFromSiteMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageImpl pageImpl = new PageImpl();
    pageImpl.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    pageImpl.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    pageImpl.setAdditionalAttributes(new HashMap<>());
    pageImpl.setDescription("The characteristics of someone or something");
    pageImpl.setFullUrl("https://example.org/example");
    pageImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageImpl.setMetaDescription("Meta Description");
    pageImpl.setMetaTitle("Dr");
    pageImpl.setOfflineFlag(true);
    pageImpl.setPageFields(new HashMap<>());
    pageImpl.setPageMatchRules(new HashMap<>());
    pageImpl.setPageTemplate(new PageTemplateImpl());
    pageImpl.setPriority(1);
    pageImpl.setQualifyingItemCriteria(new HashSet<>());
    pageImpl.setExcludeFromSiteMap(true);

    // Act and Assert
    assertTrue(pageImpl.getExcludeFromSiteMap());
  }

  /**
   * Test {@link PageImpl#getExcludeFromSiteMap()}.
   * <ul>
   *   <li>Given {@link PageImpl} (default constructor) ActiveEndDate is
   * {@link java.sql.Date}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageImpl#getExcludeFromSiteMap()}
   */
  @Test
  public void testGetExcludeFromSiteMap_givenPageImplActiveEndDateIsDate_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageImpl pageImpl = new PageImpl();
    pageImpl.setActiveEndDate(mock(java.sql.Date.class));
    pageImpl.setActiveStartDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    pageImpl.setAdditionalAttributes(new HashMap<>());
    pageImpl.setDescription("The characteristics of someone or something");
    pageImpl.setFullUrl("https://example.org/example");
    pageImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageImpl.setMetaDescription("Meta Description");
    pageImpl.setMetaTitle("Dr");
    pageImpl.setOfflineFlag(true);
    pageImpl.setPageFields(new HashMap<>());
    pageImpl.setPageMatchRules(new HashMap<>());
    pageImpl.setPageTemplate(new PageTemplateImpl());
    pageImpl.setPriority(1);
    pageImpl.setQualifyingItemCriteria(new HashSet<>());
    pageImpl.setExcludeFromSiteMap(true);

    // Act and Assert
    assertTrue(pageImpl.getExcludeFromSiteMap());
  }

  /**
   * Test {@link PageImpl#getExcludeFromSiteMap()}.
   * <ul>
   *   <li>Given {@link PageImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageImpl#getExcludeFromSiteMap()}
   */
  @Test
  public void testGetExcludeFromSiteMap_givenPageImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PageImpl()).getExcludeFromSiteMap());
  }

  /**
   * Test {@link PageImpl#setExcludeFromSiteMap(boolean)}.
   * <ul>
   *   <li>Given {@link PageImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageImpl#setExcludeFromSiteMap(boolean)}
   */
  @Test
  public void testSetExcludeFromSiteMap_givenPageImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageImpl pageImpl = new PageImpl();

    // Act
    pageImpl.setExcludeFromSiteMap(true);

    // Assert
    assertTrue(pageImpl.getExcludeFromSiteMap());
    assertTrue(pageImpl.excludeFromSiteMap);
  }

  /**
   * Test {@link PageImpl#setExcludeFromSiteMap(boolean)}.
   * <ul>
   *   <li>Given {@link PageImpl} (default constructor) PageTemplate is
   * {@link PageTemplateImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageImpl#setExcludeFromSiteMap(boolean)}
   */
  @Test
  public void testSetExcludeFromSiteMap_givenPageImplPageTemplateIsPageTemplateImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageImpl pageImpl = new PageImpl();
    pageImpl.setPageTemplate(mock(PageTemplateImpl.class));

    // Act
    pageImpl.setExcludeFromSiteMap(true);

    // Assert
    assertTrue(pageImpl.getExcludeFromSiteMap());
    assertTrue(pageImpl.excludeFromSiteMap);
  }

  /**
   * Test {@link PageImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link PageImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageImpl pageImpl = new PageImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Page> actualCreateOrRetrieveCopyInstanceResult = pageImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link PageImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>Then Clone return {@link PageImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_givenJavaLangObject_thenCloneReturnPageImpl()
      throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageImpl pageImpl = new PageImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<Page> actualCreateOrRetrieveCopyInstanceResult = pageImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.cms.page.domain.PageImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    Page clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof PageImpl);
    assertNull(((PageImpl) clone).priority);
    assertNull(clone.getId());
    assertNull(clone.getDescription());
    assertNull(clone.getFullUrl());
    assertNull(clone.getMetaDescription());
    assertNull(clone.getMetaTitle());
    assertNull(((PageImpl) clone).getLocation());
    assertNull(((PageImpl) clone).getMainEntityName());
    assertNull(clone.getActiveEndDate());
    assertNull(clone.getActiveStartDate());
    assertNull(clone.getPageTemplate());
    assertEquals(0, clone.getPriority().intValue());
    assertFalse(clone.getExcludeFromSiteMap());
    assertFalse(clone.getOfflineFlag());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertFalse(((PageImpl) clone).excludeFromSiteMap);
    assertFalse(((PageImpl) clone).offlineFlag);
    assertTrue(clone.getAdditionalAttributes().isEmpty());
    assertTrue(clone.getPageFields().isEmpty());
    assertTrue(clone.getPageMatchRules().isEmpty());
    assertTrue(clone.getQualifyingItemCriteria().isEmpty());
  }

  /**
   * Test {@link PageImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link PageImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenPageImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new PageImpl()).getMainEntityName());
  }

  /**
   * Test {@link PageImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link PageImpl} (default constructor) PageTemplate is
   * {@link PageTemplateImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenPageImplPageTemplateIsPageTemplateImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageImpl pageImpl = new PageImpl();
    pageImpl.setPageTemplate(mock(PageTemplateImpl.class));

    // Act and Assert
    assertNull(pageImpl.getMainEntityName());
  }

  /**
   * Test {@link PageImpl#getLocation()}.
   * <ul>
   *   <li>Given {@link PageImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageImpl#getLocation()}
   */
  @Test
  public void testGetLocation_givenPageImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new PageImpl()).getLocation());
  }

  /**
   * Test {@link PageImpl#getLocation()}.
   * <ul>
   *   <li>Given {@link PageImpl} (default constructor) PageTemplate is
   * {@link PageTemplateImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageImpl#getLocation()}
   */
  @Test
  public void testGetLocation_givenPageImplPageTemplateIsPageTemplateImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageImpl pageImpl = new PageImpl();
    pageImpl.setPageTemplate(mock(PageTemplateImpl.class));

    // Act and Assert
    assertNull(pageImpl.getLocation());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PageImpl}
   *   <li>{@link PageImpl#setActiveEndDate(Date)}
   *   <li>{@link PageImpl#setActiveStartDate(Date)}
   *   <li>{@link PageImpl#setAdditionalAttributes(Map)}
   *   <li>{@link PageImpl#setDescription(String)}
   *   <li>{@link PageImpl#setFullUrl(String)}
   *   <li>{@link PageImpl#setId(Long)}
   *   <li>{@link PageImpl#setMetaDescription(String)}
   *   <li>{@link PageImpl#setMetaTitle(String)}
   *   <li>{@link PageImpl#setPageFields(Map)}
   *   <li>{@link PageImpl#setPageMatchRules(Map)}
   *   <li>{@link PageImpl#setPageTemplate(PageTemplate)}
   *   <li>{@link PageImpl#setPriority(Integer)}
   *   <li>{@link PageImpl#setQualifyingItemCriteria(Set)}
   *   <li>{@link PageImpl#getActiveEndDate()}
   *   <li>{@link PageImpl#getActiveStartDate()}
   *   <li>{@link PageImpl#getAdditionalAttributes()}
   *   <li>{@link PageImpl#getDescription()}
   *   <li>{@link PageImpl#getFullUrl()}
   *   <li>{@link PageImpl#getId()}
   *   <li>{@link PageImpl#getMetaDescription()}
   *   <li>{@link PageImpl#getMetaTitle()}
   *   <li>{@link PageImpl#getPageFields()}
   *   <li>{@link PageImpl#getPageMatchRules()}
   *   <li>{@link PageImpl#getPageTemplate()}
   *   <li>{@link PageImpl#getQualifyingItemCriteria()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PageImpl actualPageImpl = new PageImpl();
    Date activeEndDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualPageImpl.setActiveEndDate(activeEndDate);
    Date activeStartDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualPageImpl.setActiveStartDate(activeStartDate);
    HashMap<String, PageAttribute> additionalAttributes = new HashMap<>();
    actualPageImpl.setAdditionalAttributes(additionalAttributes);
    actualPageImpl.setDescription("The characteristics of someone or something");
    actualPageImpl.setFullUrl("https://example.org/example");
    actualPageImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    actualPageImpl.setMetaDescription("Meta Description");
    actualPageImpl.setMetaTitle("Dr");
    HashMap<String, PageField> pageFields = new HashMap<>();
    actualPageImpl.setPageFields(pageFields);
    HashMap<String, PageRule> pageMatchRules = new HashMap<>();
    actualPageImpl.setPageMatchRules(pageMatchRules);
    PageTemplateImpl pageTemplate = new PageTemplateImpl();
    actualPageImpl.setPageTemplate(pageTemplate);
    actualPageImpl.setPriority(1);
    HashSet<PageItemCriteria> qualifyingItemCriteria = new HashSet<>();
    actualPageImpl.setQualifyingItemCriteria(qualifyingItemCriteria);
    Date actualActiveEndDate = actualPageImpl.getActiveEndDate();
    Date actualActiveStartDate = actualPageImpl.getActiveStartDate();
    Map<String, PageAttribute> actualAdditionalAttributes = actualPageImpl.getAdditionalAttributes();
    String actualDescription = actualPageImpl.getDescription();
    String actualFullUrl = actualPageImpl.getFullUrl();
    Long actualId = actualPageImpl.getId();
    String actualMetaDescription = actualPageImpl.getMetaDescription();
    String actualMetaTitle = actualPageImpl.getMetaTitle();
    Map<String, PageField> actualPageFields = actualPageImpl.getPageFields();
    Map<String, PageRule> actualPageMatchRules = actualPageImpl.getPageMatchRules();
    PageTemplate actualPageTemplate = actualPageImpl.getPageTemplate();
    Set<PageItemCriteria> actualQualifyingItemCriteria = actualPageImpl.getQualifyingItemCriteria();

    // Assert that nothing has changed
    assertEquals("Dr", actualMetaTitle);
    assertEquals("Meta Description", actualMetaDescription);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals("https://example.org/example", actualFullUrl);
    assertEquals(1, actualPageImpl.priority.intValue());
    assertTrue(actualAdditionalAttributes.isEmpty());
    assertTrue(actualPageFields.isEmpty());
    assertTrue(actualPageMatchRules.isEmpty());
    assertTrue(actualQualifyingItemCriteria.isEmpty());
    assertEquals(PageItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(additionalAttributes, actualAdditionalAttributes);
    assertSame(pageFields, actualPageFields);
    assertSame(pageMatchRules, actualPageMatchRules);
    assertSame(qualifyingItemCriteria, actualQualifyingItemCriteria);
    assertSame(pageTemplate, actualPageTemplate);
    assertSame(activeEndDate, actualActiveEndDate);
    assertSame(activeStartDate, actualActiveStartDate);
  }
}
