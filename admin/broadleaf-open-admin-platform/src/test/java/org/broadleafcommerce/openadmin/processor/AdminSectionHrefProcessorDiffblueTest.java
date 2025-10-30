/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.presentation.model.BroadleafAttributeModifier;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdminSectionHrefProcessorDiffblueTest {
  @InjectMocks
  private AdminSectionHrefProcessor adminSectionHrefProcessor;

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminSectionHrefProcessor.getName()", "String AdminSectionHrefProcessor.getPrefix()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AdminSectionHrefProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10002, adminSectionHrefProcessor.getPrecedence());
  }

  /**
   * Test {@link AdminSectionHrefProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return Added size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSectionHrefProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminSectionHrefProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_givenNull_thenReturnAddedSizeIsOne() {
    // Arrange
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
