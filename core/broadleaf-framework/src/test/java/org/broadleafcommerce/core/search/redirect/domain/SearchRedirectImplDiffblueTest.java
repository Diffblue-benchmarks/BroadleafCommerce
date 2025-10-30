/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.search.redirect.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SearchRedirectImplDiffblueTest {
  @Autowired
  private SearchRedirectImpl searchRedirectImpl;

  /**
   * Test {@link SearchRedirectImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link SearchRedirectImpl#getMainEntityName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SearchRedirectImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull((new SearchRedirectImpl()).getMainEntityName());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SearchRedirectImpl}
   *   <li>{@link SearchRedirectImpl#setActiveEndDate(Date)}
   *   <li>{@link SearchRedirectImpl#setActiveStartDate(Date)}
   *   <li>{@link SearchRedirectImpl#setId(Long)}
   *   <li>{@link SearchRedirectImpl#setSearchPriority(Integer)}
   *   <li>{@link SearchRedirectImpl#setSearchTerm(String)}
   *   <li>{@link SearchRedirectImpl#setUrl(String)}
   *   <li>{@link SearchRedirectImpl#getActiveEndDate()}
   *   <li>{@link SearchRedirectImpl#getActiveStartDate()}
   *   <li>{@link SearchRedirectImpl#getId()}
   *   <li>{@link SearchRedirectImpl#getSearchPriority()}
   *   <li>{@link SearchRedirectImpl#getSearchTerm()}
   *   <li>{@link SearchRedirectImpl#getUrl()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SearchRedirectImpl.<init>()", "Date SearchRedirectImpl.getActiveEndDate()",
      "Date SearchRedirectImpl.getActiveStartDate()", "Long SearchRedirectImpl.getId()",
      "Integer SearchRedirectImpl.getSearchPriority()", "String SearchRedirectImpl.getSearchTerm()",
      "String SearchRedirectImpl.getUrl()", "void SearchRedirectImpl.setActiveEndDate(Date)",
      "void SearchRedirectImpl.setActiveStartDate(Date)", "void SearchRedirectImpl.setId(Long)",
      "void SearchRedirectImpl.setSearchPriority(Integer)", "void SearchRedirectImpl.setSearchTerm(String)",
      "void SearchRedirectImpl.setUrl(String)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    SearchRedirectImpl actualSearchRedirectImpl = new SearchRedirectImpl();
    Date activeEndDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualSearchRedirectImpl.setActiveEndDate(activeEndDate);
    Date activeStartDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualSearchRedirectImpl.setActiveStartDate(activeStartDate);
    actualSearchRedirectImpl.setId(1L);
    actualSearchRedirectImpl.setSearchPriority(1);
    actualSearchRedirectImpl.setSearchTerm("Search Term");
    actualSearchRedirectImpl.setUrl("https://example.org/example");
    Date actualActiveEndDate = actualSearchRedirectImpl.getActiveEndDate();
    Date actualActiveStartDate = actualSearchRedirectImpl.getActiveStartDate();
    Long actualId = actualSearchRedirectImpl.getId();
    Integer actualSearchPriority = actualSearchRedirectImpl.getSearchPriority();
    String actualSearchTerm = actualSearchRedirectImpl.getSearchTerm();

    // Assert
    assertEquals("Search Term", actualSearchTerm);
    assertEquals("https://example.org/example", actualSearchRedirectImpl.getUrl());
    assertEquals(1, actualSearchPriority.intValue());
    assertEquals(1L, actualId.longValue());
    assertSame(activeEndDate, actualActiveEndDate);
    assertSame(activeStartDate, actualActiveStartDate);
  }
}
