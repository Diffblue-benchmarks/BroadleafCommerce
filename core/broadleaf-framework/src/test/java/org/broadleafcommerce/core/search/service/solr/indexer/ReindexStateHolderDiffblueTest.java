package org.broadleafcommerce.core.search.service.solr.indexer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.Map;
import org.junit.Test;

public class ReindexStateHolderDiffblueTest {
  /**
   * Test {@link ReindexStateHolder#getInstance(String, boolean, boolean)} with
   * {@code collectionName}, {@code incrementalCommits}, {@code createIfAbsent}.
   * <p>
   * Method under test:
   * {@link ReindexStateHolder#getInstance(String, boolean, boolean)}
   */
  @Test
  public void testGetInstanceWithCollectionNameIncrementalCommitsCreateIfAbsent() {
    // Arrange and Act
    ReindexStateHolder actualInstance = ReindexStateHolder.getInstance("Collection Name", true, true);

    // Assert
    assertEquals("Collection Name", actualInstance.getCollectionName());
    Exception failure = actualInstance.getFailure();
    assertEquals("foo", failure.getLocalizedMessage());
    assertEquals("foo", failure.getMessage());
    assertNull(failure.getCause());
    assertEquals(0, failure.getSuppressed().length);
    assertEquals(1L, actualInstance.getLastCommitted());
    assertEquals(669L, actualInstance.getUnindexedItemCount());
    assertEquals(701L, actualInstance.getIndexableCount());
    assertTrue(actualInstance.getAdditionalState().isEmpty());
    assertTrue(actualInstance.isFailed());
    assertTrue(actualInstance.isIncrementalCommits());
  }

  /**
   * Test {@link ReindexStateHolder#getInstance(String)} with
   * {@code collectionName}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReindexStateHolder#getInstance(String)}
   */
  @Test
  public void testGetInstanceWithCollectionName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ReindexStateHolder.getInstance("Collection NameCollection Name"));
  }

  /**
   * Test {@link ReindexStateHolder#getInstance(String)} with
   * {@code collectionName}.
   * <ul>
   *   <li>When {@code Collection Name}.</li>
   *   <li>Then return {@code Collection Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReindexStateHolder#getInstance(String)}
   */
  @Test
  public void testGetInstanceWithCollectionName_whenCollectionName_thenReturnCollectionName() {
    // Arrange and Act
    ReindexStateHolder actualInstance = ReindexStateHolder.getInstance("Collection Name");

    // Assert
    assertEquals("Collection Name", actualInstance.getCollectionName());
    Exception failure = actualInstance.getFailure();
    assertEquals("foo", failure.getLocalizedMessage());
    assertEquals("foo", failure.getMessage());
    assertNull(failure.getCause());
    assertEquals(0, failure.getSuppressed().length);
    assertEquals(1L, actualInstance.getLastCommitted());
    assertEquals(669L, actualInstance.getUnindexedItemCount());
    assertEquals(701L, actualInstance.getIndexableCount());
    assertTrue(actualInstance.getAdditionalState().isEmpty());
    assertTrue(actualInstance.isFailed());
    assertTrue(actualInstance.isIncrementalCommits());
  }

  /**
   * Test {@link ReindexStateHolder#unregister(String)}.
   * <p>
   * Method under test: {@link ReindexStateHolder#unregister(String)}
   */
  @Test
  public void testUnregister() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    ReindexStateHolder.unregister("Collection Name");
  }

  /**
   * Test {@link ReindexStateHolder#isFailed()}.
   * <p>
   * Method under test: {@link ReindexStateHolder#isFailed()}
   */
  @Test
  public void testIsFailed() {
    // Arrange, Act and Assert
    assertTrue(ReindexStateHolder.getInstance("Collection Name", true, true).isFailed());
  }

  /**
   * Test {@link ReindexStateHolder#failFast(Exception)}.
   * <p>
   * Method under test: {@link ReindexStateHolder#failFast(Exception)}
   */
  @Test
  public void testFailFast() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    ReindexStateHolder instance = ReindexStateHolder.getInstance("Collection Name", true, true);

    // Act
    instance.failFast(new Exception("foo"));
  }

  /**
   * Test {@link ReindexStateHolder#getFailure()}.
   * <p>
   * Method under test: {@link ReindexStateHolder#getFailure()}
   */
  @Test
  public void testGetFailure() {
    // Arrange and Act
    Exception actualFailure = ReindexStateHolder.getInstance("Collection Name", true, true).getFailure();

    // Assert
    assertEquals("foo", actualFailure.getLocalizedMessage());
    assertEquals("foo", actualFailure.getMessage());
    assertNull(actualFailure.getCause());
    assertEquals(0, actualFailure.getSuppressed().length);
  }

  /**
   * Test {@link ReindexStateHolder#getIndexableCount()}.
   * <p>
   * Method under test: {@link ReindexStateHolder#getIndexableCount()}
   */
  @Test
  public void testGetIndexableCount() {
    // Arrange, Act and Assert
    assertEquals(187L, ReindexStateHolder.getInstance("Collection Name", true, true).getIndexableCount());
  }

  /**
   * Test {@link ReindexStateHolder#incrementIndexableCount(long)}.
   * <p>
   * Method under test: {@link ReindexStateHolder#incrementIndexableCount(long)}
   */
  @Test
  public void testIncrementIndexableCount() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    ReindexStateHolder.getInstance("Collection Name", true, true).incrementIndexableCount(2L);
  }

  /**
   * Test {@link ReindexStateHolder#getUnindexedItemCount()}.
   * <p>
   * Method under test: {@link ReindexStateHolder#getUnindexedItemCount()}
   */
  @Test
  public void testGetUnindexedItemCount() {
    // Arrange, Act and Assert
    assertEquals(199L, ReindexStateHolder.getInstance("Collection Name", true, true).getUnindexedItemCount());
  }

  /**
   * Test {@link ReindexStateHolder#incrementUnindexedItemCount(long)}.
   * <p>
   * Method under test:
   * {@link ReindexStateHolder#incrementUnindexedItemCount(long)}
   */
  @Test
  public void testIncrementUnindexedItemCount() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    ReindexStateHolder.getInstance("Collection Name", true, true).incrementUnindexedItemCount(2L);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReindexStateHolder#getAdditionalState()}
   *   <li>{@link ReindexStateHolder#getCollectionName()}
   *   <li>{@link ReindexStateHolder#isIncrementalCommits()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ReindexStateHolder instance = ReindexStateHolder.getInstance("Collection Name", true, true);

    // Act
    Map<String, Object> actualAdditionalState = instance.getAdditionalState();
    String actualCollectionName = instance.getCollectionName();
    boolean actualIsIncrementalCommitsResult = instance.isIncrementalCommits();

    // Assert
    assertEquals("Collection Name", actualCollectionName);
    assertTrue(actualAdditionalState.isEmpty());
    assertTrue(actualIsIncrementalCommitsResult);
  }

  /**
   * Test {@link ReindexStateHolder#getLastCommitted()}.
   * <p>
   * Method under test: {@link ReindexStateHolder#getLastCommitted()}
   */
  @Test
  public void testGetLastCommitted() {
    // Arrange, Act and Assert
    assertEquals(0L, ReindexStateHolder.getInstance("Collection Name", true, true).getLastCommitted());
  }

  /**
   * Test {@link ReindexStateHolder#setLastCommitted(long)}.
   * <p>
   * Method under test: {@link ReindexStateHolder#setLastCommitted(long)}
   */
  @Test
  public void testSetLastCommitted() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    ReindexStateHolder.getInstance("Collection Name", true, true).setLastCommitted(1L);
  }
}
