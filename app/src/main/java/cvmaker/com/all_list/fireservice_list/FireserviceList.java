package cvmaker.com.all_list.fireservice_list;

import java.util.ArrayList;
import java.util.List;

import cvmaker.com.model.FireServiceModel;
import cvmaker.com.model.HospitalMode;

public class FireserviceList {

    public static List<FireServiceModel> fireserviceList() {
        List<FireServiceModel> fireServiceModels = new ArrayList<>();
        fireServiceModels.add(new FireServiceModel("ভোলা ফায়ার সার্ভিস জরুরি সেবা", "01714-501896", ""));
        fireServiceModels.add(new FireServiceModel("বোরহানউদ্দিন ফায়ার সার্ভিস জরুরি সেবা", "01709-079595", ""));
        fireServiceModels.add(new FireServiceModel("দৌলতখান ফায়ার সার্ভিস জরুরি সেবা", "01797-005480", ""));
        fireServiceModels.add(new FireServiceModel("লালমোহন ফায়ার সার্ভিস জরুরি সেবা", "01708-613333", ""));
        fireServiceModels.add(new FireServiceModel("চরফ্যাশন ফায়ার সার্ভিস জরুরি সেবা", "01715-917117", ""));
        fireServiceModels.add(new FireServiceModel("তজুমদ্দিন ফায়ার সার্ভিস জরুরি সেবা", "01720-213233", ""));

        fireServiceModels.add(new FireServiceModel("মনপুরা ফায়ার সার্ভিস জরুরি সেবা", "01990-494689", ""));
        return fireServiceModels;
    }

}
