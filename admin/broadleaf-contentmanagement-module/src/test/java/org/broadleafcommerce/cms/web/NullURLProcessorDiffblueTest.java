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
package org.broadleafcommerce.cms.web;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {NullURLProcessor.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NullURLProcessorDiffblueTest {
  @Autowired
  private NullURLProcessor nullURLProcessor;

  /**
   * Test {@link NullURLProcessor#canProcessURL(String)}.
   * <p>
   * Method under test: {@link NullURLProcessor#canProcessURL(String)}
   */
  @Test
  public void testCanProcessURL() {
    // Arrange, Act and Assert
    assertTrue(nullURLProcessor.canProcessURL("https://example.org/example"));
  }

  /**
   * Test {@link NullURLProcessor#processURL(String)}.
   * <p>
   * Method under test: {@link NullURLProcessor#processURL(String)}
   */
  @Test
  public void testProcessURL() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullURLProcessor.processURL("https://example.org/example"));
  }
}
