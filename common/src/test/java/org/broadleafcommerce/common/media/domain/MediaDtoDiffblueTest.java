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
package org.broadleafcommerce.common.media.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import org.broadleafcommerce.common.util.UnknownUnwrapTypeException;
import org.junit.Test;

public class MediaDtoDiffblueTest {
  /**
   * Method under test: {@link MediaDto#getId()}
   */
  @Test
  public void testGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0L, (new MediaDto()).getId().longValue());
  }

  /**
   * Method under test: {@link MediaDto#setId(Long)}
   */
  @Test
  public void testSetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaDto mediaDto = new MediaDto();

    // Act
    mediaDto.setId(1L);

    // Assert
    assertEquals(1L, mediaDto.getId().longValue());
    assertEquals(1L, mediaDto.id);
  }

  /**
   * Method under test: {@link MediaDto#isUnwrappableAs(Class)}
   */
  @Test
  public void testIsUnwrappableAs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaDto mediaDto = new MediaDto();
    Class<Object> unwrapType = Object.class;

    // Act and Assert
    assertFalse(mediaDto.isUnwrappableAs(unwrapType));
  }

  /**
   * Method under test: {@link MediaDto#unwrap(Class)}
   */
  @Test
  public void testUnwrap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaDto mediaDto = new MediaDto();
    Class<Object> unwrapType = Object.class;

    // Act and Assert
    assertThrows(UnknownUnwrapTypeException.class, () -> mediaDto.unwrap(unwrapType));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MediaDto}
   *   <li>{@link MediaDto#setAltText(String)}
   *   <li>{@link MediaDto#setTags(String)}
   *   <li>{@link MediaDto#setTitle(String)}
   *   <li>{@link MediaDto#setUrl(String)}
   *   <li>{@link MediaDto#getAltText()}
   *   <li>{@link MediaDto#getTags()}
   *   <li>{@link MediaDto#getTitle()}
   *   <li>{@link MediaDto#getUrl()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    MediaDto actualMediaDto = new MediaDto();
    actualMediaDto.setAltText("Alt Text");
    actualMediaDto.setTags("Tags");
    actualMediaDto.setTitle("Dr");
    actualMediaDto.setUrl("https://example.org/example");
    String actualAltText = actualMediaDto.getAltText();
    String actualTags = actualMediaDto.getTags();
    String actualTitle = actualMediaDto.getTitle();

    // Assert that nothing has changed
    assertEquals("Alt Text", actualAltText);
    assertEquals("Dr", actualTitle);
    assertEquals("Tags", actualTags);
    assertEquals("https://example.org/example", actualMediaDto.getUrl());
  }
}
