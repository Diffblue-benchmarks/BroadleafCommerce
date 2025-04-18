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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class RatingSummaryImplDiffblueTest {
  @Autowired
  private RatingSummaryImpl ratingSummaryImpl;

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Double RatingSummaryImpl.getAverageRating()", "Long RatingSummaryImpl.getId()",
      "String RatingSummaryImpl.getItemId()", "void RatingSummaryImpl.setId(Long)",
      "void RatingSummaryImpl.setItemId(String)", "void RatingSummaryImpl.setRatings(List)",
      "void RatingSummaryImpl.setReviews(List)"})
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
   * <ul>
   *   <li>Given {@link RatingSummaryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#resetAverageRating()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RatingSummaryImpl.resetAverageRating()"})
  public void testResetAverageRating_givenRatingSummaryImpl() {
    // Arrange
    RatingSummaryImpl ratingSummaryImpl2 = new RatingSummaryImpl();

    // Act
    ratingSummaryImpl2.resetAverageRating();

    // Assert that nothing has changed
    assertEquals(0.0d, ratingSummaryImpl2.getAverageRating().doubleValue(), 0.0);
  }

  /**
   * Test {@link RatingSummaryImpl#resetAverageRating()}.
   * <ul>
   *   <li>Given {@link RatingSummaryImpl} (default constructor) Ratings is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#resetAverageRating()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RatingSummaryImpl.resetAverageRating()"})
  public void testResetAverageRating_givenRatingSummaryImplRatingsIsNull() {
    // Arrange
    RatingSummaryImpl ratingSummaryImpl2 = new RatingSummaryImpl();
    ratingSummaryImpl2.setId(1L);
    ratingSummaryImpl2.setItemId("42");
    ratingSummaryImpl2.setRatingType(RatingType.PRODUCT);
    ratingSummaryImpl2.setReviews(new ArrayList<>());
    ratingSummaryImpl2.setRatings(null);

    // Act
    ratingSummaryImpl2.resetAverageRating();

    // Assert that nothing has changed
    assertEquals(0.0d, ratingSummaryImpl2.getAverageRating().doubleValue(), 0.0);
  }

  /**
   * Test {@link RatingSummaryImpl#resetAverageRating()}.
   * <ul>
   *   <li>Then {@link RatingSummaryImpl} (default constructor) AverageRating doubleValue is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#resetAverageRating()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RatingSummaryImpl.resetAverageRating()"})
  public void testResetAverageRating_thenRatingSummaryImplAverageRatingDoubleValueIsTen() {
    // Arrange
    RatingDetailImpl ratingDetailImpl = mock(RatingDetailImpl.class);
    when(ratingDetailImpl.getRating()).thenReturn(10.0d);

    ArrayList<RatingDetail> ratings = new ArrayList<>();
    ratings.add(ratingDetailImpl);

    RatingSummaryImpl ratingSummaryImpl2 = new RatingSummaryImpl();
    ratingSummaryImpl2.setId(1L);
    ratingSummaryImpl2.setItemId("42");
    ratingSummaryImpl2.setRatingType(RatingType.PRODUCT);
    ratingSummaryImpl2.setReviews(new ArrayList<>());
    ratingSummaryImpl2.setRatings(ratings);

    // Act
    ratingSummaryImpl2.resetAverageRating();

    // Assert
    verify(ratingDetailImpl).getRating();
    assertEquals(10.0d, ratingSummaryImpl2.getAverageRating().doubleValue(), 0.0);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Integer RatingSummaryImpl.getNumberOfRatings()"})
  public void testGetNumberOfRatings_givenRatingSummaryImpl() {
    // Arrange, Act and Assert
    assertEquals(0, (new RatingSummaryImpl()).getNumberOfRatings().intValue());
  }

  /**
   * Test {@link RatingSummaryImpl#getNumberOfRatings()}.
   * <ul>
   *   <li>Given {@link RatingSummaryImpl} (default constructor) Id is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#getNumberOfRatings()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Integer RatingSummaryImpl.getNumberOfRatings()"})
  public void testGetNumberOfRatings_givenRatingSummaryImplIdIsOne() {
    // Arrange
    RatingSummaryImpl ratingSummaryImpl2 = new RatingSummaryImpl();
    ratingSummaryImpl2.setId(1L);
    ratingSummaryImpl2.setItemId("42");
    ratingSummaryImpl2.setRatingType(RatingType.PRODUCT);
    ratingSummaryImpl2.setReviews(new ArrayList<>());
    ratingSummaryImpl2.setRatings(null);

    // Act and Assert
    assertEquals(0, ratingSummaryImpl2.getNumberOfRatings().intValue());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Integer RatingSummaryImpl.getNumberOfReviews()"})
  public void testGetNumberOfReviews_givenRatingSummaryImpl() {
    // Arrange, Act and Assert
    assertEquals(0, (new RatingSummaryImpl()).getNumberOfReviews().intValue());
  }

  /**
   * Test {@link RatingSummaryImpl#getNumberOfReviews()}.
   * <ul>
   *   <li>Given {@link RatingSummaryImpl} (default constructor) Id is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#getNumberOfReviews()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Integer RatingSummaryImpl.getNumberOfReviews()"})
  public void testGetNumberOfReviews_givenRatingSummaryImplIdIsOne() {
    // Arrange
    RatingSummaryImpl ratingSummaryImpl2 = new RatingSummaryImpl();
    ratingSummaryImpl2.setId(1L);
    ratingSummaryImpl2.setItemId("42");
    ratingSummaryImpl2.setRatingType(RatingType.PRODUCT);
    ratingSummaryImpl2.setRatings(new ArrayList<>());
    ratingSummaryImpl2.setReviews(null);

    // Act and Assert
    assertEquals(0, ratingSummaryImpl2.getNumberOfReviews().intValue());
  }

  /**
   * Test {@link RatingSummaryImpl#getRatingType()}.
   * <p>
   * Method under test: {@link RatingSummaryImpl#getRatingType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RatingType RatingSummaryImpl.getRatingType()"})
  public void testGetRatingType() {
    // Arrange and Act
    RatingType actualRatingType = (new RatingSummaryImpl()).getRatingType();

    // Assert
    assertNull(actualRatingType.getFriendlyType());
    assertNull(actualRatingType.getType());
  }

  /**
   * Test {@link RatingSummaryImpl#setRatingType(RatingType)}.
   * <ul>
   *   <li>Given {@code Type}.</li>
   *   <li>Then {@link RatingSummaryImpl} (default constructor) RatingType FriendlyType is {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#setRatingType(RatingType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RatingSummaryImpl.setRatingType(RatingType)"})
  public void testSetRatingType_givenType_thenRatingSummaryImplRatingTypeFriendlyTypeIsType() {
    // Arrange
    RatingSummaryImpl ratingSummaryImpl2 = new RatingSummaryImpl();
    RatingType type = mock(RatingType.class);
    when(type.getType()).thenReturn("Type");

    // Act
    ratingSummaryImpl2.setRatingType(type);

    // Assert
    verify(type).getType();
    RatingType ratingType = ratingSummaryImpl2.getRatingType();
    assertEquals("Type", ratingType.getFriendlyType());
    assertEquals("Type", ratingType.getType());
    assertEquals("Type", ratingSummaryImpl2.ratingTypeStr);
  }

  /**
   * Test {@link RatingSummaryImpl#setRatingType(RatingType)}.
   * <ul>
   *   <li>Then {@link RatingSummaryImpl} (default constructor) RatingType FriendlyType is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#setRatingType(RatingType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RatingSummaryImpl.setRatingType(RatingType)"})
  public void testSetRatingType_thenRatingSummaryImplRatingTypeFriendlyTypeIsNull() {
    // Arrange
    RatingSummaryImpl ratingSummaryImpl2 = new RatingSummaryImpl();
    ratingSummaryImpl2.setId(1L);
    ratingSummaryImpl2.setItemId("42");
    ratingSummaryImpl2.setRatingType(RatingType.PRODUCT);
    ratingSummaryImpl2.setRatings(new ArrayList<>());
    ratingSummaryImpl2.setReviews(new ArrayList<>());

    // Act
    ratingSummaryImpl2.setRatingType(null);

    // Assert
    RatingType ratingType = ratingSummaryImpl2.getRatingType();
    assertNull(ratingType.getFriendlyType());
    assertNull(ratingType.getType());
    assertNull(ratingSummaryImpl2.ratingTypeStr);
  }

  /**
   * Test {@link RatingSummaryImpl#setRatingType(RatingType)}.
   * <ul>
   *   <li>When {@link RatingType#PRODUCT}.</li>
   *   <li>Then {@link RatingSummaryImpl} (default constructor) {@link RatingSummaryImpl#ratingTypeStr} is {@code PRODUCT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#setRatingType(RatingType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RatingSummaryImpl.setRatingType(RatingType)"})
  public void testSetRatingType_whenProduct_thenRatingSummaryImplRatingTypeStrIsProduct() {
    // Arrange
    RatingSummaryImpl ratingSummaryImpl2 = new RatingSummaryImpl();
    RatingType type = RatingType.PRODUCT;

    // Act
    ratingSummaryImpl2.setRatingType(type);

    // Assert
    assertEquals("PRODUCT", ratingSummaryImpl2.ratingTypeStr);
    RatingType expectedRatingType = type.PRODUCT;
    assertEquals(expectedRatingType, ratingSummaryImpl2.getRatingType());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RatingSummaryImpl.getRatings()"})
  public void testGetRatings_givenRatingSummaryImpl() {
    // Arrange, Act and Assert
    assertTrue((new RatingSummaryImpl()).getRatings().isEmpty());
  }

  /**
   * Test {@link RatingSummaryImpl#getRatings()}.
   * <ul>
   *   <li>Given {@link RatingSummaryImpl} (default constructor) Id is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#getRatings()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RatingSummaryImpl.getRatings()"})
  public void testGetRatings_givenRatingSummaryImplIdIsOne() {
    // Arrange
    RatingSummaryImpl ratingSummaryImpl2 = new RatingSummaryImpl();
    ratingSummaryImpl2.setId(1L);
    ratingSummaryImpl2.setItemId("42");
    ratingSummaryImpl2.setRatingType(RatingType.PRODUCT);
    ratingSummaryImpl2.setReviews(new ArrayList<>());
    ratingSummaryImpl2.setRatings(null);

    // Act and Assert
    assertTrue(ratingSummaryImpl2.getRatings().isEmpty());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RatingSummaryImpl.getReviews()"})
  public void testGetReviews_givenRatingSummaryImpl() {
    // Arrange, Act and Assert
    assertTrue((new RatingSummaryImpl()).getReviews().isEmpty());
  }

  /**
   * Test {@link RatingSummaryImpl#getReviews()}.
   * <ul>
   *   <li>Given {@link RatingSummaryImpl} (default constructor) Id is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RatingSummaryImpl#getReviews()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RatingSummaryImpl.getReviews()"})
  public void testGetReviews_givenRatingSummaryImplIdIsOne() {
    // Arrange
    RatingSummaryImpl ratingSummaryImpl2 = new RatingSummaryImpl();
    ratingSummaryImpl2.setId(1L);
    ratingSummaryImpl2.setItemId("42");
    ratingSummaryImpl2.setRatingType(RatingType.PRODUCT);
    ratingSummaryImpl2.setRatings(new ArrayList<>());
    ratingSummaryImpl2.setReviews(null);

    // Act and Assert
    assertTrue(ratingSummaryImpl2.getReviews().isEmpty());
  }

  /**
   * Test new {@link RatingSummaryImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link RatingSummaryImpl}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
