package SEP3.Client;

import SEP3.Domain.Model.TenantList;

import java.io.IOException;

public interface ClientModel {

    TenantList receiveTenantList() throws IOException;
}
