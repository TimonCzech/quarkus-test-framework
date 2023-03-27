package io.quarkus.qe.database.oracle;

import org.junit.jupiter.api.Test;

import io.quarkus.test.bootstrap.RestService;
import io.quarkus.test.scenarios.QuarkusScenario;
import io.quarkus.test.scenarios.annotations.DisabledOnNative;
import io.quarkus.test.services.DevModeQuarkusApplication;

/**
 * Running Quarkus on DEV mode will spin up a Database instance automatically.
 */
@DisabledOnNative // Don't run DEV mode tests in native: https://github.com/quarkus-qe/quarkus-test-framework/issues/720
@QuarkusScenario
public class DevModeOracleDevServiceDatabaseIT extends AbstractSqlDatabaseIT {

    @DevModeQuarkusApplication
    static RestService app = new RestService();

    @Override
    protected RestService getApp() {
        return app;
    }

    @Test
    public void verifyLogsToAssertDevMode() {
        app.logs().assertContains("Profile DevModeOracleDevServiceDatabaseIT activated. Live Coding activated");
    }
}
