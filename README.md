# azureKeyVaultTool

Java tool to validate azure keyvault credentials, connect and retrieve secrets.

Build...

$ mvn package

Execute...

$ java -jar davidtam-akvtool-1.0-all.jar

4 arguments needed:  AKV_URL, clientID, clientSecret, and tenantID

Get Service Principal info using az cli (would not reveal client secret)...

$ az ad sp list --output table
The result is not complete. You can still use '--all' to get all of them with long latency expected, or provide a filter through command arguments
DisplayName                                                            Id                                    AppId                                 CreatedDateTime
---------------------------------------------------------------------  ------------------------------------  ------------------------------------  --------------------
7b6e17931aae4b4f985a0000                                               00d11274-0d8f-48d6-8833-c8ffffffffff  0fded36d-bb65-4540-b1f3-9fffffffffff  2023-08-25T03:09:01Z
Application Examples API                                               00083428-9bf5-48d1-b26c-3fffffffffff  f5c26e74-f226-4ae8-85f0-bfffffffffff  2017-12-27T18:34:05Z
