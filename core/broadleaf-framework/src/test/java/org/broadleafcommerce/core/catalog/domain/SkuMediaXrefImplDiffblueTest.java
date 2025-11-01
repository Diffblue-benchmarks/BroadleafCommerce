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
import org.broadleafcommerce.common.money.Money;
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

@ContextConfiguration(classes = {SkuMediaXrefImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class SkuMediaXrefImplDiffblueTest {
  @Autowired
  private SkuMediaXrefImpl skuMediaXrefImpl;

  /**
   * Method under test: {@link SkuMediaXrefImpl#getUrl()}
   */
  @Test
  public void testGetUrl() {
    // Arrange, Act and Assert
    assertNull((new SkuMediaXrefImpl()).getUrl());
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#getUrl()}
   */
  @Test
  public void testGetUrl2() {
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
   * Method under test: {@link SkuMediaXrefImpl#getUrl()}
   */
  @Test
  public void testGetUrl3() {
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
   * Method under test: {@link SkuMediaXrefImpl#getUrl()}
   */
  @Test
  public void testGetUrl4() {
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
   * Method under test: {@link SkuMediaXrefImpl#setUrl(String)}
   */
  @Test
  public void testSetUrl() {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl2 = new SkuMediaXrefImpl();

    // Act
    skuMediaXrefImpl2.setUrl("https://example.org/example");

    // Assert
    Media media = skuMediaXrefImpl2.getMedia();
    assertTrue(media instanceof MediaImpl);
    assertEquals("https://example.org/example", media.getUrl());
    assertEquals("https://example.org/example", skuMediaXrefImpl2.getUrl());
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#setUrl(String)}
   */
  @Test
  public void testSetUrl2() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    SkuMediaXrefImpl skuMediaXrefImpl2 = new SkuMediaXrefImpl(sku, media, "Key");

    // Act
    skuMediaXrefImpl2.setUrl("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", skuMediaXrefImpl2.getUrl());
    assertSame(media, skuMediaXrefImpl2.getMedia());
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#setUrl(String)}
   */
  @Test
  public void testSetUrl3() {
    // Arrange
    SkuImpl sku = mock(SkuImpl.class);
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    SkuMediaXrefImpl skuMediaXrefImpl2 = new SkuMediaXrefImpl(sku, media, "Key");

    // Act
    skuMediaXrefImpl2.setUrl("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", skuMediaXrefImpl2.getUrl());
    assertSame(media, skuMediaXrefImpl2.getMedia());
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#setUrl(String)}
   */
  @Test
  public void testSetUrl4() {
    // Arrange
    SkuMediaXrefImpl media = new SkuMediaXrefImpl();
    media.setId(1L);
    media.setKey("Key");
    media.setMedia(new CategoryMediaXrefImpl());
    media.setSku(new SkuImpl());
    SkuMediaXrefImpl skuMediaXrefImpl2 = new SkuMediaXrefImpl(new SkuImpl(), media, "Key");

    // Act
    skuMediaXrefImpl2.setUrl("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", skuMediaXrefImpl2.getUrl());
    assertSame(media, skuMediaXrefImpl2.getMedia());
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#setUrl(String)}
   */
  @Test
  public void testSetUrl5() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    MediaDto media = new MediaDto();
    SkuMediaXrefImpl skuMediaXrefImpl2 = new SkuMediaXrefImpl(sku, media, "Key");

    // Act
    skuMediaXrefImpl2.setUrl("https://example.org/example");

    // Assert
    Media media2 = skuMediaXrefImpl2.getMedia();
    assertTrue(media2 instanceof MediaDto);
    assertEquals("https://example.org/example", media2.getUrl());
    assertEquals("https://example.org/example", skuMediaXrefImpl2.getUrl());
    assertSame(media, media2);
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#setUrl(String)}
   */
  @Test
  public void testSetUrl6() {
    // Arrange
    MediaImpl media = mock(MediaImpl.class);
    Class<Object> unwrapType = Object.class;
    doThrow(new UnknownUnwrapTypeException(unwrapType)).when(media).setUrl(Mockito.<String>any());

    // Act and Assert
    assertThrows(UnknownUnwrapTypeException.class,
        () -> (new SkuMediaXrefImpl(new SkuImpl(), media, "Key")).setUrl("https://example.org/example"));
    verify(media).setUrl(eq("https://example.org/example"));
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#getTitle()}
   */
  @Test
  public void testGetTitle() {
    // Arrange, Act and Assert
    assertNull((new SkuMediaXrefImpl()).getTitle());
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#getTitle()}
   */
  @Test
  public void testGetTitle2() {
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
   * Method under test: {@link SkuMediaXrefImpl#getTitle()}
   */
  @Test
  public void testGetTitle3() {
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
   * Method under test: {@link SkuMediaXrefImpl#getTitle()}
   */
  @Test
  public void testGetTitle4() {
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
   * Method under test: {@link SkuMediaXrefImpl#getTitle()}
   */
  @Test
  public void testGetTitle5() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    sku.setSalePrice(new Money());

    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    skuMediaXrefImpl.setId(1L);
    skuMediaXrefImpl.setKey("Key");
    skuMediaXrefImpl.setSku(sku);
    skuMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNull(skuMediaXrefImpl.getTitle());
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#setTitle(String)}
   */
  @Test
  public void testSetTitle() {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl2 = new SkuMediaXrefImpl();

    // Act
    skuMediaXrefImpl2.setTitle("Dr");

    // Assert
    Media media = skuMediaXrefImpl2.getMedia();
    assertTrue(media instanceof MediaImpl);
    assertEquals("Dr", media.getTitle());
    assertEquals("Dr", skuMediaXrefImpl2.getTitle());
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#setTitle(String)}
   */
  @Test
  public void testSetTitle2() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    SkuMediaXrefImpl skuMediaXrefImpl2 = new SkuMediaXrefImpl(sku, media, "Key");

    // Act
    skuMediaXrefImpl2.setTitle("Dr");

    // Assert
    assertEquals("Dr", skuMediaXrefImpl2.getTitle());
    assertSame(media, skuMediaXrefImpl2.getMedia());
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#setTitle(String)}
   */
  @Test
  public void testSetTitle3() {
    // Arrange
    SkuImpl sku = mock(SkuImpl.class);
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    SkuMediaXrefImpl skuMediaXrefImpl2 = new SkuMediaXrefImpl(sku, media, "Key");

    // Act
    skuMediaXrefImpl2.setTitle("Dr");

    // Assert
    assertEquals("Dr", skuMediaXrefImpl2.getTitle());
    assertSame(media, skuMediaXrefImpl2.getMedia());
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#setTitle(String)}
   */
  @Test
  public void testSetTitle4() {
    // Arrange
    SkuMediaXrefImpl media = new SkuMediaXrefImpl();
    media.setId(1L);
    media.setKey("Key");
    media.setMedia(new CategoryMediaXrefImpl());
    media.setSku(new SkuImpl());
    SkuMediaXrefImpl skuMediaXrefImpl2 = new SkuMediaXrefImpl(new SkuImpl(), media, "Key");

    // Act
    skuMediaXrefImpl2.setTitle("Dr");

    // Assert
    assertEquals("Dr", skuMediaXrefImpl2.getTitle());
    assertSame(media, skuMediaXrefImpl2.getMedia());
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#setTitle(String)}
   */
  @Test
  public void testSetTitle5() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    MediaDto media = new MediaDto();
    SkuMediaXrefImpl skuMediaXrefImpl2 = new SkuMediaXrefImpl(sku, media, "Key");

    // Act
    skuMediaXrefImpl2.setTitle("Dr");

    // Assert
    Media media2 = skuMediaXrefImpl2.getMedia();
    assertTrue(media2 instanceof MediaDto);
    assertEquals("Dr", media2.getTitle());
    assertEquals("Dr", skuMediaXrefImpl2.getTitle());
    assertSame(media, media2);
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#setTitle(String)}
   */
  @Test
  public void testSetTitle6() {
    // Arrange
    MediaImpl media = mock(MediaImpl.class);
    Class<Object> unwrapType = Object.class;
    doThrow(new UnknownUnwrapTypeException(unwrapType)).when(media).setTitle(Mockito.<String>any());

    // Act and Assert
    assertThrows(UnknownUnwrapTypeException.class,
        () -> (new SkuMediaXrefImpl(new SkuImpl(), media, "Key")).setTitle("Dr"));
    verify(media).setTitle(eq("Dr"));
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#getAltText()}
   */
  @Test
  public void testGetAltText() {
    // Arrange, Act and Assert
    assertNull((new SkuMediaXrefImpl()).getAltText());
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#getAltText()}
   */
  @Test
  public void testGetAltText2() {
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
   * Method under test: {@link SkuMediaXrefImpl#getAltText()}
   */
  @Test
  public void testGetAltText3() {
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
   * Method under test: {@link SkuMediaXrefImpl#getAltText()}
   */
  @Test
  public void testGetAltText4() {
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
   * Method under test: {@link SkuMediaXrefImpl#getAltText()}
   */
  @Test
  public void testGetAltText5() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    sku.setSalePrice(new Money());

    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    skuMediaXrefImpl.setId(1L);
    skuMediaXrefImpl.setKey("Key");
    skuMediaXrefImpl.setSku(sku);
    skuMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    // Act and Assert
    assertNull(skuMediaXrefImpl.getAltText());
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#setAltText(String)}
   */
  @Test
  public void testSetAltText() {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl2 = new SkuMediaXrefImpl();

    // Act
    skuMediaXrefImpl2.setAltText("Alt Text");

    // Assert
    Media media = skuMediaXrefImpl2.getMedia();
    assertTrue(media instanceof MediaImpl);
    assertEquals("Alt Text", media.getAltText());
    assertEquals("Alt Text", skuMediaXrefImpl2.getAltText());
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#setAltText(String)}
   */
  @Test
  public void testSetAltText2() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    SkuMediaXrefImpl skuMediaXrefImpl2 = new SkuMediaXrefImpl(sku, media, "Key");

    // Act
    skuMediaXrefImpl2.setAltText("Alt Text");

    // Assert
    assertEquals("Alt Text", skuMediaXrefImpl2.getAltText());
    assertSame(media, skuMediaXrefImpl2.getMedia());
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#setAltText(String)}
   */
  @Test
  public void testSetAltText3() {
    // Arrange
    SkuImpl sku = mock(SkuImpl.class);
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    SkuMediaXrefImpl skuMediaXrefImpl2 = new SkuMediaXrefImpl(sku, media, "Key");

    // Act
    skuMediaXrefImpl2.setAltText("Alt Text");

    // Assert
    assertEquals("Alt Text", skuMediaXrefImpl2.getAltText());
    assertSame(media, skuMediaXrefImpl2.getMedia());
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#setAltText(String)}
   */
  @Test
  public void testSetAltText4() {
    // Arrange
    SkuMediaXrefImpl media = new SkuMediaXrefImpl();
    media.setId(1L);
    media.setKey("Key");
    media.setMedia(new CategoryMediaXrefImpl());
    media.setSku(new SkuImpl());
    SkuMediaXrefImpl skuMediaXrefImpl2 = new SkuMediaXrefImpl(new SkuImpl(), media, "Key");

    // Act
    skuMediaXrefImpl2.setAltText("Alt Text");

    // Assert
    assertEquals("Alt Text", skuMediaXrefImpl2.getAltText());
    assertSame(media, skuMediaXrefImpl2.getMedia());
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#setAltText(String)}
   */
  @Test
  public void testSetAltText5() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    MediaDto media = new MediaDto();
    SkuMediaXrefImpl skuMediaXrefImpl2 = new SkuMediaXrefImpl(sku, media, "Key");

    // Act
    skuMediaXrefImpl2.setAltText("Alt Text");

    // Assert
    Media media2 = skuMediaXrefImpl2.getMedia();
    assertTrue(media2 instanceof MediaDto);
    assertEquals("Alt Text", media2.getAltText());
    assertEquals("Alt Text", skuMediaXrefImpl2.getAltText());
    assertSame(media, media2);
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#setAltText(String)}
   */
  @Test
  public void testSetAltText6() {
    // Arrange
    MediaImpl media = mock(MediaImpl.class);
    Class<Object> unwrapType = Object.class;
    doThrow(new UnknownUnwrapTypeException(unwrapType)).when(media).setAltText(Mockito.<String>any());

    // Act and Assert
    assertThrows(UnknownUnwrapTypeException.class,
        () -> (new SkuMediaXrefImpl(new SkuImpl(), media, "Key")).setAltText("Alt Text"));
    verify(media).setAltText(eq("Alt Text"));
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#getTags()}
   */
  @Test
  public void testGetTags() {
    // Arrange, Act and Assert
    assertNull((new SkuMediaXrefImpl()).getTags());
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#getTags()}
   */
  @Test
  public void testGetTags2() {
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
   * Method under test: {@link SkuMediaXrefImpl#getTags()}
   */
  @Test
  public void testGetTags3() {
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
   * Method under test: {@link SkuMediaXrefImpl#getTags()}
   */
  @Test
  public void testGetTags4() {
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
   * Method under test: {@link SkuMediaXrefImpl#setTags(String)}
   */
  @Test
  public void testSetTags() {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl2 = new SkuMediaXrefImpl();

    // Act
    skuMediaXrefImpl2.setTags("Tags");

    // Assert
    Media media = skuMediaXrefImpl2.getMedia();
    assertTrue(media instanceof MediaImpl);
    assertEquals("Tags", media.getTags());
    assertEquals("Tags", skuMediaXrefImpl2.getTags());
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#setTags(String)}
   */
  @Test
  public void testSetTags2() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    SkuMediaXrefImpl skuMediaXrefImpl2 = new SkuMediaXrefImpl(sku, media, "Key");

    // Act
    skuMediaXrefImpl2.setTags("Tags");

    // Assert
    assertEquals("Tags", skuMediaXrefImpl2.getTags());
    assertSame(media, skuMediaXrefImpl2.getMedia());
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#setTags(String)}
   */
  @Test
  public void testSetTags3() {
    // Arrange
    SkuImpl sku = mock(SkuImpl.class);
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    SkuMediaXrefImpl skuMediaXrefImpl2 = new SkuMediaXrefImpl(sku, media, "Key");

    // Act
    skuMediaXrefImpl2.setTags("Tags");

    // Assert
    assertEquals("Tags", skuMediaXrefImpl2.getTags());
    assertSame(media, skuMediaXrefImpl2.getMedia());
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#setTags(String)}
   */
  @Test
  public void testSetTags4() {
    // Arrange
    SkuMediaXrefImpl media = new SkuMediaXrefImpl();
    media.setId(1L);
    media.setKey("Key");
    media.setMedia(new CategoryMediaXrefImpl());
    media.setSku(new SkuImpl());
    SkuMediaXrefImpl skuMediaXrefImpl2 = new SkuMediaXrefImpl(new SkuImpl(), media, "Key");

    // Act
    skuMediaXrefImpl2.setTags("Tags");

    // Assert
    assertEquals("Tags", skuMediaXrefImpl2.getTags());
    assertSame(media, skuMediaXrefImpl2.getMedia());
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#setTags(String)}
   */
  @Test
  public void testSetTags5() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    MediaDto media = new MediaDto();
    SkuMediaXrefImpl skuMediaXrefImpl2 = new SkuMediaXrefImpl(sku, media, "Key");

    // Act
    skuMediaXrefImpl2.setTags("Tags");

    // Assert
    Media media2 = skuMediaXrefImpl2.getMedia();
    assertTrue(media2 instanceof MediaDto);
    assertEquals("Tags", media2.getTags());
    assertEquals("Tags", skuMediaXrefImpl2.getTags());
    assertSame(media, media2);
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#setTags(String)}
   */
  @Test
  public void testSetTags6() {
    // Arrange
    MediaImpl media = mock(MediaImpl.class);
    Class<Object> unwrapType = Object.class;
    doThrow(new UnknownUnwrapTypeException(unwrapType)).when(media).setTags(Mockito.<String>any());

    // Act and Assert
    assertThrows(UnknownUnwrapTypeException.class,
        () -> (new SkuMediaXrefImpl(new SkuImpl(), media, "Key")).setTags("Tags"));
    verify(media).setTags(eq("Tags"));
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#isUnwrappableAs(Class)}
   */
  @Test
  public void testIsUnwrappableAs() {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    Class<Object> unwrapType = Object.class;

    // Act and Assert
    assertFalse(skuMediaXrefImpl.isUnwrappableAs(unwrapType));
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#isUnwrappableAs(Class)}
   */
  @Test
  public void testIsUnwrappableAs2() {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    Class<Media> unwrapType = Media.class;

    // Act and Assert
    assertTrue(skuMediaXrefImpl.isUnwrappableAs(unwrapType));
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#unwrap(Class)}
   */
  @Test
  public void testUnwrap() {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    Class<Object> unwrapType = Object.class;

    // Act and Assert
    assertThrows(UnknownUnwrapTypeException.class, () -> skuMediaXrefImpl.unwrap(unwrapType));
  }

  /**
   * Method under test: {@link SkuMediaXrefImpl#unwrap(Class)}
   */
  @Test
  public void testUnwrap2() {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    Class<Media> unwrapType = Media.class;

    // Act and Assert
    assertNull(skuMediaXrefImpl.unwrap(unwrapType));
  }

  /**
   * Method under test:
   * {@link SkuMediaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<SkuMediaXrefImpl> actualCreateOrRetrieveCopyInstanceResult = skuMediaXrefImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.core.catalog.domain.SkuMediaXrefImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    SkuMediaXrefImpl clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    Media media = clone.getMedia();
    assertTrue(media instanceof MediaImpl);
    assertNull(media.getId());
    assertNull(clone.getId());
    assertNull(media.getAltText());
    assertNull(media.getTags());
    assertNull(media.getTitle());
    assertNull(media.getUrl());
    assertNull(clone.getAltText());
    assertNull(clone.getKey());
    assertNull(clone.getTags());
    assertNull(clone.getTitle());
    assertNull(clone.getUrl());
    assertNull(clone.getSku());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
  }

  /**
   * Method under test:
   * {@link SkuMediaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<SkuMediaXrefImpl> actualCreateOrRetrieveCopyInstanceResult = skuMediaXrefImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Method under test:
   * {@link SkuMediaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();

    SkuMediaXrefImpl skuMediaXrefImpl2 = new SkuMediaXrefImpl();
    skuMediaXrefImpl2.setId(1L);
    skuMediaXrefImpl2.setKey("Key");
    skuMediaXrefImpl2.setMedia(new CategoryMediaXrefImpl());
    skuMediaXrefImpl2.setSku(new SkuImpl());
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(skuMediaXrefImpl2);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    skuMediaXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
  }

  /**
   * Methods under test:
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

    // Assert that nothing has changed
    assertEquals("Key", actualKey);
    assertEquals(1L, actualId.longValue());
    assertSame(media, actualMedia);
    assertSame(sku, actualSku);
  }

  /**
   * Methods under test:
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
  public void testGettersAndSetters2() {
    // Arrange
    SkuImpl sku = new SkuImpl();

    // Act
    SkuMediaXrefImpl actualSkuMediaXrefImpl = new SkuMediaXrefImpl(sku, new CategoryMediaXrefImpl(), "Key");
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

    // Assert that nothing has changed
    assertEquals("Key", actualKey);
    assertEquals(1L, actualId.longValue());
    assertSame(media, actualMedia);
    assertSame(sku2, actualSku);
  }
}
