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

public class PageDaoImplDiffblueTest {
  /**
   * Method under test: {@link PageDaoImpl#filterInactive(List)}
   */
  @Test
  public void testFilterInactive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDaoImpl pageDaoImpl = new PageDaoImpl();
    ArrayList<Page> pages = new ArrayList<>();

    // Act
    List<Page> actualFilterInactiveResult = pageDaoImpl.filterInactive(pages);

    // Assert
    assertTrue(actualFilterInactiveResult.isEmpty());
    assertSame(pages, actualFilterInactiveResult);
  }

  /**
   * Method under test: {@link PageDaoImpl#isActiveNow(Page)}
   */
  @Test
  public void testIsActiveNow() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDaoImpl pageDaoImpl = new PageDaoImpl();

    // Act and Assert
    assertTrue(pageDaoImpl.isActiveNow(new PageImpl()));
  }

  /**
   * Method under test: {@link PageDaoImpl#isActiveNow(Page)}
   */
  @Test
  public void testIsActiveNow2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDaoImpl pageDaoImpl = new PageDaoImpl();

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
    page.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertFalse(pageDaoImpl.isActiveNow(page));
  }

  /**
   * Method under test: {@link PageDaoImpl#isActiveNow(Page)}
   */
  @Test
  public void testIsActiveNow3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDaoImpl pageDaoImpl = new PageDaoImpl();

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
    page.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    page.setActiveEndDate(null);

    // Act and Assert
    assertTrue(pageDaoImpl.isActiveNow(page));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PageDaoImpl#setCurrentDateResolution(Long)}
   *   <li>{@link PageDaoImpl#getCurrentDateResolution()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    PageDaoImpl pageDaoImpl = new PageDaoImpl();

    // Act
    pageDaoImpl.setCurrentDateResolution(1L);

    // Assert that nothing has changed
    assertEquals(1L, pageDaoImpl.getCurrentDateResolution().longValue());
  }
}
