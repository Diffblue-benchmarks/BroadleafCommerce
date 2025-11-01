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
   * Method under test: {@link AdminComponentIdProcessor#getPrecedence()}
   */
  @Test
  public void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10002, (new AdminComponentIdProcessor()).getPrecedence());
  }

  /**
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes2() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes3() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes8() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes9() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes10() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes11() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes12() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes13() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes14() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes15() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes16() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes17() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes18() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes19() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes20() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes21() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes22() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes23() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes24() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes25() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes26() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes27() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes28() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes29() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes30() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes31() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes32() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes33() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes34() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes35() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes36() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes37() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes38() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes39() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes40() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes41() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes42() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes43() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes44() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes45() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes46() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes47() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes48() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes49() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes50() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes51() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes52() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes53() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes54() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes55() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes56() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes57() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes58() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes59() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes60() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes61() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes62() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes63() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes64() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes65() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes66() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes67() {
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
   * Method under test:
   * {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes68() {
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
   * Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  public void testCleanCssIdString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("In", (new AdminComponentIdProcessor()).cleanCssIdString("In"));
    assertEquals("-", (new AdminComponentIdProcessor()).cleanCssIdString(" "));
    assertEquals("--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]"));
    assertEquals("org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("--", (new AdminComponentIdProcessor()).cleanCssIdString("  "));
    assertEquals("---a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString(" [^a-zA-Z0-9-]"));
    assertEquals("--", (new AdminComponentIdProcessor()).cleanCssIdString(" -"));
    assertEquals("-In", (new AdminComponentIdProcessor()).cleanCssIdString(" In"));
    assertEquals("-42", (new AdminComponentIdProcessor()).cleanCssIdString(" 42"));
    assertEquals("-id", (new AdminComponentIdProcessor()).cleanCssIdString(" id"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("--a-zA-Z0-9---", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-] "));
    assertEquals("--a-zA-Z0-9----a-zA-Z0-9--",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-]"));
    assertEquals("--a-zA-Z0-9---", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]-"));
    assertEquals("--a-zA-Z0-9--In", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]In"));
    assertEquals("--a-zA-Z0-9--42", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]42"));
    assertEquals("--a-zA-Z0-9--id", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]id"));
    assertEquals("--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field", (new AdminComponentIdProcessor())
        .cleanCssIdString("[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("--", (new AdminComponentIdProcessor()).cleanCssIdString("- "));
    assertEquals("---a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("-[^a-zA-Z0-9-]"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("In-", (new AdminComponentIdProcessor()).cleanCssIdString("In "));
    assertEquals("In--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("In[^a-zA-Z0-9-]"));
    assertEquals("Inorg-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("Inorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("Inorg-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("Inorg.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("42-", (new AdminComponentIdProcessor()).cleanCssIdString("42 "));
    assertEquals("42--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("42[^a-zA-Z0-9-]"));
    assertEquals("42org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("42org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("42org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("42org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("id-", (new AdminComponentIdProcessor()).cleanCssIdString("id "));
    assertEquals("id--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("id[^a-zA-Z0-9-]"));
    assertEquals("idorg-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("idorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("idorg-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("idorg.broadleafcommerce.openadmin.web.form.entity.Field"));
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
    assertEquals("org-broadleafcommerce-openadmin-web-form-entity-Field-",
        (new AdminComponentIdProcessor()).cleanCssIdString("org.broadleafcommerce.openadmin.web.form.entity.Field "));
    assertEquals("org-broadleafcommerce-openadmin-web-form-entity-Field--a-zA-Z0-9--", (new AdminComponentIdProcessor())
        .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.entity.Field[^a-zA-Z0-9-]"));
    assertEquals("org-broadleafcommerce-openadmin-web-form-entity-Field-",
        (new AdminComponentIdProcessor()).cleanCssIdString("org.broadleafcommerce.openadmin.web.form.entity.Field-"));
    assertEquals("org-broadleafcommerce-openadmin-web-form-entity-FieldIn",
        (new AdminComponentIdProcessor()).cleanCssIdString("org.broadleafcommerce.openadmin.web.form.entity.FieldIn"));
    assertEquals("org-broadleafcommerce-openadmin-web-form-entity-Field42",
        (new AdminComponentIdProcessor()).cleanCssIdString("org.broadleafcommerce.openadmin.web.form.entity.Field42"));
    assertEquals("org-broadleafcommerce-openadmin-web-form-entity-Fieldid",
        (new AdminComponentIdProcessor()).cleanCssIdString("org.broadleafcommerce.openadmin.web.form.entity.Fieldid"));
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
    assertEquals("---", (new AdminComponentIdProcessor()).cleanCssIdString("   "));
    assertEquals("----a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("  [^a-zA-Z0-9-]"));
    assertEquals("---", (new AdminComponentIdProcessor()).cleanCssIdString("  -"));
    assertEquals("--In", (new AdminComponentIdProcessor()).cleanCssIdString("  In"));
    assertEquals("--42", (new AdminComponentIdProcessor()).cleanCssIdString("  42"));
    assertEquals("--id", (new AdminComponentIdProcessor()).cleanCssIdString("  id"));
    assertEquals("--org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("  org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("--org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("  org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("---a-zA-Z0-9---", (new AdminComponentIdProcessor()).cleanCssIdString(" [^a-zA-Z0-9-] "));
    assertEquals("---a-zA-Z0-9----a-zA-Z0-9--",
        (new AdminComponentIdProcessor()).cleanCssIdString(" [^a-zA-Z0-9-][^a-zA-Z0-9-]"));
    assertEquals("---a-zA-Z0-9---", (new AdminComponentIdProcessor()).cleanCssIdString(" [^a-zA-Z0-9-]-"));
    assertEquals("---a-zA-Z0-9--In", (new AdminComponentIdProcessor()).cleanCssIdString(" [^a-zA-Z0-9-]In"));
    assertEquals("---a-zA-Z0-9--42", (new AdminComponentIdProcessor()).cleanCssIdString(" [^a-zA-Z0-9-]42"));
    assertEquals("---a-zA-Z0-9--id", (new AdminComponentIdProcessor()).cleanCssIdString(" [^a-zA-Z0-9-]id"));
    assertEquals("---a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        (new AdminComponentIdProcessor())
            .cleanCssIdString(" [^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("---a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor())
            .cleanCssIdString(" [^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("---", (new AdminComponentIdProcessor()).cleanCssIdString(" - "));
    assertEquals("----a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString(" -[^a-zA-Z0-9-]"));
    assertEquals("---", (new AdminComponentIdProcessor()).cleanCssIdString(" --"));
    assertEquals("--In", (new AdminComponentIdProcessor()).cleanCssIdString(" -In"));
    assertEquals("--42", (new AdminComponentIdProcessor()).cleanCssIdString(" -42"));
    assertEquals("--id", (new AdminComponentIdProcessor()).cleanCssIdString(" -id"));
    assertEquals("--org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString(" -org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("--org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString(" -org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("-In-", (new AdminComponentIdProcessor()).cleanCssIdString(" In "));
    assertEquals("-In--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString(" In[^a-zA-Z0-9-]"));
    assertEquals("-In-", (new AdminComponentIdProcessor()).cleanCssIdString(" In-"));
    assertEquals("-InIn", (new AdminComponentIdProcessor()).cleanCssIdString(" InIn"));
    assertEquals("-In42", (new AdminComponentIdProcessor()).cleanCssIdString(" In42"));
    assertEquals("-Inid", (new AdminComponentIdProcessor()).cleanCssIdString(" Inid"));
    assertEquals("-Inorg-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString(" Inorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("-Inorg-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString(" Inorg.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("-42-", (new AdminComponentIdProcessor()).cleanCssIdString(" 42 "));
    assertEquals("-42--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString(" 42[^a-zA-Z0-9-]"));
    assertEquals("-42-", (new AdminComponentIdProcessor()).cleanCssIdString(" 42-"));
    assertEquals("-42In", (new AdminComponentIdProcessor()).cleanCssIdString(" 42In"));
    assertEquals("-4242", (new AdminComponentIdProcessor()).cleanCssIdString(" 4242"));
    assertEquals("-42id", (new AdminComponentIdProcessor()).cleanCssIdString(" 42id"));
    assertEquals("-42org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString(" 42org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("-42org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString(" 42org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("-id-", (new AdminComponentIdProcessor()).cleanCssIdString(" id "));
    assertEquals("-id--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString(" id[^a-zA-Z0-9-]"));
    assertEquals("-id-", (new AdminComponentIdProcessor()).cleanCssIdString(" id-"));
    assertEquals("-idIn", (new AdminComponentIdProcessor()).cleanCssIdString(" idIn"));
    assertEquals("-id42", (new AdminComponentIdProcessor()).cleanCssIdString(" id42"));
    assertEquals("-idid", (new AdminComponentIdProcessor()).cleanCssIdString(" idid"));
    assertEquals("-idorg-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString(" idorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("-idorg-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString(" idorg.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGrid-", (new AdminComponentIdProcessor())
        .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.component.ListGrid "));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGrid--a-zA-Z0-9--",
        (new AdminComponentIdProcessor())
            .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.component.ListGrid[^a-zA-Z0-9-]"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGrid-", (new AdminComponentIdProcessor())
        .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.component.ListGrid-"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGridIn", (new AdminComponentIdProcessor())
        .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.component.ListGridIn"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGrid42", (new AdminComponentIdProcessor())
        .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.component.ListGrid42"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGridid", (new AdminComponentIdProcessor())
        .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.component.ListGridid"));
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
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Field-",
        (new AdminComponentIdProcessor()).cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.entity.Field "));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Field--a-zA-Z0-9--",
        (new AdminComponentIdProcessor())
            .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.entity.Field[^a-zA-Z0-9-]"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Field-",
        (new AdminComponentIdProcessor()).cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.entity.Field-"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-FieldIn",
        (new AdminComponentIdProcessor()).cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.entity.FieldIn"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Field42",
        (new AdminComponentIdProcessor()).cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.entity.Field42"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Fieldid",
        (new AdminComponentIdProcessor()).cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.entity.Fieldid"));
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
    assertEquals("--a-zA-Z0-9----", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]  "));
    assertEquals("--a-zA-Z0-9-----a-zA-Z0-9--",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-] [^a-zA-Z0-9-]"));
    assertEquals("--a-zA-Z0-9----", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-] -"));
    assertEquals("--a-zA-Z0-9---In", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-] In"));
    assertEquals("--a-zA-Z0-9---42", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-] 42"));
    assertEquals("--a-zA-Z0-9---id", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-] id"));
    assertEquals("--a-zA-Z0-9---org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-] org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("--a-zA-Z0-9---org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-] org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("--a-zA-Z0-9----a-zA-Z0-9---",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-] "));
    assertEquals("--a-zA-Z0-9----a-zA-Z0-9----a-zA-Z0-9--",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-][^a-zA-Z0-9-]"));
    assertEquals("--a-zA-Z0-9----a-zA-Z0-9---",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-]-"));
    assertEquals("--a-zA-Z0-9----a-zA-Z0-9--In",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-]In"));
    assertEquals("--a-zA-Z0-9----a-zA-Z0-9--42",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-]42"));
    assertEquals("--a-zA-Z0-9----a-zA-Z0-9--id",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-]id"));
    assertEquals("--a-zA-Z0-9----a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("--a-zA-Z0-9----a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("--a-zA-Z0-9----", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]- "));
    assertEquals("--a-zA-Z0-9-----a-zA-Z0-9--",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]-[^a-zA-Z0-9-]"));
    assertEquals("--a-zA-Z0-9----", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]--"));
    assertEquals("--a-zA-Z0-9---In", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]-In"));
    assertEquals("--a-zA-Z0-9---42", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]-42"));
    assertEquals("--a-zA-Z0-9---id", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]-id"));
    assertEquals("--a-zA-Z0-9---org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]-org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("--a-zA-Z0-9---org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]-org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("--a-zA-Z0-9--In-", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]In "));
    assertEquals("--a-zA-Z0-9--In--a-zA-Z0-9--",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]In[^a-zA-Z0-9-]"));
    assertEquals("--a-zA-Z0-9--In-", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]In-"));
    assertEquals("--a-zA-Z0-9--InIn", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]InIn"));
    assertEquals("--a-zA-Z0-9--In42", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]In42"));
    assertEquals("--a-zA-Z0-9--Inid", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]Inid"));
    assertEquals("--a-zA-Z0-9--Inorg-broadleafcommerce-openadmin-web-form-component-ListGrid",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]Inorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("--a-zA-Z0-9--Inorg-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]Inorg.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("--a-zA-Z0-9--42-", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]42 "));
    assertEquals("--a-zA-Z0-9--42--a-zA-Z0-9--",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]42[^a-zA-Z0-9-]"));
    assertEquals("--a-zA-Z0-9--42-", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]42-"));
    assertEquals("--a-zA-Z0-9--42In", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]42In"));
    assertEquals("--a-zA-Z0-9--4242", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]4242"));
    assertEquals("--a-zA-Z0-9--42id", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]42id"));
    assertEquals("--a-zA-Z0-9--42org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]42org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("--a-zA-Z0-9--42org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]42org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("--a-zA-Z0-9--id-", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]id "));
    assertEquals("--a-zA-Z0-9--id--a-zA-Z0-9--",
        (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]id[^a-zA-Z0-9-]"));
    assertEquals("--a-zA-Z0-9--id-", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]id-"));
    assertEquals("--a-zA-Z0-9--idIn", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]idIn"));
    assertEquals("--a-zA-Z0-9--id42", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]id42"));
    assertEquals("--a-zA-Z0-9--idid", (new AdminComponentIdProcessor()).cleanCssIdString("[^a-zA-Z0-9-]idid"));
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
    assertEquals("--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field-",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field "));
    assertEquals("--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field--a-zA-Z0-9--",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field[^a-zA-Z0-9-]"));
    assertEquals("--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field-",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field-"));
    assertEquals("--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-FieldIn",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.FieldIn"));
    assertEquals("--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field42",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field42"));
    assertEquals("--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Fieldid",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Fieldid"));
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
    assertEquals("---", (new AdminComponentIdProcessor()).cleanCssIdString("-  "));
    assertEquals("----a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("- [^a-zA-Z0-9-]"));
    assertEquals("---", (new AdminComponentIdProcessor()).cleanCssIdString("- -"));
    assertEquals("--In", (new AdminComponentIdProcessor()).cleanCssIdString("- In"));
    assertEquals("--42", (new AdminComponentIdProcessor()).cleanCssIdString("- 42"));
    assertEquals("--id", (new AdminComponentIdProcessor()).cleanCssIdString("- id"));
    assertEquals("--org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("- org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("--org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("- org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("---a-zA-Z0-9---", (new AdminComponentIdProcessor()).cleanCssIdString("-[^a-zA-Z0-9-] "));
    assertEquals("---a-zA-Z0-9----a-zA-Z0-9--",
        (new AdminComponentIdProcessor()).cleanCssIdString("-[^a-zA-Z0-9-][^a-zA-Z0-9-]"));
    assertEquals("---a-zA-Z0-9---", (new AdminComponentIdProcessor()).cleanCssIdString("-[^a-zA-Z0-9-]-"));
    assertEquals("---a-zA-Z0-9--In", (new AdminComponentIdProcessor()).cleanCssIdString("-[^a-zA-Z0-9-]In"));
    assertEquals("---a-zA-Z0-9--42", (new AdminComponentIdProcessor()).cleanCssIdString("-[^a-zA-Z0-9-]42"));
    assertEquals("---a-zA-Z0-9--id", (new AdminComponentIdProcessor()).cleanCssIdString("-[^a-zA-Z0-9-]id"));
    assertEquals("---a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("-[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("---a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("-[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("---", (new AdminComponentIdProcessor()).cleanCssIdString("-- "));
    assertEquals("----a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("--[^a-zA-Z0-9-]"));
    assertEquals("--org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("--org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("--org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("--org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("-In-", (new AdminComponentIdProcessor()).cleanCssIdString("-In "));
    assertEquals("-In--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("-In[^a-zA-Z0-9-]"));
    assertEquals("-Inorg-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("-Inorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("-Inorg-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("-Inorg.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("-42-", (new AdminComponentIdProcessor()).cleanCssIdString("-42 "));
    assertEquals("-42--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("-42[^a-zA-Z0-9-]"));
    assertEquals("-42org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("-42org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("-42org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("-42org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("-id-", (new AdminComponentIdProcessor()).cleanCssIdString("-id "));
    assertEquals("-id--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("-id[^a-zA-Z0-9-]"));
    assertEquals("-idorg-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("-idorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("-idorg-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("-idorg.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGrid-", (new AdminComponentIdProcessor())
        .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.component.ListGrid "));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGrid--a-zA-Z0-9--",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.component.ListGrid[^a-zA-Z0-9-]"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGrid-", (new AdminComponentIdProcessor())
        .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.component.ListGrid-"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGridIn", (new AdminComponentIdProcessor())
        .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.component.ListGridIn"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGrid42", (new AdminComponentIdProcessor())
        .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.component.ListGrid42"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-component-ListGridid", (new AdminComponentIdProcessor())
        .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.component.ListGridid"));
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
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Field-",
        (new AdminComponentIdProcessor()).cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.entity.Field "));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Field--a-zA-Z0-9--",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.entity.Field[^a-zA-Z0-9-]"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Field-",
        (new AdminComponentIdProcessor()).cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.entity.Field-"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-FieldIn",
        (new AdminComponentIdProcessor()).cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.entity.FieldIn"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Field42",
        (new AdminComponentIdProcessor()).cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.entity.Field42"));
    assertEquals("-org-broadleafcommerce-openadmin-web-form-entity-Fieldid",
        (new AdminComponentIdProcessor()).cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.entity.Fieldid"));
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
    assertEquals("In--", (new AdminComponentIdProcessor()).cleanCssIdString("In  "));
    assertEquals("In---a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("In [^a-zA-Z0-9-]"));
    assertEquals("In--", (new AdminComponentIdProcessor()).cleanCssIdString("In -"));
    assertEquals("In-In", (new AdminComponentIdProcessor()).cleanCssIdString("In In"));
    assertEquals("In-42", (new AdminComponentIdProcessor()).cleanCssIdString("In 42"));
    assertEquals("In-id", (new AdminComponentIdProcessor()).cleanCssIdString("In id"));
    assertEquals("In-org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("In org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("In-org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("In org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("In--a-zA-Z0-9---", (new AdminComponentIdProcessor()).cleanCssIdString("In[^a-zA-Z0-9-] "));
    assertEquals("In--a-zA-Z0-9----a-zA-Z0-9--",
        (new AdminComponentIdProcessor()).cleanCssIdString("In[^a-zA-Z0-9-][^a-zA-Z0-9-]"));
    assertEquals("In--a-zA-Z0-9---", (new AdminComponentIdProcessor()).cleanCssIdString("In[^a-zA-Z0-9-]-"));
    assertEquals("In--a-zA-Z0-9--In", (new AdminComponentIdProcessor()).cleanCssIdString("In[^a-zA-Z0-9-]In"));
    assertEquals("In--a-zA-Z0-9--42", (new AdminComponentIdProcessor()).cleanCssIdString("In[^a-zA-Z0-9-]42"));
    assertEquals("In--a-zA-Z0-9--id", (new AdminComponentIdProcessor()).cleanCssIdString("In[^a-zA-Z0-9-]id"));
    assertEquals("In--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("In[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("In--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor())
            .cleanCssIdString("In[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("In--", (new AdminComponentIdProcessor()).cleanCssIdString("In- "));
    assertEquals("In---a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("In-[^a-zA-Z0-9-]"));
    assertEquals("In-org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("In-org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("In-org-broadleafcommerce-openadmin-web-form-entity-Field",
        (new AdminComponentIdProcessor()).cleanCssIdString("In-org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("InIn-", (new AdminComponentIdProcessor()).cleanCssIdString("InIn "));
    assertEquals("InIn--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("InIn[^a-zA-Z0-9-]"));
    assertEquals("InInorg-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("InInorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("InInorg-broadleafcommerce-openadmin-web-form-entity-Field", (new AdminComponentIdProcessor())
        .cleanCssIdString("InInorg.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("In42-", (new AdminComponentIdProcessor()).cleanCssIdString("In42 "));
    assertEquals("In42--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("In42[^a-zA-Z0-9-]"));
    assertEquals("In42org-broadleafcommerce-openadmin-web-form-component-ListGrid", (new AdminComponentIdProcessor())
        .cleanCssIdString("In42org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
    assertEquals("In42org-broadleafcommerce-openadmin-web-form-entity-Field", (new AdminComponentIdProcessor())
        .cleanCssIdString("In42org.broadleafcommerce.openadmin.web.form.entity.Field"));
    assertEquals("Inid-", (new AdminComponentIdProcessor()).cleanCssIdString("Inid "));
    assertEquals("Inid--a-zA-Z0-9--", (new AdminComponentIdProcessor()).cleanCssIdString("Inid[^a-zA-Z0-9-]"));
  }

  /**
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
}
