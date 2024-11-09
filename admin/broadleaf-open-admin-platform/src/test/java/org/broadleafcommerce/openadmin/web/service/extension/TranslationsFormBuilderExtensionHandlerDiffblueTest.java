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
package org.broadleafcommerce.openadmin.web.service.extension;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.web.form.component.ListGridRecord;
import org.broadleafcommerce.openadmin.web.form.entity.CodeField;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.junit.Test;
import org.mockito.Mockito;

public class TranslationsFormBuilderExtensionHandlerDiffblueTest {
  /**
   * Test
   * {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}.
   * <p>
   * Method under test:
   * {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}
   */
  @Test
  public void testModifyListGridRecord() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();
    ListGridRecord resultRecord = new ListGridRecord();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        translationsFormBuilderExtensionHandler.modifyListGridRecord(
            "org.broadleafcommerce.openadmin.web.service.extension.TranslationsFormBuilderExtensionHandler",
            resultRecord, new Entity()));
  }

  /**
   * Test
   * {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}.
   * <ul>
   *   <li>Given {@link CodeField} {@link Field#getValue()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}
   */
  @Test
  public void testModifyListGridRecord_givenCodeFieldGetValueReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();
    CodeField codeField = mock(CodeField.class);
    when(codeField.getValue()).thenReturn(null);
    when(codeField.getDisplayValue()).thenReturn("42");
    ListGridRecord resultRecord = mock(ListGridRecord.class);
    when(resultRecord.getField(Mockito.<String>any())).thenReturn(codeField);

    // Act
    ExtensionResultStatusType actualModifyListGridRecordResult = translationsFormBuilderExtensionHandler
        .modifyListGridRecord("org.broadleafcommerce.common.i18n.domain.Translation", resultRecord, new Entity());

    // Assert
    verify(resultRecord).getField(eq("translatedValue"));
    verify(codeField).getDisplayValue();
    verify(codeField).getValue();
    assertEquals(ExtensionResultStatusType.HANDLED, actualModifyListGridRecordResult);
  }

  /**
   * Test
   * {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}.
   * <ul>
   *   <li>Given {@link Field} (default constructor).</li>
   *   <li>When {@link ListGridRecord} {@link ListGridRecord#getField(String)}
   * return {@link Field} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}
   */
  @Test
  public void testModifyListGridRecord_givenField_whenListGridRecordGetFieldReturnField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();
    ListGridRecord resultRecord = mock(ListGridRecord.class);
    when(resultRecord.getField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    ExtensionResultStatusType actualModifyListGridRecordResult = translationsFormBuilderExtensionHandler
        .modifyListGridRecord("org.broadleafcommerce.common.i18n.domain.Translation", resultRecord, new Entity());

    // Assert
    verify(resultRecord).getField(eq("translatedValue"));
    assertEquals(ExtensionResultStatusType.HANDLED, actualModifyListGridRecordResult);
  }

  /**
   * Test
   * {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ListGridRecord} {@link ListGridRecord#getField(String)}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}
   */
  @Test
  public void testModifyListGridRecord_givenNull_whenListGridRecordGetFieldReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();
    ListGridRecord resultRecord = mock(ListGridRecord.class);
    when(resultRecord.getField(Mockito.<String>any())).thenReturn(null);

    // Act
    ExtensionResultStatusType actualModifyListGridRecordResult = translationsFormBuilderExtensionHandler
        .modifyListGridRecord("org.broadleafcommerce.common.i18n.domain.Translation", resultRecord, new Entity());

    // Assert
    verify(resultRecord).getField(eq("translatedValue"));
    assertEquals(ExtensionResultStatusType.HANDLED, actualModifyListGridRecordResult);
  }

  /**
   * Test
   * {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}.
   * <ul>
   *   <li>Then calls {@link Field#setDisplayValue(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}
   */
  @Test
  public void testModifyListGridRecord_thenCallsSetDisplayValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();
    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setDisplayValue(Mockito.<String>any());
    doNothing().when(codeField).setValue(Mockito.<String>any());
    when(codeField.getValue()).thenReturn("42");
    when(codeField.getDisplayValue()).thenReturn("42");
    ListGridRecord resultRecord = mock(ListGridRecord.class);
    when(resultRecord.getField(Mockito.<String>any())).thenReturn(codeField);

    // Act
    ExtensionResultStatusType actualModifyListGridRecordResult = translationsFormBuilderExtensionHandler
        .modifyListGridRecord("org.broadleafcommerce.common.i18n.domain.Translation", resultRecord, new Entity());

    // Assert
    verify(resultRecord).getField(eq("translatedValue"));
    verify(codeField, atLeast(1)).getDisplayValue();
    verify(codeField, atLeast(1)).getValue();
    verify(codeField).setDisplayValue(eq("42"));
    verify(codeField).setValue(eq("42"));
    assertEquals(ExtensionResultStatusType.HANDLED, actualModifyListGridRecordResult);
  }

  /**
   * Test
   * {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}.
   * <ul>
   *   <li>When {@code Class Name}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}
   */
  @Test
  public void testModifyListGridRecord_whenClassName_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();
    ListGridRecord resultRecord = new ListGridRecord();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        translationsFormBuilderExtensionHandler.modifyListGridRecord("Class Name", resultRecord, new Entity()));
  }

  /**
   * Test
   * {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}.
   * <ul>
   *   <li>When {@link ListGridRecord} (default constructor).</li>
   *   <li>Then return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}
   */
  @Test
  public void testModifyListGridRecord_whenListGridRecord_thenReturnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();
    ListGridRecord resultRecord = new ListGridRecord();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED, translationsFormBuilderExtensionHandler
        .modifyListGridRecord("org.broadleafcommerce.common.i18n.domain.Translation", resultRecord, new Entity()));
  }

  /**
   * Test
   * {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}.
   * <ul>
   *   <li>When {@link ListGridRecord}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}
   */
  @Test
  public void testModifyListGridRecord_whenListGridRecord_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();
    ListGridRecord resultRecord = mock(ListGridRecord.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        translationsFormBuilderExtensionHandler.modifyListGridRecord("Class Name", resultRecord, new Entity()));
  }
}
