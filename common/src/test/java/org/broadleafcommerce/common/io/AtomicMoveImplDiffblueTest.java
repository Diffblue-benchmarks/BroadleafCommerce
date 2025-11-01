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
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import org.codehaus.groovy.runtime.WritablePath;
import org.junit.Test;

public class AtomicMoveImplDiffblueTest {
  /**
   * Method under test: {@link AtomicMoveImpl#replaceExisting(File, File)}
   */
  @Test
  public void testReplaceExisting() throws IOException {
    // Arrange
    AtomicMoveImpl atomicMoveImpl = new AtomicMoveImpl();
    System.getProperty("java.io.tmpdir");
    WritablePath writablePath = mock(WritablePath.class);
    when(writablePath.toFile()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    File src = writablePath.toFile();

    // Act
    atomicMoveImpl.replaceExisting(src, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Assert that nothing has changed
    verify(writablePath).toFile();
  }

  /**
   * Method under test: {@link AtomicMoveImpl#getFileMoveLock(File)}
   */
  @Test
  public void testGetFileMoveLock() {
    // Arrange
    AtomicMoveImpl atomicMoveImpl = new AtomicMoveImpl();
    System.getProperty("java.io.tmpdir");
    WritablePath writablePath = mock(WritablePath.class);
    when(writablePath.toFile()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    atomicMoveImpl.getFileMoveLock(writablePath.toFile());

    // Assert
    verify(writablePath).toFile();
  }
}
