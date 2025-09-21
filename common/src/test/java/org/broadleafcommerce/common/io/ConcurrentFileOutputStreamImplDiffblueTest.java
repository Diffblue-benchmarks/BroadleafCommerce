/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.io;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.nio.file.Paths;
import org.codehaus.groovy.runtime.WritablePath;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConcurrentFileOutputStreamImplDiffblueTest {
  /**
   * Test {@link ConcurrentFileOutputStreamImpl#getFileMoveLock(File)}.
   *
   * <ul>
   *   <li>Given Property is {@code java.io.tmpdir}.
   *   <li>Then calls {@link WritablePath#toFile()}.
   * </ul>
   *
   * <p>Method under test: {@link ConcurrentFileOutputStreamImpl#getFileMoveLock(File)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object ConcurrentFileOutputStreamImpl.getFileMoveLock(File)"})
  public void testGetFileMoveLock_givenPropertyIsJavaIoTmpdir_thenCallsToFile() {
    // Arrange
    ConcurrentFileOutputStreamImpl concurrentFileOutputStreamImpl =
        new ConcurrentFileOutputStreamImpl();
    System.getProperty("java.io.tmpdir");

    WritablePath writablePath = mock(WritablePath.class);
    when(writablePath.toFile())
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    concurrentFileOutputStreamImpl.getFileMoveLock(writablePath.toFile());

    // Assert
    verify(writablePath).toFile();
  }
}
