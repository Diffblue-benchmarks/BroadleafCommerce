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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.presentation.model.BroadleafBindStatus;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.validation.BindException;

public class ErrorsProcessorDiffblueTest {
  /**
   * Method under test: {@link ErrorsProcessor#getPrecedence()}
   */
  @Test
  public void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10000, (new ErrorsProcessor()).getPrecedence());
  }

  /**
   * Method under test: {@link ErrorsProcessor#getPrecedence()}
   */
  @Test
  public void testGetPrecedence2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, List<String>> tabErrors = new HashMap<>();
    tabErrors.computeIfPresent("foo", mock(BiFunction.class));

    ErrorsProcessor errorsProcessor = new ErrorsProcessor();
    errorsProcessor.addFieldError("Field Name", "Not all who wander are lost", tabErrors);

    // Act and Assert
    assertEquals(10000, errorsProcessor.getPrecedence());
  }

  /**
   * Method under test:
   * {@link ErrorsProcessor#populateModelVariables(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testPopulateModelVariables() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ErrorsProcessor errorsProcessor = new ErrorsProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafBindStatus broadleafBindStatus = mock(BroadleafBindStatus.class);
    when(broadleafBindStatus.getErrors()).thenReturn(new BindException(new EntityForm(), "Object Name"));
    when(broadleafBindStatus.isError()).thenReturn(true);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getBindStatus(Mockito.<String>any())).thenReturn(broadleafBindStatus);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult = errorsProcessor.populateModelVariables("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(broadleafBindStatus, atLeast(1)).getErrors();
    verify(broadleafBindStatus).isError();
    verify(context).getBindStatus(eq("42"));
    assertEquals(1, actualPopulateModelVariablesResult.size());
    Object getResult = actualPopulateModelVariablesResult.get("tabErrors");
    assertTrue(getResult instanceof Map);
    assertTrue(((Map<Object, Object>) getResult).isEmpty());
  }

  /**
   * Method under test: {@link ErrorsProcessor#addFieldError(String, String, Map)}
   */
  @Test
  public void testAddFieldError() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ErrorsProcessor errorsProcessor = new ErrorsProcessor();
    HashMap<String, List<String>> tabErrors = new HashMap<>();

    // Act
    errorsProcessor.addFieldError("Field Name", "Not all who wander are lost", tabErrors);

    // Assert
    assertEquals(1, tabErrors.size());
    List<String> getResult = tabErrors.get("Field Name");
    assertEquals(1, getResult.size());
    assertEquals("Not all who wander are lost", getResult.get(0));
  }

  /**
   * Method under test: {@link ErrorsProcessor#addFieldError(String, String, Map)}
   */
  @Test
  public void testAddFieldError2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ErrorsProcessor errorsProcessor = new ErrorsProcessor();

    HashMap<String, List<String>> tabErrors = new HashMap<>();
    tabErrors.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    errorsProcessor.addFieldError("Field Name", "Not all who wander are lost", tabErrors);

    // Assert
    assertEquals(1, tabErrors.size());
    List<String> getResult = tabErrors.get("Field Name");
    assertEquals(1, getResult.size());
    assertEquals("Not all who wander are lost", getResult.get(0));
  }

  /**
   * Method under test: {@link ErrorsProcessor#addFieldError(String, String, Map)}
   */
  @Test
  public void testAddFieldError3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ErrorsProcessor errorsProcessor = new ErrorsProcessor();

    HashMap<String, List<String>> tabErrors = new HashMap<>();
    ArrayList<String> stringList = new ArrayList<>();
    tabErrors.put("", stringList);

    // Act
    errorsProcessor.addFieldError("", "Not all who wander are lost", tabErrors);

    // Assert
    assertEquals(1, tabErrors.size());
    List<String> getResult = tabErrors.get("");
    assertEquals(1, getResult.size());
    assertEquals("Not all who wander are lost", getResult.get(0));
    assertSame(stringList, getResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorsProcessor#getName()}
   *   <li>{@link ErrorsProcessor#getPrefix()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ErrorsProcessor errorsProcessor = new ErrorsProcessor();

    // Act
    String actualName = errorsProcessor.getName();

    // Assert
    assertEquals("blc_admin", errorsProcessor.getPrefix());
    assertEquals("errors", actualName);
  }
}
