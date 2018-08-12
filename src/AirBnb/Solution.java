package AirBnb;

import java.util.*;

/**
 * Created by Green on 2018/8/12.
 */
public class Solution {
    // Complete the paginate function below.
    static List<String> paginate(int num, List<String> results) {
        List<String> output = new ArrayList<String>();
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> remove = new ArrayList<Integer>();

        while(results.size() > 0){
            int count=0;
            for(int i=0; count < num && i<results.size(); i++){
                String record = results.get(i);
                int hostId = Integer.parseInt(results.get(i).split(",")[0]);
                if(!set.contains(hostId)){
                    set.add(hostId);
                    output.add(record);
                    remove.add(i);
                    count++;
                }

            }
            if(count < 5){
                int index=0;
                while(count < num && remove.size() < results.size()){
                    if(remove.lastIndexOf(index) == -1){
                        output.add(results.get(index));
                        remove.add(index);
                        count++;
                    }
                    index++;
                }
                Collections.sort(remove);
            }
            if(count == num){
                output.add("");
            }
            for(int i=remove.size()-1; i>=0; i--){
                results.remove((int) remove.get(i));
            }
            remove.clear();
            set.clear();
        }

        return output;
    }

    public static void main(String[] args) {
        String[] input = {
                "1,28,300.1,Melbourne",
                        "4,5,209.1,Melbourne",
                        "20,7,208.1,Melbourne",
                        "23,8,207.1,Melbourne",
                        "16,10,206.1,Melbourne",
                        "1,16,205.1,Melbourne",
                        "6,29,204.1,Melbourne",
                        "7,20,203.1,Melbourne",
                        "8,21,202.1,Melbourne",
                        "2,18,201.1,Melbourne",
                        "4,30,200.1,Melbourne"};
        List<String> results = new ArrayList<>();
        for(String a : input){
            results.add(a);
        }
        int num = 5;
        List<String> output = paginate(3, results);
        for(String a: output){
            System.out.println(a);
        }
    }

}
