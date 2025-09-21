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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.util.UnknownUnwrapTypeException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-common-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class MediaDtoDiffblueTest {
  @Autowired private MediaDto mediaDto;

  /**
   * Test {@link MediaDto#getId()}.
   *
   * <p>Method under test: {@link MediaDto#getId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MediaDto.getId()"})
  public void testGetId() {
    // Arrange, Act and Assert
    assertEquals(0L, mediaDto.getId().longValue());
  }

  /**
   * Test {@link MediaDto#setId(Long)}.
   *
   * <p>Method under test: {@link MediaDto#setId(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MediaDto.setId(Long)"})
  public void testSetId() {
    // Arrange and Act
    mediaDto.setId(1L);

    // Assert
    assertEquals(1L, mediaDto.getId().longValue());
    assertEquals(1L, mediaDto.id);
  }

  /**
   * Test {@link MediaDto#isUnwrappableAs(Class)}.
   *
   * <p>Method under test: {@link MediaDto#isUnwrappableAs(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaDto.isUnwrappableAs(Class)"})
  public void testIsUnwrappableAs() {
    // Arrange
    Class<Object> unwrapType = Object.class;

    // Act and Assert
    assertFalse(mediaDto.isUnwrappableAs(unwrapType));
  }

  /**
   * Test {@link MediaDto#unwrap(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then throw {@link UnknownUnwrapTypeException}.
   * </ul>
   *
   * <p>Method under test: {@link MediaDto#unwrap(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MediaDto.unwrap(Class)"})
  public void testUnwrap_whenJavaLangObject_thenThrowUnknownUnwrapTypeException() {
    // Arrange
    Class<Object> unwrapType = Object.class;

    // Act and Assert
    assertThrows(UnknownUnwrapTypeException.class, () -> mediaDto.unwrap(unwrapType));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MediaDto.<init>()",
    "String MediaDto.getAltText()",
    "String MediaDto.getTags()",
    "String MediaDto.getTitle()",
    "String MediaDto.getUrl()",
    "void MediaDto.setAltText(String)",
    "void MediaDto.setTags(String)",
    "void MediaDto.setTitle(String)",
    "void MediaDto.setUrl(String)"
  })
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

    // Assert
    assertEquals("Alt Text", actualAltText);
    assertEquals("Dr", actualTitle);
    assertEquals("Tags", actualTags);
    assertEquals("https://example.org/example", actualMediaDto.getUrl());
  }
}
