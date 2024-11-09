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
package org.broadleafcommerce.openadmin.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.broadleafcommerce.openadmin.web.form.entity.CodeField;
import org.broadleafcommerce.presentation.model.BroadleafAttributeModifier;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
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
  public void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10002, (new AdminComponentIdProcessor()).getPrecedence());
  }

  /**
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link CodeField} (default constructor).</li>
   *   <li>Then return Added {@code id} is {@code field-null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_givenCodeField_thenReturnAddedIdIsFieldNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link ListGrid} {@link ListGrid#getListGridType()} return
   * {@code -}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_givenListGridGetListGridTypeReturnDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link ListGrid} {@link ListGrid#getSubCollectionFieldName()}
   * return {@code -}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_givenListGridGetSubCollectionFieldNameReturnDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link ListGrid} {@link ListGrid#getSubCollectionFieldName()}
   * return {@code -}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_givenListGridGetSubCollectionFieldNameReturnDash2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("/");
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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor).</li>
   *   <li>Then return Added {@code id} is {@code listGrid-null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_givenListGrid_thenReturnAddedIdIsListGridNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code Parse Expression}.</li>
   *   <li>Then return Added {@code id} is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_givenParseExpression_thenReturnAddedIdIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid--}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGrid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid----}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGrid2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGrid3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("");
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
    assertEquals("listGrid---", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid--}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGrid4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("/");
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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid----}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGrid5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("/");
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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGrid42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-42---a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGrid42AZAZ09() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("42");
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
    assertEquals("listGrid-42---a-zA-Z0-9--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is
   * {@code listGrid-42-Sub-Collection-Field-Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGrid42SubCollectionFieldName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-42--}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGrid422() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("42");
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
    assertEquals("listGrid-42--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGrid423() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("/");
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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-----a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ09() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is
   * {@code listGrid---a-zA-Z0-9-----a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ09AZAZ09() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---a-zA-Z0-9---foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ09Foo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---a-zA-Z0-9---id}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ09Id() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is
   * {@code listGrid---a-zA-Z0-9---listGrid-}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ09ListGrid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---a-zA-Z0-9---none}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ09None() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-----a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ092() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ093() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---a-zA-Z0-9----}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ094() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---a-zA-Z0-9----}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ095() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid----a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ096() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("");
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
    assertEquals("listGrid----a-zA-Z0-9--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-----a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ097() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("/");
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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---a-zA-Z0-9---42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ0942() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-foo--}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridFoo2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("foo");
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
    assertEquals("listGrid-foo--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridFoo3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("/");
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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-foo---a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridFooAZAZ09() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("foo");
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
    assertEquals("listGrid-foo---a-zA-Z0-9--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is
   * {@code listGrid-foo-Sub-Collection-Field-Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridFooSubCollectionFieldName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---id}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-id--}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridId2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("id");
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
    assertEquals("listGrid-id--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---id}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridId3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("/");
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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-id---a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridIdAZAZ09() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("id");
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
    assertEquals("listGrid-id---a-zA-Z0-9--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is
   * {@code listGrid-id-Sub-Collection-Field-Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridIdSubCollectionFieldName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---listGrid-}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGrid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-listGrid---}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGrid2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---listGrid-}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGrid3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("/");
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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is
   * {@code listGrid-listGrid----a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridAZAZ09() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-List-Grid-Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-List-Grid-Type--}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-List-Grid-Type--}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridType3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-List-Grid-Type-42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridType42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is
   * {@code listGrid-List-Grid-Type---a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridTypeAZAZ09() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-List-Grid-Type-foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridTypeFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-List-Grid-Type-id}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridTypeId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is
   * {@code listGrid-List-Grid-Type-listGrid-}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridTypeListGrid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is
   * {@code listGrid-List-Grid-Type-none}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridTypeNone() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---none}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridNone() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---none}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridNone2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("/");
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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-none--}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridNone3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("none");
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
    assertEquals("listGrid-none--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-none---a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridNoneAZAZ09() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("none");
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
    assertEquals("listGrid-none---a-zA-Z0-9--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is
   * {@code listGrid-none-Sub-Collection-Field-Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridNoneSubCollectionFieldName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is
   * {@code listGrid---Sub-Collection-Field-Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridSubCollectionFieldName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is
   * {@code listGrid---Sub-Collection-Field-Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridSubCollectionFieldName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is
   * {@code listGrid--Sub-Collection-Field-Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridSubCollectionFieldName3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return Added {@code id} is
   * {@code listGrid---Sub-Collection-Field-Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridSubCollectionFieldName4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field", (new AdminComponentIdProcessor())
        .cleanCssIdString("[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("Inorg-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("Inorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("42org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("42org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("idorg-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("idorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("org-broadleafcommerce-openadmin-web-form-component-ListGrid-", (new AdminComponentIdProcessor())
        .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.component.ListGrid "));
    assertEquals("org-broadleafcommerce-openadmin-web-form-component-ListGrid--a-zA-Z0-9--",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.component.ListGrid[^a-zA-Z0-9-]"));
    assertEquals("org-broadleafcommerce-openadmin-web-form-component-ListGrid-", (new AdminComponentIdProcessor())
        .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.component.ListGrid-"));
    assertEquals("org-broadleafcommerce-openadmin-web-form-component-ListGridIn", (new AdminComponentIdProcessor())
        .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.component.ListGridIn"));
    assertEquals("org-broadleafcommerce-openadmin-web-form-component-ListGrid42", (new AdminComponentIdProcessor())
        .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.component.ListGrid42"));
    assertEquals("org-broadleafcommerce-openadmin-web-form-component-ListGridid", (new AdminComponentIdProcessor())
        .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.component.ListGridid"));
    assertEquals("org-broadleafcommerce-openadmin-web-form-entity-Field--a-zA-Z0-9--", (new AdminComponentIdProcessor())
        .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.entity.Field[^a-zA-Z0-9-]"));
    assertEquals("--org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("  org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("---a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        (new AdminComponentIdProcessor())
            .cleanCssIdString(" [^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("---a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor())
            .cleanCssIdString(" [^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("-Inorg-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString(" Inorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("-42org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString(" 42org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("-idorg-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString(" idorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGrid-", (new AdminComponentIdProcessor())
        .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.component.ListGrid "));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGrid--a-zA-Z0-9--",
        (new AdminComponentIdProcessor())
            .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.component.ListGrid[^a-zA-Z0-9-]"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGridIn", (new AdminComponentIdProcessor())
        .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.component.ListGridIn"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGrid42", (new AdminComponentIdProcessor())
        .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.component.ListGrid42"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGridid", (new AdminComponentIdProcessor())
        .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.component.ListGridid"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Field--a-zA-Z0-9--",
        (new AdminComponentIdProcessor())
            .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.entity.Field[^a-zA-Z0-9-]"));
    assertEquals("--a-zA-Z0-9---org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-] org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("--a-zA-Z0-9----a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("--a-zA-Z0-9----a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("--a-zA-Z0-9---org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]-org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("--a-zA-Z0-9--Inorg-broadleafcommerce-openadmin-web-form-component-ListGrid",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]Inorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("--a-zA-Z0-9--Inorg-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]Inorg.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("--a-zA-Z0-9--42org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]42org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("--a-zA-Z0-9--42org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]42org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("--a-zA-Z0-9--idorg-broadleafcommerce-openadmin-web-form-component-ListGrid",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]idorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("--a-zA-Z0-9--idorg-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]idorg.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGrid-",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGrid "));
    assertEquals("--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGrid--a-zA-Z0-9--",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGrid[^a-zA-Z0-9-]"));
    assertEquals("--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGrid-",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGrid-"));
    assertEquals("--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGridIn",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGridIn"));
    assertEquals("--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGrid42",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGrid42"));
    assertEquals("--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGridid",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGridid"));
    assertEquals("--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field-",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field "));
    assertEquals("--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field--a-zA-Z0-9--",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field[^a-zA-Z0-9-]"));
    assertEquals("--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-FieldIn",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.FieldIn"));
    assertEquals("--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field42",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field42"));
    assertEquals("--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Fieldid",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Fieldid"));
    assertEquals("---a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("-[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGrid--a-zA-Z0-9--",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.component.ListGrid[^a-zA-Z0-9-]"));
    assertEquals("In--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("In[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("In--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("In[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("InInorg-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("InInorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("InInorg-broadleafcommerce-openadmin-web-form-entity-Field", (new AdminComponentIdProcessor())
        .cleanCssIdString("InInorg.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("In42org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("In42org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("In42org-broadleafcommerce-openadmin-web-form-entity-Field", (new AdminComponentIdProcessor())
        .cleanCssIdString("In42org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return
   * {@code 42org-broadleafcommerce-openadmin-web-form-entity-Field}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_thenReturn42orgBroadleafcommerceOpenadminWebFormEntityField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("42org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("42org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("-42org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString(" 42org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return
   * {@code idorg-broadleafcommerce-openadmin-web-form-entity-Field}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_thenReturnIdorgBroadleafcommerceOpenadminWebFormEntityField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("idorg-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("idorg.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("-idorg-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString(" idorg.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return
   * {@code Inorg-broadleafcommerce-openadmin-web-form-entity-Field}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_thenReturnInorgBroadleafcommerceOpenadminWebFormEntityField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Inorg-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("Inorg.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("-Inorg-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString(" Inorg.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return
   * {@code org-broadleafcommerce-openadmin-web-form-entity-Field}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("org-broadleafcommerce-openadmin-web-form-entity-Field-",
        (new AdminComponentIdProcessor()).cleanCssIdString("org.broadleafcommerce.openadmin.web.form.entity.Field "));
    assertEquals("org-broadleafcommerce-openadmin-web-form-entity-Field-",
        (new AdminComponentIdProcessor()).cleanCssIdString("org.broadleafcommerce.openadmin.web.form.entity.Field-"));
    assertEquals("--org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("  org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Field-",
        (new AdminComponentIdProcessor()).cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.entity.Field "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return
   * {@code org-broadleafcommerce-openadmin-web-form-entity-Field42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityField42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("org-broadleafcommerce-openadmin-web-form-entity-Field42",
        (new AdminComponentIdProcessor()).cleanCssIdString("org.broadleafcommerce.openadmin.web.form.entity.Field42"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Field42",
        (new AdminComponentIdProcessor()).cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.entity.Field42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return
   * {@code org-broadleafcommerce-openadmin-web-form-entity-FieldIn}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityFieldIn() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("org-broadleafcommerce-openadmin-web-form-entity-FieldIn",
        (new AdminComponentIdProcessor()).cleanCssIdString("org.broadleafcommerce.openadmin.web.form.entity.FieldIn"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-FieldIn",
        (new AdminComponentIdProcessor()).cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.entity.FieldIn"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>Then return
   * {@code org-broadleafcommerce-openadmin-web-form-entity-Fieldid}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityFieldid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("org-broadleafcommerce-openadmin-web-form-entity-Fieldid",
        (new AdminComponentIdProcessor()).cleanCssIdString("org.broadleafcommerce.openadmin.web.form.entity.Fieldid"));
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
  public void testCleanCssIdString_when42AZAZ09_thenReturn42AZAZ09() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("42--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("42[^a-zA-Z0-9-]"));
    assertEquals("-42--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString(" 42[^a-zA-Z0-9-]"));
    assertEquals("-42--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("-42[^a-zA-Z0-9-]"));
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
  public void testCleanCssIdString_when42In_thenReturn42In() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testCleanCssIdString_when42_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("-42", (new AdminComponentIdProcessor()).cleanCssIdString(" 42"));
    assertEquals("42-", (new AdminComponentIdProcessor()).cleanCssIdString("42 "));
    assertEquals("--42", (new AdminComponentIdProcessor()).cleanCssIdString("  42"));
    assertEquals("--42", (new AdminComponentIdProcessor()).cleanCssIdString(" -42"));
    assertEquals("-42-", (new AdminComponentIdProcessor()).cleanCssIdString(" 42 "));
    assertEquals("-42-", (new AdminComponentIdProcessor()).cleanCssIdString(" 42-"));
    assertEquals("--42", (new AdminComponentIdProcessor()).cleanCssIdString("- 42"));
    assertEquals("-42-", (new AdminComponentIdProcessor()).cleanCssIdString("-42 "));
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
  public void testCleanCssIdString_when42id_thenReturn42id() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("-42id", (new AdminComponentIdProcessor()).cleanCssIdString(" 42id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When
   * {@code -42org.broadleafcommerce.openadmin.web.form.component.ListGrid}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_when42orgBroadleafcommerceOpenadminWebFormComponentListGrid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("-42org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("-42org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When
   * {@code -42org.broadleafcommerce.openadmin.web.form.entity.Field}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_when42orgBroadleafcommerceOpenadminWebFormEntityField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("-42org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("-42org.broadleafcommerce.openadmin.web.form.entity.Field"));
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
  public void testCleanCssIdString_when4242_thenReturn4242() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testCleanCssIdString_whenAString_thenReturnAString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(
        "org-broadleafcommerce-openadmin-web-form-component-ListGridorg-broadleafcommerce-openadmin-web-form"
            + "-component-ListGrid",
        (new AdminComponentIdProcessor()).cleanCssIdString(
            "org.broadleafcommerce.openadmin.web.form.component.ListGridorg.broadleafcommerce.openadmin.web.form"
                + ".component.ListGrid"));
    assertEquals(
        "org-broadleafcommerce-openadmin-web-form-component-ListGridorg-broadleafcommerce-openadmin-web-form"
            + "-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString(
            "org.broadleafcommerce.openadmin.web.form.component.ListGridorg.broadleafcommerce.openadmin.web.form"
                + ".entity.Field"));
    assertEquals(
        "org-broadleafcommerce-openadmin-web-form-entity-Fieldorg-broadleafcommerce-openadmin-web-form-component"
            + "-ListGrid",
        (new AdminComponentIdProcessor()).cleanCssIdString(
            "org.broadleafcommerce.openadmin.web.form.entity.Fieldorg.broadleafcommerce.openadmin.web.form.component"
                + ".ListGrid"));
    assertEquals(
        "org-broadleafcommerce-openadmin-web-form-entity-Fieldorg-broadleafcommerce-openadmin-web-form"
            + "-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString(
            "org.broadleafcommerce.openadmin.web.form.entity.Fieldorg.broadleafcommerce.openadmin.web.form"
                + ".entity.Field"));
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-component-ListGridorg-broadleafcommerce-openadmin-web-form"
            + "-component-ListGrid",
        (new AdminComponentIdProcessor()).cleanCssIdString(
            " org.broadleafcommerce.openadmin.web.form.component.ListGridorg.broadleafcommerce.openadmin.web.form"
                + ".component.ListGrid"));
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-component-ListGridorg-broadleafcommerce-openadmin-web-form"
            + "-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString(
            " org.broadleafcommerce.openadmin.web.form.component.ListGridorg.broadleafcommerce.openadmin.web.form"
                + ".entity.Field"));
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-entity-Fieldorg-broadleafcommerce-openadmin-web-form-component"
            + "-ListGrid",
        (new AdminComponentIdProcessor()).cleanCssIdString(
            " org.broadleafcommerce.openadmin.web.form.entity.Fieldorg.broadleafcommerce.openadmin.web.form.component"
                + ".ListGrid"));
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-entity-Fieldorg-broadleafcommerce-openadmin-web-form"
            + "-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString(
            " org.broadleafcommerce.openadmin.web.form.entity.Fieldorg.broadleafcommerce.openadmin.web.form"
                + ".entity.Field"));
    assertEquals(
        "--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGridorg-broadleafcommerce-openadmin"
            + "-web-form-component-ListGrid",
        (new AdminComponentIdProcessor()).cleanCssIdString(
            "[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGridorg.broadleafcommerce.openadmin"
                + ".web.form.component.ListGrid"));
    assertEquals(
        "--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGridorg-broadleafcommerce-openadmin"
            + "-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString(
            "[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGridorg.broadleafcommerce.openadmin"
                + ".web.form.entity.Field"));
    assertEquals(
        "--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Fieldorg-broadleafcommerce-openadmin-web"
            + "-form-component-ListGrid",
        (new AdminComponentIdProcessor()).cleanCssIdString(
            "[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Fieldorg.broadleafcommerce.openadmin.web"
                + ".form.component.ListGrid"));
    assertEquals(
        "--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Fieldorg-broadleafcommerce-openadmin-web"
            + "-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString(
            "[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Fieldorg.broadleafcommerce.openadmin.web"
                + ".form.entity.Field"));
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-component-ListGridorg-broadleafcommerce-openadmin-web-form"
            + "-component-ListGrid",
        (new AdminComponentIdProcessor()).cleanCssIdString(
            "-org.broadleafcommerce.openadmin.web.form.component.ListGridorg.broadleafcommerce.openadmin.web.form"
                + ".component.ListGrid"));
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-component-ListGridorg-broadleafcommerce-openadmin-web-form"
            + "-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString(
            "-org.broadleafcommerce.openadmin.web.form.component.ListGridorg.broadleafcommerce.openadmin.web.form"
                + ".entity.Field"));
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-entity-Fieldorg-broadleafcommerce-openadmin-web-form-component"
            + "-ListGrid",
        (new AdminComponentIdProcessor()).cleanCssIdString(
            "-org.broadleafcommerce.openadmin.web.form.entity.Fieldorg.broadleafcommerce.openadmin.web.form.component"
                + ".ListGrid"));
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-entity-Fieldorg-broadleafcommerce-openadmin-web-form"
            + "-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString(
            "-org.broadleafcommerce.openadmin.web.form.entity.Fieldorg.broadleafcommerce.openadmin.web.form"
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
  public void testCleanCssIdString_whenAZAZ09AZAZ09AZAZ09_thenReturnAZAZ09AZAZ09AZAZ09() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testCleanCssIdString_whenAZAZ09AZAZ09Id_thenReturnAZAZ09AZAZ09Id() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testCleanCssIdString_whenAZAZ09AZAZ09In_thenReturnAZAZ09AZAZ09In() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testCleanCssIdString_whenAZAZ09AZAZ09_thenReturnAZAZ09AZAZ09() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9----a-zA-Z0-9--",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-]"));
    assertEquals("---a-zA-Z0-9----a-zA-Z0-9--",
        (new AdminComponentIdProcessor()).cleanCssIdString(" [^a-zA-Z0-9-][^a-zA-Z0-9-]"));
    assertEquals("--a-zA-Z0-9-----a-zA-Z0-9--",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-] [^a-zA-Z0-9-]"));
    assertEquals("--a-zA-Z0-9----a-zA-Z0-9---",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-] "));
    assertEquals("--a-zA-Z0-9----a-zA-Z0-9---",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-]-"));
    assertEquals("--a-zA-Z0-9-----a-zA-Z0-9--",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]-[^a-zA-Z0-9-]"));
    assertEquals("---a-zA-Z0-9----a-zA-Z0-9--",
        (new AdminComponentIdProcessor()).cleanCssIdString("-[^a-zA-Z0-9-][^a-zA-Z0-9-]"));
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
  public void testCleanCssIdString_whenAZAZ09AZAZ0942_thenReturnAZAZ09AZAZ0942() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9----a-zA-Z0-9--42",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-]42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]id42}.</li>
   *   <li>Then return {@code --a-zA-Z0-9--id42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenAZAZ09Id42_thenReturnAZAZ09Id42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9--id42", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]id42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]id[^a-zA-Z0-9-]}.</li>
   *   <li>Then return {@code --a-zA-Z0-9--id--a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenAZAZ09IdAZAZ09_thenReturnAZAZ09IdAZAZ09() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9--id--a-zA-Z0-9--",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]id[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]idIn}.</li>
   *   <li>Then return {@code --a-zA-Z0-9--idIn}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenAZAZ09IdIn_thenReturnAZAZ09IdIn() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9--idIn", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]idIn"));
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
  public void testCleanCssIdString_whenAZAZ09Id_thenReturnAZAZ09Id() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9--id", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]id"));
    assertEquals("---a-zA-Z0-9--id", (new AdminComponentIdProcessor()).cleanCssIdString(" [^a-zA-Z0-9-]id"));
    assertEquals("--a-zA-Z0-9---id", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-] id"));
    assertEquals("--a-zA-Z0-9---id", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]-id"));
    assertEquals("--a-zA-Z0-9--id-", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]id "));
    assertEquals("--a-zA-Z0-9--id-", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]id-"));
    assertEquals("---a-zA-Z0-9--id", (new AdminComponentIdProcessor()).cleanCssIdString("-[^a-zA-Z0-9-]id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]idid}.</li>
   *   <li>Then return {@code --a-zA-Z0-9--idid}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenAZAZ09Idid_thenReturnAZAZ09Idid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9--idid", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]idid"));
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
  public void testCleanCssIdString_whenAZAZ09In42_thenReturnAZAZ09In42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testCleanCssIdString_whenAZAZ09InAZAZ09_thenReturnAZAZ09InAZAZ09() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testCleanCssIdString_whenAZAZ09InIn_thenReturnAZAZ09InIn() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testCleanCssIdString_whenAZAZ09In_thenReturnAZAZ09In() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9--In", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]In"));
    assertEquals("---a-zA-Z0-9--In", (new AdminComponentIdProcessor()).cleanCssIdString(" [^a-zA-Z0-9-]In"));
    assertEquals("--a-zA-Z0-9---In", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-] In"));
    assertEquals("--a-zA-Z0-9---In", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]-In"));
    assertEquals("--a-zA-Z0-9--In-", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]In "));
    assertEquals("--a-zA-Z0-9--In-", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]In-"));
    assertEquals("---a-zA-Z0-9--In", (new AdminComponentIdProcessor()).cleanCssIdString("-[^a-zA-Z0-9-]In"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]Inid}.</li>
   *   <li>Then return {@code --a-zA-Z0-9--Inid}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenAZAZ09Inid_thenReturnAZAZ09Inid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9--Inid", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]Inid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When
   * {@code [^a-zA-Z0-9-] org.broadleafcommerce.openadmin.web.form.entity.Field}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenAZAZ09OrgBroadleafcommerceOpenadminWebFormEntityField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9---org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-] org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("--a-zA-Z0-9---org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]-org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field-",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field-"));
    assertEquals("---a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("-[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field"));
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
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ09() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]"));
    assertEquals("---a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString(" [^a-zA-Z0-9-]"));
    assertEquals("--a-zA-Z0-9---", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-] "));
    assertEquals("--a-zA-Z0-9---", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]-"));
    assertEquals("---a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("-[^a-zA-Z0-9-]"));
    assertEquals("----a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("  [^a-zA-Z0-9-]"));
    assertEquals("---a-zA-Z0-9---", (new AdminComponentIdProcessor()).cleanCssIdString(" [^a-zA-Z0-9-] "));
    assertEquals("---a-zA-Z0-9---", (new AdminComponentIdProcessor()).cleanCssIdString(" [^a-zA-Z0-9-]-"));
    assertEquals("----a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString(" -[^a-zA-Z0-9-]"));
    assertEquals("--a-zA-Z0-9----", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]  "));
    assertEquals("--a-zA-Z0-9----", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-] -"));
    assertEquals("--a-zA-Z0-9----", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]- "));
    assertEquals("--a-zA-Z0-9----", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]--"));
    assertEquals("----a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("- [^a-zA-Z0-9-]"));
    assertEquals("---a-zA-Z0-9---", (new AdminComponentIdProcessor()).cleanCssIdString("-[^a-zA-Z0-9-] "));
    assertEquals("---a-zA-Z0-9---", (new AdminComponentIdProcessor()).cleanCssIdString("-[^a-zA-Z0-9-]-"));
    assertEquals("----a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("--[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]42[^a-zA-Z0-9-]}.</li>
   *   <li>Then return {@code --a-zA-Z0-9--42--a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenAZAZ0942AZAZ09_thenReturnAZAZ0942AZAZ09() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9--42--a-zA-Z0-9--",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]42[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]42In}.</li>
   *   <li>Then return {@code --a-zA-Z0-9--42In}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenAZAZ0942In_thenReturnAZAZ0942In() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9--42In", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]42In"));
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
  public void testCleanCssIdString_whenAZAZ0942_thenReturnAZAZ0942() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9--42", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]42"));
    assertEquals("---a-zA-Z0-9--42", (new AdminComponentIdProcessor()).cleanCssIdString(" [^a-zA-Z0-9-]42"));
    assertEquals("--a-zA-Z0-9---42", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-] 42"));
    assertEquals("--a-zA-Z0-9---42", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]-42"));
    assertEquals("--a-zA-Z0-9--42-", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]42 "));
    assertEquals("--a-zA-Z0-9--42-", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]42-"));
    assertEquals("---a-zA-Z0-9--42", (new AdminComponentIdProcessor()).cleanCssIdString("-[^a-zA-Z0-9-]42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]42id}.</li>
   *   <li>Then return {@code --a-zA-Z0-9--42id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenAZAZ0942id_thenReturnAZAZ0942id() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9--42id", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]42id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]4242}.</li>
   *   <li>Then return {@code --a-zA-Z0-9--4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenAZAZ094242_thenReturnAZAZ094242() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("--a-zA-Z0-9--4242", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]4242"));
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
  public void testCleanCssIdString_whenDashDash_thenReturnDashDashDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("---", (new AdminComponentIdProcessor()).cleanCssIdString(" --"));
    assertEquals("---", (new AdminComponentIdProcessor()).cleanCssIdString("-- "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code - -}.</li>
   *   <li>Then return {@code ---}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenDashSpaceDash_thenReturnDashDashDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("---", (new AdminComponentIdProcessor()).cleanCssIdString("- -"));
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
  public void testCleanCssIdString_whenDash_thenReturnDashDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("--", (new AdminComponentIdProcessor()).cleanCssIdString(" -"));
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
  public void testCleanCssIdString_whenDash_thenReturnDashDashDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("---", (new AdminComponentIdProcessor()).cleanCssIdString("  -"));
    assertEquals("---", (new AdminComponentIdProcessor()).cleanCssIdString(" - "));
    assertEquals("---", (new AdminComponentIdProcessor()).cleanCssIdString("-  "));
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
  public void testCleanCssIdString_whenId42_thenReturnId42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testCleanCssIdString_whenIdAZAZ09_thenReturnIdAZAZ09() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("id--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("id[^a-zA-Z0-9-]"));
    assertEquals("-id--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString(" id[^a-zA-Z0-9-]"));
    assertEquals("-id--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("-id[^a-zA-Z0-9-]"));
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
  public void testCleanCssIdString_whenIdIn_thenReturnIdIn() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testCleanCssIdString_whenId_thenReturnId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("-id", (new AdminComponentIdProcessor()).cleanCssIdString(" id"));
    assertEquals("id-", (new AdminComponentIdProcessor()).cleanCssIdString("id "));
    assertEquals("--id", (new AdminComponentIdProcessor()).cleanCssIdString("  id"));
    assertEquals("--id", (new AdminComponentIdProcessor()).cleanCssIdString(" -id"));
    assertEquals("-id-", (new AdminComponentIdProcessor()).cleanCssIdString(" id "));
    assertEquals("-id-", (new AdminComponentIdProcessor()).cleanCssIdString(" id-"));
    assertEquals("--id", (new AdminComponentIdProcessor()).cleanCssIdString("- id"));
    assertEquals("-id-", (new AdminComponentIdProcessor()).cleanCssIdString("-id "));
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
  public void testCleanCssIdString_whenIdid_thenReturnIdid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("-idid", (new AdminComponentIdProcessor()).cleanCssIdString(" idid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When
   * {@code -idorg.broadleafcommerce.openadmin.web.form.component.ListGrid}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenIdorgBroadleafcommerceOpenadminWebFormComponentListGrid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("-idorg-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("-idorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When
   * {@code -idorg.broadleafcommerce.openadmin.web.form.entity.Field}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenIdorgBroadleafcommerceOpenadminWebFormEntityField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("-idorg-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("-idorg.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code In42[^a-zA-Z0-9-]}.</li>
   *   <li>Then return {@code In42--a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenIn42AZAZ09_thenReturnIn42AZAZ09() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("In42--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("In42[^a-zA-Z0-9-]"));
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
  public void testCleanCssIdString_whenIn42_thenReturnIn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("-In42", (new AdminComponentIdProcessor()).cleanCssIdString(" In42"));
    assertEquals("In-42", (new AdminComponentIdProcessor()).cleanCssIdString("In 42"));
    assertEquals("In42-", (new AdminComponentIdProcessor()).cleanCssIdString("In42 "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code In[^a-zA-Z0-9-][^a-zA-Z0-9-]}.</li>
   *   <li>Then return {@code In--a-zA-Z0-9----a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenInAZAZ09AZAZ09_thenReturnInAZAZ09AZAZ09() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("In--a-zA-Z0-9----a-zA-Z0-9--",
        (new AdminComponentIdProcessor()).cleanCssIdString("In[^a-zA-Z0-9-][^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code In[^a-zA-Z0-9-]id}.</li>
   *   <li>Then return {@code In--a-zA-Z0-9--id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenInAZAZ09Id_thenReturnInAZAZ09Id() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("In--a-zA-Z0-9--id", (new AdminComponentIdProcessor()).cleanCssIdString("In[^a-zA-Z0-9-]id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code In[^a-zA-Z0-9-]In}.</li>
   *   <li>Then return {@code In--a-zA-Z0-9--In}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenInAZAZ09In_thenReturnInAZAZ09In() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("In--a-zA-Z0-9--In", (new AdminComponentIdProcessor()).cleanCssIdString("In[^a-zA-Z0-9-]In"));
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
  public void testCleanCssIdString_whenInAZAZ09_thenReturnInAZAZ09() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("In--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("In[^a-zA-Z0-9-]"));
    assertEquals("-In--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString(" In[^a-zA-Z0-9-]"));
    assertEquals("-In--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("-In[^a-zA-Z0-9-]"));
    assertEquals("In---a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("In [^a-zA-Z0-9-]"));
    assertEquals("In--a-zA-Z0-9---", (new AdminComponentIdProcessor()).cleanCssIdString("In[^a-zA-Z0-9-] "));
    assertEquals("In--a-zA-Z0-9---", (new AdminComponentIdProcessor()).cleanCssIdString("In[^a-zA-Z0-9-]-"));
    assertEquals("In---a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("In-[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code In[^a-zA-Z0-9-]42}.</li>
   *   <li>Then return {@code In--a-zA-Z0-9--42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenInAZAZ0942_thenReturnInAZAZ0942() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("In--a-zA-Z0-9--42", (new AdminComponentIdProcessor()).cleanCssIdString("In[^a-zA-Z0-9-]42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code In id}.</li>
   *   <li>Then return {@code In-id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenInId_thenReturnInId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("In-id", (new AdminComponentIdProcessor()).cleanCssIdString("In id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code InIn[^a-zA-Z0-9-]}.</li>
   *   <li>Then return {@code InIn--a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenInInAZAZ09_thenReturnInInAZAZ09() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("InIn--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("InIn[^a-zA-Z0-9-]"));
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
  public void testCleanCssIdString_whenInIn_thenReturnInIn() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("-InIn", (new AdminComponentIdProcessor()).cleanCssIdString(" InIn"));
    assertEquals("In-In", (new AdminComponentIdProcessor()).cleanCssIdString("In In"));
    assertEquals("InIn-", (new AdminComponentIdProcessor()).cleanCssIdString("InIn "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When
   * {@code In org.broadleafcommerce.openadmin.web.form.component.ListGrid}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenInOrgBroadleafcommerceOpenadminWebFormComponentListGrid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("In-org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("In org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("In-org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("In-org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When
   * {@code In org.broadleafcommerce.openadmin.web.form.entity.Field}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenInOrgBroadleafcommerceOpenadminWebFormEntityField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("In-org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("In org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("In-org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("In-org.broadleafcommerce.openadmin.web.form.entity.Field"));
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
  public void testCleanCssIdString_whenIn_thenReturnIn() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("In", (new AdminComponentIdProcessor()).cleanCssIdString("In"));
    assertEquals("-In", (new AdminComponentIdProcessor()).cleanCssIdString(" In"));
    assertEquals("In-", (new AdminComponentIdProcessor()).cleanCssIdString("In "));
    assertEquals("--In", (new AdminComponentIdProcessor()).cleanCssIdString("  In"));
    assertEquals("--In", (new AdminComponentIdProcessor()).cleanCssIdString(" -In"));
    assertEquals("-In-", (new AdminComponentIdProcessor()).cleanCssIdString(" In "));
    assertEquals("-In-", (new AdminComponentIdProcessor()).cleanCssIdString(" In-"));
    assertEquals("--In", (new AdminComponentIdProcessor()).cleanCssIdString("- In"));
    assertEquals("-In-", (new AdminComponentIdProcessor()).cleanCssIdString("-In "));
    assertEquals("In--", (new AdminComponentIdProcessor()).cleanCssIdString("In  "));
    assertEquals("In--", (new AdminComponentIdProcessor()).cleanCssIdString("In -"));
    assertEquals("In--", (new AdminComponentIdProcessor()).cleanCssIdString("In- "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code Inid[^a-zA-Z0-9-]}.</li>
   *   <li>Then return {@code Inid--a-zA-Z0-9--}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenInidAZAZ09_thenReturnInidAZAZ09() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Inid--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("Inid[^a-zA-Z0-9-]"));
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
  public void testCleanCssIdString_whenInid_thenReturnInid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("-Inid", (new AdminComponentIdProcessor()).cleanCssIdString(" Inid"));
    assertEquals("Inid-", (new AdminComponentIdProcessor()).cleanCssIdString("Inid "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When
   * {@code -Inorg.broadleafcommerce.openadmin.web.form.component.ListGrid}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenInorgBroadleafcommerceOpenadminWebFormComponentListGrid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("-Inorg-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("-Inorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When
   * {@code -Inorg.broadleafcommerce.openadmin.web.form.entity.Field}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenInorgBroadleafcommerceOpenadminWebFormEntityField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("-Inorg-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("-Inorg.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When
   * {@code -org.broadleafcommerce.openadmin.web.form.component.ListGrid}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormComponentListGrid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("--org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString(" -org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGrid-", (new AdminComponentIdProcessor())
        .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.component.ListGrid-"));
    assertEquals("--org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("- org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("--org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("--org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGrid-", (new AdminComponentIdProcessor())
        .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.component.ListGrid "));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGrid-", (new AdminComponentIdProcessor())
        .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.component.ListGrid-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When
   * {@code -org.broadleafcommerce.openadmin.web.form.component.ListGrid42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormComponentListGrid42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGrid42", (new AdminComponentIdProcessor())
        .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.component.ListGrid42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When
   * {@code -org.broadleafcommerce.openadmin.web.form.component.ListGridIn}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormComponentListGridIn() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGridIn", (new AdminComponentIdProcessor())
        .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.component.ListGridIn"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When
   * {@code -org.broadleafcommerce.openadmin.web.form.component.ListGridid}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormComponentListGridid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGridid", (new AdminComponentIdProcessor())
        .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.component.ListGridid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When {@code -org.broadleafcommerce.openadmin.web.form.entity.Field}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormEntityField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("--org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString(" -org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Field-",
        (new AdminComponentIdProcessor()).cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.entity.Field-"));
    assertEquals("--org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("- org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("--org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("--org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Field-",
        (new AdminComponentIdProcessor()).cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.entity.Field "));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Field-",
        (new AdminComponentIdProcessor()).cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.entity.Field-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When
   * {@code -org.broadleafcommerce.openadmin.web.form.entity.Field42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormEntityField42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Field42",
        (new AdminComponentIdProcessor()).cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.entity.Field42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When
   * {@code -org.broadleafcommerce.openadmin.web.form.entity.Field[^a-zA-Z0-9-]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormEntityFieldAZAZ09() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Field--a-zA-Z0-9--",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.entity.Field[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When
   * {@code -org.broadleafcommerce.openadmin.web.form.entity.FieldIn}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormEntityFieldIn() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-FieldIn",
        (new AdminComponentIdProcessor()).cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.entity.FieldIn"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   * <ul>
   *   <li>When
   * {@code -org.broadleafcommerce.openadmin.web.form.entity.Fieldid}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormEntityFieldid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Fieldid",
        (new AdminComponentIdProcessor()).cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.entity.Fieldid"));
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
  public void testCleanCssIdString_whenSpaceSpaceSpace_thenReturnDashDashDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testCleanCssIdString_whenSpaceSpace_thenReturnDashDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testCleanCssIdString_whenSpace_thenReturnDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("-", (new AdminComponentIdProcessor()).cleanCssIdString(" "));
  }
}
