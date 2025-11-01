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
package org.broadleafcommerce.openadmin.web.rulebuilder.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.FieldData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AbstractRuleBuilderFieldServiceExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractRuleBuilderFieldServiceExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractRuleBuilderFieldServiceExtensionHandler abstractRuleBuilderFieldServiceExtensionHandler;

  /**
   * Method under test:
   * {@link AbstractRuleBuilderFieldServiceExtensionHandler#addFields(List, String, String)}
   */
  @Test
  public void testAddFields() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractRuleBuilderFieldServiceExtensionHandler.addFields(new ArrayList<>(), "Name", "Dto Class Name"));
  }

  /**
   * Method under test:
   * {@link AbstractRuleBuilderFieldServiceExtensionHandler#addFields(List, String, String)}
   */
  @Test
  public void testAddFields2() {
    // Arrange
    ArrayList<FieldData> fields = new ArrayList<>();
    fields.add(mock(FieldData.class));

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractRuleBuilderFieldServiceExtensionHandler.addFields(fields, "Name", "Dto Class Name"));
  }

  /**
   * Method under test:
   * {@link AbstractRuleBuilderFieldServiceExtensionHandler#addFields(List, String, String)}
   */
  @Test
  public void testAddFields3() {
    // Arrange
    ArrayList<FieldData> fields = new ArrayList<>();
    fields.add(mock(FieldData.class));
    fields.add(mock(FieldData.class));

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractRuleBuilderFieldServiceExtensionHandler.addFields(fields, "Name", "Dto Class Name"));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link AbstractRuleBuilderFieldServiceExtensionHandler}
   */
  @Test
  public void testNewAbstractRuleBuilderFieldServiceExtensionHandler() {
    // Arrange and Act
    AbstractRuleBuilderFieldServiceExtensionHandler actualAbstractRuleBuilderFieldServiceExtensionHandler = new AbstractRuleBuilderFieldServiceExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractRuleBuilderFieldServiceExtensionHandler.getPriority());
    assertTrue(actualAbstractRuleBuilderFieldServiceExtensionHandler.isEnabled());
  }
}
