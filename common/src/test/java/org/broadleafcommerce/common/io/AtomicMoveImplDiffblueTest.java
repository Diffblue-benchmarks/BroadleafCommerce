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
   * Test {@link AtomicMoveImpl#replaceExisting(File, File)}.
   * <ul>
   *   <li>Given Property is {@code java.io.tmpdir}.</li>
   *   <li>Then calls {@link WritablePath#toFile()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AtomicMoveImpl#replaceExisting(File, File)}
   */
  @Test
  public void testReplaceExisting_givenPropertyIsJavaIoTmpdir_thenCallsToFile() throws IOException {
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
   * Test {@link AtomicMoveImpl#getFileMoveLock(File)}.
   * <p>
   * Method under test: {@link AtomicMoveImpl#getFileMoveLock(File)}
   */
  @Test
  public void testGetFileMoveLock() {
    // Arrange
    AtomicMoveImpl atomicMoveImpl = new AtomicMoveImpl();
    System.getProperty("java.io.tmpdir");
    WritablePath writablePath = mock(WritablePath.class);
    when(writablePath.toFile()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile());
    WritablePath writablePath2 = mock(WritablePath.class);
    when(writablePath2.toFile()).thenReturn(writablePath.toFile());
    WritablePath writablePath3 = mock(WritablePath.class);
    when(writablePath3.toFile()).thenReturn(writablePath2.toFile());
    WritablePath writablePath4 = mock(WritablePath.class);
    when(writablePath4.toFile()).thenReturn(writablePath3.toFile());
    WritablePath writablePath5 = mock(WritablePath.class);
    when(writablePath5.toFile()).thenReturn(writablePath4.toFile());
    WritablePath writablePath6 = mock(WritablePath.class);
    when(writablePath6.toFile()).thenReturn(writablePath5.toFile());
    WritablePath writablePath7 = mock(WritablePath.class);
    when(writablePath7.toFile()).thenReturn(writablePath6.toFile());
    WritablePath writablePath8 = mock(WritablePath.class);
    when(writablePath8.toFile()).thenReturn(writablePath7.toFile());
    WritablePath writablePath9 = mock(WritablePath.class);
    when(writablePath9.toFile()).thenReturn(writablePath8.toFile());
    WritablePath writablePath10 = mock(WritablePath.class);
    when(writablePath10.toFile()).thenReturn(writablePath9.toFile());
    WritablePath writablePath11 = mock(WritablePath.class);
    when(writablePath11.toFile()).thenReturn(writablePath10.toFile());
    WritablePath writablePath12 = mock(WritablePath.class);
    when(writablePath12.toFile()).thenReturn(writablePath11.toFile());
    WritablePath writablePath13 = mock(WritablePath.class);
    when(writablePath13.toFile()).thenReturn(writablePath12.toFile());
    WritablePath writablePath14 = mock(WritablePath.class);
    when(writablePath14.toFile()).thenReturn(writablePath13.toFile());
    WritablePath writablePath15 = mock(WritablePath.class);
    when(writablePath15.toFile()).thenReturn(writablePath14.toFile());
    WritablePath writablePath16 = mock(WritablePath.class);
    when(writablePath16.toFile()).thenReturn(writablePath15.toFile());
    WritablePath writablePath17 = mock(WritablePath.class);
    when(writablePath17.toFile()).thenReturn(writablePath16.toFile());
    WritablePath writablePath18 = mock(WritablePath.class);
    when(writablePath18.toFile()).thenReturn(writablePath17.toFile());
    WritablePath writablePath19 = mock(WritablePath.class);
    when(writablePath19.toFile()).thenReturn(writablePath18.toFile());
    System.getProperty("java.io.tmpdir");
    System.getProperty("java.io.tmpdir");
    System.getProperty("java.io.tmpdir");
    System.getProperty("java.io.tmpdir");
    System.getProperty("java.io.tmpdir");
    System.getProperty("java.io.tmpdir");
    System.getProperty("java.io.tmpdir");
    System.getProperty("java.io.tmpdir");
    System.getProperty("java.io.tmpdir");
    System.getProperty("java.io.tmpdir");
    System.getProperty("java.io.tmpdir");
    System.getProperty("java.io.tmpdir");
    System.getProperty("java.io.tmpdir");
    System.getProperty("java.io.tmpdir");
    System.getProperty("java.io.tmpdir");
    System.getProperty("java.io.tmpdir");
    System.getProperty("java.io.tmpdir");
    System.getProperty("java.io.tmpdir");

    // Act
    atomicMoveImpl.getFileMoveLock(writablePath19.toFile());

    // Assert
    verify(writablePath19).toFile();
    verify(writablePath18).toFile();
    verify(writablePath17).toFile();
    verify(writablePath16).toFile();
    verify(writablePath15).toFile();
    verify(writablePath14).toFile();
    verify(writablePath13).toFile();
    verify(writablePath12).toFile();
    verify(writablePath11).toFile();
    verify(writablePath10).toFile();
    verify(writablePath9).toFile();
    verify(writablePath8).toFile();
    verify(writablePath7).toFile();
    verify(writablePath6).toFile();
    verify(writablePath5).toFile();
    verify(writablePath4).toFile();
    verify(writablePath3).toFile();
    verify(writablePath2).toFile();
    verify(writablePath).toFile();
  }

  /**
   * Test {@link AtomicMoveImpl#getFileMoveLock(File)}.
   * <ul>
   *   <li>Given Property is {@code java.io.tmpdir} is array of {@link String} with
   * {@code test.txt} toFile.</li>
   * </ul>
   * <p>
   * Method under test: {@link AtomicMoveImpl#getFileMoveLock(File)}
   */
  @Test
  public void testGetFileMoveLock_givenPropertyIsJavaIoTmpdirIsArrayOfStringWithTestTxtToFile() {
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

  /**
   * Test new {@link AtomicMoveImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AtomicMoveImpl}
   */
  @Test
  public void testNewAtomicMoveImpl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new AtomicMoveImpl();
  }
}
