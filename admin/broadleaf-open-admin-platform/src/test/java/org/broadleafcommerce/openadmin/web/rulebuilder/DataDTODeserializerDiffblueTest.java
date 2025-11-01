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
package org.broadleafcommerce.openadmin.web.rulebuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.DataDTO;
import org.junit.Test;

public class DataDTODeserializerDiffblueTest {
  /**
   * Method under test:
   * {@link DataDTODeserializer#deserialize(JsonParser, DeserializationContext)}
   */
  @Test
  public void testDeserialize() throws IOException {
    // Arrange
    DataDTODeserializer dataDTODeserializer = new DataDTODeserializer();
    JsonParser d = mock(JsonParser.class);
    doNothing().when(d).clearCurrentToken();
    JacksonFeatureSet<StreamReadCapability> fromBitmaskResult = JacksonFeatureSet.fromBitmask(1);
    when(d.getReadCapabilities()).thenReturn(fromBitmaskResult);
    when(d.currentTokenId()).thenReturn(1);
    when(d.nextToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.currentToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.getCodec()).thenReturn(new ObjectMapper());
    JsonParserDelegate jp = new JsonParserDelegate(d);

    // Act
    DataDTO actualDeserializeResult = dataDTODeserializer.deserialize(jp,
        new DefaultDeserializationContext.Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig())));

    // Assert
    verify(d).clearCurrentToken();
    verify(d, atLeast(1)).currentToken();
    verify(d).currentTokenId();
    verify(d).getCodec();
    verify(d).getReadCapabilities();
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
   * Method under test:
   * {@link DataDTODeserializer#deserialize(JsonParser, DeserializationContext)}
   */
  @Test
  public void testDeserialize2() throws IOException {
    // Arrange
    DataDTODeserializer dataDTODeserializer = new DataDTODeserializer();
    JsonParser d = mock(JsonParser.class);
    doNothing().when(d).clearCurrentToken();
    JacksonFeatureSet<StreamReadCapability> fromBitmaskResult = JacksonFeatureSet.fromBitmask(1);
    when(d.getReadCapabilities()).thenReturn(fromBitmaskResult);
    when(d.currentTokenId()).thenReturn(1);
    when(d.nextToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.currentToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.getCodec()).thenReturn(new XmlMapper());
    JsonParserDelegate jp = new JsonParserDelegate(d);

    // Act
    DataDTO actualDeserializeResult = dataDTODeserializer.deserialize(jp,
        new DefaultDeserializationContext.Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig())));

    // Assert
    verify(d).clearCurrentToken();
    verify(d, atLeast(1)).currentToken();
    verify(d).currentTokenId();
    verify(d).getCodec();
    verify(d).getReadCapabilities();
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
   * Method under test: {@link DataDTODeserializer#getNullAwareText(JsonNode)}
   */
  @Test
  public void testGetNullAwareText() {
    // Arrange
    DataDTODeserializer dataDTODeserializer = new DataDTODeserializer();

    // Act and Assert
    assertEquals("", dataDTODeserializer.getNullAwareText(MissingNode.getInstance()));
  }

  /**
   * Method under test: {@link DataDTODeserializer#getNullAwareText(JsonNode)}
   */
  @Test
  public void testGetNullAwareText2() {
    // Arrange
    DataDTODeserializer dataDTODeserializer = new DataDTODeserializer();

    // Act and Assert
    assertEquals("", dataDTODeserializer.getNullAwareText(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true))));
  }

  /**
   * Method under test: {@link DataDTODeserializer#getNullAwareText(JsonNode)}
   */
  @Test
  public void testGetNullAwareText3() throws UnsupportedEncodingException {
    // Arrange
    DataDTODeserializer dataDTODeserializer = new DataDTODeserializer();

    // Act and Assert
    assertEquals("QVhBWEFYQVg=", dataDTODeserializer.getNullAwareText(new BinaryNode("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Method under test: {@link DataDTODeserializer#getNullAwareText(JsonNode)}
   */
  @Test
  public void testGetNullAwareText4() {
    // Arrange
    DataDTODeserializer dataDTODeserializer = new DataDTODeserializer();

    // Act and Assert
    assertNull(dataDTODeserializer.getNullAwareText(NullNode.getInstance()));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link DataDTODeserializer}
   */
  @Test
  public void testNewDataDTODeserializer() {
    // Arrange and Act
    DataDTODeserializer actualDataDTODeserializer = new DataDTODeserializer();

    // Assert
    assertNull(actualDataDTODeserializer.getValueType());
    Class<DataDTO> expectedValueClass = DataDTO.class;
    assertEquals(expectedValueClass, actualDataDTODeserializer.getValueClass());
  }
}
