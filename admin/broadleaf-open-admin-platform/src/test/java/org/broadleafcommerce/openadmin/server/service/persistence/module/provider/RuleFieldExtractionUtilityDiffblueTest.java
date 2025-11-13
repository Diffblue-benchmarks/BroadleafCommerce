package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.BeanProperty.Bogus;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTypeResolverBuilder;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsDeductionTypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
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
        () ->
            new RuleFieldExtractionUtility()
                .convertJsonToDataWrapper("42DataDTODeserializerModule"));
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
        RuntimeException.class,
        () -> new RuleFieldExtractionUtility().convertJsonToDataWrapper("42"));
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
  public void testConvertJsonToDataWrapper_whenDataDTODeserializerModule() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new RuleFieldExtractionUtility()
                .convertJsonToDataWrapper("[]DataDTODeserializerModule"));
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
        RuntimeException.class,
        () -> new RuleFieldExtractionUtility().convertJsonToDataWrapper(""));
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
        RuntimeException.class,
        () -> new RuleFieldExtractionUtility().convertJsonToDataWrapper("Json"));
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
    assertNull(new RuleFieldExtractionUtility().convertJsonToDataWrapper("[]"));
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
    assertNull(new RuleFieldExtractionUtility().convertJsonToDataWrapper(null));
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
    dataDTO3.setCondition("Dw");

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
    RuleFieldExtractionUtility ruleFieldExtractionUtility = new RuleFieldExtractionUtility();
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
    // Arrange
    RuleFieldExtractionUtility ruleFieldExtractionUtility = new RuleFieldExtractionUtility();

    // Act and Assert
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
  public void testConvertSimpleRuleToJson2() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));

    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition("org.broadleafcommerce.openadmin.web.rulebuilder.dto.DataDTO");
    dataDTO.setContainedPk(2L);
    dataDTO.setCreatedFromSubGroup(false);
    dataDTO.setPk(2L);
    dataDTO.setPreviousContainedPk(2L);
    dataDTO.setPreviousPk(2L);
    dataDTO.setQuantity(2);
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

    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT));

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
  public void testConvertSimpleRuleToJson3() {
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

    TypeResolverBuilder<?> typer = mock(TypeResolverBuilder.class);
    when(typer.buildTypeSerializer(
            Mockito.<SerializationConfig>any(),
            Mockito.<JavaType>any(),
            Mockito.<Collection<NamedType>>any()))
        .thenReturn(AsDeductionTypeSerializer.instance());

    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(typer);

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
    verify(typer, atLeast(1))
        .buildTypeSerializer(isA(SerializationConfig.class), Mockito.<JavaType>any(), isNull());
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
   *   <li>Given {@link DataDTO} (default constructor) CreatedFromSubGroup is {@code true}.
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
  public void testConvertSimpleRuleToJson_givenDataDTOCreatedFromSubGroupIsTrue() {
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
   *   <li>Given {@link DataWrapper}.
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
  public void testConvertSimpleRuleToJson_givenDataWrapper() {
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

    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(new StdTypeResolverBuilder());

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
   *   <li>Given {@link DefaultTypeResolverBuilder#DefaultTypeResolverBuilder(DefaultTyping)} with t
   *       is {@code JAVA_LANG_OBJECT}.
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
  public void testConvertSimpleRuleToJson_givenDefaultTypeResolverBuilderWithTIsJavaLangObject() {
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
    builderResult.setDefaultTyping(new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT));

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
   *   <li>Given {@code true}.
   *   <li>When builder defaultLeniency {@code true}.
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
  public void testConvertSimpleRuleToJson_givenTrue_whenBuilderDefaultLeniencyTrue() {
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
    builderResult.defaultLeniency(true);

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
   *   <li>Then calls {@link DataWrapper#getRawMvel()}.
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
  public void testConvertSimpleRuleToJson_thenCallsGetRawMvel() {
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
   *   <li>Then calls {@link TypeIdResolver#idFromValue(Object)}.
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
  public void testConvertSimpleRuleToJson_thenCallsIdFromValue() {
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

    TypeIdResolver idRes = mock(TypeIdResolver.class);
    when(idRes.idFromValue(Mockito.<Object>any())).thenReturn("42");
    AsArrayTypeSerializer asArrayTypeSerializer = new AsArrayTypeSerializer(idRes, new Bogus());

    TypeResolverBuilder<?> typer = mock(TypeResolverBuilder.class);
    when(typer.buildTypeSerializer(
            Mockito.<SerializationConfig>any(),
            Mockito.<JavaType>any(),
            Mockito.<Collection<NamedType>>any()))
        .thenReturn(asArrayTypeSerializer);

    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(typer);

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
    verify(idRes, atLeast(1)).idFromValue(Mockito.<Object>any());
    verify(typer, atLeast(1))
        .buildTypeSerializer(isA(SerializationConfig.class), Mockito.<JavaType>any(), isNull());
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
   *   <li>Then calls {@link AsArrayTypeSerializer#typeId(Object, JsonToken)}.
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
  public void testConvertSimpleRuleToJson_thenCallsTypeId() throws IOException {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));

    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getData()).thenReturn(new ArrayList<>());

    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(
            Mockito.<Entity[]>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<RuleBuilderFieldService>any()))
        .thenReturn(dataWrapper);

    AsArrayTypeSerializer asArrayTypeSerializer = mock(AsArrayTypeSerializer.class);
    when(asArrayTypeSerializer.typeId(Mockito.<Object>any(), Mockito.<JsonToken>any()))
        .thenReturn(new WritableTypeId());
    when(asArrayTypeSerializer.writeTypePrefix(
            Mockito.<JsonGenerator>any(), Mockito.<WritableTypeId>any()))
        .thenReturn(new WritableTypeId());

    TypeSerializer typeSerializer = mock(TypeSerializer.class);
    when(typeSerializer.getTypeInclusion()).thenReturn(As.PROPERTY);
    when(typeSerializer.forProperty(Mockito.<BeanProperty>any())).thenReturn(asArrayTypeSerializer);

    TypeResolverBuilder<?> typer = mock(TypeResolverBuilder.class);
    when(typer.buildTypeSerializer(
            Mockito.<SerializationConfig>any(),
            Mockito.<JavaType>any(),
            Mockito.<Collection<NamedType>>any()))
        .thenReturn(typeSerializer);

    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(typer);

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
    verify(typer, atLeast(1))
        .buildTypeSerializer(isA(SerializationConfig.class), Mockito.<JavaType>any(), isNull());
    verify(typeSerializer, atLeast(1)).forProperty(Mockito.<BeanProperty>any());
    verify(typeSerializer, atLeast(1)).getTypeInclusion();
    verify(asArrayTypeSerializer).typeId(isA(Object.class), eq(JsonToken.START_OBJECT));
    verify(asArrayTypeSerializer)
        .writeTypePrefix(isA(JsonGenerator.class), isA(WritableTypeId.class));
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
   *   <li>Then calls {@link DataWrapper#getRawMvel()}.
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
  public void testConvertSimpleRuleToJson_whenNull_thenCallsGetRawMvel() {
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
    assertEquals("foo", new RuleFieldExtractionUtility().escapeSpecialCharacters("foo"));
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
    assertEquals("foo", new RuleFieldExtractionUtility().unescapeSpecialCharacters("foo"));
  }
}
