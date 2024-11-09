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
package org.broadleafcommerce.cms.url.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
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
   * Test {@link NullURLHandler#NullURLHandler()}.
   * <p>
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
   * Test {@link NullURLHandler#NullURLHandler(String, URLRedirectType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link URLHandlerDTO#urlRedirectType} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NullURLHandler#NullURLHandler(String, URLRedirectType)}
   */
  @Test
  public void testNewNullURLHandler_whenNull_thenReturnUrlRedirectTypeIsNull() {
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
