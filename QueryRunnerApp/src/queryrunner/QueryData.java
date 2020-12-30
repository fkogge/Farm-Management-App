/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queryrunner;

import java.util.ArrayList;

/**
 *
 * @author mckeem
 */
public class QueryData {

    QueryData(String query, String[] parms, boolean [] likeparms, boolean isAction, boolean isParm, String name) {
        m_queryString = query;
        m_arrayParms = parms;
        m_arrayLikeParms = likeparms;
        m_isAction = isAction;
        m_isParms = isParm;
        queryNames.add(name);
    }
    
    String GetQueryString() {
        return m_queryString;
    }
    
    int GetParmAmount() {
        if (m_arrayParms == null)
            return 0;
        else
            return m_arrayParms.length;
    }

    static String getQueryNames(int queryNum) {
        return queryNames.get(queryNum);
    }

    static int getQueryNumber(String queryDesc) {
        return queryNames.indexOf(queryDesc);
    }

    String GetParamText(int index) {
        return m_arrayParms[index];
    }
    
    boolean GetLikeParam(int index) {
        return m_arrayLikeParms[index];
    }
    
    boolean [] GetAllLikeParams() {
        return m_arrayLikeParms;
    }
    
    boolean IsQueryAction() {
        return m_isAction;
    }
    
    boolean IsQueryParm() {
        return m_isParms;
    }
     
    private String m_queryString;
    private String [] m_arrayParms;
    private static ArrayList<String> queryNames = new ArrayList<>();
    private boolean m_isAction;
    private boolean m_isParms;   
    private boolean [] m_arrayLikeParms;
}
