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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.openadmin.dto.TabMetadata;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.presentation.model.BroadleafBindStatus;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.validation.BeanPropertyBindingResult;

public class ErrorsProcessorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ErrorsProcessor#getName()}
   *   <li>{@link ErrorsProcessor#getPrefix()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ErrorsProcessor.getName()", "String ErrorsProcessor.getPrefix()"})
  public void testGettersAndSetters() {
    // Arrange
    ErrorsProcessor errorsProcessor = new ErrorsProcessor();

    // Act
    String actualName = errorsProcessor.getName();

    // Assert
    assertEquals("blc_admin", errorsProcessor.getPrefix());
    assertEquals("errors", actualName);
  }

  /**
   * Test {@link ErrorsProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link ErrorsProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ErrorsProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, new ErrorsProcessor().getPrecedence());
  }

  /**
   * Test {@link ErrorsProcessor#populateModelVariables(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor) addTabFromTabMetadata {@link TabMetadata}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ErrorsProcessor#populateModelVariables(String, Map, String,
   * String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map ErrorsProcessor.populateModelVariables(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testPopulateModelVariables_givenEntityFormAddTabFromTabMetadataTabMetadata() {
    // Arrange
    ErrorsProcessor errorsProcessor = new ErrorsProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    BroadleafBindStatus broadleafBindStatus = mock(BroadleafBindStatus.class);
    when(broadleafBindStatus.getErrors())
        .thenReturn(new BeanPropertyBindingResult(entityForm, "Object Name"));
    when(broadleafBindStatus.isError()).thenReturn(true);

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getBindStatus(Mockito.<String>any())).thenReturn(broadleafBindStatus);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult =
        errorsProcessor.populateModelVariables(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(broadleafBindStatus, atLeast(1)).getErrors();
    verify(broadleafBindStatus).isError();
    verify(context).getBindStatus("42");
    assertEquals(1, actualPopulateModelVariablesResult.size());
    Object getResult = actualPopulateModelVariablesResult.get("tabErrors");
    assertTrue(getResult instanceof Map);
    assertTrue(((Map<Object, Object>) getResult).isEmpty());
  }

  /**
   * Test {@link ErrorsProcessor#populateModelVariables(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ErrorsProcessor#populateModelVariables(String, Map, String,
   * String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map ErrorsProcessor.populateModelVariables(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testPopulateModelVariables_thenReturnEmpty() {
    // Arrange
    ErrorsProcessor errorsProcessor = new ErrorsProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    BroadleafBindStatus broadleafBindStatus = mock(BroadleafBindStatus.class);
    when(broadleafBindStatus.isError()).thenReturn(false);

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getBindStatus(Mockito.<String>any())).thenReturn(broadleafBindStatus);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult =
        errorsProcessor.populateModelVariables(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(broadleafBindStatus).isError();
    verify(context).getBindStatus("42");
    assertTrue(actualPopulateModelVariablesResult.isEmpty());
  }

  /**
   * Test {@link ErrorsProcessor#populateModelVariables(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ErrorsProcessor#populateModelVariables(String, Map, String,
   * String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map ErrorsProcessor.populateModelVariables(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testPopulateModelVariables_thenReturnSizeIsOne() {
    // Arrange
    ErrorsProcessor errorsProcessor = new ErrorsProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    BroadleafBindStatus broadleafBindStatus = mock(BroadleafBindStatus.class);
    when(broadleafBindStatus.getErrors())
        .thenReturn(new BeanPropertyBindingResult(new EntityForm(), "Object Name"));
    when(broadleafBindStatus.isError()).thenReturn(true);

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getBindStatus(Mockito.<String>any())).thenReturn(broadleafBindStatus);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult =
        errorsProcessor.populateModelVariables(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(broadleafBindStatus, atLeast(1)).getErrors();
    verify(broadleafBindStatus).isError();
    verify(context).getBindStatus("42");
    assertEquals(1, actualPopulateModelVariablesResult.size());
    Object getResult = actualPopulateModelVariablesResult.get("tabErrors");
    assertTrue(getResult instanceof Map);
    assertTrue(((Map<Object, Object>) getResult).isEmpty());
  }

  /**
   * Test {@link ErrorsProcessor#addFieldError(String, String, Map)}.
   *
   * <p>Method under test: {@link ErrorsProcessor#addFieldError(String, String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ErrorsProcessor.addFieldError(String, String, Map)"})
  public void testAddFieldError() {
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
}
