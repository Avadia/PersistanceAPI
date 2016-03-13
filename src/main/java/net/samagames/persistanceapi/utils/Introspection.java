package net.samagames.persistanceapi.utils;

import net.samagames.persistanceapi.beans.permissions.APIPermissionsBean;

/**
 * Created by Jacky on 13/03/2016.
 */
public class Introspection
{
    public static void main (String[] args)
    {
        APIPermissionsBean bean = new APIPermissionsBean(1, true, false, true, false, true, false, true, false, true, false, true, false, true, false);
        bean.getHashMapPromotions();
    }
}
