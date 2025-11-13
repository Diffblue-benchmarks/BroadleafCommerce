package org.broadleafcommerce.openadmin.web.rulebuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import com.fasterxml.jackson.core.util.JsonParserSequence;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTypeResolverBuilder;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.Impl;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.DataDTO;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class DataDTODeserializerDiffblueTest {
  /**
   * Test new {@link DataDTODeserializer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link DataDTODeserializer}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataDTODeserializer.<init>()"})
  public void testNewDataDTODeserializer() {
    // Arrange and Act
    DataDTODeserializer actualDataDTODeserializer = new DataDTODeserializer();

    // Assert
    assertNull(actualDataDTODeserializer.getValueType());
    Class<DataDTO> expectedValueClass = DataDTO.class;
    assertEquals(expectedValueClass, actualDataDTODeserializer.getValueClass());
  }

  /**
   * Test {@link DataDTODeserializer#deserialize(JsonParser, DeserializationContext)} with {@code
   * jp}, {@code ctxt}.
   *
   * <p>Method under test: {@link DataDTODeserializer#deserialize(JsonParser,
   * DeserializationContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataDTO DataDTODeserializer.deserialize(JsonParser, DeserializationContext)"})
  public void testDeserializeWithJpCtxt() throws IOException {
    // Arrange
    DataDTODeserializer dataDTODeserializer = new DataDTODeserializer();

    Builder builderResult = JsonMapper.builder();
    builderResult.setDefaultTyping(new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT));
    JsonMapper jsonMapper = builderResult.findAndAddModules().build();

    JsonParserSequence d = mock(JsonParserSequence.class);
    doNothing().when(d).clearCurrentToken();
    JacksonFeatureSet<StreamReadCapability> fromBitmaskResult = JacksonFeatureSet.fromBitmask(1);
    when(d.getReadCapabilities()).thenReturn(fromBitmaskResult);
    when(d.currentTokenId()).thenReturn(1);
    when(d.currentToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.nextToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.getCodec()).thenReturn(jsonMapper);
    doNothing().when(d).setSchema(Mockito.<FormatSchema>any());

    JsonParserDelegate jp = new JsonParserDelegate(d);
    jp.setSchema(mock(FormatSchema.class));

    // Act
    DataDTO actualDeserializeResult =
        dataDTODeserializer.deserialize(
            jp, new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig())));

    // Assert
    verify(d).clearCurrentToken();
    verify(d, atLeast(1)).currentToken();
    verify(d).currentTokenId();
    verify(d).getCodec();
    verify(d).getReadCapabilities();
    verify(d).setSchema(isA(FormatSchema.class));
    verify(d).nextToken();
    assertNull(actualDeserializeResult.getQuantity());
    assertNull(actualDeserializeResult.getContainedPk());
    assertNull(actualDeserializeResult.getPk());
    assertNull(actualDeserializeResult.getPreviousContainedPk());
    assertNull(actualDeserializeResult.getPreviousPk());
    assertNull(actualDeserializeResult.getCondition());
    assertFalse(actualDeserializeResult.isCreatedFromSubGroup());
    assertTrue(actualDeserializeResult.getRules().isEmpty());
  }

  /**
   * Test {@link DataDTODeserializer#deserialize(JsonParser, DeserializationContext)} with {@code
   * jp}, {@code ctxt}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return Quantity is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTODeserializer#deserialize(JsonParser,
   * DeserializationContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataDTO DataDTODeserializer.deserialize(JsonParser, DeserializationContext)"})
  public void testDeserializeWithJpCtxt_givenOne_thenReturnQuantityIsNull() throws IOException {
    // Arrange
    DataDTODeserializer dataDTODeserializer = new DataDTODeserializer();

    JsonParserSequence d = mock(JsonParserSequence.class);
    doNothing().when(d).clearCurrentToken();
    JacksonFeatureSet<StreamReadCapability> fromBitmaskResult = JacksonFeatureSet.fromBitmask(1);
    when(d.getReadCapabilities()).thenReturn(fromBitmaskResult);
    when(d.currentTokenId()).thenReturn(1);
    when(d.currentToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.nextToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.getCodec()).thenReturn(JsonMapper.builder().findAndAddModules().build());
    doNothing().when(d).setSchema(Mockito.<FormatSchema>any());

    JsonParserDelegate jp = new JsonParserDelegate(d);
    jp.setSchema(mock(FormatSchema.class));

    // Act
    DataDTO actualDeserializeResult =
        dataDTODeserializer.deserialize(
            jp, new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig())));

    // Assert
    verify(d).clearCurrentToken();
    verify(d, atLeast(1)).currentToken();
    verify(d).currentTokenId();
    verify(d).getCodec();
    verify(d).getReadCapabilities();
    verify(d).setSchema(isA(FormatSchema.class));
    verify(d).nextToken();
    assertNull(actualDeserializeResult.getQuantity());
    assertNull(actualDeserializeResult.getContainedPk());
    assertNull(actualDeserializeResult.getPk());
    assertNull(actualDeserializeResult.getPreviousContainedPk());
    assertNull(actualDeserializeResult.getPreviousPk());
    assertNull(actualDeserializeResult.getCondition());
    assertFalse(actualDeserializeResult.isCreatedFromSubGroup());
    assertTrue(actualDeserializeResult.getRules().isEmpty());
  }

  /**
   * Test {@link DataDTODeserializer#getNullAwareText(JsonNode)}.
   *
   * <ul>
   *   <li>Then return {@code QVhBWEFYQVg=}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTODeserializer#getNullAwareText(JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTODeserializer.getNullAwareText(JsonNode)"})
  public void testGetNullAwareText_thenReturnQVhBWEFYQVg() throws UnsupportedEncodingException {
    // Arrange
    DataDTODeserializer dataDTODeserializer = new DataDTODeserializer();

    // Act
    String actualNullAwareText =
        dataDTODeserializer.getNullAwareText(new BinaryNode("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    assertEquals("QVhBWEFYQVg=", actualNullAwareText);
  }

  /**
   * Test {@link DataDTODeserializer#getNullAwareText(JsonNode)}.
   *
   * <ul>
   *   <li>When Instance.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link DataDTODeserializer#getNullAwareText(JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTODeserializer.getNullAwareText(JsonNode)"})
  public void testGetNullAwareText_whenInstance_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new DataDTODeserializer().getNullAwareText(MissingNode.getInstance()));
  }

  /**
   * Test {@link DataDTODeserializer#getNullAwareText(JsonNode)}.
   *
   * <ul>
   *   <li>When Instance.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTODeserializer#getNullAwareText(JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTODeserializer.getNullAwareText(JsonNode)"})
  public void testGetNullAwareText_whenInstance_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new DataDTODeserializer().getNullAwareText(NullNode.getInstance()));
  }

  /**
   * Test {@link DataDTODeserializer#getNullAwareText(JsonNode)}.
   *
   * <ul>
   *   <li>When valueOf ten.
   *   <li>Then return {@code 10.0}.
   * </ul>
   *
   * <p>Method under test: {@link DataDTODeserializer#getNullAwareText(JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataDTODeserializer.getNullAwareText(JsonNode)"})
  public void testGetNullAwareText_whenValueOfTen_thenReturn100() {
    // Arrange, Act and Assert
    assertEquals("10.0", new DataDTODeserializer().getNullAwareText(DoubleNode.valueOf(10.0d)));
  }
}
