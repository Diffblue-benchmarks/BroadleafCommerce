package org.broadleafcommerce.openadmin.server.dao.provider.metadata;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PasswordFieldMetadataProviderDiffblueTest {
  /**
   * Test {@link PasswordFieldMetadataProvider#getOrder()}.
   * <p>
   * Method under test: {@link PasswordFieldMetadataProvider#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(FieldMetadataProvider.BASIC, (new PasswordFieldMetadataProvider()).getOrder());
  }
}
