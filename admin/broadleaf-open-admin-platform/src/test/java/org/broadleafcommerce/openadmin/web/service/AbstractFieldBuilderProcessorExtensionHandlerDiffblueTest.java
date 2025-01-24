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
