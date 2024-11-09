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
package org.broadleafcommerce.cms.web.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.presentation.model.BroadleafAttributeModifier;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
import org.mockito.Mockito;

public class HrefUrlRewriteProcessorDiffblueTest {
  /**
   * Test {@link HrefUrlRewriteProcessor#getName()}.
   * <p>
   * Method under test: {@link HrefUrlRewriteProcessor#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("href", (new HrefUrlRewriteProcessor()).getName());
  }

  /**
   * Test
   * {@link HrefUrlRewriteProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code useCDN}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code useCDN} is {@code useCDN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HrefUrlRewriteProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_givenUseCDN_whenHashMapUseCDNIsUseCDN() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HrefUrlRewriteProcessor hrefUrlRewriteProcessor = new HrefUrlRewriteProcessor();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("useCDN", "useCDN");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = hrefUrlRewriteProcessor.getModifiedAttributes(
        "https://example.org/example", tagAttributes, "https://example.org/example", "https://example.org/example",
        context);

    // Assert
    verify(context).parseExpression(eq("https://example.org/example"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("Parse Expression", added.get("href"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test
   * {@link HrefUrlRewriteProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return Added size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HrefUrlRewriteProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_whenHashMap_thenReturnAddedSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HrefUrlRewriteProcessor hrefUrlRewriteProcessor = new HrefUrlRewriteProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = hrefUrlRewriteProcessor.getModifiedAttributes(
        "https://example.org/example", tagAttributes, "https://example.org/example", "https://example.org/example",
        context);

    // Assert
    verify(context).parseExpression(eq("https://example.org/example"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("Parse Expression", added.get("href"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test
   * {@link HrefUrlRewriteProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return Added size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HrefUrlRewriteProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_whenSlash_thenReturnAddedSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HrefUrlRewriteProcessor hrefUrlRewriteProcessor = new HrefUrlRewriteProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = hrefUrlRewriteProcessor.getModifiedAttributes(
        "https://example.org/example", tagAttributes, "https://example.org/example", "/", context);

    // Assert
    verify(context).parseExpression(eq("@{ / }"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("Parse Expression", added.get("href"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }
}
