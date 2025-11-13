package org.broadleafcommerce.common.i18n.domain;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TranslationImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TranslationImpl}
   *   <li>{@link TranslationImpl#setEntityId(String)}
   *   <li>{@link TranslationImpl#setFieldName(String)}
   *   <li>{@link TranslationImpl#setId(Long)}
   *   <li>{@link TranslationImpl#setLocaleCode(String)}
   *   <li>{@link TranslationImpl#setTranslatedValue(String)}
   *   <li>{@link TranslationImpl#getEntityId()}
   *   <li>{@link TranslationImpl#getFieldName()}
   *   <li>{@link TranslationImpl#getId()}
   *   <li>{@link TranslationImpl#getLocaleCode()}
   *   <li>{@link TranslationImpl#getTranslatedValue()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TranslationImpl.<init>()",
    "String TranslationImpl.getEntityId()",
    "String TranslationImpl.getFieldName()",
    "Long TranslationImpl.getId()",
    "String TranslationImpl.getLocaleCode()",
    "String TranslationImpl.getTranslatedValue()",
    "void TranslationImpl.setEntityId(String)",
    "void TranslationImpl.setFieldName(String)",
    "void TranslationImpl.setId(Long)",
    "void TranslationImpl.setLocaleCode(String)",
    "void TranslationImpl.setTranslatedValue(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    TranslationImpl actualTranslationImpl = new TranslationImpl();
    actualTranslationImpl.setEntityId("42");
    actualTranslationImpl.setFieldName("Field Name");
    actualTranslationImpl.setId(1L);
    actualTranslationImpl.setLocaleCode("en");
    actualTranslationImpl.setTranslatedValue("42");
    String actualEntityId = actualTranslationImpl.getEntityId();
    String actualFieldName = actualTranslationImpl.getFieldName();
    Long actualId = actualTranslationImpl.getId();
    String actualLocaleCode = actualTranslationImpl.getLocaleCode();

    // Assert
    assertEquals("42", actualEntityId);
    assertEquals("42", actualTranslationImpl.getTranslatedValue());
    assertEquals("Field Name", actualFieldName);
    assertEquals("en", actualLocaleCode);
    assertEquals(1L, actualId.longValue());
  }
}
