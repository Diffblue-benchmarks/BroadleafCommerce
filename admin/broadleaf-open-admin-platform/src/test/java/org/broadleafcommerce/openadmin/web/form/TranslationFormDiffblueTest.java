package org.broadleafcommerce.openadmin.web.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TranslationFormDiffblueTest {
  /**
   * Test {@link TranslationForm#getIsRte()}.
   *
   * <ul>
   *   <li>Given {@link TranslationForm} (default constructor) FieldType is {@code Field Type}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationForm#getIsRte()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean TranslationForm.getIsRte()"})
  public void testGetIsRte_givenTranslationFormFieldTypeIsFieldType_thenReturnTrue() {
    // Arrange
    TranslationForm translationForm = new TranslationForm();
    translationForm.setCeilingEntity("Ceiling Entity");
    translationForm.setEntityId("42");
    translationForm.setFieldType("Field Type");
    translationForm.setIsRte(true);
    translationForm.setLocaleCode("en");
    translationForm.setPropertyName("Property Name");
    translationForm.setTranslatedValue("42");
    translationForm.setTranslationId(1L);

    // Act and Assert
    assertTrue(translationForm.getIsRte());
  }

  /**
   * Test {@link TranslationForm#getIsRte()}.
   *
   * <ul>
   *   <li>Given {@link TranslationForm} (default constructor) FieldType is {@code HTML_BASIC}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationForm#getIsRte()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean TranslationForm.getIsRte()"})
  public void testGetIsRte_givenTranslationFormFieldTypeIsHtmlBasic_thenReturnTrue() {
    // Arrange
    TranslationForm translationForm = new TranslationForm();
    translationForm.setCeilingEntity("Ceiling Entity");
    translationForm.setEntityId("42");
    translationForm.setFieldType("HTML_BASIC");
    translationForm.setIsRte(true);
    translationForm.setLocaleCode("en");
    translationForm.setPropertyName("Property Name");
    translationForm.setTranslatedValue("42");
    translationForm.setTranslationId(1L);

    // Act and Assert
    assertTrue(translationForm.getIsRte());
  }

  /**
   * Test {@link TranslationForm#getIsRte()}.
   *
   * <ul>
   *   <li>Given {@link TranslationForm} (default constructor) FieldType is {@code HTML}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationForm#getIsRte()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean TranslationForm.getIsRte()"})
  public void testGetIsRte_givenTranslationFormFieldTypeIsHtml_thenReturnTrue() {
    // Arrange
    TranslationForm translationForm = new TranslationForm();
    translationForm.setCeilingEntity("Ceiling Entity");
    translationForm.setEntityId("42");
    translationForm.setFieldType("HTML");
    translationForm.setIsRte(true);
    translationForm.setLocaleCode("en");
    translationForm.setPropertyName("Property Name");
    translationForm.setTranslatedValue("42");
    translationForm.setTranslationId(1L);

    // Act and Assert
    assertTrue(translationForm.getIsRte());
  }

  /**
   * Test {@link TranslationForm#getIsRte()}.
   *
   * <ul>
   *   <li>Given {@link TranslationForm} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationForm#getIsRte()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean TranslationForm.getIsRte()"})
  public void testGetIsRte_givenTranslationForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new TranslationForm().getIsRte());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TranslationForm.<init>()",
    "String TranslationForm.getCeilingEntity()",
    "String TranslationForm.getEntityId()",
    "String TranslationForm.getFieldType()",
    "String TranslationForm.getLocaleCode()",
    "String TranslationForm.getPropertyName()",
    "String TranslationForm.getTranslatedValue()",
    "Long TranslationForm.getTranslationId()",
    "void TranslationForm.setCeilingEntity(String)",
    "void TranslationForm.setEntityId(String)",
    "void TranslationForm.setFieldType(String)",
    "void TranslationForm.setIsRte(Boolean)",
    "void TranslationForm.setLocaleCode(String)",
    "void TranslationForm.setPropertyName(String)",
    "void TranslationForm.setTranslatedValue(String)",
    "void TranslationForm.setTranslationId(Long)"
  })
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

    // Assert
    assertEquals("42", actualEntityId);
    assertEquals("42", actualTranslatedValue);
    assertEquals("Ceiling Entity", actualCeilingEntity);
    assertEquals("Field Type", actualFieldType);
    assertEquals("Property Name", actualPropertyName);
    assertEquals("en", actualLocaleCode);
    assertEquals(1L, actualTranslationForm.getTranslationId().longValue());
  }
}
