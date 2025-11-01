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
package org.broadleafcommerce.openadmin.web.form.component;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ListGridRecord.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ListGridRecordDiffblueTest {
  @Autowired
  private ListGridRecord listGridRecord;

  /**
   * Method under test: {@link ListGridRecord#getPath()}
   */
  @Test
  public void testGetPath() {
    // Arrange
    ListGrid listGrid = new ListGrid();
    listGrid.setSectionKey("/");

    ListGridRecord listGridRecord = new ListGridRecord();
    listGridRecord.setListGrid(listGrid);

    // Act and Assert
    assertEquals("//null", listGridRecord.getPath());
  }

  /**
   * Method under test: {@link ListGridRecord#getPath()}
   */
  @Test
  public void testGetPath2() {
    // Arrange
    ListGrid listGrid = new ListGrid();
    listGrid.setPathOverride("/");

    ListGridRecord listGridRecord = new ListGridRecord();
    listGridRecord.setListGrid(listGrid);

    // Act and Assert
    assertEquals("//null", listGridRecord.getPath());
  }

  /**
   * Method under test: {@link ListGridRecord#getPath()}
   */
  @Test
  public void testGetPath3() {
    // Arrange
    ListGrid listGrid = new ListGrid();
    listGrid.setSectionKey("/");

    ListGridRecord listGridRecord = new ListGridRecord();
    listGridRecord.setAltId("42");
    listGridRecord.setListGrid(listGrid);

    // Act and Assert
    assertEquals("//null/42", listGridRecord.getPath());
  }

  /**
   * Method under test: {@link ListGridRecord#getPath()}
   */
  @Test
  public void testGetPath4() {
    // Arrange
    ListGrid listGrid = new ListGrid();
    listGrid.setSectionKey("/");

    ListGridRecord listGridRecord = new ListGridRecord();
    listGridRecord.setAltId("");
    listGridRecord.setListGrid(listGrid);

    // Act and Assert
    assertEquals("//null", listGridRecord.getPath());
  }

  /**
   * Method under test: {@link ListGridRecord#getCanLinkToExternalEntity()}
   */
  @Test
  public void testGetCanLinkToExternalEntity() {
    // Arrange
    ListGrid listGrid = new ListGrid();
    listGrid.setExternalEntitySectionKey(null);

    ListGridRecord listGridRecord = new ListGridRecord();
    listGridRecord.setListGrid(listGrid);

    // Act and Assert
    assertFalse(listGridRecord.getCanLinkToExternalEntity());
  }

  /**
   * Method under test: {@link ListGridRecord#getCanLinkToExternalEntity()}
   */
  @Test
  public void testGetCanLinkToExternalEntity2() {
    // Arrange
    ListGrid listGrid = new ListGrid();
    listGrid.setExternalEntitySectionKey("foo");

    ListGridRecord listGridRecord = new ListGridRecord();
    listGridRecord.setListGrid(listGrid);

    // Act and Assert
    assertTrue(listGridRecord.getCanLinkToExternalEntity());
  }

  /**
   * Method under test: {@link ListGridRecord#getExternalEntityPath()}
   */
  @Test
  public void testGetExternalEntityPath() {
    // Arrange
    ListGridRecord listGridRecord = new ListGridRecord();
    listGridRecord.setListGrid(new ListGrid());

    // Act and Assert
    assertEquals("null/null", listGridRecord.getExternalEntityPath());
  }

  /**
   * Method under test: {@link ListGridRecord#getIndex()}
   */
  @Test
  public void testGetIndex() {
    // Arrange
    ArrayList<ListGridRecord> records = new ArrayList<>();
    records.add(new ListGridRecord());

    ListGrid listGrid = new ListGrid();
    listGrid.setRecords(records);

    ListGridRecord listGridRecord = new ListGridRecord();
    listGridRecord.setListGrid(listGrid);

    // Act and Assert
    assertEquals(-1, listGridRecord.getIndex());
  }

  /**
   * Method under test: {@link ListGridRecord#getField(String)}
   */
  @Test
  public void testGetField() {
    // Arrange and Act
    Field actualField = listGridRecord.getField("Field Name");

    // Assert
    assertEquals("null/null", actualField.getEntityViewPath());
    assertNull(actualField.getOrder());
    assertNull(actualField.getAssociatedFieldName());
    assertNull(actualField.getColumnWidth());
    assertNull(actualField.getConfirmEnabledText());
    assertNull(actualField.getDisplayType());
    assertNull(actualField.getDisplayValue());
    assertNull(actualField.getFieldComponentRenderer());
    assertNull(actualField.getFieldType());
    assertNull(actualField.getForeignKeyClass());
    assertNull(actualField.getForeignKeyDisplayValueProperty());
    assertNull(actualField.getForeignKeySectionPath());
    assertNull(actualField.getFriendlyName());
    assertNull(actualField.getGridFieldComponentRenderer());
    assertNull(actualField.getHelp());
    assertNull(actualField.getHint());
    assertNull(actualField.getIdOverride());
    assertNull(actualField.getName());
    assertNull(actualField.getOnChangeTrigger());
    assertNull(actualField.getOwningEntityClass());
    assertNull(actualField.getRawDisplayValue());
    assertNull(actualField.getTooltip());
    assertNull(actualField.getTranslationFieldName());
    assertNull(actualField.getValue());
    assertFalse(actualField.getAllowNoValueEnumOption());
    assertFalse(actualField.getAlternateOrdering());
    assertFalse(actualField.getCanLinkToExternalEntity());
    assertFalse(actualField.getContentOverflowAllowed());
    assertFalse(actualField.getDisabled());
    assertFalse(actualField.getFilterSortDisabled());
    assertFalse(actualField.getIsConfirmEnabled());
    assertFalse(actualField.getIsDerived());
    assertFalse(actualField.getIsDirty());
    assertFalse(actualField.getIsLargeEntry());
    assertFalse(actualField.getIsTypeaheadEnabled());
    assertFalse(actualField.getMainEntityLink());
    assertFalse(actualField.getReadOnly());
    assertFalse(actualField.getRequired());
    assertFalse(actualField.getResizeDisabled());
    assertFalse(actualField.getTranslatable());
    assertTrue(actualField.getAttributes().isEmpty());
    assertTrue(listGridRecord.fieldMap.isEmpty());
    assertTrue(actualField.getIsVisible());
    assertTrue(actualField.getShouldRender());
  }

  /**
   * Method under test: {@link ListGridRecord#getField(String)}
   */
  @Test
  public void testGetField2() {
    // Arrange and Act
    Field actualField = listGridRecord.getField(null);

    // Assert
    assertEquals("null/null", actualField.getEntityViewPath());
    assertNull(actualField.getOrder());
    assertNull(actualField.getAssociatedFieldName());
    assertNull(actualField.getColumnWidth());
    assertNull(actualField.getConfirmEnabledText());
    assertNull(actualField.getDisplayType());
    assertNull(actualField.getDisplayValue());
    assertNull(actualField.getFieldComponentRenderer());
    assertNull(actualField.getFieldType());
    assertNull(actualField.getForeignKeyClass());
    assertNull(actualField.getForeignKeyDisplayValueProperty());
    assertNull(actualField.getForeignKeySectionPath());
    assertNull(actualField.getFriendlyName());
    assertNull(actualField.getGridFieldComponentRenderer());
    assertNull(actualField.getHelp());
    assertNull(actualField.getHint());
    assertNull(actualField.getIdOverride());
    assertNull(actualField.getName());
    assertNull(actualField.getOnChangeTrigger());
    assertNull(actualField.getOwningEntityClass());
    assertNull(actualField.getRawDisplayValue());
    assertNull(actualField.getTooltip());
    assertNull(actualField.getTranslationFieldName());
    assertNull(actualField.getValue());
    assertFalse(actualField.getAllowNoValueEnumOption());
    assertFalse(actualField.getAlternateOrdering());
    assertFalse(actualField.getCanLinkToExternalEntity());
    assertFalse(actualField.getContentOverflowAllowed());
    assertFalse(actualField.getDisabled());
    assertFalse(actualField.getFilterSortDisabled());
    assertFalse(actualField.getIsConfirmEnabled());
    assertFalse(actualField.getIsDerived());
    assertFalse(actualField.getIsDirty());
    assertFalse(actualField.getIsLargeEntry());
    assertFalse(actualField.getIsTypeaheadEnabled());
    assertFalse(actualField.getMainEntityLink());
    assertFalse(actualField.getReadOnly());
    assertFalse(actualField.getRequired());
    assertFalse(actualField.getResizeDisabled());
    assertFalse(actualField.getTranslatable());
    assertTrue(actualField.getAttributes().isEmpty());
    assertTrue(listGridRecord.fieldMap.isEmpty());
    assertTrue(actualField.getIsVisible());
    assertTrue(actualField.getShouldRender());
  }

  /**
   * Method under test: {@link ListGridRecord#hasField(String)}
   */
  @Test
  public void testHasField() {
    // Arrange, Act and Assert
    assertFalse(listGridRecord.hasField("Field Name"));
    assertTrue(listGridRecord.fieldMap.isEmpty());
  }

  /**
   * Method under test: {@link ListGridRecord#populateFieldMap()}
   */
  @Test
  public void testPopulateFieldMap() {
    // Arrange
    ListGridRecord listGridRecord = new ListGridRecord();

    // Act
    listGridRecord.populateFieldMap();

    // Assert
    assertTrue(listGridRecord.fieldMap.isEmpty());
  }

  /**
   * Method under test: {@link ListGridRecord#populateFieldMap()}
   */
  @Test
  public void testPopulateFieldMap2() {
    // Arrange
    ArrayList<Field> fields = new ArrayList<>();
    fields.add(new Field());

    ArrayList<Field> hiddenFields = new ArrayList<>();
    Field field = new Field();
    hiddenFields.add(field);

    ListGridRecord listGridRecord = new ListGridRecord();
    listGridRecord.setFields(fields);
    listGridRecord.setHiddenFields(hiddenFields);

    // Act
    listGridRecord.populateFieldMap();

    // Assert
    Map<String, Field> stringFieldMap = listGridRecord.fieldMap;
    assertEquals(1, stringFieldMap.size());
    assertSame(field, stringFieldMap.get(null));
  }

  /**
   * Method under test: {@link ListGridRecord#getHiddenFieldsJson()}
   */
  @Test
  public void testGetHiddenFieldsJson() {
    // Arrange, Act and Assert
    assertEquals("{\"hiddenFields\":[]}", (new ListGridRecord()).getHiddenFieldsJson());
  }

  /**
   * Method under test: {@link ListGridRecord#getHiddenFieldsJson()}
   */
  @Test
  public void testGetHiddenFieldsJson2() {
    // Arrange
    ArrayList<Field> hiddenFields = new ArrayList<>();
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());

    ListGridRecord listGridRecord = new ListGridRecord();
    listGridRecord.setHiddenFields(hiddenFields);

    // Act and Assert
    assertEquals(
        "{\"hiddenFields\":[{\"name\":\"null\",\"val\":\"\"},{\"name\":\"null\",\"val\":\"\"},{\"name\":\"null\",\"val\":\"\"},{\"name\":"
            + "\"null\",\"val\":\"\"},{\"name\":\"null\",\"val\":\"\"},{\"name\":\"null\",\"val\":\"\"},{\"name\":\"null\",\"val\":\"\"},{\"name\":"
            + "\"null\",\"val\":\"\"},{\"name\":\"null\",\"val\":\"\"},{\"name\":\"null\",\"val\":\"\"},{\"name\":\"null\",\"val\":\"\"},{\"name\":"
            + "\"null\",\"val\":\"\"},{\"name\":\"null\",\"val\":\"\"},{\"name\":\"null\",\"val\":\"\"},{\"name\":\"null\",\"val\":\"\"},{\"name\":"
            + "\"null\",\"val\":\"\"},{\"name\":\"null\",\"val\":\"\"},{\"name\":\"null\",\"val\":\"\"}]}",
        listGridRecord.getHiddenFieldsJson());
  }

  /**
   * Method under test: {@link ListGridRecord#getHiddenFieldsJson()}
   */
  @Test
  public void testGetHiddenFieldsJson3() {
    // Arrange
    Field field = new Field();
    field.setValue("42");

    ArrayList<Field> hiddenFields = new ArrayList<>();
    hiddenFields.add(field);
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());
    hiddenFields.add(new Field());

    ListGridRecord listGridRecord = new ListGridRecord();
    listGridRecord.setHiddenFields(hiddenFields);

    // Act and Assert
    assertEquals(
        "{\"hiddenFields\":[{\"name\":\"null\",\"val\":\"42\"},{\"name\":\"null\",\"val\":\"\"},{\"name\":\"null\",\"val\":\"\"},{\"name"
            + "\":\"null\",\"val\":\"\"},{\"name\":\"null\",\"val\":\"\"},{\"name\":\"null\",\"val\":\"\"},{\"name\":\"null\",\"val\":\"\"},{\"name"
            + "\":\"null\",\"val\":\"\"},{\"name\":\"null\",\"val\":\"\"},{\"name\":\"null\",\"val\":\"\"},{\"name\":\"null\",\"val\":\"\"},{\"name"
            + "\":\"null\",\"val\":\"\"},{\"name\":\"null\",\"val\":\"\"},{\"name\":\"null\",\"val\":\"\"},{\"name\":\"null\",\"val\":\"\"},{\"name"
            + "\":\"null\",\"val\":\"\"},{\"name\":\"null\",\"val\":\"\"},{\"name\":\"null\",\"val\":\"\"}]}",
        listGridRecord.getHiddenFieldsJson());
  }

  /**
   * Method under test: {@link ListGridRecord#getIsDirty()}
   */
  @Test
  public void testGetIsDirty() {
    // Arrange, Act and Assert
    assertFalse((new ListGridRecord()).getIsDirty());
  }

  /**
   * Method under test: {@link ListGridRecord#getIsDirty()}
   */
  @Test
  public void testGetIsDirty2() {
    // Arrange
    ListGridRecord listGridRecord = new ListGridRecord();
    listGridRecord.setDirty(true);

    // Act and Assert
    assertTrue(listGridRecord.getIsDirty());
  }

  /**
   * Method under test: {@link ListGridRecord#getReadOnly()}
   */
  @Test
  public void testGetReadOnly() {
    // Arrange, Act and Assert
    assertFalse((new ListGridRecord()).getReadOnly());
  }

  /**
   * Method under test: {@link ListGridRecord#getReadOnly()}
   */
  @Test
  public void testGetReadOnly2() {
    // Arrange
    ListGridRecord listGridRecord = new ListGridRecord();
    listGridRecord.setReadOnly(null);

    // Act and Assert
    assertFalse(listGridRecord.getReadOnly());
  }

  /**
   * Method under test: {@link ListGridRecord#getReadOnly()}
   */
  @Test
  public void testGetReadOnly3() {
    // Arrange
    ListGridRecord listGridRecord = new ListGridRecord();
    listGridRecord.setReadOnly(true);

    // Act and Assert
    assertTrue(listGridRecord.getReadOnly());
  }

  /**
   * Method under test: {@link ListGridRecord#getIsError()}
   */
  @Test
  public void testGetIsError() {
    // Arrange, Act and Assert
    assertFalse((new ListGridRecord()).getIsError());
  }

  /**
   * Method under test: {@link ListGridRecord#getIsError()}
   */
  @Test
  public void testGetIsError2() {
    // Arrange
    ListGridRecord listGridRecord = new ListGridRecord();
    listGridRecord.setIsError(true);

    // Act and Assert
    assertTrue(listGridRecord.getIsError());
  }

  /**
   * Method under test: {@link ListGridRecord#getIcon()}
   */
  @Test
  public void testGetIcon() {
    // Arrange, Act and Assert
    assertNull((new ListGridRecord()).getIcon());
  }

  /**
   * Method under test: {@link ListGridRecord#getIcon()}
   */
  @Test
  public void testGetIcon2() {
    // Arrange
    ListGridRecord listGridRecord = new ListGridRecord();
    listGridRecord.setIcon(null);
    listGridRecord.setErrorMessage(null);
    listGridRecord.setStatus("foo");
    listGridRecord.setIsError(null);
    listGridRecord.setDirty(null);

    // Act
    ListGridRecordIcon actualIcon = listGridRecord.getIcon();

    // Assert
    assertEquals("foo", actualIcon.getMessage());
    assertNull(actualIcon.getCssClass());
    assertTrue(actualIcon.getHasDetails());
  }

  /**
   * Method under test: {@link ListGridRecord#getIcon()}
   */
  @Test
  public void testGetIcon3() {
    // Arrange
    ListGridRecord listGridRecord = new ListGridRecord();
    listGridRecord.setIcon(null);
    listGridRecord.setErrorMessage("foo");
    listGridRecord.setStatus(null);
    listGridRecord.setIsError(true);
    listGridRecord.setDirty(null);

    // Act
    ListGridRecordIcon actualIcon = listGridRecord.getIcon();

    // Assert
    assertEquals("fa fa-exclamation-triangle", actualIcon.getCssClass());
    assertEquals("foo", actualIcon.getMessage());
    assertTrue(actualIcon.getHasDetails());
  }

  /**
   * Method under test: {@link ListGridRecord#getIcon()}
   */
  @Test
  public void testGetIcon4() {
    // Arrange
    ListGridRecord listGridRecord = new ListGridRecord();
    ListGridRecordIcon icon = new ListGridRecordIcon();
    listGridRecord.setIcon(icon);
    listGridRecord.setErrorMessage(null);
    listGridRecord.setStatus(null);
    listGridRecord.setIsError(null);
    listGridRecord.setDirty(null);

    // Act and Assert
    assertSame(icon, listGridRecord.getIcon());
  }

  /**
   * Method under test: {@link ListGridRecord#getHasIcon()}
   */
  @Test
  public void testGetHasIcon() {
    // Arrange, Act and Assert
    assertFalse((new ListGridRecord()).getHasIcon());
  }

  /**
   * Method under test: {@link ListGridRecord#getHasIcon()}
   */
  @Test
  public void testGetHasIcon2() {
    // Arrange
    ListGridRecord listGridRecord = new ListGridRecord();
    listGridRecord.setIcon(null);
    listGridRecord.setStatus(null);
    listGridRecord.setDirty(null);
    listGridRecord.setIsError(true);

    // Act and Assert
    assertTrue(listGridRecord.getHasIcon());
  }

  /**
   * Method under test: {@link ListGridRecord#getHasIcon()}
   */
  @Test
  public void testGetHasIcon3() {
    // Arrange
    ListGridRecord listGridRecord = new ListGridRecord();
    listGridRecord.setIcon(null);
    listGridRecord.setStatus(null);
    listGridRecord.setDirty(true);
    listGridRecord.setIsError(null);

    // Act and Assert
    assertTrue(listGridRecord.getHasIcon());
  }

  /**
   * Method under test: {@link ListGridRecord#getHasIcon()}
   */
  @Test
  public void testGetHasIcon4() {
    // Arrange
    ListGridRecord listGridRecord = new ListGridRecord();
    listGridRecord.setIcon(null);
    listGridRecord.setStatus("foo");
    listGridRecord.setDirty(null);
    listGridRecord.setIsError(null);

    // Act and Assert
    assertTrue(listGridRecord.getHasIcon());
  }

  /**
   * Method under test: {@link ListGridRecord#getHasIcon()}
   */
  @Test
  public void testGetHasIcon5() {
    // Arrange
    ListGridRecord listGridRecord = new ListGridRecord();
    listGridRecord.setIcon(new ListGridRecordIcon());
    listGridRecord.setStatus(null);
    listGridRecord.setDirty(null);
    listGridRecord.setIsError(null);

    // Act and Assert
    assertTrue(listGridRecord.getHasIcon());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ListGridRecord}
   *   <li>{@link ListGridRecord#setAltId(String)}
   *   <li>{@link ListGridRecord#setDirty(Boolean)}
   *   <li>{@link ListGridRecord#setDisplayOrder(String)}
   *   <li>{@link ListGridRecord#setEntity(Entity)}
   *   <li>{@link ListGridRecord#setErrorKey(String)}
   *   <li>{@link ListGridRecord#setErrorMessage(String)}
   *   <li>{@link ListGridRecord#setFields(List)}
   *   <li>{@link ListGridRecord#setHiddenFields(List)}
   *   <li>{@link ListGridRecord#setIcon(ListGridRecordIcon)}
   *   <li>{@link ListGridRecord#setId(String)}
   *   <li>{@link ListGridRecord#setIsError(Boolean)}
   *   <li>{@link ListGridRecord#setListGrid(ListGrid)}
   *   <li>{@link ListGridRecord#setLocked(Boolean)}
   *   <li>{@link ListGridRecord#setReadOnly(Boolean)}
   *   <li>{@link ListGridRecord#setStatus(String)}
   *   <li>{@link ListGridRecord#setStatusCssClass(String)}
   *   <li>{@link ListGridRecord#clearFieldMap()}
   *   <li>{@link ListGridRecord#getAltId()}
   *   <li>{@link ListGridRecord#getDisplayOrder()}
   *   <li>{@link ListGridRecord#getEntity()}
   *   <li>{@link ListGridRecord#getErrorKey()}
   *   <li>{@link ListGridRecord#getErrorMessage()}
   *   <li>{@link ListGridRecord#getFields()}
   *   <li>{@link ListGridRecord#getHiddenFields()}
   *   <li>{@link ListGridRecord#getId()}
   *   <li>{@link ListGridRecord#getListGrid()}
   *   <li>{@link ListGridRecord#getLocked()}
   *   <li>{@link ListGridRecord#getStatus()}
   *   <li>{@link ListGridRecord#getStatusCssClass()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ListGridRecord actualListGridRecord = new ListGridRecord();
    actualListGridRecord.setAltId("42");
    actualListGridRecord.setDirty(true);
    actualListGridRecord.setDisplayOrder("Display Order");
    Entity entity = new Entity();
    actualListGridRecord.setEntity(entity);
    actualListGridRecord.setErrorKey("An error occurred");
    actualListGridRecord.setErrorMessage("An error occurred");
    ArrayList<Field> fields = new ArrayList<>();
    actualListGridRecord.setFields(fields);
    ArrayList<Field> hiddenFields = new ArrayList<>();
    actualListGridRecord.setHiddenFields(hiddenFields);
    actualListGridRecord.setIcon(new ListGridRecordIcon());
    actualListGridRecord.setId("42");
    actualListGridRecord.setIsError(true);
    ListGrid listGrid = new ListGrid();
    actualListGridRecord.setListGrid(listGrid);
    actualListGridRecord.setLocked(true);
    actualListGridRecord.setReadOnly(true);
    actualListGridRecord.setStatus("Status");
    actualListGridRecord.setStatusCssClass("Status Css Class");
    actualListGridRecord.clearFieldMap();
    String actualAltId = actualListGridRecord.getAltId();
    String actualDisplayOrder = actualListGridRecord.getDisplayOrder();
    Entity actualEntity = actualListGridRecord.getEntity();
    String actualErrorKey = actualListGridRecord.getErrorKey();
    String actualErrorMessage = actualListGridRecord.getErrorMessage();
    List<Field> actualFields = actualListGridRecord.getFields();
    List<Field> actualHiddenFields = actualListGridRecord.getHiddenFields();
    String actualId = actualListGridRecord.getId();
    ListGrid actualListGrid = actualListGridRecord.getListGrid();
    Boolean actualLocked = actualListGridRecord.getLocked();
    String actualStatus = actualListGridRecord.getStatus();

    // Assert that nothing has changed
    assertEquals("42", actualAltId);
    assertEquals("42", actualId);
    assertEquals("An error occurred", actualErrorKey);
    assertEquals("An error occurred", actualErrorMessage);
    assertEquals("Display Order", actualDisplayOrder);
    assertEquals("Status Css Class", actualListGridRecord.getStatusCssClass());
    assertEquals("Status", actualStatus);
    assertTrue(actualFields.isEmpty());
    assertTrue(actualHiddenFields.isEmpty());
    assertTrue(actualLocked);
    assertSame(fields, actualFields);
    assertSame(hiddenFields, actualHiddenFields);
    assertSame(entity, actualEntity);
    assertSame(listGrid, actualListGrid);
  }
}
