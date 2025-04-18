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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue;
import org.broadleafcommerce.common.enumeration.service.DataDrivenEnumerationService;
import org.broadleafcommerce.common.web.expression.DataDrivenEnumVariableExpression;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DataDrivenEnumerationProcessorDiffblueTest {
  @Mock
  private DataDrivenEnumVariableExpression dataDrivenEnumVariableExpression;

  @InjectMocks
  private DataDrivenEnumerationProcessor dataDrivenEnumerationProcessor;

  @Mock
  private DataDrivenEnumerationService dataDrivenEnumerationService;

  /**
   * Test {@link DataDrivenEnumerationProcessor#getName()}.
   * <p>
   * Method under test: {@link DataDrivenEnumerationProcessor#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataDrivenEnumerationProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("enumeration", (new DataDrivenEnumerationProcessor()).getName());
  }

  /**
   * Test {@link DataDrivenEnumerationProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link DataDrivenEnumerationProcessor#getPrecedence()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DataDrivenEnumerationProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, dataDrivenEnumerationProcessor.getPrecedence());
  }

  /**
   * Test {@link DataDrivenEnumerationProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link DataDrivenEnumerationProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map DataDrivenEnumerationProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"})
  public void testPopulateModelVariables() {
    // Arrange
    ArrayList<DataDrivenEnumerationValue> dataDrivenEnumerationValueList = new ArrayList<>();
    when(dataDrivenEnumVariableExpression.getEnumValues(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(dataDrivenEnumerationValueList);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult = dataDrivenEnumerationProcessor
        .populateModelVariables("Tag Name", new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(dataDrivenEnumVariableExpression).getEnumValues(isNull(), isNull());
    assertEquals(1, actualPopulateModelVariablesResult.size());
    Object getResult = actualPopulateModelVariablesResult.get("enumValues");
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertSame(dataDrivenEnumerationValueList, getResult);
  }
}
