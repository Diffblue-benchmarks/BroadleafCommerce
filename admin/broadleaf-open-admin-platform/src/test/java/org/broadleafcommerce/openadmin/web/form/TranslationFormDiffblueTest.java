package org.broadleafcommerce.openadmin.web.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TranslationFormDiffblueTest {
  /**
   * Test {@link TranslationForm#getIsRte()}.
   * <ul>
   *   <li>Given {@link TranslationForm} (default constructor) IsRte is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationForm#getIsRte()}
   */
  @Test
  public void testGetIsRte_givenTranslationFormIsRteIsTrue_thenReturnTrue() {
    // Arrange
    TranslationForm translationForm = new TranslationForm();
    translationForm.setIsRte(true);

    // Act and Assert
    assertTrue(translationForm.getIsRte());
  }

  /**
   * Test {@link TranslationForm#getIsRte()}.
   * <ul>
   *   <li>Given {@link TranslationForm} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationForm#getIsRte()}
   */
  @Test
  public void testGetIsRte_givenTranslationForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new TranslationForm()).getIsRte());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TranslationForm}
   *   <li>{@link TranslationForm#setCeilingEntity(String)}
   *   <li>{@link TranslationForm#setEntityId(String)}
   *   <li>{@link TranslationForm#setFieldType(String)}
   *   <li>{@link TranslationForm#setIsRte(Boolean)}
   *   <li>{@link TranslationForm#setLocaleCode(String)}
   *   <li>{@link TranslationForm#setPropertyName(String)}
   *   <li>{@link TranslationForm#setTranslatedValue(String)}
   *   <li>{@link TranslationForm#setTranslationId(Long)}
   *   <li>{@link TranslationForm#getCeilingEntity()}
   *   <li>{@link TranslationForm#getEntityId()}
   *   <li>{@link TranslationForm#getFieldType()}
   *   <li>{@link TranslationForm#getLocaleCode()}
   *   <li>{@link TranslationForm#getPropertyName()}
   *   <li>{@link TranslationForm#getTranslatedValue()}
   *   <li>{@link TranslationForm#getTranslationId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    TranslationForm actualTranslationForm = new TranslationForm();
    actualTranslationForm.setCeilingEntity("Ceiling Entity");
    actualTranslationForm.setEntityId("42");
    actualTranslationForm.setFieldType("Field Type");
    actualTranslationForm.setIsRte(true);
    actualTranslationForm.setLocaleCode("en");
    actualTranslationForm.setPropertyName("Property Name");
    actualTranslationForm.setTranslatedValue("42");
    actualTranslationForm.setTranslationId(1L);
    String actualCeilingEntity = actualTranslationForm.getCeilingEntity();
    String actualEntityId = actualTranslationForm.getEntityId();
    String actualFieldType = actualTranslationForm.getFieldType();
    String actualLocaleCode = actualTranslationForm.getLocaleCode();
    String actualPropertyName = actualTranslationForm.getPropertyName();
    String actualTranslatedValue = actualTranslationForm.getTranslatedValue();

    // Assert that nothing has changed
    assertEquals("42", actualEntityId);
    assertEquals("42", actualTranslatedValue);
    assertEquals("Ceiling Entity", actualCeilingEntity);
    assertEquals("Field Type", actualFieldType);
    assertEquals("Property Name", actualPropertyName);
    assertEquals("en", actualLocaleCode);
    assertEquals(1L, actualTranslationForm.getTranslationId().longValue());
  }
}
