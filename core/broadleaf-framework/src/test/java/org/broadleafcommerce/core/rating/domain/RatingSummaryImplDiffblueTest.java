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
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.rating.service.type.RatingType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class RatingSummaryImplDiffblueTest {
  @Autowired private RatingSummaryImpl ratingSummaryImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Double RatingSummaryImpl.getAverageRating()",
    "Long RatingSummaryImpl.getId()",
    "String RatingSummaryImpl.getItemId()",
    "void RatingSummaryImpl.setId(Long)",
    "void RatingSummaryImpl.setItemId(String)",
    "void RatingSummaryImpl.setRatings(List)",
    "void RatingSummaryImpl.setReviews(List)"
  })
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

    // Assert
    assertEquals("42", ratingSummaryImpl.getItemId());
    assertEquals(0.0d, actualAverageRating.doubleValue(), 0.0);
    assertEquals(1L, actualId.longValue());
  }

  /**
   * Test {@link RatingSummaryImpl#resetAverageRating()}.
   *
   * <ul>
   *   <li>Given {@link RatingSummaryImpl}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSummaryImpl#resetAverageRating()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RatingSummaryImpl.resetAverageRating()"})
  public void testResetAverageRating_givenRatingSummaryImpl() {
    // Arrange and Act
    ratingSummaryImpl.resetAverageRating();

    // Assert that nothing has changed
    assertEquals(0.0d, ratingSummaryImpl.getAverageRating().doubleValue(), 0.0);
  }

  /**
   * Test {@link RatingSummaryImpl#resetAverageRating()}.
   *
   * <ul>
   *   <li>Given {@link RatingSummaryImpl} Ratings is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSummaryImpl#resetAverageRating()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RatingSummaryImpl.resetAverageRating()"})
  public void testResetAverageRating_givenRatingSummaryImplRatingsIsNull() {
    // Arrange
    ratingSummaryImpl.setRatings(null);

    // Act
    ratingSummaryImpl.resetAverageRating();

    // Assert that nothing has changed
    assertEquals(0.0d, ratingSummaryImpl.getAverageRating().doubleValue(), 0.0);
  }

  /**
   * Test {@link RatingSummaryImpl#resetAverageRating()}.
   *
   * <ul>
   *   <li>Then {@link RatingSummaryImpl} AverageRating doubleValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link RatingSummaryImpl#resetAverageRating()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RatingSummaryImpl.resetAverageRating()"})
  public void testResetAverageRating_thenRatingSummaryImplAverageRatingDoubleValueIsTen() {
    // Arrange
    RatingDetail ratingDetail = mock(RatingDetail.class);
    when(ratingDetail.getRating()).thenReturn(10.0d);

    ArrayList<RatingDetail> ratings = new ArrayList<>();
    ratings.add(ratingDetail);
    ratingSummaryImpl.setRatings(ratings);

    // Act
    ratingSummaryImpl.resetAverageRating();

    // Assert
    verify(ratingDetail).getRating();
    assertEquals(10.0d, ratingSummaryImpl.getAverageRating().doubleValue(), 0.0);
  }

  /**
   * Test {@link RatingSummaryImpl#getNumberOfRatings()}.
   *
   * <ul>
   *   <li>Given {@link RatingSummaryImpl}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSummaryImpl#getNumberOfRatings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer RatingSummaryImpl.getNumberOfRatings()"})
  public void testGetNumberOfRatings_givenRatingSummaryImpl() {
    // Arrange, Act and Assert
    assertEquals(0, ratingSummaryImpl.getNumberOfRatings().intValue());
  }

  /**
   * Test {@link RatingSummaryImpl#getNumberOfRatings()}.
   *
   * <ul>
   *   <li>Given {@link RatingSummaryImpl} Ratings is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSummaryImpl#getNumberOfRatings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer RatingSummaryImpl.getNumberOfRatings()"})
  public void testGetNumberOfRatings_givenRatingSummaryImplRatingsIsNull() {
    // Arrange
    ratingSummaryImpl.setRatings(null);

    // Act and Assert
    assertEquals(0, ratingSummaryImpl.getNumberOfRatings().intValue());
  }

  /**
   * Test {@link RatingSummaryImpl#getNumberOfReviews()}.
   *
   * <ul>
   *   <li>Given {@link RatingSummaryImpl}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSummaryImpl#getNumberOfReviews()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer RatingSummaryImpl.getNumberOfReviews()"})
  public void testGetNumberOfReviews_givenRatingSummaryImpl() {
    // Arrange, Act and Assert
    assertEquals(0, ratingSummaryImpl.getNumberOfReviews().intValue());
  }

  /**
   * Test {@link RatingSummaryImpl#getNumberOfReviews()}.
   *
   * <ul>
   *   <li>Given {@link RatingSummaryImpl} Reviews is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSummaryImpl#getNumberOfReviews()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer RatingSummaryImpl.getNumberOfReviews()"})
  public void testGetNumberOfReviews_givenRatingSummaryImplReviewsIsNull() {
    // Arrange
    ratingSummaryImpl.setReviews(null);

    // Act and Assert
    assertEquals(0, ratingSummaryImpl.getNumberOfReviews().intValue());
  }

  /**
   * Test {@link RatingSummaryImpl#getRatingType()}.
   *
   * <p>Method under test: {@link RatingSummaryImpl#getRatingType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RatingType RatingSummaryImpl.getRatingType()"})
  public void testGetRatingType() {
    // Arrange and Act
    RatingType actualRatingType = ratingSummaryImpl.getRatingType();

    // Assert
    assertNull(actualRatingType.getFriendlyType());
    assertNull(actualRatingType.getType());
  }

  /**
   * Test {@link RatingSummaryImpl#setRatingType(RatingType)}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>Then {@link RatingSummaryImpl} RatingType FriendlyType is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSummaryImpl#setRatingType(RatingType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RatingSummaryImpl.setRatingType(RatingType)"})
  public void testSetRatingType_givenType_thenRatingSummaryImplRatingTypeFriendlyTypeIsType() {
    // Arrange
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
   * Test {@link RatingSummaryImpl#setRatingType(RatingType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link RatingSummaryImpl} RatingType FriendlyType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSummaryImpl#setRatingType(RatingType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RatingSummaryImpl.setRatingType(RatingType)"})
  public void testSetRatingType_whenNull_thenRatingSummaryImplRatingTypeFriendlyTypeIsNull() {
    // Arrange and Act
    ratingSummaryImpl.setRatingType(null);

    // Assert that nothing has changed
    RatingType ratingType = ratingSummaryImpl.getRatingType();
    assertNull(ratingType.getFriendlyType());
    assertNull(ratingType.getType());
    assertNull(ratingSummaryImpl.ratingTypeStr);
  }

  /**
   * Test {@link RatingSummaryImpl#setRatingType(RatingType)}.
   *
   * <ul>
   *   <li>When {@link RatingType#PRODUCT}.
   *   <li>Then {@link RatingSummaryImpl} {@link RatingSummaryImpl#ratingTypeStr} is {@code
   *       PRODUCT}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSummaryImpl#setRatingType(RatingType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RatingSummaryImpl.setRatingType(RatingType)"})
  public void testSetRatingType_whenProduct_thenRatingSummaryImplRatingTypeStrIsProduct() {
    // Arrange and Act
    ratingSummaryImpl.setRatingType(RatingType.PRODUCT);

    // Assert
    assertEquals("PRODUCT", ratingSummaryImpl.ratingTypeStr);
    assertEquals(RatingType.PRODUCT, ratingSummaryImpl.getRatingType());
  }

  /**
   * Test {@link RatingSummaryImpl#getRatings()}.
   *
   * <ul>
   *   <li>Given {@link RatingSummaryImpl}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSummaryImpl#getRatings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RatingSummaryImpl.getRatings()"})
  public void testGetRatings_givenRatingSummaryImpl() {
    // Arrange, Act and Assert
    assertTrue(ratingSummaryImpl.getRatings().isEmpty());
  }

  /**
   * Test {@link RatingSummaryImpl#getRatings()}.
   *
   * <ul>
   *   <li>Given {@link RatingSummaryImpl} Ratings is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSummaryImpl#getRatings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RatingSummaryImpl.getRatings()"})
  public void testGetRatings_givenRatingSummaryImplRatingsIsNull() {
    // Arrange
    ratingSummaryImpl.setRatings(null);

    // Act and Assert
    assertTrue(ratingSummaryImpl.getRatings().isEmpty());
  }

  /**
   * Test {@link RatingSummaryImpl#getReviews()}.
   *
   * <ul>
   *   <li>Given {@link RatingSummaryImpl}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSummaryImpl#getReviews()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RatingSummaryImpl.getReviews()"})
  public void testGetReviews_givenRatingSummaryImpl() {
    // Arrange, Act and Assert
    assertTrue(ratingSummaryImpl.getReviews().isEmpty());
  }

  /**
   * Test {@link RatingSummaryImpl#getReviews()}.
   *
   * <ul>
   *   <li>Given {@link RatingSummaryImpl} Reviews is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSummaryImpl#getReviews()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List RatingSummaryImpl.getReviews()"})
  public void testGetReviews_givenRatingSummaryImplReviewsIsNull() {
    // Arrange
    ratingSummaryImpl.setReviews(null);

    // Act and Assert
    assertTrue(ratingSummaryImpl.getReviews().isEmpty());
  }

  /**
   * Test new {@link RatingSummaryImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link RatingSummaryImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RatingSummaryImpl.<init>()"})
  public void testNewRatingSummaryImpl() {
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
    assertTrue(actualRatingSummaryImpl.getRatings().isEmpty());
    assertTrue(actualRatingSummaryImpl.getReviews().isEmpty());
    assertTrue(actualRatingSummaryImpl.ratings.isEmpty());
    assertTrue(actualRatingSummaryImpl.reviews.isEmpty());
  }
}
