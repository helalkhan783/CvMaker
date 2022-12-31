package cvmaker.com.utils;

import java.util.ArrayList;
import java.util.List;

import cvmaker.com.R;

public class BholaServiceUtil {
    public static final String hospital = "হাসপাতাল";
    public static final String ambulance = "অ্যাম্বুলেন্স";
    public static final String fireService = "ফায়ার সার্ভিস";
    public static final String police = "পুলিশ";
    public static final String biddyut = "জরুরী বিদ্যুৎ";
    public static final String rentCar = "রেন্ট-এ-কার";


    public static List<String> bholaSadarServiceName() {
        List<String> list = new ArrayList<>();
        list.add(hospital);
        list.add(ambulance);
        list.add(fireService);
        list.add(police);
        list.add(biddyut);
        list.add(rentCar);


        return list;
    }


    public static List<Integer> serviceImage() {
        List<Integer> image = new ArrayList<>();
        image.add(R.drawable.hospital);
        image.add(R.drawable.ambulance);
        image.add(R.drawable.fireservice);
        image.add(R.drawable.policeman);
        image.add(R.drawable.current);
        image.add(R.drawable.rent_car);
 


        return image;
    }


}
