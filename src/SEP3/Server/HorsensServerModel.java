package SEP3.Server;

import SEP3.Domain.Model.ApartmentList;
import SEP3.Domain.Model.TenantList;

public interface HorsensServerModel {

    TenantList getTenantList();
    ApartmentList getApartmentList();
}
