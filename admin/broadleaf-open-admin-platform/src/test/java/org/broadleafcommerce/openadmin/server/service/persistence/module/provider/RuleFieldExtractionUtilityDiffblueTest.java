package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.broadleafcommerce.openadmin.web.rulebuilder.DataDTOToMVELTranslator;
import org.broadleafcommerce.openadmin.web.rulebuilder.MVELToDataWrapperTranslator;
import org.broadleafcommerce.openadmin.web.rulebuilder.MVELTranslationException;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.DataDTO;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.DataWrapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class RuleFieldExtractionUtilityDiffblueTest {
  @Autowired
  private RuleFieldExtractionUtility ruleFieldExtractionUtility;

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
   * <p>
   * Method under test:
   * {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConvertJsonToDataWrapper2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass882 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldExtractionUtility ruleFieldExtractionUtility;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new RuleFieldExtractionUtility()).convertJsonToDataWrapper("[]");
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
   * <p>
   * Method under test:
   * {@link RuleFieldExtractionUtility#convertSimpleMatchRuleJsonToMvel(DataDTOToMVELTranslator, String, String, DataWrapper)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConvertSimpleMatchRuleJsonToMvel() throws MVELTranslationException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1039 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldExtractionUtility ruleFieldExtractionUtility;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleFieldExtractionUtility ruleFieldExtractionUtility2 = new RuleFieldExtractionUtility();
    DataDTOToMVELTranslator translator = new DataDTOToMVELTranslator();

    // Act
    ruleFieldExtractionUtility2.convertSimpleMatchRuleJsonToMvel(translator, "Entity Key", "Field Service",
        new DataWrapper());
  }

  /**
   * Test
   * {@link RuleFieldExtractionUtility#convertSimpleMatchRuleJsonToMvel(DataDTOToMVELTranslator, String, String, DataWrapper)}.
   * <ul>
   *   <li>Then calls {@link DataWrapper#getData()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldExtractionUtility#convertSimpleMatchRuleJsonToMvel(DataDTOToMVELTranslator, String, String, DataWrapper)}
   */
  @Test
  public void testConvertSimpleMatchRuleJsonToMvel_thenCallsGetData() throws MVELTranslationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldExtractionUtility ruleFieldExtractionUtility = new RuleFieldExtractionUtility();
    DataDTOToMVELTranslator translator = new DataDTOToMVELTranslator();
    DataWrapper dw = mock(DataWrapper.class);
    when(dw.getData()).thenThrow(new RuntimeException("foo"));

    // Act
    ruleFieldExtractionUtility.convertSimpleMatchRuleJsonToMvel(translator, "Entity Key", "Field Service", dw);

    // Assert
    verify(dw).getData();
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
   * Test
   * {@link RuleFieldExtractionUtility#convertDTOToMvelString(DataDTOToMVELTranslator, String, DataDTO, String)}.
   * <p>
   * Method under test:
   * {@link RuleFieldExtractionUtility#convertDTOToMvelString(DataDTOToMVELTranslator, String, DataDTO, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConvertDTOToMvelString() throws MVELTranslationException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass801 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldExtractionUtility ruleFieldExtractionUtility;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleFieldExtractionUtility ruleFieldExtractionUtility2 = new RuleFieldExtractionUtility();
    DataDTOToMVELTranslator translator = new DataDTOToMVELTranslator();

    DataDTO dto = new DataDTO();
    dto.setCondition("Condition");
    dto.setContainedPk(1L);
    dto.setCreatedFromSubGroup(true);
    dto.setPk(1L);
    dto.setPreviousContainedPk(1L);
    dto.setPreviousPk(1L);
    dto.setQuantity(1);
    dto.setRules(new ArrayList<>());

    // Act
    ruleFieldExtractionUtility2.convertDTOToMvelString(translator, "Entity Key", dto, "Field Service");
  }

  /**
   * Test
   * {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)}.
   * <p>
   * Method under test:
   * {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConvertSimpleRuleToJson() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1057 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldExtractionUtility ruleFieldExtractionUtility;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleFieldExtractionUtility ruleFieldExtractionUtility2 = new RuleFieldExtractionUtility();
    MVELToDataWrapperTranslator translator = new MVELToDataWrapperTranslator();

    // Act
    ruleFieldExtractionUtility2.convertSimpleRuleToJson(translator, new ObjectMapper(), "Match Rule", "Json Prop",
        "Field Service");
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
   * Test {@link RuleFieldExtractionUtility#escapeSpecialCharacters(String)}.
   * <p>
   * Method under test:
   * {@link RuleFieldExtractionUtility#escapeSpecialCharacters(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEscapeSpecialCharacters2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1123 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldExtractionUtility ruleFieldExtractionUtility;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new RuleFieldExtractionUtility()).escapeSpecialCharacters("foo");
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

  /**
   * Test {@link RuleFieldExtractionUtility#unescapeSpecialCharacters(String)}.
   * <p>
   * Method under test:
   * {@link RuleFieldExtractionUtility#unescapeSpecialCharacters(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUnescapeSpecialCharacters2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1279 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.RuleFieldExtractionUtility ruleFieldExtractionUtility;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new RuleFieldExtractionUtility()).unescapeSpecialCharacters("foo");
  }
}
