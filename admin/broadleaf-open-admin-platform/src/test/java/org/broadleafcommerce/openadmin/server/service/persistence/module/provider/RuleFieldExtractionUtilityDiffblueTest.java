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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.BeanProperty.Bogus;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.ClassNameIdResolver;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.IOException;
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
  @Mock private RuleBuilderFieldServiceFactory ruleBuilderFieldServiceFactory;

  @InjectMocks private RuleFieldExtractionUtility ruleFieldExtractionUtility;

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   *
   * <ul>
   *   <li>When {@code 42DataDTODeserializerModule}.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWrapper RuleFieldExtractionUtility.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_when42DataDTODeserializerModule() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> ruleFieldExtractionUtility.convertJsonToDataWrapper("42DataDTODeserializerModule"));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWrapper RuleFieldExtractionUtility.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_when42_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> ruleFieldExtractionUtility.convertJsonToDataWrapper("42"));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   *
   * <ul>
   *   <li>When {@code DataDTODeserializerModule}.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWrapper RuleFieldExtractionUtility.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_whenDataDTODeserializerModule() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> ruleFieldExtractionUtility.convertJsonToDataWrapper("DataDTODeserializerModule"));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   *
   * <ul>
   *   <li>When {@code []DataDTODeserializerModule}.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWrapper RuleFieldExtractionUtility.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_whenDataDTODeserializerModule2() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> ruleFieldExtractionUtility.convertJsonToDataWrapper("[]DataDTODeserializerModule"));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWrapper RuleFieldExtractionUtility.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_whenEmptyString_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> ruleFieldExtractionUtility.convertJsonToDataWrapper(""));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   *
   * <ul>
   *   <li>When {@code Json}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWrapper RuleFieldExtractionUtility.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_whenJson_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> ruleFieldExtractionUtility.convertJsonToDataWrapper("Json"));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   *
   * <ul>
   *   <li>When {@code []}.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWrapper RuleFieldExtractionUtility.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_whenLeftSquareBracketRightSquareBracket() {
    // Arrange, Act and Assert
    assertNull(ruleFieldExtractionUtility.convertJsonToDataWrapper("[]"));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldExtractionUtility#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWrapper RuleFieldExtractionUtility.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ruleFieldExtractionUtility.convertJsonToDataWrapper(null));
  }

  /**
   * Test {@link
   * RuleFieldExtractionUtility#convertSimpleMatchRuleJsonToMvel(DataDTOToMVELTranslator, String,
   * String, DataWrapper)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldExtractionUtility#convertSimpleMatchRuleJsonToMvel(DataDTOToMVELTranslator, String,
   * String, DataWrapper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String RuleFieldExtractionUtility.convertSimpleMatchRuleJsonToMvel(DataDTOToMVELTranslator, String, String, DataWrapper)"
  })
  public void testConvertSimpleMatchRuleJsonToMvel_thenThrowRuntimeException()
      throws MVELTranslationException {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenThrow(new RuntimeException());
    DataDTOToMVELTranslator translator = new DataDTOToMVELTranslator();

    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition("Condition");
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

    ArrayList<DataDTO> rules2 = new ArrayList<>();
    rules2.add(dataDTO2);

    DataDTO dataDTO3 = new DataDTO();
    dataDTO3.setContainedPk(1L);
    dataDTO3.setCreatedFromSubGroup(true);
    dataDTO3.setPk(1L);
    dataDTO3.setPreviousContainedPk(1L);
    dataDTO3.setPreviousPk(1L);
    dataDTO3.setQuantity(1);
    dataDTO3.setRules(rules2);
    dataDTO3.setCondition(null);

    ArrayList<DataDTO> data = new ArrayList<>();
    data.add(dataDTO3);

    DataWrapper dw = new DataWrapper();
    dw.setData(data);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ruleFieldExtractionUtility.convertSimpleMatchRuleJsonToMvel(
                translator, "Entity Key", "Field Service", dw));
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
  }

  /**
   * Test {@link
   * RuleFieldExtractionUtility#convertSimpleMatchRuleJsonToMvel(DataDTOToMVELTranslator, String,
   * String, DataWrapper)}.
   *
   * <ul>
   *   <li>When {@link DataWrapper} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldExtractionUtility#convertSimpleMatchRuleJsonToMvel(DataDTOToMVELTranslator, String,
   * String, DataWrapper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String RuleFieldExtractionUtility.convertSimpleMatchRuleJsonToMvel(DataDTOToMVELTranslator, String, String, DataWrapper)"
  })
  public void testConvertSimpleMatchRuleJsonToMvel_whenDataWrapper_thenReturnNull()
      throws MVELTranslationException {
    // Arrange
    DataDTOToMVELTranslator translator = new DataDTOToMVELTranslator();

    // Act and Assert
    assertNull(
        ruleFieldExtractionUtility.convertSimpleMatchRuleJsonToMvel(
            translator, "Entity Key", "Field Service", new DataWrapper()));
  }

  /**
   * Test {@link
   * RuleFieldExtractionUtility#convertSimpleMatchRuleJsonToMvel(DataDTOToMVELTranslator, String,
   * String, DataWrapper)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldExtractionUtility#convertSimpleMatchRuleJsonToMvel(DataDTOToMVELTranslator, String,
   * String, DataWrapper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String RuleFieldExtractionUtility.convertSimpleMatchRuleJsonToMvel(DataDTOToMVELTranslator, String, String, DataWrapper)"
  })
  public void testConvertSimpleMatchRuleJsonToMvel_whenNull_thenReturnNull()
      throws MVELTranslationException {
    // Arrange, Act and Assert
    assertNull(
        ruleFieldExtractionUtility.convertSimpleMatchRuleJsonToMvel(
            new DataDTOToMVELTranslator(), "Entity Key", "Field Service", null));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertDTOToMvelString(DataDTOToMVELTranslator, String,
   * DataDTO, String)}.
   *
   * <ul>
   *   <li>Given {@code Create MVEL}.
   *   <li>Then return {@code Create MVEL}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldExtractionUtility#convertDTOToMvelString(DataDTOToMVELTranslator, String, DataDTO,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String RuleFieldExtractionUtility.convertDTOToMvelString(DataDTOToMVELTranslator, String, DataDTO, String)"
  })
  public void testConvertDTOToMvelString_givenCreateMvel_thenReturnCreateMvel()
      throws MVELTranslationException {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));

    DataDTOToMVELTranslator translator = mock(DataDTOToMVELTranslator.class);
    when(translator.createMVEL(
            Mockito.<String>any(), Mockito.<DataDTO>any(), Mockito.<RuleBuilderFieldService>any()))
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
    String actualConvertDTOToMvelStringResult =
        ruleFieldExtractionUtility.convertDTOToMvelString(
            translator, "Entity Key", dto, "Field Service");

    // Assert
    verify(translator)
        .createMVEL(eq("Entity Key"), isA(DataDTO.class), isA(RuleBuilderFieldService.class));
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
    assertEquals("Create MVEL", actualConvertDTOToMvelStringResult);
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertDTOToMvelString(DataDTOToMVELTranslator, String,
   * DataDTO, String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldExtractionUtility#convertDTOToMvelString(DataDTOToMVELTranslator, String, DataDTO,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String RuleFieldExtractionUtility.convertDTOToMvelString(DataDTOToMVELTranslator, String, DataDTO, String)"
  })
  public void testConvertDTOToMvelString_thenThrowRuntimeException()
      throws MVELTranslationException {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenThrow(new RuntimeException());
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

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ruleFieldExtractionUtility.convertDTOToMvelString(
                translator, "Entity Key", dto, "Field Service"));
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, String, String, String)}.
   *
   * <p>Method under test: {@link
   * RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldExtractionUtility.convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)"
  })
  public void testConvertSimpleRuleToJson() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenThrow(new RuntimeException());
    MVELToDataWrapperTranslator translator = new MVELToDataWrapperTranslator();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ruleFieldExtractionUtility.convertSimpleRuleToJson(
                translator,
                JsonMapper.builder().findAndAddModules().build(),
                "Match Rule",
                "Json Prop",
                "Field Service"));
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, String, String, String)}.
   *
   * <p>Method under test: {@link
   * RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldExtractionUtility.convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)"
  })
  public void testConvertSimpleRuleToJson2() throws JsonMappingException {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));

    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(
            Mockito.<Entity[]>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<RuleBuilderFieldService>any()))
        .thenReturn(mock(DataWrapper.class));

    SerializerFactory f = mock(SerializerFactory.class);
    Class<Object> type = Object.class;
    when(f.createSerializer(Mockito.<SerializerProvider>any(), Mockito.<JavaType>any()))
        .thenReturn(new Default(1, type));
    PlaceholderForType baseType = new PlaceholderForType(1);
    TypeFactory typeFactory = TypeFactory.defaultInstance();

    BasicPolymorphicTypeValidator.Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    ClassNameIdResolver idRes = new ClassNameIdResolver(baseType, typeFactory, ptv);
    AsArrayTypeSerializer asArrayTypeSerializer = new AsArrayTypeSerializer(idRes, new Bogus());
    when(f.createTypeSerializer(Mockito.<SerializationConfig>any(), Mockito.<JavaType>any()))
        .thenReturn(asArrayTypeSerializer);

    Builder builderResult2 = JsonMapper.builder();
    builderResult2.serializerFactory(f);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ruleFieldExtractionUtility.convertSimpleRuleToJson(
                translator,
                builderResult2.findAndAddModules().build(),
                "Match Rule",
                "Json Prop",
                "Field Service"));
    verify(f).createSerializer(isA(SerializerProvider.class), isA(JavaType.class));
    verify(f).createTypeSerializer(isA(SerializationConfig.class), isA(JavaType.class));
    verify(translator)
        .createRuleData(
            isA(Entity[].class),
            eq("matchRule"),
            isNull(),
            isNull(),
            isA(RuleBuilderFieldService.class));
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTO} (default constructor) Condition is {@code matchRule}.
   *   <li>Then calls {@link DataWrapper#getError()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldExtractionUtility.convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)"
  })
  public void testConvertSimpleRuleToJson_givenDataDTOConditionIsMatchRule_thenCallsGetError() {
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
    when(translator.createRuleData(
            Mockito.<Entity[]>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<RuleBuilderFieldService>any()))
        .thenReturn(dataWrapper);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ruleFieldExtractionUtility.convertSimpleRuleToJson(
                translator,
                JsonMapper.builder().findAndAddModules().build(),
                "Match Rule",
                "Json Prop",
                "Field Service"));
    verify(translator)
        .createRuleData(
            isA(Entity[].class),
            eq("matchRule"),
            isNull(),
            isNull(),
            isA(RuleBuilderFieldService.class));
    verify(dataWrapper).getData();
    verify(dataWrapper).getError();
    verify(dataWrapper).getRawMvel();
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link DataWrapper} {@link DataWrapper#getData()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldExtractionUtility.convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)"
  })
  public void testConvertSimpleRuleToJson_givenDataWrapperGetDataThrowRuntimeException() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));

    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getData()).thenThrow(new RuntimeException());

    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(
            Mockito.<Entity[]>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<RuleBuilderFieldService>any()))
        .thenReturn(dataWrapper);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ruleFieldExtractionUtility.convertSimpleRuleToJson(
                translator,
                JsonMapper.builder().findAndAddModules().build(),
                "Match Rule",
                "Json Prop",
                "Field Service"));
    verify(translator)
        .createRuleData(
            isA(Entity[].class),
            eq("matchRule"),
            isNull(),
            isNull(),
            isA(RuleBuilderFieldService.class));
    verify(dataWrapper).getData();
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link DataWrapper} {@link DataWrapper#getData()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldExtractionUtility.convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)"
  })
  public void testConvertSimpleRuleToJson_givenDataWrapperGetDataThrowRuntimeException2() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));

    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getData()).thenThrow(new RuntimeException());

    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(
            Mockito.<Entity[]>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<RuleBuilderFieldService>any()))
        .thenReturn(dataWrapper);

    Builder builderResult = JsonMapper.builder();
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ruleFieldExtractionUtility.convertSimpleRuleToJson(
                translator,
                builderResult.findAndAddModules().build(),
                "Match Rule",
                "Json Prop",
                "Field Service"));
    verify(translator)
        .createRuleData(
            isA(Entity[].class),
            eq("matchRule"),
            isNull(),
            isNull(),
            isA(RuleBuilderFieldService.class));
    verify(dataWrapper).getData();
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link StdKeySerializers.Default} {@link
   *       StdKeySerializers.Default#serializeWithType(Object, JsonGenerator, SerializerProvider,
   *       TypeSerializer)} throw {@link IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldExtractionUtility.convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)"
  })
  public void testConvertSimpleRuleToJson_givenDefaultSerializeWithTypeThrowIOException()
      throws IOException {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));

    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(
            Mockito.<Entity[]>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<RuleBuilderFieldService>any()))
        .thenReturn(mock(DataWrapper.class));

    Default resultDefault = mock(Default.class);
    doThrow(new IOException())
        .when(resultDefault)
        .serializeWithType(
            Mockito.<Object>any(),
            Mockito.<JsonGenerator>any(),
            Mockito.<SerializerProvider>any(),
            Mockito.<TypeSerializer>any());

    SerializerFactory f = mock(SerializerFactory.class);
    when(f.createSerializer(Mockito.<SerializerProvider>any(), Mockito.<JavaType>any()))
        .thenReturn(resultDefault);
    PlaceholderForType baseType = new PlaceholderForType(1);
    TypeFactory typeFactory = TypeFactory.defaultInstance();

    BasicPolymorphicTypeValidator.Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    ClassNameIdResolver idRes = new ClassNameIdResolver(baseType, typeFactory, ptv);
    AsArrayTypeSerializer asArrayTypeSerializer = new AsArrayTypeSerializer(idRes, new Bogus());
    when(f.createTypeSerializer(Mockito.<SerializationConfig>any(), Mockito.<JavaType>any()))
        .thenReturn(asArrayTypeSerializer);

    Builder builderResult2 = JsonMapper.builder();
    builderResult2.serializerFactory(f);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ruleFieldExtractionUtility.convertSimpleRuleToJson(
                translator,
                builderResult2.findAndAddModules().build(),
                "Match Rule",
                "Json Prop",
                "Field Service"));
    verify(resultDefault)
        .serializeWithType(
            isA(Object.class),
            isA(JsonGenerator.class),
            isA(SerializerProvider.class),
            isA(TypeSerializer.class));
    verify(f).createSerializer(isA(SerializerProvider.class), isA(JavaType.class));
    verify(f).createTypeSerializer(isA(SerializationConfig.class), isA(JavaType.class));
    verify(translator)
        .createRuleData(
            isA(Entity[].class),
            eq("matchRule"),
            isNull(),
            isNull(),
            isA(RuleBuilderFieldService.class));
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link StdKeySerializers.Default} {@link
   *       StdKeySerializers.Default#serializeWithType(Object, JsonGenerator, SerializerProvider,
   *       TypeSerializer)} throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldExtractionUtility.convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)"
  })
  public void testConvertSimpleRuleToJson_givenDefaultSerializeWithTypeThrowRuntimeException()
      throws IOException {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));

    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(
            Mockito.<Entity[]>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<RuleBuilderFieldService>any()))
        .thenReturn(mock(DataWrapper.class));

    Default resultDefault = mock(Default.class);
    doThrow(new RuntimeException())
        .when(resultDefault)
        .serializeWithType(
            Mockito.<Object>any(),
            Mockito.<JsonGenerator>any(),
            Mockito.<SerializerProvider>any(),
            Mockito.<TypeSerializer>any());

    SerializerFactory f = mock(SerializerFactory.class);
    when(f.createSerializer(Mockito.<SerializerProvider>any(), Mockito.<JavaType>any()))
        .thenReturn(resultDefault);
    PlaceholderForType baseType = new PlaceholderForType(1);
    TypeFactory typeFactory = TypeFactory.defaultInstance();

    BasicPolymorphicTypeValidator.Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    ClassNameIdResolver idRes = new ClassNameIdResolver(baseType, typeFactory, ptv);
    AsArrayTypeSerializer asArrayTypeSerializer = new AsArrayTypeSerializer(idRes, new Bogus());
    when(f.createTypeSerializer(Mockito.<SerializationConfig>any(), Mockito.<JavaType>any()))
        .thenReturn(asArrayTypeSerializer);

    Builder builderResult2 = JsonMapper.builder();
    builderResult2.serializerFactory(f);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ruleFieldExtractionUtility.convertSimpleRuleToJson(
                translator,
                builderResult2.findAndAddModules().build(),
                "Match Rule",
                "Json Prop",
                "Field Service"));
    verify(resultDefault)
        .serializeWithType(
            isA(Object.class),
            isA(JsonGenerator.class),
            isA(SerializerProvider.class),
            isA(TypeSerializer.class));
    verify(f).createSerializer(isA(SerializerProvider.class), isA(JavaType.class));
    verify(f).createTypeSerializer(isA(SerializationConfig.class), isA(JavaType.class));
    verify(translator)
        .createRuleData(
            isA(Entity[].class),
            eq("matchRule"),
            isNull(),
            isNull(),
            isA(RuleBuilderFieldService.class));
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link Object}.
   *   <li>When builder addMixIn {@link Object} and {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldExtractionUtility.convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)"
  })
  public void testConvertSimpleRuleToJson_givenObject_whenBuilderAddMixInObjectAndObject() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));

    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("An error occurred");
    when(dataWrapper.getRawMvel()).thenReturn("Raw Mvel");
    when(dataWrapper.getData()).thenReturn(new ArrayList<>());

    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(
            Mockito.<Entity[]>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<RuleBuilderFieldService>any()))
        .thenReturn(dataWrapper);

    Builder builderResult = JsonMapper.builder();
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ruleFieldExtractionUtility.convertSimpleRuleToJson(
                translator,
                builderResult.findAndAddModules().build(),
                "Match Rule",
                "Json Prop",
                "Field Service"));
    verify(translator)
        .createRuleData(
            isA(Entity[].class),
            eq("matchRule"),
            isNull(),
            isNull(),
            isA(RuleBuilderFieldService.class));
    verify(dataWrapper).getData();
    verify(dataWrapper).getError();
    verify(dataWrapper).getRawMvel();
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link SerializerFactory} {@link
   *       SerializerFactory#createSerializer(SerializerProvider, JavaType)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldExtractionUtility.convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)"
  })
  public void testConvertSimpleRuleToJson_givenSerializerFactoryCreateSerializerReturnNull()
      throws JsonMappingException {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));

    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(
            Mockito.<Entity[]>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<RuleBuilderFieldService>any()))
        .thenReturn(mock(DataWrapper.class));

    SerializerFactory f = mock(SerializerFactory.class);
    when(f.createSerializer(Mockito.<SerializerProvider>any(), Mockito.<JavaType>any()))
        .thenReturn(null);
    PlaceholderForType baseType = new PlaceholderForType(1);
    TypeFactory typeFactory = TypeFactory.defaultInstance();

    BasicPolymorphicTypeValidator.Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    ClassNameIdResolver idRes = new ClassNameIdResolver(baseType, typeFactory, ptv);
    AsArrayTypeSerializer asArrayTypeSerializer = new AsArrayTypeSerializer(idRes, new Bogus());
    when(f.createTypeSerializer(Mockito.<SerializationConfig>any(), Mockito.<JavaType>any()))
        .thenReturn(asArrayTypeSerializer);

    Builder builderResult2 = JsonMapper.builder();
    builderResult2.serializerFactory(f);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ruleFieldExtractionUtility.convertSimpleRuleToJson(
                translator,
                builderResult2.findAndAddModules().build(),
                "Match Rule",
                "Json Prop",
                "Field Service"));
    verify(f).createSerializer(isA(SerializerProvider.class), isA(JavaType.class));
    verify(f).createTypeSerializer(isA(SerializationConfig.class), isA(JavaType.class));
    verify(translator)
        .createRuleData(
            isA(Entity[].class),
            eq("matchRule"),
            isNull(),
            isNull(),
            isA(RuleBuilderFieldService.class));
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, String, String, String)}.
   *
   * <ul>
   *   <li>Then calls {@link DataWrapper#getError()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldExtractionUtility.convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)"
  })
  public void testConvertSimpleRuleToJson_thenCallsGetError() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));

    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("An error occurred");
    when(dataWrapper.getRawMvel()).thenReturn("Raw Mvel");
    when(dataWrapper.getData()).thenReturn(new ArrayList<>());

    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(
            Mockito.<Entity[]>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<RuleBuilderFieldService>any()))
        .thenReturn(dataWrapper);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ruleFieldExtractionUtility.convertSimpleRuleToJson(
                translator,
                JsonMapper.builder().findAndAddModules().build(),
                "Match Rule",
                "Json Prop",
                "Field Service"));
    verify(translator)
        .createRuleData(
            isA(Entity[].class),
            eq("matchRule"),
            isNull(),
            isNull(),
            isA(RuleBuilderFieldService.class));
    verify(dataWrapper).getData();
    verify(dataWrapper).getError();
    verify(dataWrapper).getRawMvel();
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, String, String, String)}.
   *
   * <ul>
   *   <li>Then return RawValue is a string.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldExtractionUtility.convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)"
  })
  public void testConvertSimpleRuleToJson_thenReturnRawValueIsAString() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));
    MVELToDataWrapperTranslator translator = new MVELToDataWrapperTranslator();

    // Act
    Property actualConvertSimpleRuleToJsonResult =
        ruleFieldExtractionUtility.convertSimpleRuleToJson(
            translator,
            JsonMapper.builder().findAndAddModules().build(),
            "Match Rule",
            "Json Prop",
            "Field Service");

    // Assert
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
    assertTrue(actualConvertSimpleRuleToJsonResult.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("Json Prop", actualConvertSimpleRuleToJsonResult.getName());
    assertEquals(
        "{\"data\":[],\"error\":\"Could not parse the MVEL expression to a compatible form for the rules builder"
            + " (Match Rule)\",\"rawMvel\":\"Match Rule\"}",
        actualConvertSimpleRuleToJsonResult.getRawValue());
    assertEquals(
        "{\"data\":[],\"error\":\"Could not parse the MVEL expression to a compatible form for the rules builder"
            + " (Match Rule)\",\"rawMvel\":\"Match Rule\"}",
        actualConvertSimpleRuleToJsonResult.getUnHtmlEncodedValue());
    assertEquals(
        "{\"data\":[],\"error\":\"Could not parse the MVEL expression to a compatible form for the rules builder"
            + " (Match Rule)\",\"rawMvel\":\"Match Rule\"}",
        actualConvertSimpleRuleToJsonResult.getValue());
    assertNull(actualConvertSimpleRuleToJsonResult.getDisplayValue());
    assertNull(actualConvertSimpleRuleToJsonResult.getOriginalDisplayValue());
    assertNull(actualConvertSimpleRuleToJsonResult.getOriginalValue());
    assertNull(actualConvertSimpleRuleToJsonResult.getDeployDate());
    assertFalse(actualConvertSimpleRuleToJsonResult.getIsDirty());
    assertFalse(actualConvertSimpleRuleToJsonResult.isAdvancedCollection());
    assertTrue(actualConvertSimpleRuleToJsonResult.getEnabled());
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, String, String, String)}.
   *
   * <ul>
   *   <li>Then return RawValue is {@code {"data":[],"error":null,"rawMvel":null}}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldExtractionUtility.convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)"
  })
  public void testConvertSimpleRuleToJson_thenReturnRawValueIsDataErrorNullRawMvelNull() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));

    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(
            Mockito.<Entity[]>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<RuleBuilderFieldService>any()))
        .thenReturn(new DataWrapper());

    // Act
    Property actualConvertSimpleRuleToJsonResult =
        ruleFieldExtractionUtility.convertSimpleRuleToJson(
            translator,
            JsonMapper.builder().findAndAddModules().build(),
            "Match Rule",
            "Json Prop",
            "Field Service");

    // Assert
    verify(translator)
        .createRuleData(
            isA(Entity[].class),
            eq("matchRule"),
            isNull(),
            isNull(),
            isA(RuleBuilderFieldService.class));
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
    assertTrue(actualConvertSimpleRuleToJsonResult.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("Json Prop", actualConvertSimpleRuleToJsonResult.getName());
    assertEquals(
        "{\"data\":[],\"error\":null,\"rawMvel\":null}",
        actualConvertSimpleRuleToJsonResult.getRawValue());
    assertEquals(
        "{\"data\":[],\"error\":null,\"rawMvel\":null}",
        actualConvertSimpleRuleToJsonResult.getUnHtmlEncodedValue());
    assertEquals(
        "{\"data\":[],\"error\":null,\"rawMvel\":null}",
        actualConvertSimpleRuleToJsonResult.getValue());
    assertNull(actualConvertSimpleRuleToJsonResult.getDisplayValue());
    assertNull(actualConvertSimpleRuleToJsonResult.getOriginalDisplayValue());
    assertNull(actualConvertSimpleRuleToJsonResult.getOriginalValue());
    assertNull(actualConvertSimpleRuleToJsonResult.getDeployDate());
    assertFalse(actualConvertSimpleRuleToJsonResult.getIsDirty());
    assertFalse(actualConvertSimpleRuleToJsonResult.isAdvancedCollection());
    assertTrue(actualConvertSimpleRuleToJsonResult.getEnabled());
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, String, String, String)}.
   *
   * <ul>
   *   <li>Then return RawValue is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldExtractionUtility.convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)"
  })
  public void testConvertSimpleRuleToJson_thenReturnRawValueIsEmptyString() throws IOException {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));

    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(
            Mockito.<Entity[]>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<RuleBuilderFieldService>any()))
        .thenReturn(mock(DataWrapper.class));

    Default resultDefault = mock(Default.class);
    doNothing()
        .when(resultDefault)
        .serializeWithType(
            Mockito.<Object>any(),
            Mockito.<JsonGenerator>any(),
            Mockito.<SerializerProvider>any(),
            Mockito.<TypeSerializer>any());

    SerializerFactory f = mock(SerializerFactory.class);
    when(f.createSerializer(Mockito.<SerializerProvider>any(), Mockito.<JavaType>any()))
        .thenReturn(resultDefault);
    PlaceholderForType baseType = new PlaceholderForType(1);
    TypeFactory typeFactory = TypeFactory.defaultInstance();

    BasicPolymorphicTypeValidator.Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    ClassNameIdResolver idRes = new ClassNameIdResolver(baseType, typeFactory, ptv);
    AsArrayTypeSerializer asArrayTypeSerializer = new AsArrayTypeSerializer(idRes, new Bogus());
    when(f.createTypeSerializer(Mockito.<SerializationConfig>any(), Mockito.<JavaType>any()))
        .thenReturn(asArrayTypeSerializer);

    Builder builderResult2 = JsonMapper.builder();
    builderResult2.serializerFactory(f);

    // Act
    Property actualConvertSimpleRuleToJsonResult =
        ruleFieldExtractionUtility.convertSimpleRuleToJson(
            translator,
            builderResult2.findAndAddModules().build(),
            "Match Rule",
            "Json Prop",
            "Field Service");

    // Assert
    verify(resultDefault)
        .serializeWithType(
            isA(Object.class),
            isA(JsonGenerator.class),
            isA(SerializerProvider.class),
            isA(TypeSerializer.class));
    verify(f).createSerializer(isA(SerializerProvider.class), isA(JavaType.class));
    verify(f).createTypeSerializer(isA(SerializationConfig.class), isA(JavaType.class));
    verify(translator)
        .createRuleData(
            isA(Entity[].class),
            eq("matchRule"),
            isNull(),
            isNull(),
            isA(RuleBuilderFieldService.class));
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
    assertTrue(actualConvertSimpleRuleToJsonResult.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("", actualConvertSimpleRuleToJsonResult.getRawValue());
    assertEquals("", actualConvertSimpleRuleToJsonResult.getUnHtmlEncodedValue());
    assertEquals("", actualConvertSimpleRuleToJsonResult.getValue());
    assertEquals("Json Prop", actualConvertSimpleRuleToJsonResult.getName());
    assertNull(actualConvertSimpleRuleToJsonResult.getDisplayValue());
    assertNull(actualConvertSimpleRuleToJsonResult.getOriginalDisplayValue());
    assertNull(actualConvertSimpleRuleToJsonResult.getOriginalValue());
    assertNull(actualConvertSimpleRuleToJsonResult.getDeployDate());
    assertFalse(actualConvertSimpleRuleToJsonResult.getIsDirty());
    assertFalse(actualConvertSimpleRuleToJsonResult.isAdvancedCollection());
    assertTrue(actualConvertSimpleRuleToJsonResult.getEnabled());
  }

  /**
   * Test {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, String, String, String)}.
   *
   * <ul>
   *   <li>Then return RawValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldExtractionUtility.convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)"
  })
  public void testConvertSimpleRuleToJson_thenReturnRawValueIsNull() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));

    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(
            Mockito.<Entity[]>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<RuleBuilderFieldService>any()))
        .thenReturn(null);

    // Act
    Property actualConvertSimpleRuleToJsonResult =
        ruleFieldExtractionUtility.convertSimpleRuleToJson(
            translator,
            JsonMapper.builder().findAndAddModules().build(),
            "Match Rule",
            "Json Prop",
            "Field Service");

    // Assert
    verify(translator)
        .createRuleData(
            isA(Entity[].class),
            eq("matchRule"),
            isNull(),
            isNull(),
            isA(RuleBuilderFieldService.class));
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
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
   * Test {@link RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then calls {@link DataWrapper#getError()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldExtractionUtility#convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldExtractionUtility.convertSimpleRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, String, String, String)"
  })
  public void testConvertSimpleRuleToJson_whenNull_thenCallsGetError() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));

    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("An error occurred");
    when(dataWrapper.getRawMvel()).thenReturn("Raw Mvel");
    when(dataWrapper.getData()).thenReturn(new ArrayList<>());

    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(
            Mockito.<Entity[]>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<RuleBuilderFieldService>any()))
        .thenReturn(dataWrapper);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ruleFieldExtractionUtility.convertSimpleRuleToJson(
                translator,
                JsonMapper.builder().findAndAddModules().build(),
                null,
                "Json Prop",
                "Field Service"));
    verify(translator)
        .createRuleData(
            isA(Entity[].class),
            eq("matchRule"),
            isNull(),
            isNull(),
            isA(RuleBuilderFieldService.class));
    verify(dataWrapper).getData();
    verify(dataWrapper).getError();
    verify(dataWrapper).getRawMvel();
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
  }

  /**
   * Test {@link RuleFieldExtractionUtility#escapeSpecialCharacters(String)}.
   *
   * <p>Method under test: {@link RuleFieldExtractionUtility#escapeSpecialCharacters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String RuleFieldExtractionUtility.escapeSpecialCharacters(String)"})
  public void testEscapeSpecialCharacters() {
    // Arrange, Act and Assert
    assertEquals("foo", ruleFieldExtractionUtility.escapeSpecialCharacters("foo"));
  }

  /**
   * Test {@link RuleFieldExtractionUtility#unescapeSpecialCharacters(String)}.
   *
   * <p>Method under test: {@link RuleFieldExtractionUtility#unescapeSpecialCharacters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String RuleFieldExtractionUtility.unescapeSpecialCharacters(String)"})
  public void testUnescapeSpecialCharacters() {
    // Arrange, Act and Assert
    assertEquals("foo", ruleFieldExtractionUtility.unescapeSpecialCharacters("foo"));
  }
}
