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
   * Test {@link SiteMapURLWrapper#addImage(SiteMapImageWrapper)}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapURLWrapper#addImage(SiteMapImageWrapper)}
   */
  @Test
  public void testAddImage_givenDateGetTimeReturnTen_thenCallsGetTime() {
    // Arrange
    java.sql.Date lastModDate = mock(java.sql.Date.class);
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
   * Test {@link SiteMapURLWrapper#addImage(SiteMapImageWrapper)}.
   * <ul>
   *   <li>Given {@link SiteMapURLWrapper} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapURLWrapper#addImage(SiteMapImageWrapper)}
   */
  @Test
  public void testAddImage_givenSiteMapURLWrapper() {
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
   * Test {@link SiteMapURLWrapper#setPriorityType(SiteMapPriorityType)}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>When {@link SiteMapPriorityType#ONE}.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapURLWrapper#setPriorityType(SiteMapPriorityType)}
   */
  @Test
  public void testSetPriorityType_givenDateGetTimeReturnTen_whenOne_thenCallsGetTime() {
    // Arrange
    java.sql.Date lastModDate = mock(java.sql.Date.class);
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
   * Test {@link SiteMapURLWrapper#setPriorityType(SiteMapPriorityType)}.
   * <ul>
   *   <li>Given {@link SiteMapURLWrapper} (default constructor).</li>
   *   <li>Then {@link SiteMapURLWrapper} (default constructor) Priority is
   * {@code 1.0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapURLWrapper#setPriorityType(SiteMapPriorityType)}
   */
  @Test
  public void testSetPriorityType_givenSiteMapURLWrapper_thenSiteMapURLWrapperPriorityIs10() {
    // Arrange
    SiteMapURLWrapper siteMapURLWrapper = new SiteMapURLWrapper();

    // Act
    siteMapURLWrapper.setPriorityType(SiteMapPriorityType.ONE);

    // Assert
    assertEquals("1.0", siteMapURLWrapper.getPriority());
  }

  /**
   * Test {@link SiteMapURLWrapper#setPriorityType(SiteMapPriorityType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SiteMapURLWrapper} (default constructor) Priority is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapURLWrapper#setPriorityType(SiteMapPriorityType)}
   */
  @Test
  public void testSetPriorityType_whenNull_thenSiteMapURLWrapperPriorityIsNull() {
    // Arrange
    SiteMapURLWrapper siteMapURLWrapper = new SiteMapURLWrapper();

    // Act
    siteMapURLWrapper.setPriorityType(null);

    // Assert that nothing has changed
    assertNull(siteMapURLWrapper.getPriority());
  }

  /**
   * Test {@link SiteMapURLWrapper#setChangeFreqType(SiteMapChangeFreqType)}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>When {@link SiteMapChangeFreqType#ALWAYS}.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapURLWrapper#setChangeFreqType(SiteMapChangeFreqType)}
   */
  @Test
  public void testSetChangeFreqType_givenDateGetTimeReturnTen_whenAlways_thenCallsGetTime() {
    // Arrange
    java.sql.Date lastModDate = mock(java.sql.Date.class);
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
   * Test {@link SiteMapURLWrapper#setChangeFreqType(SiteMapChangeFreqType)}.
   * <ul>
   *   <li>Then {@link SiteMapURLWrapper} (default constructor) Changefreq is
   * {@code always}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapURLWrapper#setChangeFreqType(SiteMapChangeFreqType)}
   */
  @Test
  public void testSetChangeFreqType_thenSiteMapURLWrapperChangefreqIsAlways() {
    // Arrange
    SiteMapURLWrapper siteMapURLWrapper = new SiteMapURLWrapper();

    // Act
    siteMapURLWrapper.setChangeFreqType(SiteMapChangeFreqType.ALWAYS);

    // Assert
    assertEquals("always", siteMapURLWrapper.getChangefreq());
  }

  /**
   * Test {@link SiteMapURLWrapper#setChangeFreqType(SiteMapChangeFreqType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SiteMapURLWrapper} (default constructor) Changefreq is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapURLWrapper#setChangeFreqType(SiteMapChangeFreqType)}
   */
  @Test
  public void testSetChangeFreqType_whenNull_thenSiteMapURLWrapperChangefreqIsNull() {
    // Arrange
    SiteMapURLWrapper siteMapURLWrapper = new SiteMapURLWrapper();

    // Act
    siteMapURLWrapper.setChangeFreqType(null);

    // Assert that nothing has changed
    assertNull(siteMapURLWrapper.getChangefreq());
  }

  /**
   * Test getters and setters.
   * <p>
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
