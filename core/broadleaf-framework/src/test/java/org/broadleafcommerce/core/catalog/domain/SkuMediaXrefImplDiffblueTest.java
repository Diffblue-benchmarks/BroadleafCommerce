/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.media.domain.Media;
import org.broadleafcommerce.common.media.domain.MediaDto;
import org.broadleafcommerce.common.media.domain.MediaImpl;
import org.broadleafcommerce.common.util.UnknownUnwrapTypeException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {SkuMediaXrefImpl.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class SkuMediaXrefImplDiffblueTest {
  @Autowired private SkuMediaXrefImpl skuMediaXrefImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuMediaXrefImpl#SkuMediaXrefImpl()}
   *   <li>{@link SkuMediaXrefImpl#setId(Long)}
   *   <li>{@link SkuMediaXrefImpl#setKey(String)}
   *   <li>{@link SkuMediaXrefImpl#setMedia(Media)}
   *   <li>{@link SkuMediaXrefImpl#setSku(Sku)}
   *   <li>{@link SkuMediaXrefImpl#getId()}
   *   <li>{@link SkuMediaXrefImpl#getKey()}
   *   <li>{@link SkuMediaXrefImpl#getMedia()}
   *   <li>{@link SkuMediaXrefImpl#getSku()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuMediaXrefImpl.<init>()",
    "void SkuMediaXrefImpl.<init>(Sku, Media, String)",
    "Long SkuMediaXrefImpl.getId()",
    "String SkuMediaXrefImpl.getKey()",
    "Media SkuMediaXrefImpl.getMedia()",
    "Sku SkuMediaXrefImpl.getSku()",
    "void SkuMediaXrefImpl.setId(Long)",
    "void SkuMediaXrefImpl.setKey(String)",
    "void SkuMediaXrefImpl.setMedia(Media)",
    "void SkuMediaXrefImpl.setSku(Sku)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    SkuMediaXrefImpl actualSkuMediaXrefImpl = new SkuMediaXrefImpl();
    actualSkuMediaXrefImpl.setId(1L);
    actualSkuMediaXrefImpl.setKey("Key");
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    actualSkuMediaXrefImpl.setMedia(media);
    SkuImpl sku = new SkuImpl();
    actualSkuMediaXrefImpl.setSku(sku);
    Long actualId = actualSkuMediaXrefImpl.getId();
    String actualKey = actualSkuMediaXrefImpl.getKey();
    Media actualMedia = actualSkuMediaXrefImpl.getMedia();
    Sku actualSku = actualSkuMediaXrefImpl.getSku();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals(1L, actualId.longValue());
    assertSame(media, actualMedia);
    assertSame(sku, actualSku);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuMediaXrefImpl#SkuMediaXrefImpl(Sku, Media, String)}
   *   <li>{@link SkuMediaXrefImpl#setId(Long)}
   *   <li>{@link SkuMediaXrefImpl#setKey(String)}
   *   <li>{@link SkuMediaXrefImpl#setMedia(Media)}
   *   <li>{@link SkuMediaXrefImpl#setSku(Sku)}
   *   <li>{@link SkuMediaXrefImpl#getId()}
   *   <li>{@link SkuMediaXrefImpl#getKey()}
   *   <li>{@link SkuMediaXrefImpl#getMedia()}
   *   <li>{@link SkuMediaXrefImpl#getSku()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuMediaXrefImpl.<init>()",
    "void SkuMediaXrefImpl.<init>(Sku, Media, String)",
    "Long SkuMediaXrefImpl.getId()",
    "String SkuMediaXrefImpl.getKey()",
    "Media SkuMediaXrefImpl.getMedia()",
    "Sku SkuMediaXrefImpl.getSku()",
    "void SkuMediaXrefImpl.setId(Long)",
    "void SkuMediaXrefImpl.setKey(String)",
    "void SkuMediaXrefImpl.setMedia(Media)",
    "void SkuMediaXrefImpl.setSku(Sku)"
  })
  public void testGettersAndSetters_whenSkuImpl() {
    // Arrange
    SkuImpl sku = new SkuImpl();

    // Act
    SkuMediaXrefImpl actualSkuMediaXrefImpl =
        new SkuMediaXrefImpl(sku, new CategoryMediaXrefImpl(), "Key");
    actualSkuMediaXrefImpl.setId(1L);
    actualSkuMediaXrefImpl.setKey("Key");
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    actualSkuMediaXrefImpl.setMedia(media);
    SkuImpl sku2 = new SkuImpl();
    actualSkuMediaXrefImpl.setSku(sku2);
    Long actualId = actualSkuMediaXrefImpl.getId();
    String actualKey = actualSkuMediaXrefImpl.getKey();
    Media actualMedia = actualSkuMediaXrefImpl.getMedia();
    Sku actualSku = actualSkuMediaXrefImpl.getSku();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals(1L, actualId.longValue());
    assertSame(media, actualMedia);
    assertSame(sku2, actualSku);
  }

  /**
   * Test {@link SkuMediaXrefImpl#getUrl()}.
   *
   * <ul>
   *   <li>Given {@link SkuMediaXrefImpl#SkuMediaXrefImpl()} Media is {@link
   *       CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#getUrl()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SkuMediaXrefImpl.getUrl()"})
  public void testGetUrl_givenSkuMediaXrefImplMediaIsCategoryMediaXrefImpl_thenReturnNull() {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    skuMediaXrefImpl.setId(1L);
    skuMediaXrefImpl.setKey("Key");
    skuMediaXrefImpl.setSku(new SkuImpl());
    skuMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNull(skuMediaXrefImpl.getUrl());
  }

  /**
   * Test {@link SkuMediaXrefImpl#getUrl()}.
   *
   * <ul>
   *   <li>Given {@link SkuMediaXrefImpl#SkuMediaXrefImpl()} Media is {@link MediaDto} (default
   *       constructor).
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#getUrl()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SkuMediaXrefImpl.getUrl()"})
  public void testGetUrl_givenSkuMediaXrefImplMediaIsMediaDto_thenReturnEmptyString() {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    skuMediaXrefImpl.setId(1L);
    skuMediaXrefImpl.setKey("Key");
    skuMediaXrefImpl.setSku(new SkuImpl());
    skuMediaXrefImpl.setMedia(new MediaDto());

    // Act and Assert
    assertEquals("", skuMediaXrefImpl.getUrl());
  }

  /**
   * Test {@link SkuMediaXrefImpl#getUrl()}.
   *
   * <ul>
   *   <li>Given {@link SkuMediaXrefImpl#SkuMediaXrefImpl()} Media is {@link
   *       SkuMediaXrefImpl#SkuMediaXrefImpl()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#getUrl()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SkuMediaXrefImpl.getUrl()"})
  public void testGetUrl_givenSkuMediaXrefImplMediaIsSkuMediaXrefImpl_thenReturnNull() {
    // Arrange
    SkuMediaXrefImpl media = new SkuMediaXrefImpl();
    media.setId(1L);
    media.setKey("Key");
    media.setMedia(new CategoryMediaXrefImpl());
    media.setSku(new SkuImpl());

    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    skuMediaXrefImpl.setId(1L);
    skuMediaXrefImpl.setKey("Key");
    skuMediaXrefImpl.setSku(new SkuImpl());
    skuMediaXrefImpl.setMedia(media);

    // Act and Assert
    assertNull(skuMediaXrefImpl.getUrl());
  }

  /**
   * Test {@link SkuMediaXrefImpl#getUrl()}.
   *
   * <ul>
   *   <li>Given {@link SkuMediaXrefImpl#SkuMediaXrefImpl()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#getUrl()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SkuMediaXrefImpl.getUrl()"})
  public void testGetUrl_givenSkuMediaXrefImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new SkuMediaXrefImpl().getUrl());
  }

  /**
   * Test {@link SkuMediaXrefImpl#setUrl(String)}.
   *
   * <ul>
   *   <li>Given {@link SkuMediaXrefImpl}.
   *   <li>Then {@link SkuMediaXrefImpl} Media {@link MediaImpl}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#setUrl(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuMediaXrefImpl.setUrl(String)"})
  public void testSetUrl_givenSkuMediaXrefImpl_thenSkuMediaXrefImplMediaMediaImpl() {
    // Arrange and Act
    skuMediaXrefImpl.setUrl("https://example.org/example");

    // Assert
    Media media = skuMediaXrefImpl.getMedia();
    assertTrue(media instanceof MediaImpl);
    assertEquals("https://example.org/example", media.getUrl());
    assertEquals("https://example.org/example", skuMediaXrefImpl.getUrl());
  }

  /**
   * Test {@link SkuMediaXrefImpl#setUrl(String)}.
   *
   * <ul>
   *   <li>Then {@link SkuMediaXrefImpl} Media {@link MediaDto}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#setUrl(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuMediaXrefImpl.setUrl(String)"})
  public void testSetUrl_thenSkuMediaXrefImplMediaMediaDto() {
    // Arrange
    skuMediaXrefImpl.setMedia(new MediaDto());

    // Act
    skuMediaXrefImpl.setUrl("https://example.org/example");

    // Assert
    Media media = skuMediaXrefImpl.getMedia();
    assertTrue(media instanceof MediaDto);
    assertEquals("https://example.org/example", media.getUrl());
    assertEquals("https://example.org/example", skuMediaXrefImpl.getUrl());
  }

  /**
   * Test {@link SkuMediaXrefImpl#setUrl(String)}.
   *
   * <ul>
   *   <li>Then {@link SkuMediaXrefImpl} Media Media {@link MediaImpl}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#setUrl(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuMediaXrefImpl.setUrl(String)"})
  public void testSetUrl_thenSkuMediaXrefImplMediaMediaMediaImpl() {
    // Arrange
    skuMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    // Act
    skuMediaXrefImpl.setUrl("https://example.org/example");

    // Assert
    Media media = skuMediaXrefImpl.getMedia();
    Media media2 = ((CategoryMediaXrefImpl) media).getMedia();
    assertTrue(media2 instanceof MediaImpl);
    assertTrue(media instanceof CategoryMediaXrefImpl);
    assertEquals("https://example.org/example", media2.getUrl());
    assertEquals("https://example.org/example", media.getUrl());
    assertEquals("https://example.org/example", skuMediaXrefImpl.getUrl());
  }

  /**
   * Test {@link SkuMediaXrefImpl#setUrl(String)}.
   *
   * <ul>
   *   <li>Then {@link SkuMediaXrefImpl} Media Media Media {@link MediaImpl}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#setUrl(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuMediaXrefImpl.setUrl(String)"})
  public void testSetUrl_thenSkuMediaXrefImplMediaMediaMediaMediaImpl() {
    // Arrange
    SkuMediaXrefImpl media = new SkuMediaXrefImpl();
    media.setId(1L);
    media.setKey("Key");
    media.setMedia(new CategoryMediaXrefImpl());
    media.setSku(new SkuImpl());
    skuMediaXrefImpl.setMedia(media);

    // Act
    skuMediaXrefImpl.setUrl("https://example.org/example");

    // Assert
    Media media2 = skuMediaXrefImpl.getMedia();
    Media media3 = ((SkuMediaXrefImpl) media2).getMedia();
    Media media4 = ((CategoryMediaXrefImpl) media3).getMedia();
    assertTrue(media4 instanceof MediaImpl);
    assertTrue(media3 instanceof CategoryMediaXrefImpl);
    assertTrue(media2 instanceof SkuMediaXrefImpl);
    assertEquals("https://example.org/example", media4.getUrl());
    assertEquals("https://example.org/example", media2.getUrl());
    assertEquals("https://example.org/example", media3.getUrl());
    assertEquals("https://example.org/example", skuMediaXrefImpl.getUrl());
  }

  /**
   * Test {@link SkuMediaXrefImpl#getTitle()}.
   *
   * <ul>
   *   <li>Given {@link SkuMediaXrefImpl#SkuMediaXrefImpl()} Media is {@link
   *       CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#getTitle()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SkuMediaXrefImpl.getTitle()"})
  public void testGetTitle_givenSkuMediaXrefImplMediaIsCategoryMediaXrefImpl_thenReturnNull() {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    skuMediaXrefImpl.setId(1L);
    skuMediaXrefImpl.setKey("Key");
    skuMediaXrefImpl.setSku(new SkuImpl());
    skuMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNull(skuMediaXrefImpl.getTitle());
  }

  /**
   * Test {@link SkuMediaXrefImpl#getTitle()}.
   *
   * <ul>
   *   <li>Given {@link SkuMediaXrefImpl#SkuMediaXrefImpl()} Media is {@link MediaDto} (default
   *       constructor).
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#getTitle()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SkuMediaXrefImpl.getTitle()"})
  public void testGetTitle_givenSkuMediaXrefImplMediaIsMediaDto_thenReturnEmptyString() {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    skuMediaXrefImpl.setId(1L);
    skuMediaXrefImpl.setKey("Key");
    skuMediaXrefImpl.setSku(new SkuImpl());
    skuMediaXrefImpl.setMedia(new MediaDto());

    // Act and Assert
    assertEquals("", skuMediaXrefImpl.getTitle());
  }

  /**
   * Test {@link SkuMediaXrefImpl#getTitle()}.
   *
   * <ul>
   *   <li>Given {@link SkuMediaXrefImpl#SkuMediaXrefImpl()} Media is {@link
   *       SkuMediaXrefImpl#SkuMediaXrefImpl()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#getTitle()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SkuMediaXrefImpl.getTitle()"})
  public void testGetTitle_givenSkuMediaXrefImplMediaIsSkuMediaXrefImpl_thenReturnNull() {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    skuMediaXrefImpl.setId(1L);
    skuMediaXrefImpl.setKey("Key");
    skuMediaXrefImpl.setSku(new SkuImpl());
    skuMediaXrefImpl.setMedia(new SkuMediaXrefImpl());

    // Act and Assert
    assertNull(skuMediaXrefImpl.getTitle());
  }

  /**
   * Test {@link SkuMediaXrefImpl#getTitle()}.
   *
   * <ul>
   *   <li>Given {@link SkuMediaXrefImpl#SkuMediaXrefImpl()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#getTitle()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SkuMediaXrefImpl.getTitle()"})
  public void testGetTitle_givenSkuMediaXrefImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new SkuMediaXrefImpl().getTitle());
  }

  /**
   * Test {@link SkuMediaXrefImpl#setTitle(String)}.
   *
   * <ul>
   *   <li>Given {@link SkuMediaXrefImpl}.
   *   <li>When {@code Dr}.
   *   <li>Then {@link SkuMediaXrefImpl} Media {@link MediaImpl}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#setTitle(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuMediaXrefImpl.setTitle(String)"})
  public void testSetTitle_givenSkuMediaXrefImpl_whenDr_thenSkuMediaXrefImplMediaMediaImpl() {
    // Arrange and Act
    skuMediaXrefImpl.setTitle("Dr");

    // Assert
    Media media = skuMediaXrefImpl.getMedia();
    assertTrue(media instanceof MediaImpl);
    assertEquals("Dr", media.getTitle());
    assertEquals("Dr", skuMediaXrefImpl.getTitle());
  }

  /**
   * Test {@link SkuMediaXrefImpl#setTitle(String)}.
   *
   * <ul>
   *   <li>Then {@link SkuMediaXrefImpl} Media {@link MediaDto}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#setTitle(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuMediaXrefImpl.setTitle(String)"})
  public void testSetTitle_thenSkuMediaXrefImplMediaMediaDto() {
    // Arrange
    skuMediaXrefImpl.setMedia(new MediaDto());

    // Act
    skuMediaXrefImpl.setTitle("Dr");

    // Assert
    Media media = skuMediaXrefImpl.getMedia();
    assertTrue(media instanceof MediaDto);
    assertEquals("Dr", media.getTitle());
    assertEquals("Dr", skuMediaXrefImpl.getTitle());
  }

  /**
   * Test {@link SkuMediaXrefImpl#setTitle(String)}.
   *
   * <ul>
   *   <li>Then {@link SkuMediaXrefImpl} Media Media {@link MediaImpl}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#setTitle(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuMediaXrefImpl.setTitle(String)"})
  public void testSetTitle_thenSkuMediaXrefImplMediaMediaMediaImpl() {
    // Arrange
    skuMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    // Act
    skuMediaXrefImpl.setTitle("Dr");

    // Assert
    Media media = skuMediaXrefImpl.getMedia();
    Media media2 = ((CategoryMediaXrefImpl) media).getMedia();
    assertTrue(media2 instanceof MediaImpl);
    assertTrue(media instanceof CategoryMediaXrefImpl);
    assertEquals("Dr", media2.getTitle());
    assertEquals("Dr", media.getTitle());
    assertEquals("Dr", skuMediaXrefImpl.getTitle());
  }

  /**
   * Test {@link SkuMediaXrefImpl#setTitle(String)}.
   *
   * <ul>
   *   <li>Then {@link SkuMediaXrefImpl} Media Media Media {@link MediaImpl}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#setTitle(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuMediaXrefImpl.setTitle(String)"})
  public void testSetTitle_thenSkuMediaXrefImplMediaMediaMediaMediaImpl() {
    // Arrange
    SkuMediaXrefImpl media = new SkuMediaXrefImpl();
    media.setId(1L);
    media.setKey("Key");
    media.setMedia(new CategoryMediaXrefImpl());
    media.setSku(new SkuImpl());
    skuMediaXrefImpl.setMedia(media);

    // Act
    skuMediaXrefImpl.setTitle("Dr");

    // Assert
    Media media2 = skuMediaXrefImpl.getMedia();
    Media media3 = ((SkuMediaXrefImpl) media2).getMedia();
    Media media4 = ((CategoryMediaXrefImpl) media3).getMedia();
    assertTrue(media4 instanceof MediaImpl);
    assertTrue(media3 instanceof CategoryMediaXrefImpl);
    assertTrue(media2 instanceof SkuMediaXrefImpl);
    assertEquals("Dr", media4.getTitle());
    assertEquals("Dr", media2.getTitle());
    assertEquals("Dr", media3.getTitle());
    assertEquals("Dr", skuMediaXrefImpl.getTitle());
  }

  /**
   * Test {@link SkuMediaXrefImpl#getAltText()}.
   *
   * <ul>
   *   <li>Given {@link SkuMediaXrefImpl#SkuMediaXrefImpl()} Media is {@link
   *       CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#getAltText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SkuMediaXrefImpl.getAltText()"})
  public void testGetAltText_givenSkuMediaXrefImplMediaIsCategoryMediaXrefImpl_thenReturnNull() {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    skuMediaXrefImpl.setId(1L);
    skuMediaXrefImpl.setKey("Key");
    skuMediaXrefImpl.setSku(new SkuImpl());
    skuMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNull(skuMediaXrefImpl.getAltText());
  }

  /**
   * Test {@link SkuMediaXrefImpl#getAltText()}.
   *
   * <ul>
   *   <li>Given {@link SkuMediaXrefImpl#SkuMediaXrefImpl()} Media is {@link MediaDto} (default
   *       constructor).
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#getAltText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SkuMediaXrefImpl.getAltText()"})
  public void testGetAltText_givenSkuMediaXrefImplMediaIsMediaDto_thenReturnEmptyString() {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    skuMediaXrefImpl.setId(1L);
    skuMediaXrefImpl.setKey("Key");
    skuMediaXrefImpl.setSku(new SkuImpl());
    skuMediaXrefImpl.setMedia(new MediaDto());

    // Act and Assert
    assertEquals("", skuMediaXrefImpl.getAltText());
  }

  /**
   * Test {@link SkuMediaXrefImpl#getAltText()}.
   *
   * <ul>
   *   <li>Given {@link SkuMediaXrefImpl#SkuMediaXrefImpl()} Media is {@link
   *       SkuMediaXrefImpl#SkuMediaXrefImpl()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#getAltText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SkuMediaXrefImpl.getAltText()"})
  public void testGetAltText_givenSkuMediaXrefImplMediaIsSkuMediaXrefImpl_thenReturnNull() {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    skuMediaXrefImpl.setId(1L);
    skuMediaXrefImpl.setKey("Key");
    skuMediaXrefImpl.setSku(new SkuImpl());
    skuMediaXrefImpl.setMedia(new SkuMediaXrefImpl());

    // Act and Assert
    assertNull(skuMediaXrefImpl.getAltText());
  }

  /**
   * Test {@link SkuMediaXrefImpl#getAltText()}.
   *
   * <ul>
   *   <li>Given {@link SkuMediaXrefImpl#SkuMediaXrefImpl()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#getAltText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SkuMediaXrefImpl.getAltText()"})
  public void testGetAltText_givenSkuMediaXrefImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new SkuMediaXrefImpl().getAltText());
  }

  /**
   * Test {@link SkuMediaXrefImpl#setAltText(String)}.
   *
   * <ul>
   *   <li>Given {@link SkuMediaXrefImpl}.
   *   <li>Then {@link SkuMediaXrefImpl} Media {@link MediaImpl}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#setAltText(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuMediaXrefImpl.setAltText(String)"})
  public void testSetAltText_givenSkuMediaXrefImpl_thenSkuMediaXrefImplMediaMediaImpl() {
    // Arrange and Act
    skuMediaXrefImpl.setAltText("Alt Text");

    // Assert
    Media media = skuMediaXrefImpl.getMedia();
    assertTrue(media instanceof MediaImpl);
    assertEquals("Alt Text", media.getAltText());
    assertEquals("Alt Text", skuMediaXrefImpl.getAltText());
  }

  /**
   * Test {@link SkuMediaXrefImpl#setAltText(String)}.
   *
   * <ul>
   *   <li>Then {@link SkuMediaXrefImpl} Media {@link MediaDto}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#setAltText(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuMediaXrefImpl.setAltText(String)"})
  public void testSetAltText_thenSkuMediaXrefImplMediaMediaDto() {
    // Arrange
    skuMediaXrefImpl.setMedia(new MediaDto());

    // Act
    skuMediaXrefImpl.setAltText("Alt Text");

    // Assert
    Media media = skuMediaXrefImpl.getMedia();
    assertTrue(media instanceof MediaDto);
    assertEquals("Alt Text", media.getAltText());
    assertEquals("Alt Text", skuMediaXrefImpl.getAltText());
  }

  /**
   * Test {@link SkuMediaXrefImpl#setAltText(String)}.
   *
   * <ul>
   *   <li>Then {@link SkuMediaXrefImpl} Media Media {@link MediaImpl}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#setAltText(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuMediaXrefImpl.setAltText(String)"})
  public void testSetAltText_thenSkuMediaXrefImplMediaMediaMediaImpl() {
    // Arrange
    skuMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    // Act
    skuMediaXrefImpl.setAltText("Alt Text");

    // Assert
    Media media = skuMediaXrefImpl.getMedia();
    Media media2 = ((CategoryMediaXrefImpl) media).getMedia();
    assertTrue(media2 instanceof MediaImpl);
    assertTrue(media instanceof CategoryMediaXrefImpl);
    assertEquals("Alt Text", media2.getAltText());
    assertEquals("Alt Text", media.getAltText());
    assertEquals("Alt Text", skuMediaXrefImpl.getAltText());
  }

  /**
   * Test {@link SkuMediaXrefImpl#setAltText(String)}.
   *
   * <ul>
   *   <li>Then {@link SkuMediaXrefImpl} Media Media Media {@link MediaImpl}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#setAltText(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuMediaXrefImpl.setAltText(String)"})
  public void testSetAltText_thenSkuMediaXrefImplMediaMediaMediaMediaImpl() {
    // Arrange
    SkuMediaXrefImpl media = new SkuMediaXrefImpl();
    media.setId(1L);
    media.setKey("Key");
    media.setMedia(new CategoryMediaXrefImpl());
    media.setSku(new SkuImpl());
    skuMediaXrefImpl.setMedia(media);

    // Act
    skuMediaXrefImpl.setAltText("Alt Text");

    // Assert
    Media media2 = skuMediaXrefImpl.getMedia();
    Media media3 = ((SkuMediaXrefImpl) media2).getMedia();
    Media media4 = ((CategoryMediaXrefImpl) media3).getMedia();
    assertTrue(media4 instanceof MediaImpl);
    assertTrue(media3 instanceof CategoryMediaXrefImpl);
    assertTrue(media2 instanceof SkuMediaXrefImpl);
    assertEquals("Alt Text", media4.getAltText());
    assertEquals("Alt Text", media2.getAltText());
    assertEquals("Alt Text", media3.getAltText());
    assertEquals("Alt Text", skuMediaXrefImpl.getAltText());
  }

  /**
   * Test {@link SkuMediaXrefImpl#getTags()}.
   *
   * <ul>
   *   <li>Given {@link SkuMediaXrefImpl#SkuMediaXrefImpl()} Media is {@link
   *       CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#getTags()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SkuMediaXrefImpl.getTags()"})
  public void testGetTags_givenSkuMediaXrefImplMediaIsCategoryMediaXrefImpl_thenReturnNull() {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    skuMediaXrefImpl.setId(1L);
    skuMediaXrefImpl.setKey("Key");
    skuMediaXrefImpl.setSku(new SkuImpl());
    skuMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNull(skuMediaXrefImpl.getTags());
  }

  /**
   * Test {@link SkuMediaXrefImpl#getTags()}.
   *
   * <ul>
   *   <li>Given {@link SkuMediaXrefImpl#SkuMediaXrefImpl()} Media is {@link MediaDto} (default
   *       constructor).
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#getTags()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SkuMediaXrefImpl.getTags()"})
  public void testGetTags_givenSkuMediaXrefImplMediaIsMediaDto_thenReturnEmptyString() {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    skuMediaXrefImpl.setId(1L);
    skuMediaXrefImpl.setKey("Key");
    skuMediaXrefImpl.setSku(new SkuImpl());
    skuMediaXrefImpl.setMedia(new MediaDto());

    // Act and Assert
    assertEquals("", skuMediaXrefImpl.getTags());
  }

  /**
   * Test {@link SkuMediaXrefImpl#getTags()}.
   *
   * <ul>
   *   <li>Given {@link SkuMediaXrefImpl#SkuMediaXrefImpl()} Media is {@link
   *       SkuMediaXrefImpl#SkuMediaXrefImpl()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#getTags()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SkuMediaXrefImpl.getTags()"})
  public void testGetTags_givenSkuMediaXrefImplMediaIsSkuMediaXrefImpl_thenReturnNull() {
    // Arrange
    SkuMediaXrefImpl media = new SkuMediaXrefImpl();
    media.setId(1L);
    media.setKey("Key");
    media.setMedia(new CategoryMediaXrefImpl());
    media.setSku(new SkuImpl());

    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    skuMediaXrefImpl.setId(1L);
    skuMediaXrefImpl.setKey("Key");
    skuMediaXrefImpl.setSku(new SkuImpl());
    skuMediaXrefImpl.setMedia(media);

    // Act and Assert
    assertNull(skuMediaXrefImpl.getTags());
  }

  /**
   * Test {@link SkuMediaXrefImpl#getTags()}.
   *
   * <ul>
   *   <li>Given {@link SkuMediaXrefImpl#SkuMediaXrefImpl()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#getTags()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SkuMediaXrefImpl.getTags()"})
  public void testGetTags_givenSkuMediaXrefImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new SkuMediaXrefImpl().getTags());
  }

  /**
   * Test {@link SkuMediaXrefImpl#setTags(String)}.
   *
   * <ul>
   *   <li>Given {@link SkuMediaXrefImpl}.
   *   <li>When {@code Tags}.
   *   <li>Then {@link SkuMediaXrefImpl} Media {@link MediaImpl}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#setTags(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuMediaXrefImpl.setTags(String)"})
  public void testSetTags_givenSkuMediaXrefImpl_whenTags_thenSkuMediaXrefImplMediaMediaImpl() {
    // Arrange and Act
    skuMediaXrefImpl.setTags("Tags");

    // Assert
    Media media = skuMediaXrefImpl.getMedia();
    assertTrue(media instanceof MediaImpl);
    assertEquals("Tags", media.getTags());
    assertEquals("Tags", skuMediaXrefImpl.getTags());
  }

  /**
   * Test {@link SkuMediaXrefImpl#setTags(String)}.
   *
   * <ul>
   *   <li>Then {@link SkuMediaXrefImpl} Media {@link MediaDto}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#setTags(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuMediaXrefImpl.setTags(String)"})
  public void testSetTags_thenSkuMediaXrefImplMediaMediaDto() {
    // Arrange
    skuMediaXrefImpl.setMedia(new MediaDto());

    // Act
    skuMediaXrefImpl.setTags("Tags");

    // Assert
    Media media = skuMediaXrefImpl.getMedia();
    assertTrue(media instanceof MediaDto);
    assertEquals("Tags", media.getTags());
    assertEquals("Tags", skuMediaXrefImpl.getTags());
  }

  /**
   * Test {@link SkuMediaXrefImpl#setTags(String)}.
   *
   * <ul>
   *   <li>Then {@link SkuMediaXrefImpl} Media Media {@link MediaImpl}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#setTags(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuMediaXrefImpl.setTags(String)"})
  public void testSetTags_thenSkuMediaXrefImplMediaMediaMediaImpl() {
    // Arrange
    skuMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    // Act
    skuMediaXrefImpl.setTags("Tags");

    // Assert
    Media media = skuMediaXrefImpl.getMedia();
    Media media2 = ((CategoryMediaXrefImpl) media).getMedia();
    assertTrue(media2 instanceof MediaImpl);
    assertTrue(media instanceof CategoryMediaXrefImpl);
    assertEquals("Tags", media2.getTags());
    assertEquals("Tags", media.getTags());
    assertEquals("Tags", skuMediaXrefImpl.getTags());
  }

  /**
   * Test {@link SkuMediaXrefImpl#setTags(String)}.
   *
   * <ul>
   *   <li>Then {@link SkuMediaXrefImpl} Media Media Media {@link MediaImpl}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#setTags(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuMediaXrefImpl.setTags(String)"})
  public void testSetTags_thenSkuMediaXrefImplMediaMediaMediaMediaImpl() {
    // Arrange
    SkuMediaXrefImpl media = new SkuMediaXrefImpl();
    media.setId(1L);
    media.setKey("Key");
    media.setMedia(new CategoryMediaXrefImpl());
    media.setSku(new SkuImpl());
    skuMediaXrefImpl.setMedia(media);

    // Act
    skuMediaXrefImpl.setTags("Tags");

    // Assert
    Media media2 = skuMediaXrefImpl.getMedia();
    Media media3 = ((SkuMediaXrefImpl) media2).getMedia();
    Media media4 = ((CategoryMediaXrefImpl) media3).getMedia();
    assertTrue(media4 instanceof MediaImpl);
    assertTrue(media3 instanceof CategoryMediaXrefImpl);
    assertTrue(media2 instanceof SkuMediaXrefImpl);
    assertEquals("Tags", media4.getTags());
    assertEquals("Tags", media2.getTags());
    assertEquals("Tags", media3.getTags());
    assertEquals("Tags", skuMediaXrefImpl.getTags());
  }

  /**
   * Test {@link SkuMediaXrefImpl#isUnwrappableAs(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#isUnwrappableAs(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuMediaXrefImpl.isUnwrappableAs(Class)"})
  public void testIsUnwrappableAs_thenReturnTrue() {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    Class<Media> unwrapType = Media.class;

    // Act and Assert
    assertTrue(skuMediaXrefImpl.isUnwrappableAs(unwrapType));
  }

  /**
   * Test {@link SkuMediaXrefImpl#isUnwrappableAs(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#isUnwrappableAs(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuMediaXrefImpl.isUnwrappableAs(Class)"})
  public void testIsUnwrappableAs_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    Class<Object> unwrapType = Object.class;

    // Act and Assert
    assertFalse(skuMediaXrefImpl.isUnwrappableAs(unwrapType));
  }

  /**
   * Test {@link SkuMediaXrefImpl#unwrap(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then throw {@link UnknownUnwrapTypeException}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#unwrap(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SkuMediaXrefImpl.unwrap(Class)"})
  public void testUnwrap_whenJavaLangObject_thenThrowUnknownUnwrapTypeException() {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    Class<Object> unwrapType = Object.class;

    // Act and Assert
    assertThrows(UnknownUnwrapTypeException.class, () -> skuMediaXrefImpl.unwrap(unwrapType));
  }

  /**
   * Test {@link SkuMediaXrefImpl#unwrap(Class)}.
   *
   * <ul>
   *   <li>When {@code Media}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuMediaXrefImpl#unwrap(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object SkuMediaXrefImpl.unwrap(Class)"})
  public void testUnwrap_whenOrgBroadleafcommerceCommonMediaDomainMedia_thenReturnNull() {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    Class<Media> unwrapType = Media.class;

    // Act and Assert
    assertNull(skuMediaXrefImpl.unwrap(unwrapType));
  }

  /**
   * Test {@link SkuMediaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * SkuMediaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse SkuMediaXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();

    SkuMediaXrefImpl skuMediaXrefImpl2 = new SkuMediaXrefImpl();
    skuMediaXrefImpl2.setId(1L);
    skuMediaXrefImpl2.setKey("Key");
    skuMediaXrefImpl2.setMedia(new CategoryMediaXrefImpl());
    skuMediaXrefImpl2.setSku(new SkuImpl());
    CreateResponse<Object> createResponse = new CreateResponse<>(skuMediaXrefImpl2, true);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<SkuMediaXrefImpl> actualCreateOrRetrieveCopyInstanceResult =
        skuMediaXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link SkuMediaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * SkuMediaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse SkuMediaXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();

    SkuMediaXrefImpl skuMediaXrefImpl2 = new SkuMediaXrefImpl();
    skuMediaXrefImpl2.setId(1L);
    skuMediaXrefImpl2.setKey("Key");
    skuMediaXrefImpl2.setMedia(new CategoryMediaXrefImpl());
    skuMediaXrefImpl2.setSku(new SkuImpl());
    CreateResponse<Object> createResponse = new CreateResponse<>(skuMediaXrefImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<SkuMediaXrefImpl> actualCreateOrRetrieveCopyInstanceResult =
        skuMediaXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link SkuMediaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * SkuMediaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse SkuMediaXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new SkuMediaXrefImpl(), false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<SkuMediaXrefImpl> actualCreateOrRetrieveCopyInstanceResult =
        skuMediaXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }
}
