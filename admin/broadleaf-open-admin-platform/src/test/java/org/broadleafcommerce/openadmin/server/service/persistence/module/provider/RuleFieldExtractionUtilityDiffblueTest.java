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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTypeResolverBuilder;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.CacheProvider;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import com.fasterxml.jackson.databind.util.LRUMap;
import java.util.ArrayList;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.web.rulebuilder.DataDTOToMVELTranslator;
import org.broadleafcommerce.openadmin.web.rulebuilder.MVELToDataWrapperTranslator;
import org.broadleafcommerce.openadmin.web.rulebuilder.MVELTranslationException;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.DataDTO;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.DataWrapper;
import org.broadleafcommerce.openadmin.web.rulebuilder.service.RuleBuilderFieldService;
import org.broadleafcommerce.openadmin.web.rulebuilder.service.RuleBuilderFieldServiceFactory;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RuleFieldExtractionUtilityDiffblueTest {
  @Mock
  private RuleBuilderFieldServiceFactory ruleBuilderFieldServiceFactory;

  @InjectMocks
  private RuleFieldExtractionUtility ruleFieldExtractionUtility;

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper RuleFieldExtractionUtility.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper() throws JsonProcessingException {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> ruleFieldExtractionUtility
        .convertJsonToDataWrapper(JsonMapper.builder().findAndAddModules().build().writeValueAsString(42)));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper RuleFieldExtractionUtility.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper2() throws JsonProcessingException {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> ruleFieldExtractionUtility
        .convertJsonToDataWrapper(JsonMapper.builder().findAndAddModules().build().writeValueAsString("42")));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper RuleFieldExtractionUtility.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper3() throws JsonProcessingException {
    // Arrange, Act and Assert
    assertNull(ruleFieldExtractionUtility
        .convertJsonToDataWrapper(JsonMapper.builder().findAndAddModules().build().writeValueAsString(null)));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper RuleFieldExtractionUtility.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper4() throws JsonProcessingException {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> ruleFieldExtractionUtility.convertJsonToDataWrapper(JsonMapper.builder()
            .findAndAddModules()
            .build()
            .writeValueAsString("{\"data\":[],\"error\":null,\"rawMvel\":null}")));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper RuleFieldExtractionUtility.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper5() throws JsonProcessingException {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> ruleFieldExtractionUtility
        .convertJsonToDataWrapper(JsonMapper.builder().findAndAddModules().build().writeValueAsString("")));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>Then return Data first Condition is {@code Condition}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper RuleFieldExtractionUtility.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_thenReturnDataFirstConditionIsCondition() throws JsonProcessingException {
    // Arrange
    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition("Condition");
    dataDTO.setContainedPk(1L);
    dataDTO.setCreatedFromSubGroup(true);
    dataDTO.setPk(1L);
    dataDTO.setPreviousContainedPk(1L);
    dataDTO.setPreviousPk(1L);
    dataDTO.setQuantity(1);
    dataDTO.setRules(new ArrayList<>());

    ArrayList<DataDTO> data = new ArrayList<>();
    data.add(dataDTO);

    DataWrapper dataWrapper = new DataWrapper();
    dataWrapper.setData(data);

    // Act and Assert
    ArrayList<DataDTO> data2 = ruleFieldExtractionUtility
        .convertJsonToDataWrapper(JsonMapper.builder().findAndAddModules().build().writeValueAsString(dataWrapper))
        .getData();
    assertEquals(1, data2.size());
    DataDTO getResult = data2.get(0);
    assertEquals("Condition", getResult.getCondition());
    assertEquals(1, getResult.getQuantity().intValue());
    assertEquals(1L, getResult.getContainedPk().longValue());
    assertEquals(1L, getResult.getPk().longValue());
    assertEquals(1L, getResult.getPreviousContainedPk().longValue());
    assertEquals(1L, getResult.getPreviousPk().longValue());
    assertTrue(getResult.getRules().isEmpty());
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>Then return Data first Condition is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper RuleFieldExtractionUtility.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_thenReturnDataFirstConditionIsNull() throws JsonProcessingException {
    // Arrange
    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition(null);
    dataDTO.setContainedPk(1L);
    dataDTO.setCreatedFromSubGroup(true);
    dataDTO.setPk(1L);
    dataDTO.setPreviousContainedPk(1L);
    dataDTO.setPreviousPk(1L);
    dataDTO.setQuantity(1);
    dataDTO.setRules(new ArrayList<>());

    ArrayList<DataDTO> data = new ArrayList<>();
    data.add(dataDTO);

    DataWrapper dataWrapper = new DataWrapper();
    dataWrapper.setData(data);

    // Act and Assert
    ArrayList<DataDTO> data2 = ruleFieldExtractionUtility
        .convertJsonToDataWrapper(JsonMapper.builder().findAndAddModules().build().writeValueAsString(dataWrapper))
        .getData();
    assertEquals(1, data2.size());
    DataDTO getResult = data2.get(0);
    assertNull(getResult.getCondition());
    assertEquals(1, getResult.getQuantity().intValue());
    assertEquals(1L, getResult.getContainedPk().longValue());
    assertEquals(1L, getResult.getPk().longValue());
    assertEquals(1L, getResult.getPreviousContainedPk().longValue());
    assertEquals(1L, getResult.getPreviousPk().longValue());
    assertTrue(getResult.getRules().isEmpty());
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>Then return Data first ContainedPk longValue is {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper RuleFieldExtractionUtility.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_thenReturnDataFirstContainedPkLongValueIsMax_value()
      throws JsonProcessingException {
    // Arrange
    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition("Condition");
    dataDTO.setContainedPk(Long.MAX_VALUE);
    dataDTO.setCreatedFromSubGroup(true);
    dataDTO.setPk(1L);
    dataDTO.setPreviousContainedPk(1L);
    dataDTO.setPreviousPk(1L);
    dataDTO.setQuantity(1);
    dataDTO.setRules(new ArrayList<>());

    ArrayList<DataDTO> data = new ArrayList<>();
    data.add(dataDTO);

    DataWrapper dataWrapper = new DataWrapper();
    dataWrapper.setData(data);

    // Act and Assert
    ArrayList<DataDTO> data2 = ruleFieldExtractionUtility
        .convertJsonToDataWrapper(JsonMapper.builder().findAndAddModules().build().writeValueAsString(dataWrapper))
        .getData();
    assertEquals(1, data2.size());
    DataDTO getResult = data2.get(0);
    assertEquals("Condition", getResult.getCondition());
    assertEquals(1, getResult.getQuantity().intValue());
    assertEquals(1L, getResult.getPk().longValue());
    assertEquals(1L, getResult.getPreviousContainedPk().longValue());
    assertEquals(1L, getResult.getPreviousPk().longValue());
    assertTrue(getResult.getRules().isEmpty());
    assertEquals(Long.MAX_VALUE, getResult.getContainedPk().longValue());
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>Then return Data first Rules size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper RuleFieldExtractionUtility.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_thenReturnDataFirstRulesSizeIsOne() throws JsonProcessingException {
    // Arrange
    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition("DataDTODeserializerModule");
    dataDTO.setContainedPk(1L);
    dataDTO.setCreatedFromSubGroup(true);
    dataDTO.setPk(1L);
    dataDTO.setPreviousContainedPk(1L);
    dataDTO.setPreviousPk(1L);
    dataDTO.setQuantity(1);
    dataDTO.setRules(new ArrayList<>());

    ArrayList<DataDTO> rules = new ArrayList<>();
    rules.add(dataDTO);

    DataDTO dataDTO2 = new DataDTO();
    dataDTO2.setCondition("Condition");
    dataDTO2.setContainedPk(1L);
    dataDTO2.setCreatedFromSubGroup(true);
    dataDTO2.setPk(1L);
    dataDTO2.setPreviousContainedPk(1L);
    dataDTO2.setPreviousPk(1L);
    dataDTO2.setQuantity(1);
    dataDTO2.setRules(rules);

    ArrayList<DataDTO> data = new ArrayList<>();
    data.add(dataDTO2);

    DataWrapper dataWrapper = new DataWrapper();
    dataWrapper.setData(data);

    // Act and Assert
    ArrayList<DataDTO> data2 = ruleFieldExtractionUtility
        .convertJsonToDataWrapper(JsonMapper.builder().findAndAddModules().build().writeValueAsString(dataWrapper))
        .getData();
    assertEquals(1, data2.size());
    ArrayList<DataDTO> rules2 = data2.get(0).getRules();
    assertEquals(1, rules2.size());
    assertEquals(dataDTO, rules2.get(0));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>Then return Data first Rules size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper RuleFieldExtractionUtility.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_thenReturnDataFirstRulesSizeIsOne2() throws JsonProcessingException {
    // Arrange
    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition("DataDTODeserializerModule");
    dataDTO.setContainedPk(Long.MAX_VALUE);
    dataDTO.setCreatedFromSubGroup(true);
    dataDTO.setPk(1L);
    dataDTO.setPreviousContainedPk(1L);
    dataDTO.setPreviousPk(1L);
    dataDTO.setQuantity(1);
    dataDTO.setRules(new ArrayList<>());

    ArrayList<DataDTO> rules = new ArrayList<>();
    rules.add(dataDTO);

    DataDTO dataDTO2 = new DataDTO();
    dataDTO2.setCondition("Condition");
    dataDTO2.setContainedPk(1L);
    dataDTO2.setCreatedFromSubGroup(true);
    dataDTO2.setPk(1L);
    dataDTO2.setPreviousContainedPk(1L);
    dataDTO2.setPreviousPk(1L);
    dataDTO2.setQuantity(1);
    dataDTO2.setRules(rules);

    ArrayList<DataDTO> data = new ArrayList<>();
    data.add(dataDTO2);

    DataWrapper dataWrapper = new DataWrapper();
    dataWrapper.setData(data);

    // Act and Assert
    ArrayList<DataDTO> data2 = ruleFieldExtractionUtility
        .convertJsonToDataWrapper(JsonMapper.builder().findAndAddModules().build().writeValueAsString(dataWrapper))
        .getData();
    assertEquals(1, data2.size());
    ArrayList<DataDTO> rules2 = data2.get(0).getRules();
    assertEquals(1, rules2.size());
    assertEquals(dataDTO, rules2.get(0));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>Then return Data size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper RuleFieldExtractionUtility.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_thenReturnDataSizeIsTwo() throws JsonProcessingException {
    // Arrange
    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition("Condition");
    dataDTO.setContainedPk(1L);
    dataDTO.setCreatedFromSubGroup(true);
    dataDTO.setPk(1L);
    dataDTO.setPreviousContainedPk(1L);
    dataDTO.setPreviousPk(1L);
    dataDTO.setQuantity(1);
    dataDTO.setRules(new ArrayList<>());

    DataDTO dataDTO2 = new DataDTO();
    dataDTO2.setCondition("[]");
    dataDTO2.setContainedPk(0L);
    dataDTO2.setCreatedFromSubGroup(false);
    dataDTO2.setPk(0L);
    dataDTO2.setPreviousContainedPk(0L);
    dataDTO2.setPreviousPk(0L);
    dataDTO2.setQuantity(0);
    dataDTO2.setRules(new ArrayList<>());

    ArrayList<DataDTO> data = new ArrayList<>();
    data.add(dataDTO2);
    data.add(dataDTO);

    DataWrapper dataWrapper = new DataWrapper();
    dataWrapper.setData(data);

    // Act and Assert
    ArrayList<DataDTO> data2 = ruleFieldExtractionUtility
        .convertJsonToDataWrapper(JsonMapper.builder().findAndAddModules().build().writeValueAsString(dataWrapper))
        .getData();
    assertEquals(2, data2.size());
    DataDTO getResult = data2.get(0);
    assertEquals("[]", getResult.getCondition());
    assertEquals(0, getResult.getQuantity().intValue());
    assertEquals(0L, getResult.getContainedPk().longValue());
    assertEquals(0L, getResult.getPk().longValue());
    assertEquals(0L, getResult.getPreviousContainedPk().longValue());
    assertEquals(0L, getResult.getPreviousPk().longValue());
    assertEquals(dataDTO, data2.get(1));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>Then return {@link DataWrapper} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper RuleFieldExtractionUtility.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_thenReturnDataWrapper() throws JsonProcessingException {
    // Arrange
    JsonMapper buildResult = JsonMapper.builder().findAndAddModules().build();
    DataWrapper dataWrapper = new DataWrapper();

    // Act and Assert
    assertEquals(dataWrapper,
        ruleFieldExtractionUtility.convertJsonToDataWrapper(buildResult.writeValueAsString(dataWrapper)));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper RuleFieldExtractionUtility.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_when42_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> ruleFieldExtractionUtility.convertJsonToDataWrapper("42"));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>When {@code DataDTODeserializerModule}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper RuleFieldExtractionUtility.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_whenDataDTODeserializerModule() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> ruleFieldExtractionUtility.convertJsonToDataWrapper("DataDTODeserializerModule"));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>When {@code []DataDTODeserializerModule}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper RuleFieldExtractionUtility.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_whenDataDTODeserializerModule2() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> ruleFieldExtractionUtility.convertJsonToDataWrapper("[]DataDTODeserializerModule"));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper RuleFieldExtractionUtility.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_whenEmptyString_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> ruleFieldExtractionUtility.convertJsonToDataWrapper(""));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>When {@code []}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper RuleFieldExtractionUtility.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_whenLeftSquareBracketRightSquareBracket() {
    // Arrange, Act and Assert
    assertNull(ruleFieldExtractionUtility.convertJsonToDataWrapper("[]"));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper RuleFieldExtractionUtility.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ruleFieldExtractionUtility.convertJsonToDataWrapper(null));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertSimpleMatchRuleJsonToMvel(DataDTOToMVELTranslator, String, String, DataWrapper)}.
   * <ul>
   *   <li>When {@link DataWrapper} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertSimpleMatchRuleJsonToMvel(DataDTOToMVELTranslator, String, String, DataWrapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String RuleFieldExtractionUtility.convertSimpleMatchRuleJsonToMvel(DataDTOToMVELTranslator, String, String, DataWrapper)"})
  public void testConvertSimpleMatchRuleJsonToMvel_whenDataWrapper_thenReturnNull() throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator translator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertNull(ruleFieldExtractionUtility.convertSimpleMatchRuleJsonToMvel(translator, "Entity Key", "Field Service",
        new DataWrapper()));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertSimpleMatchRuleJsonToMvel(DataDTOToMVELTranslator, String, String, DataWrapper)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertSimpleMatchRuleJsonToMvel(DataDTOToMVELTranslator, String, String, DataWrapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String RuleFieldExtractionUtility.convertSimpleMatchRuleJsonToMvel(DataDTOToMVELTranslator, String, String, DataWrapper)"})
  public void testConvertSimpleMatchRuleJsonToMvel_whenNull_thenReturnNull() throws MVELTranslationException {
    // Arrange, Act and Assert
    assertNull(ruleFieldExtractionUtility.convertSimpleMatchRuleJsonToMvel(new DataDTOToMVELTranslator(), "Entity Key",
        "Field Service", null));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertDTOToMvelString(DataDTOToMVELTranslator, String, DataDTO, String)}.
   * <ul>
   *   <li>Given {@code Create MVEL}.</li>
   *   <li>Then return {@code Create MVEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertDTOToMvelString(DataDTOToMVELTranslator, String, DataDTO, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String RuleFieldExtractionUtility.convertDTOToMvelString(DataDTOToMVELTranslator, String, DataDTO, String)"})
  public void testConvertDTOToMvelString_givenCreateMvel_thenReturnCreateMvel() throws MVELTranslationException {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));
    DataDTOToMVELTranslator translator = mock(DataDTOToMVELTranslator.class);
    when(translator.createMVEL(Mockito.<String>any(), Mockito.<DataDTO>any(), Mockito.<RuleBuilderFieldService>any()))
        .thenReturn("Create MVEL");

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
    String actualConvertDTOToMvelStringResult = ruleFieldExtractionUtility.convertDTOToMvelString(translator,
        "Entity Key", dto, "Field Service");

    // Assert
    verify(translator).createMVEL(eq("Entity Key"), isA(DataDTO.class), isA(RuleBuilderFieldService.class));
    verify(ruleBuilderFieldServiceFactory).createInstance(eq("Field Service"));
    assertEquals("Create MVEL", actualConvertDTOToMvelStringResult);
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)}.
   * <ul>
   *   <li>Given {@link DataDTO} (default constructor) Condition is {@code matchRule}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Property RuleFieldExtractionUtility.convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)"})
  public void testConvertSimpleRuleToJson_givenDataDTOConditionIsMatchRule() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));

    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition("matchRule");
    dataDTO.setContainedPk(1L);
    dataDTO.setCreatedFromSubGroup(true);
    dataDTO.setPk(1L);
    dataDTO.setPreviousContainedPk(1L);
    dataDTO.setPreviousPk(1L);
    dataDTO.setQuantity(1);
    dataDTO.setRules(new ArrayList<>());

    ArrayList<DataDTO> dataDTOList = new ArrayList<>();
    dataDTOList.add(dataDTO);
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("An error occurred");
    when(dataWrapper.getRawMvel()).thenReturn("Raw Mvel");
    when(dataWrapper.getData()).thenReturn(dataDTOList);
    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(Mockito.<Entity[]>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<RuleBuilderFieldService>any())).thenReturn(dataWrapper);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ruleFieldExtractionUtility.convertSimpleRuleToJson(translator,
        JsonMapper.builder().findAndAddModules().build(), "Match Rule", "Json Prop", "Field Service"));
    verify(translator).createRuleData(isA(Entity[].class), eq("matchRule"), isNull(), isNull(),
        isA(RuleBuilderFieldService.class));
    verify(dataWrapper).getData();
    verify(dataWrapper).getError();
    verify(dataWrapper).getRawMvel();
    verify(ruleBuilderFieldServiceFactory).createInstance(eq("Field Service"));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)}.
   * <ul>
   *   <li>Given {@link DefaultTypeResolverBuilder#DefaultTypeResolverBuilder(DefaultTyping)} with t is {@code JAVA_LANG_OBJECT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Property RuleFieldExtractionUtility.convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)"})
  public void testConvertSimpleRuleToJson_givenDefaultTypeResolverBuilderWithTIsJavaLangObject() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("An error occurred");
    when(dataWrapper.getRawMvel()).thenReturn("Raw Mvel");
    when(dataWrapper.getData()).thenReturn(new ArrayList<>());
    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(Mockito.<Entity[]>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<RuleBuilderFieldService>any())).thenReturn(dataWrapper);
    CacheProvider cacheProvider = mock(CacheProvider.class);
    when(cacheProvider.forDeserializerCache(Mockito.<DeserializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forSerializerCache(Mockito.<SerializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forTypeFactory()).thenReturn(new LRUMap<>(1, 3));
    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT));
    builderResult.cacheProvider(cacheProvider);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ruleFieldExtractionUtility.convertSimpleRuleToJson(translator,
        builderResult.findAndAddModules().build(), "Match Rule", "Json Prop", "Field Service"));
    verify(cacheProvider).forDeserializerCache(isNull());
    verify(cacheProvider).forSerializerCache(isNull());
    verify(cacheProvider).forTypeFactory();
    verify(translator).createRuleData(isA(Entity[].class), eq("matchRule"), isNull(), isNull(),
        isA(RuleBuilderFieldService.class));
    verify(dataWrapper).getData();
    verify(dataWrapper).getError();
    verify(dataWrapper).getRawMvel();
    verify(ruleBuilderFieldServiceFactory).createInstance(eq("Field Service"));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Property RuleFieldExtractionUtility.convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)"})
  public void testConvertSimpleRuleToJson_givenJavaLangObject() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("An error occurred");
    when(dataWrapper.getRawMvel()).thenReturn("Raw Mvel");
    when(dataWrapper.getData()).thenReturn(new ArrayList<>());
    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(Mockito.<Entity[]>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<RuleBuilderFieldService>any())).thenReturn(dataWrapper);
    Builder builderResult = JsonMapper.builder();
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ruleFieldExtractionUtility.convertSimpleRuleToJson(translator,
        builderResult.findAndAddModules().build(), "Match Rule", "Json Prop", "Field Service"));
    verify(translator).createRuleData(isA(Entity[].class), eq("matchRule"), isNull(), isNull(),
        isA(RuleBuilderFieldService.class));
    verify(dataWrapper).getData();
    verify(dataWrapper).getError();
    verify(dataWrapper).getRawMvel();
    verify(ruleBuilderFieldServiceFactory).createInstance(eq("Field Service"));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When builder defaultLeniency {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Property RuleFieldExtractionUtility.convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)"})
  public void testConvertSimpleRuleToJson_givenTrue_whenBuilderDefaultLeniencyTrue() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("An error occurred");
    when(dataWrapper.getRawMvel()).thenReturn("Raw Mvel");
    when(dataWrapper.getData()).thenReturn(new ArrayList<>());
    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(Mockito.<Entity[]>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<RuleBuilderFieldService>any())).thenReturn(dataWrapper);
    CacheProvider cacheProvider = mock(CacheProvider.class);
    when(cacheProvider.forDeserializerCache(Mockito.<DeserializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forSerializerCache(Mockito.<SerializationConfig>any())).thenReturn(new LRUMap<>(1, 3));
    when(cacheProvider.forTypeFactory()).thenReturn(new LRUMap<>(1, 3));
    Builder builderResult = JsonMapper.builder();
    builderResult.defaultLeniency(true);
    builderResult.cacheProvider(cacheProvider);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ruleFieldExtractionUtility.convertSimpleRuleToJson(translator,
        builderResult.findAndAddModules().build(), "Match Rule", "Json Prop", "Field Service"));
    verify(cacheProvider).forDeserializerCache(isNull());
    verify(cacheProvider).forSerializerCache(isNull());
    verify(cacheProvider).forTypeFactory();
    verify(translator).createRuleData(isA(Entity[].class), eq("matchRule"), isNull(), isNull(),
        isA(RuleBuilderFieldService.class));
    verify(dataWrapper).getData();
    verify(dataWrapper).getError();
    verify(dataWrapper).getRawMvel();
    verify(ruleBuilderFieldServiceFactory).createInstance(eq("Field Service"));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)}.
   * <ul>
   *   <li>Then return RawValue is {@code {"data":[],"error":null,"rawMvel":null}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Property RuleFieldExtractionUtility.convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)"})
  public void testConvertSimpleRuleToJson_thenReturnRawValueIsDataErrorNullRawMvelNull() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));
    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(Mockito.<Entity[]>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<RuleBuilderFieldService>any())).thenReturn(new DataWrapper());

    // Act
    Property actualConvertSimpleRuleToJsonResult = ruleFieldExtractionUtility.convertSimpleRuleToJson(translator,
        JsonMapper.builder().findAndAddModules().build(), "Match Rule", "Json Prop", "Field Service");

    // Assert
    verify(translator).createRuleData(isA(Entity[].class), eq("matchRule"), isNull(), isNull(),
        isA(RuleBuilderFieldService.class));
    verify(ruleBuilderFieldServiceFactory).createInstance(eq("Field Service"));
    assertTrue(actualConvertSimpleRuleToJsonResult.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("Json Prop", actualConvertSimpleRuleToJsonResult.getName());
    assertEquals("{\"data\":[],\"error\":null,\"rawMvel\":null}", actualConvertSimpleRuleToJsonResult.getRawValue());
    assertEquals("{\"data\":[],\"error\":null,\"rawMvel\":null}",
        actualConvertSimpleRuleToJsonResult.getUnHtmlEncodedValue());
    assertEquals("{\"data\":[],\"error\":null,\"rawMvel\":null}", actualConvertSimpleRuleToJsonResult.getValue());
    assertNull(actualConvertSimpleRuleToJsonResult.getDisplayValue());
    assertNull(actualConvertSimpleRuleToJsonResult.getOriginalDisplayValue());
    assertNull(actualConvertSimpleRuleToJsonResult.getOriginalValue());
    assertNull(actualConvertSimpleRuleToJsonResult.getDeployDate());
    assertFalse(actualConvertSimpleRuleToJsonResult.getIsDirty());
    assertFalse(actualConvertSimpleRuleToJsonResult.isAdvancedCollection());
    assertTrue(actualConvertSimpleRuleToJsonResult.getEnabled());
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)}.
   * <ul>
   *   <li>Then return RawValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Property RuleFieldExtractionUtility.convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)"})
  public void testConvertSimpleRuleToJson_thenReturnRawValueIsNull() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));
    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(Mockito.<Entity[]>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<RuleBuilderFieldService>any())).thenReturn(null);

    // Act
    Property actualConvertSimpleRuleToJsonResult = ruleFieldExtractionUtility.convertSimpleRuleToJson(translator,
        JsonMapper.builder().findAndAddModules().build(), "Match Rule", "Json Prop", "Field Service");

    // Assert
    verify(translator).createRuleData(isA(Entity[].class), eq("matchRule"), isNull(), isNull(),
        isA(RuleBuilderFieldService.class));
    verify(ruleBuilderFieldServiceFactory).createInstance(eq("Field Service"));
    assertTrue(actualConvertSimpleRuleToJsonResult.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("Json Prop", actualConvertSimpleRuleToJsonResult.getName());
    assertEquals("null", actualConvertSimpleRuleToJsonResult.getRawValue());
    assertEquals("null", actualConvertSimpleRuleToJsonResult.getUnHtmlEncodedValue());
    assertEquals("null", actualConvertSimpleRuleToJsonResult.getValue());
    assertNull(actualConvertSimpleRuleToJsonResult.getDisplayValue());
    assertNull(actualConvertSimpleRuleToJsonResult.getOriginalDisplayValue());
    assertNull(actualConvertSimpleRuleToJsonResult.getOriginalValue());
    assertNull(actualConvertSimpleRuleToJsonResult.getDeployDate());
    assertFalse(actualConvertSimpleRuleToJsonResult.getIsDirty());
    assertFalse(actualConvertSimpleRuleToJsonResult.isAdvancedCollection());
    assertTrue(actualConvertSimpleRuleToJsonResult.getEnabled());
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Property RuleFieldExtractionUtility.convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)"})
  public void testConvertSimpleRuleToJson_thenThrowRuntimeException() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("An error occurred");
    when(dataWrapper.getRawMvel()).thenReturn("Raw Mvel");
    when(dataWrapper.getData()).thenReturn(new ArrayList<>());
    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(Mockito.<Entity[]>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<RuleBuilderFieldService>any())).thenReturn(dataWrapper);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ruleFieldExtractionUtility.convertSimpleRuleToJson(translator,
        JsonMapper.builder().findAndAddModules().build(), "Match Rule", "Json Prop", "Field Service"));
    verify(translator).createRuleData(isA(Entity[].class), eq("matchRule"), isNull(), isNull(),
        isA(RuleBuilderFieldService.class));
    verify(dataWrapper).getData();
    verify(dataWrapper).getError();
    verify(dataWrapper).getRawMvel();
    verify(ruleBuilderFieldServiceFactory).createInstance(eq("Field Service"));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Property RuleFieldExtractionUtility.convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)"})
  public void testConvertSimpleRuleToJson_whenNull_thenThrowRuntimeException() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("An error occurred");
    when(dataWrapper.getRawMvel()).thenReturn("Raw Mvel");
    when(dataWrapper.getData()).thenReturn(new ArrayList<>());
    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(Mockito.<Entity[]>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<RuleBuilderFieldService>any())).thenReturn(dataWrapper);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ruleFieldExtractionUtility.convertSimpleRuleToJson(translator,
        JsonMapper.builder().findAndAddModules().build(), null, "Json Prop", "Field Service"));
    verify(translator).createRuleData(isA(Entity[].class), eq("matchRule"), isNull(), isNull(),
        isA(RuleBuilderFieldService.class));
    verify(dataWrapper).getData();
    verify(dataWrapper).getError();
    verify(dataWrapper).getRawMvel();
    verify(ruleBuilderFieldServiceFactory).createInstance(eq("Field Service"));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#escapeSpecialCharacters(String)}.
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#escapeSpecialCharacters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String RuleFieldExtractionUtility.escapeSpecialCharacters(String)"})
  public void testEscapeSpecialCharacters() {
    // Arrange, Act and Assert
    assertEquals("foo", ruleFieldExtractionUtility.escapeSpecialCharacters("foo"));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#unescapeSpecialCharacters(String)}.
   * <p>
   * Method under test: {@link RuleFieldExtractionUtility#unescapeSpecialCharacters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String RuleFieldExtractionUtility.unescapeSpecialCharacters(String)"})
  public void testUnescapeSpecialCharacters() {
    // Arrange, Act and Assert
    assertEquals("foo", ruleFieldExtractionUtility.unescapeSpecialCharacters("foo"));
  }
}
