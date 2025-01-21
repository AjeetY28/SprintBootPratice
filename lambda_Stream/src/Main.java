import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //older ways
//        Walkable obj=new WalkFast();
//        obj.walk(4);

        //using Anonymous Alss
//        Walkable obj= new Walkable() {
//            @Override
//            public int walk(int steps) {
//                return 0;
//            }
//        };

        //using lambda not using WalkFast class in this method not need to define data
        //typ on (steps ) because compiler known and if many argument the only right line by lie not write data typ

//        Walkable obj = (steps)->{
//            System.out.println("Walk fast "+steps+" steps.");
//            return 2*steps;
//        };
//        obj.walk(4);
//
//        //2nd ways
//        Walkable obj2=(steps)->2*steps;
//    }

        //Stream
        //if stream once run then we don't access this stream
        //use to save memory wested
        List<String> fruits=List.of("Apple","Banana","Orange","Kiwi");
//        Stream<String> stream=fruits.stream();
//        stream
//                .filter(fruit->fruit.length()<5)//it will print only those length is less 5 //Kiwi=4 print 4
//                .sorted()
////                .map(fruit->fruit.length())//converted to string length only print
//                .forEach((fruit)->{
//            System.out.println(fruit);
//        });

       List<Integer> fruitList = fruits.stream()
                .map(fruit->fruit.length())
                .collect(Collectors.toList());//return in list we can use also set ,map
        System.out.println(fruitList);

        Map<String,Integer> fruitMap=fruits.stream()
                .collect(Collectors.toMap(
                        fruit->fruit,
                        fruit->fruit.length()
                ));
        System.out.println(fruitMap);
// rerun then we get exception means we can't use this stream again
//        stream.forEach((fruit)->{
//            System.out.println(fruit);
//        });



    }
}

interface Walkable
{
    int walk(int steps);
}

//class WalkFast implements Walkable
//{
//    @Override
//    public int walk(int steps) {
//        System.out.println("Walk fast "+steps+" steps.");
//        return 0;
//    }
//}