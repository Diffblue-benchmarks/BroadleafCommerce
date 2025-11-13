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
import org.hibernate.dialect.identity.MySQLIdentityColumnSupport;
import org.hibernate.dialect.unique.MySQLUniqueDelegate;
import org.hibernate.engine.jdbc.env.internal.DefaultSchemaNameResolver;
import org.hibernate.hql.spi.id.local.LocalTemporaryTableBulkIdStrategy;
import org.hibernate.id.IdentityGenerator;
import org.hibernate.procedure.internal.StandardCallableStatementSupport;
import org.hibernate.tool.schema.extract.internal.SequenceInformationExtractorNoOpImpl;
import org.hibernate.tool.schema.internal.StandardAuxiliaryDatabaseObjectExporter;
import org.hibernate.tool.schema.internal.StandardForeignKeyExporter;
import org.hibernate.tool.schema.internal.StandardIndexExporter;
import org.hibernate.tool.schema.internal.StandardSequenceExporter;
import org.hibernate.tool.schema.internal.StandardTableExporter;
import org.hibernate.tool.schema.internal.StandardUniqueKeyExporter;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Broadleaf2CompatibilityMySQL5InnoDBDialectDiffblueTest {
  /**
   * Test new {@link Broadleaf2CompatibilityMySQL5InnoDBDialect} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * Broadleaf2CompatibilityMySQL5InnoDBDialect}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Broadleaf2CompatibilityMySQL5InnoDBDialect.<init>()"})
  public void testNewBroadleaf2CompatibilityMySQL5InnoDBDialect() {
    // Arrange and Act
    Broadleaf2CompatibilityMySQL5InnoDBDialect actualBroadleaf2CompatibilityMySQL5InnoDBDialect =
        new Broadleaf2CompatibilityMySQL5InnoDBDialect();

    // Assert
    assertTrue(
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getIdentityColumnSupport()
            instanceof MySQLIdentityColumnSupport);
    assertTrue(
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getUniqueDelegate()
            instanceof MySQLUniqueDelegate);
    assertTrue(
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getSchemaNameResolver()
            instanceof DefaultSchemaNameResolver);
    assertTrue(
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getDefaultMultiTableBulkIdStrategy()
            instanceof LocalTemporaryTableBulkIdStrategy);
    assertTrue(
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getCallableStatementSupport()
            instanceof StandardCallableStatementSupport);
    assertTrue(
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getSequenceInformationExtractor()
            instanceof SequenceInformationExtractorNoOpImpl);
    assertTrue(
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getAuxiliaryDatabaseObjectExporter()
            instanceof StandardAuxiliaryDatabaseObjectExporter);
    assertTrue(
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getForeignKeyExporter()
            instanceof StandardForeignKeyExporter);
    assertTrue(
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getIndexExporter()
            instanceof StandardIndexExporter);
    assertTrue(
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getSequenceExporter()
            instanceof StandardSequenceExporter);
    assertTrue(
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getTableExporter()
            instanceof StandardTableExporter);
    assertTrue(
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getUniqueKeyExporter()
            instanceof StandardUniqueKeyExporter);
    assertEquals(
        " cross join ", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getCrossJoinSeparator());
    assertEquals(
        " drop foreign key ",
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getDropForeignKeyString());
    assertEquals(
        " engine=InnoDB", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getTableTypeString());
    assertEquals(
        " for update", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getForUpdateNowaitString());
    assertEquals(
        " for update",
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getForUpdateSkipLockedString());
    assertEquals(
        " for update", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getForUpdateString());
    assertEquals("", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getAddColumnSuffixString());
    assertEquals(
        "", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getCascadeConstraintsString());
    assertEquals("", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getNullColumnString());
    assertEquals(
        "add column", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getAddColumnString());
    assertEquals(
        "create table",
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getCreateMultisetTableString());
    assertEquals(
        "create table", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getCreateTableString());
    assertEquals(
        "current_timestamp",
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getCurrentTimestampSQLFunctionName());
    assertEquals(
        "identity",
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getNativeIdentifierGeneratorStrategy());
    assertEquals("like", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getCaseInsensitiveLike());
    assertEquals("lower", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getLowercaseFunction());
    assertEquals(
        "select now()",
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getCurrentTimestampSelectString());
    assertEquals(
        "select uuid()", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getSelectGUIDString());
    assertEquals(
        "values ( )", actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getNoColumnsInsertString());
    assertNull(actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getCurrentSchemaCommand());
    assertNull(actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getQuerySequencesString());
    assertNull(actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getNameQualifierSupport());
    assertEquals(0, actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getInExpressionCountLimit());
    assertEquals(10, actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getMaxAliasLength());
    Map<String, SQLFunction> functions =
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getFunctions();
    assertEquals(108, functions.size());
    Properties defaultProperties =
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getDefaultProperties();
    assertEquals(2, defaultProperties.size());
    assertFalse(
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.isLegacyLimitHandlerBehaviorEnabled());
    assertFalse(actualBroadleaf2CompatibilityMySQL5InnoDBDialect.isLockTimeoutParameterized());
    assertFalse(
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.isCurrentTimestampSelectStringCallable());
    assertFalse(
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.isJdbcLogWarningsEnabledByDefault());
    assertTrue(defaultProperties.containsKey("hibernate.jdbc.batch_size"));
    assertTrue(defaultProperties.containsKey("hibernate.max_fetch_depth"));
    assertTrue(functions.containsKey("bin"));
    assertTrue(functions.containsKey("character_length"));
    assertTrue(functions.containsKey("mod"));
    assertTrue(functions.containsKey("upper"));
    assertTrue(functions.containsKey("weekday"));
    assertTrue(functions.containsKey("year"));
    assertTrue(actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getKeywords().isEmpty());
    assertTrue(actualBroadleaf2CompatibilityMySQL5InnoDBDialect.hasAlterTable());
    assertTrue(actualBroadleaf2CompatibilityMySQL5InnoDBDialect.hasSelfReferentialForeignKeyBug());
    Class<IdentityGenerator> expectedNativeIdentifierGeneratorClass = IdentityGenerator.class;
    assertEquals(
        expectedNativeIdentifierGeneratorClass,
        actualBroadleaf2CompatibilityMySQL5InnoDBDialect.getNativeIdentifierGeneratorClass());
  }
}
