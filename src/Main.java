import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Zebra> zebras = new ArrayList<>();
        zebras.add(new Zebra(33));
        zebras.add(new Zebra(12));
        zebras.add(new Zebra(789));

        for (int i = 0; i<900; i++){
            zebras.add(new Zebra(i));
        }

        System.out.println(recursiveMostStripes(zebras).numberOfStripes);

    }
    public static Zebra getZebraWithMostStripes(List<Zebra> zebras){
        Zebra mostStripes = null;
        for (Zebra zebra : zebras) {
            if (mostStripes == null
                    || mostStripes.getNumberOfStripes() < zebra.getNumberOfStripes()) {
                mostStripes = zebra;
            }
        }
        return mostStripes;
    }

    public static Zebra recursiveMostStripes(List<Zebra> zebras){
        if (zebras.size() == 1) {
            return zebras.get(0);
        }
        Zebra zebra = zebras.get(0);
        Zebra mostStripes =
                recursiveMostStripes(zebras.subList(1, zebras.size()));
        if (zebra.getNumberOfStripes() > mostStripes.getNumberOfStripes()){
            return zebra;
        }
        return mostStripes;
    }
}
