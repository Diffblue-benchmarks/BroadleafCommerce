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
package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.broadleafcommerce.openadmin.web.rulebuilder.DataDTOToMVELTranslator;
import org.broadleafcommerce.openadmin.web.rulebuilder.MVELTranslationException;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.DataWrapper;
import org.junit.Test;

public class RuleFieldExtractionUtilityDiffblueTest {
  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <p>
   * Method under test:
   * {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  public void testConvertJsonToDataWrapper() throws JsonProcessingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldExtractionUtility ruleFieldExtractionUtility = new RuleFieldExtractionUtility();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ruleFieldExtractionUtility.convertJsonToDataWrapper(
        (new ObjectMapper()).writeValueAsString("{\"data\":[],\"error\":null,\"rawMvel\":null}")));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>Then return {@link DataWrapper} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  public void testConvertJsonToDataWrapper_thenReturnDataWrapper() throws JsonProcessingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldExtractionUtility ruleFieldExtractionUtility = new RuleFieldExtractionUtility();

    ObjectMapper objectMapper = new ObjectMapper();
    DataWrapper dataWrapper = new DataWrapper();

    // Act and Assert
    assertEquals(dataWrapper,
        ruleFieldExtractionUtility.convertJsonToDataWrapper(objectMapper.writeValueAsString(dataWrapper)));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  public void testConvertJsonToDataWrapper_when42_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new RuleFieldExtractionUtility()).convertJsonToDataWrapper("42"));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>When {@code DataDTODeserializerModule}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  public void testConvertJsonToDataWrapper_whenDataDTODeserializerModule() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new RuleFieldExtractionUtility()).convertJsonToDataWrapper("DataDTODeserializerModule"));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  public void testConvertJsonToDataWrapper_whenEmptyString_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new RuleFieldExtractionUtility()).convertJsonToDataWrapper(""));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>When {@code []}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  public void testConvertJsonToDataWrapper_whenLeftSquareBracketRightSquareBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new RuleFieldExtractionUtility()).convertJsonToDataWrapper("[]"));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  public void testConvertJsonToDataWrapper_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new RuleFieldExtractionUtility()).convertJsonToDataWrapper(null));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>When {@link ObjectMapper#ObjectMapper()} writeValueAsString
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  public void testConvertJsonToDataWrapper_whenObjectMapperWriteValueAsString42() throws JsonProcessingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldExtractionUtility ruleFieldExtractionUtility = new RuleFieldExtractionUtility();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ruleFieldExtractionUtility.convertJsonToDataWrapper((new ObjectMapper()).writeValueAsString("42")));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>When {@link ObjectMapper#ObjectMapper()} writeValueAsString
   * forty-two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  public void testConvertJsonToDataWrapper_whenObjectMapperWriteValueAsStringFortyTwo() throws JsonProcessingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldExtractionUtility ruleFieldExtractionUtility = new RuleFieldExtractionUtility();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ruleFieldExtractionUtility.convertJsonToDataWrapper((new ObjectMapper()).writeValueAsString(42)));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>When {@link ObjectMapper#ObjectMapper()} writeValueAsString
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  public void testConvertJsonToDataWrapper_whenObjectMapperWriteValueAsStringNull() throws JsonProcessingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldExtractionUtility ruleFieldExtractionUtility = new RuleFieldExtractionUtility();

    // Act and Assert
    assertNull(ruleFieldExtractionUtility.convertJsonToDataWrapper((new ObjectMapper()).writeValueAsString(null)));
  }

  /**
   * Test
   * {@link RuleFieldExtractionUtility#convertSimpleMatchRuleJsonToMvel(DataDTOToMVELTranslator, String, String, DataWrapper)}.
   * <ul>
   *   <li>When {@link DataDTOToMVELTranslator}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldExtractionUtility#convertSimpleMatchRuleJsonToMvel(DataDTOToMVELTranslator, String, String, DataWrapper)}
   */
  @Test
  public void testConvertSimpleMatchRuleJsonToMvel_whenDataDTOToMVELTranslator_thenReturnNull()
      throws MVELTranslationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldExtractionUtility ruleFieldExtractionUtility = new RuleFieldExtractionUtility();
    DataDTOToMVELTranslator translator = mock(DataDTOToMVELTranslator.class);

    // Act and Assert
    assertNull(ruleFieldExtractionUtility.convertSimpleMatchRuleJsonToMvel(translator, "Entity Key", "Field Service",
        new DataWrapper()));
  }

  /**
   * Test
   * {@link RuleFieldExtractionUtility#convertSimpleMatchRuleJsonToMvel(DataDTOToMVELTranslator, String, String, DataWrapper)}.
   * <ul>
   *   <li>When {@link DataWrapper} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldExtractionUtility#convertSimpleMatchRuleJsonToMvel(DataDTOToMVELTranslator, String, String, DataWrapper)}
   */
  @Test
  public void testConvertSimpleMatchRuleJsonToMvel_whenDataWrapper_thenReturnNull() throws MVELTranslationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldExtractionUtility ruleFieldExtractionUtility = new RuleFieldExtractionUtility();
    DataDTOToMVELTranslator translator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertNull(ruleFieldExtractionUtility.convertSimpleMatchRuleJsonToMvel(translator, "Entity Key", "Field Service",
        new DataWrapper()));
  }

  /**
   * Test
   * {@link RuleFieldExtractionUtility#convertSimpleMatchRuleJsonToMvel(DataDTOToMVELTranslator, String, String, DataWrapper)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldExtractionUtility#convertSimpleMatchRuleJsonToMvel(DataDTOToMVELTranslator, String, String, DataWrapper)}
   */
  @Test
  public void testConvertSimpleMatchRuleJsonToMvel_whenNull_thenReturnNull() throws MVELTranslationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldExtractionUtility ruleFieldExtractionUtility = new RuleFieldExtractionUtility();

    // Act and Assert
    assertNull(ruleFieldExtractionUtility.convertSimpleMatchRuleJsonToMvel(new DataDTOToMVELTranslator(), "Entity Key",
        "Field Service", null));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#escapeSpecialCharacters(String)}.
   * <p>
   * Method under test:
   * {@link RuleFieldExtractionUtility#escapeSpecialCharacters(String)}
   */
  @Test
  public void testEscapeSpecialCharacters() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("foo", (new RuleFieldExtractionUtility()).escapeSpecialCharacters("foo"));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#unescapeSpecialCharacters(String)}.
   * <p>
   * Method under test:
   * {@link RuleFieldExtractionUtility#unescapeSpecialCharacters(String)}
   */
  @Test
  public void testUnescapeSpecialCharacters() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("foo", (new RuleFieldExtractionUtility()).unescapeSpecialCharacters("foo"));
  }
}
