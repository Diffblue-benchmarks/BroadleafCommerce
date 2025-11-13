package org.broadleafcommerce.cms.file.dao;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.SQLException;
import javax.sql.rowset.serial.SerialBlob;
import org.broadleafcommerce.cms.file.domain.StaticAssetStorage;
import org.broadleafcommerce.cms.file.domain.StaticAssetStorageImpl;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StaticAssetStorageDaoImplDiffblueTest {
  @Mock private EntityConfiguration entityConfiguration;

  @InjectMocks private StaticAssetStorageDaoImpl staticAssetStorageDaoImpl;

  /**
   * Test {@link StaticAssetStorageDaoImpl#create()}.
   *
   * <p>Method under test: {@link StaticAssetStorageDaoImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StaticAssetStorage StaticAssetStorageDaoImpl.create()"})
  public void testCreate() throws SQLException {
    // Arrange
    StaticAssetStorageImpl staticAssetStorageImpl = new StaticAssetStorageImpl();
    SerialBlob fileData = new SerialBlob(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    staticAssetStorageImpl.setFileData(fileData);
    staticAssetStorageImpl.setId(1L);
    staticAssetStorageImpl.setStaticAssetId(1L);
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenReturn(staticAssetStorageImpl);

    // Act
    StaticAssetStorage actualCreateResult = staticAssetStorageDaoImpl.create();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.cms.file.domain.StaticAssetStorage");
    assertSame(staticAssetStorageImpl, actualCreateResult);
  }
}
