package stepdefinitions.apisteps;

import java.util.HashMap;
import java.util.Map;

public class TestData {
    public static Map<String, String> getProposalData() {
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("subject", "Alina_Proposal_Test_TC6");
        dataMap.put("rel_type", "customer");
        dataMap.put("rel_id", "3");
        dataMap.put("proposal_to", "Customer05 techtorial");
        dataMap.put("email", "customer05-techtorial@techtorialperfex.com");
        dataMap.put("assigned", "6");
        dataMap.put("project_id", "1");
        dataMap.put("date", "2024-03-10");


        dataMap.put("newitems[0][description]", "item 1 Name");
        dataMap.put("newitems[0][long_description]", "item 1 description");
        dataMap.put("newitems[0][qty]", "2");
        dataMap.put("newitems[0][rate]", "10.00");
        dataMap.put("newitems[0][order]", "1");
        dataMap.put("newitems[0][unit]", "1");

        dataMap.put("newitems[1][description]", "item 2 Name");
        dataMap.put("newitems[1][long_description]", "item 2 description");
        dataMap.put("newitems[1][qty]", "4");
        dataMap.put("newitems[1][rate]", "100.00");
        dataMap.put("newitems[1][order]", "4");
        dataMap.put("newitems[1][unit]", "4");

        dataMap.put("subtotal", "420.00");
        dataMap.put("total", "441.00");
        dataMap.put("currency", "1");
        dataMap.put("status", "6");

        return dataMap;


    }
}
