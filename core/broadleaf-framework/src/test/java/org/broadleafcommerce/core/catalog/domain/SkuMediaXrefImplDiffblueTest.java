package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.media.domain.Media;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SkuMediaXrefImplDiffblueTest {
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
}
