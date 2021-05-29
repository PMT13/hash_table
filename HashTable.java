//Written by Peng Mong Thao (thao0577)
import java.io.FileNotFoundException;

public class HashTable <T extends Comparable<T>>{
    NGen<T>[] arr;

    public static void main(String args[]) throws FileNotFoundException {
        HashTable myTable = new HashTable();
        myTable.add("python");
        myTable.add("java");
        myTable.add("c");
        myTable.add("c++");
        myTable.add("ocaml");
        myTable.display();
    }
    public HashTable(){
        arr = new NGen[16];
    }
    public HashTable(int size){
        arr = new NGen[size];
    }
    public void add(T item){
        hash(item);
    }
    public void display(){
        int maxChain = 0;
        int minChain = 0;
        int count = 0; int oneCount = 0; int twoCount = 0; int threeCount = 0;           // variables to keep track of 'n' length chains
        int fourCount = 0; int fiveCount = 0; int sixCount = 0; int sevenCount = 0;
        for(int i = 0; i < arr.length; i++){
            int chainCount = 0;
            if(arr[i] != null) {
                System.out.print(i + ": ");
                NGen head = arr[i];
                while(head != null){
                    System.out.print(head.getData() + " | ");
                    head = head.getNext();
                    chainCount++;
                }
                System.out.print("\n"+"     # of hashes at index "+i+": "+chainCount+"\n\n");
            }else{
                System.out.print(i + ": " + "\n"+"     # of hashes at index "+i+": "+chainCount+"\n\n");
            }
            if(i == 0){                             // this if/else statement helps to find the max and minimum length chains in the hash table
                maxChain = chainCount;
                minChain = chainCount;
            }else {
                if (chainCount > maxChain) {
                    maxChain = chainCount;
                }
                if (chainCount < minChain) {
                    minChain = chainCount;
                }
            }
            if(chainCount == 0){                    // All of these if statements below are just to keep track of how many chains of length 'n'
                count++;                            // there are in the hash table
            }
            if(chainCount == 1){
                oneCount++;
            }
            if(chainCount == 2){
                twoCount++;
            }
            if(chainCount == 3){
                threeCount++;
            }
            if(chainCount == 4){
                fourCount++;
            }
            if(chainCount == 5){
                fiveCount++;
            }
            if(chainCount == 6){
                sixCount++;
            }
            if(chainCount == 7){
                sevenCount++;
            }
        }
        System.out.println("Longest Chain Length: "+maxChain+"\nShortest Chain Length: "+minChain+"\n");
        System.out.println("# of 0-chain indexes: "+count);
        System.out.println("# of 1-chain indexes: "+oneCount);
        System.out.println("# of 2-chain indexes: "+twoCount);
        System.out.println("# of 3-chain indexes: "+threeCount);
        System.out.println("# of 4-chain indexes: "+fourCount);
        System.out.println("# of 5-chain indexes: "+fiveCount);
        System.out.println("# of 6-chain indexes: "+sixCount);
        System.out.println("# of 7-chain indexes: "+sevenCount);
    }

    public void hashFile(String file) throws FileNotFoundException {         // this method calls the hash() function on every unique word in a file
        TextScan myFile = new TextScan(file);                                // which adds those words to the hash table
        String[] wordArray = myFile.fileArray();
        for(int i = 0; i < wordArray.length; i++){
            hash((T) wordArray[i]);
        }
    }

    private int hash(T key){
        String stringKey = (String) key;
        int hashIdx = 0;
        int num = 0;
        for(int i = 0; i < stringKey.length();i++){      // essentially what my hash function does is that, for each character in the string, it multiplies its numerical
            num = 13 + stringKey.charAt(i);              // value by 'num' who's value is calculated by adding 13 to the whatever character (numerical value) of the string
            hashIdx += stringKey.charAt(i) * num;        // that the for loop is on
        }                                                                               // To finish things off, the middle character of the string is then added to hashIdx and then
        hashIdx = (hashIdx + stringKey.charAt(stringKey.length()/2)) % arr.length;      //  the whole thing is modulo by the length of the array
        if(arr[hashIdx] != null){                        // this next set of code will check if the key is already in the hash table and if it is,
            NGen head = arr[hashIdx];                    // it will not be added and -1 will be returned
            while(head != null){
                if(head.getData().equals(key)){
                    System.out.println("'"+key+"'"+" is already in hash table\n");
                    return -1;
                }
                head = head.getNext();
            }
        }
        arr[hashIdx] = new NGen<>(key,arr[hashIdx]);      // adding the new key to the hash table
        return hashIdx;
    }

    public void hashKeywordsFile(String file) throws FileNotFoundException {    // this method is for hashing the keywords file where we know the size of the data
        TextScan myFile = new TextScan(file);                                   // It's the same thing as the hashFile() except it just calls keywordHash() instead of hash()
        String[] wordArray = myFile.fileArray();
        for(int i = 0; i < wordArray.length; i++){
            keywordHash((T) wordArray[i]);
        }
    }

    private int keywordHash(T key){
        String stringKey = (String) key;
        int hashIdx = 0;
        for(int i = 0; i < stringKey.length(); i++){      // sums up the (character value * the location of the character in the string starting from 1)
            hashIdx += stringKey.charAt(i) * (i + 1);
        }
        hashIdx = hashIdx % arr.length;
        if(stringKey.charAt(0) == 99){                    // if the first character is a 'c', -8 from the index
            hashIdx -= 8;
        }
        if(arr[hashIdx] != null){                         // this next set of code will check if the key is already in the hash table and if it is,
            NGen head = arr[hashIdx];                     // it will not be added and -1 will be returned
            while(head != null){
                if(head.getData().equals(key)){
                    System.out.println("'"+key+"'"+" is already in hash table\n");
                    return -1;
                }
                head = head.getNext();
            }
        }
        arr[hashIdx] = new NGen<>(key,arr[hashIdx]);
        return hashIdx;
    }
}
