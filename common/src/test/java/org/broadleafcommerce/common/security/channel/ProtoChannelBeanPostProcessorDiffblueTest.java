/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.security.channel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.apache.xerces.impl.dv.util.ByteListImpl;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.access.channel.ChannelProcessor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ProtoChannelBeanPostProcessor.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProtoChannelBeanPostProcessorDiffblueTest {
  @Autowired
  private ProtoChannelBeanPostProcessor protoChannelBeanPostProcessor;

  /**
   * Test
   * {@link ProtoChannelBeanPostProcessor#postProcessAfterInitialization(Object, String)}.
   * <p>
   * Method under test:
   * {@link ProtoChannelBeanPostProcessor#postProcessAfterInitialization(Object, String)}
   */
  @Test
  public void testPostProcessAfterInitialization() throws BeansException {
    // Arrange
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act and Assert
    assertSame(object, protoChannelBeanPostProcessor.postProcessAfterInitialization(object, "Bean Name"));
  }

  /**
   * Test
   * {@link ProtoChannelBeanPostProcessor#postProcessBeforeInitialization(Object, String)}.
   * <ul>
   *   <li>When {@link ByteListImpl}.</li>
   *   <li>Then return {@link ByteListImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoChannelBeanPostProcessor#postProcessBeforeInitialization(Object, String)}
   */
  @Test
  public void testPostProcessBeforeInitialization_whenByteListImpl_thenReturnByteListImpl() throws BeansException {
    // Arrange
    ByteListImpl byteListImpl = mock(ByteListImpl.class);

    // Act and Assert
    assertSame(byteListImpl, protoChannelBeanPostProcessor.postProcessBeforeInitialization(byteListImpl, "Bean Name"));
  }

  /**
   * Test
   * {@link ProtoChannelBeanPostProcessor#postProcessBeforeInitialization(Object, String)}.
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then return {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoChannelBeanPostProcessor#postProcessBeforeInitialization(Object, String)}
   */
  @Test
  public void testPostProcessBeforeInitialization_whenNull_field_thenReturnNull_field() throws BeansException {
    // Arrange
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act and Assert
    assertSame(object, protoChannelBeanPostProcessor.postProcessBeforeInitialization(object, "Bean Name"));
  }

  /**
   * Test {@link ProtoChannelBeanPostProcessor#getOrder()}.
   * <p>
   * Method under test: {@link ProtoChannelBeanPostProcessor#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(9999, (new ProtoChannelBeanPostProcessor()).getOrder());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProtoChannelBeanPostProcessor#setChannelProcessorOverrides(List)}
   *   <li>{@link ProtoChannelBeanPostProcessor#getChannelProcessorOverrides()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ProtoChannelBeanPostProcessor protoChannelBeanPostProcessor = new ProtoChannelBeanPostProcessor();
    ArrayList<ChannelProcessor> channelProcessorOverrides = new ArrayList<>();

    // Act
    protoChannelBeanPostProcessor.setChannelProcessorOverrides(channelProcessorOverrides);
    List<ChannelProcessor> actualChannelProcessorOverrides = protoChannelBeanPostProcessor
        .getChannelProcessorOverrides();

    // Assert that nothing has changed
    assertTrue(actualChannelProcessorOverrides.isEmpty());
    assertSame(channelProcessorOverrides, actualChannelProcessorOverrides);
  }

  /**
   * Test new {@link ProtoChannelBeanPostProcessor} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ProtoChannelBeanPostProcessor}
   */
  @Test
  public void testNewProtoChannelBeanPostProcessor() {
    // Arrange and Act
    ProtoChannelBeanPostProcessor actualProtoChannelBeanPostProcessor = new ProtoChannelBeanPostProcessor();

    // Assert
    assertNull(actualProtoChannelBeanPostProcessor.getChannelProcessorOverrides());
    assertEquals(9999, actualProtoChannelBeanPostProcessor.getOrder());
  }
}
