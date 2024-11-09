/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.media.domain.Media;
import org.broadleafcommerce.common.media.domain.MediaDto;
import org.broadleafcommerce.common.media.domain.MediaImpl;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.util.UnknownUnwrapTypeException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CategoryMediaXrefImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CategoryMediaXrefImplDiffblueTest {
  @Autowired
  private CategoryMediaXrefImpl categoryMediaXrefImpl;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()}
   *   <li>{@link CategoryMediaXrefImpl#setCategory(Category)}
   *   <li>{@link CategoryMediaXrefImpl#setId(Long)}
   *   <li>{@link CategoryMediaXrefImpl#setKey(String)}
   *   <li>{@link CategoryMediaXrefImpl#setMedia(Media)}
   *   <li>{@link CategoryMediaXrefImpl#getCategory()}
   *   <li>{@link CategoryMediaXrefImpl#getId()}
   *   <li>{@link CategoryMediaXrefImpl#getKey()}
   *   <li>{@link CategoryMediaXrefImpl#getMedia()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CategoryMediaXrefImpl actualCategoryMediaXrefImpl = new CategoryMediaXrefImpl();
    CategoryImpl category = new CategoryImpl();
    actualCategoryMediaXrefImpl.setCategory(category);
    actualCategoryMediaXrefImpl.setId(1L);
    actualCategoryMediaXrefImpl.setKey("Key");
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    actualCategoryMediaXrefImpl.setMedia(media);
    Category actualCategory = actualCategoryMediaXrefImpl.getCategory();
    Long actualId = actualCategoryMediaXrefImpl.getId();
    String actualKey = actualCategoryMediaXrefImpl.getKey();
    Media actualMedia = actualCategoryMediaXrefImpl.getMedia();

    // Assert that nothing has changed
    assertEquals("Key", actualKey);
    assertEquals(1L, actualId.longValue());
    assertSame(category, actualCategory);
    assertSame(media, actualMedia);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl(Category, Media, String)}
   *   <li>{@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()}
   *   <li>{@link CategoryMediaXrefImpl#setCategory(Category)}
   *   <li>{@link CategoryMediaXrefImpl#setId(Long)}
   *   <li>{@link CategoryMediaXrefImpl#setKey(String)}
   *   <li>{@link CategoryMediaXrefImpl#setMedia(Media)}
   *   <li>{@link CategoryMediaXrefImpl#getCategory()}
   *   <li>{@link CategoryMediaXrefImpl#getId()}
   *   <li>{@link CategoryMediaXrefImpl#getKey()}
   *   <li>{@link CategoryMediaXrefImpl#getMedia()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenCategoryImpl() {
    // Arrange
    CategoryImpl category = new CategoryImpl();

    // Act
    CategoryMediaXrefImpl actualCategoryMediaXrefImpl = new CategoryMediaXrefImpl(category, new CategoryMediaXrefImpl(),
        "Key");
    CategoryImpl category2 = new CategoryImpl();
    actualCategoryMediaXrefImpl.setCategory(category2);
    actualCategoryMediaXrefImpl.setId(1L);
    actualCategoryMediaXrefImpl.setKey("Key");
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    actualCategoryMediaXrefImpl.setMedia(media);
    Category actualCategory = actualCategoryMediaXrefImpl.getCategory();
    Long actualId = actualCategoryMediaXrefImpl.getId();
    String actualKey = actualCategoryMediaXrefImpl.getKey();
    Media actualMedia = actualCategoryMediaXrefImpl.getMedia();

    // Assert that nothing has changed
    assertEquals("Key", actualKey);
    assertEquals(1L, actualId.longValue());
    assertSame(category2, actualCategory);
    assertSame(media, actualMedia);
  }

  /**
   * Test {@link CategoryMediaXrefImpl#getUrl()}.
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media is
   * {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#getUrl()}
   */
  @Test
  public void testGetUrl_givenCategoryMediaXrefImplMediaIsCategoryMediaXrefImpl_thenReturnNull() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNull(categoryMediaXrefImpl.getUrl());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#getUrl()}.
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media is
   * {@link MediaDto} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#getUrl()}
   */
  @Test
  public void testGetUrl_givenCategoryMediaXrefImplMediaIsMediaDto_thenReturnEmptyString() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(new MediaDto());

    // Act and Assert
    assertEquals("", categoryMediaXrefImpl.getUrl());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#getUrl()}.
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media is
   * {@link SkuMediaXrefImpl#SkuMediaXrefImpl()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#getUrl()}
   */
  @Test
  public void testGetUrl_givenCategoryMediaXrefImplMediaIsSkuMediaXrefImpl_thenReturnNull() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(new SkuMediaXrefImpl());

    // Act and Assert
    assertNull(categoryMediaXrefImpl.getUrl());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#getUrl()}.
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#getUrl()}
   */
  @Test
  public void testGetUrl_givenCategoryMediaXrefImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new CategoryMediaXrefImpl()).getUrl());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setUrl(String)}.
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#setUrl(String)}
   */
  @Test
  public void testSetUrl() {
    // Arrange
    CategoryImpl category = new CategoryImpl();
    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl(category, new CategoryMediaXrefImpl(),
        "Key");

    // Act
    categoryMediaXrefImpl2.setUrl("https://example.org/example");

    // Assert
    Media media = categoryMediaXrefImpl2.getMedia();
    Media media2 = ((CategoryMediaXrefImpl) media).getMedia();
    assertTrue(media2 instanceof MediaImpl);
    assertTrue(media instanceof CategoryMediaXrefImpl);
    assertEquals("https://example.org/example", media.getUrl());
    assertEquals("https://example.org/example", media2.getUrl());
    assertEquals("https://example.org/example", categoryMediaXrefImpl2.getUrl());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setUrl(String)}.
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#setUrl(String)}
   */
  @Test
  public void testSetUrl2() {
    // Arrange
    CategoryImpl category = mock(CategoryImpl.class);
    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl(category, new CategoryMediaXrefImpl(),
        "Key");

    // Act
    categoryMediaXrefImpl2.setUrl("https://example.org/example");

    // Assert
    Media media = categoryMediaXrefImpl2.getMedia();
    Media media2 = ((CategoryMediaXrefImpl) media).getMedia();
    assertTrue(media2 instanceof MediaImpl);
    assertTrue(media instanceof CategoryMediaXrefImpl);
    assertEquals("https://example.org/example", media.getUrl());
    assertEquals("https://example.org/example", media2.getUrl());
    assertEquals("https://example.org/example", categoryMediaXrefImpl2.getUrl());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setUrl(String)}.
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#setUrl(String)}
   */
  @Test
  public void testSetUrl3() {
    // Arrange
    CategoryImpl category = new CategoryImpl();
    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl(category, new MediaDto(), "Key");

    // Act
    categoryMediaXrefImpl2.setUrl("https://example.org/example");

    // Assert
    Media media = categoryMediaXrefImpl2.getMedia();
    assertTrue(media instanceof MediaDto);
    assertEquals("https://example.org/example", media.getUrl());
    assertEquals("https://example.org/example", categoryMediaXrefImpl2.getUrl());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setUrl(String)}.
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.</li>
   *   <li>Then {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media
   * {@link MediaImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#setUrl(String)}
   */
  @Test
  public void testSetUrl_givenCategoryMediaXrefImpl_thenCategoryMediaXrefImplMediaMediaImpl() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl();

    // Act
    categoryMediaXrefImpl2.setUrl("https://example.org/example");

    // Assert
    Media media = categoryMediaXrefImpl2.getMedia();
    assertTrue(media instanceof MediaImpl);
    assertEquals("https://example.org/example", media.getUrl());
    assertEquals("https://example.org/example", categoryMediaXrefImpl2.getUrl());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setUrl(String)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>Then throw {@link UnknownUnwrapTypeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#setUrl(String)}
   */
  @Test
  public void testSetUrl_givenJavaLangObject_thenThrowUnknownUnwrapTypeException() {
    // Arrange
    MediaImpl media = mock(MediaImpl.class);
    Class<Object> unwrapType = Object.class;
    doThrow(new UnknownUnwrapTypeException(unwrapType)).when(media).setUrl(Mockito.<String>any());

    // Act and Assert
    assertThrows(UnknownUnwrapTypeException.class,
        () -> (new CategoryMediaXrefImpl(new CategoryImpl(), media, "Key")).setUrl("https://example.org/example"));
    verify(media).setUrl(eq("https://example.org/example"));
  }

  /**
   * Test {@link CategoryMediaXrefImpl#getTitle()}.
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media is
   * {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#getTitle()}
   */
  @Test
  public void testGetTitle_givenCategoryMediaXrefImplMediaIsCategoryMediaXrefImpl() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNull(categoryMediaXrefImpl.getTitle());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#getTitle()}.
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media is
   * {@link MediaDto} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#getTitle()}
   */
  @Test
  public void testGetTitle_givenCategoryMediaXrefImplMediaIsMediaDto_thenReturnEmptyString() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(new MediaDto());

    // Act and Assert
    assertEquals("", categoryMediaXrefImpl.getTitle());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#getTitle()}.
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media is
   * {@link SkuMediaXrefImpl#SkuMediaXrefImpl()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#getTitle()}
   */
  @Test
  public void testGetTitle_givenCategoryMediaXrefImplMediaIsSkuMediaXrefImpl_thenReturnNull() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(new SkuMediaXrefImpl());

    // Act and Assert
    assertNull(categoryMediaXrefImpl.getTitle());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#getTitle()}.
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#getTitle()}
   */
  @Test
  public void testGetTitle_givenCategoryMediaXrefImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new CategoryMediaXrefImpl()).getTitle());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setTitle(String)}.
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#setTitle(String)}
   */
  @Test
  public void testSetTitle() {
    // Arrange
    CategoryImpl category = new CategoryImpl();
    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl(category, new CategoryMediaXrefImpl(),
        "Key");

    // Act
    categoryMediaXrefImpl2.setTitle("Dr");

    // Assert
    Media media = categoryMediaXrefImpl2.getMedia();
    Media media2 = ((CategoryMediaXrefImpl) media).getMedia();
    assertTrue(media2 instanceof MediaImpl);
    assertTrue(media instanceof CategoryMediaXrefImpl);
    assertEquals("Dr", media.getTitle());
    assertEquals("Dr", media2.getTitle());
    assertEquals("Dr", categoryMediaXrefImpl2.getTitle());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setTitle(String)}.
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#setTitle(String)}
   */
  @Test
  public void testSetTitle2() {
    // Arrange
    CategoryImpl category = mock(CategoryImpl.class);
    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl(category, new CategoryMediaXrefImpl(),
        "Key");

    // Act
    categoryMediaXrefImpl2.setTitle("Dr");

    // Assert
    Media media = categoryMediaXrefImpl2.getMedia();
    Media media2 = ((CategoryMediaXrefImpl) media).getMedia();
    assertTrue(media2 instanceof MediaImpl);
    assertTrue(media instanceof CategoryMediaXrefImpl);
    assertEquals("Dr", media.getTitle());
    assertEquals("Dr", media2.getTitle());
    assertEquals("Dr", categoryMediaXrefImpl2.getTitle());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setTitle(String)}.
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#setTitle(String)}
   */
  @Test
  public void testSetTitle3() {
    // Arrange
    CategoryImpl category = new CategoryImpl();
    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl(category, new MediaDto(), "Key");

    // Act
    categoryMediaXrefImpl2.setTitle("Dr");

    // Assert
    Media media = categoryMediaXrefImpl2.getMedia();
    assertTrue(media instanceof MediaDto);
    assertEquals("Dr", media.getTitle());
    assertEquals("Dr", categoryMediaXrefImpl2.getTitle());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setTitle(String)}.
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.</li>
   *   <li>Then {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media
   * {@link MediaImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#setTitle(String)}
   */
  @Test
  public void testSetTitle_givenCategoryMediaXrefImpl_thenCategoryMediaXrefImplMediaMediaImpl() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl();

    // Act
    categoryMediaXrefImpl2.setTitle("Dr");

    // Assert
    Media media = categoryMediaXrefImpl2.getMedia();
    assertTrue(media instanceof MediaImpl);
    assertEquals("Dr", media.getTitle());
    assertEquals("Dr", categoryMediaXrefImpl2.getTitle());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setTitle(String)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>Then throw {@link UnknownUnwrapTypeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#setTitle(String)}
   */
  @Test
  public void testSetTitle_givenJavaLangObject_thenThrowUnknownUnwrapTypeException() {
    // Arrange
    MediaImpl media = mock(MediaImpl.class);
    Class<Object> unwrapType = Object.class;
    doThrow(new UnknownUnwrapTypeException(unwrapType)).when(media).setTitle(Mockito.<String>any());

    // Act and Assert
    assertThrows(UnknownUnwrapTypeException.class,
        () -> (new CategoryMediaXrefImpl(new CategoryImpl(), media, "Key")).setTitle("Dr"));
    verify(media).setTitle(eq("Dr"));
  }

  /**
   * Test {@link CategoryMediaXrefImpl#getAltText()}.
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media is
   * {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#getAltText()}
   */
  @Test
  public void testGetAltText_givenCategoryMediaXrefImplMediaIsCategoryMediaXrefImpl() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNull(categoryMediaXrefImpl.getAltText());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#getAltText()}.
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media is
   * {@link MediaDto} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#getAltText()}
   */
  @Test
  public void testGetAltText_givenCategoryMediaXrefImplMediaIsMediaDto_thenReturnEmptyString() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(new MediaDto());

    // Act and Assert
    assertEquals("", categoryMediaXrefImpl.getAltText());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#getAltText()}.
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media is
   * {@link SkuMediaXrefImpl#SkuMediaXrefImpl()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#getAltText()}
   */
  @Test
  public void testGetAltText_givenCategoryMediaXrefImplMediaIsSkuMediaXrefImpl_thenReturnNull() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(new SkuMediaXrefImpl());

    // Act and Assert
    assertNull(categoryMediaXrefImpl.getAltText());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#getAltText()}.
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#getAltText()}
   */
  @Test
  public void testGetAltText_givenCategoryMediaXrefImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new CategoryMediaXrefImpl()).getAltText());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setAltText(String)}.
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#setAltText(String)}
   */
  @Test
  public void testSetAltText() {
    // Arrange
    CategoryImpl category = new CategoryImpl();
    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl(category, new CategoryMediaXrefImpl(),
        "Key");

    // Act
    categoryMediaXrefImpl2.setAltText("Alt Text");

    // Assert
    Media media = categoryMediaXrefImpl2.getMedia();
    Media media2 = ((CategoryMediaXrefImpl) media).getMedia();
    assertTrue(media2 instanceof MediaImpl);
    assertTrue(media instanceof CategoryMediaXrefImpl);
    assertEquals("Alt Text", media.getAltText());
    assertEquals("Alt Text", media2.getAltText());
    assertEquals("Alt Text", categoryMediaXrefImpl2.getAltText());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setAltText(String)}.
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#setAltText(String)}
   */
  @Test
  public void testSetAltText2() {
    // Arrange
    CategoryImpl category = mock(CategoryImpl.class);
    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl(category, new CategoryMediaXrefImpl(),
        "Key");

    // Act
    categoryMediaXrefImpl2.setAltText("Alt Text");

    // Assert
    Media media = categoryMediaXrefImpl2.getMedia();
    Media media2 = ((CategoryMediaXrefImpl) media).getMedia();
    assertTrue(media2 instanceof MediaImpl);
    assertTrue(media instanceof CategoryMediaXrefImpl);
    assertEquals("Alt Text", media.getAltText());
    assertEquals("Alt Text", media2.getAltText());
    assertEquals("Alt Text", categoryMediaXrefImpl2.getAltText());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setAltText(String)}.
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#setAltText(String)}
   */
  @Test
  public void testSetAltText3() {
    // Arrange
    CategoryImpl category = new CategoryImpl();
    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl(category, new MediaDto(), "Key");

    // Act
    categoryMediaXrefImpl2.setAltText("Alt Text");

    // Assert
    Media media = categoryMediaXrefImpl2.getMedia();
    assertTrue(media instanceof MediaDto);
    assertEquals("Alt Text", media.getAltText());
    assertEquals("Alt Text", categoryMediaXrefImpl2.getAltText());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setAltText(String)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>Then throw {@link UnknownUnwrapTypeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#setAltText(String)}
   */
  @Test
  public void testSetAltText_givenJavaLangObject_thenThrowUnknownUnwrapTypeException() {
    // Arrange
    MediaImpl media = mock(MediaImpl.class);
    Class<Object> unwrapType = Object.class;
    doThrow(new UnknownUnwrapTypeException(unwrapType)).when(media).setAltText(Mockito.<String>any());

    // Act and Assert
    assertThrows(UnknownUnwrapTypeException.class,
        () -> (new CategoryMediaXrefImpl(new CategoryImpl(), media, "Key")).setAltText("Alt Text"));
    verify(media).setAltText(eq("Alt Text"));
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setAltText(String)}.
   * <ul>
   *   <li>Then {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media
   * {@link MediaImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#setAltText(String)}
   */
  @Test
  public void testSetAltText_thenCategoryMediaXrefImplMediaMediaImpl() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl();

    // Act
    categoryMediaXrefImpl2.setAltText("Alt Text");

    // Assert
    Media media = categoryMediaXrefImpl2.getMedia();
    assertTrue(media instanceof MediaImpl);
    assertEquals("Alt Text", media.getAltText());
    assertEquals("Alt Text", categoryMediaXrefImpl2.getAltText());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#getTags()}.
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media is
   * {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#getTags()}
   */
  @Test
  public void testGetTags_givenCategoryMediaXrefImplMediaIsCategoryMediaXrefImpl() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNull(categoryMediaXrefImpl.getTags());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#getTags()}.
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media is
   * {@link MediaDto} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#getTags()}
   */
  @Test
  public void testGetTags_givenCategoryMediaXrefImplMediaIsMediaDto_thenReturnEmptyString() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(new MediaDto());

    // Act and Assert
    assertEquals("", categoryMediaXrefImpl.getTags());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#getTags()}.
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media is
   * {@link SkuMediaXrefImpl#SkuMediaXrefImpl()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#getTags()}
   */
  @Test
  public void testGetTags_givenCategoryMediaXrefImplMediaIsSkuMediaXrefImpl_thenReturnNull() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(new SkuMediaXrefImpl());

    // Act and Assert
    assertNull(categoryMediaXrefImpl.getTags());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#getTags()}.
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#getTags()}
   */
  @Test
  public void testGetTags_givenCategoryMediaXrefImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new CategoryMediaXrefImpl()).getTags());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setTags(String)}.
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#setTags(String)}
   */
  @Test
  public void testSetTags() {
    // Arrange
    CategoryImpl category = new CategoryImpl();
    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl(category, new CategoryMediaXrefImpl(),
        "Key");

    // Act
    categoryMediaXrefImpl2.setTags("Tags");

    // Assert
    Media media = categoryMediaXrefImpl2.getMedia();
    Media media2 = ((CategoryMediaXrefImpl) media).getMedia();
    assertTrue(media2 instanceof MediaImpl);
    assertTrue(media instanceof CategoryMediaXrefImpl);
    assertEquals("Tags", media.getTags());
    assertEquals("Tags", media2.getTags());
    assertEquals("Tags", categoryMediaXrefImpl2.getTags());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setTags(String)}.
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#setTags(String)}
   */
  @Test
  public void testSetTags2() {
    // Arrange
    CategoryImpl category = mock(CategoryImpl.class);
    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl(category, new CategoryMediaXrefImpl(),
        "Key");

    // Act
    categoryMediaXrefImpl2.setTags("Tags");

    // Assert
    Media media = categoryMediaXrefImpl2.getMedia();
    Media media2 = ((CategoryMediaXrefImpl) media).getMedia();
    assertTrue(media2 instanceof MediaImpl);
    assertTrue(media instanceof CategoryMediaXrefImpl);
    assertEquals("Tags", media.getTags());
    assertEquals("Tags", media2.getTags());
    assertEquals("Tags", categoryMediaXrefImpl2.getTags());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setTags(String)}.
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#setTags(String)}
   */
  @Test
  public void testSetTags3() {
    // Arrange
    CategoryImpl category = new CategoryImpl();
    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl(category, new MediaDto(), "Key");

    // Act
    categoryMediaXrefImpl2.setTags("Tags");

    // Assert
    Media media = categoryMediaXrefImpl2.getMedia();
    assertTrue(media instanceof MediaDto);
    assertEquals("Tags", media.getTags());
    assertEquals("Tags", categoryMediaXrefImpl2.getTags());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setTags(String)}.
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.</li>
   *   <li>Then {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media
   * {@link MediaImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#setTags(String)}
   */
  @Test
  public void testSetTags_givenCategoryMediaXrefImpl_thenCategoryMediaXrefImplMediaMediaImpl() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl();

    // Act
    categoryMediaXrefImpl2.setTags("Tags");

    // Assert
    Media media = categoryMediaXrefImpl2.getMedia();
    assertTrue(media instanceof MediaImpl);
    assertEquals("Tags", media.getTags());
    assertEquals("Tags", categoryMediaXrefImpl2.getTags());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setTags(String)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>Then throw {@link UnknownUnwrapTypeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#setTags(String)}
   */
  @Test
  public void testSetTags_givenJavaLangObject_thenThrowUnknownUnwrapTypeException() {
    // Arrange
    MediaImpl media = mock(MediaImpl.class);
    Class<Object> unwrapType = Object.class;
    doThrow(new UnknownUnwrapTypeException(unwrapType)).when(media).setTags(Mockito.<String>any());

    // Act and Assert
    assertThrows(UnknownUnwrapTypeException.class,
        () -> (new CategoryMediaXrefImpl(new CategoryImpl(), media, "Key")).setTags("Tags"));
    verify(media).setTags(eq("Tags"));
  }

  /**
   * Test {@link CategoryMediaXrefImpl#isUnwrappableAs(Class)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#isUnwrappableAs(Class)}
   */
  @Test
  public void testIsUnwrappableAs_thenReturnTrue() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    Class<Media> unwrapType = Media.class;

    // Act and Assert
    assertTrue(categoryMediaXrefImpl.isUnwrappableAs(unwrapType));
  }

  /**
   * Test {@link CategoryMediaXrefImpl#isUnwrappableAs(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#isUnwrappableAs(Class)}
   */
  @Test
  public void testIsUnwrappableAs_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    Class<Object> unwrapType = Object.class;

    // Act and Assert
    assertFalse(categoryMediaXrefImpl.isUnwrappableAs(unwrapType));
  }

  /**
   * Test {@link CategoryMediaXrefImpl#unwrap(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then throw {@link UnknownUnwrapTypeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#unwrap(Class)}
   */
  @Test
  public void testUnwrap_whenJavaLangObject_thenThrowUnknownUnwrapTypeException() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    Class<Object> unwrapType = Object.class;

    // Act and Assert
    assertThrows(UnknownUnwrapTypeException.class, () -> categoryMediaXrefImpl.unwrap(unwrapType));
  }

  /**
   * Test {@link CategoryMediaXrefImpl#unwrap(Class)}.
   * <ul>
   *   <li>When {@code org.broadleafcommerce.common.media.domain.Media}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#unwrap(Class)}
   */
  @Test
  public void testUnwrap_whenOrgBroadleafcommerceCommonMediaDomainMedia_thenReturnNull() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    Class<Media> unwrapType = Media.class;

    // Act and Assert
    assertNull(categoryMediaXrefImpl.unwrap(unwrapType));
  }

  /**
   * Test {@link CategoryMediaXrefImpl#equals(Object)}, and
   * {@link CategoryMediaXrefImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryMediaXrefImpl#equals(Object)}
   *   <li>{@link CategoryMediaXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl2.setCategory(new CategoryImpl());
    categoryMediaXrefImpl2.setId(1L);
    categoryMediaXrefImpl2.setKey("Key");
    categoryMediaXrefImpl2.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertEquals(categoryMediaXrefImpl, categoryMediaXrefImpl2);
    int expectedHashCodeResult = categoryMediaXrefImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryMediaXrefImpl2.hashCode());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#equals(Object)}, and
   * {@link CategoryMediaXrefImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryMediaXrefImpl#equals(Object)}
   *   <li>{@link CategoryMediaXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertEquals(categoryMediaXrefImpl, categoryMediaXrefImpl);
    int expectedHashCodeResult = categoryMediaXrefImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryMediaXrefImpl.hashCode());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(null);
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl2.setCategory(new CategoryImpl());
    categoryMediaXrefImpl2.setId(1L);
    categoryMediaXrefImpl2.setKey("Key");
    categoryMediaXrefImpl2.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNotEquals(categoryMediaXrefImpl, categoryMediaXrefImpl2);
  }

  /**
   * Test {@link CategoryMediaXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(mock(CategoryImpl.class));
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl2.setCategory(new CategoryImpl());
    categoryMediaXrefImpl2.setId(1L);
    categoryMediaXrefImpl2.setKey("Key");
    categoryMediaXrefImpl2.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNotEquals(categoryMediaXrefImpl, categoryMediaXrefImpl2);
  }

  /**
   * Test {@link CategoryMediaXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey(null);
    categoryMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl2.setCategory(new CategoryImpl());
    categoryMediaXrefImpl2.setId(1L);
    categoryMediaXrefImpl2.setKey("Key");
    categoryMediaXrefImpl2.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNotEquals(categoryMediaXrefImpl, categoryMediaXrefImpl2);
  }

  /**
   * Test {@link CategoryMediaXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("org.broadleafcommerce.common.media.domain.Media");
    categoryMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl2.setCategory(new CategoryImpl());
    categoryMediaXrefImpl2.setId(1L);
    categoryMediaXrefImpl2.setKey("Key");
    categoryMediaXrefImpl2.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNotEquals(categoryMediaXrefImpl, categoryMediaXrefImpl2);
  }

  /**
   * Test {@link CategoryMediaXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(null);

    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl2.setCategory(new CategoryImpl());
    categoryMediaXrefImpl2.setId(1L);
    categoryMediaXrefImpl2.setKey("Key");
    categoryMediaXrefImpl2.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNotEquals(categoryMediaXrefImpl, categoryMediaXrefImpl2);
  }

  /**
   * Test {@link CategoryMediaXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    CategoryImpl category = new CategoryImpl();
    categoryMediaXrefImpl.setMedia(new CategoryMediaXrefImpl(category, new CategoryMediaXrefImpl(), "Key"));

    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl2.setCategory(new CategoryImpl());
    categoryMediaXrefImpl2.setId(1L);
    categoryMediaXrefImpl2.setKey("Key");
    categoryMediaXrefImpl2.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNotEquals(categoryMediaXrefImpl, categoryMediaXrefImpl2);
  }

  /**
   * Test {@link CategoryMediaXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(new SkuMediaXrefImpl());

    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl2.setCategory(new CategoryImpl());
    categoryMediaXrefImpl2.setId(1L);
    categoryMediaXrefImpl2.setKey("Key");
    categoryMediaXrefImpl2.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNotEquals(categoryMediaXrefImpl, categoryMediaXrefImpl2);
  }

  /**
   * Test {@link CategoryMediaXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNotEquals(categoryMediaXrefImpl, null);
  }

  /**
   * Test {@link CategoryMediaXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryMediaXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNotEquals(categoryMediaXrefImpl, "Different type to CategoryMediaXrefImpl");
  }

  /**
   * Test
   * {@link CategoryMediaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link CategoryMediaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<CategoryMediaXrefImpl> actualCreateOrRetrieveCopyInstanceResult = categoryMediaXrefImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link CategoryMediaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then calls {@link CreateResponse#getClone()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryMediaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCallsGetClone() throws CloneNotSupportedException {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();

    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl2.setCategory(new CategoryImpl());
    categoryMediaXrefImpl2.setId(1L);
    categoryMediaXrefImpl2.setKey("Key");
    categoryMediaXrefImpl2.setMedia(new CategoryMediaXrefImpl());
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(categoryMediaXrefImpl2);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    categoryMediaXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
  }

  /**
   * Test
   * {@link CategoryMediaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then return not AlreadyPopulated.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryMediaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenReturnNotAlreadyPopulated() throws CloneNotSupportedException {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<CategoryMediaXrefImpl> actualCreateOrRetrieveCopyInstanceResult = categoryMediaXrefImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.core.catalog.domain.CategoryMediaXrefImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(categoryMediaXrefImpl, actualCreateOrRetrieveCopyInstanceResult.getClone());
  }
}
