package cvmaker.com.all_list;

import java.util.ArrayList;
import java.util.List;

import cvmaker.com.model.CurrentModel;
import cvmaker.com.model.PoliceModel;

public class CurrentList {
    public static List<CurrentModel> bholaCurrent() {
        List<CurrentModel> currentModels = new ArrayList<>();
        currentModels.clear();
        currentModels.add(new CurrentModel("ভোলা সদর দপ্তর অভিযোগ কেন্দ্র", "01769-400886", ""));
        currentModels.add(new CurrentModel("পরাণগঞ্জ সাব-জোনাল বিদ্যুৎ অফিস", "01769-400885", ""));
        return currentModels;
    }

    public static List<CurrentModel> borhunuddinCurrent() {
        List<CurrentModel> currentModels = new ArrayList<>();
        currentModels.clear();
        currentModels.add(new CurrentModel("বোরহানউদ্দিন সাব-জোনাল বিদ্যুৎ অফিস", "01769-400889", " 01700-709997"));
        return currentModels;
    }

    public static List<CurrentModel> monpuraCurrent() {
//        List<CurrentModel> currentModels = new ArrayList<>();
//        currentModels.clear();
//        currentModels.add(new CurrentModel("মনপুরা সদর থানা", "01320-152334", ""));
//        currentModels.add(new CurrentModel("ভোলা জেলা প্রশাসক", "01715-211899", ""));
        return null;
    }

    public static List<CurrentModel> lalmohonCurrent() {
        List<CurrentModel> currentModels = new ArrayList<>();
        currentModels.clear();
        currentModels.add(new CurrentModel("লালমোহন জোনাল বিদ্যুৎ অফিস", "01769-400888", ""));
        currentModels.add(new CurrentModel("কর্তারহাট ইনডোর উপকেন্দ্র", "01769-407821", ""));
        currentModels.add(new CurrentModel("রামচাঁদ অভিযোগ কেন্দ্র ", "01769-407820", ""));
        return currentModels;
    }

    public static List<CurrentModel> tajumuddonCurrent() {
       /* List<CurrentModel> currentModels = new ArrayList<>();
        currentModels.clear();
        currentModels.add(new CurrentModel("তজুমদ্দিন সদর থানা", "01320-152238", ""));
        currentModels.add(new CurrentModel("ভোলা জেলা প্রশাসক", "01715-211899", ""));
        */
        return null;
    }

    public static List<CurrentModel> daulatkhaCurrent() {
       /* List<CurrentModel> currentModels = new ArrayList<>();
        currentModels.clear();
        currentModels.add(new CurrentModel("দৌলতখান সদর থানা", "01320-152212", ""));
        currentModels.add(new CurrentModel("ভোলা জেলা প্রশাসক", "01715-211899", ""));
       */ return null;
    }

    public static List<CurrentModel> charfashionCurrent() {
        List<CurrentModel> currentModels = new ArrayList<>();
        currentModels.clear();
        currentModels.add(new CurrentModel("চরফ্যাশন বিদ্যুৎ অফিস", "01769-400891", ""));
        currentModels.add(new CurrentModel("দুলারহাট অভিযোগ কেন্দ্র", "01769-407854", ""));
        currentModels.add(new CurrentModel("শশীভুষন অভিযোগ কেন্দ্র", "01769-402266", ""));
        currentModels.add(new CurrentModel("চর মুজিব অভিযোগ কেন্দ্র", "01769-407924", ""));
        return currentModels;
    }

}
