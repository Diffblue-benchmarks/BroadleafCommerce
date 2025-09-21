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
import java.util.Map;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.broadleafcommerce.presentation.model.BroadleafAttributeModifier;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class AdminComponentIdProcessorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminComponentIdProcessor#getName()}
   *   <li>{@link AdminComponentIdProcessor#getPrefix()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminComponentIdProcessor.getName()",
    "String AdminComponentIdProcessor.getPrefix()"
  })
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
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AdminComponentIdProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10002, new AdminComponentIdProcessor().getPrecedence());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
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
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-List-Grid-Type-Sub-Collection-Field-Name", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
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
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-listGrid--Sub-Collection-Field-Name", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
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
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---a-zA-Z0-9---Sub-Collection-Field-Name", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes4() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName())
        .thenReturn("org.broadleafcommerce.openadmin.web.form.component.ListGridAction");
    when(listGrid.getListGridType()).thenReturn("List Grid Type");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals(
        "listGrid-List-Grid-Type-org-broadleafcommerce-openadmin-web-form-component-ListGridAction",
        added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes5() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("not blank");
    when(listGrid.getListGridType())
        .thenReturn("org.broadleafcommerce.openadmin.web.form.component.ListGridAction");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals(
        "listGrid-org-broadleafcommerce-openadmin-web-form-component-ListGridAction-not-blank",
        added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes6() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn(" ");
    when(listGrid.getListGridType())
        .thenReturn("org.broadleafcommerce.openadmin.web.form.component.ListGridAction");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals(
        "listGrid-org-broadleafcommerce-openadmin-web-form-component-ListGridAction",
        added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes7() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType())
        .thenReturn("org.broadleafcommerce.openadmin.web.form.component.ListGridAction");
    when(listGrid.getSubCollectionFieldName()).thenReturn("Sub Collection Field Name");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals(
        "listGrid-org-broadleafcommerce-openadmin-web-form-component-ListGridAction-Sub-Collection-Field-Name",
        added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes8() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName())
        .thenReturn("org.broadleafcommerce.openadmin.web.form.entity.Field");
    when(listGrid.getListGridType()).thenReturn("List Grid Type");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals(
        "listGrid-List-Grid-Type-org-broadleafcommerce-openadmin-web-form-entity-Field",
        added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes9() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("not blank");
    when(listGrid.getListGridType())
        .thenReturn("org.broadleafcommerce.openadmin.web.form.entity.Field");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals(
        "listGrid-org-broadleafcommerce-openadmin-web-form-entity-Field-not-blank",
        added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes10() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn(" ");
    when(listGrid.getListGridType())
        .thenReturn("org.broadleafcommerce.openadmin.web.form.entity.Field");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-org-broadleafcommerce-openadmin-web-form-entity-Field", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes11() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType())
        .thenReturn("org.broadleafcommerce.openadmin.web.form.entity.Field");
    when(listGrid.getSubCollectionFieldName()).thenReturn("Sub Collection Field Name");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals(
        "listGrid-org-broadleafcommerce-openadmin-web-form-entity-Field-Sub-Collection-Field-Name",
        added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor).
   *   <li>Then return Added {@code id} is {@code field-null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_givenField_thenReturnAddedIdIsFieldNull() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(new Field());

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("field-null", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link ListGrid} {@link ListGrid#getListGridType()} return {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_givenListGridGetListGridTypeReturnDash() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("/");
    when(listGrid.getListGridType()).thenReturn("-");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid----", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link ListGrid} {@link ListGrid#getSubCollectionFieldName()} return {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_givenListGridGetSubCollectionFieldNameReturnDash() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("-");
    when(listGrid.getListGridType()).thenReturn(" ");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid----", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link ListGrid} {@link ListGrid#getSubCollectionFieldName()} return {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_givenListGridGetSubCollectionFieldNameReturnDash2() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("-");
    when(listGrid.getListGridType()).thenReturn("/");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid----", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor) ListGridTypeString is space.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_givenListGridListGridTypeStringIsSpace() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = new ListGrid();
    listGrid.setListGridTypeString(" ");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor) SubCollectionFieldName is space.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_givenListGridSubCollectionFieldNameIsSpace() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = new ListGrid();
    listGrid.setSubCollectionFieldName(" ");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-null", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor).
   *   <li>Then return Added {@code id} is {@code listGrid-null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_givenListGrid_thenReturnAddedIdIsListGridNull() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(new ListGrid());

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-null", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code Parse Expression}.
   *   <li>Then return Added {@code id} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_givenParseExpression_thenReturnAddedIdIsEmptyString() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGrid() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn(" ");
    when(listGrid.getListGridType()).thenReturn("/");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid----}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGrid2() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("/");
    when(listGrid.getListGridType()).thenReturn(" ");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid----", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGrid3() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("/");
    when(listGrid.getListGridType()).thenReturn("");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid----}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGrid4() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("/");
    when(listGrid.getListGridType()).thenReturn("/");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid----", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGrid42() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("42");
    when(listGrid.getListGridType()).thenReturn(" ");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---42", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-42---a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGrid42AZAZ09() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("[^a-zA-Z0-9-]");
    when(listGrid.getListGridType()).thenReturn("42");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-42---a-zA-Z0-9--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-42-not-blank}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGrid42NotBlank() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("not blank");
    when(listGrid.getListGridType()).thenReturn("42");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-42-not-blank", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-42-Sub-Collection-Field-Name}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
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
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-42-Sub-Collection-Field-Name", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGrid422() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("42");
    when(listGrid.getListGridType()).thenReturn("/");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---42", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-42--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGrid423() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("/");
    when(listGrid.getListGridType()).thenReturn("42");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-42--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ09() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn(" ");
    when(listGrid.getListGridType()).thenReturn("[^a-zA-Z0-9-]");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---a-zA-Z0-9--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---a-zA-Z0-9-----a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ09AZAZ09() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("[^a-zA-Z0-9-]");
    when(listGrid.getListGridType()).thenReturn("[^a-zA-Z0-9-]");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---a-zA-Z0-9-----a-zA-Z0-9--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---a-zA-Z0-9---foo}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ09Foo() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("foo");
    when(listGrid.getListGridType()).thenReturn("[^a-zA-Z0-9-]");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---a-zA-Z0-9---foo", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---a-zA-Z0-9---id}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ09Id() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("id");
    when(listGrid.getListGridType()).thenReturn("[^a-zA-Z0-9-]");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---a-zA-Z0-9---id", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---a-zA-Z0-9---listGrid-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ09ListGrid() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("listGrid-");
    when(listGrid.getListGridType()).thenReturn("[^a-zA-Z0-9-]");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---a-zA-Z0-9---listGrid-", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---a-zA-Z0-9---not-blank}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ09NotBlank() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("not blank");
    when(listGrid.getListGridType()).thenReturn("[^a-zA-Z0-9-]");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---a-zA-Z0-9---not-blank", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---a-zA-Z0-9----}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ092() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("-");
    when(listGrid.getListGridType()).thenReturn("[^a-zA-Z0-9-]");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---a-zA-Z0-9----", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-----a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ093() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("[^a-zA-Z0-9-]");
    when(listGrid.getListGridType()).thenReturn(" ");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-----a-zA-Z0-9--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-----a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ094() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("[^a-zA-Z0-9-]");
    when(listGrid.getListGridType()).thenReturn("-");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-----a-zA-Z0-9--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid----a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ095() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("[^a-zA-Z0-9-]");
    when(listGrid.getListGridType()).thenReturn("");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid----a-zA-Z0-9--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-----a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ096() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("[^a-zA-Z0-9-]");
    when(listGrid.getListGridType()).thenReturn("/");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-----a-zA-Z0-9--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---a-zA-Z0-9----}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ097() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("/");
    when(listGrid.getListGridType()).thenReturn("[^a-zA-Z0-9-]");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---a-zA-Z0-9----", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---a-zA-Z0-9---42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridAZAZ0942() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("42");
    when(listGrid.getListGridType()).thenReturn("[^a-zA-Z0-9-]");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---a-zA-Z0-9---42", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---foo}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridFoo() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("foo");
    when(listGrid.getListGridType()).thenReturn(" ");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---foo", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---foo}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridFoo2() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("foo");
    when(listGrid.getListGridType()).thenReturn("/");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---foo", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-foo--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridFoo3() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("/");
    when(listGrid.getListGridType()).thenReturn("foo");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-foo--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-foo---a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridFooAZAZ09() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("[^a-zA-Z0-9-]");
    when(listGrid.getListGridType()).thenReturn("foo");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-foo---a-zA-Z0-9--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-foo-not-blank}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridFooNotBlank() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("not blank");
    when(listGrid.getListGridType()).thenReturn("foo");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-foo-not-blank", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-foo-Sub-Collection-Field-Name}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
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
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-foo-Sub-Collection-Field-Name", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---id}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridId() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("id");
    when(listGrid.getListGridType()).thenReturn(" ");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---id", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---id}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridId2() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("id");
    when(listGrid.getListGridType()).thenReturn("/");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---id", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-id--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridId3() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("/");
    when(listGrid.getListGridType()).thenReturn("id");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-id--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-id---a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridIdAZAZ09() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("[^a-zA-Z0-9-]");
    when(listGrid.getListGridType()).thenReturn("id");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-id---a-zA-Z0-9--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-id-not-blank}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridIdNotBlank() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("not blank");
    when(listGrid.getListGridType()).thenReturn("id");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-id-not-blank", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-id-Sub-Collection-Field-Name}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
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
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-id-Sub-Collection-Field-Name", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---listGrid-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGrid() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("listGrid-");
    when(listGrid.getListGridType()).thenReturn(" ");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---listGrid-", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---listGrid-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGrid2() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("listGrid-");
    when(listGrid.getListGridType()).thenReturn("/");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---listGrid-", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-listGrid---}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGrid3() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("/");
    when(listGrid.getListGridType()).thenReturn("listGrid-");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-listGrid---", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-listGrid----a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridAZAZ09() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("[^a-zA-Z0-9-]");
    when(listGrid.getListGridType()).thenReturn("listGrid-");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-listGrid----a-zA-Z0-9--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-listGrid--not-blank}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridNotBlank() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("not blank");
    when(listGrid.getListGridType()).thenReturn("listGrid-");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-listGrid--not-blank", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-List-Grid-Type}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridType() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn(" ");
    when(listGrid.getListGridType()).thenReturn("List Grid Type");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-List-Grid-Type", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-List-Grid-Type--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridType2() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("-");
    when(listGrid.getListGridType()).thenReturn("List Grid Type");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-List-Grid-Type--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-List-Grid-Type--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridType3() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("/");
    when(listGrid.getListGridType()).thenReturn("List Grid Type");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-List-Grid-Type--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-List-Grid-Type-42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridType42() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("42");
    when(listGrid.getListGridType()).thenReturn("List Grid Type");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-List-Grid-Type-42", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-List-Grid-Type---a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridTypeAZAZ09() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("[^a-zA-Z0-9-]");
    when(listGrid.getListGridType()).thenReturn("List Grid Type");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-List-Grid-Type---a-zA-Z0-9--", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-List-Grid-Type-foo}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridTypeFoo() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("foo");
    when(listGrid.getListGridType()).thenReturn("List Grid Type");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-List-Grid-Type-foo", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-List-Grid-Type-id}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridTypeId() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("id");
    when(listGrid.getListGridType()).thenReturn("List Grid Type");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-List-Grid-Type-id", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-List-Grid-Type-listGrid-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridTypeListGrid() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("listGrid-");
    when(listGrid.getListGridType()).thenReturn("List Grid Type");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-List-Grid-Type-listGrid-", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-List-Grid-Type-none}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridTypeNone() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("none");
    when(listGrid.getListGridType()).thenReturn("List Grid Type");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-List-Grid-Type-none", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-List-Grid-Type-not-blank}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridListGridTypeNotBlank() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("not blank");
    when(listGrid.getListGridType()).thenReturn("List Grid Type");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-List-Grid-Type-not-blank", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-none-not-blank}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridNoneNotBlank() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("not blank");
    when(listGrid.getListGridType()).thenReturn("none");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-none-not-blank", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-none-Sub-Collection-Field-Name}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
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
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-none-Sub-Collection-Field-Name", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---not-blank}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridNotBlank() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("not blank");
    when(listGrid.getListGridType()).thenReturn(" ");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---not-blank", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---not-blank}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridNotBlank2() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("not blank");
    when(listGrid.getListGridType()).thenReturn("-");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---not-blank", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid--not-blank}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridNotBlank3() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("not blank");
    when(listGrid.getListGridType()).thenReturn("");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid--not-blank", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---not-blank}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridNotBlank4() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getSubCollectionFieldName()).thenReturn("not blank");
    when(listGrid.getListGridType()).thenReturn("/");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---not-blank", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid-null-not-blank}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridNullNotBlank() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = new ListGrid();
    listGrid.setSubCollectionFieldName("not blank");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid-null-not-blank", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---Sub-Collection-Field-Name}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
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
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---Sub-Collection-Field-Name", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---Sub-Collection-Field-Name}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
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
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---Sub-Collection-Field-Name", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid--Sub-Collection-Field-Name}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
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
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid--Sub-Collection-Field-Name", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Added {@code id} is {@code listGrid---Sub-Collection-Field-Name}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminComponentIdProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_thenReturnAddedIdIsListGridSubCollectionFieldName4() {
    // Arrange
    AdminComponentIdProcessor adminComponentIdProcessor = new AdminComponentIdProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getListGridType()).thenReturn("/");
    when(listGrid.getSubCollectionFieldName()).thenReturn("Sub Collection Field Name");

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(listGrid);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminComponentIdProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(listGrid).getListGridType();
    verify(listGrid, atLeast(1)).getSubCollectionFieldName();
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("listGrid---Sub-Collection-Field-Name", added.get("id"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString() {
    // Arrange, Act and Assert
    assertEquals(
        "org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString2() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString3() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString4() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString5() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString6() {
    // Arrange, Act and Assert
    assertEquals(
        "Inorg-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString("Inorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString7() {
    // Arrange, Act and Assert
    assertEquals(
        "42org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString("42org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString8() {
    // Arrange, Act and Assert
    assertEquals(
        "idorg-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString("idorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString9() {
    // Arrange, Act and Assert
    assertEquals(
        "org-broadleafcommerce-openadmin-web-form-component-ListGrid-",
        new AdminComponentIdProcessor()
            .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.component.ListGrid "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString10() {
    // Arrange, Act and Assert
    assertEquals(
        "org-broadleafcommerce-openadmin-web-form-component-ListGrid--a-zA-Z0-9--",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "org.broadleafcommerce.openadmin.web.form.component.ListGrid[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString11() {
    // Arrange, Act and Assert
    assertEquals(
        "org-broadleafcommerce-openadmin-web-form-component-ListGrid-",
        new AdminComponentIdProcessor()
            .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.component.ListGrid-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString12() {
    // Arrange, Act and Assert
    assertEquals(
        "org-broadleafcommerce-openadmin-web-form-component-ListGridIn",
        new AdminComponentIdProcessor()
            .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.component.ListGridIn"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString13() {
    // Arrange, Act and Assert
    assertEquals(
        "org-broadleafcommerce-openadmin-web-form-component-ListGrid42",
        new AdminComponentIdProcessor()
            .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.component.ListGrid42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString14() {
    // Arrange, Act and Assert
    assertEquals(
        "org-broadleafcommerce-openadmin-web-form-component-ListGridid",
        new AdminComponentIdProcessor()
            .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.component.ListGridid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString15() {
    // Arrange, Act and Assert
    assertEquals(
        "org-broadleafcommerce-openadmin-web-form-entity-Field--a-zA-Z0-9--",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "org.broadleafcommerce.openadmin.web.form.entity.Field[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString16() {
    // Arrange, Act and Assert
    assertEquals(
        "--org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString("  org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString17() {
    // Arrange, Act and Assert
    assertEquals(
        "---a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                " [^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString18() {
    // Arrange, Act and Assert
    assertEquals(
        "---a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                " [^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString19() {
    // Arrange, Act and Assert
    assertEquals(
        "-Inorg-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString(" Inorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString20() {
    // Arrange, Act and Assert
    assertEquals(
        "-42org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString(" 42org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString21() {
    // Arrange, Act and Assert
    assertEquals(
        "-idorg-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString(" idorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString22() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-component-ListGrid-",
        new AdminComponentIdProcessor()
            .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.component.ListGrid "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString23() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-component-ListGrid--a-zA-Z0-9--",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                " org.broadleafcommerce.openadmin.web.form.component.ListGrid[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString24() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-component-ListGridIn",
        new AdminComponentIdProcessor()
            .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.component.ListGridIn"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString25() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-component-ListGrid42",
        new AdminComponentIdProcessor()
            .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.component.ListGrid42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString26() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-component-ListGridid",
        new AdminComponentIdProcessor()
            .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.component.ListGridid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString27() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-entity-Field--a-zA-Z0-9--",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                " org.broadleafcommerce.openadmin.web.form.entity.Field[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString28() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9---org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-] org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString29() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9----a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-][^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString30() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9----a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-][^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString31() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9---org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-]-org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString32() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--Inorg-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-]Inorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString33() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--Inorg-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-]Inorg.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString34() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--42org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-]42org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString35() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--42org-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-]42org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString36() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--idorg-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-]idorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString37() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--idorg-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-]idorg.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString38() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGrid-",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGrid "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString39() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGrid--a-zA-Z0-9--",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGrid[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString40() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGrid-",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGrid-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString41() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGridIn",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGridIn"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString42() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGrid42",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGrid42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString43() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGridid",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGridid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString44() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field-",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString45() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field--a-zA-Z0-9--",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString46() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-FieldIn",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.FieldIn"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString47() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field42",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString48() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Fieldid",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Fieldid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString49() {
    // Arrange, Act and Assert
    assertEquals(
        "---a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "-[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString50() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-component-ListGrid--a-zA-Z0-9--",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "-org.broadleafcommerce.openadmin.web.form.component.ListGrid[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString51() {
    // Arrange, Act and Assert
    assertEquals(
        "In--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "In[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString52() {
    // Arrange, Act and Assert
    assertEquals(
        "In--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "In[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString53() {
    // Arrange, Act and Assert
    assertEquals(
        "InInorg-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString("InInorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString54() {
    // Arrange, Act and Assert
    assertEquals(
        "InInorg-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString("InInorg.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString55() {
    // Arrange, Act and Assert
    assertEquals(
        "In42org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString("In42org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString56() {
    // Arrange, Act and Assert
    assertEquals(
        "In42org-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString("In42org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>Then return {@code 42org-broadleafcommerce-openadmin-web-form-entity-Field}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturn42orgBroadleafcommerceOpenadminWebFormEntityField() {
    // Arrange, Act and Assert
    assertEquals(
        "42org-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString("42org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>Then return {@code -42org-broadleafcommerce-openadmin-web-form-entity-Field}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturn42orgBroadleafcommerceOpenadminWebFormEntityField2() {
    // Arrange, Act and Assert
    assertEquals(
        "-42org-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString(" 42org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>Then return {@code idorg-broadleafcommerce-openadmin-web-form-entity-Field}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnIdorgBroadleafcommerceOpenadminWebFormEntityField() {
    // Arrange, Act and Assert
    assertEquals(
        "idorg-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString("idorg.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>Then return {@code -idorg-broadleafcommerce-openadmin-web-form-entity-Field}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnIdorgBroadleafcommerceOpenadminWebFormEntityField2() {
    // Arrange, Act and Assert
    assertEquals(
        "-idorg-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString(" idorg.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>Then return {@code Inorg-broadleafcommerce-openadmin-web-form-entity-Field}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnInorgBroadleafcommerceOpenadminWebFormEntityField() {
    // Arrange, Act and Assert
    assertEquals(
        "Inorg-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString("Inorg.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>Then return {@code -Inorg-broadleafcommerce-openadmin-web-form-entity-Field}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnInorgBroadleafcommerceOpenadminWebFormEntityField2() {
    // Arrange, Act and Assert
    assertEquals(
        "-Inorg-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString(" Inorg.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>Then return {@code org-broadleafcommerce-openadmin-web-form-entity-Field}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityField() {
    // Arrange, Act and Assert
    assertEquals(
        "org-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>Then return {@code -org-broadleafcommerce-openadmin-web-form-entity-Field}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityField2() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>Then return {@code -org-broadleafcommerce-openadmin-web-form-entity-Field}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityField3() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>Then return {@code org-broadleafcommerce-openadmin-web-form-entity-Field-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityField4() {
    // Arrange, Act and Assert
    assertEquals(
        "org-broadleafcommerce-openadmin-web-form-entity-Field-",
        new AdminComponentIdProcessor()
            .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.entity.Field "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>Then return {@code org-broadleafcommerce-openadmin-web-form-entity-Field-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityField5() {
    // Arrange, Act and Assert
    assertEquals(
        "org-broadleafcommerce-openadmin-web-form-entity-Field-",
        new AdminComponentIdProcessor()
            .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.entity.Field-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>Then return {@code --org-broadleafcommerce-openadmin-web-form-entity-Field}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityField6() {
    // Arrange, Act and Assert
    assertEquals(
        "--org-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString("  org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>Then return {@code -org-broadleafcommerce-openadmin-web-form-entity-Field-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityField7() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-entity-Field-",
        new AdminComponentIdProcessor()
            .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.entity.Field "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>Then return {@code org-broadleafcommerce-openadmin-web-form-entity-Field42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityField42() {
    // Arrange, Act and Assert
    assertEquals(
        "org-broadleafcommerce-openadmin-web-form-entity-Field42",
        new AdminComponentIdProcessor()
            .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.entity.Field42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>Then return {@code -org-broadleafcommerce-openadmin-web-form-entity-Field42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityField422() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-entity-Field42",
        new AdminComponentIdProcessor()
            .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.entity.Field42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>Then return {@code org-broadleafcommerce-openadmin-web-form-entity-FieldIn}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityFieldIn() {
    // Arrange, Act and Assert
    assertEquals(
        "org-broadleafcommerce-openadmin-web-form-entity-FieldIn",
        new AdminComponentIdProcessor()
            .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.entity.FieldIn"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>Then return {@code -org-broadleafcommerce-openadmin-web-form-entity-FieldIn}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityFieldIn2() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-entity-FieldIn",
        new AdminComponentIdProcessor()
            .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.entity.FieldIn"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>Then return {@code org-broadleafcommerce-openadmin-web-form-entity-Fieldid}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityFieldid() {
    // Arrange, Act and Assert
    assertEquals(
        "org-broadleafcommerce-openadmin-web-form-entity-Fieldid",
        new AdminComponentIdProcessor()
            .cleanCssIdString("org.broadleafcommerce.openadmin.web.form.entity.Fieldid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>Then return {@code -org-broadleafcommerce-openadmin-web-form-entity-Fieldid}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_thenReturnOrgBroadleafcommerceOpenadminWebFormEntityFieldid2() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-entity-Fieldid",
        new AdminComponentIdProcessor()
            .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.entity.Fieldid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code 42[^a-zA-Z0-9-]}.
   *   <li>Then return {@code 42--a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_when42AZAZ09_thenReturn42AZAZ09() {
    // Arrange, Act and Assert
    assertEquals(
        "42--a-zA-Z0-9--", new AdminComponentIdProcessor().cleanCssIdString("42[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code 42[^a-zA-Z0-9-]}.
   *   <li>Then return {@code -42--a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_when42AZAZ09_thenReturn42AZAZ092() {
    // Arrange, Act and Assert
    assertEquals(
        "-42--a-zA-Z0-9--", new AdminComponentIdProcessor().cleanCssIdString(" 42[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -42[^a-zA-Z0-9-]}.
   *   <li>Then return {@code -42--a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_when42AZAZ09_thenReturn42AZAZ093() {
    // Arrange, Act and Assert
    assertEquals(
        "-42--a-zA-Z0-9--", new AdminComponentIdProcessor().cleanCssIdString("-42[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code 42In}.
   *   <li>Then return {@code -42In}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_when42In_thenReturn42In() {
    // Arrange, Act and Assert
    assertEquals("-42In", new AdminComponentIdProcessor().cleanCssIdString(" 42In"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code -42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("-42", new AdminComponentIdProcessor().cleanCssIdString(" 42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_when42_thenReturn422() {
    // Arrange, Act and Assert
    assertEquals("42-", new AdminComponentIdProcessor().cleanCssIdString("42 "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code --42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_when42_thenReturn423() {
    // Arrange, Act and Assert
    assertEquals("--42", new AdminComponentIdProcessor().cleanCssIdString("  42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -42}.
   *   <li>Then return {@code --42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_when42_thenReturn424() {
    // Arrange, Act and Assert
    assertEquals("--42", new AdminComponentIdProcessor().cleanCssIdString(" -42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code -42-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_when42_thenReturn425() {
    // Arrange, Act and Assert
    assertEquals("-42-", new AdminComponentIdProcessor().cleanCssIdString(" 42 "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code 42-}.
   *   <li>Then return {@code -42-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_when42_thenReturn426() {
    // Arrange, Act and Assert
    assertEquals("-42-", new AdminComponentIdProcessor().cleanCssIdString(" 42-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code - 42}.
   *   <li>Then return {@code --42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_when42_thenReturn427() {
    // Arrange, Act and Assert
    assertEquals("--42", new AdminComponentIdProcessor().cleanCssIdString("- 42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -42}.
   *   <li>Then return {@code -42-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_when42_thenReturn428() {
    // Arrange, Act and Assert
    assertEquals("-42-", new AdminComponentIdProcessor().cleanCssIdString("-42 "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code 42id}.
   *   <li>Then return {@code -42id}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_when42id_thenReturn42id() {
    // Arrange, Act and Assert
    assertEquals("-42id", new AdminComponentIdProcessor().cleanCssIdString(" 42id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -42ListGrid}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_when42orgBroadleafcommerceOpenadminWebFormComponentListGrid() {
    // Arrange, Act and Assert
    assertEquals(
        "-42org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString("-42org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -42Field}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_when42orgBroadleafcommerceOpenadminWebFormEntityField() {
    // Arrange, Act and Assert
    assertEquals(
        "-42org-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString("-42org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   *   <li>Then return {@code -4242}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_when4242_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("-4242", new AdminComponentIdProcessor().cleanCssIdString(" 4242"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAString_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "org-broadleafcommerce-openadmin-web-form-component-ListGridorg-broadleafcommerce-openadmin-web-form"
            + "-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "org.broadleafcommerce.openadmin.web.form.component.ListGridorg.broadleafcommerce.openadmin.web.form"
                    + ".component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAString_thenReturnAString2() {
    // Arrange, Act and Assert
    assertEquals(
        "org-broadleafcommerce-openadmin-web-form-component-ListGridorg-broadleafcommerce-openadmin-web-form"
            + "-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "org.broadleafcommerce.openadmin.web.form.component.ListGridorg.broadleafcommerce.openadmin.web.form"
                    + ".entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAString_thenReturnAString3() {
    // Arrange, Act and Assert
    assertEquals(
        "org-broadleafcommerce-openadmin-web-form-entity-Fieldorg-broadleafcommerce-openadmin-web-form-component"
            + "-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "org.broadleafcommerce.openadmin.web.form.entity.Fieldorg.broadleafcommerce.openadmin.web.form.component"
                    + ".ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAString_thenReturnAString4() {
    // Arrange, Act and Assert
    assertEquals(
        "org-broadleafcommerce-openadmin-web-form-entity-Fieldorg-broadleafcommerce-openadmin-web-form"
            + "-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "org.broadleafcommerce.openadmin.web.form.entity.Fieldorg.broadleafcommerce.openadmin.web.form"
                    + ".entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAString_thenReturnAString5() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-component-ListGridorg-broadleafcommerce-openadmin-web-form"
            + "-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                " org.broadleafcommerce.openadmin.web.form.component.ListGridorg.broadleafcommerce.openadmin.web.form"
                    + ".component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAString_thenReturnAString6() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-component-ListGridorg-broadleafcommerce-openadmin-web-form"
            + "-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                " org.broadleafcommerce.openadmin.web.form.component.ListGridorg.broadleafcommerce.openadmin.web.form"
                    + ".entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAString_thenReturnAString7() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-entity-Fieldorg-broadleafcommerce-openadmin-web-form-component"
            + "-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                " org.broadleafcommerce.openadmin.web.form.entity.Fieldorg.broadleafcommerce.openadmin.web.form.component"
                    + ".ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAString_thenReturnAString8() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-entity-Fieldorg-broadleafcommerce-openadmin-web-form"
            + "-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                " org.broadleafcommerce.openadmin.web.form.entity.Fieldorg.broadleafcommerce.openadmin.web.form"
                    + ".entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAString_thenReturnAString9() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGridorg-broadleafcommerce-openadmin"
            + "-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGridorg.broadleafcommerce.openadmin"
                    + ".web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAString_thenReturnAString10() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-component-ListGridorg-broadleafcommerce-openadmin"
            + "-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.component.ListGridorg.broadleafcommerce.openadmin"
                    + ".web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAString_thenReturnAString11() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Fieldorg-broadleafcommerce-openadmin-web"
            + "-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Fieldorg.broadleafcommerce.openadmin.web"
                    + ".form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAString_thenReturnAString12() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Fieldorg-broadleafcommerce-openadmin-web"
            + "-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Fieldorg.broadleafcommerce.openadmin.web"
                    + ".form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAString_thenReturnAString13() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-component-ListGridorg-broadleafcommerce-openadmin-web-form"
            + "-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "-org.broadleafcommerce.openadmin.web.form.component.ListGridorg.broadleafcommerce.openadmin.web.form"
                    + ".component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAString_thenReturnAString14() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-component-ListGridorg-broadleafcommerce-openadmin-web-form"
            + "-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "-org.broadleafcommerce.openadmin.web.form.component.ListGridorg.broadleafcommerce.openadmin.web.form"
                    + ".entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAString_thenReturnAString15() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-entity-Fieldorg-broadleafcommerce-openadmin-web-form-component"
            + "-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "-org.broadleafcommerce.openadmin.web.form.entity.Fieldorg.broadleafcommerce.openadmin.web.form.component"
                    + ".ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAString_thenReturnAString16() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-entity-Fieldorg-broadleafcommerce-openadmin-web-form"
            + "-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "-org.broadleafcommerce.openadmin.web.form.entity.Fieldorg.broadleafcommerce.openadmin.web.form"
                    + ".entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-][^a-zA-Z0-9-][^a-zA-Z0-9-]}.
   *   <li>Then return {@code --a-zA-Z0-9----a-zA-Z0-9----a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09AZAZ09AZAZ09_thenReturnAZAZ09AZAZ09AZAZ09() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9----a-zA-Z0-9----a-zA-Z0-9--",
        new AdminComponentIdProcessor()
            .cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-][^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-][^a-zA-Z0-9-]id}.
   *   <li>Then return {@code --a-zA-Z0-9----a-zA-Z0-9--id}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09AZAZ09Id_thenReturnAZAZ09AZAZ09Id() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9----a-zA-Z0-9--id",
        new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-]id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-][^a-zA-Z0-9-]In}.
   *   <li>Then return {@code --a-zA-Z0-9----a-zA-Z0-9--In}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09AZAZ09In_thenReturnAZAZ09AZAZ09In() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9----a-zA-Z0-9--In",
        new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-]In"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-][^a-zA-Z0-9-]}.
   *   <li>Then return {@code --a-zA-Z0-9----a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09AZAZ09_thenReturnAZAZ09AZAZ09() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9----a-zA-Z0-9--",
        new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-][^a-zA-Z0-9-]}.
   *   <li>Then return {@code ---a-zA-Z0-9----a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09AZAZ09_thenReturnAZAZ09AZAZ092() {
    // Arrange, Act and Assert
    assertEquals(
        "---a-zA-Z0-9----a-zA-Z0-9--",
        new AdminComponentIdProcessor().cleanCssIdString(" [^a-zA-Z0-9-][^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-] [^a-zA-Z0-9-]}.
   *   <li>Then return {@code --a-zA-Z0-9-----a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09AZAZ09_thenReturnAZAZ09AZAZ093() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9-----a-zA-Z0-9--",
        new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-] [^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-][^a-zA-Z0-9-]}.
   *   <li>Then return {@code --a-zA-Z0-9----a-zA-Z0-9---}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09AZAZ09_thenReturnAZAZ09AZAZ094() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9----a-zA-Z0-9---",
        new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-] "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-][^a-zA-Z0-9-]-}.
   *   <li>Then return {@code --a-zA-Z0-9----a-zA-Z0-9---}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09AZAZ09_thenReturnAZAZ09AZAZ095() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9----a-zA-Z0-9---",
        new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-]-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]-[^a-zA-Z0-9-]}.
   *   <li>Then return {@code --a-zA-Z0-9-----a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09AZAZ09_thenReturnAZAZ09AZAZ096() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9-----a-zA-Z0-9--",
        new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]-[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -[^a-zA-Z0-9-][^a-zA-Z0-9-]}.
   *   <li>Then return {@code ---a-zA-Z0-9----a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09AZAZ09_thenReturnAZAZ09AZAZ097() {
    // Arrange, Act and Assert
    assertEquals(
        "---a-zA-Z0-9----a-zA-Z0-9--",
        new AdminComponentIdProcessor().cleanCssIdString("-[^a-zA-Z0-9-][^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-][^a-zA-Z0-9-]42}.
   *   <li>Then return {@code --a-zA-Z0-9----a-zA-Z0-9--42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09AZAZ0942_thenReturnAZAZ09AZAZ0942() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9----a-zA-Z0-9--42",
        new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-][^a-zA-Z0-9-]42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]id42}.
   *   <li>Then return {@code --a-zA-Z0-9--id42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09Id42_thenReturnAZAZ09Id42() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--id42", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]id42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]id[^a-zA-Z0-9-]}.
   *   <li>Then return {@code --a-zA-Z0-9--id--a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09IdAZAZ09_thenReturnAZAZ09IdAZAZ09() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--id--a-zA-Z0-9--",
        new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]id[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]idIn}.
   *   <li>Then return {@code --a-zA-Z0-9--idIn}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09IdIn_thenReturnAZAZ09IdIn() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--idIn", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]idIn"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]id}.
   *   <li>Then return {@code --a-zA-Z0-9--id}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09Id_thenReturnAZAZ09Id() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--id", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]id}.
   *   <li>Then return {@code ---a-zA-Z0-9--id}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09Id_thenReturnAZAZ09Id2() {
    // Arrange, Act and Assert
    assertEquals(
        "---a-zA-Z0-9--id", new AdminComponentIdProcessor().cleanCssIdString(" [^a-zA-Z0-9-]id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-] id}.
   *   <li>Then return {@code --a-zA-Z0-9---id}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09Id_thenReturnAZAZ09Id3() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9---id", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-] id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]-id}.
   *   <li>Then return {@code --a-zA-Z0-9---id}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09Id_thenReturnAZAZ09Id4() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9---id", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]-id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]id}.
   *   <li>Then return {@code --a-zA-Z0-9--id-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09Id_thenReturnAZAZ09Id5() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--id-", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]id "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]id-}.
   *   <li>Then return {@code --a-zA-Z0-9--id-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09Id_thenReturnAZAZ09Id6() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--id-", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]id-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -[^a-zA-Z0-9-]id}.
   *   <li>Then return {@code ---a-zA-Z0-9--id}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09Id_thenReturnAZAZ09Id7() {
    // Arrange, Act and Assert
    assertEquals(
        "---a-zA-Z0-9--id", new AdminComponentIdProcessor().cleanCssIdString("-[^a-zA-Z0-9-]id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]idid}.
   *   <li>Then return {@code --a-zA-Z0-9--idid}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09Idid_thenReturnAZAZ09Idid() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--idid", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]idid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]In42}.
   *   <li>Then return {@code --a-zA-Z0-9--In42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09In42_thenReturnAZAZ09In42() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--In42", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]In42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]In[^a-zA-Z0-9-]}.
   *   <li>Then return {@code --a-zA-Z0-9--In--a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09InAZAZ09_thenReturnAZAZ09InAZAZ09() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--In--a-zA-Z0-9--",
        new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]In[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]InIn}.
   *   <li>Then return {@code --a-zA-Z0-9--InIn}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09InIn_thenReturnAZAZ09InIn() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--InIn", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]InIn"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]In}.
   *   <li>Then return {@code --a-zA-Z0-9--In}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09In_thenReturnAZAZ09In() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--In", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]In"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]In}.
   *   <li>Then return {@code ---a-zA-Z0-9--In}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09In_thenReturnAZAZ09In2() {
    // Arrange, Act and Assert
    assertEquals(
        "---a-zA-Z0-9--In", new AdminComponentIdProcessor().cleanCssIdString(" [^a-zA-Z0-9-]In"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-] In}.
   *   <li>Then return {@code --a-zA-Z0-9---In}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09In_thenReturnAZAZ09In3() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9---In", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-] In"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]-In}.
   *   <li>Then return {@code --a-zA-Z0-9---In}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09In_thenReturnAZAZ09In4() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9---In", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]-In"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]In}.
   *   <li>Then return {@code --a-zA-Z0-9--In-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09In_thenReturnAZAZ09In5() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--In-", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]In "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]In-}.
   *   <li>Then return {@code --a-zA-Z0-9--In-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09In_thenReturnAZAZ09In6() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--In-", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]In-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -[^a-zA-Z0-9-]In}.
   *   <li>Then return {@code ---a-zA-Z0-9--In}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09In_thenReturnAZAZ09In7() {
    // Arrange, Act and Assert
    assertEquals(
        "---a-zA-Z0-9--In", new AdminComponentIdProcessor().cleanCssIdString("-[^a-zA-Z0-9-]In"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]Inid}.
   *   <li>Then return {@code --a-zA-Z0-9--Inid}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09Inid_thenReturnAZAZ09Inid() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--Inid", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]Inid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-] Field}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09OrgBroadleafcommerceOpenadminWebFormEntityField() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9---org-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-] org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]-Field}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09OrgBroadleafcommerceOpenadminWebFormEntityField2() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9---org-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-]-org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]Field-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09OrgBroadleafcommerceOpenadminWebFormEntityField3() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field-",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -[^a-zA-Z0-9-]Field}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09OrgBroadleafcommerceOpenadminWebFormEntityField4() {
    // Arrange, Act and Assert
    assertEquals(
        "---a-zA-Z0-9--org-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "-[^a-zA-Z0-9-]org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]}.
   *   <li>Then return {@code --a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ09() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]}.
   *   <li>Then return {@code ---a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ092() {
    // Arrange, Act and Assert
    assertEquals(
        "---a-zA-Z0-9--", new AdminComponentIdProcessor().cleanCssIdString(" [^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]}.
   *   <li>Then return {@code --a-zA-Z0-9---}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ093() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9---", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-] "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]-}.
   *   <li>Then return {@code --a-zA-Z0-9---}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ094() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9---", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -[^a-zA-Z0-9-]}.
   *   <li>Then return {@code ---a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ095() {
    // Arrange, Act and Assert
    assertEquals(
        "---a-zA-Z0-9--", new AdminComponentIdProcessor().cleanCssIdString("-[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]}.
   *   <li>Then return {@code ----a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ096() {
    // Arrange, Act and Assert
    assertEquals(
        "----a-zA-Z0-9--", new AdminComponentIdProcessor().cleanCssIdString("  [^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]}.
   *   <li>Then return {@code ---a-zA-Z0-9---}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ097() {
    // Arrange, Act and Assert
    assertEquals(
        "---a-zA-Z0-9---", new AdminComponentIdProcessor().cleanCssIdString(" [^a-zA-Z0-9-] "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]-}.
   *   <li>Then return {@code ---a-zA-Z0-9---}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ098() {
    // Arrange, Act and Assert
    assertEquals(
        "---a-zA-Z0-9---", new AdminComponentIdProcessor().cleanCssIdString(" [^a-zA-Z0-9-]-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -[^a-zA-Z0-9-]}.
   *   <li>Then return {@code ----a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ099() {
    // Arrange, Act and Assert
    assertEquals(
        "----a-zA-Z0-9--", new AdminComponentIdProcessor().cleanCssIdString(" -[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]}.
   *   <li>Then return {@code --a-zA-Z0-9----}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ0910() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9----", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]  "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-] -}.
   *   <li>Then return {@code --a-zA-Z0-9----}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ0911() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9----", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-] -"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]-}.
   *   <li>Then return {@code --a-zA-Z0-9----}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ0912() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9----", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]- "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]--}.
   *   <li>Then return {@code --a-zA-Z0-9----}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ0913() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9----", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]--"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code - [^a-zA-Z0-9-]}.
   *   <li>Then return {@code ----a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ0914() {
    // Arrange, Act and Assert
    assertEquals(
        "----a-zA-Z0-9--", new AdminComponentIdProcessor().cleanCssIdString("- [^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -[^a-zA-Z0-9-]}.
   *   <li>Then return {@code ---a-zA-Z0-9---}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ0915() {
    // Arrange, Act and Assert
    assertEquals(
        "---a-zA-Z0-9---", new AdminComponentIdProcessor().cleanCssIdString("-[^a-zA-Z0-9-] "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -[^a-zA-Z0-9-]-}.
   *   <li>Then return {@code ---a-zA-Z0-9---}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ0916() {
    // Arrange, Act and Assert
    assertEquals(
        "---a-zA-Z0-9---", new AdminComponentIdProcessor().cleanCssIdString("-[^a-zA-Z0-9-]-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code --[^a-zA-Z0-9-]}.
   *   <li>Then return {@code ----a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ09_thenReturnAZAZ0917() {
    // Arrange, Act and Assert
    assertEquals(
        "----a-zA-Z0-9--", new AdminComponentIdProcessor().cleanCssIdString("--[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]42[^a-zA-Z0-9-]}.
   *   <li>Then return {@code --a-zA-Z0-9--42--a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ0942AZAZ09_thenReturnAZAZ0942AZAZ09() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--42--a-zA-Z0-9--",
        new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]42[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]42In}.
   *   <li>Then return {@code --a-zA-Z0-9--42In}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ0942In_thenReturnAZAZ0942In() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--42In", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]42In"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]42}.
   *   <li>Then return {@code --a-zA-Z0-9--42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ0942_thenReturnAZAZ0942() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--42", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]42}.
   *   <li>Then return {@code ---a-zA-Z0-9--42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ0942_thenReturnAZAZ09422() {
    // Arrange, Act and Assert
    assertEquals(
        "---a-zA-Z0-9--42", new AdminComponentIdProcessor().cleanCssIdString(" [^a-zA-Z0-9-]42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-] 42}.
   *   <li>Then return {@code --a-zA-Z0-9---42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ0942_thenReturnAZAZ09423() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9---42", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-] 42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]-42}.
   *   <li>Then return {@code --a-zA-Z0-9---42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ0942_thenReturnAZAZ09424() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9---42", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]-42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]42}.
   *   <li>Then return {@code --a-zA-Z0-9--42-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ0942_thenReturnAZAZ09425() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--42-", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]42 "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]42-}.
   *   <li>Then return {@code --a-zA-Z0-9--42-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ0942_thenReturnAZAZ09426() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--42-", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]42-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -[^a-zA-Z0-9-]42}.
   *   <li>Then return {@code ---a-zA-Z0-9--42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ0942_thenReturnAZAZ09427() {
    // Arrange, Act and Assert
    assertEquals(
        "---a-zA-Z0-9--42", new AdminComponentIdProcessor().cleanCssIdString("-[^a-zA-Z0-9-]42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]42id}.
   *   <li>Then return {@code --a-zA-Z0-9--42id}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ0942id_thenReturnAZAZ0942id() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--42id", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]42id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code [^a-zA-Z0-9-]4242}.
   *   <li>Then return {@code --a-zA-Z0-9--4242}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenAZAZ094242_thenReturnAZAZ094242() {
    // Arrange, Act and Assert
    assertEquals(
        "--a-zA-Z0-9--4242", new AdminComponentIdProcessor().cleanCssIdString("[^a-zA-Z0-9-]4242"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code --}.
   *   <li>Then return {@code ---}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenDashDash_thenReturnDashDashDash() {
    // Arrange, Act and Assert
    assertEquals("---", new AdminComponentIdProcessor().cleanCssIdString(" --"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code --}.
   *   <li>Then return {@code ---}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenDashDash_thenReturnDashDashDash2() {
    // Arrange, Act and Assert
    assertEquals("---", new AdminComponentIdProcessor().cleanCssIdString("-- "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code - -}.
   *   <li>Then return {@code ---}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenDashSpaceDash_thenReturnDashDashDash() {
    // Arrange, Act and Assert
    assertEquals("---", new AdminComponentIdProcessor().cleanCssIdString("- -"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then return {@code --}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenDash_thenReturnDashDash() {
    // Arrange, Act and Assert
    assertEquals("--", new AdminComponentIdProcessor().cleanCssIdString(" -"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then return {@code --}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenDash_thenReturnDashDash2() {
    // Arrange, Act and Assert
    assertEquals("--", new AdminComponentIdProcessor().cleanCssIdString("- "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then return {@code ---}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenDash_thenReturnDashDashDash() {
    // Arrange, Act and Assert
    assertEquals("---", new AdminComponentIdProcessor().cleanCssIdString("  -"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then return {@code ---}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenDash_thenReturnDashDashDash2() {
    // Arrange, Act and Assert
    assertEquals("---", new AdminComponentIdProcessor().cleanCssIdString(" - "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then return {@code ---}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenDash_thenReturnDashDashDash3() {
    // Arrange, Act and Assert
    assertEquals("---", new AdminComponentIdProcessor().cleanCssIdString("-  "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code id42}.
   *   <li>Then return {@code -id42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenId42_thenReturnId42() {
    // Arrange, Act and Assert
    assertEquals("-id42", new AdminComponentIdProcessor().cleanCssIdString(" id42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code id[^a-zA-Z0-9-]}.
   *   <li>Then return {@code id--a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIdAZAZ09_thenReturnIdAZAZ09() {
    // Arrange, Act and Assert
    assertEquals(
        "id--a-zA-Z0-9--", new AdminComponentIdProcessor().cleanCssIdString("id[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code id[^a-zA-Z0-9-]}.
   *   <li>Then return {@code -id--a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIdAZAZ09_thenReturnIdAZAZ092() {
    // Arrange, Act and Assert
    assertEquals(
        "-id--a-zA-Z0-9--", new AdminComponentIdProcessor().cleanCssIdString(" id[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -id[^a-zA-Z0-9-]}.
   *   <li>Then return {@code -id--a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIdAZAZ09_thenReturnIdAZAZ093() {
    // Arrange, Act and Assert
    assertEquals(
        "-id--a-zA-Z0-9--", new AdminComponentIdProcessor().cleanCssIdString("-id[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code idIn}.
   *   <li>Then return {@code -idIn}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIdIn_thenReturnIdIn() {
    // Arrange, Act and Assert
    assertEquals("-idIn", new AdminComponentIdProcessor().cleanCssIdString(" idIn"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code id}.
   *   <li>Then return {@code -id}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenId_thenReturnId() {
    // Arrange, Act and Assert
    assertEquals("-id", new AdminComponentIdProcessor().cleanCssIdString(" id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code id}.
   *   <li>Then return {@code id-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenId_thenReturnId2() {
    // Arrange, Act and Assert
    assertEquals("id-", new AdminComponentIdProcessor().cleanCssIdString("id "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code id}.
   *   <li>Then return {@code --id}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenId_thenReturnId3() {
    // Arrange, Act and Assert
    assertEquals("--id", new AdminComponentIdProcessor().cleanCssIdString("  id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -id}.
   *   <li>Then return {@code --id}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenId_thenReturnId4() {
    // Arrange, Act and Assert
    assertEquals("--id", new AdminComponentIdProcessor().cleanCssIdString(" -id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code id}.
   *   <li>Then return {@code -id-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenId_thenReturnId5() {
    // Arrange, Act and Assert
    assertEquals("-id-", new AdminComponentIdProcessor().cleanCssIdString(" id "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code id-}.
   *   <li>Then return {@code -id-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenId_thenReturnId6() {
    // Arrange, Act and Assert
    assertEquals("-id-", new AdminComponentIdProcessor().cleanCssIdString(" id-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code - id}.
   *   <li>Then return {@code --id}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenId_thenReturnId7() {
    // Arrange, Act and Assert
    assertEquals("--id", new AdminComponentIdProcessor().cleanCssIdString("- id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -id}.
   *   <li>Then return {@code -id-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenId_thenReturnId8() {
    // Arrange, Act and Assert
    assertEquals("-id-", new AdminComponentIdProcessor().cleanCssIdString("-id "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code idid}.
   *   <li>Then return {@code -idid}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIdid_thenReturnIdid() {
    // Arrange, Act and Assert
    assertEquals("-idid", new AdminComponentIdProcessor().cleanCssIdString(" idid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -idListGrid}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIdorgBroadleafcommerceOpenadminWebFormComponentListGrid() {
    // Arrange, Act and Assert
    assertEquals(
        "-idorg-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString("-idorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -idField}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIdorgBroadleafcommerceOpenadminWebFormEntityField() {
    // Arrange, Act and Assert
    assertEquals(
        "-idorg-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString("-idorg.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In42[^a-zA-Z0-9-]}.
   *   <li>Then return {@code In42--a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIn42AZAZ09_thenReturnIn42AZAZ09() {
    // Arrange, Act and Assert
    assertEquals(
        "In42--a-zA-Z0-9--", new AdminComponentIdProcessor().cleanCssIdString("In42[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In42}.
   *   <li>Then return {@code -In42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIn42_thenReturnIn42() {
    // Arrange, Act and Assert
    assertEquals("-In42", new AdminComponentIdProcessor().cleanCssIdString(" In42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In 42}.
   *   <li>Then return {@code In-42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIn42_thenReturnIn422() {
    // Arrange, Act and Assert
    assertEquals("In-42", new AdminComponentIdProcessor().cleanCssIdString("In 42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In42}.
   *   <li>Then return {@code In42-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIn42_thenReturnIn423() {
    // Arrange, Act and Assert
    assertEquals("In42-", new AdminComponentIdProcessor().cleanCssIdString("In42 "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In[^a-zA-Z0-9-][^a-zA-Z0-9-]}.
   *   <li>Then return {@code In--a-zA-Z0-9----a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInAZAZ09AZAZ09_thenReturnInAZAZ09AZAZ09() {
    // Arrange, Act and Assert
    assertEquals(
        "In--a-zA-Z0-9----a-zA-Z0-9--",
        new AdminComponentIdProcessor().cleanCssIdString("In[^a-zA-Z0-9-][^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In[^a-zA-Z0-9-]id}.
   *   <li>Then return {@code In--a-zA-Z0-9--id}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInAZAZ09Id_thenReturnInAZAZ09Id() {
    // Arrange, Act and Assert
    assertEquals(
        "In--a-zA-Z0-9--id", new AdminComponentIdProcessor().cleanCssIdString("In[^a-zA-Z0-9-]id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In[^a-zA-Z0-9-]In}.
   *   <li>Then return {@code In--a-zA-Z0-9--In}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInAZAZ09In_thenReturnInAZAZ09In() {
    // Arrange, Act and Assert
    assertEquals(
        "In--a-zA-Z0-9--In", new AdminComponentIdProcessor().cleanCssIdString("In[^a-zA-Z0-9-]In"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In[^a-zA-Z0-9-]}.
   *   <li>Then return {@code In--a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInAZAZ09_thenReturnInAZAZ09() {
    // Arrange, Act and Assert
    assertEquals(
        "In--a-zA-Z0-9--", new AdminComponentIdProcessor().cleanCssIdString("In[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In[^a-zA-Z0-9-]}.
   *   <li>Then return {@code -In--a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInAZAZ09_thenReturnInAZAZ092() {
    // Arrange, Act and Assert
    assertEquals(
        "-In--a-zA-Z0-9--", new AdminComponentIdProcessor().cleanCssIdString(" In[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -In[^a-zA-Z0-9-]}.
   *   <li>Then return {@code -In--a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInAZAZ09_thenReturnInAZAZ093() {
    // Arrange, Act and Assert
    assertEquals(
        "-In--a-zA-Z0-9--", new AdminComponentIdProcessor().cleanCssIdString("-In[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In [^a-zA-Z0-9-]}.
   *   <li>Then return {@code In---a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInAZAZ09_thenReturnInAZAZ094() {
    // Arrange, Act and Assert
    assertEquals(
        "In---a-zA-Z0-9--", new AdminComponentIdProcessor().cleanCssIdString("In [^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In[^a-zA-Z0-9-]}.
   *   <li>Then return {@code In--a-zA-Z0-9---}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInAZAZ09_thenReturnInAZAZ095() {
    // Arrange, Act and Assert
    assertEquals(
        "In--a-zA-Z0-9---", new AdminComponentIdProcessor().cleanCssIdString("In[^a-zA-Z0-9-] "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In[^a-zA-Z0-9-]-}.
   *   <li>Then return {@code In--a-zA-Z0-9---}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInAZAZ09_thenReturnInAZAZ096() {
    // Arrange, Act and Assert
    assertEquals(
        "In--a-zA-Z0-9---", new AdminComponentIdProcessor().cleanCssIdString("In[^a-zA-Z0-9-]-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In-[^a-zA-Z0-9-]}.
   *   <li>Then return {@code In---a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInAZAZ09_thenReturnInAZAZ097() {
    // Arrange, Act and Assert
    assertEquals(
        "In---a-zA-Z0-9--", new AdminComponentIdProcessor().cleanCssIdString("In-[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In[^a-zA-Z0-9-]42}.
   *   <li>Then return {@code In--a-zA-Z0-9--42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInAZAZ0942_thenReturnInAZAZ0942() {
    // Arrange, Act and Assert
    assertEquals(
        "In--a-zA-Z0-9--42", new AdminComponentIdProcessor().cleanCssIdString("In[^a-zA-Z0-9-]42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In id}.
   *   <li>Then return {@code In-id}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInId_thenReturnInId() {
    // Arrange, Act and Assert
    assertEquals("In-id", new AdminComponentIdProcessor().cleanCssIdString("In id"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code InIn[^a-zA-Z0-9-]}.
   *   <li>Then return {@code InIn--a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInInAZAZ09_thenReturnInInAZAZ09() {
    // Arrange, Act and Assert
    assertEquals(
        "InIn--a-zA-Z0-9--", new AdminComponentIdProcessor().cleanCssIdString("InIn[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code InIn}.
   *   <li>Then return {@code -InIn}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInIn_thenReturnInIn() {
    // Arrange, Act and Assert
    assertEquals("-InIn", new AdminComponentIdProcessor().cleanCssIdString(" InIn"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In In}.
   *   <li>Then return {@code In-In}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInIn_thenReturnInIn2() {
    // Arrange, Act and Assert
    assertEquals("In-In", new AdminComponentIdProcessor().cleanCssIdString("In In"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code InIn}.
   *   <li>Then return {@code InIn-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInIn_thenReturnInIn3() {
    // Arrange, Act and Assert
    assertEquals("InIn-", new AdminComponentIdProcessor().cleanCssIdString("InIn "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In ListGrid}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInOrgBroadleafcommerceOpenadminWebFormComponentListGrid() {
    // Arrange, Act and Assert
    assertEquals(
        "In-org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString("In org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In-ListGrid}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInOrgBroadleafcommerceOpenadminWebFormComponentListGrid2() {
    // Arrange, Act and Assert
    assertEquals(
        "In-org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString("In-org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In Field}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInOrgBroadleafcommerceOpenadminWebFormEntityField() {
    // Arrange, Act and Assert
    assertEquals(
        "In-org-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString("In org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In-Field}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInOrgBroadleafcommerceOpenadminWebFormEntityField2() {
    // Arrange, Act and Assert
    assertEquals(
        "In-org-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString("In-org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In}.
   *   <li>Then return {@code In}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIn_thenReturnIn() {
    // Arrange, Act and Assert
    assertEquals("In", new AdminComponentIdProcessor().cleanCssIdString("In"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In}.
   *   <li>Then return {@code -In}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIn_thenReturnIn2() {
    // Arrange, Act and Assert
    assertEquals("-In", new AdminComponentIdProcessor().cleanCssIdString(" In"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In}.
   *   <li>Then return {@code In-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIn_thenReturnIn3() {
    // Arrange, Act and Assert
    assertEquals("In-", new AdminComponentIdProcessor().cleanCssIdString("In "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In}.
   *   <li>Then return {@code --In}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIn_thenReturnIn4() {
    // Arrange, Act and Assert
    assertEquals("--In", new AdminComponentIdProcessor().cleanCssIdString("  In"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -In}.
   *   <li>Then return {@code --In}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIn_thenReturnIn5() {
    // Arrange, Act and Assert
    assertEquals("--In", new AdminComponentIdProcessor().cleanCssIdString(" -In"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In}.
   *   <li>Then return {@code -In-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIn_thenReturnIn6() {
    // Arrange, Act and Assert
    assertEquals("-In-", new AdminComponentIdProcessor().cleanCssIdString(" In "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In-}.
   *   <li>Then return {@code -In-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIn_thenReturnIn7() {
    // Arrange, Act and Assert
    assertEquals("-In-", new AdminComponentIdProcessor().cleanCssIdString(" In-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code - In}.
   *   <li>Then return {@code --In}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIn_thenReturnIn8() {
    // Arrange, Act and Assert
    assertEquals("--In", new AdminComponentIdProcessor().cleanCssIdString("- In"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -In}.
   *   <li>Then return {@code -In-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIn_thenReturnIn9() {
    // Arrange, Act and Assert
    assertEquals("-In-", new AdminComponentIdProcessor().cleanCssIdString("-In "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In}.
   *   <li>Then return {@code In--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIn_thenReturnIn10() {
    // Arrange, Act and Assert
    assertEquals("In--", new AdminComponentIdProcessor().cleanCssIdString("In  "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In -}.
   *   <li>Then return {@code In--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIn_thenReturnIn11() {
    // Arrange, Act and Assert
    assertEquals("In--", new AdminComponentIdProcessor().cleanCssIdString("In -"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code In-}.
   *   <li>Then return {@code In--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenIn_thenReturnIn12() {
    // Arrange, Act and Assert
    assertEquals("In--", new AdminComponentIdProcessor().cleanCssIdString("In- "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code Inid[^a-zA-Z0-9-]}.
   *   <li>Then return {@code Inid--a-zA-Z0-9--}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInidAZAZ09_thenReturnInidAZAZ09() {
    // Arrange, Act and Assert
    assertEquals(
        "Inid--a-zA-Z0-9--", new AdminComponentIdProcessor().cleanCssIdString("Inid[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code Inid}.
   *   <li>Then return {@code -Inid}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInid_thenReturnInid() {
    // Arrange, Act and Assert
    assertEquals("-Inid", new AdminComponentIdProcessor().cleanCssIdString(" Inid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code Inid}.
   *   <li>Then return {@code Inid-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInid_thenReturnInid2() {
    // Arrange, Act and Assert
    assertEquals("Inid-", new AdminComponentIdProcessor().cleanCssIdString("Inid "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -InListGrid}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInorgBroadleafcommerceOpenadminWebFormComponentListGrid() {
    // Arrange, Act and Assert
    assertEquals(
        "-Inorg-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString("-Inorg.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -InField}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenInorgBroadleafcommerceOpenadminWebFormEntityField() {
    // Arrange, Act and Assert
    assertEquals(
        "-Inorg-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString("-Inorg.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -ListGrid}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormComponentListGrid() {
    // Arrange, Act and Assert
    assertEquals(
        "--org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString(" -org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code ListGrid-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormComponentListGrid2() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-component-ListGrid-",
        new AdminComponentIdProcessor()
            .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.component.ListGrid-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code - ListGrid}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormComponentListGrid3() {
    // Arrange, Act and Assert
    assertEquals(
        "--org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString("- org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code --ListGrid}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormComponentListGrid4() {
    // Arrange, Act and Assert
    assertEquals(
        "--org-broadleafcommerce-openadmin-web-form-component-ListGrid",
        new AdminComponentIdProcessor()
            .cleanCssIdString("--org.broadleafcommerce.openadmin.web.form.component.ListGrid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -ListGrid}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormComponentListGrid5() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-component-ListGrid-",
        new AdminComponentIdProcessor()
            .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.component.ListGrid "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -ListGrid-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormComponentListGrid6() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-component-ListGrid-",
        new AdminComponentIdProcessor()
            .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.component.ListGrid-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -ListGrid42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormComponentListGrid42() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-component-ListGrid42",
        new AdminComponentIdProcessor()
            .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.component.ListGrid42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -ListGridIn}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormComponentListGridIn() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-component-ListGridIn",
        new AdminComponentIdProcessor()
            .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.component.ListGridIn"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -ListGridid}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormComponentListGridid() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-component-ListGridid",
        new AdminComponentIdProcessor()
            .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.component.ListGridid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -Field}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormEntityField() {
    // Arrange, Act and Assert
    assertEquals(
        "--org-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString(" -org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code Field-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormEntityField2() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-entity-Field-",
        new AdminComponentIdProcessor()
            .cleanCssIdString(" org.broadleafcommerce.openadmin.web.form.entity.Field-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code - Field}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormEntityField3() {
    // Arrange, Act and Assert
    assertEquals(
        "--org-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString("- org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code --Field}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormEntityField4() {
    // Arrange, Act and Assert
    assertEquals(
        "--org-broadleafcommerce-openadmin-web-form-entity-Field",
        new AdminComponentIdProcessor()
            .cleanCssIdString("--org.broadleafcommerce.openadmin.web.form.entity.Field"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -Field}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormEntityField5() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-entity-Field-",
        new AdminComponentIdProcessor()
            .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.entity.Field "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -Field-}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormEntityField6() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-entity-Field-",
        new AdminComponentIdProcessor()
            .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.entity.Field-"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -Field42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormEntityField42() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-entity-Field42",
        new AdminComponentIdProcessor()
            .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.entity.Field42"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -Field[^a-zA-Z0-9-]}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormEntityFieldAZAZ09() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-entity-Field--a-zA-Z0-9--",
        new AdminComponentIdProcessor()
            .cleanCssIdString(
                "-org.broadleafcommerce.openadmin.web.form.entity.Field[^a-zA-Z0-9-]"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -FieldIn}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormEntityFieldIn() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-entity-FieldIn",
        new AdminComponentIdProcessor()
            .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.entity.FieldIn"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When {@code -Fieldid}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenOrgBroadleafcommerceOpenadminWebFormEntityFieldid() {
    // Arrange, Act and Assert
    assertEquals(
        "-org-broadleafcommerce-openadmin-web-form-entity-Fieldid",
        new AdminComponentIdProcessor()
            .cleanCssIdString("-org.broadleafcommerce.openadmin.web.form.entity.Fieldid"));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When space space space.
   *   <li>Then return {@code ---}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenSpaceSpaceSpace_thenReturnDashDashDash() {
    // Arrange, Act and Assert
    assertEquals("---", new AdminComponentIdProcessor().cleanCssIdString("   "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When space space.
   *   <li>Then return {@code --}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenSpaceSpace_thenReturnDashDash() {
    // Arrange, Act and Assert
    assertEquals("--", new AdminComponentIdProcessor().cleanCssIdString("  "));
  }

  /**
   * Test {@link AdminComponentIdProcessor#cleanCssIdString(String)}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then return {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link AdminComponentIdProcessor#cleanCssIdString(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminComponentIdProcessor.cleanCssIdString(String)"})
  public void testCleanCssIdString_whenSpace_thenReturnDash() {
    // Arrange, Act and Assert
    assertEquals("-", new AdminComponentIdProcessor().cleanCssIdString(" "));
  }
}
