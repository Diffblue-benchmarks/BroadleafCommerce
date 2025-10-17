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
package org.broadleafcommerce.core.search.service.solr.indexer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractSolrIndexUpdateServiceImplDiffblueTest {
  @Autowired private AbstractSolrIndexUpdateServiceImpl abstractSolrIndexUpdateServiceImpl;

  @MockBean private CatalogSolrIndexUpdateServiceImpl catalogSolrIndexUpdateServiceImpl;

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#getCommandGroup()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSolrIndexUpdateServiceImpl#getCommandGroup()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractSolrIndexUpdateServiceImpl.getCommandGroup()"})
  public void testGetCommandGroup_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(abstractSolrIndexUpdateServiceImpl.getCommandGroup());
  }

  /**
   * Test {@link AbstractSolrIndexUpdateServiceImpl#isRunning(String)}.
   *
   * <p>Method under test: {@link AbstractSolrIndexUpdateServiceImpl#isRunning(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractSolrIndexUpdateServiceImpl.isRunning(String)"})
  public void testIsRunning() {
    // Arrange, Act and Assert
    assertFalse(AbstractSolrIndexUpdateServiceImpl.isRunning("42"));
  }
}
