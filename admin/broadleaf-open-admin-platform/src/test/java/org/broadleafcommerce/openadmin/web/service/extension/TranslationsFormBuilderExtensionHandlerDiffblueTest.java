package org.broadleafcommerce.openadmin.web.service.extension;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.web.form.component.ListGridRecord;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.broadleafcommerce.openadmin.web.service.FormBuilderExtensionHandler;
import org.broadleafcommerce.openadmin.web.service.FormBuilderExtensionManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {TranslationsFormBuilderExtensionHandler.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class TranslationsFormBuilderExtensionHandlerDiffblueTest {
  @MockBean(name = "blFormBuilderExtensionManager")
  private FormBuilderExtensionManager formBuilderExtensionManager;

  @Autowired
  private TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler;

  /**
   * Test {@link TranslationsFormBuilderExtensionHandler#init()}.
   *
   * <ul>
   *   <li>Then calls {@link FormBuilderExtensionManager#registerHandler(ExtensionHandler)}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationsFormBuilderExtensionHandler#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TranslationsFormBuilderExtensionHandler.init()"})
  public void testInit_thenCallsRegisterHandler() {
    // Arrange
    when(formBuilderExtensionManager.registerHandler(Mockito.<FormBuilderExtensionHandler>any()))
        .thenReturn(true);
    translationsFormBuilderExtensionHandler.setEnabled(true);

    // Act
    translationsFormBuilderExtensionHandler.init();

    // Assert
    verify(formBuilderExtensionManager).registerHandler(isA(FormBuilderExtensionHandler.class));
  }

  /**
   * Test {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String,
   * ListGridRecord, Entity)}.
   *
   * <p>Method under test: {@link
   * TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TranslationsFormBuilderExtensionHandler.modifyListGridRecord(String, ListGridRecord, Entity)"
  })
  public void testModifyListGridRecord() {
    // Arrange
    ListGridRecord resultRecord = new ListGridRecord();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        translationsFormBuilderExtensionHandler.modifyListGridRecord(
            "org.broadleafcommerce.openadmin.web.service.extension.TranslationsFormBuilderExtensionHandler",
            resultRecord,
            new Entity()));
  }

  /**
   * Test {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String,
   * ListGridRecord, Entity)}.
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) DisplayValue is {@code Field}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TranslationsFormBuilderExtensionHandler.modifyListGridRecord(String, ListGridRecord, Entity)"
  })
  public void testModifyListGridRecord_givenFieldDisplayValueIsField() {
    // Arrange
    Field field = new Field();
    field.setDisplayValue("Field");

    ListGridRecord resultRecord = mock(ListGridRecord.class);
    when(resultRecord.getField(Mockito.<String>any())).thenReturn(field);

    // Act
    ExtensionResultStatusType actualModifyListGridRecordResult =
        translationsFormBuilderExtensionHandler.modifyListGridRecord(
            "org.broadleafcommerce.common.i18n.domain.Translation", resultRecord, new Entity());

    // Assert
    verify(resultRecord).getField("translatedValue");
    assertEquals(ExtensionResultStatusType.HANDLED, actualModifyListGridRecordResult);
  }

  /**
   * Test {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String,
   * ListGridRecord, Entity)}.
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) Value is {@code Field}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TranslationsFormBuilderExtensionHandler.modifyListGridRecord(String, ListGridRecord, Entity)"
  })
  public void testModifyListGridRecord_givenFieldValueIsField() {
    // Arrange
    Field field = new Field();
    field.setValue("Field");

    ListGridRecord resultRecord = mock(ListGridRecord.class);
    when(resultRecord.getField(Mockito.<String>any())).thenReturn(field);

    // Act
    ExtensionResultStatusType actualModifyListGridRecordResult =
        translationsFormBuilderExtensionHandler.modifyListGridRecord(
            "org.broadleafcommerce.common.i18n.domain.Translation", resultRecord, new Entity());

    // Assert
    verify(resultRecord).getField("translatedValue");
    assertEquals(ExtensionResultStatusType.HANDLED, actualModifyListGridRecordResult);
  }

  /**
   * Test {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String,
   * ListGridRecord, Entity)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ListGridRecord} {@link ListGridRecord#getField(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TranslationsFormBuilderExtensionHandler.modifyListGridRecord(String, ListGridRecord, Entity)"
  })
  public void testModifyListGridRecord_givenNull_whenListGridRecordGetFieldReturnNull() {
    // Arrange
    ListGridRecord resultRecord = mock(ListGridRecord.class);
    when(resultRecord.getField(Mockito.<String>any())).thenReturn(null);

    // Act
    ExtensionResultStatusType actualModifyListGridRecordResult =
        translationsFormBuilderExtensionHandler.modifyListGridRecord(
            "org.broadleafcommerce.common.i18n.domain.Translation", resultRecord, new Entity());

    // Assert
    verify(resultRecord).getField("translatedValue");
    assertEquals(ExtensionResultStatusType.HANDLED, actualModifyListGridRecordResult);
  }

  /**
   * Test {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String,
   * ListGridRecord, Entity)}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TranslationsFormBuilderExtensionHandler.modifyListGridRecord(String, ListGridRecord, Entity)"
  })
  public void testModifyListGridRecord_whenClassName_thenReturnNotHandled() {
    // Arrange
    ListGridRecord resultRecord = new ListGridRecord();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        translationsFormBuilderExtensionHandler.modifyListGridRecord(
            "Class Name", resultRecord, new Entity()));
  }

  /**
   * Test {@link TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String,
   * ListGridRecord, Entity)}.
   *
   * <ul>
   *   <li>When {@link ListGridRecord} (default constructor).
   *   <li>Then return {@code HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TranslationsFormBuilderExtensionHandler#modifyListGridRecord(String, ListGridRecord, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType TranslationsFormBuilderExtensionHandler.modifyListGridRecord(String, ListGridRecord, Entity)"
  })
  public void testModifyListGridRecord_whenListGridRecord_thenReturnHandled() {
    // Arrange
    ListGridRecord resultRecord = new ListGridRecord();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.HANDLED,
        translationsFormBuilderExtensionHandler.modifyListGridRecord(
            "org.broadleafcommerce.common.i18n.domain.Translation", resultRecord, new Entity()));
  }
}
