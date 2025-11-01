/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.sitemap.wrapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType;
import org.junit.Test;

public class SiteMapURLWrapperDiffblueTest {
  /**
   * Method under test: {@link SiteMapURLWrapper#addImage(SiteMapImageWrapper)}
   */
  @Test
  public void testAddImage() {
    // Arrange
    SiteMapURLWrapper siteMapURLWrapper = new SiteMapURLWrapper();

    SiteMapImageWrapper siteMapImage = new SiteMapImageWrapper();
    siteMapImage.setLoc("Loc");

    // Act
    siteMapURLWrapper.addImage(siteMapImage);

    // Assert
    List<SiteMapImageWrapper> siteMapImageWrappers = siteMapURLWrapper.getSiteMapImageWrappers();
    assertEquals(1, siteMapImageWrappers.size());
    assertSame(siteMapImage, siteMapImageWrappers.get(0));
  }

  /**
   * Method under test: {@link SiteMapURLWrapper#addImage(SiteMapImageWrapper)}
   */
  @Test
  public void testAddImage2() {
    // Arrange
    Date lastModDate = mock(Date.class);
    when(lastModDate.getTime()).thenReturn(10L);

    SiteMapURLWrapper siteMapURLWrapper = new SiteMapURLWrapper();
    siteMapURLWrapper.setLastModDate(lastModDate);

    SiteMapImageWrapper siteMapImage = new SiteMapImageWrapper();
    siteMapImage.setLoc("Loc");

    // Act
    siteMapURLWrapper.addImage(siteMapImage);

    // Assert
    verify(lastModDate).getTime();
    List<SiteMapImageWrapper> siteMapImageWrappers = siteMapURLWrapper.getSiteMapImageWrappers();
    assertEquals(1, siteMapImageWrappers.size());
    assertSame(siteMapImage, siteMapImageWrappers.get(0));
  }

  /**
   * Method under test: {@link SiteMapURLWrapper#setLastModDate(java.util.Date)}
   */
  @Test
  public void testSetLastModDate() {
    // Arrange
    SiteMapURLWrapper siteMapURLWrapper = new SiteMapURLWrapper();
    java.sql.Date lastModDate = mock(java.sql.Date.class);
    when(lastModDate.getTime()).thenReturn(10L);

    // Act
    siteMapURLWrapper.setLastModDate(lastModDate);

    // Assert
    verify(lastModDate).getTime();
    assertEquals("1970-01-01T00:00:00+00:00", siteMapURLWrapper.getLastmod());
  }

  /**
   * Method under test:
   * {@link SiteMapURLWrapper#setPriorityType(SiteMapPriorityType)}
   */
  @Test
  public void testSetPriorityType() {
    // Arrange
    SiteMapURLWrapper siteMapURLWrapper = new SiteMapURLWrapper();

    // Act
    siteMapURLWrapper.setPriorityType(SiteMapPriorityType.ONE);

    // Assert
    assertEquals("1.0", siteMapURLWrapper.getPriority());
  }

  /**
   * Method under test:
   * {@link SiteMapURLWrapper#setPriorityType(SiteMapPriorityType)}
   */
  @Test
  public void testSetPriorityType2() {
    // Arrange
    SiteMapURLWrapper siteMapURLWrapper = new SiteMapURLWrapper();

    // Act
    siteMapURLWrapper.setPriorityType(null);

    // Assert that nothing has changed
    assertNull(siteMapURLWrapper.getPriority());
  }

  /**
   * Method under test:
   * {@link SiteMapURLWrapper#setPriorityType(SiteMapPriorityType)}
   */
  @Test
  public void testSetPriorityType3() {
    // Arrange
    Date lastModDate = mock(Date.class);
    when(lastModDate.getTime()).thenReturn(10L);

    SiteMapURLWrapper siteMapURLWrapper = new SiteMapURLWrapper();
    siteMapURLWrapper.setLastModDate(lastModDate);

    // Act
    siteMapURLWrapper.setPriorityType(SiteMapPriorityType.ONE);

    // Assert
    verify(lastModDate).getTime();
    assertEquals("1.0", siteMapURLWrapper.getPriority());
  }

  /**
   * Method under test:
   * {@link SiteMapURLWrapper#setChangeFreqType(SiteMapChangeFreqType)}
   */
  @Test
  public void testSetChangeFreqType() {
    // Arrange
    SiteMapURLWrapper siteMapURLWrapper = new SiteMapURLWrapper();

    // Act
    siteMapURLWrapper.setChangeFreqType(SiteMapChangeFreqType.ALWAYS);

    // Assert
    assertEquals("always", siteMapURLWrapper.getChangefreq());
  }

  /**
   * Method under test:
   * {@link SiteMapURLWrapper#setChangeFreqType(SiteMapChangeFreqType)}
   */
  @Test
  public void testSetChangeFreqType2() {
    // Arrange
    SiteMapURLWrapper siteMapURLWrapper = new SiteMapURLWrapper();

    // Act
    siteMapURLWrapper.setChangeFreqType(null);

    // Assert that nothing has changed
    assertNull(siteMapURLWrapper.getChangefreq());
  }

  /**
   * Method under test:
   * {@link SiteMapURLWrapper#setChangeFreqType(SiteMapChangeFreqType)}
   */
  @Test
  public void testSetChangeFreqType3() {
    // Arrange
    Date lastModDate = mock(Date.class);
    when(lastModDate.getTime()).thenReturn(10L);

    SiteMapURLWrapper siteMapURLWrapper = new SiteMapURLWrapper();
    siteMapURLWrapper.setLastModDate(lastModDate);

    // Act
    siteMapURLWrapper.setChangeFreqType(SiteMapChangeFreqType.ALWAYS);

    // Assert
    verify(lastModDate).getTime();
    assertEquals("always", siteMapURLWrapper.getChangefreq());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SiteMapURLWrapper}
   *   <li>{@link SiteMapURLWrapper#setChangefreq(String)}
   *   <li>{@link SiteMapURLWrapper#setLastmod(String)}
   *   <li>{@link SiteMapURLWrapper#setLoc(String)}
   *   <li>{@link SiteMapURLWrapper#setPriority(String)}
   *   <li>{@link SiteMapURLWrapper#setSiteMapImageWrappers(List)}
   *   <li>{@link SiteMapURLWrapper#getChangefreq()}
   *   <li>{@link SiteMapURLWrapper#getLastmod()}
   *   <li>{@link SiteMapURLWrapper#getLoc()}
   *   <li>{@link SiteMapURLWrapper#getPriority()}
   *   <li>{@link SiteMapURLWrapper#getSiteMapImageWrappers()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SiteMapURLWrapper actualSiteMapURLWrapper = new SiteMapURLWrapper();
    actualSiteMapURLWrapper.setChangefreq("https://example.org/example");
    actualSiteMapURLWrapper.setLastmod("https://example.org/example");
    actualSiteMapURLWrapper.setLoc("https://example.org/example");
    actualSiteMapURLWrapper.setPriority("https://example.org/example");
    ArrayList<SiteMapImageWrapper> siteMapImageWrappers = new ArrayList<>();
    actualSiteMapURLWrapper.setSiteMapImageWrappers(siteMapImageWrappers);
    String actualChangefreq = actualSiteMapURLWrapper.getChangefreq();
    String actualLastmod = actualSiteMapURLWrapper.getLastmod();
    String actualLoc = actualSiteMapURLWrapper.getLoc();
    String actualPriority = actualSiteMapURLWrapper.getPriority();
    List<SiteMapImageWrapper> actualSiteMapImageWrappers = actualSiteMapURLWrapper.getSiteMapImageWrappers();

    // Assert that nothing has changed
    assertEquals("https://example.org/example", actualChangefreq);
    assertEquals("https://example.org/example", actualLastmod);
    assertEquals("https://example.org/example", actualLoc);
    assertEquals("https://example.org/example", actualPriority);
    assertTrue(actualSiteMapImageWrappers.isEmpty());
    assertSame(siteMapImageWrappers, actualSiteMapImageWrappers);
  }
}
