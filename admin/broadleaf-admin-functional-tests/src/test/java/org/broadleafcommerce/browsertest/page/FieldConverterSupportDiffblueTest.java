package org.broadleafcommerce.browsertest.page;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FieldConverterSupportDiffblueTest {
  /**
   * Test {@link FieldConverterSupport#convertFieldName(String)}.
   * <p>
   * Method under test: {@link FieldConverterSupport#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName() {
    // Arrange, Act and Assert
    assertEquals("[name=\"fields\\[\\'org__broadleafcommerce__browsertest__page__FieldConverterSupport\\'\\].value\"]",
        (new FieldConverterSupport()).convertFieldName("org.broadleafcommerce.browsertest.page.FieldConverterSupport"));
  }

  /**
   * Test {@link FieldConverterSupport#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code Field Name}.</li>
   *   <li>Then return {@code [name="fields\[\'Field Name\'\].value"]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldConverterSupport#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenFieldName_thenReturnNameFieldsFieldNameValue() {
    // Arrange, Act and Assert
    assertEquals("[name=\"fields\\[\\'Field Name\\'\\].value\"]",
        (new FieldConverterSupport()).convertFieldName("Field Name"));
  }

  /**
   * Test new {@link FieldConverterSupport} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link FieldConverterSupport}
   */
  @Test
  public void testNewFieldConverterSupport() {
    // Arrange, Act and Assert
    assertEquals("[name=\"fields\\[\\'Field Name\\'\\].value\"]",
        (new FieldConverterSupport()).convertFieldName("Field Name"));
  }
}
