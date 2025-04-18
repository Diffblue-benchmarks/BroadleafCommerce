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
package org.broadleafcommerce.cms.admin.server.persistence.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {HTMLFieldPersistenceProvider.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class HTMLFieldPersistenceProviderDiffblueTest {
  @Autowired
  private HTMLFieldPersistenceProvider hTMLFieldPersistenceProvider;

  /**
   * Test {@link HTMLFieldPersistenceProvider#fixAssetPathsForStorage(String)}.
   * <ul>
   *   <li>Given {@link HTMLFieldPersistenceProvider} (default constructor).</li>
   *   <li>Then return {@code Val}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HTMLFieldPersistenceProvider#fixAssetPathsForStorage(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String HTMLFieldPersistenceProvider.fixAssetPathsForStorage(String)"})
  public void testFixAssetPathsForStorage_givenHTMLFieldPersistenceProvider_thenReturnVal() {
    // Arrange, Act and Assert
    assertEquals("Val", (new HTMLFieldPersistenceProvider()).fixAssetPathsForStorage("Val"));
  }

  /**
   * Test {@link HTMLFieldPersistenceProvider#fixAssetPathsForStorage(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HTMLFieldPersistenceProvider#fixAssetPathsForStorage(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String HTMLFieldPersistenceProvider.fixAssetPathsForStorage(String)"})
  public void testFixAssetPathsForStorage_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(hTMLFieldPersistenceProvider.fixAssetPathsForStorage(null));
  }

  /**
   * Test {@link HTMLFieldPersistenceProvider#fixAssetPathsForDisplay(String)}.
   * <p>
   * Method under test: {@link HTMLFieldPersistenceProvider#fixAssetPathsForDisplay(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String HTMLFieldPersistenceProvider.fixAssetPathsForDisplay(String)"})
  public void testFixAssetPathsForDisplay() {
    // Arrange, Act and Assert
    assertEquals("Val", (new HTMLFieldPersistenceProvider()).fixAssetPathsForDisplay("Val"));
  }

  /**
   * Test {@link HTMLFieldPersistenceProvider#getOrder()}.
   * <p>
   * Method under test: {@link HTMLFieldPersistenceProvider#getOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int HTMLFieldPersistenceProvider.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(60000, (new HTMLFieldPersistenceProvider()).getOrder());
  }
}
