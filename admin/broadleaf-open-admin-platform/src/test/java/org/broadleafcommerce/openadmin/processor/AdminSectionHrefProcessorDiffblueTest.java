/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.processor;

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

public class AdminSectionHrefProcessorDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminSectionHrefProcessor#getName()}
   *   <li>{@link AdminSectionHrefProcessor#getPrefix()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    AdminSectionHrefProcessor adminSectionHrefProcessor = new AdminSectionHrefProcessor();

    // Act
    String actualName = adminSectionHrefProcessor.getName();

    // Assert
    assertEquals("admin_section_href", actualName);
    assertEquals("blc_admin", adminSectionHrefProcessor.getPrefix());
  }

  /**
   * Test {@link AdminSectionHrefProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link AdminSectionHrefProcessor#getPrecedence()}
   */
  @Test
  public void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10002, (new AdminSectionHrefProcessor()).getPrecedence());
  }

  /**
   * Test
   * {@link AdminSectionHrefProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return Added size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSectionHrefProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_givenNull_thenReturnAddedSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSectionHrefProcessor adminSectionHrefProcessor = new AdminSectionHrefProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(null);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminSectionHrefProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("#", added.get("href"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }
}
