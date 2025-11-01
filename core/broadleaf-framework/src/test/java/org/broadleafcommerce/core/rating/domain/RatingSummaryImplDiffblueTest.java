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
package org.broadleafcommerce.core.rating.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.rating.service.type.RatingType;
import org.junit.Test;

public class RatingSummaryImplDiffblueTest {
  /**
   * Method under test: {@link RatingSummaryImpl#resetAverageRating()}
   */
  @Test
  public void testResetAverageRating() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();

    // Act
    ratingSummaryImpl.resetAverageRating();

    // Assert
    assertEquals(0.0d, ratingSummaryImpl.getAverageRating().doubleValue(), 0.0);
  }

  /**
   * Method under test: {@link RatingSummaryImpl#resetAverageRating()}
   */
  @Test
  public void testResetAverageRating2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();
    ratingSummaryImpl.setId(1L);
    ratingSummaryImpl.setItemId("42");
    ratingSummaryImpl.setRatingType(RatingType.PRODUCT);
    ratingSummaryImpl.setReviews(new ArrayList<>());
    ratingSummaryImpl.setRatings(null);

    // Act
    ratingSummaryImpl.resetAverageRating();

    // Assert
    assertEquals(0.0d, ratingSummaryImpl.getAverageRating().doubleValue(), 0.0);
  }

  /**
   * Method under test: {@link RatingSummaryImpl#resetAverageRating()}
   */
  @Test
  public void testResetAverageRating3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RatingType type = mock(RatingType.class);
    when(type.getType()).thenReturn("Type");

    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();
    ratingSummaryImpl.setId(1L);
    ratingSummaryImpl.setItemId("42");
    ratingSummaryImpl.setRatingType(type);
    ratingSummaryImpl.setReviews(new ArrayList<>());
    ratingSummaryImpl.setRatings(null);

    // Act
    ratingSummaryImpl.resetAverageRating();

    // Assert
    verify(type).getType();
    assertEquals(0.0d, ratingSummaryImpl.getAverageRating().doubleValue(), 0.0);
  }

  /**
   * Method under test: {@link RatingSummaryImpl#resetAverageRating()}
   */
  @Test
  public void testResetAverageRating4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RatingDetailImpl ratingDetailImpl = mock(RatingDetailImpl.class);
    when(ratingDetailImpl.getRating()).thenReturn(10.0d);

    ArrayList<RatingDetail> ratings = new ArrayList<>();
    ratings.add(ratingDetailImpl);

    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();
    ratingSummaryImpl.setId(1L);
    ratingSummaryImpl.setItemId("42");
    ratingSummaryImpl.setRatingType(RatingType.PRODUCT);
    ratingSummaryImpl.setReviews(new ArrayList<>());
    ratingSummaryImpl.setRatings(ratings);

    // Act
    ratingSummaryImpl.resetAverageRating();

    // Assert
    verify(ratingDetailImpl).getRating();
    assertEquals(10.0d, ratingSummaryImpl.getAverageRating().doubleValue(), 0.0);
  }

  /**
   * Method under test: {@link RatingSummaryImpl#getNumberOfRatings()}
   */
  @Test
  public void testGetNumberOfRatings() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0, (new RatingSummaryImpl()).getNumberOfRatings().intValue());
  }

  /**
   * Method under test: {@link RatingSummaryImpl#getNumberOfRatings()}
   */
  @Test
  public void testGetNumberOfRatings2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();
    ratingSummaryImpl.setId(1L);
    ratingSummaryImpl.setItemId("42");
    ratingSummaryImpl.setRatingType(RatingType.PRODUCT);
    ratingSummaryImpl.setReviews(new ArrayList<>());
    ratingSummaryImpl.setRatings(null);

    // Act and Assert
    assertEquals(0, ratingSummaryImpl.getNumberOfRatings().intValue());
  }

  /**
   * Method under test: {@link RatingSummaryImpl#getNumberOfRatings()}
   */
  @Test
  public void testGetNumberOfRatings3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RatingType type = mock(RatingType.class);
    when(type.getType()).thenReturn("Type");

    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();
    ratingSummaryImpl.setId(1L);
    ratingSummaryImpl.setItemId("42");
    ratingSummaryImpl.setRatingType(type);
    ratingSummaryImpl.setReviews(new ArrayList<>());
    ratingSummaryImpl.setRatings(null);

    // Act
    Integer actualNumberOfRatings = ratingSummaryImpl.getNumberOfRatings();

    // Assert
    verify(type).getType();
    assertEquals(0, actualNumberOfRatings.intValue());
  }

  /**
   * Method under test: {@link RatingSummaryImpl#getNumberOfReviews()}
   */
  @Test
  public void testGetNumberOfReviews() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0, (new RatingSummaryImpl()).getNumberOfReviews().intValue());
  }

  /**
   * Method under test: {@link RatingSummaryImpl#getNumberOfReviews()}
   */
  @Test
  public void testGetNumberOfReviews2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();
    ratingSummaryImpl.setId(1L);
    ratingSummaryImpl.setItemId("42");
    ratingSummaryImpl.setRatingType(RatingType.PRODUCT);
    ratingSummaryImpl.setRatings(new ArrayList<>());
    ratingSummaryImpl.setReviews(null);

    // Act and Assert
    assertEquals(0, ratingSummaryImpl.getNumberOfReviews().intValue());
  }

  /**
   * Method under test: {@link RatingSummaryImpl#getNumberOfReviews()}
   */
  @Test
  public void testGetNumberOfReviews3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RatingType type = mock(RatingType.class);
    when(type.getType()).thenReturn("Type");

    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();
    ratingSummaryImpl.setId(1L);
    ratingSummaryImpl.setItemId("42");
    ratingSummaryImpl.setRatingType(type);
    ratingSummaryImpl.setRatings(new ArrayList<>());
    ratingSummaryImpl.setReviews(null);

    // Act
    Integer actualNumberOfReviews = ratingSummaryImpl.getNumberOfReviews();

    // Assert
    verify(type).getType();
    assertEquals(0, actualNumberOfReviews.intValue());
  }

  /**
   * Method under test: {@link RatingSummaryImpl#getRatingType()}
   */
  @Test
  public void testGetRatingType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    RatingType actualRatingType = (new RatingSummaryImpl()).getRatingType();

    // Assert
    assertNull(actualRatingType.getFriendlyType());
    assertNull(actualRatingType.getType());
  }

  /**
   * Method under test: {@link RatingSummaryImpl#getRatingType()}
   */
  @Test
  public void testGetRatingType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RatingType type = mock(RatingType.class);
    when(type.getType()).thenReturn("Type");

    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();
    ratingSummaryImpl.setRatingType(type);

    // Act
    RatingType actualRatingType = ratingSummaryImpl.getRatingType();

    // Assert
    verify(type).getType();
    assertEquals("Type", actualRatingType.getFriendlyType());
    assertEquals("Type", actualRatingType.getType());
  }

  /**
   * Method under test: {@link RatingSummaryImpl#getRatingType()}
   */
  @Test
  public void testGetRatingType3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RatingType type = mock(RatingType.class);
    when(type.getType()).thenReturn("foo");

    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();
    ratingSummaryImpl.setRatingType(type);

    // Act
    RatingType actualRatingType = ratingSummaryImpl.getRatingType();

    // Assert
    verify(type).getType();
    assertEquals("foo", actualRatingType.getFriendlyType());
    assertEquals("foo", actualRatingType.getType());
  }

  /**
   * Method under test: {@link RatingSummaryImpl#setRatingType(RatingType)}
   */
  @Test
  public void testSetRatingType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();
    RatingType type = RatingType.PRODUCT;

    // Act
    ratingSummaryImpl.setRatingType(type);

    // Assert
    assertEquals("PRODUCT", ratingSummaryImpl.ratingTypeStr);
    RatingType expectedRatingType = type.PRODUCT;
    assertEquals(expectedRatingType, ratingSummaryImpl.getRatingType());
  }

  /**
   * Method under test: {@link RatingSummaryImpl#setRatingType(RatingType)}
   */
  @Test
  public void testSetRatingType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();
    ratingSummaryImpl.setId(1L);
    ratingSummaryImpl.setItemId("42");
    ratingSummaryImpl.setRatingType(RatingType.PRODUCT);
    ratingSummaryImpl.setRatings(new ArrayList<>());
    ratingSummaryImpl.setReviews(new ArrayList<>());

    // Act
    ratingSummaryImpl.setRatingType(null);

    // Assert
    RatingType ratingType = ratingSummaryImpl.getRatingType();
    assertNull(ratingType.getFriendlyType());
    assertNull(ratingType.getType());
    assertNull(ratingSummaryImpl.ratingTypeStr);
  }

  /**
   * Method under test: {@link RatingSummaryImpl#setRatingType(RatingType)}
   */
  @Test
  public void testSetRatingType3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();
    RatingType type = mock(RatingType.class);
    when(type.getType()).thenReturn("Type");

    // Act
    ratingSummaryImpl.setRatingType(type);

    // Assert
    verify(type).getType();
    RatingType ratingType = ratingSummaryImpl.getRatingType();
    assertEquals("Type", ratingType.getFriendlyType());
    assertEquals("Type", ratingType.getType());
    assertEquals("Type", ratingSummaryImpl.ratingTypeStr);
  }

  /**
   * Method under test: {@link RatingSummaryImpl#getRatings()}
   */
  @Test
  public void testGetRatings() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();

    // Act
    List<RatingDetail> actualRatings = ratingSummaryImpl.getRatings();

    // Assert
    assertTrue(actualRatings.isEmpty());
    assertSame(ratingSummaryImpl.ratings, actualRatings);
  }

  /**
   * Method under test: {@link RatingSummaryImpl#getRatings()}
   */
  @Test
  public void testGetRatings2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();
    ratingSummaryImpl.setId(1L);
    ratingSummaryImpl.setItemId("42");
    ratingSummaryImpl.setRatingType(RatingType.PRODUCT);
    ratingSummaryImpl.setReviews(new ArrayList<>());
    ratingSummaryImpl.setRatings(null);

    // Act and Assert
    assertTrue(ratingSummaryImpl.getRatings().isEmpty());
  }

  /**
   * Method under test: {@link RatingSummaryImpl#getRatings()}
   */
  @Test
  public void testGetRatings3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RatingType type = mock(RatingType.class);
    when(type.getType()).thenReturn("Type");

    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();
    ratingSummaryImpl.setId(1L);
    ratingSummaryImpl.setItemId("42");
    ratingSummaryImpl.setRatingType(type);
    ratingSummaryImpl.setReviews(new ArrayList<>());
    ratingSummaryImpl.setRatings(null);

    // Act
    List<RatingDetail> actualRatings = ratingSummaryImpl.getRatings();

    // Assert
    verify(type).getType();
    assertTrue(actualRatings.isEmpty());
  }

  /**
   * Method under test: {@link RatingSummaryImpl#getReviews()}
   */
  @Test
  public void testGetReviews() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();

    // Act
    List<ReviewDetail> actualReviews = ratingSummaryImpl.getReviews();

    // Assert
    assertTrue(actualReviews.isEmpty());
    assertSame(ratingSummaryImpl.reviews, actualReviews);
  }

  /**
   * Method under test: {@link RatingSummaryImpl#getReviews()}
   */
  @Test
  public void testGetReviews2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();
    ratingSummaryImpl.setId(1L);
    ratingSummaryImpl.setItemId("42");
    ratingSummaryImpl.setRatingType(RatingType.PRODUCT);
    ratingSummaryImpl.setRatings(new ArrayList<>());
    ratingSummaryImpl.setReviews(null);

    // Act and Assert
    assertTrue(ratingSummaryImpl.getReviews().isEmpty());
  }

  /**
   * Method under test: {@link RatingSummaryImpl#getReviews()}
   */
  @Test
  public void testGetReviews3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RatingType type = mock(RatingType.class);
    when(type.getType()).thenReturn("Type");

    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();
    ratingSummaryImpl.setId(1L);
    ratingSummaryImpl.setItemId("42");
    ratingSummaryImpl.setRatingType(type);
    ratingSummaryImpl.setRatings(new ArrayList<>());
    ratingSummaryImpl.setReviews(null);

    // Act
    List<ReviewDetail> actualReviews = ratingSummaryImpl.getReviews();

    // Assert
    verify(type).getType();
    assertTrue(actualReviews.isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RatingSummaryImpl#setId(Long)}
   *   <li>{@link RatingSummaryImpl#setItemId(String)}
   *   <li>{@link RatingSummaryImpl#setRatings(List)}
   *   <li>{@link RatingSummaryImpl#setReviews(List)}
   *   <li>{@link RatingSummaryImpl#getAverageRating()}
   *   <li>{@link RatingSummaryImpl#getId()}
   *   <li>{@link RatingSummaryImpl#getItemId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();

    // Act
    ratingSummaryImpl.setId(1L);
    ratingSummaryImpl.setItemId("42");
    ratingSummaryImpl.setRatings(new ArrayList<>());
    ratingSummaryImpl.setReviews(new ArrayList<>());
    Double actualAverageRating = ratingSummaryImpl.getAverageRating();
    Long actualId = ratingSummaryImpl.getId();

    // Assert that nothing has changed
    assertEquals("42", ratingSummaryImpl.getItemId());
    assertEquals(0.0d, actualAverageRating.doubleValue(), 0.0);
    assertEquals(1L, actualId.longValue());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link RatingSummaryImpl}
   */
  @Test
  public void testNewRatingSummaryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    RatingSummaryImpl actualRatingSummaryImpl = new RatingSummaryImpl();

    // Assert
    assertNull(actualRatingSummaryImpl.getId());
    assertNull(actualRatingSummaryImpl.getItemId());
    RatingType ratingType = actualRatingSummaryImpl.getRatingType();
    assertNull(ratingType.getFriendlyType());
    assertNull(ratingType.getType());
    assertNull(actualRatingSummaryImpl.ratingTypeStr);
    assertEquals(0, actualRatingSummaryImpl.getNumberOfRatings().intValue());
    assertEquals(0, actualRatingSummaryImpl.getNumberOfReviews().intValue());
    assertEquals(0.0d, actualRatingSummaryImpl.getAverageRating().doubleValue(), 0.0);
    List<RatingDetail> ratings = actualRatingSummaryImpl.getRatings();
    assertTrue(ratings.isEmpty());
    List<ReviewDetail> reviews = actualRatingSummaryImpl.getReviews();
    assertTrue(reviews.isEmpty());
    assertTrue(actualRatingSummaryImpl.ratings.isEmpty());
    assertTrue(actualRatingSummaryImpl.reviews.isEmpty());
    assertSame(actualRatingSummaryImpl.ratings, ratings);
    assertSame(actualRatingSummaryImpl.reviews, reviews);
  }
}
