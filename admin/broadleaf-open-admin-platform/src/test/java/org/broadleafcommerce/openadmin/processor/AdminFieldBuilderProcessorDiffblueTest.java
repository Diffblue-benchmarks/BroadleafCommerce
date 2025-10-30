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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.FieldWrapper;
import org.broadleafcommerce.openadmin.web.rulebuilder.service.RuleBuilderFieldService;
import org.broadleafcommerce.openadmin.web.rulebuilder.service.RuleBuilderFieldServiceFactory;
import org.broadleafcommerce.openadmin.web.service.AbstractFieldBuilderProcessorExtensionHandler;
import org.broadleafcommerce.openadmin.web.service.AdminFieldBuilderProcessorExtensionManager;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdminFieldBuilderProcessorDiffblueTest {
  @InjectMocks
  private AdminFieldBuilderProcessor adminFieldBuilderProcessor;

  @Mock
  private AdminFieldBuilderProcessorExtensionManager adminFieldBuilderProcessorExtensionManager;

  @Mock
  private RuleBuilderFieldServiceFactory ruleBuilderFieldServiceFactory;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminFieldBuilderProcessor#getName()}
   *   <li>{@link AdminFieldBuilderProcessor#getPrefix()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminFieldBuilderProcessor.getName()", "String AdminFieldBuilderProcessor.getPrefix()"})
  public void testGettersAndSetters() {
    // Arrange
    AdminFieldBuilderProcessor adminFieldBuilderProcessor = new AdminFieldBuilderProcessor();

    // Act
    String actualName = adminFieldBuilderProcessor.getName();

    // Assert
    assertEquals("admin_field_builder", actualName);
    assertEquals("blc_admin", adminFieldBuilderProcessor.getPrefix());
  }

  /**
   * Test {@link AdminFieldBuilderProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link AdminFieldBuilderProcessor#getPrecedence()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AdminFieldBuilderProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(100, adminFieldBuilderProcessor.getPrecedence());
  }

  /**
   * Test {@link AdminFieldBuilderProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminFieldBuilderProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AdminFieldBuilderProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"})
  public void testPopulateModelVariables_givenNull() {
    // Arrange
    when(adminFieldBuilderProcessorExtensionManager.getProxy())
        .thenReturn(new AbstractFieldBuilderProcessorExtensionHandler());
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(null);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult = adminFieldBuilderProcessor
        .populateModelVariables("Tag Name", tagAttributes, context);

    // Assert
    verify(adminFieldBuilderProcessorExtensionManager).getProxy();
    verify(context, atLeast(1)).parseExpression(isNull());
    assertEquals(1, actualPopulateModelVariablesResult.size());
    Object getResult = actualPopulateModelVariablesResult.get("fieldWrapper");
    assertTrue(getResult instanceof FieldWrapper);
    assertTrue(((FieldWrapper) getResult).getFields().isEmpty());
  }

  /**
   * Test {@link AdminFieldBuilderProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return {@code fieldWrapper} is {@link FieldWrapper} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminFieldBuilderProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AdminFieldBuilderProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"})
  public void testPopulateModelVariables_thenReturnFieldWrapperIsFieldWrapper() {
    // Arrange
    when(adminFieldBuilderProcessorExtensionManager.getProxy())
        .thenReturn(new AbstractFieldBuilderProcessorExtensionHandler());
    RuleBuilderFieldService ruleBuilderFieldService = mock(RuleBuilderFieldService.class);
    FieldWrapper fieldWrapper = new FieldWrapper();
    when(ruleBuilderFieldService.buildFields()).thenReturn(fieldWrapper);
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any())).thenReturn(ruleBuilderFieldService);
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    Map<String, Object> actualPopulateModelVariablesResult = adminFieldBuilderProcessor
        .populateModelVariables("Tag Name", tagAttributes, context);

    // Assert
    verify(adminFieldBuilderProcessorExtensionManager).getProxy();
    verify(ruleBuilderFieldService).buildFields();
    verify(ruleBuilderFieldServiceFactory).createInstance(eq("Parse Expression"));
    verify(context, atLeast(1)).parseExpression(isNull());
    assertEquals(1, actualPopulateModelVariablesResult.size());
    Object getResult = actualPopulateModelVariablesResult.get("fieldWrapper");
    assertTrue(getResult instanceof FieldWrapper);
    assertTrue(((FieldWrapper) getResult).getFields().isEmpty());
    assertSame(fieldWrapper, getResult);
  }

  /**
   * Test {@link AdminFieldBuilderProcessor#useGlobalScope()}.
   * <p>
   * Method under test: {@link AdminFieldBuilderProcessor#useGlobalScope()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminFieldBuilderProcessor.useGlobalScope()"})
  public void testUseGlobalScope() {
    // Arrange, Act and Assert
    assertFalse(adminFieldBuilderProcessor.useGlobalScope());
  }
}
