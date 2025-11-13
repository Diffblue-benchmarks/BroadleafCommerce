package org.broadleafcommerce.common.web.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue;
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
  @Mock private DataDrivenEnumVariableExpression dataDrivenEnumVariableExpression;

  @InjectMocks private DataDrivenEnumerationProcessor dataDrivenEnumerationProcessor;

  /**
   * Test {@link DataDrivenEnumerationProcessor#getName()}.
   *
   * <p>Method under test: {@link DataDrivenEnumerationProcessor#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDrivenEnumerationProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("enumeration", new DataDrivenEnumerationProcessor().getName());
  }

  /**
   * Test {@link DataDrivenEnumerationProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link DataDrivenEnumerationProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataDrivenEnumerationProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, new DataDrivenEnumerationProcessor().getPrecedence());
  }

  /**
   * Test {@link DataDrivenEnumerationProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link DataDrivenEnumerationProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DataDrivenEnumerationProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"
  })
  public void testPopulateModelVariables() {
    // Arrange
    ArrayList<DataDrivenEnumerationValue> dataDrivenEnumerationValueList = new ArrayList<>();
    when(dataDrivenEnumVariableExpression.getEnumValues(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(dataDrivenEnumerationValueList);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult =
        dataDrivenEnumerationProcessor.populateModelVariables(
            "Tag Name", new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(dataDrivenEnumVariableExpression).getEnumValues(null, null);
    assertEquals(1, actualPopulateModelVariablesResult.size());
    Object getResult = actualPopulateModelVariablesResult.get("enumValues");
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertSame(dataDrivenEnumerationValueList, getResult);
  }
}
