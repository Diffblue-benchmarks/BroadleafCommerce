/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class FetchPageRequestDiffblueTest {
  /**
   * Test {@link FetchPageRequest#withStartIndex(Integer)}.
   * <p>
   * Method under test: {@link FetchPageRequest#withStartIndex(Integer)}
   */
  @Test
  public void testWithStartIndex() {
    // Arrange
    FetchPageRequest fetchPageRequest = new FetchPageRequest();

    // Act
    FetchPageRequest actualWithStartIndexResult = fetchPageRequest.withStartIndex(1);

    // Assert
    assertEquals(1, fetchPageRequest.getStartIndex().intValue());
    assertSame(fetchPageRequest, actualWithStartIndexResult);
  }

  /**
   * Test {@link FetchPageRequest#withMaxIndex(Integer)}.
   * <p>
   * Method under test: {@link FetchPageRequest#withMaxIndex(Integer)}
   */
  @Test
  public void testWithMaxIndex() {
    // Arrange
    FetchPageRequest fetchPageRequest = new FetchPageRequest();

    // Act
    FetchPageRequest actualWithMaxIndexResult = fetchPageRequest.withMaxIndex(1);

    // Assert
    assertEquals(1, fetchPageRequest.getMaxIndex().intValue());
    assertSame(fetchPageRequest, actualWithMaxIndexResult);
  }

  /**
   * Test {@link FetchPageRequest#withLastId(Long)}.
   * <p>
   * Method under test: {@link FetchPageRequest#withLastId(Long)}
   */
  @Test
  public void testWithLastId() {
    // Arrange
    FetchPageRequest fetchPageRequest = new FetchPageRequest();

    // Act
    FetchPageRequest actualWithLastIdResult = fetchPageRequest.withLastId(1L);

    // Assert
    assertEquals(1L, fetchPageRequest.getLastId().longValue());
    assertSame(fetchPageRequest, actualWithLastIdResult);
  }

  /**
   * Test {@link FetchPageRequest#withFirstId(Long)}.
   * <p>
   * Method under test: {@link FetchPageRequest#withFirstId(Long)}
   */
  @Test
  public void testWithFirstId() {
    // Arrange
    FetchPageRequest fetchPageRequest = new FetchPageRequest();

    // Act
    FetchPageRequest actualWithFirstIdResult = fetchPageRequest.withFirstId(1L);

    // Assert
    assertEquals(1L, fetchPageRequest.getFirstId().longValue());
    assertSame(fetchPageRequest, actualWithFirstIdResult);
  }

  /**
   * Test {@link FetchPageRequest#withUpperCount(Integer)}.
   * <p>
   * Method under test: {@link FetchPageRequest#withUpperCount(Integer)}
   */
  @Test
  public void testWithUpperCount() {
    // Arrange
    FetchPageRequest fetchPageRequest = new FetchPageRequest();

    // Act
    FetchPageRequest actualWithUpperCountResult = fetchPageRequest.withUpperCount(3);

    // Assert
    assertEquals(3, fetchPageRequest.getUpperCount().intValue());
    assertSame(fetchPageRequest, actualWithUpperCountResult);
  }

  /**
   * Test {@link FetchPageRequest#withLowerCount(Integer)}.
   * <p>
   * Method under test: {@link FetchPageRequest#withLowerCount(Integer)}
   */
  @Test
  public void testWithLowerCount() {
    // Arrange
    FetchPageRequest fetchPageRequest = new FetchPageRequest();

    // Act
    FetchPageRequest actualWithLowerCountResult = fetchPageRequest.withLowerCount(3);

    // Assert
    assertEquals(3, fetchPageRequest.getLowerCount().intValue());
    assertSame(fetchPageRequest, actualWithLowerCountResult);
  }

  /**
   * Test {@link FetchPageRequest#withPageSize(Integer)}.
   * <p>
   * Method under test: {@link FetchPageRequest#withPageSize(Integer)}
   */
  @Test
  public void testWithPageSize() {
    // Arrange
    FetchPageRequest fetchPageRequest = new FetchPageRequest();

    // Act
    FetchPageRequest actualWithPageSizeResult = fetchPageRequest.withPageSize(3);

    // Assert
    assertEquals(3, fetchPageRequest.getPageSize().intValue());
    assertSame(fetchPageRequest, actualWithPageSizeResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FetchPageRequest}
   *   <li>{@link FetchPageRequest#setFirstId(Long)}
   *   <li>{@link FetchPageRequest#setLastId(Long)}
   *   <li>{@link FetchPageRequest#setLowerCount(Integer)}
   *   <li>{@link FetchPageRequest#setMaxIndex(Integer)}
   *   <li>{@link FetchPageRequest#setPageSize(Integer)}
   *   <li>{@link FetchPageRequest#setStartIndex(Integer)}
   *   <li>{@link FetchPageRequest#setUpperCount(Integer)}
   *   <li>{@link FetchPageRequest#getFirstId()}
   *   <li>{@link FetchPageRequest#getLastId()}
   *   <li>{@link FetchPageRequest#getLowerCount()}
   *   <li>{@link FetchPageRequest#getMaxIndex()}
   *   <li>{@link FetchPageRequest#getPageSize()}
   *   <li>{@link FetchPageRequest#getStartIndex()}
   *   <li>{@link FetchPageRequest#getUpperCount()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FetchPageRequest actualFetchPageRequest = new FetchPageRequest();
    actualFetchPageRequest.setFirstId(1L);
    actualFetchPageRequest.setLastId(1L);
    actualFetchPageRequest.setLowerCount(3);
    actualFetchPageRequest.setMaxIndex(1);
    actualFetchPageRequest.setPageSize(3);
    actualFetchPageRequest.setStartIndex(1);
    actualFetchPageRequest.setUpperCount(3);
    Long actualFirstId = actualFetchPageRequest.getFirstId();
    Long actualLastId = actualFetchPageRequest.getLastId();
    Integer actualLowerCount = actualFetchPageRequest.getLowerCount();
    Integer actualMaxIndex = actualFetchPageRequest.getMaxIndex();
    Integer actualPageSize = actualFetchPageRequest.getPageSize();
    Integer actualStartIndex = actualFetchPageRequest.getStartIndex();
    Integer actualUpperCount = actualFetchPageRequest.getUpperCount();

    // Assert that nothing has changed
    assertEquals(1, actualMaxIndex.intValue());
    assertEquals(1, actualStartIndex.intValue());
    assertEquals(1L, actualFirstId.longValue());
    assertEquals(1L, actualLastId.longValue());
    assertEquals(3, actualLowerCount.intValue());
    assertEquals(3, actualPageSize.intValue());
    assertEquals(3, actualUpperCount.intValue());
  }
}
