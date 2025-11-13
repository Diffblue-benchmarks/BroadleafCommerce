package org.broadleafcommerce.openadmin.server.service.artifact;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.openadmin.server.service.artifact.image.Operation;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.UnmarshalledParameter;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-open-admin-contentClient-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ArtifactServiceImplDiffblueTest {
  @MockBean private ArtifactProcessor artifactProcessor;

  @Autowired private ArtifactServiceImpl artifactServiceImpl;

  @Autowired private List<ArtifactProcessor> list;

  /**
   * Test {@link ArtifactServiceImpl#convert(InputStream, Operation[], String)}.
   *
   * <ul>
   *   <li>Given {@link ArtifactProcessor} {@link ArtifactProcessor#convert(InputStream,
   *       Operation[], String)} throw {@link Exception#Exception()}.
   *   <li>Then throw {@link Exception}.
   * </ul>
   *
   * <p>Method under test: {@link ArtifactServiceImpl#convert(InputStream, Operation[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"InputStream ArtifactServiceImpl.convert(InputStream, Operation[], String)"})
  public void testConvert_givenArtifactProcessorConvertThrowException_thenThrowException()
      throws Exception {
    // Arrange
    when(artifactProcessor.convert(
            Mockito.<InputStream>any(), Mockito.<Operation[]>any(), Mockito.<String>any()))
        .thenThrow(new Exception());
    when(artifactProcessor.isSupported(Mockito.<InputStream>any(), Mockito.<String>any()))
        .thenReturn(true);
    ByteArrayInputStream artifactStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    UnmarshalledParameter unmarshalledParameter = new UnmarshalledParameter();
    unmarshalledParameter.setApplyFactor(true);
    unmarshalledParameter.setName("Name");
    unmarshalledParameter.setType("Type");
    unmarshalledParameter.setValue("42");

    Operation operation = new Operation();
    operation.setFactor(10.0d);
    operation.setName("Name");
    operation.setParameters(new UnmarshalledParameter[] {unmarshalledParameter});

    // Act and Assert
    assertThrows(
        Exception.class,
        () ->
            artifactServiceImpl.convert(artifactStream, new Operation[] {operation}, "text/plain"));
    verify(artifactProcessor)
        .convert(isA(InputStream.class), isA(Operation[].class), eq("text/plain"));
    verify(artifactProcessor).isSupported(isA(InputStream.class), eq("text/plain"));
  }

  /**
   * Test {@link ArtifactServiceImpl#convert(InputStream, Operation[], String)}.
   *
   * <ul>
   *   <li>Then {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8} read is eight.
   * </ul>
   *
   * <p>Method under test: {@link ArtifactServiceImpl#convert(InputStream, Operation[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"InputStream ArtifactServiceImpl.convert(InputStream, Operation[], String)"})
  public void testConvert_thenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8ReadIsEight()
      throws Exception {
    // Arrange
    when(artifactProcessor.convert(
            Mockito.<InputStream>any(), Mockito.<Operation[]>any(), Mockito.<String>any()))
        .thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(artifactProcessor.isSupported(Mockito.<InputStream>any(), Mockito.<String>any()))
        .thenReturn(true);
    ByteArrayInputStream artifactStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    UnmarshalledParameter unmarshalledParameter = new UnmarshalledParameter();
    unmarshalledParameter.setApplyFactor(true);
    unmarshalledParameter.setName("Name");
    unmarshalledParameter.setType("Type");
    unmarshalledParameter.setValue("42");

    Operation operation = new Operation();
    operation.setFactor(10.0d);
    operation.setName("Name");
    operation.setParameters(new UnmarshalledParameter[] {unmarshalledParameter});

    // Act
    InputStream actualConvertResult =
        artifactServiceImpl.convert(artifactStream, new Operation[] {operation}, "text/plain");

    // Assert
    verify(artifactProcessor)
        .convert(isA(InputStream.class), isA(Operation[].class), eq("text/plain"));
    verify(artifactProcessor).isSupported(isA(InputStream.class), eq("text/plain"));
    byte[] byteArray = new byte[8];
    assertEquals(8, artifactStream.read(byteArray));
    byte[] byteArray2 = new byte[8];
    assertEquals(8, actualConvertResult.read(byteArray2));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ArtifactServiceImpl#convert(InputStream, Operation[], String)}.
   *
   * <ul>
   *   <li>Then {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8} read is minus one.
   * </ul>
   *
   * <p>Method under test: {@link ArtifactServiceImpl#convert(InputStream, Operation[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"InputStream ArtifactServiceImpl.convert(InputStream, Operation[], String)"})
  public void testConvert_thenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8ReadIsMinusOne()
      throws Exception {
    // Arrange
    when(artifactProcessor.isSupported(Mockito.<InputStream>any(), Mockito.<String>any()))
        .thenReturn(false);
    ByteArrayInputStream artifactStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    Operation operation = new Operation();
    operation.setFactor(10.0d);
    operation.setName("Name");

    UnmarshalledParameter unmarshalledParameter = new UnmarshalledParameter();
    unmarshalledParameter.setApplyFactor(true);
    unmarshalledParameter.setName("Name");
    unmarshalledParameter.setType("Type");
    unmarshalledParameter.setValue("42");
    operation.setParameters(new UnmarshalledParameter[] {unmarshalledParameter});

    // Act and Assert
    byte[] byteArray = new byte[8];
    int actualReadResult =
        artifactServiceImpl
            .convert(artifactStream, new Operation[] {operation}, "text/plain")
            .read(byteArray);
    verify(artifactProcessor).isSupported(isA(InputStream.class), eq("text/plain"));
    int actualReadResult2 = artifactStream.read(new byte[] {});
    assertEquals(-1, actualReadResult2);
    assertEquals(8, actualReadResult);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ArtifactServiceImpl#buildOperations(Map, InputStream, String)}.
   *
   * <ul>
   *   <li>Given {@link ArtifactProcessor} {@link ArtifactProcessor#isSupported(InputStream,
   *       String)} return {@code false}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ArtifactServiceImpl#buildOperations(Map, InputStream, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation[] ArtifactServiceImpl.buildOperations(Map, InputStream, String)"})
  public void testBuildOperations_givenArtifactProcessorIsSupportedReturnFalse_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    when(artifactProcessor.isSupported(Mockito.<InputStream>any(), Mockito.<String>any()))
        .thenReturn(false);
    HashMap<String, String> parameterMap = new HashMap<>();

    // Act
    Operation[] actualBuildOperationsResult =
        artifactServiceImpl.buildOperations(
            parameterMap, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "text/plain");

    // Assert
    verify(artifactProcessor).isSupported(isA(InputStream.class), eq("text/plain"));
    assertNull(actualBuildOperationsResult);
  }

  /**
   * Test {@link ArtifactServiceImpl#buildOperations(Map, InputStream, String)}.
   *
   * <ul>
   *   <li>Then return array length is one.
   * </ul>
   *
   * <p>Method under test: {@link ArtifactServiceImpl#buildOperations(Map, InputStream, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation[] ArtifactServiceImpl.buildOperations(Map, InputStream, String)"})
  public void testBuildOperations_thenReturnArrayLengthIsOne() throws UnsupportedEncodingException {
    // Arrange
    UnmarshalledParameter unmarshalledParameter = new UnmarshalledParameter();
    unmarshalledParameter.setApplyFactor(true);
    unmarshalledParameter.setName("Name");
    unmarshalledParameter.setType("Type");
    unmarshalledParameter.setValue("42");

    Operation operation = new Operation();
    operation.setFactor(10.0d);
    operation.setName("Name");
    operation.setParameters(new UnmarshalledParameter[] {unmarshalledParameter});
    when(artifactProcessor.buildOperations(
            Mockito.<Map<String, String>>any(), Mockito.<InputStream>any(), Mockito.<String>any()))
        .thenReturn(new Operation[] {operation});
    when(artifactProcessor.isSupported(Mockito.<InputStream>any(), Mockito.<String>any()))
        .thenReturn(true);
    HashMap<String, String> parameterMap = new HashMap<>();

    // Act
    Operation[] actualBuildOperationsResult =
        artifactServiceImpl.buildOperations(
            parameterMap, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "text/plain");

    // Assert
    verify(artifactProcessor)
        .buildOperations(isA(Map.class), isA(InputStream.class), eq("text/plain"));
    verify(artifactProcessor).isSupported(isA(InputStream.class), eq("text/plain"));
    assertEquals(1, actualBuildOperationsResult.length);
    assertSame(operation, actualBuildOperationsResult[0]);
  }
}
