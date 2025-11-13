package org.broadleafcommerce.common.cache;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CacheStatDiffblueTest {
  /**
   * Test {@link CacheStat#getCacheHitCount()}.
   *
   * <p>Method under test: {@link CacheStat#getCacheHitCount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long CacheStat.getCacheHitCount()"})
  public void testGetCacheHitCount() {
    // Arrange, Act and Assert
    assertEquals(0L, new CacheStat().getCacheHitCount().longValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CacheStat#setLastLogTime(Long)}
   *   <li>{@link CacheStat#getLastLogTime()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long CacheStat.getLastLogTime()", "void CacheStat.setLastLogTime(Long)"})
  public void testGettersAndSetters() {
    // Arrange
    CacheStat cacheStat = new CacheStat();

    // Act
    cacheStat.setLastLogTime(1L);

    // Assert
    assertEquals(1L, cacheStat.getLastLogTime().longValue());
  }

  /**
   * Test {@link CacheStat#getRequestCount()}.
   *
   * <p>Method under test: {@link CacheStat#getRequestCount()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long CacheStat.getRequestCount()"})
  public void testGetRequestCount() {
    // Arrange, Act and Assert
    assertEquals(0L, new CacheStat().getRequestCount().longValue());
  }

  /**
   * Test {@link CacheStat#incrementRequest()}.
   *
   * <p>Method under test: {@link CacheStat#incrementRequest()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CacheStat.incrementRequest()"})
  public void testIncrementRequest() {
    // Arrange
    CacheStat cacheStat = new CacheStat();

    // Act
    cacheStat.incrementRequest();

    // Assert
    AtomicLong atomicLong = cacheStat.requestCount;
    assertEquals(1L, atomicLong.get());
    assertEquals(1L, atomicLong.getAndDecrement());
    assertEquals(0L, atomicLong.getAndIncrement());
    assertEquals(new BigDecimal("0.00"), cacheStat.getHitRate());
    assertEquals(1L, cacheStat.getRequestCount().longValue());
  }

  /**
   * Test {@link CacheStat#incrementHit()}.
   *
   * <p>Method under test: {@link CacheStat#incrementHit()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CacheStat.incrementHit()"})
  public void testIncrementHit() {
    // Arrange
    CacheStat cacheStat = new CacheStat();

    // Act
    cacheStat.incrementHit();

    // Assert
    AtomicLong atomicLong = cacheStat.cacheHitCount;
    assertEquals(1L, atomicLong.get());
    assertEquals(1L, atomicLong.getAndDecrement());
    assertEquals(0L, atomicLong.getAndIncrement());
    assertEquals(1L, cacheStat.getCacheHitCount().longValue());
  }

  /**
   * Test {@link CacheStat#getHitRate()}.
   *
   * <ul>
   *   <li>Given {@link CacheStat} (default constructor) incrementRequest.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link CacheStat#getHitRate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal CacheStat.getHitRate()"})
  public void testGetHitRate_givenCacheStatIncrementRequest_thenReturnBigDecimalWith000() {
    // Arrange
    CacheStat cacheStat = new CacheStat();
    cacheStat.incrementRequest();

    // Act
    BigDecimal actualHitRate = cacheStat.getHitRate();

    // Assert
    assertEquals(new BigDecimal("0.00"), actualHitRate);
  }

  /**
   * Test {@link CacheStat#getHitRate()}.
   *
   * <ul>
   *   <li>Given {@link CacheStat} (default constructor).
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code -1}.
   * </ul>
   *
   * <p>Method under test: {@link CacheStat#getHitRate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal CacheStat.getHitRate()"})
  public void testGetHitRate_givenCacheStat_thenReturnBigDecimalWith1() {
    // Arrange and Act
    BigDecimal actualHitRate = new CacheStat().getHitRate();

    // Assert
    assertEquals(new BigDecimal("-1"), actualHitRate);
  }

  /**
   * Test new {@link CacheStat} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link CacheStat}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CacheStat.<init>()"})
  public void testNewCacheStat() {
    // Arrange and Act
    CacheStat actualCacheStat = new CacheStat();

    // Assert
    AtomicLong atomicLong = actualCacheStat.cacheHitCount;
    assertEquals(0L, atomicLong.get());
    assertEquals(0L, atomicLong.getAndDecrement());
    assertEquals(-1L, atomicLong.getAndIncrement());
    AtomicLong atomicLong2 = actualCacheStat.requestCount;
    assertEquals(0L, atomicLong2.get());
    assertEquals(0L, atomicLong2.getAndDecrement());
    assertEquals(-1L, atomicLong2.getAndIncrement());
    assertEquals(0L, actualCacheStat.getCacheHitCount().longValue());
    assertEquals(new BigDecimal("-1"), actualCacheStat.getHitRate());
    assertEquals(0L, actualCacheStat.getRequestCount().longValue());
  }
}
