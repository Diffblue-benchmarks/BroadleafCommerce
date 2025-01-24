package org.broadleafcommerce.cms.file.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import java.sql.Blob;
import org.junit.Test;

public class StaticAssetStorageImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link StaticAssetStorageImpl}
   *   <li>{@link StaticAssetStorageImpl#setFileData(Blob)}
   *   <li>{@link StaticAssetStorageImpl#setId(Long)}
   *   <li>{@link StaticAssetStorageImpl#setStaticAssetId(Long)}
   *   <li>{@link StaticAssetStorageImpl#getFileData()}
   *   <li>{@link StaticAssetStorageImpl#getId()}
   *   <li>{@link StaticAssetStorageImpl#getStaticAssetId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    StaticAssetStorageImpl actualStaticAssetStorageImpl = new StaticAssetStorageImpl();
    Blob fileData = mock(Blob.class);
    actualStaticAssetStorageImpl.setFileData(fileData);
    actualStaticAssetStorageImpl.setId(1L);
    actualStaticAssetStorageImpl.setStaticAssetId(1L);
    Blob actualFileData = actualStaticAssetStorageImpl.getFileData();
    Long actualId = actualStaticAssetStorageImpl.getId();
    Long actualStaticAssetId = actualStaticAssetStorageImpl.getStaticAssetId();

    // Assert that nothing has changed
    assertEquals(1L, actualId.longValue());
    assertEquals(1L, actualStaticAssetId.longValue());
    assertSame(fileData, actualFileData);
  }
}
