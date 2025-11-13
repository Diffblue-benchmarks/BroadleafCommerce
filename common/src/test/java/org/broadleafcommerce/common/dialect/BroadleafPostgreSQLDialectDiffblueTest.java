package org.broadleafcommerce.common.dialect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import java.util.Properties;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.dialect.identity.PostgreSQL81IdentityColumnSupport;
import org.hibernate.dialect.unique.DefaultUniqueDelegate;
import org.hibernate.engine.jdbc.env.internal.DefaultSchemaNameResolver;
import org.hibernate.hql.spi.id.local.LocalTemporaryTableBulkIdStrategy;
import org.hibernate.id.IdentityGenerator;
import org.hibernate.procedure.internal.PostgresCallableStatementSupport;
import org.hibernate.tool.schema.extract.internal.SequenceInformationExtractorLegacyImpl;
import org.hibernate.tool.schema.internal.StandardAuxiliaryDatabaseObjectExporter;
import org.hibernate.tool.schema.internal.StandardForeignKeyExporter;
import org.hibernate.tool.schema.internal.StandardIndexExporter;
import org.hibernate.tool.schema.internal.StandardSequenceExporter;
import org.hibernate.tool.schema.internal.StandardTableExporter;
import org.hibernate.tool.schema.internal.StandardUniqueKeyExporter;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BroadleafPostgreSQLDialectDiffblueTest {
  /**
   * Test {@link BroadleafPostgreSQLDialect#getSqlTypeDescriptorOverride(int)}.
   *
   * <ul>
   *   <li>When {@code 2005}.
   *   <li>Then return {@link PostgreSQLClobTypeDescriptor}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafPostgreSQLDialect#getSqlTypeDescriptorOverride(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SqlTypeDescriptor BroadleafPostgreSQLDialect.getSqlTypeDescriptorOverride(int)"
  })
  public void testGetSqlTypeDescriptorOverride_when2005_thenReturnPostgreSQLClobTypeDescriptor() {
    // Arrange and Act
    SqlTypeDescriptor actualSqlTypeDescriptorOverride =
        new BroadleafPostgreSQLDialect().getSqlTypeDescriptorOverride(2005);

    // Assert
    assertTrue(actualSqlTypeDescriptorOverride instanceof PostgreSQLClobTypeDescriptor);
    assertEquals(2005, actualSqlTypeDescriptorOverride.getSqlType());
  }

  /**
   * Test {@link BroadleafPostgreSQLDialect#getSqlTypeDescriptorOverride(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafPostgreSQLDialect#getSqlTypeDescriptorOverride(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SqlTypeDescriptor BroadleafPostgreSQLDialect.getSqlTypeDescriptorOverride(int)"
  })
  public void testGetSqlTypeDescriptorOverride_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new BroadleafPostgreSQLDialect().getSqlTypeDescriptorOverride(1));
  }

  /**
   * Test new {@link BroadleafPostgreSQLDialect} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * BroadleafPostgreSQLDialect}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafPostgreSQLDialect.<init>()"})
  public void testNewBroadleafPostgreSQLDialect() {
    // Arrange and Act
    BroadleafPostgreSQLDialect actualBroadleafPostgreSQLDialect = new BroadleafPostgreSQLDialect();

    // Assert
    assertTrue(
        actualBroadleafPostgreSQLDialect.getIdentityColumnSupport()
            instanceof PostgreSQL81IdentityColumnSupport);
    assertTrue(
        actualBroadleafPostgreSQLDialect.getUniqueDelegate() instanceof DefaultUniqueDelegate);
    assertTrue(
        actualBroadleafPostgreSQLDialect.getSchemaNameResolver()
            instanceof DefaultSchemaNameResolver);
    assertTrue(
        actualBroadleafPostgreSQLDialect.getDefaultMultiTableBulkIdStrategy()
            instanceof LocalTemporaryTableBulkIdStrategy);
    assertTrue(
        actualBroadleafPostgreSQLDialect.getCallableStatementSupport()
            instanceof PostgresCallableStatementSupport);
    assertTrue(
        actualBroadleafPostgreSQLDialect.getSequenceInformationExtractor()
            instanceof SequenceInformationExtractorLegacyImpl);
    assertTrue(
        actualBroadleafPostgreSQLDialect.getAuxiliaryDatabaseObjectExporter()
            instanceof StandardAuxiliaryDatabaseObjectExporter);
    assertTrue(
        actualBroadleafPostgreSQLDialect.getForeignKeyExporter()
            instanceof StandardForeignKeyExporter);
    assertTrue(
        actualBroadleafPostgreSQLDialect.getIndexExporter() instanceof StandardIndexExporter);
    assertTrue(
        actualBroadleafPostgreSQLDialect.getSequenceExporter() instanceof StandardSequenceExporter);
    assertTrue(
        actualBroadleafPostgreSQLDialect.getTableExporter() instanceof StandardTableExporter);
    assertTrue(
        actualBroadleafPostgreSQLDialect.getUniqueKeyExporter()
            instanceof StandardUniqueKeyExporter);
    assertEquals(" cascade", actualBroadleafPostgreSQLDialect.getCascadeConstraintsString());
    assertEquals(" cross join ", actualBroadleafPostgreSQLDialect.getCrossJoinSeparator());
    assertEquals(" drop constraint ", actualBroadleafPostgreSQLDialect.getDropForeignKeyString());
    assertEquals(
        " for update nowait ", actualBroadleafPostgreSQLDialect.getForUpdateNowaitString());
    assertEquals(
        " for update skip locked", actualBroadleafPostgreSQLDialect.getForUpdateSkipLockedString());
    assertEquals(" for update", actualBroadleafPostgreSQLDialect.getForUpdateString());
    assertEquals("", actualBroadleafPostgreSQLDialect.getAddColumnSuffixString());
    assertEquals("", actualBroadleafPostgreSQLDialect.getNullColumnString());
    assertEquals("", actualBroadleafPostgreSQLDialect.getTableTypeString());
    assertEquals("add column", actualBroadleafPostgreSQLDialect.getAddColumnString());
    assertEquals("create table", actualBroadleafPostgreSQLDialect.getCreateMultisetTableString());
    assertEquals("create table", actualBroadleafPostgreSQLDialect.getCreateTableString());
    assertEquals(
        "current_timestamp", actualBroadleafPostgreSQLDialect.getCurrentTimestampSQLFunctionName());
    assertEquals("default values", actualBroadleafPostgreSQLDialect.getNoColumnsInsertString());
    assertEquals("ilike", actualBroadleafPostgreSQLDialect.getCaseInsensitiveLike());
    assertEquals("lower", actualBroadleafPostgreSQLDialect.getLowercaseFunction());
    assertEquals(
        "select * from information_schema.sequences",
        actualBroadleafPostgreSQLDialect.getQuerySequencesString());
    assertEquals(
        "select now()", actualBroadleafPostgreSQLDialect.getCurrentTimestampSelectString());
    assertEquals(
        "sequence", actualBroadleafPostgreSQLDialect.getNativeIdentifierGeneratorStrategy());
    assertNull(actualBroadleafPostgreSQLDialect.getCurrentSchemaCommand());
    assertNull(actualBroadleafPostgreSQLDialect.getNameQualifierSupport());
    assertEquals(0, actualBroadleafPostgreSQLDialect.getInExpressionCountLimit());
    assertEquals(1, actualBroadleafPostgreSQLDialect.getKeywords().size());
    assertEquals(10, actualBroadleafPostgreSQLDialect.getMaxAliasLength());
    Properties defaultProperties = actualBroadleafPostgreSQLDialect.getDefaultProperties();
    assertEquals(2, defaultProperties.size());
    Map<String, SQLFunction> functions = actualBroadleafPostgreSQLDialect.getFunctions();
    assertEquals(82, functions.size());
    assertFalse(actualBroadleafPostgreSQLDialect.hasSelfReferentialForeignKeyBug());
    assertFalse(actualBroadleafPostgreSQLDialect.isLegacyLimitHandlerBehaviorEnabled());
    assertFalse(actualBroadleafPostgreSQLDialect.isLockTimeoutParameterized());
    assertFalse(actualBroadleafPostgreSQLDialect.isCurrentTimestampSelectStringCallable());
    assertTrue(defaultProperties.containsKey("hibernate.jdbc.batch_size"));
    assertTrue(defaultProperties.containsKey("hibernate.jdbc.lob.non_contextual_creation"));
    assertTrue(functions.containsKey("cos"));
    assertTrue(functions.containsKey("ln"));
    assertTrue(functions.containsKey("localtime"));
    assertTrue(functions.containsKey("make_time"));
    assertTrue(functions.containsKey("mod"));
    assertTrue(functions.containsKey("year"));
    assertTrue(actualBroadleafPostgreSQLDialect.hasAlterTable());
    assertTrue(actualBroadleafPostgreSQLDialect.isJdbcLogWarningsEnabledByDefault());
    Class<IdentityGenerator> expectedNativeIdentifierGeneratorClass = IdentityGenerator.class;
    assertEquals(
        expectedNativeIdentifierGeneratorClass,
        actualBroadleafPostgreSQLDialect.getNativeIdentifierGeneratorClass());
  }
}
