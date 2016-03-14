/*
===============================================================
   _____                       ______
  / ___/____ _____ ___  ____ _/ ____/___ _____ ___  ___  _____
  \__ \/ __ `/ __ `__ \/ __ `/ / __/ __ `/ __ `__ \/ _ \/ ___/
 ___/ / /_/ / / / / / / /_/ / /_/ / /_/ / / / / / /  __(__  )
/____/\__,_/_/ /_/ /_/\__,_/\____/\__,_/_/ /_/ /_/\___/____/

===============================================================
  Persistance API
  Copyright (c) for SamaGames, all right reserved
  By MisterSatch, January 2016
===============================================================
*/

package net.samagames.persistanceapi.tests;

import net.samagames.persistanceapi.beans.permissions.APIPermissionsBean;

public class Introspection
{
    public static void main (String[] args)
    {
        APIPermissionsBean bean = new APIPermissionsBean(1, true, false, true, false, true, false, true, false, true, false, true, false, true, false);
        bean.getHashMap();
    }
}

