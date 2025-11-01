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
package org.broadleafcommerce.openadmin.web.form.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {Field.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FieldDiffblueTest {
  @Autowired
  private Field field;

  /**
   * Method under test: {@link Field#withName(String)}
   */
  @Test
  public void testWithName() {
    // Arrange and Act
    Field actualWithNameResult = field.withName("Name");

    // Assert
    assertEquals("Name", field.getName());
    assertEquals("Name", field.getTranslationFieldName());
    assertSame(field, actualWithNameResult);
  }

  /**
   * Method under test: {@link Field#withFriendlyName(String)}
   */
  @Test
  public void testWithFriendlyName() {
    // Arrange and Act
    Field actualWithFriendlyNameResult = field.withFriendlyName("Friendly Name");

    // Assert
    assertEquals("Friendly Name", field.getFriendlyName());
    assertSame(field, actualWithFriendlyNameResult);
  }

  /**
   * Method under test: {@link Field#withFieldType(String)}
   */
  @Test
  public void testWithFieldType() {
    // Arrange and Act
    Field actualWithFieldTypeResult = field.withFieldType("Field Type");

    // Assert
    assertEquals("Field Type", field.getFieldType());
    assertSame(field, actualWithFieldTypeResult);
  }

  /**
   * Method under test: {@link Field#withDisplayType(String)}
   */
  @Test
  public void testWithDisplayType() {
    // Arrange and Act
    Field actualWithDisplayTypeResult = field.withDisplayType("Display Type");

    // Assert
    assertEquals("Display Type", field.getDisplayType());
    assertSame(field, actualWithDisplayTypeResult);
  }

  /**
   * Method under test: {@link Field#withFieldComponentRenderer(String)}
   */
  @Test
  public void testWithFieldComponentRenderer() {
    // Arrange and Act
    Field actualWithFieldComponentRendererResult = field.withFieldComponentRenderer("Field Component Renderer");

    // Assert
    assertEquals("Field Component Renderer", field.getFieldComponentRenderer());
    assertSame(field, actualWithFieldComponentRendererResult);
  }

  /**
   * Method under test: {@link Field#withGridFieldComponentRenderer(String)}
   */
  @Test
  public void testWithGridFieldComponentRenderer() {
    // Arrange and Act
    Field actualWithGridFieldComponentRendererResult = field
        .withGridFieldComponentRenderer("Grid Field Component Renderer");

    // Assert
    assertEquals("Grid Field Component Renderer", field.getGridFieldComponentRenderer());
    assertSame(field, actualWithGridFieldComponentRendererResult);
  }

  /**
   * Method under test: {@link Field#withValue(String)}
   */
  @Test
  public void testWithValue() {
    // Arrange and Act
    Field actualWithValueResult = field.withValue("42");

    // Assert
    assertEquals("42", field.getDisplayValue());
    assertEquals("42", field.getValue());
    assertEquals("null/42", field.getEntityViewPath());
    assertSame(field, actualWithValueResult);
  }

  /**
   * Method under test: {@link Field#withDisplayValue(String)}
   */
  @Test
  public void testWithDisplayValue() {
    // Arrange and Act
    Field actualWithDisplayValueResult = field.withDisplayValue("42");

    // Assert
    assertEquals("42", field.getDisplayValue());
    assertEquals("42", field.getRawDisplayValue());
    assertSame(field, actualWithDisplayValueResult);
  }

  /**
   * Method under test: {@link Field#withForeignKeyDisplayValueProperty(String)}
   */
  @Test
  public void testWithForeignKeyDisplayValueProperty() {
    // Arrange and Act
    Field actualWithForeignKeyDisplayValuePropertyResult = field.withForeignKeyDisplayValueProperty("42");

    // Assert
    assertEquals("42", field.getForeignKeyDisplayValueProperty());
    assertSame(field, actualWithForeignKeyDisplayValuePropertyResult);
  }

  /**
   * Method under test: {@link Field#withForeignKeyClass(String)}
   */
  @Test
  public void testWithForeignKeyClass() {
    // Arrange and Act
    Field actualWithForeignKeyClassResult = field.withForeignKeyClass("Foreign Key Class");

    // Assert
    assertEquals("Foreign Key Class", field.getForeignKeyClass());
    assertEquals("Foreign Key Class/null", field.getEntityViewPath());
    assertSame(field, actualWithForeignKeyClassResult);
  }

  /**
   * Method under test: {@link Field#withForeignKeySectionPath(String)}
   */
  @Test
  public void testWithForeignKeySectionPath() {
    // Arrange and Act
    Field actualWithForeignKeySectionPathResult = field.withForeignKeySectionPath("Foreign Key Section Path");

    // Assert
    assertEquals("Foreign Key Section Path", field.getForeignKeySectionPath());
    assertSame(field, actualWithForeignKeySectionPathResult);
  }

  /**
   * Method under test: {@link Field#withOwningEntityClass(String)}
   */
  @Test
  public void testWithOwningEntityClass() {
    // Arrange and Act
    Field actualWithOwningEntityClassResult = field.withOwningEntityClass("Owning Entity Class");

    // Assert
    assertEquals("Owning Entity Class", field.getOwningEntityClass());
    assertSame(field, actualWithOwningEntityClassResult);
  }

  /**
   * Method under test: {@link Field#withIdOverride(String)}
   */
  @Test
  public void testWithIdOverride() {
    // Arrange and Act
    Field actualWithIdOverrideResult = field.withIdOverride("Id Override");

    // Assert
    assertEquals("Id Override", field.getIdOverride());
    assertSame(field, actualWithIdOverrideResult);
  }

  /**
   * Method under test: {@link Field#withOrder(Integer)}
   */
  @Test
  public void testWithOrder() {
    // Arrange
    Field field = new Field();

    // Act
    Field actualWithOrderResult = field.withOrder(1);

    // Assert
    assertEquals(1, field.getOrder().intValue());
    assertSame(field, actualWithOrderResult);
  }

  /**
   * Method under test: {@link Field#withAlternateOrdering(Boolean)}
   */
  @Test
  public void testWithAlternateOrdering() {
    // Arrange
    Field field = new Field();

    // Act
    Field actualWithAlternateOrderingResult = field.withAlternateOrdering(true);

    // Assert
    assertTrue(field.getAlternateOrdering());
    assertTrue(field.isAlternateOrdering);
    assertSame(field, actualWithAlternateOrderingResult);
  }

  /**
   * Method under test: {@link Field#withRequired(Boolean)}
   */
  @Test
  public void testWithRequired() {
    // Arrange
    Field field = new Field();

    // Act
    Field actualWithRequiredResult = field.withRequired(true);

    // Assert
    assertTrue(field.getRequired());
    assertTrue(field.required);
    assertSame(field, actualWithRequiredResult);
  }

  /**
   * Method under test: {@link Field#withColumnWidth(String)}
   */
  @Test
  public void testWithColumnWidth() {
    // Arrange and Act
    Field actualWithColumnWidthResult = field.withColumnWidth("Column Width");

    // Assert
    assertEquals("Column Width", field.getColumnWidth());
    assertSame(field, actualWithColumnWidthResult);
  }

  /**
   * Method under test: {@link Field#withColumnWidth(String)}
   */
  @Test
  public void testWithColumnWidth2() {
    // Arrange and Act
    Field actualWithColumnWidthResult = field.withColumnWidth("*");

    // Assert
    assertNull(field.getColumnWidth());
    assertSame(field, actualWithColumnWidthResult);
  }

  /**
   * Method under test: {@link Field#withReadOnly(Boolean)}
   */
  @Test
  public void testWithReadOnly() {
    // Arrange
    Field field = new Field();

    // Act
    Field actualWithReadOnlyResult = field.withReadOnly(true);

    // Assert
    assertTrue(field.getReadOnly());
    assertTrue(field.isReadOnly);
    assertSame(field, actualWithReadOnlyResult);
  }

  /**
   * Method under test: {@link Field#withDisabled(Boolean)}
   */
  @Test
  public void testWithDisabled() {
    // Arrange
    Field field = new Field();

    // Act
    Field actualWithDisabledResult = field.withDisabled(true);

    // Assert
    assertTrue(field.getDisabled());
    assertTrue(field.isDisabled);
    assertSame(field, actualWithDisabledResult);
  }

  /**
   * Method under test: {@link Field#withTranslatable(Boolean)}
   */
  @Test
  public void testWithTranslatable() {
    // Arrange
    Field field = new Field();

    // Act
    Field actualWithTranslatableResult = field.withTranslatable(true);

    // Assert
    assertTrue(field.getTranslatable());
    assertTrue(field.isTranslatable);
    assertSame(field, actualWithTranslatableResult);
  }

  /**
   * Method under test: {@link Field#withMainEntityLink(Boolean)}
   */
  @Test
  public void testWithMainEntityLink() {
    // Arrange
    Field field = new Field();

    // Act
    Field actualWithMainEntityLinkResult = field.withMainEntityLink(true);

    // Assert
    assertTrue(field.getMainEntityLink());
    assertTrue(field.isMainEntityLink);
    assertSame(field, actualWithMainEntityLinkResult);
  }

  /**
   * Method under test: {@link Field#withFilterSortDisabled(Boolean)}
   */
  @Test
  public void testWithFilterSortDisabled() {
    // Arrange
    Field field = new Field();

    // Act
    Field actualWithFilterSortDisabledResult = field.withFilterSortDisabled(true);

    // Assert
    assertTrue(field.getFilterSortDisabled());
    assertTrue(field.isFilterSortDisabled);
    assertSame(field, actualWithFilterSortDisabledResult);
  }

  /**
   * Method under test: {@link Field#withDerived(Boolean)}
   */
  @Test
  public void testWithDerived() {
    // Arrange
    Field field = new Field();

    // Act
    Field actualWithDerivedResult = field.withDerived(true);

    // Assert
    assertTrue(field.getIsDerived());
    assertTrue(field.isDerived);
    assertSame(field, actualWithDerivedResult);
  }

  /**
   * Method under test: {@link Field#withLargeEntry(Boolean)}
   */
  @Test
  public void testWithLargeEntry() {
    // Arrange
    Field field = new Field();

    // Act
    Field actualWithLargeEntryResult = field.withLargeEntry(true);

    // Assert
    assertTrue(field.getIsLargeEntry());
    assertTrue(field.isLargeEntry);
    assertSame(field, actualWithLargeEntryResult);
  }

  /**
   * Method under test: {@link Field#withHint(String)}
   */
  @Test
  public void testWithHint() {
    // Arrange and Act
    Field actualWithHintResult = field.withHint("Hint");

    // Assert
    assertEquals("Hint", field.getHint());
    assertEquals("Hint", field.hint);
    assertSame(field, actualWithHintResult);
  }

  /**
   * Method under test: {@link Field#withHelp(String)}
   */
  @Test
  public void testWithHelp() {
    // Arrange and Act
    Field actualWithHelpResult = field.withHelp("Help");

    // Assert
    assertEquals("Help", field.getHelp());
    assertEquals("Help", field.help);
    assertSame(field, actualWithHelpResult);
  }

  /**
   * Method under test: {@link Field#withTooltip(String)}
   */
  @Test
  public void testWithTooltip() {
    // Arrange, Act and Assert
    assertSame(field, field.withTooltip("127.0.0.1"));
  }

  /**
   * Method under test: {@link Field#withAttribute(String, Object)}
   */
  @Test
  public void testWithAttribute() {
    // Arrange, Act and Assert
    assertSame(field, field.withAttribute("Key", "Value"));
  }

  /**
   * Method under test: {@link Field#withTypeaheadEnabled(Boolean)}
   */
  @Test
  public void testWithTypeaheadEnabled() {
    // Arrange
    Field field = new Field();

    // Act
    Field actualWithTypeaheadEnabledResult = field.withTypeaheadEnabled(true);

    // Assert
    assertTrue(field.getIsTypeaheadEnabled());
    assertTrue(field.isTypeaheadEnabled);
    assertSame(field, actualWithTypeaheadEnabledResult);
  }

  /**
   * Method under test: {@link Field#withTranslationFieldName(String)}
   */
  @Test
  public void testWithTranslationFieldName() {
    // Arrange and Act
    Field actualWithTranslationFieldNameResult = field.withTranslationFieldName("Translation Field Name");

    // Assert
    assertEquals("Translation Field Name", field.getTranslationFieldName());
    assertEquals("Translation Field Name", field.translationFieldName);
    assertSame(field, actualWithTranslationFieldNameResult);
  }

  /**
   * Method under test: {@link Field#withCanLinkToExternalEntity(Boolean)}
   */
  @Test
  public void testWithCanLinkToExternalEntity() {
    // Arrange
    Field field = new Field();

    // Act and Assert
    assertSame(field, field.withCanLinkToExternalEntity(true));
  }

  /**
   * Method under test: {@link Field#withAssociatedFieldName(String)}
   */
  @Test
  public void testWithAssociatedFieldName() {
    // Arrange and Act
    Field actualWithAssociatedFieldNameResult = field.withAssociatedFieldName("Associated Field Name");

    // Assert
    assertEquals("Associated Field Name", field.getAssociatedFieldName());
    assertSame(field, actualWithAssociatedFieldNameResult);
  }

  /**
   * Method under test: {@link Field#getIsVisible()}
   */
  @Test
  public void testGetIsVisible() {
    // Arrange, Act and Assert
    assertTrue((new Field()).getIsVisible());
  }

  /**
   * Method under test: {@link Field#getIsVisible()}
   */
  @Test
  public void testGetIsVisible2() {
    // Arrange
    Field field = new Field();
    field.setFieldType("Field Type");

    // Act and Assert
    assertTrue(field.getIsVisible());
  }

  /**
   * Method under test: {@link Field#getIsVisible()}
   */
  @Test
  public void testGetIsVisible3() {
    // Arrange
    Field field = new Field();
    field.setIsVisible(true);

    // Act and Assert
    assertTrue(field.getIsVisible());
  }

  /**
   * Method under test: {@link Field#getIsVisible()}
   */
  @Test
  public void testGetIsVisible4() {
    // Arrange
    Field field = new Field();
    field.setIsVisible(false);

    // Act and Assert
    assertFalse(field.getIsVisible());
  }

  /**
   * Method under test: {@link Field#setColumnWidth(String)}
   */
  @Test
  public void testSetColumnWidth() {
    // Arrange and Act
    field.setColumnWidth("Column Width");

    // Assert
    assertEquals("Column Width", field.getColumnWidth());
  }

  /**
   * Method under test: {@link Field#setColumnWidth(String)}
   */
  @Test
  public void testSetColumnWidth2() {
    // Arrange and Act
    field.setColumnWidth("*");

    // Assert
    assertNull(field.getColumnWidth());
  }

  /**
   * Method under test: {@link Field#getDisplayValue()}
   */
  @Test
  public void testGetDisplayValue() {
    // Arrange, Act and Assert
    assertNull((new Field()).getDisplayValue());
  }

  /**
   * Method under test: {@link Field#getDisplayValue()}
   */
  @Test
  public void testGetDisplayValue2() {
    // Arrange
    Field field = new Field();
    field.setDisplayValue("foo");

    // Act and Assert
    assertEquals("foo", field.getDisplayValue());
  }

  /**
   * Method under test: {@link Field#getEntityViewPath()}
   */
  @Test
  public void testGetEntityViewPath() {
    // Arrange, Act and Assert
    assertEquals("null/null", (new Field()).getEntityViewPath());
  }

  /**
   * Method under test: {@link Field#getReadOnly()}
   */
  @Test
  public void testGetReadOnly() {
    // Arrange, Act and Assert
    assertFalse((new Field()).getReadOnly());
  }

  /**
   * Method under test: {@link Field#getReadOnly()}
   */
  @Test
  public void testGetReadOnly2() {
    // Arrange
    Field field = new Field();
    field.setReadOnly(true);

    // Act and Assert
    assertTrue(field.getReadOnly());
  }

  /**
   * Method under test: {@link Field#getDisabled()}
   */
  @Test
  public void testGetDisabled() {
    // Arrange, Act and Assert
    assertFalse((new Field()).getDisabled());
  }

  /**
   * Method under test: {@link Field#getDisabled()}
   */
  @Test
  public void testGetDisabled2() {
    // Arrange
    Field field = new Field();
    field.setDisabled(true);

    // Act and Assert
    assertTrue(field.getDisabled());
  }

  /**
   * Method under test: {@link Field#getAlternateOrdering()}
   */
  @Test
  public void testGetAlternateOrdering() {
    // Arrange, Act and Assert
    assertFalse((new Field()).getAlternateOrdering());
  }

  /**
   * Method under test: {@link Field#getAlternateOrdering()}
   */
  @Test
  public void testGetAlternateOrdering2() {
    // Arrange
    Field field = new Field();
    field.setAlternateOrdering(true);

    // Act and Assert
    assertTrue(field.getAlternateOrdering());
  }

  /**
   * Method under test: {@link Field#getTranslatable()}
   */
  @Test
  public void testGetTranslatable() {
    // Arrange, Act and Assert
    assertFalse((new Field()).getTranslatable());
  }

  /**
   * Method under test: {@link Field#getTranslatable()}
   */
  @Test
  public void testGetTranslatable2() {
    // Arrange
    Field field = new Field();
    field.setTranslatable(true);

    // Act and Assert
    assertTrue(field.getTranslatable());
  }

  /**
   * Method under test: {@link Field#getMainEntityLink()}
   */
  @Test
  public void testGetMainEntityLink() {
    // Arrange, Act and Assert
    assertFalse((new Field()).getMainEntityLink());
  }

  /**
   * Method under test: {@link Field#getMainEntityLink()}
   */
  @Test
  public void testGetMainEntityLink2() {
    // Arrange
    Field field = new Field();
    field.setMainEntityLink(true);

    // Act and Assert
    assertTrue(field.getMainEntityLink());
  }

  /**
   * Method under test: {@link Field#getFilterSortDisabled()}
   */
  @Test
  public void testGetFilterSortDisabled() {
    // Arrange, Act and Assert
    assertFalse((new Field()).getFilterSortDisabled());
  }

  /**
   * Method under test: {@link Field#getFilterSortDisabled()}
   */
  @Test
  public void testGetFilterSortDisabled2() {
    // Arrange
    Field field = new Field();
    field.setFilterSortDisabled(true);

    // Act and Assert
    assertTrue(field.getFilterSortDisabled());
  }

  /**
   * Method under test: {@link Field#getResizeDisabled()}
   */
  @Test
  public void testGetResizeDisabled() {
    // Arrange, Act and Assert
    assertFalse((new Field()).getResizeDisabled());
  }

  /**
   * Method under test: {@link Field#getResizeDisabled()}
   */
  @Test
  public void testGetResizeDisabled2() {
    // Arrange
    Field field = new Field();
    field.setResizeDisabled(true);

    // Act and Assert
    assertTrue(field.getResizeDisabled());
  }

  /**
   * Method under test: {@link Field#getContentOverflowAllowed()}
   */
  @Test
  public void testGetContentOverflowAllowed() {
    // Arrange, Act and Assert
    assertFalse((new Field()).getContentOverflowAllowed());
  }

  /**
   * Method under test: {@link Field#getContentOverflowAllowed()}
   */
  @Test
  public void testGetContentOverflowAllowed2() {
    // Arrange
    Field field = new Field();
    field.setContentOverflowAllowed(true);

    // Act and Assert
    assertTrue(field.getContentOverflowAllowed());
  }

  /**
   * Method under test: {@link Field#getAttribute(String)}
   */
  @Test
  public void testGetAttribute() {
    // Arrange, Act and Assert
    assertNull(field.getAttribute("Key"));
  }

  /**
   * Method under test: {@link Field#getIsTypeaheadEnabled()}
   */
  @Test
  public void testGetIsTypeaheadEnabled() {
    // Arrange, Act and Assert
    assertFalse((new Field()).getIsTypeaheadEnabled());
  }

  /**
   * Method under test: {@link Field#getIsTypeaheadEnabled()}
   */
  @Test
  public void testGetIsTypeaheadEnabled2() {
    // Arrange
    Field field = new Field();
    field.setIsTypeaheadEnabled(true);

    // Act and Assert
    assertTrue(field.getIsTypeaheadEnabled());
  }

  /**
   * Method under test: {@link Field#getTranslationFieldName()}
   */
  @Test
  public void testGetTranslationFieldName() {
    // Arrange, Act and Assert
    assertNull((new Field()).getTranslationFieldName());
  }

  /**
   * Method under test: {@link Field#getTranslationFieldName()}
   */
  @Test
  public void testGetTranslationFieldName2() {
    // Arrange
    Field field = new Field();
    field.setTranslationFieldName("foo");

    // Act and Assert
    assertEquals("foo", field.getTranslationFieldName());
  }

  /**
   * Method under test: {@link Field#getIsConfirmEnabled()}
   */
  @Test
  public void testGetIsConfirmEnabled() {
    // Arrange, Act and Assert
    assertFalse((new Field()).getIsConfirmEnabled());
  }

  /**
   * Method under test: {@link Field#getIsConfirmEnabled()}
   */
  @Test
  public void testGetIsConfirmEnabled2() {
    // Arrange
    Field field = new Field();
    field.setIsConfirmEnabled(true);

    // Act and Assert
    assertTrue(field.getIsConfirmEnabled());
  }

  /**
   * Method under test: {@link Field#getRequired()}
   */
  @Test
  public void testGetRequired() {
    // Arrange, Act and Assert
    assertFalse((new Field()).getRequired());
  }

  /**
   * Method under test: {@link Field#getRequired()}
   */
  @Test
  public void testGetRequired2() {
    // Arrange
    Field field = new Field();
    field.setRequired(null);

    // Act and Assert
    assertFalse(field.getRequired());
  }

  /**
   * Method under test: {@link Field#getRequired()}
   */
  @Test
  public void testGetRequired3() {
    // Arrange
    Field field = new Field();
    field.setRequired(true);

    // Act and Assert
    assertTrue(field.getRequired());
  }

  /**
   * Method under test: {@link Field#getIsDerived()}
   */
  @Test
  public void testGetIsDerived() {
    // Arrange, Act and Assert
    assertFalse((new Field()).getIsDerived());
  }

  /**
   * Method under test: {@link Field#getIsDerived()}
   */
  @Test
  public void testGetIsDerived2() {
    // Arrange
    Field field = new Field();
    field.setDerived(true);

    // Act and Assert
    assertTrue(field.getIsDerived());
  }

  /**
   * Method under test: {@link Field#getIsLargeEntry()}
   */
  @Test
  public void testGetIsLargeEntry() {
    // Arrange, Act and Assert
    assertFalse((new Field()).getIsLargeEntry());
  }

  /**
   * Method under test: {@link Field#getIsLargeEntry()}
   */
  @Test
  public void testGetIsLargeEntry2() {
    // Arrange
    Field field = new Field();
    field.setLargeEntry(true);

    // Act and Assert
    assertTrue(field.getIsLargeEntry());
  }

  /**
   * Method under test: {@link Field#getIsDirty()}
   */
  @Test
  public void testGetIsDirty() {
    // Arrange, Act and Assert
    assertFalse((new Field()).getIsDirty());
  }

  /**
   * Method under test: {@link Field#getIsDirty()}
   */
  @Test
  public void testGetIsDirty2() {
    // Arrange
    Field field = new Field();
    field.setDirty(true);

    // Act and Assert
    assertTrue(field.getIsDirty());
  }

  /**
   * Method under test: {@link Field#getHint()}
   */
  @Test
  public void testGetHint() {
    // Arrange, Act and Assert
    assertNull((new Field()).getHint());
  }

  /**
   * Method under test: {@link Field#getHint()}
   */
  @Test
  public void testGetHint2() {
    // Arrange
    Field field = new Field();
    field.setHint("foo");

    // Act and Assert
    assertEquals("foo", field.getHint());
  }

  /**
   * Method under test: {@link Field#getTooltip()}
   */
  @Test
  public void testGetTooltip() {
    // Arrange, Act and Assert
    assertNull((new Field()).getTooltip());
  }

  /**
   * Method under test: {@link Field#getTooltip()}
   */
  @Test
  public void testGetTooltip2() {
    // Arrange
    Field field = new Field();
    field.setTooltip("foo");

    // Act and Assert
    assertEquals("foo", field.getTooltip());
  }

  /**
   * Method under test: {@link Field#getHelp()}
   */
  @Test
  public void testGetHelp() {
    // Arrange, Act and Assert
    assertNull((new Field()).getHelp());
  }

  /**
   * Method under test: {@link Field#getHelp()}
   */
  @Test
  public void testGetHelp2() {
    // Arrange
    Field field = new Field();
    field.setHelp("foo");

    // Act and Assert
    assertEquals("foo", field.getHelp());
  }

  /**
   * Method under test: {@link Field#getCanLinkToExternalEntity()}
   */
  @Test
  public void testGetCanLinkToExternalEntity() {
    // Arrange, Act and Assert
    assertFalse((new Field()).getCanLinkToExternalEntity());
  }

  /**
   * Method under test: {@link Field#getCanLinkToExternalEntity()}
   */
  @Test
  public void testGetCanLinkToExternalEntity2() {
    // Arrange
    Field field = new Field();
    field.setCanLinkToExternalEntity(false);

    // Act and Assert
    assertFalse(field.getCanLinkToExternalEntity());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Field}
   *   <li>{@link Field#setAllowNoValueEnumOption(Boolean)}
   *   <li>{@link Field#setAlternateOrdering(Boolean)}
   *   <li>{@link Field#setAssociatedFieldName(String)}
   *   <li>{@link Field#setAttributes(Map)}
   *   <li>{@link Field#setCanLinkToExternalEntity(Boolean)}
   *   <li>{@link Field#setConfirmEnabledText(String)}
   *   <li>{@link Field#setContentOverflowAllowed(Boolean)}
   *   <li>{@link Field#setDerived(Boolean)}
   *   <li>{@link Field#setDirty(Boolean)}
   *   <li>{@link Field#setDisabled(Boolean)}
   *   <li>{@link Field#setDisplayType(String)}
   *   <li>{@link Field#setDisplayValue(String)}
   *   <li>{@link Field#setFieldComponentRenderer(String)}
   *   <li>{@link Field#setFieldType(String)}
   *   <li>{@link Field#setFilterSortDisabled(Boolean)}
   *   <li>{@link Field#setForeignKeyClass(String)}
   *   <li>{@link Field#setForeignKeyDisplayValueProperty(String)}
   *   <li>{@link Field#setForeignKeySectionPath(String)}
   *   <li>{@link Field#setFriendlyName(String)}
   *   <li>{@link Field#setGridFieldComponentRenderer(String)}
   *   <li>{@link Field#setHelp(String)}
   *   <li>{@link Field#setHint(String)}
   *   <li>{@link Field#setIdOverride(String)}
   *   <li>{@link Field#setIsConfirmEnabled(Boolean)}
   *   <li>{@link Field#setIsTypeaheadEnabled(Boolean)}
   *   <li>{@link Field#setIsVisible(Boolean)}
   *   <li>{@link Field#setLargeEntry(Boolean)}
   *   <li>{@link Field#setMainEntityLink(Boolean)}
   *   <li>{@link Field#setName(String)}
   *   <li>{@link Field#setOnChangeTrigger(String)}
   *   <li>{@link Field#setOrder(Integer)}
   *   <li>{@link Field#setOwningEntityClass(String)}
   *   <li>{@link Field#setReadOnly(Boolean)}
   *   <li>{@link Field#setRequired(Boolean)}
   *   <li>{@link Field#setResizeDisabled(Boolean)}
   *   <li>{@link Field#setShouldRender(Boolean)}
   *   <li>{@link Field#setTooltip(String)}
   *   <li>{@link Field#setTranslatable(Boolean)}
   *   <li>{@link Field#setTranslationFieldName(String)}
   *   <li>{@link Field#setValue(String)}
   *   <li>{@link Field#getAllowNoValueEnumOption()}
   *   <li>{@link Field#getAssociatedFieldName()}
   *   <li>{@link Field#getAttributes()}
   *   <li>{@link Field#getColumnWidth()}
   *   <li>{@link Field#getConfirmEnabledText()}
   *   <li>{@link Field#getDisplayType()}
   *   <li>{@link Field#getFieldComponentRenderer()}
   *   <li>{@link Field#getFieldType()}
   *   <li>{@link Field#getForeignKeyClass()}
   *   <li>{@link Field#getForeignKeyDisplayValueProperty()}
   *   <li>{@link Field#getForeignKeySectionPath()}
   *   <li>{@link Field#getFriendlyName()}
   *   <li>{@link Field#getGridFieldComponentRenderer()}
   *   <li>{@link Field#getIdOverride()}
   *   <li>{@link Field#getName()}
   *   <li>{@link Field#getOnChangeTrigger()}
   *   <li>{@link Field#getOrder()}
   *   <li>{@link Field#getOwningEntityClass()}
   *   <li>{@link Field#getRawDisplayValue()}
   *   <li>{@link Field#getShouldRender()}
   *   <li>{@link Field#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Field actualField = new Field();
    actualField.setAllowNoValueEnumOption(true);
    actualField.setAlternateOrdering(true);
    actualField.setAssociatedFieldName("Associated Field Name");
    HashMap<String, Object> attributes = new HashMap<>();
    actualField.setAttributes(attributes);
    actualField.setCanLinkToExternalEntity(true);
    actualField.setConfirmEnabledText("Confirm Enabled Text");
    actualField.setContentOverflowAllowed(true);
    actualField.setDerived(true);
    actualField.setDirty(true);
    actualField.setDisabled(true);
    actualField.setDisplayType("Display Type");
    actualField.setDisplayValue("42");
    actualField.setFieldComponentRenderer("Field Component Renderer");
    actualField.setFieldType("Field Type");
    actualField.setFilterSortDisabled(true);
    actualField.setForeignKeyClass("Foreign Key Class");
    actualField.setForeignKeyDisplayValueProperty("42");
    actualField.setForeignKeySectionPath("Foreign Key Section Path");
    actualField.setFriendlyName("Friendly Name");
    actualField.setGridFieldComponentRenderer("Grid Field Component Renderer");
    actualField.setHelp("Help");
    actualField.setHint("Hint");
    actualField.setIdOverride("Id Override");
    actualField.setIsConfirmEnabled(true);
    actualField.setIsTypeaheadEnabled(true);
    actualField.setIsVisible(true);
    actualField.setLargeEntry(true);
    actualField.setMainEntityLink(true);
    actualField.setName("Name");
    actualField.setOnChangeTrigger("On Change Trigger");
    actualField.setOrder(1);
    actualField.setOwningEntityClass("Owning Entity Class");
    actualField.setReadOnly(true);
    actualField.setRequired(true);
    actualField.setResizeDisabled(true);
    actualField.setShouldRender(true);
    actualField.setTooltip("127.0.0.1");
    actualField.setTranslatable(true);
    actualField.setTranslationFieldName("Translation Field Name");
    actualField.setValue("42");
    Boolean actualAllowNoValueEnumOption = actualField.getAllowNoValueEnumOption();
    String actualAssociatedFieldName = actualField.getAssociatedFieldName();
    Map<String, Object> actualAttributes = actualField.getAttributes();
    actualField.getColumnWidth();
    String actualConfirmEnabledText = actualField.getConfirmEnabledText();
    String actualDisplayType = actualField.getDisplayType();
    String actualFieldComponentRenderer = actualField.getFieldComponentRenderer();
    String actualFieldType = actualField.getFieldType();
    String actualForeignKeyClass = actualField.getForeignKeyClass();
    String actualForeignKeyDisplayValueProperty = actualField.getForeignKeyDisplayValueProperty();
    String actualForeignKeySectionPath = actualField.getForeignKeySectionPath();
    String actualFriendlyName = actualField.getFriendlyName();
    String actualGridFieldComponentRenderer = actualField.getGridFieldComponentRenderer();
    String actualIdOverride = actualField.getIdOverride();
    String actualName = actualField.getName();
    String actualOnChangeTrigger = actualField.getOnChangeTrigger();
    Integer actualOrder = actualField.getOrder();
    String actualOwningEntityClass = actualField.getOwningEntityClass();
    String actualRawDisplayValue = actualField.getRawDisplayValue();
    Boolean actualShouldRender = actualField.getShouldRender();

    // Assert that nothing has changed
    assertEquals("42", actualForeignKeyDisplayValueProperty);
    assertEquals("42", actualRawDisplayValue);
    assertEquals("42", actualField.getValue());
    assertEquals("Associated Field Name", actualAssociatedFieldName);
    assertEquals("Confirm Enabled Text", actualConfirmEnabledText);
    assertEquals("Display Type", actualDisplayType);
    assertEquals("Field Component Renderer", actualFieldComponentRenderer);
    assertEquals("Field Type", actualFieldType);
    assertEquals("Foreign Key Class", actualForeignKeyClass);
    assertEquals("Foreign Key Section Path", actualForeignKeySectionPath);
    assertEquals("Friendly Name", actualFriendlyName);
    assertEquals("Grid Field Component Renderer", actualGridFieldComponentRenderer);
    assertEquals("Id Override", actualIdOverride);
    assertEquals("Name", actualName);
    assertEquals("On Change Trigger", actualOnChangeTrigger);
    assertEquals("Owning Entity Class", actualOwningEntityClass);
    assertEquals(1, actualOrder.intValue());
    assertTrue(actualAttributes.isEmpty());
    assertTrue(actualAllowNoValueEnumOption);
    assertTrue(actualShouldRender);
    assertSame(attributes, actualAttributes);
  }
}
