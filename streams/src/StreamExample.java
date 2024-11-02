import java.util.*;
import java.util.stream.*;
public class StreamExample {

    public static void main(String[] args){
        //to filter out even numbers from array
        int[] stream = new int[]{1,2,3,4,5};

        List<Integer> evenList = Arrays.stream(stream).boxed().filter(a -> a%2 == 0).collect(Collectors.toList());
        System.out.println(evenList);
        int sum = Arrays.stream(stream).filter(a->a%2 ==0 ).sum();
        int sumByReduce = Arrays.stream(stream).filter(a->a%2 == 0).reduce(0, (a,b) -> a+b);
        //sum of positive numbers
        System.out.println("normal sum:: " +sum+ " sum By Reduce :: "+ sumByReduce);
        //find factorial
        List<Integer> ListOfInteger = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        int multiplyFactorialOf10 = ListOfInteger.stream().reduce(1, (a,b) -> a*b);
        System.out.println(multiplyFactorialOf10);
        //find factorial only number is given
        int n = 5;
        int factorialOf5 = IntStream.rangeClosed(1,5).reduce(1,(a,b)-> a*b);
        System.out.println(factorialOf5);


        List<String> wordList = Arrays.asList("coconut","coconut","aa","aa","bb","aaa","a","a","a");

        //to convert each word into caps


        //to count occurence of each word in a list
        Map<String,Integer> wordOccurence = wordList.stream()
                .collect(Collectors.toMap(
                        word -> word,
                        word->1,
                        Integer::sum));
        System.out.println(wordOccurence);

        //sort the occurence of words by count
        Map<String, Integer> sortedByCount = wordOccurence.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, // In case of a tie, keep the first entry
                        LinkedHashMap::new // Use LinkedHashMap to maintain insertion order
                ));
        System.out.println(sortedByCount);

    }
}
