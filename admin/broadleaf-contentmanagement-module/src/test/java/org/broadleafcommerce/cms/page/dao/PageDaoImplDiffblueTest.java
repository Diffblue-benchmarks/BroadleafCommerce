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
package org.broadleafcommerce.cms.page.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
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
import org.broadleafcommerce.cms.page.domain.Page;
import org.broadleafcommerce.cms.page.domain.PageImpl;
import org.broadleafcommerce.cms.page.domain.PageTemplateImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PageDaoImplDiffblueTest {
  @InjectMocks private PageDaoImpl pageDaoImpl;

  /**
   * Test {@link PageDaoImpl#filterInactive(List)}.
   *
   * <p>Method under test: {@link PageDaoImpl#filterInactive(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PageDaoImpl.filterInactive(List)"})
  public void testFilterInactive() {
    // Arrange
    PageImpl pageImpl = mock(PageImpl.class);
    when(pageImpl.getActiveEndDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(pageImpl.getActiveStartDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<Page> pages = new ArrayList<>();
    pages.add(pageImpl);

    // Act
    List<Page> actualFilterInactiveResult = pageDaoImpl.filterInactive(pages);

    // Assert
    verify(pageImpl).getActiveEndDate();
    verify(pageImpl).getActiveStartDate();
    assertTrue(pages.isEmpty());
    assertTrue(actualFilterInactiveResult.isEmpty());
  }

  /**
   * Test {@link PageDaoImpl#filterInactive(List)}.
   *
   * <ul>
   *   <li>Given {@link PageImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link PageImpl} (default constructor).
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link PageDaoImpl#filterInactive(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PageDaoImpl.filterInactive(List)"})
  public void testFilterInactive_givenPageImpl_whenArrayListAddPageImpl_thenArrayListSizeIsOne() {
    // Arrange
    ArrayList<Page> pages = new ArrayList<>();
    pages.add(new PageImpl());

    // Act
    List<Page> actualFilterInactiveResult = pageDaoImpl.filterInactive(pages);

    // Assert
    assertEquals(1, pages.size());
    assertSame(pages, actualFilterInactiveResult);
  }

  /**
   * Test {@link PageDaoImpl#filterInactive(List)}.
   *
   * <ul>
   *   <li>Given {@link PageImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link PageImpl} (default constructor).
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link PageDaoImpl#filterInactive(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PageDaoImpl.filterInactive(List)"})
  public void testFilterInactive_givenPageImpl_whenArrayListAddPageImpl_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Page> pages = new ArrayList<>();
    pages.add(new PageImpl());
    PageImpl pageImpl = new PageImpl();
    pages.add(pageImpl);

    // Act
    List<Page> actualFilterInactiveResult = pageDaoImpl.filterInactive(pages);

    // Assert
    assertEquals(2, actualFilterInactiveResult.size());
    assertSame(pageImpl, actualFilterInactiveResult.get(1));
  }

  /**
   * Test {@link PageDaoImpl#filterInactive(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link PageDaoImpl#filterInactive(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PageDaoImpl.filterInactive(List)"})
  public void testFilterInactive_whenArrayList_thenArrayListEmpty() {
    // Arrange
    ArrayList<Page> pages = new ArrayList<>();

    // Act
    List<Page> actualFilterInactiveResult = pageDaoImpl.filterInactive(pages);

    // Assert
    assertTrue(pages.isEmpty());
    assertTrue(actualFilterInactiveResult.isEmpty());
  }

  /**
   * Test {@link PageDaoImpl#isActiveNow(Page)}.
   *
   * <p>Method under test: {@link PageDaoImpl#isActiveNow(Page)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageDaoImpl.isActiveNow(Page)"})
  public void testIsActiveNow() {
    // Arrange
    PageImpl page = new PageImpl();
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
    page.setPageTemplate(new PageTemplateImpl());
    page.setPriority(1);
    page.setQualifyingItemCriteria(new HashSet<>());
    page.setActiveStartDate(null);
    page.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertFalse(pageDaoImpl.isActiveNow(page));
  }

  /**
   * Test {@link PageDaoImpl#isActiveNow(Page)}.
   *
   * <p>Method under test: {@link PageDaoImpl#isActiveNow(Page)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageDaoImpl.isActiveNow(Page)"})
  public void testIsActiveNow2() {
    // Arrange
    PageImpl page = new PageImpl();
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
    page.setPageTemplate(new PageTemplateImpl());
    page.setPriority(1);
    page.setQualifyingItemCriteria(new HashSet<>());
    page.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveEndDate(null);

    // Act and Assert
    assertTrue(pageDaoImpl.isActiveNow(page));
  }

  /**
   * Test {@link PageDaoImpl#isActiveNow(Page)}.
   *
   * <ul>
   *   <li>When {@link PageImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PageDaoImpl#isActiveNow(Page)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageDaoImpl.isActiveNow(Page)"})
  public void testIsActiveNow_whenPageImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(pageDaoImpl.isActiveNow(new PageImpl()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageDaoImpl#setCurrentDateResolution(Long)}
   *   <li>{@link PageDaoImpl#getCurrentDateResolution()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long PageDaoImpl.getCurrentDateResolution()",
    "void PageDaoImpl.setCurrentDateResolution(Long)"
  })
  public void testGettersAndSetters() {
    // Arrange
    PageDaoImpl pageDaoImpl = new PageDaoImpl();

    // Act
    pageDaoImpl.setCurrentDateResolution(1L);

    // Assert
    assertEquals(1L, pageDaoImpl.getCurrentDateResolution().longValue());
  }
}
