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
package org.broadleafcommerce.cms.url.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.broadleafcommerce.cms.url.type.URLRedirectType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {NullURLHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NullURLHandlerDiffblueTest {
  @Autowired
  private NullURLHandler nullURLHandler;

  /**
   * Method under test: {@link NullURLHandler#NullURLHandler()}
   */
  @Test
  public void testNewNullURLHandler() {
    // Arrange and Act
    NullURLHandler actualNullURLHandler = new NullURLHandler();

    // Assert
    assertEquals("", actualNullURLHandler.getIncomingURL());
    assertNull(actualNullURLHandler.getId());
    assertNull(actualNullURLHandler.getNewURL());
    assertNull(actualNullURLHandler.urlRedirectType);
    assertNull(actualNullURLHandler.getUrlRedirectType());
    assertFalse(actualNullURLHandler.isRegexHandler());
  }

  /**
   * Method under test:
   * {@link NullURLHandler#NullURLHandler(String, URLRedirectType)}
   */
  @Test
  public void testNewNullURLHandler2() {
    // Arrange
    URLRedirectType redirectType = URLRedirectType.FORWARD;

    // Act
    NullURLHandler actualNullURLHandler = new NullURLHandler("https://example.org/example", redirectType);

    // Assert
    assertEquals("", actualNullURLHandler.getIncomingURL());
    assertEquals("FORWARD", actualNullURLHandler.urlRedirectType);
    assertEquals("https://example.org/example", actualNullURLHandler.getNewURL());
    assertNull(actualNullURLHandler.getId());
    assertFalse(actualNullURLHandler.isRegexHandler());
    URLRedirectType expectedUrlRedirectType = redirectType.FORWARD;
    assertSame(expectedUrlRedirectType, actualNullURLHandler.getUrlRedirectType());
  }

  /**
   * Method under test:
   * {@link NullURLHandler#NullURLHandler(String, URLRedirectType)}
   */
  @Test
  public void testNewNullURLHandler3() {
    // Arrange and Act
    NullURLHandler actualNullURLHandler = new NullURLHandler("https://example.org/example", null);

    // Assert
    assertEquals("", actualNullURLHandler.getIncomingURL());
    assertEquals("https://example.org/example", actualNullURLHandler.getNewURL());
    assertNull(actualNullURLHandler.getId());
    assertNull(actualNullURLHandler.urlRedirectType);
    assertNull(actualNullURLHandler.getUrlRedirectType());
    assertFalse(actualNullURLHandler.isRegexHandler());
  }
}
