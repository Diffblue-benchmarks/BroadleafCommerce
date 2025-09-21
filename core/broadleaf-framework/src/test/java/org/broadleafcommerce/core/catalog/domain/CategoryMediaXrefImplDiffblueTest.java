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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.media.domain.Media;
import org.broadleafcommerce.common.media.domain.MediaDto;
import org.broadleafcommerce.common.media.domain.MediaImpl;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.util.UnknownUnwrapTypeException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CategoryMediaXrefImpl.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryMediaXrefImplDiffblueTest {
  @Autowired private CategoryMediaXrefImpl categoryMediaXrefImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryMediaXrefImpl.<init>()",
    "void CategoryMediaXrefImpl.<init>(Category, Media, String)",
    "Category CategoryMediaXrefImpl.getCategory()",
    "Long CategoryMediaXrefImpl.getId()",
    "String CategoryMediaXrefImpl.getKey()",
    "Media CategoryMediaXrefImpl.getMedia()",
    "void CategoryMediaXrefImpl.setCategory(Category)",
    "void CategoryMediaXrefImpl.setId(Long)",
    "void CategoryMediaXrefImpl.setKey(String)",
    "void CategoryMediaXrefImpl.setMedia(Media)"
  })
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

    // Assert
    assertEquals("Key", actualKey);
    assertEquals(1L, actualId.longValue());
    assertSame(category, actualCategory);
    assertSame(media, actualMedia);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryMediaXrefImpl#CategoryMediaXrefImpl(Category, Media, String)}
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
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryMediaXrefImpl.<init>()",
    "void CategoryMediaXrefImpl.<init>(Category, Media, String)",
    "Category CategoryMediaXrefImpl.getCategory()",
    "Long CategoryMediaXrefImpl.getId()",
    "String CategoryMediaXrefImpl.getKey()",
    "Media CategoryMediaXrefImpl.getMedia()",
    "void CategoryMediaXrefImpl.setCategory(Category)",
    "void CategoryMediaXrefImpl.setId(Long)",
    "void CategoryMediaXrefImpl.setKey(String)",
    "void CategoryMediaXrefImpl.setMedia(Media)"
  })
  public void testGettersAndSetters_whenCategoryImpl() {
    // Arrange
    CategoryImpl category = new CategoryImpl();

    // Act
    CategoryMediaXrefImpl actualCategoryMediaXrefImpl =
        new CategoryMediaXrefImpl(category, new CategoryMediaXrefImpl(), "Key");
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

    // Assert
    assertEquals("Key", actualKey);
    assertEquals(1L, actualId.longValue());
    assertSame(category2, actualCategory);
    assertSame(media, actualMedia);
  }

  /**
   * Test {@link CategoryMediaXrefImpl#getUrl()}.
   *
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media is {@link
   *       CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#getUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryMediaXrefImpl.getUrl()"})
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
   *
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media is {@link MediaDto}
   *       (default constructor).
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#getUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryMediaXrefImpl.getUrl()"})
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
   *
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media is {@link
   *       SkuMediaXrefImpl#SkuMediaXrefImpl()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#getUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryMediaXrefImpl.getUrl()"})
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
   *
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#getUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryMediaXrefImpl.getUrl()"})
  public void testGetUrl_givenCategoryMediaXrefImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new CategoryMediaXrefImpl().getUrl());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setUrl(String)}.
   *
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl}.
   *   <li>Then {@link CategoryMediaXrefImpl} Media {@link MediaImpl}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#setUrl(String)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryMediaXrefImpl.setUrl(String)"})
  public void testSetUrl_givenCategoryMediaXrefImpl_thenCategoryMediaXrefImplMediaMediaImpl() {
    // Arrange and Act
    categoryMediaXrefImpl.setUrl("https://example.org/example");

    // Assert
    Media media = categoryMediaXrefImpl.getMedia();
    assertTrue(media instanceof MediaImpl);
    assertEquals("https://example.org/example", media.getUrl());
    assertEquals("https://example.org/example", categoryMediaXrefImpl.getUrl());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setUrl(String)}.
   *
   * <ul>
   *   <li>Then {@link CategoryMediaXrefImpl} Media {@link CategoryMediaXrefImpl}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#setUrl(String)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryMediaXrefImpl.setUrl(String)"})
  public void testSetUrl_thenCategoryMediaXrefImplMediaCategoryMediaXrefImpl() {
    // Arrange
    categoryMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    // Act
    categoryMediaXrefImpl.setUrl("https://example.org/example");

    // Assert
    Media media = categoryMediaXrefImpl.getMedia();
    Media media2 = ((CategoryMediaXrefImpl) media).getMedia();
    assertTrue(media2 instanceof MediaImpl);
    assertTrue(media instanceof CategoryMediaXrefImpl);
    assertEquals("https://example.org/example", media.getUrl());
    assertEquals("https://example.org/example", media2.getUrl());
    assertEquals("https://example.org/example", categoryMediaXrefImpl.getUrl());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setUrl(String)}.
   *
   * <ul>
   *   <li>Then {@link CategoryMediaXrefImpl} Media {@link MediaDto}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#setUrl(String)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryMediaXrefImpl.setUrl(String)"})
  public void testSetUrl_thenCategoryMediaXrefImplMediaMediaDto() {
    // Arrange
    categoryMediaXrefImpl.setMedia(new MediaDto());

    // Act
    categoryMediaXrefImpl.setUrl("https://example.org/example");

    // Assert
    Media media = categoryMediaXrefImpl.getMedia();
    assertTrue(media instanceof MediaDto);
    assertEquals("https://example.org/example", media.getUrl());
    assertEquals("https://example.org/example", categoryMediaXrefImpl.getUrl());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setUrl(String)}.
   *
   * <ul>
   *   <li>Then {@link CategoryMediaXrefImpl} Media {@link SkuMediaXrefImpl}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#setUrl(String)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryMediaXrefImpl.setUrl(String)"})
  public void testSetUrl_thenCategoryMediaXrefImplMediaSkuMediaXrefImpl() {
    // Arrange
    categoryMediaXrefImpl.setMedia(new SkuMediaXrefImpl());

    // Act
    categoryMediaXrefImpl.setUrl("https://example.org/example");

    // Assert
    Media media = categoryMediaXrefImpl.getMedia();
    Media media2 = ((SkuMediaXrefImpl) media).getMedia();
    assertTrue(media2 instanceof MediaImpl);
    assertTrue(media instanceof SkuMediaXrefImpl);
    assertEquals("https://example.org/example", media.getUrl());
    assertEquals("https://example.org/example", media2.getUrl());
    assertEquals("https://example.org/example", categoryMediaXrefImpl.getUrl());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#getTitle()}.
   *
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media is {@link
   *       CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#getTitle()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryMediaXrefImpl.getTitle()"})
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
   *
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media is {@link MediaDto}
   *       (default constructor).
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#getTitle()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryMediaXrefImpl.getTitle()"})
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
   *
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media is {@link
   *       SkuMediaXrefImpl#SkuMediaXrefImpl()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#getTitle()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryMediaXrefImpl.getTitle()"})
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
   *
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#getTitle()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryMediaXrefImpl.getTitle()"})
  public void testGetTitle_givenCategoryMediaXrefImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new CategoryMediaXrefImpl().getTitle());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setTitle(String)}.
   *
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl}.
   *   <li>Then {@link CategoryMediaXrefImpl} Media {@link MediaImpl}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#setTitle(String)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryMediaXrefImpl.setTitle(String)"})
  public void testSetTitle_givenCategoryMediaXrefImpl_thenCategoryMediaXrefImplMediaMediaImpl() {
    // Arrange and Act
    categoryMediaXrefImpl.setTitle("Dr");

    // Assert
    Media media = categoryMediaXrefImpl.getMedia();
    assertTrue(media instanceof MediaImpl);
    assertEquals("Dr", media.getTitle());
    assertEquals("Dr", categoryMediaXrefImpl.getTitle());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setTitle(String)}.
   *
   * <ul>
   *   <li>Then {@link CategoryMediaXrefImpl} Media {@link CategoryMediaXrefImpl}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#setTitle(String)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryMediaXrefImpl.setTitle(String)"})
  public void testSetTitle_thenCategoryMediaXrefImplMediaCategoryMediaXrefImpl() {
    // Arrange
    categoryMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    // Act
    categoryMediaXrefImpl.setTitle("Dr");

    // Assert
    Media media = categoryMediaXrefImpl.getMedia();
    Media media2 = ((CategoryMediaXrefImpl) media).getMedia();
    assertTrue(media2 instanceof MediaImpl);
    assertTrue(media instanceof CategoryMediaXrefImpl);
    assertEquals("Dr", media.getTitle());
    assertEquals("Dr", media2.getTitle());
    assertEquals("Dr", categoryMediaXrefImpl.getTitle());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setTitle(String)}.
   *
   * <ul>
   *   <li>Then {@link CategoryMediaXrefImpl} Media {@link MediaDto}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#setTitle(String)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryMediaXrefImpl.setTitle(String)"})
  public void testSetTitle_thenCategoryMediaXrefImplMediaMediaDto() {
    // Arrange
    categoryMediaXrefImpl.setMedia(new MediaDto());

    // Act
    categoryMediaXrefImpl.setTitle("Dr");

    // Assert
    Media media = categoryMediaXrefImpl.getMedia();
    assertTrue(media instanceof MediaDto);
    assertEquals("Dr", media.getTitle());
    assertEquals("Dr", categoryMediaXrefImpl.getTitle());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setTitle(String)}.
   *
   * <ul>
   *   <li>Then {@link CategoryMediaXrefImpl} Media {@link SkuMediaXrefImpl}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#setTitle(String)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryMediaXrefImpl.setTitle(String)"})
  public void testSetTitle_thenCategoryMediaXrefImplMediaSkuMediaXrefImpl() {
    // Arrange
    categoryMediaXrefImpl.setMedia(new SkuMediaXrefImpl());

    // Act
    categoryMediaXrefImpl.setTitle("Dr");

    // Assert
    Media media = categoryMediaXrefImpl.getMedia();
    Media media2 = ((SkuMediaXrefImpl) media).getMedia();
    assertTrue(media2 instanceof MediaImpl);
    assertTrue(media instanceof SkuMediaXrefImpl);
    assertEquals("Dr", media.getTitle());
    assertEquals("Dr", media2.getTitle());
    assertEquals("Dr", categoryMediaXrefImpl.getTitle());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#getAltText()}.
   *
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media is {@link
   *       CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#getAltText()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryMediaXrefImpl.getAltText()"})
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
   *
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media is {@link MediaDto}
   *       (default constructor).
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#getAltText()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryMediaXrefImpl.getAltText()"})
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
   *
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media is {@link
   *       SkuMediaXrefImpl#SkuMediaXrefImpl()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#getAltText()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryMediaXrefImpl.getAltText()"})
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
   *
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#getAltText()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryMediaXrefImpl.getAltText()"})
  public void testGetAltText_givenCategoryMediaXrefImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new CategoryMediaXrefImpl().getAltText());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setAltText(String)}.
   *
   * <ul>
   *   <li>Then {@link CategoryMediaXrefImpl} Media {@link CategoryMediaXrefImpl}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#setAltText(String)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryMediaXrefImpl.setAltText(String)"})
  public void testSetAltText_thenCategoryMediaXrefImplMediaCategoryMediaXrefImpl() {
    // Arrange
    categoryMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    // Act
    categoryMediaXrefImpl.setAltText("Alt Text");

    // Assert
    Media media = categoryMediaXrefImpl.getMedia();
    Media media2 = ((CategoryMediaXrefImpl) media).getMedia();
    assertTrue(media2 instanceof MediaImpl);
    assertTrue(media instanceof CategoryMediaXrefImpl);
    assertEquals("Alt Text", media.getAltText());
    assertEquals("Alt Text", media2.getAltText());
    assertEquals("Alt Text", categoryMediaXrefImpl.getAltText());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setAltText(String)}.
   *
   * <ul>
   *   <li>Then {@link CategoryMediaXrefImpl} Media {@link MediaDto}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#setAltText(String)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryMediaXrefImpl.setAltText(String)"})
  public void testSetAltText_thenCategoryMediaXrefImplMediaMediaDto() {
    // Arrange
    categoryMediaXrefImpl.setMedia(new MediaDto());

    // Act
    categoryMediaXrefImpl.setAltText("Alt Text");

    // Assert
    Media media = categoryMediaXrefImpl.getMedia();
    assertTrue(media instanceof MediaDto);
    assertEquals("Alt Text", media.getAltText());
    assertEquals("Alt Text", categoryMediaXrefImpl.getAltText());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setAltText(String)}.
   *
   * <ul>
   *   <li>Then {@link CategoryMediaXrefImpl} Media {@link MediaImpl}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#setAltText(String)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryMediaXrefImpl.setAltText(String)"})
  public void testSetAltText_thenCategoryMediaXrefImplMediaMediaImpl() {
    // Arrange and Act
    categoryMediaXrefImpl.setAltText("Alt Text");

    // Assert
    Media media = categoryMediaXrefImpl.getMedia();
    assertTrue(media instanceof MediaImpl);
    assertEquals("Alt Text", media.getAltText());
    assertEquals("Alt Text", categoryMediaXrefImpl.getAltText());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setAltText(String)}.
   *
   * <ul>
   *   <li>Then {@link CategoryMediaXrefImpl} Media {@link SkuMediaXrefImpl}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#setAltText(String)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryMediaXrefImpl.setAltText(String)"})
  public void testSetAltText_thenCategoryMediaXrefImplMediaSkuMediaXrefImpl() {
    // Arrange
    categoryMediaXrefImpl.setMedia(new SkuMediaXrefImpl());

    // Act
    categoryMediaXrefImpl.setAltText("Alt Text");

    // Assert
    Media media = categoryMediaXrefImpl.getMedia();
    Media media2 = ((SkuMediaXrefImpl) media).getMedia();
    assertTrue(media2 instanceof MediaImpl);
    assertTrue(media instanceof SkuMediaXrefImpl);
    assertEquals("Alt Text", media.getAltText());
    assertEquals("Alt Text", media2.getAltText());
    assertEquals("Alt Text", categoryMediaXrefImpl.getAltText());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#getTags()}.
   *
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media is {@link
   *       CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#getTags()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryMediaXrefImpl.getTags()"})
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
   *
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media is {@link MediaDto}
   *       (default constructor).
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#getTags()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryMediaXrefImpl.getTags()"})
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
   *
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Media is {@link
   *       SkuMediaXrefImpl#SkuMediaXrefImpl()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#getTags()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryMediaXrefImpl.getTags()"})
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
   *
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#getTags()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryMediaXrefImpl.getTags()"})
  public void testGetTags_givenCategoryMediaXrefImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new CategoryMediaXrefImpl().getTags());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setTags(String)}.
   *
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl}.
   *   <li>Then {@link CategoryMediaXrefImpl} Media {@link MediaImpl}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#setTags(String)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryMediaXrefImpl.setTags(String)"})
  public void testSetTags_givenCategoryMediaXrefImpl_thenCategoryMediaXrefImplMediaMediaImpl() {
    // Arrange and Act
    categoryMediaXrefImpl.setTags("Tags");

    // Assert
    Media media = categoryMediaXrefImpl.getMedia();
    assertTrue(media instanceof MediaImpl);
    assertEquals("Tags", media.getTags());
    assertEquals("Tags", categoryMediaXrefImpl.getTags());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setTags(String)}.
   *
   * <ul>
   *   <li>Then {@link CategoryMediaXrefImpl} Media {@link CategoryMediaXrefImpl}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#setTags(String)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryMediaXrefImpl.setTags(String)"})
  public void testSetTags_thenCategoryMediaXrefImplMediaCategoryMediaXrefImpl() {
    // Arrange
    categoryMediaXrefImpl.setMedia(new CategoryMediaXrefImpl());

    // Act
    categoryMediaXrefImpl.setTags("Tags");

    // Assert
    Media media = categoryMediaXrefImpl.getMedia();
    Media media2 = ((CategoryMediaXrefImpl) media).getMedia();
    assertTrue(media2 instanceof MediaImpl);
    assertTrue(media instanceof CategoryMediaXrefImpl);
    assertEquals("Tags", media.getTags());
    assertEquals("Tags", media2.getTags());
    assertEquals("Tags", categoryMediaXrefImpl.getTags());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setTags(String)}.
   *
   * <ul>
   *   <li>Then {@link CategoryMediaXrefImpl} Media {@link MediaDto}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#setTags(String)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryMediaXrefImpl.setTags(String)"})
  public void testSetTags_thenCategoryMediaXrefImplMediaMediaDto() {
    // Arrange
    categoryMediaXrefImpl.setMedia(new MediaDto());

    // Act
    categoryMediaXrefImpl.setTags("Tags");

    // Assert
    Media media = categoryMediaXrefImpl.getMedia();
    assertTrue(media instanceof MediaDto);
    assertEquals("Tags", media.getTags());
    assertEquals("Tags", categoryMediaXrefImpl.getTags());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#setTags(String)}.
   *
   * <ul>
   *   <li>Then {@link CategoryMediaXrefImpl} Media {@link SkuMediaXrefImpl}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#setTags(String)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryMediaXrefImpl.setTags(String)"})
  public void testSetTags_thenCategoryMediaXrefImplMediaSkuMediaXrefImpl() {
    // Arrange
    categoryMediaXrefImpl.setMedia(new SkuMediaXrefImpl());

    // Act
    categoryMediaXrefImpl.setTags("Tags");

    // Assert
    Media media = categoryMediaXrefImpl.getMedia();
    Media media2 = ((SkuMediaXrefImpl) media).getMedia();
    assertTrue(media2 instanceof MediaImpl);
    assertTrue(media instanceof SkuMediaXrefImpl);
    assertEquals("Tags", media.getTags());
    assertEquals("Tags", media2.getTags());
    assertEquals("Tags", categoryMediaXrefImpl.getTags());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#isUnwrappableAs(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#isUnwrappableAs(Class)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryMediaXrefImpl.isUnwrappableAs(Class)"})
  public void testIsUnwrappableAs_thenReturnTrue() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    Class<Media> unwrapType = Media.class;

    // Act and Assert
    assertTrue(categoryMediaXrefImpl.isUnwrappableAs(unwrapType));
  }

  /**
   * Test {@link CategoryMediaXrefImpl#isUnwrappableAs(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#isUnwrappableAs(Class)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryMediaXrefImpl.isUnwrappableAs(Class)"})
  public void testIsUnwrappableAs_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    Class<Object> unwrapType = Object.class;

    // Act and Assert
    assertFalse(categoryMediaXrefImpl.isUnwrappableAs(unwrapType));
  }

  /**
   * Test {@link CategoryMediaXrefImpl#unwrap(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then throw {@link UnknownUnwrapTypeException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#unwrap(Class)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CategoryMediaXrefImpl.unwrap(Class)"})
  public void testUnwrap_whenJavaLangObject_thenThrowUnknownUnwrapTypeException() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    Class<Object> unwrapType = Object.class;

    // Act and Assert
    assertThrows(UnknownUnwrapTypeException.class, () -> categoryMediaXrefImpl.unwrap(unwrapType));
  }

  /**
   * Test {@link CategoryMediaXrefImpl#unwrap(Class)}.
   *
   * <ul>
   *   <li>When {@code Media}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#unwrap(Class)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object CategoryMediaXrefImpl.unwrap(Class)"})
  public void testUnwrap_whenOrgBroadleafcommerceCommonMediaDomainMedia_thenReturnNull() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    Class<Media> unwrapType = Media.class;

    // Act and Assert
    assertNull(categoryMediaXrefImpl.unwrap(unwrapType));
  }

  /**
   * Test {@link CategoryMediaXrefImpl#equals(Object)}, and {@link
   * CategoryMediaXrefImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryMediaXrefImpl#equals(Object)}
   *   <li>{@link CategoryMediaXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaXrefImpl.equals(Object)",
    "int CategoryMediaXrefImpl.hashCode()"
  })
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
    assertEquals(categoryMediaXrefImpl.hashCode(), categoryMediaXrefImpl2.hashCode());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#equals(Object)}, and {@link
   * CategoryMediaXrefImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryMediaXrefImpl#equals(Object)}
   *   <li>{@link CategoryMediaXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaXrefImpl.equals(Object)",
    "int CategoryMediaXrefImpl.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaXrefImpl.equals(Object)",
    "int CategoryMediaXrefImpl.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaXrefImpl.equals(Object)",
    "int CategoryMediaXrefImpl.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaXrefImpl.equals(Object)",
    "int CategoryMediaXrefImpl.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaXrefImpl.equals(Object)",
    "int CategoryMediaXrefImpl.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaXrefImpl.equals(Object)",
    "int CategoryMediaXrefImpl.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaXrefImpl.equals(Object)",
    "int CategoryMediaXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setCategory(new CategoryImpl());
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    CategoryImpl category = new CategoryImpl();
    CategoryMediaXrefImpl media =
        new CategoryMediaXrefImpl(category, new CategoryMediaXrefImpl(), "Key");
    categoryMediaXrefImpl.setMedia(media);

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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaXrefImpl.equals(Object)",
    "int CategoryMediaXrefImpl.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaXrefImpl.equals(Object)",
    "int CategoryMediaXrefImpl.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryMediaXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryMediaXrefImpl.equals(Object)",
    "int CategoryMediaXrefImpl.hashCode()"
  })
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
   * Test {@link CategoryMediaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * CategoryMediaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategoryMediaXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();

    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl2.setCategory(new CategoryImpl());
    categoryMediaXrefImpl2.setId(1L);
    categoryMediaXrefImpl2.setKey("Key");
    categoryMediaXrefImpl2.setMedia(new CategoryMediaXrefImpl());
    CreateResponse<Object> createResponse = new CreateResponse<>(categoryMediaXrefImpl2, true);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<CategoryMediaXrefImpl> actualCreateOrRetrieveCopyInstanceResult =
        categoryMediaXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link CategoryMediaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * CategoryMediaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategoryMediaXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();

    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl2.setCategory(new CategoryImpl());
    categoryMediaXrefImpl2.setId(1L);
    categoryMediaXrefImpl2.setKey("Key");
    categoryMediaXrefImpl2.setMedia(new CategoryMediaXrefImpl());
    CreateResponse<Object> createResponse = new CreateResponse<>(categoryMediaXrefImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<CategoryMediaXrefImpl> actualCreateOrRetrieveCopyInstanceResult =
        categoryMediaXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link CategoryMediaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * CategoryMediaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategoryMediaXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(null);
    categoryMediaXrefImpl.setCategory(new CategoryImpl());

    GenericEntityServiceImpl genericEntityService = mock(GenericEntityServiceImpl.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    MultiTenantCopyContext context =
        new MultiTenantCopyContext(
            fromCatalog,
            null,
            fromSite,
            toSite,
            genericEntityService,
            new MultiTenantCopierExtensionManager());

    // Act
    CreateResponse<CategoryMediaXrefImpl> actualCreateOrRetrieveCopyInstanceResult =
        categoryMediaXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(genericEntityService, atLeast(1)).getCeilingImplClass(Mockito.<String>any());
    verify(genericEntityService, atLeast(1)).getIdentifier(Mockito.<Object>any());
    assertEquals(categoryMediaXrefImpl, actualCreateOrRetrieveCopyInstanceResult.getClone());
  }

  /**
   * Test {@link CategoryMediaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Given {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()} Category is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryMediaXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategoryMediaXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_givenCategoryMediaXrefImplCategoryIsNull()
      throws CloneNotSupportedException {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    categoryMediaXrefImpl.setId(1L);
    categoryMediaXrefImpl.setKey("Key");
    categoryMediaXrefImpl.setMedia(null);
    categoryMediaXrefImpl.setCategory(null);

    GenericEntityServiceImpl genericEntityService = mock(GenericEntityServiceImpl.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    MultiTenantCopyContext context =
        new MultiTenantCopyContext(
            fromCatalog,
            toCatalog,
            fromSite,
            toSite,
            genericEntityService,
            new MultiTenantCopierExtensionManager());

    // Act
    CreateResponse<CategoryMediaXrefImpl> actualCreateOrRetrieveCopyInstanceResult =
        categoryMediaXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass("org.broadleafcommerce.core.catalog.domain.CategoryMediaXrefImpl");
    verify(genericEntityService).getIdentifier(isA(Object.class));
    assertEquals(categoryMediaXrefImpl, actualCreateOrRetrieveCopyInstanceResult.getClone());
  }
}
