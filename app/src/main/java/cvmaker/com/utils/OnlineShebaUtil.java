package cvmaker.com.utils;

import java.util.ArrayList;
import java.util.List;

import cvmaker.com.R;

public class OnlineShebaUtil {
    public static final String bholaSadar = "ভোলা সদর উপজেলা";
    public static final String bordunuddin = "বোরহানউদ্দিন উপজেলা";
    public static final String charfassion = "চরফ্যাশন উপজেলা";
    public static final String monpura = "মনপুরা উপজেলা";
    public static final String lalmohon = "লালমহন উপজেলা";
    public static final String tazumoddin = "তজুমদ্দিন উপজেলা";
    public static final String daulatkha = "দৌলতখান উপজেলা";


    public static List<String> getUpazillaName() {
        List<String> list = new ArrayList<>();
        list.add(bholaSadar);
        list.add(bordunuddin);
        list.add(charfassion);
        list.add(lalmohon);
        list.add(tazumoddin);
        list.add(daulatkha);
        list.add(monpura);



        return list;
    }


    public static List<Integer> getUpazillaImage() {
        List<Integer> image = new ArrayList<>();
        image.add(R.drawable.icon);
        image.add(R.drawable.icon);
        image.add(R.drawable.icon);
        image.add(R.drawable.icon);
        image.add(R.drawable.icon);
        image.add(R.drawable.icon);
        image.add(R.drawable.icon);


         return image;
    }


}
