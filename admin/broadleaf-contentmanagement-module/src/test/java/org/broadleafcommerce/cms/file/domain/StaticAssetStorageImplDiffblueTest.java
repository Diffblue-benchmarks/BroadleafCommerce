package org.broadleafcommerce.cms.file.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;
import javax.sql.rowset.serial.SerialBlob;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StaticAssetStorageImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticAssetStorageImpl.<init>()",
    "Blob StaticAssetStorageImpl.getFileData()",
    "Long StaticAssetStorageImpl.getId()",
    "Long StaticAssetStorageImpl.getStaticAssetId()",
    "void StaticAssetStorageImpl.setFileData(Blob)",
    "void StaticAssetStorageImpl.setId(Long)",
    "void StaticAssetStorageImpl.setStaticAssetId(Long)"
  })
  public void testGettersAndSetters() throws UnsupportedEncodingException, SQLException {
    // Arrange and Act
    StaticAssetStorageImpl actualStaticAssetStorageImpl = new StaticAssetStorageImpl();
    SerialBlob fileData = new SerialBlob("AXAXAXAX".getBytes("UTF-8"));
    actualStaticAssetStorageImpl.setFileData(fileData);
    actualStaticAssetStorageImpl.setId(1L);
    actualStaticAssetStorageImpl.setStaticAssetId(1L);
    Blob actualFileData = actualStaticAssetStorageImpl.getFileData();
    Long actualId = actualStaticAssetStorageImpl.getId();
    Long actualStaticAssetId = actualStaticAssetStorageImpl.getStaticAssetId();

    // Assert
    assertEquals(1L, actualId.longValue());
    assertEquals(1L, actualStaticAssetId.longValue());
    assertSame(fileData, actualFileData);
  }
}
