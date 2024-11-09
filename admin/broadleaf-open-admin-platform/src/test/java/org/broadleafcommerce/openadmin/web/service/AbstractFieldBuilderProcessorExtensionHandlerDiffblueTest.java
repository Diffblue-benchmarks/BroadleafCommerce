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
package org.broadleafcommerce.openadmin.web.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.FieldWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AbstractFieldBuilderProcessorExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractFieldBuilderProcessorExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractFieldBuilderProcessorExtensionHandler abstractFieldBuilderProcessorExtensionHandler;

  /**
   * Test
   * {@link AbstractFieldBuilderProcessorExtensionHandler#modifyRuleBuilderFields(String, String, FieldWrapper)}.
   * <ul>
   *   <li>When {@link FieldWrapper} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractFieldBuilderProcessorExtensionHandler#modifyRuleBuilderFields(String, String, FieldWrapper)}
   */
  @Test
  public void testModifyRuleBuilderFields_whenFieldWrapper() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractFieldBuilderProcessorExtensionHandler
        .modifyRuleBuilderFields("Field Builder", "Ceiling Entity", new FieldWrapper()));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractFieldBuilderProcessorExtensionHandler
        .modifyRuleBuilderFields("Field Builder", "Ceiling Entity", mock(FieldWrapper.class)));
  }

  /**
   * Test new {@link AbstractFieldBuilderProcessorExtensionHandler} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AbstractFieldBuilderProcessorExtensionHandler}
   */
  @Test
  public void testNewAbstractFieldBuilderProcessorExtensionHandler() {
    // Arrange and Act
    AbstractFieldBuilderProcessorExtensionHandler actualAbstractFieldBuilderProcessorExtensionHandler = new AbstractFieldBuilderProcessorExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractFieldBuilderProcessorExtensionHandler.getPriority());
    assertTrue(actualAbstractFieldBuilderProcessorExtensionHandler.isEnabled());
  }
}
