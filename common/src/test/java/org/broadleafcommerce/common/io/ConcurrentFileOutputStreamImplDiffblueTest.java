/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.io;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import org.codehaus.groovy.runtime.WritablePath;
import org.junit.Test;

public class ConcurrentFileOutputStreamImplDiffblueTest {
  /**
   * Test {@link ConcurrentFileOutputStreamImpl#replaceExisting(File, File)}.
   * <ul>
   *   <li>Given Property is {@code java.io.tmpdir}.</li>
   *   <li>Then calls {@link WritablePath#toFile()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConcurrentFileOutputStreamImpl#replaceExisting(File, File)}
   */
  @Test
  public void testReplaceExisting_givenPropertyIsJavaIoTmpdir_thenCallsToFile() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ConcurrentFileOutputStreamImpl concurrentFileOutputStreamImpl = new ConcurrentFileOutputStreamImpl();
    System.getProperty("java.io.tmpdir");
    WritablePath writablePath = mock(WritablePath.class);
    when(writablePath.toFile()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    File src = writablePath.toFile();

    // Act
    concurrentFileOutputStreamImpl.replaceExisting(src,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Assert that nothing has changed
    verify(writablePath).toFile();
  }

  /**
   * Test {@link ConcurrentFileOutputStreamImpl#getFileMoveLock(File)}.
   * <ul>
   *   <li>Given Property is {@code java.io.tmpdir}.</li>
   *   <li>Then calls {@link WritablePath#toFile()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConcurrentFileOutputStreamImpl#getFileMoveLock(File)}
   */
  @Test
  public void testGetFileMoveLock_givenPropertyIsJavaIoTmpdir_thenCallsToFile() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ConcurrentFileOutputStreamImpl concurrentFileOutputStreamImpl = new ConcurrentFileOutputStreamImpl();
    System.getProperty("java.io.tmpdir");
    WritablePath writablePath = mock(WritablePath.class);
    when(writablePath.toFile()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    concurrentFileOutputStreamImpl.getFileMoveLock(writablePath.toFile());

    // Assert
    verify(writablePath).toFile();
  }
}
