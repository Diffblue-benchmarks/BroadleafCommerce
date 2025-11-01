/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.web.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;

public class FormProcessorDiffblueTest {
  /**
   * Method under test: {@link FormProcessor#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("form", (new FormProcessor()).getName());
  }

  /**
   * Method under test: {@link FormProcessor#getPrecedence()}
   */
  @Test
  public void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(1001, (new FormProcessor()).getPrecedence());
  }

  /**
   * Method under test:
   * {@link FormProcessor#getInjectedModelAndTagAttributes(String, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testGetInjectedModelAndTagAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormProcessor formProcessor = new FormProcessor();
    HashMap<String, String> rootTagAttributes = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.createModel()).thenThrow(new RuntimeException("GET"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> formProcessor.getInjectedModelAndTagAttributes("Root Tag Name", rootTagAttributes, context));
    verify(context).createModel();
  }

  /**
   * Method under test: {@link FormProcessor#reprocessModel()}
   */
  @Test
  public void testReprocessModel() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new FormProcessor()).reprocessModel());
  }
}
