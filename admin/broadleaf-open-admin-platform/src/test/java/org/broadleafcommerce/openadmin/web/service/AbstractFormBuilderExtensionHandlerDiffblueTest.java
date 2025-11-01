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
package org.broadleafcommerce.openadmin.web.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.service.extension.TranslationsFormBuilderExtensionHandler;
import org.junit.Test;

public class AbstractFormBuilderExtensionHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#modifyUnpopulatedEntityForm(EntityForm)}
   */
  @Test
  public void testModifyUnpopulatedEntityForm() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        translationsFormBuilderExtensionHandler.modifyUnpopulatedEntityForm(new EntityForm()));
  }

  /**
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#modifyUnpopulatedEntityForm(EntityForm)}
   */
  @Test
  public void testModifyUnpopulatedEntityForm2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        (new TranslationsFormBuilderExtensionHandler()).modifyUnpopulatedEntityForm(mock(EntityForm.class)));
  }

  /**
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#modifyPopulatedEntityForm(EntityForm, Entity)}
   */
  @Test
  public void testModifyPopulatedEntityForm() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();
    EntityForm ef = new EntityForm();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        translationsFormBuilderExtensionHandler.modifyPopulatedEntityForm(ef, new Entity()));
  }

  /**
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#modifyPopulatedEntityForm(EntityForm, Entity)}
   */
  @Test
  public void testModifyPopulatedEntityForm2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();
    EntityForm ef = mock(EntityForm.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        translationsFormBuilderExtensionHandler.modifyPopulatedEntityForm(ef, new Entity()));
  }

  /**
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#modifyDetailEntityForm(EntityForm)}
   */
  @Test
  public void testModifyDetailEntityForm() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        translationsFormBuilderExtensionHandler.modifyDetailEntityForm(new EntityForm()));
  }

  /**
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#modifyDetailEntityForm(EntityForm)}
   */
  @Test
  public void testModifyDetailEntityForm2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        (new TranslationsFormBuilderExtensionHandler()).modifyDetailEntityForm(mock(EntityForm.class)));
  }

  /**
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#addAdditionalFormActions(EntityForm)}
   */
  @Test
  public void testAddAdditionalFormActions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        translationsFormBuilderExtensionHandler.addAdditionalFormActions(new EntityForm()));
  }

  /**
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#addAdditionalFormActions(EntityForm)}
   */
  @Test
  public void testAddAdditionalFormActions2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        (new TranslationsFormBuilderExtensionHandler()).addAdditionalFormActions(mock(EntityForm.class)));
  }

  /**
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#modifyListGrid(String, ListGrid)}
   */
  @Test
  public void testModifyListGrid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        translationsFormBuilderExtensionHandler.modifyListGrid("Class Name", new ListGrid()));
  }

  /**
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#modifyListGrid(String, ListGrid)}
   */
  @Test
  public void testModifyListGrid2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        (new TranslationsFormBuilderExtensionHandler()).modifyListGrid("Class Name", mock(ListGrid.class)));
  }

  /**
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#addAdditionalAdornedFormActions(EntityForm)}
   */
  @Test
  public void testAddAdditionalAdornedFormActions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationsFormBuilderExtensionHandler translationsFormBuilderExtensionHandler = new TranslationsFormBuilderExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        translationsFormBuilderExtensionHandler.addAdditionalAdornedFormActions(new EntityForm()));
  }

  /**
   * Method under test:
   * {@link AbstractFormBuilderExtensionHandler#addAdditionalAdornedFormActions(EntityForm)}
   */
  @Test
  public void testAddAdditionalAdornedFormActions2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        (new TranslationsFormBuilderExtensionHandler()).addAdditionalAdornedFormActions(mock(EntityForm.class)));
  }
}
