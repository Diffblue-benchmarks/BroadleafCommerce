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
        translationsFormBuilderExtensionHandler.modifyListGridRecord("Class Name", resultRecord, new Entity()));
  }

  /**
   * Method under test:
   * {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}
   */
  @Test
  public void testModifyListGridRecord2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();
    ListGridRecord resultRecord = new ListGridRecord();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED, translationsFormBuilderExtensionHandler
        .modifyListGridRecord("org.broadleafcommerce.common.i18n.domain.Translation", resultRecord, new Entity()));
  }

  /**
   * Method under test:
   * {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}
   */
  @Test
  public void testModifyListGridRecord3() {
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
   * Method under test:
   * {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}
   */
  @Test
  public void testModifyListGridRecord4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();
    ListGridRecord resultRecord = mock(ListGridRecord.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        translationsFormBuilderExtensionHandler.modifyListGridRecord("Class Name", resultRecord, new Entity()));
  }

  /**
   * Method under test:
   * {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}
   */
  @Test
  public void testModifyListGridRecord5() {
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
   * Method under test:
   * {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}
   */
  @Test
  public void testModifyListGridRecord6() {
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
   * Method under test:
   * {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}
   */
  @Test
  public void testModifyListGridRecord7() {
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
   * Method under test:
   * {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}
   */
  @Test
  public void testModifyListGridRecord8() {
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
}
