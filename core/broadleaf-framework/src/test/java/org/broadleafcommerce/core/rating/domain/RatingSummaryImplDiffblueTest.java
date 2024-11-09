/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.rating.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
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
   * Test getters and setters.
   * <p>
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
   * Test {@link RatingSummaryImpl#resetAverageRating()}.
   * <ul>
   *   <li>Given {@link RatingSummaryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#resetAverageRating()}
   */
  @Test
  public void testResetAverageRating_givenRatingSummaryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();

    // Act
    ratingSummaryImpl.resetAverageRating();

    // Assert
    assertEquals(0.0d, ratingSummaryImpl.getAverageRating().doubleValue(), 0.0);
  }

  /**
   * Test {@link RatingSummaryImpl#resetAverageRating()}.
   * <ul>
   *   <li>Given {@link RatingSummaryImpl} (default constructor) Ratings is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#resetAverageRating()}
   */
  @Test
  public void testResetAverageRating_givenRatingSummaryImplRatingsIsNull() {
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
   * Test {@link RatingSummaryImpl#resetAverageRating()}.
   * <ul>
   *   <li>Given {@link RatingType} {@link RatingType#getType()} return
   * {@code Type}.</li>
   *   <li>Then calls {@link RatingType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#resetAverageRating()}
   */
  @Test
  public void testResetAverageRating_givenRatingTypeGetTypeReturnType_thenCallsGetType() {
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
   * Test {@link RatingSummaryImpl#resetAverageRating()}.
   * <ul>
   *   <li>Then {@link RatingSummaryImpl} (default constructor) AverageRating
   * doubleValue is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#resetAverageRating()}
   */
  @Test
  public void testResetAverageRating_thenRatingSummaryImplAverageRatingDoubleValueIsTen() {
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
   * Test {@link RatingSummaryImpl#getNumberOfRatings()}.
   * <ul>
   *   <li>Given {@link RatingSummaryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#getNumberOfRatings()}
   */
  @Test
  public void testGetNumberOfRatings_givenRatingSummaryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0, (new RatingSummaryImpl()).getNumberOfRatings().intValue());
  }

  /**
   * Test {@link RatingSummaryImpl#getNumberOfRatings()}.
   * <ul>
   *   <li>Given {@link RatingSummaryImpl} (default constructor) RatingType is
   * {@link RatingType#PRODUCT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#getNumberOfRatings()}
   */
  @Test
  public void testGetNumberOfRatings_givenRatingSummaryImplRatingTypeIsProduct() {
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
   * Test {@link RatingSummaryImpl#getNumberOfRatings()}.
   * <ul>
   *   <li>Given {@link RatingType} {@link RatingType#getType()} return
   * {@code Type}.</li>
   *   <li>Then calls {@link RatingType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#getNumberOfRatings()}
   */
  @Test
  public void testGetNumberOfRatings_givenRatingTypeGetTypeReturnType_thenCallsGetType() {
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
   * Test {@link RatingSummaryImpl#getNumberOfReviews()}.
   * <ul>
   *   <li>Given {@link RatingSummaryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#getNumberOfReviews()}
   */
  @Test
  public void testGetNumberOfReviews_givenRatingSummaryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0, (new RatingSummaryImpl()).getNumberOfReviews().intValue());
  }

  /**
   * Test {@link RatingSummaryImpl#getNumberOfReviews()}.
   * <ul>
   *   <li>Given {@link RatingSummaryImpl} (default constructor) RatingType is
   * {@link RatingType#PRODUCT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#getNumberOfReviews()}
   */
  @Test
  public void testGetNumberOfReviews_givenRatingSummaryImplRatingTypeIsProduct() {
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
   * Test {@link RatingSummaryImpl#getNumberOfReviews()}.
   * <ul>
   *   <li>Given {@link RatingType} {@link RatingType#getType()} return
   * {@code Type}.</li>
   *   <li>Then calls {@link RatingType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#getNumberOfReviews()}
   */
  @Test
  public void testGetNumberOfReviews_givenRatingTypeGetTypeReturnType_thenCallsGetType() {
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
   * Test {@link RatingSummaryImpl#getRatingType()}.
   * <ul>
   *   <li>Given {@link RatingSummaryImpl} (default constructor).</li>
   *   <li>Then return FriendlyType is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#getRatingType()}
   */
  @Test
  public void testGetRatingType_givenRatingSummaryImpl_thenReturnFriendlyTypeIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    RatingType actualRatingType = (new RatingSummaryImpl()).getRatingType();

    // Assert
    assertNull(actualRatingType.getFriendlyType());
    assertNull(actualRatingType.getType());
  }

  /**
   * Test {@link RatingSummaryImpl#getRatingType()}.
   * <ul>
   *   <li>Given {@link RatingType} {@link RatingType#getType()} return
   * {@code foo}.</li>
   *   <li>Then return FriendlyType is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#getRatingType()}
   */
  @Test
  public void testGetRatingType_givenRatingTypeGetTypeReturnFoo_thenReturnFriendlyTypeIsFoo() {
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
   * Test {@link RatingSummaryImpl#getRatingType()}.
   * <ul>
   *   <li>Given {@link RatingType} {@link RatingType#getType()} return
   * {@code Type}.</li>
   *   <li>Then return FriendlyType is {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#getRatingType()}
   */
  @Test
  public void testGetRatingType_givenRatingTypeGetTypeReturnType_thenReturnFriendlyTypeIsType() {
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
   * Test {@link RatingSummaryImpl#setRatingType(RatingType)}.
   * <ul>
   *   <li>Given {@code Type}.</li>
   *   <li>Then {@link RatingSummaryImpl} (default constructor) RatingType
   * FriendlyType is {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#setRatingType(RatingType)}
   */
  @Test
  public void testSetRatingType_givenType_thenRatingSummaryImplRatingTypeFriendlyTypeIsType() {
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
   * Test {@link RatingSummaryImpl#setRatingType(RatingType)}.
   * <ul>
   *   <li>Then {@link RatingSummaryImpl} (default constructor) RatingType
   * FriendlyType is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#setRatingType(RatingType)}
   */
  @Test
  public void testSetRatingType_thenRatingSummaryImplRatingTypeFriendlyTypeIsNull() {
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
   * Test {@link RatingSummaryImpl#setRatingType(RatingType)}.
   * <ul>
   *   <li>When {@link RatingType#PRODUCT}.</li>
   *   <li>Then {@link RatingSummaryImpl} (default constructor)
   * {@link RatingSummaryImpl#ratingTypeStr} is {@code PRODUCT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#setRatingType(RatingType)}
   */
  @Test
  public void testSetRatingType_whenProduct_thenRatingSummaryImplRatingTypeStrIsProduct() {
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
   * Test {@link RatingSummaryImpl#getRatings()}.
   * <ul>
   *   <li>Given {@link RatingSummaryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#getRatings()}
   */
  @Test
  public void testGetRatings_givenRatingSummaryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new RatingSummaryImpl()).getRatings().isEmpty());
  }

  /**
   * Test {@link RatingSummaryImpl#getRatings()}.
   * <ul>
   *   <li>Given {@link RatingSummaryImpl} (default constructor) RatingType is
   * {@link RatingType#PRODUCT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#getRatings()}
   */
  @Test
  public void testGetRatings_givenRatingSummaryImplRatingTypeIsProduct() {
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
   * Test {@link RatingSummaryImpl#getRatings()}.
   * <ul>
   *   <li>Given {@link RatingType} {@link RatingType#getType()} return
   * {@code Type}.</li>
   *   <li>Then calls {@link RatingType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#getRatings()}
   */
  @Test
  public void testGetRatings_givenRatingTypeGetTypeReturnType_thenCallsGetType() {
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
   * Test {@link RatingSummaryImpl#getReviews()}.
   * <ul>
   *   <li>Given {@link RatingSummaryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#getReviews()}
   */
  @Test
  public void testGetReviews_givenRatingSummaryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new RatingSummaryImpl()).getReviews().isEmpty());
  }

  /**
   * Test {@link RatingSummaryImpl#getReviews()}.
   * <ul>
   *   <li>Given {@link RatingSummaryImpl} (default constructor) RatingType is
   * {@link RatingType#PRODUCT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#getReviews()}
   */
  @Test
  public void testGetReviews_givenRatingSummaryImplRatingTypeIsProduct() {
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
   * Test {@link RatingSummaryImpl#getReviews()}.
   * <ul>
   *   <li>Given {@link RatingType} {@link RatingType#getType()} return
   * {@code Type}.</li>
   *   <li>Then calls {@link RatingType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#getReviews()}
   */
  @Test
  public void testGetReviews_givenRatingTypeGetTypeReturnType_thenCallsGetType() {
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
   * Test new {@link RatingSummaryImpl} (default constructor).
   * <p>
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
    assertTrue(actualRatingSummaryImpl.getRatings().isEmpty());
    assertTrue(actualRatingSummaryImpl.getReviews().isEmpty());
    assertTrue(actualRatingSummaryImpl.ratings.isEmpty());
    assertTrue(actualRatingSummaryImpl.reviews.isEmpty());
  }
}
