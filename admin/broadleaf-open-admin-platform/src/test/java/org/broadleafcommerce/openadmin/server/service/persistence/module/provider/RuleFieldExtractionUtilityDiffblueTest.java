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
   * Method under test:
   * {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  public void testConvertJsonToDataWrapper() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new RuleFieldExtractionUtility()).convertJsonToDataWrapper("[]"));
    assertThrows(RuntimeException.class,
        () -> (new RuleFieldExtractionUtility()).convertJsonToDataWrapper("DataDTODeserializerModule"));
    assertNull((new RuleFieldExtractionUtility()).convertJsonToDataWrapper(null));
    assertThrows(RuntimeException.class, () -> (new RuleFieldExtractionUtility()).convertJsonToDataWrapper("42"));
    assertThrows(RuntimeException.class, () -> (new RuleFieldExtractionUtility()).convertJsonToDataWrapper(""));
  }

  /**
   * Method under test:
   * {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  public void testConvertJsonToDataWrapper2() throws JsonProcessingException {
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
   * Method under test:
   * {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  public void testConvertJsonToDataWrapper3() throws JsonProcessingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldExtractionUtility ruleFieldExtractionUtility = new RuleFieldExtractionUtility();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ruleFieldExtractionUtility.convertJsonToDataWrapper((new ObjectMapper()).writeValueAsString(42)));
  }

  /**
   * Method under test:
   * {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  public void testConvertJsonToDataWrapper4() throws JsonProcessingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldExtractionUtility ruleFieldExtractionUtility = new RuleFieldExtractionUtility();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ruleFieldExtractionUtility.convertJsonToDataWrapper((new ObjectMapper()).writeValueAsString("42")));
  }

  /**
   * Method under test:
   * {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  public void testConvertJsonToDataWrapper5() throws JsonProcessingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldExtractionUtility ruleFieldExtractionUtility = new RuleFieldExtractionUtility();

    // Act and Assert
    assertNull(ruleFieldExtractionUtility.convertJsonToDataWrapper((new ObjectMapper()).writeValueAsString(null)));
  }

  /**
   * Method under test:
   * {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  public void testConvertJsonToDataWrapper6() throws JsonProcessingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldExtractionUtility ruleFieldExtractionUtility = new RuleFieldExtractionUtility();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ruleFieldExtractionUtility.convertJsonToDataWrapper(
        (new ObjectMapper()).writeValueAsString("{\"data\":[],\"error\":null,\"rawMvel\":null}")));
  }

  /**
   * Method under test:
   * {@link RuleFieldExtractionUtility#convertSimpleMatchRuleJsonToMvel(DataDTOToMVELTranslator, String, String, DataWrapper)}
   */
  @Test
  public void testConvertSimpleMatchRuleJsonToMvel() throws MVELTranslationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldExtractionUtility ruleFieldExtractionUtility = new RuleFieldExtractionUtility();
    DataDTOToMVELTranslator translator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertNull(ruleFieldExtractionUtility.convertSimpleMatchRuleJsonToMvel(translator, "Entity Key", "Field Service",
        new DataWrapper()));
  }

  /**
   * Method under test:
   * {@link RuleFieldExtractionUtility#convertSimpleMatchRuleJsonToMvel(DataDTOToMVELTranslator, String, String, DataWrapper)}
   */
  @Test
  public void testConvertSimpleMatchRuleJsonToMvel2() throws MVELTranslationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldExtractionUtility ruleFieldExtractionUtility = new RuleFieldExtractionUtility();
    DataDTOToMVELTranslator translator = mock(DataDTOToMVELTranslator.class);

    // Act and Assert
    assertNull(ruleFieldExtractionUtility.convertSimpleMatchRuleJsonToMvel(translator, "Entity Key", "Field Service",
        new DataWrapper()));
  }

  /**
   * Method under test:
   * {@link RuleFieldExtractionUtility#convertSimpleMatchRuleJsonToMvel(DataDTOToMVELTranslator, String, String, DataWrapper)}
   */
  @Test
  public void testConvertSimpleMatchRuleJsonToMvel3() throws MVELTranslationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldExtractionUtility ruleFieldExtractionUtility = new RuleFieldExtractionUtility();

    // Act and Assert
    assertNull(ruleFieldExtractionUtility.convertSimpleMatchRuleJsonToMvel(new DataDTOToMVELTranslator(), "Entity Key",
        "Field Service", null));
  }

  /**
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
