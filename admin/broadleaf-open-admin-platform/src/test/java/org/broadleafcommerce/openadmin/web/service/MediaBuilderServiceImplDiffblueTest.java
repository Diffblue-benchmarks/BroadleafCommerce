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
package org.broadleafcommerce.openadmin.web.service;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.broadleafcommerce.common.media.domain.Media;
import org.broadleafcommerce.common.media.domain.MediaDto;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {MediaBuilderServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MediaBuilderServiceImplDiffblueTest {
  @MockBean(name = "blEntityConfiguration")
  private EntityConfiguration entityConfiguration;

  @Autowired
  private MediaBuilderServiceImpl mediaBuilderServiceImpl;

  /**
   * Test {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}.
   * <p>
   * Method under test: {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Media MediaBuilderServiceImpl.convertJsonToMedia(String, Class)"})
  public void testConvertJsonToMedia() throws JsonProcessingException {
    // Arrange
    MediaDto mediaDto = new MediaDto();
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), Mockito.<Class<Media>>any()))
        .thenReturn(mediaDto);
    JsonMapper buildResult = JsonMapper.builder().findAndAddModules().build();
    String json = buildResult.writeValueAsString(new MediaDto());
    Class<Object> type = Object.class;

    // Act
    Media actualConvertJsonToMediaResult = mediaBuilderServiceImpl.convertJsonToMedia(json, type);

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.common.media.domain.Media"),
        isA(Class.class));
    assertSame(mediaDto, actualConvertJsonToMediaResult);
  }

  /**
   * Test {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}.
   * <p>
   * Method under test: {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Media MediaBuilderServiceImpl.convertJsonToMedia(String, Class)"})
  public void testConvertJsonToMedia2() throws JsonProcessingException {
    // Arrange
    MediaDto mediaDto = new MediaDto();
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), Mockito.<Class<Media>>any()))
        .thenReturn(mediaDto);
    String json = JsonMapper.builder()
        .findAndAddModules()
        .build()
        .writeValueAsString("{\"id\":0,\"url\":\"\",\"title\":\"\",\"altText\":\"\",\"tags\":\"\"}");
    Class<Object> type = Object.class;

    // Act
    Media actualConvertJsonToMediaResult = mediaBuilderServiceImpl.convertJsonToMedia(json, type);

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.common.media.domain.Media"),
        isA(Class.class));
    assertSame(mediaDto, actualConvertJsonToMediaResult);
  }

  /**
   * Test {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@link MediaDto} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Media MediaBuilderServiceImpl.convertJsonToMedia(String, Class)"})
  public void testConvertJsonToMedia_when42_thenReturnMediaDto() {
    // Arrange
    MediaDto mediaDto = new MediaDto();
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), Mockito.<Class<Media>>any()))
        .thenReturn(mediaDto);
    Class<Object> type = Object.class;

    // Act
    Media actualConvertJsonToMediaResult = mediaBuilderServiceImpl.convertJsonToMedia("42", type);

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.common.media.domain.Media"),
        isA(Class.class));
    assertSame(mediaDto, actualConvertJsonToMediaResult);
  }

  /**
   * Test {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}.
   * <ul>
   *   <li>When builder findAndAddModules build writeValueAsString {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Media MediaBuilderServiceImpl.convertJsonToMedia(String, Class)"})
  public void testConvertJsonToMedia_whenBuilderFindAndAddModulesBuildWriteValueAsString42()
      throws JsonProcessingException {
    // Arrange
    MediaDto mediaDto = new MediaDto();
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), Mockito.<Class<Media>>any()))
        .thenReturn(mediaDto);
    String json = JsonMapper.builder().findAndAddModules().build().writeValueAsString("42");
    Class<Object> type = Object.class;

    // Act
    Media actualConvertJsonToMediaResult = mediaBuilderServiceImpl.convertJsonToMedia(json, type);

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.common.media.domain.Media"),
        isA(Class.class));
    assertSame(mediaDto, actualConvertJsonToMediaResult);
  }

  /**
   * Test {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@link MediaDto} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Media MediaBuilderServiceImpl.convertJsonToMedia(String, Class)"})
  public void testConvertJsonToMedia_whenEmptyString_thenReturnMediaDto() {
    // Arrange
    MediaDto mediaDto = new MediaDto();
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), Mockito.<Class<Media>>any()))
        .thenReturn(mediaDto);
    Class<Object> type = Object.class;

    // Act
    Media actualConvertJsonToMediaResult = mediaBuilderServiceImpl.convertJsonToMedia("", type);

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.common.media.domain.Media"),
        isA(Class.class));
    assertSame(mediaDto, actualConvertJsonToMediaResult);
  }

  /**
   * Test {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}.
   * <ul>
   *   <li>When {@code Json}.</li>
   *   <li>Then return {@link MediaDto} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Media MediaBuilderServiceImpl.convertJsonToMedia(String, Class)"})
  public void testConvertJsonToMedia_whenJson_thenReturnMediaDto() {
    // Arrange
    MediaDto mediaDto = new MediaDto();
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), Mockito.<Class<Media>>any()))
        .thenReturn(mediaDto);
    Class<Object> type = Object.class;

    // Act
    Media actualConvertJsonToMediaResult = mediaBuilderServiceImpl.convertJsonToMedia("Json", type);

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.common.media.domain.Media"),
        isA(Class.class));
    assertSame(mediaDto, actualConvertJsonToMediaResult);
  }

  /**
   * Test {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link MediaDto} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Media MediaBuilderServiceImpl.convertJsonToMedia(String, Class)"})
  public void testConvertJsonToMedia_whenNull_thenReturnMediaDto() {
    // Arrange
    MediaDto mediaDto = new MediaDto();
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), Mockito.<Class<Media>>any()))
        .thenReturn(mediaDto);
    Class<Object> type = Object.class;

    // Act
    Media actualConvertJsonToMediaResult = mediaBuilderServiceImpl.convertJsonToMedia(null, type);

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.common.media.domain.Media"),
        isA(Class.class));
    assertSame(mediaDto, actualConvertJsonToMediaResult);
  }

  /**
   * Test {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link MediaDto} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Media MediaBuilderServiceImpl.convertJsonToMedia(String, Class)"})
  public void testConvertJsonToMedia_whenNull_thenReturnMediaDto2() throws JsonProcessingException {
    // Arrange
    MediaDto mediaDto = new MediaDto();
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), Mockito.<Class<Media>>any()))
        .thenReturn(mediaDto);
    JsonMapper buildResult = JsonMapper.builder().findAndAddModules().build();

    // Act
    Media actualConvertJsonToMediaResult = mediaBuilderServiceImpl
        .convertJsonToMedia(buildResult.writeValueAsString(new MediaDto()), null);

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.common.media.domain.Media"),
        isA(Class.class));
    assertSame(mediaDto, actualConvertJsonToMediaResult);
  }
}
