package org.davidtam;

import com.azure.core.http.rest.PagedIterable;
import com.azure.identity.*;
import com.azure.core.util.Configuration;
import com.azure.core.util.polling.SyncPoller;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.DeletedSecret;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;
import com.azure.security.keyvault.secrets.models.SecretProperties;


public class Main {

    public static void main(String[] args) {

        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "ERROR");

        if (args.length != 4) {
            System.out.println("4 arguments needed:  AKV_URL, clientID, clientSecret, and tenantID");
            System.exit(1);
        }

        String vaultUrl = args[0];

        ClientSecretCredential sp = new ClientSecretCredentialBuilder()
                .clientId(args[1])
                .clientSecret(args[2])
                .tenantId(args[3])
                .build();

        SecretClient client;
        client = new SecretClientBuilder()
                .vaultUrl(vaultUrl)
                .credential(sp)
                .buildClient();

        for (SecretProperties secret : client.listPropertiesOfSecrets()) {
            KeyVaultSecret secretWithValue = client.getSecret(secret.getName(), secret.getVersion());
            System.out.println("[ " + secretWithValue.getName() + " ]");
            System.out.println(secretWithValue.getValue());
            System.out.println("");

        }
    }
}