package components;
import java.util.Random;
import java.util.ArrayList;

public class RandomSystem {
    //making a random section for an array list
    Random rand = new Random();

    public String randomArrayListIndex(ArrayList<String> list){
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}
