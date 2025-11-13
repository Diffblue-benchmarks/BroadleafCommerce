package org.broadleafcommerce.openadmin.web.service;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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

  @Autowired private MediaBuilderServiceImpl mediaBuilderServiceImpl;

  /**
   * Test {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}.
   *
   * <p>Method under test: {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Media MediaBuilderServiceImpl.convertJsonToMedia(String, Class)"})
  public void testConvertJsonToMedia() throws JsonProcessingException {
    // Arrange
    MediaDto mediaDto = new MediaDto();
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), eq(Media.class)))
        .thenReturn(mediaDto);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    String json = jsonMapper.writeValueAsString(new MediaDto());
    Class<Object> type = Object.class;

    // Act
    Media actualConvertJsonToMediaResult = mediaBuilderServiceImpl.convertJsonToMedia(json, type);

    // Assert
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.common.media.domain.Media"), isA(Class.class));
    assertSame(mediaDto, actualConvertJsonToMediaResult);
  }

  /**
   * Test {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}.
   *
   * <p>Method under test: {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Media MediaBuilderServiceImpl.convertJsonToMedia(String, Class)"})
  public void testConvertJsonToMedia2() throws JsonProcessingException {
    // Arrange
    MediaDto mediaDto = new MediaDto();
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), eq(Media.class)))
        .thenReturn(mediaDto);
    String json =
        JsonMapper.builder()
            .findAndAddModules()
            .build()
            .writeValueAsString(
                "{\"id\":0,\"url\":\"\",\"title\":\"\",\"altText\":\"\",\"tags\":\"\"}");
    Class<Object> type = Object.class;

    // Act
    Media actualConvertJsonToMediaResult = mediaBuilderServiceImpl.convertJsonToMedia(json, type);

    // Assert
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.common.media.domain.Media"), isA(Class.class));
    assertSame(mediaDto, actualConvertJsonToMediaResult);
  }

  /**
   * Test {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}.
   *
   * <p>Method under test: {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Media MediaBuilderServiceImpl.convertJsonToMedia(String, Class)"})
  public void testConvertJsonToMedia3() {
    // Arrange
    MediaDto mediaDto = new MediaDto();
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), eq(Media.class)))
        .thenReturn(mediaDto);
    Class<MediaBuilderServiceImpl> type = MediaBuilderServiceImpl.class;

    // Act
    Media actualConvertJsonToMediaResult = mediaBuilderServiceImpl.convertJsonToMedia("  ", type);

    // Assert
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.common.media.domain.Media"), isA(Class.class));
    assertSame(mediaDto, actualConvertJsonToMediaResult);
  }

  /**
   * Test {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}.
   *
   * <ul>
   *   <li>Given Bean Name{blEntityConfiguration}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Media MediaBuilderServiceImpl.convertJsonToMedia(String, Class)"})
  public void testConvertJsonToMedia_givenBeanNameBlEntityConfiguration_thenReturnNull()
      throws JsonProcessingException {
    // Arrange
    String json = JsonMapper.builder().findAndAddModules().build().writeValueAsString(null);
    Class<Object> type = Object.class;

    // Act and Assert
    assertNull(mediaBuilderServiceImpl.convertJsonToMedia(json, type));
  }

  /**
   * Test {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}.
   *
   * <ul>
   *   <li>Given {@link MediaBuilderServiceImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Media MediaBuilderServiceImpl.convertJsonToMedia(String, Class)"})
  public void testConvertJsonToMedia_givenMediaBuilderServiceImpl_thenReturnNull()
      throws JsonProcessingException {
    // Arrange
    MediaBuilderServiceImpl mediaBuilderServiceImpl = new MediaBuilderServiceImpl();
    String json = JsonMapper.builder().findAndAddModules().build().writeValueAsString(null);
    Class<MediaBuilderServiceImpl> type = MediaBuilderServiceImpl.class;

    // Act and Assert
    assertNull(mediaBuilderServiceImpl.convertJsonToMedia(json, type));
  }

  /**
   * Test {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Media MediaBuilderServiceImpl.convertJsonToMedia(String, Class)"})
  public void testConvertJsonToMedia_thenThrowRuntimeException() {
    // Arrange
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), eq(Media.class)))
        .thenThrow(new RuntimeException());
    Class<Object> type = Object.class;

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> mediaBuilderServiceImpl.convertJsonToMedia("", type));
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.common.media.domain.Media"), isA(Class.class));
  }

  /**
   * Test {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@link MediaDto} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Media MediaBuilderServiceImpl.convertJsonToMedia(String, Class)"})
  public void testConvertJsonToMedia_when42_thenReturnMediaDto() {
    // Arrange
    MediaDto mediaDto = new MediaDto();
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), eq(Media.class)))
        .thenReturn(mediaDto);
    Class<Object> type = Object.class;

    // Act
    Media actualConvertJsonToMediaResult = mediaBuilderServiceImpl.convertJsonToMedia("42", type);

    // Assert
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.common.media.domain.Media"), isA(Class.class));
    assertSame(mediaDto, actualConvertJsonToMediaResult);
  }

  /**
   * Test {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}.
   *
   * <ul>
   *   <li>When builder findAndAddModules build writeValueAsString {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Media MediaBuilderServiceImpl.convertJsonToMedia(String, Class)"})
  public void testConvertJsonToMedia_whenBuilderFindAndAddModulesBuildWriteValueAsString42()
      throws JsonProcessingException {
    // Arrange
    MediaDto mediaDto = new MediaDto();
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), eq(Media.class)))
        .thenReturn(mediaDto);
    String json = JsonMapper.builder().findAndAddModules().build().writeValueAsString("42");
    Class<Object> type = Object.class;

    // Act
    Media actualConvertJsonToMediaResult = mediaBuilderServiceImpl.convertJsonToMedia(json, type);

    // Assert
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.common.media.domain.Media"), isA(Class.class));
    assertSame(mediaDto, actualConvertJsonToMediaResult);
  }

  /**
   * Test {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@link MediaDto} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Media MediaBuilderServiceImpl.convertJsonToMedia(String, Class)"})
  public void testConvertJsonToMedia_whenEmptyString_thenReturnMediaDto() {
    // Arrange
    MediaDto mediaDto = new MediaDto();
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), eq(Media.class)))
        .thenReturn(mediaDto);
    Class<Object> type = Object.class;

    // Act
    Media actualConvertJsonToMediaResult = mediaBuilderServiceImpl.convertJsonToMedia("", type);

    // Assert
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.common.media.domain.Media"), isA(Class.class));
    assertSame(mediaDto, actualConvertJsonToMediaResult);
  }

  /**
   * Test {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}.
   *
   * <ul>
   *   <li>When {@code Json}.
   *   <li>Then return {@link MediaDto} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Media MediaBuilderServiceImpl.convertJsonToMedia(String, Class)"})
  public void testConvertJsonToMedia_whenJson_thenReturnMediaDto() {
    // Arrange
    MediaDto mediaDto = new MediaDto();
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), eq(Media.class)))
        .thenReturn(mediaDto);
    Class<Object> type = Object.class;

    // Act
    Media actualConvertJsonToMediaResult = mediaBuilderServiceImpl.convertJsonToMedia("Json", type);

    // Assert
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.common.media.domain.Media"), isA(Class.class));
    assertSame(mediaDto, actualConvertJsonToMediaResult);
  }

  /**
   * Test {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link MediaDto} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Media MediaBuilderServiceImpl.convertJsonToMedia(String, Class)"})
  public void testConvertJsonToMedia_whenNull_thenReturnMediaDto() {
    // Arrange
    MediaDto mediaDto = new MediaDto();
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), eq(Media.class)))
        .thenReturn(mediaDto);
    Class<Object> type = Object.class;

    // Act
    Media actualConvertJsonToMediaResult = mediaBuilderServiceImpl.convertJsonToMedia(null, type);

    // Assert
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.common.media.domain.Media"), isA(Class.class));
    assertSame(mediaDto, actualConvertJsonToMediaResult);
  }

  /**
   * Test {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link MediaDto} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Media MediaBuilderServiceImpl.convertJsonToMedia(String, Class)"})
  public void testConvertJsonToMedia_whenNull_thenReturnMediaDto2() {
    // Arrange
    MediaDto mediaDto = new MediaDto();
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), eq(Media.class)))
        .thenReturn(mediaDto);

    // Act
    Media actualConvertJsonToMediaResult = mediaBuilderServiceImpl.convertJsonToMedia("  ", null);

    // Assert
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.common.media.domain.Media"), isA(Class.class));
    assertSame(mediaDto, actualConvertJsonToMediaResult);
  }

  /**
   * Test {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}.
   *
   * <ul>
   *   <li>When {@code Media}.
   * </ul>
   *
   * <p>Method under test: {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Media MediaBuilderServiceImpl.convertJsonToMedia(String, Class)"})
  public void testConvertJsonToMedia_whenOrgBroadleafcommerceCommonMediaDomainMedia()
      throws JsonProcessingException {
    // Arrange
    MediaDto mediaDto = new MediaDto();
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), eq(Media.class)))
        .thenReturn(mediaDto);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    String json = jsonMapper.writeValueAsString(new MediaDto());
    Class<Media> type = Media.class;

    // Act
    Media actualConvertJsonToMediaResult = mediaBuilderServiceImpl.convertJsonToMedia(json, type);

    // Assert
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.common.media.domain.Media"), isA(Class.class));
    assertSame(mediaDto, actualConvertJsonToMediaResult);
  }

  /**
   * Test {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}.
   *
   * <ul>
   *   <li>When space space.
   *   <li>Then return {@link MediaDto} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Media MediaBuilderServiceImpl.convertJsonToMedia(String, Class)"})
  public void testConvertJsonToMedia_whenSpaceSpace_thenReturnMediaDto() {
    // Arrange
    MediaDto mediaDto = new MediaDto();
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), eq(Media.class)))
        .thenReturn(mediaDto);
    Class<Object> type = Object.class;

    // Act
    Media actualConvertJsonToMediaResult = mediaBuilderServiceImpl.convertJsonToMedia("  ", type);

    // Assert
    verify(entityConfiguration)
        .createEntityInstance(
            eq("org.broadleafcommerce.common.media.domain.Media"), isA(Class.class));
    assertSame(mediaDto, actualConvertJsonToMediaResult);
  }
}
