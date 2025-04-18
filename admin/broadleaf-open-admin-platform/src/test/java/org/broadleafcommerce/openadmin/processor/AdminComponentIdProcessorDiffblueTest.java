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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.broadleafcommerce.openadmin.web.form.entity.CodeField;
import org.broadleafcommerce.presentation.model.BroadleafAttributeModifier;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class AdminComponentIdProcessorDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminComponentIdProcessor#getName()}
   *   <li>{@link AdminComponentIdProcessor#getPrefix()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.getName()", "String AdminComponentIdProcessor.getPrefix()"})
  public void testGettersAndSetters() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();

    // Act
    String actualName = adminComponentIdProcessor.getName();

    // Assert
    assertEquals("blc_admin", adminComponentIdProcessor.getPrefix());
    assertEquals("component_id", actualName);
  }

  /**
   * Test {@link AdminComponentIdProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getPrecedence()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AdminComponentIdProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10002, (new AdminComponentIdProcessor()).getPrecedence());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("List Grid Type");
    when(listGrid.getSubCollectionFieldName()).thenReturn("Sub Collection Field Name");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-List-Grid-Type-Sub-Collection-Field-Name", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes2() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("listGrid-");
    when(listGrid.getSubCollectionFieldName()).thenReturn("Sub Collection Field Name");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-listGrid--Sub-Collection-Field-Name", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes3() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("[^a-zA-Z0-9-]");
    when(listGrid.getSubCollectionFieldName()).thenReturn("Sub Collection Field Name");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---a-zA-Z0-9---Sub-Collection-Field-Name", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes4() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("org.broadleafcommerce.openadmin.web.form.component.ListGridAction");
    when(listGrid.getSubCollectionFieldName()).thenReturn("Sub Collection Field Name");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-org-broadleafcommerce-openadmin-web-form-component-ListGridAction-Sub-Collection-Field-Name",
        added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes5() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("List Grid Type");
    when(listGrid.getSubCollectionFieldName())
        .thenReturn("org.broadleafcommerce.openadmin.web.form.component.ListGridAction");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-List-Grid-Type-org-broadleafcommerce-openadmin-web-form-component-ListGridAction",
        added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes6() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("org.broadleafcommerce.openadmin.web.form.entity.Field");
    when(listGrid.getSubCollectionFieldName()).thenReturn("Sub Collection Field Name");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-org-broadleafcommerce-openadmin-web-form-entity-Field-Sub-Collection-Field-Name",
        added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes7() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("List Grid Type");
    when(listGrid.getSubCollectionFieldName()).thenReturn("org.broadleafcommerce.openadmin.web.form.entity.Field");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-List-Grid-Type-org-broadleafcommerce-openadmin-web-form-entity-Field", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link CodeField} (default constructor).</li>
   *   <li>Then return Added {@code id} is {@code field-null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_givenCodeField_thenReturnAddedIdIsFieldNull() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(new CodeField());

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("field-null", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link ListGrid} {@link ListGrid#getListGridType()} return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_givenListGridGetListGridTypeReturnSlash() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("/");
    when(listGrid.getSubCollectionFieldName()).thenReturn("Sub Collection Field Name");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---Sub-Collection-Field-Name", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor).</li>
   *   <li>Then return Added {@code id} is {@code listGrid-null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_givenListGrid_thenReturnAddedIdIsListGridNull() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(new ListGrid());

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-null", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code Parse Expression}.</li>
   *   <li>Then return Added {@code id} is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_givenParseExpression_thenReturnAddedIdIsEmptyString() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGrid() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn(" ");
    when(listGrid.getSubCollectionFieldName()).thenReturn(" ");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGrid2() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn(" ");
    when(listGrid.getSubCollectionFieldName()).thenReturn("-");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid----", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGrid3() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn(" ");
    when(listGrid.getSubCollectionFieldName()).thenReturn("/");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid----", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGrid4() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("-");
    when(listGrid.getSubCollectionFieldName()).thenReturn("/");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid----", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGrid42() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn(" ");
    when(listGrid.getSubCollectionFieldName()).thenReturn("42");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---42", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-42-Sub-Collection-Field-Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGrid42SubCollectionFieldName() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("42");
    when(listGrid.getSubCollectionFieldName()).thenReturn("Sub Collection Field Name");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-42-Sub-Collection-Field-Name", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-----a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ09() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn(" ");
    when(listGrid.getSubCollectionFieldName()).thenReturn("[^a-zA-Z0-9-]");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-----a-zA-Z0-9--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---a-zA-Z0-9-----a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ09AZAZ09() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("[^a-zA-Z0-9-]");
    when(listGrid.getSubCollectionFieldName()).thenReturn("[^a-zA-Z0-9-]");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---a-zA-Z0-9-----a-zA-Z0-9--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---a-zA-Z0-9---foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ09Foo() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("[^a-zA-Z0-9-]");
    when(listGrid.getSubCollectionFieldName()).thenReturn("foo");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---a-zA-Z0-9---foo", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---a-zA-Z0-9---id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ09Id() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("[^a-zA-Z0-9-]");
    when(listGrid.getSubCollectionFieldName()).thenReturn("id");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---a-zA-Z0-9---id", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---a-zA-Z0-9---listGrid-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ09ListGrid() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("[^a-zA-Z0-9-]");
    when(listGrid.getSubCollectionFieldName()).thenReturn("listGrid-");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---a-zA-Z0-9---listGrid-", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---a-zA-Z0-9---none}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ09None() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("[^a-zA-Z0-9-]");
    when(listGrid.getSubCollectionFieldName()).thenReturn("none");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---a-zA-Z0-9---none", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-----a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ092() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("-");
    when(listGrid.getSubCollectionFieldName()).thenReturn("[^a-zA-Z0-9-]");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-----a-zA-Z0-9--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ093() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("[^a-zA-Z0-9-]");
    when(listGrid.getSubCollectionFieldName()).thenReturn(" ");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---a-zA-Z0-9--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---a-zA-Z0-9----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ094() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("[^a-zA-Z0-9-]");
    when(listGrid.getSubCollectionFieldName()).thenReturn("-");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---a-zA-Z0-9----", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---a-zA-Z0-9----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ095() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("[^a-zA-Z0-9-]");
    when(listGrid.getSubCollectionFieldName()).thenReturn("/");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---a-zA-Z0-9----", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---a-zA-Z0-9---42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ0942() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("[^a-zA-Z0-9-]");
    when(listGrid.getSubCollectionFieldName()).thenReturn("42");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---a-zA-Z0-9---42", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridFoo() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn(" ");
    when(listGrid.getSubCollectionFieldName()).thenReturn("foo");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---foo", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-foo-Sub-Collection-Field-Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridFooSubCollectionFieldName() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("foo");
    when(listGrid.getSubCollectionFieldName()).thenReturn("Sub Collection Field Name");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-foo-Sub-Collection-Field-Name", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridId() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn(" ");
    when(listGrid.getSubCollectionFieldName()).thenReturn("id");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---id", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-id-Sub-Collection-Field-Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridIdSubCollectionFieldName() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("id");
    when(listGrid.getSubCollectionFieldName()).thenReturn("Sub Collection Field Name");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-id-Sub-Collection-Field-Name", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---listGrid-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGrid() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn(" ");
    when(listGrid.getSubCollectionFieldName()).thenReturn("listGrid-");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---listGrid-", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-listGrid---}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGrid2() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("listGrid-");
    when(listGrid.getSubCollectionFieldName()).thenReturn("/");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-listGrid---", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-listGrid----a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridAZAZ09() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("listGrid-");
    when(listGrid.getSubCollectionFieldName()).thenReturn("[^a-zA-Z0-9-]");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-listGrid----a-zA-Z0-9--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-List-Grid-Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridType() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("List Grid Type");
    when(listGrid.getSubCollectionFieldName()).thenReturn(" ");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-List-Grid-Type", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-List-Grid-Type--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridType2() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("List Grid Type");
    when(listGrid.getSubCollectionFieldName()).thenReturn("-");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-List-Grid-Type--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-List-Grid-Type--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridType3() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("List Grid Type");
    when(listGrid.getSubCollectionFieldName()).thenReturn("/");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-List-Grid-Type--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-List-Grid-Type-42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridType42() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("List Grid Type");
    when(listGrid.getSubCollectionFieldName()).thenReturn("42");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-List-Grid-Type-42", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-List-Grid-Type---a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridTypeAZAZ09() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("List Grid Type");
    when(listGrid.getSubCollectionFieldName()).thenReturn("[^a-zA-Z0-9-]");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-List-Grid-Type---a-zA-Z0-9--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-List-Grid-Type-foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridTypeFoo() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("List Grid Type");
    when(listGrid.getSubCollectionFieldName()).thenReturn("foo");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-List-Grid-Type-foo", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-List-Grid-Type-id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridTypeId() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("List Grid Type");
    when(listGrid.getSubCollectionFieldName()).thenReturn("id");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-List-Grid-Type-id", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-List-Grid-Type-listGrid-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridTypeListGrid() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("List Grid Type");
    when(listGrid.getSubCollectionFieldName()).thenReturn("listGrid-");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-List-Grid-Type-listGrid-", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-List-Grid-Type-none}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridTypeNone() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("List Grid Type");
    when(listGrid.getSubCollectionFieldName()).thenReturn("none");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-List-Grid-Type-none", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---none}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridNone() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn(" ");
    when(listGrid.getSubCollectionFieldName()).thenReturn("none");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---none", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-none-Sub-Collection-Field-Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridNoneSubCollectionFieldName() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("none");
    when(listGrid.getSubCollectionFieldName()).thenReturn("Sub Collection Field Name");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-none-Sub-Collection-Field-Name", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---Sub-Collection-Field-Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridSubCollectionFieldName() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn(" ");
    when(listGrid.getSubCollectionFieldName()).thenReturn("Sub Collection Field Name");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---Sub-Collection-Field-Name", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---Sub-Collection-Field-Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridSubCollectionFieldName2() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("-");
    when(listGrid.getSubCollectionFieldName()).thenReturn("Sub Collection Field Name");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---Sub-Collection-Field-Name", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid--Sub-Collection-Field-Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"})
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridSubCollectionFieldName3() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("");
    when(listGrid.getSubCollectionFieldName()).thenReturn("Sub Collection Field Name");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = adminComponentIdProcessor.getModifiedAttributes("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression(eq("42"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid--Sub-Collection-Field-Name", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString() {
    // Arrange, Act and Assert
    assertEquals("org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString2() {
    // Arrange, Act and Assert
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString3() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString4() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field", (new AdminComponentIdProcessor())
        .cleanCssIdString("[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString5() {
    // Arrange, Act and Assert
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString6() {
    // Arrange, Act and Assert
    assertEquals("Inorg-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("Inorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString7() {
    // Arrange, Act and Assert
    assertEquals("42org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("42org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString8() {
    // Arrange, Act and Assert
    assertEquals("idorg-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("idorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString9() {
    // Arrange, Act and Assert
    assertEquals("org-broadleafcommerce-openadmin-web-form-component-ListGrid-", (new AdminComponentIdProcessor())
        .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.component.ListGrid "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString10() {
    // Arrange, Act and Assert
    assertEquals("org-broadleafcommerce-openadmin-web-form-component-ListGrid--a-zA-Z0-9--",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.component.ListGrid[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString11() {
    // Arrange, Act and Assert
    assertEquals("org-broadleafcommerce-openadmin-web-form-component-ListGrid-", (new AdminComponentIdProcessor())
        .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.component.ListGrid-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString12() {
    // Arrange, Act and Assert
    assertEquals("org-broadleafcommerce-openadmin-web-form-component-ListGridIn", (new AdminComponentIdProcessor())
        .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.component.ListGridIn"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString13() {
    // Arrange, Act and Assert
    assertEquals("org-broadleafcommerce-openadmin-web-form-component-ListGrid42", (new AdminComponentIdProcessor())
        .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.component.ListGrid42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString14() {
    // Arrange, Act and Assert
    assertEquals("org-broadleafcommerce-openadmin-web-form-component-ListGridid", (new AdminComponentIdProcessor())
        .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.component.ListGridid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString15() {
    // Arrange, Act and Assert
    assertEquals("org-broadleafcommerce-openadmin-web-form-entity-Field--a-zA-Z0-9--", (new AdminComponentIdProcessor())
        .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.entity.Field[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString16() {
    // Arrange, Act and Assert
    assertEquals("--org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("  org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString17() {
    // Arrange, Act and Assert
    assertEquals("---a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        (new AdminComponentIdProcessor())
            .cleanCssIdString(" [^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString18() {
    // Arrange, Act and Assert
    assertEquals("---a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor())
            .cleanCssIdString(" [^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString19() {
    // Arrange, Act and Assert
    assertEquals("--org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString(" -org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString20() {
    // Arrange, Act and Assert
    assertEquals("-Inorg-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString(" Inorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString21() {
    // Arrange, Act and Assert
    assertEquals("-42org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString(" 42org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString22() {
    // Arrange, Act and Assert
    assertEquals("-idorg-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString(" idorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString23() {
    // Arrange, Act and Assert
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGrid-", (new AdminComponentIdProcessor())
        .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.component.ListGrid "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString24() {
    // Arrange, Act and Assert
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGrid--a-zA-Z0-9--",
        (new AdminComponentIdProcessor())
            .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.component.ListGrid[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString25() {
    // Arrange, Act and Assert
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGrid-", (new AdminComponentIdProcessor())
        .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.component.ListGrid-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString26() {
    // Arrange, Act and Assert
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGridIn", (new AdminComponentIdProcessor())
        .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.component.ListGridIn"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString27() {
    // Arrange, Act and Assert
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGrid42", (new AdminComponentIdProcessor())
        .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.component.ListGrid42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString28() {
    // Arrange, Act and Assert
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGridid", (new AdminComponentIdProcessor())
        .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.component.ListGridid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString29() {
    // Arrange, Act and Assert
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Field--a-zA-Z0-9--",
        (new AdminComponentIdProcessor())
            .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.entity.Field[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString30() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9---org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-] org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString31() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9----a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString32() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9----a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString33() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9---org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]-org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return {@code 42org-broadleafcommerce-openadmin-web-form-entity-Field}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturn42orgBroadleafcommerceOpenadminWebFormEntityField() {
    // Arrange, Act and Assert
    assertEquals("42org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("42org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return {@code -42org-broadleafcommerce-openadmin-web-form-entity-Field}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturn42orgBroadleafcommerceOpenadminWebFormEntityField2() {
    // Arrange, Act and Assert
    assertEquals("-42org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString(" 42org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return {@code idorg-broadleafcommerce-openadmin-web-form-entity-Field}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnIdorgBroadleafcommerceOpenadminWebFormEntityField() {
    // Arrange, Act and Assert
    assertEquals("idorg-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("idorg.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return {@code -idorg-broadleafcommerce-openadmin-web-form-entity-Field}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnIdorgBroadleafcommerceOpenadminWebFormEntityField2() {
    // Arrange, Act and Assert
    assertEquals("-idorg-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString(" idorg.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return {@code Inorg-broadleafcommerce-openadmin-web-form-entity-Field}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnInorgBroadleafcommerceOpenadminWebFormEntityField() {
    // Arrange, Act and Assert
    assertEquals("Inorg-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("Inorg.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return {@code -Inorg-broadleafcommerce-openadmin-web-form-entity-Field}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnInorgBroadleafcommerceOpenadminWebFormEntityField2() {
    // Arrange, Act and Assert
    assertEquals("-Inorg-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString(" Inorg.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return {@code org-broadleafcommerce-openadmin-web-form-entity-Field}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityField() {
    // Arrange, Act and Assert
    assertEquals("org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return {@code -org-broadleafcommerce-openadmin-web-form-entity-Field}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityField2() {
    // Arrange, Act and Assert
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return {@code -org-broadleafcommerce-openadmin-web-form-entity-Field}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityField3() {
    // Arrange, Act and Assert
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return {@code org-broadleafcommerce-openadmin-web-form-entity-Field-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityField4() {
    // Arrange, Act and Assert
    assertEquals("org-broadleafcommerce-openadmin-web-form-entity-Field-",
        (new AdminComponentIdProcessor()).cleanCssIdString("org.broadleafcommerce.openadmin.web.form.entity.Field "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return {@code org-broadleafcommerce-openadmin-web-form-entity-Field-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityField5() {
    // Arrange, Act and Assert
    assertEquals("org-broadleafcommerce-openadmin-web-form-entity-Field-",
        (new AdminComponentIdProcessor()).cleanCssIdString("org.broadleafcommerce.openadmin.web.form.entity.Field-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return {@code --org-broadleafcommerce-openadmin-web-form-entity-Field}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityField6() {
    // Arrange, Act and Assert
    assertEquals("--org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("  org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return {@code --org-broadleafcommerce-openadmin-web-form-entity-Field}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityField7() {
    // Arrange, Act and Assert
    assertEquals("--org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString(" -org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return {@code -org-broadleafcommerce-openadmin-web-form-entity-Field-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityField8() {
    // Arrange, Act and Assert
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Field-",
        (new AdminComponentIdProcessor()).cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.entity.Field "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return {@code -org-broadleafcommerce-openadmin-web-form-entity-Field-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityField9() {
    // Arrange, Act and Assert
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Field-",
        (new AdminComponentIdProcessor()).cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.entity.Field-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return {@code org-broadleafcommerce-openadmin-web-form-entity-Field42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityField42() {
    // Arrange, Act and Assert
    assertEquals("org-broadleafcommerce-openadmin-web-form-entity-Field42",
        (new AdminComponentIdProcessor()).cleanCssIdString("org.broadleafcommerce.openadmin.web.form.entity.Field42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return {@code -org-broadleafcommerce-openadmin-web-form-entity-Field42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityField422() {
    // Arrange, Act and Assert
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Field42",
        (new AdminComponentIdProcessor()).cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.entity.Field42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return {@code org-broadleafcommerce-openadmin-web-form-entity-FieldIn}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityFieldIn() {
    // Arrange, Act and Assert
    assertEquals("org-broadleafcommerce-openadmin-web-form-entity-FieldIn",
        (new AdminComponentIdProcessor()).cleanCssIdString("org.broadleafcommerce.openadmin.web.form.entity.FieldIn"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return {@code -org-broadleafcommerce-openadmin-web-form-entity-FieldIn}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityFieldIn2() {
    // Arrange, Act and Assert
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-FieldIn",
        (new AdminComponentIdProcessor()).cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.entity.FieldIn"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return {@code org-broadleafcommerce-openadmin-web-form-entity-Fieldid}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityFieldid() {
    // Arrange, Act and Assert
    assertEquals("org-broadleafcommerce-openadmin-web-form-entity-Fieldid",
        (new AdminComponentIdProcessor()).cleanCssIdString("org.broadleafcommerce.openadmin.web.form.entity.Fieldid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return {@code -org-broadleafcommerce-openadmin-web-form-entity-Fieldid}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityFieldid2() {
    // Arrange, Act and Assert
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Fieldid",
        (new AdminComponentIdProcessor()).cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.entity.Fieldid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code 42[^a-zA-Z0-9-]}.</li>
   *   <li>Then return {@code 42--a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_when42AZAZ09_thenReturn42AZAZ09() {
    // Arrange, Act and Assert
    assertEquals("42--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("42[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code 42[^a-zA-Z0-9-]}.</li>
   *   <li>Then return {@code -42--a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_when42AZAZ09_thenReturn42AZAZ092() {
    // Arrange, Act and Assert
    assertEquals("-42--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString(" 42[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code 42In}.</li>
   *   <li>Then return {@code -42In}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_when42In_thenReturn42In() {
    // Arrange, Act and Assert
    assertEquals("-42In", (new AdminComponentIdProcessor()).cleanCssIdString(" 42In"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code -42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("-42", (new AdminComponentIdProcessor()).cleanCssIdString(" 42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_when42_thenReturn422() {
    // Arrange, Act and Assert
    assertEquals("42-", (new AdminComponentIdProcessor()).cleanCssIdString("42 "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code --42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_when42_thenReturn423() {
    // Arrange, Act and Assert
    assertEquals("--42", (new AdminComponentIdProcessor()).cleanCssIdString("  42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code -42}.</li>
   *   <li>Then return {@code --42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_when42_thenReturn424() {
    // Arrange, Act and Assert
    assertEquals("--42", (new AdminComponentIdProcessor()).cleanCssIdString(" -42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code -42-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_when42_thenReturn425() {
    // Arrange, Act and Assert
    assertEquals("-42-", (new AdminComponentIdProcessor()).cleanCssIdString(" 42 "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code 42-}.</li>
   *   <li>Then return {@code -42-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_when42_thenReturn426() {
    // Arrange, Act and Assert
    assertEquals("-42-", (new AdminComponentIdProcessor()).cleanCssIdString(" 42-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code 42id}.</li>
   *   <li>Then return {@code -42id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_when42id_thenReturn42id() {
    // Arrange, Act and Assert
    assertEquals("-42id", (new AdminComponentIdProcessor()).cleanCssIdString(" 42id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code 4242}.</li>
   *   <li>Then return {@code -4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_when4242_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("-4242", (new AdminComponentIdProcessor()).cleanCssIdString(" 4242"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When a string.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAString_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "org-broadleafcommerce-openadmin-web-form-component-ListGridorg-broadleafcommerce-openadmin-web-form"
            + "-component-ListGrid",
        (new AdminComponentIdProcessor()).cleanCssIdString(
            "org.broadleafcommerce.openadmin.web.form.component.ListGridorg.broadleafcommerce.openadmin.web.form"
                + ".component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When a string.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAString_thenReturnAString2() {
    // Arrange, Act and Assert
    assertEquals(
        "org-broadleafcommerce-openadmin-web-form-component-ListGridorg-broadleafcommerce-openadmin-web-form"
            + "-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString(
            "org.broadleafcommerce.openadmin.web.form.component.ListGridorg.broadleafcommerce.openadmin.web.form"
                + ".entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When a string.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAString_thenReturnAString3() {
    // Arrange, Act and Assert
    assertEquals(
        "org-broadleafcommerce-openadmin-web-form-entity-Fieldorg-broadleafcommerce-openadmin-web-form-component"
            + "-ListGrid",
        (new AdminComponentIdProcessor()).cleanCssIdString(
            "org.broadleafcommerce.openadmin.web.form.entity.Fieldorg.broadleafcommerce.openadmin.web.form.component"
                + ".ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When a string.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAString_thenReturnAString4() {
    // Arrange, Act and Assert
    assertEquals(
        "org-broadleafcommerce-openadmin-web-form-entity-Fieldorg-broadleafcommerce-openadmin-web-form"
            + "-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString(
            "org.broadleafcommerce.openadmin.web.form.entity.Fieldorg.broadleafcommerce.openadmin.web.form"
                + ".entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When a string.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAString_thenReturnAString5() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-component-ListGridorg-broadleafcommerce-openadmin-web-form"
            + "-component-ListGrid",
        (new AdminComponentIdProcessor()).cleanCssIdString(
            " org.broadleafcommerce.openadmin.web.form.component.ListGridorg.broadleafcommerce.openadmin.web.form"
                + ".component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When a string.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAString_thenReturnAString6() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-component-ListGridorg-broadleafcommerce-openadmin-web-form"
            + "-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString(
            " org.broadleafcommerce.openadmin.web.form.component.ListGridorg.broadleafcommerce.openadmin.web.form"
                + ".entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When a string.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAString_thenReturnAString7() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-entity-Fieldorg-broadleafcommerce-openadmin-web-form-component"
            + "-ListGrid",
        (new AdminComponentIdProcessor()).cleanCssIdString(
            " org.broadleafcommerce.openadmin.web.form.entity.Fieldorg.broadleafcommerce.openadmin.web.form.component"
                + ".ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When a string.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAString_thenReturnAString8() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-entity-Fieldorg-broadleafcommerce-openadmin-web-form"
            + "-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString(
            " org.broadleafcommerce.openadmin.web.form.entity.Fieldorg.broadleafcommerce.openadmin.web.form"
                + ".entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-][^a-zA-Z0-9-][^a-zA-Z0-9-]}.</li>
   *   <li>Then return {@code --a-zA-Z0-9----a-zA-Z0-9----a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09AZAZ09AZAZ09_thenReturnAZAZ09AZAZ09AZAZ09() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9----a-zA-Z0-9----a-zA-Z0-9--",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-][^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-][^a-zA-Z0-9-]id}.</li>
   *   <li>Then return {@code --a-zA-Z0-9----a-zA-Z0-9--id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09AZAZ09Id_thenReturnAZAZ09AZAZ09Id() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9----a-zA-Z0-9--id",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-]id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-][^a-zA-Z0-9-]In}.</li>
   *   <li>Then return {@code --a-zA-Z0-9----a-zA-Z0-9--In}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09AZAZ09In_thenReturnAZAZ09AZAZ09In() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9----a-zA-Z0-9--In",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-]In"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-][^a-zA-Z0-9-]}.</li>
   *   <li>Then return {@code --a-zA-Z0-9----a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09AZAZ09_thenReturnAZAZ09AZAZ09() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9----a-zA-Z0-9--",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-][^a-zA-Z0-9-]}.</li>
   *   <li>Then return {@code ---a-zA-Z0-9----a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09AZAZ09_thenReturnAZAZ09AZAZ092() {
    // Arrange, Act and Assert
    assertEquals("---a-zA-Z0-9----a-zA-Z0-9--",
        (new AdminComponentIdProcessor()).cleanCssIdString(" [^a-zA-Z0-9-][^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-] [^a-zA-Z0-9-]}.</li>
   *   <li>Then return {@code --a-zA-Z0-9-----a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09AZAZ09_thenReturnAZAZ09AZAZ093() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9-----a-zA-Z0-9--",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-] [^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-][^a-zA-Z0-9-]}.</li>
   *   <li>Then return {@code --a-zA-Z0-9----a-zA-Z0-9---}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09AZAZ09_thenReturnAZAZ09AZAZ094() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9----a-zA-Z0-9---",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-] "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-][^a-zA-Z0-9-]-}.</li>
   *   <li>Then return {@code --a-zA-Z0-9----a-zA-Z0-9---}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09AZAZ09_thenReturnAZAZ09AZAZ095() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9----a-zA-Z0-9---",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-]-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]-[^a-zA-Z0-9-]}.</li>
   *   <li>Then return {@code --a-zA-Z0-9-----a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09AZAZ09_thenReturnAZAZ09AZAZ096() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9-----a-zA-Z0-9--",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]-[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-][^a-zA-Z0-9-]42}.</li>
   *   <li>Then return {@code --a-zA-Z0-9----a-zA-Z0-9--42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09AZAZ0942_thenReturnAZAZ09AZAZ0942() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9----a-zA-Z0-9--42",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-]42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]id}.</li>
   *   <li>Then return {@code --a-zA-Z0-9--id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09Id_thenReturnAZAZ09Id() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9--id", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]id}.</li>
   *   <li>Then return {@code ---a-zA-Z0-9--id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09Id_thenReturnAZAZ09Id2() {
    // Arrange, Act and Assert
    assertEquals("---a-zA-Z0-9--id", (new AdminComponentIdProcessor()).cleanCssIdString(" [^a-zA-Z0-9-]id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-] id}.</li>
   *   <li>Then return {@code --a-zA-Z0-9---id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09Id_thenReturnAZAZ09Id3() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9---id", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-] id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]-id}.</li>
   *   <li>Then return {@code --a-zA-Z0-9---id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09Id_thenReturnAZAZ09Id4() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9---id", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]-id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]In42}.</li>
   *   <li>Then return {@code --a-zA-Z0-9--In42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09In42_thenReturnAZAZ09In42() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9--In42", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]In42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]In[^a-zA-Z0-9-]}.</li>
   *   <li>Then return {@code --a-zA-Z0-9--In--a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09InAZAZ09_thenReturnAZAZ09InAZAZ09() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9--In--a-zA-Z0-9--",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]In[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]InIn}.</li>
   *   <li>Then return {@code --a-zA-Z0-9--InIn}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09InIn_thenReturnAZAZ09InIn() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9--InIn", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]InIn"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]In}.</li>
   *   <li>Then return {@code --a-zA-Z0-9--In}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09In_thenReturnAZAZ09In() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9--In", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]In"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]In}.</li>
   *   <li>Then return {@code ---a-zA-Z0-9--In}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09In_thenReturnAZAZ09In2() {
    // Arrange, Act and Assert
    assertEquals("---a-zA-Z0-9--In", (new AdminComponentIdProcessor()).cleanCssIdString(" [^a-zA-Z0-9-]In"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-] In}.</li>
   *   <li>Then return {@code --a-zA-Z0-9---In}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09In_thenReturnAZAZ09In3() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9---In", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-] In"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]-In}.</li>
   *   <li>Then return {@code --a-zA-Z0-9---In}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09In_thenReturnAZAZ09In4() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9---In", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]-In"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]In}.</li>
   *   <li>Then return {@code --a-zA-Z0-9--In-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09In_thenReturnAZAZ09In5() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9--In-", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]In "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]In-}.</li>
   *   <li>Then return {@code --a-zA-Z0-9--In-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09In_thenReturnAZAZ09In6() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9--In-", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]In-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-] org.broadleafcommerce.openadmin.web.form.entity.Field}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09OrgBroadleafcommerceOpenadminWebFormEntityField() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9---org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-] org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]-org.broadleafcommerce.openadmin.web.form.entity.Field}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09OrgBroadleafcommerceOpenadminWebFormEntityField2() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9---org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]-org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]}.</li>
   *   <li>Then return {@code --a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ09() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]}.</li>
   *   <li>Then return {@code ---a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ092() {
    // Arrange, Act and Assert
    assertEquals("---a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString(" [^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]}.</li>
   *   <li>Then return {@code --a-zA-Z0-9---}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ093() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9---", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-] "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]-}.</li>
   *   <li>Then return {@code --a-zA-Z0-9---}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ094() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9---", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code -[^a-zA-Z0-9-]}.</li>
   *   <li>Then return {@code ---a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ095() {
    // Arrange, Act and Assert
    assertEquals("---a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("-[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]}.</li>
   *   <li>Then return {@code ----a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ096() {
    // Arrange, Act and Assert
    assertEquals("----a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("  [^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]}.</li>
   *   <li>Then return {@code ---a-zA-Z0-9---}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ097() {
    // Arrange, Act and Assert
    assertEquals("---a-zA-Z0-9---", (new AdminComponentIdProcessor()).cleanCssIdString(" [^a-zA-Z0-9-] "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]-}.</li>
   *   <li>Then return {@code ---a-zA-Z0-9---}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ098() {
    // Arrange, Act and Assert
    assertEquals("---a-zA-Z0-9---", (new AdminComponentIdProcessor()).cleanCssIdString(" [^a-zA-Z0-9-]-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code -[^a-zA-Z0-9-]}.</li>
   *   <li>Then return {@code ----a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ099() {
    // Arrange, Act and Assert
    assertEquals("----a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString(" -[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]}.</li>
   *   <li>Then return {@code --a-zA-Z0-9----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ0910() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9----", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]  "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-] -}.</li>
   *   <li>Then return {@code --a-zA-Z0-9----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ0911() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9----", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-] -"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]-}.</li>
   *   <li>Then return {@code --a-zA-Z0-9----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ0912() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9----", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]- "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]--}.</li>
   *   <li>Then return {@code --a-zA-Z0-9----}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ0913() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9----", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]--"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]42}.</li>
   *   <li>Then return {@code --a-zA-Z0-9--42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ0942_thenReturnAZAZ0942() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9--42", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]42}.</li>
   *   <li>Then return {@code ---a-zA-Z0-9--42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ0942_thenReturnAZAZ09422() {
    // Arrange, Act and Assert
    assertEquals("---a-zA-Z0-9--42", (new AdminComponentIdProcessor()).cleanCssIdString(" [^a-zA-Z0-9-]42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-] 42}.</li>
   *   <li>Then return {@code --a-zA-Z0-9---42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ0942_thenReturnAZAZ09423() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9---42", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-] 42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]-42}.</li>
   *   <li>Then return {@code --a-zA-Z0-9---42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ0942_thenReturnAZAZ09424() {
    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9---42", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]-42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code --}.</li>
   *   <li>Then return {@code ---}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenDashDash_thenReturnDashDashDash() {
    // Arrange, Act and Assert
    assertEquals("---", (new AdminComponentIdProcessor()).cleanCssIdString(" --"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code -}.</li>
   *   <li>Then return {@code --}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenDash_thenReturnDashDash() {
    // Arrange, Act and Assert
    assertEquals("--", (new AdminComponentIdProcessor()).cleanCssIdString(" -"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code -}.</li>
   *   <li>Then return {@code --}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenDash_thenReturnDashDash2() {
    // Arrange, Act and Assert
    assertEquals("--", (new AdminComponentIdProcessor()).cleanCssIdString("- "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code -}.</li>
   *   <li>Then return {@code ---}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenDash_thenReturnDashDashDash() {
    // Arrange, Act and Assert
    assertEquals("---", (new AdminComponentIdProcessor()).cleanCssIdString("  -"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code -}.</li>
   *   <li>Then return {@code ---}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenDash_thenReturnDashDashDash2() {
    // Arrange, Act and Assert
    assertEquals("---", (new AdminComponentIdProcessor()).cleanCssIdString(" - "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code id42}.</li>
   *   <li>Then return {@code -id42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenId42_thenReturnId42() {
    // Arrange, Act and Assert
    assertEquals("-id42", (new AdminComponentIdProcessor()).cleanCssIdString(" id42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code id[^a-zA-Z0-9-]}.</li>
   *   <li>Then return {@code id--a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIdAZAZ09_thenReturnIdAZAZ09() {
    // Arrange, Act and Assert
    assertEquals("id--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("id[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code id[^a-zA-Z0-9-]}.</li>
   *   <li>Then return {@code -id--a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIdAZAZ09_thenReturnIdAZAZ092() {
    // Arrange, Act and Assert
    assertEquals("-id--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString(" id[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code idIn}.</li>
   *   <li>Then return {@code -idIn}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIdIn_thenReturnIdIn() {
    // Arrange, Act and Assert
    assertEquals("-idIn", (new AdminComponentIdProcessor()).cleanCssIdString(" idIn"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code id}.</li>
   *   <li>Then return {@code -id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenId_thenReturnId() {
    // Arrange, Act and Assert
    assertEquals("-id", (new AdminComponentIdProcessor()).cleanCssIdString(" id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code id}.</li>
   *   <li>Then return {@code id-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenId_thenReturnId2() {
    // Arrange, Act and Assert
    assertEquals("id-", (new AdminComponentIdProcessor()).cleanCssIdString("id "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code id}.</li>
   *   <li>Then return {@code --id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenId_thenReturnId3() {
    // Arrange, Act and Assert
    assertEquals("--id", (new AdminComponentIdProcessor()).cleanCssIdString("  id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code -id}.</li>
   *   <li>Then return {@code --id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenId_thenReturnId4() {
    // Arrange, Act and Assert
    assertEquals("--id", (new AdminComponentIdProcessor()).cleanCssIdString(" -id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code id}.</li>
   *   <li>Then return {@code -id-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenId_thenReturnId5() {
    // Arrange, Act and Assert
    assertEquals("-id-", (new AdminComponentIdProcessor()).cleanCssIdString(" id "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code id-}.</li>
   *   <li>Then return {@code -id-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenId_thenReturnId6() {
    // Arrange, Act and Assert
    assertEquals("-id-", (new AdminComponentIdProcessor()).cleanCssIdString(" id-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code idid}.</li>
   *   <li>Then return {@code -idid}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIdid_thenReturnIdid() {
    // Arrange, Act and Assert
    assertEquals("-idid", (new AdminComponentIdProcessor()).cleanCssIdString(" idid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code In42}.</li>
   *   <li>Then return {@code -In42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIn42_thenReturnIn42() {
    // Arrange, Act and Assert
    assertEquals("-In42", (new AdminComponentIdProcessor()).cleanCssIdString(" In42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code In[^a-zA-Z0-9-]}.</li>
   *   <li>Then return {@code In--a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInAZAZ09_thenReturnInAZAZ09() {
    // Arrange, Act and Assert
    assertEquals("In--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("In[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code In[^a-zA-Z0-9-]}.</li>
   *   <li>Then return {@code -In--a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInAZAZ09_thenReturnInAZAZ092() {
    // Arrange, Act and Assert
    assertEquals("-In--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString(" In[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code InIn}.</li>
   *   <li>Then return {@code -InIn}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInIn_thenReturnInIn() {
    // Arrange, Act and Assert
    assertEquals("-InIn", (new AdminComponentIdProcessor()).cleanCssIdString(" InIn"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code In}.</li>
   *   <li>Then return {@code In}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIn_thenReturnIn() {
    // Arrange, Act and Assert
    assertEquals("In", (new AdminComponentIdProcessor()).cleanCssIdString("In"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code In}.</li>
   *   <li>Then return {@code -In}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIn_thenReturnIn2() {
    // Arrange, Act and Assert
    assertEquals("-In", (new AdminComponentIdProcessor()).cleanCssIdString(" In"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code In}.</li>
   *   <li>Then return {@code In-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIn_thenReturnIn3() {
    // Arrange, Act and Assert
    assertEquals("In-", (new AdminComponentIdProcessor()).cleanCssIdString("In "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code In}.</li>
   *   <li>Then return {@code --In}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIn_thenReturnIn4() {
    // Arrange, Act and Assert
    assertEquals("--In", (new AdminComponentIdProcessor()).cleanCssIdString("  In"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code -In}.</li>
   *   <li>Then return {@code --In}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIn_thenReturnIn5() {
    // Arrange, Act and Assert
    assertEquals("--In", (new AdminComponentIdProcessor()).cleanCssIdString(" -In"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code In}.</li>
   *   <li>Then return {@code -In-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIn_thenReturnIn6() {
    // Arrange, Act and Assert
    assertEquals("-In-", (new AdminComponentIdProcessor()).cleanCssIdString(" In "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code In-}.</li>
   *   <li>Then return {@code -In-}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIn_thenReturnIn7() {
    // Arrange, Act and Assert
    assertEquals("-In-", (new AdminComponentIdProcessor()).cleanCssIdString(" In-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code Inid}.</li>
   *   <li>Then return {@code -Inid}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInid_thenReturnInid() {
    // Arrange, Act and Assert
    assertEquals("-Inid", (new AdminComponentIdProcessor()).cleanCssIdString(" Inid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When space space space.</li>
   *   <li>Then return {@code ---}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenSpaceSpaceSpace_thenReturnDashDashDash() {
    // Arrange, Act and Assert
    assertEquals("---", (new AdminComponentIdProcessor()).cleanCssIdString("   "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When space space.</li>
   *   <li>Then return {@code --}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenSpaceSpace_thenReturnDashDash() {
    // Arrange, Act and Assert
    assertEquals("--", (new AdminComponentIdProcessor()).cleanCssIdString("  "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When space.</li>
   *   <li>Then return {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenSpace_thenReturnDash() {
    // Arrange, Act and Assert
    assertEquals("-", (new AdminComponentIdProcessor()).cleanCssIdString(" "));
  }
}
