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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
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
public class PageImplDiffblueTest {
  @Autowired private PageImpl pageImpl;

  /**
   * Test {@link PageImpl#getOfflineFlag()}.
   *
   * <ul>
   *   <li>Given {@link PageImpl} OfflineFlag is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PageImpl#getOfflineFlag()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean PageImpl.getOfflineFlag()"})
  public void testGetOfflineFlag_givenPageImplOfflineFlagIsTrue_thenReturnTrue() {
    // Arrange
    pageImpl.setOfflineFlag(true);

    // Act and Assert
    assertTrue(pageImpl.getOfflineFlag());
  }

  /**
   * Test {@link PageImpl#getOfflineFlag()}.
   *
   * <ul>
   *   <li>Given {@link PageImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PageImpl#getOfflineFlag()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean PageImpl.getOfflineFlag()"})
  public void testGetOfflineFlag_givenPageImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(pageImpl.getOfflineFlag());
  }

  /**
   * Test {@link PageImpl#setOfflineFlag(Boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then not {@link PageImpl} OfflineFlag.
   * </ul>
   *
   * <p>Method under test: {@link PageImpl#setOfflineFlag(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageImpl.setOfflineFlag(Boolean)"})
  public void testSetOfflineFlag_whenNull_thenNotPageImplOfflineFlag() {
    // Arrange and Act
    pageImpl.setOfflineFlag(null);

    // Assert that nothing has changed
    assertFalse(pageImpl.getOfflineFlag());
    assertFalse(pageImpl.offlineFlag);
  }

  /**
   * Test {@link PageImpl#setOfflineFlag(Boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PageImpl} OfflineFlag.
   * </ul>
   *
   * <p>Method under test: {@link PageImpl#setOfflineFlag(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageImpl.setOfflineFlag(Boolean)"})
  public void testSetOfflineFlag_whenTrue_thenPageImplOfflineFlag() {
    // Arrange and Act
    pageImpl.setOfflineFlag(true);

    // Assert
    assertTrue(pageImpl.getOfflineFlag());
    assertTrue(pageImpl.offlineFlag);
  }

  /**
   * Test {@link PageImpl#getPriority()}.
   *
   * <ul>
   *   <li>Given {@link PageImpl} Priority is one.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link PageImpl#getPriority()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer PageImpl.getPriority()"})
  public void testGetPriority_givenPageImplPriorityIsOne_thenReturnIntValueIsOne() {
    // Arrange
    pageImpl.setPriority(1);

    // Act and Assert
    assertEquals(1, pageImpl.getPriority().intValue());
  }

  /**
   * Test {@link PageImpl#getPriority()}.
   *
   * <ul>
   *   <li>Given {@link PageImpl}.
   *   <li>Then return intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link PageImpl#getPriority()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer PageImpl.getPriority()"})
  public void testGetPriority_givenPageImpl_thenReturnIntValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, pageImpl.getPriority().intValue());
  }

  /**
   * Test {@link PageImpl#getExcludeFromSiteMap()}.
   *
   * <ul>
   *   <li>Given {@link PageImpl} ExcludeFromSiteMap is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PageImpl#getExcludeFromSiteMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageImpl.getExcludeFromSiteMap()"})
  public void testGetExcludeFromSiteMap_givenPageImplExcludeFromSiteMapIsTrue_thenReturnTrue() {
    // Arrange
    pageImpl.setExcludeFromSiteMap(true);

    // Act and Assert
    assertTrue(pageImpl.getExcludeFromSiteMap());
  }

  /**
   * Test {@link PageImpl#getExcludeFromSiteMap()}.
   *
   * <ul>
   *   <li>Given {@link PageImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PageImpl#getExcludeFromSiteMap()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageImpl.getExcludeFromSiteMap()"})
  public void testGetExcludeFromSiteMap_givenPageImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(pageImpl.getExcludeFromSiteMap());
  }

  /**
   * Test {@link PageImpl#setExcludeFromSiteMap(boolean)}.
   *
   * <p>Method under test: {@link PageImpl#setExcludeFromSiteMap(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageImpl.setExcludeFromSiteMap(boolean)"})
  public void testSetExcludeFromSiteMap() {
    // Arrange and Act
    pageImpl.setExcludeFromSiteMap(true);

    // Assert
    assertTrue(pageImpl.getExcludeFromSiteMap());
    assertTrue(pageImpl.excludeFromSiteMap);
  }

  /**
   * Test {@link PageImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link PageImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse PageImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new PageImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Page> actualCreateOrRetrieveCopyInstanceResult =
        pageImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link PageImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link PageImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse PageImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(pageImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Page> actualCreateOrRetrieveCopyInstanceResult =
        pageImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link PageImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link PageImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse PageImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // Arrange
    PageTemplateImpl pageTemplate = mock(PageTemplateImpl.class);
    when(pageTemplate.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new PageTemplateImpl(), true));

    PageImpl pageImpl = new PageImpl();
    pageImpl.setPageTemplate(pageTemplate);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new PageImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    pageImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(pageTemplate).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
  }

  /**
   * Test {@link PageImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then throw {@link CloneNotSupportedException}.
   * </ul>
   *
   * <p>Method under test: {@link PageImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse PageImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenThrowCloneNotSupportedException()
      throws CloneNotSupportedException {
    // Arrange
    PageTemplateImpl pageTemplate = mock(PageTemplateImpl.class);
    when(pageTemplate.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenThrow(new CloneNotSupportedException());

    PageImpl pageImpl = new PageImpl();
    pageImpl.setPageTemplate(pageTemplate);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new PageImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act and Assert
    assertThrows(
        CloneNotSupportedException.class, () -> pageImpl.createOrRetrieveCopyInstance(context));
    verify(pageTemplate).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
  }

  /**
   * Test {@link PageImpl#getMainEntityName()}.
   *
   * <p>Method under test: {@link PageImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PageImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull(pageImpl.getMainEntityName());
  }

  /**
   * Test {@link PageImpl#getLocation()}.
   *
   * <p>Method under test: {@link PageImpl#getLocation()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PageImpl.getLocation()"})
  public void testGetLocation() {
    // Arrange, Act and Assert
    assertNull(pageImpl.getLocation());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageImpl.<init>()",
    "Date PageImpl.getActiveEndDate()",
    "Date PageImpl.getActiveStartDate()",
    "Map PageImpl.getAdditionalAttributes()",
    "String PageImpl.getDescription()",
    "String PageImpl.getFullUrl()",
    "Long PageImpl.getId()",
    "String PageImpl.getMetaDescription()",
    "String PageImpl.getMetaTitle()",
    "Map PageImpl.getPageFields()",
    "Map PageImpl.getPageMatchRules()",
    "PageTemplate PageImpl.getPageTemplate()",
    "Set PageImpl.getQualifyingItemCriteria()",
    "void PageImpl.setActiveEndDate(Date)",
    "void PageImpl.setActiveStartDate(Date)",
    "void PageImpl.setAdditionalAttributes(Map)",
    "void PageImpl.setDescription(String)",
    "void PageImpl.setFullUrl(String)",
    "void PageImpl.setId(Long)",
    "void PageImpl.setMetaDescription(String)",
    "void PageImpl.setMetaTitle(String)",
    "void PageImpl.setPageFields(Map)",
    "void PageImpl.setPageMatchRules(Map)",
    "void PageImpl.setPageTemplate(PageTemplate)",
    "void PageImpl.setPriority(Integer)",
    "void PageImpl.setQualifyingItemCriteria(Set)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    PageImpl actualPageImpl = new PageImpl();
    Date activeEndDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualPageImpl.setActiveEndDate(activeEndDate);
    Date activeStartDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
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
    Map<String, PageAttribute> actualAdditionalAttributes =
        actualPageImpl.getAdditionalAttributes();
    String actualDescription = actualPageImpl.getDescription();
    String actualFullUrl = actualPageImpl.getFullUrl();
    Long actualId = actualPageImpl.getId();
    String actualMetaDescription = actualPageImpl.getMetaDescription();
    String actualMetaTitle = actualPageImpl.getMetaTitle();
    Map<String, PageField> actualPageFields = actualPageImpl.getPageFields();
    Map<String, PageRule> actualPageMatchRules = actualPageImpl.getPageMatchRules();
    PageTemplate actualPageTemplate = actualPageImpl.getPageTemplate();
    Set<PageItemCriteria> actualQualifyingItemCriteria = actualPageImpl.getQualifyingItemCriteria();

    // Assert
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
